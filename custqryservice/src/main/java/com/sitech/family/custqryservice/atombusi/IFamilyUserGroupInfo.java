package com.sitech.family.custqryservice.atombusi;

import com.sitech.family.custqryservice.dto.mapperdto.UserGroup;
import com.sitech.family.dto.usergoods.UserGoodsInfo;
import com.sitech.family.dto.usergroup.UserGroupInfo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description 家庭群成员信息
 * @date 2018/12/14 16:08
 */
public interface IFamilyUserGroupInfo {

    /**
     * 查询家庭群成员信息
     * @param groupId
     * @return userGroup
     */
    UserGroupInfo query(BigDecimal groupId);

    /**
     * @param map
     * @return
     */
    List<UserGroupInfo> qryUserGroupInfoList(Map map);

    UserGroupInfo qryUserGroupInfo(Map map);
}
