package com.sitech.family.custqryservice.atombusi.impl;

import com.sitech.family.custqryservice.atombusi.IFamilyUserGroupMbrInfo;
import com.sitech.family.custqryservice.dto.outdto.FamilyGroupMbr;
import com.sitech.family.custqryservice.dto.outdto.GoodsPrcInfo;
import com.sitech.family.dao.usergroup.IUserGroupMbrInfoQryDao;
import com.sitech.family.dto.usergroup.UserGroupMbrInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 家庭群成员关系实体
 *
 * @author shirley
 * @date created in 2018/12/17
 */
@Component
public class FamilyUserGroupMbrInfo implements IFamilyUserGroupMbrInfo {

    /**
     *
     */
    @Resource(name = "userGroupMbrInfoQryDaoImpl")
    private IUserGroupMbrInfoQryDao userGroupMbrInfoDao;


    @Override
    public UserGroupMbrInfo query(BigDecimal memberId) {
        return userGroupMbrInfoDao.query(memberId);
    }

    @Override
    public List<FamilyGroupMbr> qryUserGroupMbrInfoList(Map map) {
        List<FamilyGroupMbr> list = new ArrayList<>();
        List<UserGroupMbrInfo> mbrList = userGroupMbrInfoDao.qryUserGroupMbrInfoList(map);
        for (UserGroupMbrInfo mbr : mbrList) {
            FamilyGroupMbr familyGroupMbr = new FamilyGroupMbr();
            BeanUtils.copyProperties(mbr, familyGroupMbr);

            //成员是否统付信息
            familyGroupMbr.setIsUnitePay("Y");

            //成员商品订购信息
            List<GoodsPrcInfo> goodsPrcInfoList = new ArrayList<>();
            GoodsPrcInfo goodsPrcInfo = new GoodsPrcInfo();
            goodsPrcInfo.setGoodsId("G00048");
            goodsPrcInfo.setGoodsName("4G飞享");
            goodsPrcInfo.setPrcId("M053100");
            goodsPrcInfo.setPrcName("4G飞享放心卡38元套餐");
            goodsPrcInfo.setGoodsType("0");
            goodsPrcInfoList.add(goodsPrcInfo);//主商品
            GoodsPrcInfo goodsPrcInfoAdd = new GoodsPrcInfo();
            goodsPrcInfoAdd.setGoodsId("G01909");
            goodsPrcInfoAdd.setGoodsName("个人彩铃");
            goodsPrcInfoAdd.setPrcId("M033705");
            goodsPrcInfoAdd.setPrcName("5元彩铃包月");
            goodsPrcInfoAdd.setGoodsType("1");
            goodsPrcInfoList.add(goodsPrcInfoAdd);//附加商品
            familyGroupMbr.setGoodsPrcInfoList(goodsPrcInfoList);

            //成员家庭共享信息
            List<GoodsPrcInfo> goodsPrcShareInfoList = new ArrayList<>();
            GoodsPrcInfo goodsPrcInfoShare = new GoodsPrcInfo();
            goodsPrcInfoShare.setGoodsId("G018888");
            goodsPrcInfoShare.setGoodsName("语音升级包");
            goodsPrcInfoShare.setPrcId("M033909");
            goodsPrcInfoShare.setPrcName("全国语音升级包");
            goodsPrcInfoShare.setGoodsType("1");
            goodsPrcShareInfoList.add(goodsPrcInfoShare);//共享附加商品信息
            familyGroupMbr.setShareInfoList(goodsPrcShareInfoList);

            list.add(familyGroupMbr);
        }
        return list;
    }
}
