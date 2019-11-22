package com.sitech.family.custservice.atombusi;

import com.sitech.family.dto.UpdateOprInfo;
import com.sitech.family.dto.ReturnDto;
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
     * 新增
     *
     * @param userGroupMbrAttrInfoDto
     * @return
     */
    ReturnDto create(UserGroupMbrAttrInfo userGroupMbrAttrInfoDto);

    /**
     * 修改
     *
     * @param userGroupMbrAttrInfoDto
     * @return
     */
    ReturnDto modify(UserGroupMbrAttrInfo userGroupMbrAttrInfoDto);

    /**
     * 删除
     *
     * @param userGroupMbrAttrInfoDto
     * @return
     */
    ReturnDto drop(UserGroupMbrAttrInfo userGroupMbrAttrInfoDto);

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

    /**
     * 根据idNo更新状态
     * @param idNo
     * @return
     */
    ReturnDto updateFinishState(UpdateOprInfo updateOprInfo, String idNo);

}
