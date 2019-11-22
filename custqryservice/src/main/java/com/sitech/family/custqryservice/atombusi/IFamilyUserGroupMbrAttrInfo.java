package com.sitech.family.custqryservice.atombusi;

import com.sitech.family.dto.usergroup.UserGroupMbrAttrInfo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 家庭群成员属性
 *
 * @author shirley
 * @date created in 2018/12/17
 */
public interface IFamilyUserGroupMbrAttrInfo {

    /**
     * 查询
     *
     * @return
     */
    UserGroupMbrAttrInfo query(BigDecimal memberId, String attrId, String attrNo, Date effDate);

    /**
     * @param map
     * @return
     */
    List<UserGroupMbrAttrInfo> qryUserGroupMbrAttrInfoList(Map map);

}
