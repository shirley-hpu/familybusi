package com.sitech.family.dao.usergroup;

import com.sitech.family.dto.usergroup.UserMbrAttrMidInfo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description
 * @date 2019/4/17 21:37
 */
public interface IUserMbrAttrMidInfoQryDao {

    /**
     * 查询
     *
     * @param insValue,attrId,effDate,attrNo
     * @return
     */
    UserMbrAttrMidInfo query(BigDecimal insValue, String attrId, Date effDate, String attrNo);

    /**
     * 查询
     *
     * @param map
     * @return
     */
    List<UserMbrAttrMidInfo> qryUserMbrAttrMidInfoList(Map map);
}
