package com.sitech.family.custqryservice.atombusi;

import com.sitech.family.custqryservice.dto.outdto.FamilyGroupMbr;
import com.sitech.family.dto.usergroup.UserGroupMbrInfo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 家庭群成员关系实体
 *
 * @author shirley
 * @date created in 2018/12/17
 */
public interface IFamilyUserGroupMbrInfo {

    /**
     * 查询
     *
     * @param memberId
     * @return
     */
    UserGroupMbrInfo query(BigDecimal memberId);

    /**
     * @param map
     * @return
     */
    List<FamilyGroupMbr> qryUserGroupMbrInfoList(Map map);

}
