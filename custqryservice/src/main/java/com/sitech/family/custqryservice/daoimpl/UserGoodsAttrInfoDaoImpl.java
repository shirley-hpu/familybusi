package com.sitech.family.custqryservice.daoimpl;

import com.sitech.family.custqryservice.daoimpl.user.IUserGoodsAttr;
import com.sitech.family.custqryservice.dto.mapperdto.UserGoodsAttr;
import com.sitech.family.dao.usergoods.IUserGoodsAttrInfoQryDao;
import com.sitech.family.dto.usergoods.UserGoodsAttrInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @author wusm
 * @description
 * @date 2018/12/17 14:30
 */
@Component
public class UserGoodsAttrInfoDaoImpl implements IUserGoodsAttrInfoQryDao {

    @Autowired
    private IUserGoodsAttr iUserGoodsAttr;

    /**
     * 查询家庭订购属性信息
     *
     * @return userGoodsAttrInfo
     */
    @Override
    public UserGoodsAttrInfo query(BigDecimal svcinsId, String attrId, String attrNo, Date effDate) {
        return null;
    }

    @Override
    public List<UserGoodsAttrInfo> qryUserGoodsAttrInfoList(Map map) {
        if (StringUtil.isEmptyOrNull(map)) {
            throw new BusiException("-9999", "处理失败,参数对象不存在或为空!");
        }

        List<UserGoodsAttrInfo> userGoodsAttrInfoList = new ArrayList<>();
        try {
            List<UserGoodsAttr> userGoodsAttrList = iUserGoodsAttr.qryUserGoodsAttrList(map);

            for (UserGoodsAttr userGoodsAttr: userGoodsAttrList) {
                UserGoodsAttrInfo userGoodsAttrInfo = new UserGoodsAttrInfo();
                userGoodsAttrInfo.setAttrId(userGoodsAttr.getAttrId());
                userGoodsAttrInfo.setAttrNo(userGoodsAttr.getAttrNo());
                userGoodsAttrInfo.setAttrValue(userGoodsAttr.getAttrValue());
                userGoodsAttrInfo.setEffDate(userGoodsAttr.getEffDate());
                userGoodsAttrInfo.setExpDate(userGoodsAttr.getExpDate());
                userGoodsAttrInfo.setGrpNo(userGoodsAttr.getGrpNo());
                userGoodsAttrInfo.setIdNo(userGoodsAttr.getIdNo());
                userGoodsAttrInfo.setInsType("1");
                userGoodsAttrInfo.setInsValue(String.valueOf(userGoodsAttr.getGoodsinsId()));
                userGoodsAttrInfo.setLoginAccept(userGoodsAttr.getLoginAccept());
                userGoodsAttrInfo.setLoginNo(userGoodsAttr.getLoginNo());
                userGoodsAttrInfo.setOpCode(userGoodsAttr.getOpCode());
                userGoodsAttrInfo.setOpNote("1");
                userGoodsAttrInfo.setOpTime(userGoodsAttr.getOpTime());
                userGoodsAttrInfo.setOupAccept("1");
                userGoodsAttrInfo.setState(userGoodsAttr.getFinishFlag());
                userGoodsAttrInfo.setStateDate(userGoodsAttr.getOpTime());
                userGoodsAttrInfo.setSystemNote("1");

                userGoodsAttrInfoList.add(userGoodsAttrInfo);
            }

            return userGoodsAttrInfoList;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
