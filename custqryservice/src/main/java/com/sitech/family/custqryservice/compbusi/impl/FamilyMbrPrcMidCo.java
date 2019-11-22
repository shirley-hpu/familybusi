package com.sitech.family.custqryservice.compbusi.impl;

import com.sitech.family.common.constants.InsTypeEnum;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custqryservice.atombusi.IFamilyMbrAttrMidInfo;
import com.sitech.family.custqryservice.atombusi.IFamilyMbrPrcMidInfo;
import com.sitech.family.custqryservice.compbusi.IFamilyMbrPrcMidCo;
import com.sitech.family.custqryservice.dto.outdto.MbrPrcMidInfo;
import com.sitech.family.dto.usergroup.UserMbrAttrMidInfo;
import com.sitech.family.dto.usergroup.UserMbrPrcMidInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 成员订购实例中间表
 *
 * @author shirley
 * @date created in 2019/4/20
 */
@Component
public class FamilyMbrPrcMidCo implements IFamilyMbrPrcMidCo {

    private static Logger logger = LoggerFactory.getLogger(FamilyMbrPrcMidCo.class);

    @Resource
    private IFamilyMbrAttrMidInfo attrMidInfo;

    @Resource
    private IFamilyMbrPrcMidInfo prcMidInfo;


    @Override
    public List<MbrPrcMidInfo> query(Map<String, Object> map) {

        try {
            //成员订购实例
            List<UserMbrPrcMidInfo> mbrPrcMidInfoList = prcMidInfo.qryUserMbrPrcMidInfoList(map);

            List<MbrPrcMidInfo> list = new ArrayList<>();

            for (UserMbrPrcMidInfo prcMidInfo : mbrPrcMidInfoList) {
                MbrPrcMidInfo mbrPrcMidInfo = new MbrPrcMidInfo();
                mbrPrcMidInfo.setMemberId(prcMidInfo.getMemberId());
                mbrPrcMidInfo.setInsType(prcMidInfo.getInsType());
                mbrPrcMidInfo.setInsValue(prcMidInfo.getInsValue());
                mbrPrcMidInfo.setParinsId(prcMidInfo.getParinsId());
                mbrPrcMidInfo.setOtherinsId(prcMidInfo.getOtherinsId());
                mbrPrcMidInfo.setRelopType(prcMidInfo.getRelopType());
                mbrPrcMidInfo.setRelationType(prcMidInfo.getRelationType());
                mbrPrcMidInfo.setRelinsId(prcMidInfo.getRelinsId());
                mbrPrcMidInfo.setMainFlag(prcMidInfo.getMainFlag());
                mbrPrcMidInfo.setGoodsId(prcMidInfo.getGoodsId());
                mbrPrcMidInfo.setPrcId(prcMidInfo.getPrcId());
                mbrPrcMidInfo.setSvcId(prcMidInfo.getSvcId());
                mbrPrcMidInfo.setEffDate(prcMidInfo.getEffDate());
                mbrPrcMidInfo.setExpDate(prcMidInfo.getExpDate());
                mbrPrcMidInfo.setOrderDate(prcMidInfo.getOrderDate());

                //成员订购属性实例
                //根据实例标识值INS_VALUE查询关联属性信息
                Map qryMap = new HashMap();
                qryMap.put("insValue", prcMidInfo.getInsValue());
                List<UserMbrAttrMidInfo> mbrAttrMidInfoList = attrMidInfo.qryUserMbrAttrMidInfoList(qryMap);

                //成员订购实例对应的所有订购属性实例
                //商品订购属性 && 资费订购属性
                List<MbrPrcMidInfo.FamilyMbrPrcAttrMid> mbrPrcAttrMidInfoList = new ArrayList<>();
                for (UserMbrAttrMidInfo mbrAttrMidInfo : mbrAttrMidInfoList) {
                    if (InsTypeEnum.VAL_1.getValue().equals(mbrAttrMidInfo.getInsType()) ||
                            InsTypeEnum.VAL_2.getValue().equals(mbrAttrMidInfo.getInsType())) {
                        MbrPrcMidInfo.FamilyMbrPrcAttrMid prcAttrMid = new MbrPrcMidInfo.FamilyMbrPrcAttrMid();
                        prcAttrMid.setAttrId(mbrAttrMidInfo.getAttrId());
                        prcAttrMid.setAttrNo(mbrAttrMidInfo.getAttrNo());
                        prcAttrMid.setAttrValue(mbrAttrMidInfo.getAttrValue());
                        prcAttrMid.setGrpNo(mbrAttrMidInfo.getGrpNo());
                        prcAttrMid.setEffDate(mbrAttrMidInfo.getEffDate());
                        prcAttrMid.setExpDate(mbrAttrMidInfo.getExpDate());
                        mbrPrcAttrMidInfoList.add(prcAttrMid);
                    }
                }

                //成员订购实例对应的所有订购属性实例
                //服务订购属性
                List<MbrPrcMidInfo.FamilyMbrSvcAttrMid> mbrSvcAttrMidInfoList = new ArrayList<>();
                for (UserMbrAttrMidInfo mbrAttrMidInfo : mbrAttrMidInfoList) {
                    if (InsTypeEnum.VAL_3.getValue().equals(mbrAttrMidInfo.getInsType())) {
                        MbrPrcMidInfo.FamilyMbrSvcAttrMid svcAttrMid = new MbrPrcMidInfo.FamilyMbrSvcAttrMid();
                        svcAttrMid.setAttrId(mbrAttrMidInfo.getAttrId());
                        svcAttrMid.setAttrNo(mbrAttrMidInfo.getAttrNo());
                        svcAttrMid.setAttrValue(mbrAttrMidInfo.getAttrValue());
                        svcAttrMid.setGrpNo(mbrAttrMidInfo.getGrpNo());
                        svcAttrMid.setEffDate(mbrAttrMidInfo.getEffDate());
                        svcAttrMid.setExpDate(mbrAttrMidInfo.getExpDate());
                        mbrSvcAttrMidInfoList.add(svcAttrMid);
                    }
                }

                mbrPrcMidInfo.setMbrPrcAttrMidInfoList(mbrPrcAttrMidInfoList);
                mbrPrcMidInfo.setMbrSvcAttrMidInfoList(mbrSvcAttrMidInfoList);
                list.add(mbrPrcMidInfo);
            }
            return list;

        } catch (Exception e) {
            throw new BusiException("处理失败", e.getMessage());
        }
    }


}
