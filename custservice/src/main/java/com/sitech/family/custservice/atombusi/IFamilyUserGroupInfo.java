package com.sitech.family.custservice.atombusi;

import com.sitech.family.dto.UpdateOprInfo;
import com.sitech.family.dto.ReturnDto;
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
     * 新增家庭群成员信息
     *
     * @param userGroup
     * @return ReturnDto
     */
    ReturnDto create(UserGroupInfo userGroup);

    /**
     * 修改家庭群成员信息
     *
     * @param userGroup
     * @return ReturnDto
     */
    ReturnDto modify(UserGroupInfo userGroup);

    /**
     * 删除家庭群成员信息
     *
     * @param userGroup
     * @return ReturnDto
     */
    ReturnDto drop(UserGroupInfo userGroup);

    /**
     * 查询家庭群成员信息
     *
     * @param groupId
     * @return userGroup
     */
    UserGroupInfo query(BigDecimal groupId);

    /**
     * @param map
     * @return
     */
    List<UserGroupInfo> qryUserGroupInfoList(Map map);

    /**
     * 根据idNo更新状态
     *
     * @param idNo
     * @return
     */
    ReturnDto updateFinishState(UpdateOprInfo updateOprInfo, Long idNo);
}
