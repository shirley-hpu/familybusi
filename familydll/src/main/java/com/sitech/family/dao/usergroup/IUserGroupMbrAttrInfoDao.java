package com.sitech.family.dao.usergroup;

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
public interface IUserGroupMbrAttrInfoDao {


    /**
     * 新增
     *
     * @param userGroupMbrAttrInfo
     * @return
     */
    ReturnDto create(UserGroupMbrAttrInfo userGroupMbrAttrInfo);

    /**
     * 修改
     *
     * @param userGroupMbrAttrInfo
     * @return
     */
    ReturnDto modify(UserGroupMbrAttrInfo userGroupMbrAttrInfo);

    /**
     * 删除
     *
     * @param userGroupMbrAttrInfo
     * @return
     */
    ReturnDto drop(UserGroupMbrAttrInfo userGroupMbrAttrInfo);

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
