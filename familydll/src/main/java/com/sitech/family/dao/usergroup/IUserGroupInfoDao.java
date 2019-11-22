package com.sitech.family.dao.usergroup;


import com.sitech.family.dto.UpdateOprInfo;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.usergroup.UserGroupInfo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description 家庭用户
 * @date 2018/12/12 18:25
 */
public interface IUserGroupInfoDao {

    /**
     * 新增家庭用户群用户
     *
     * @param userGroup
     */
    ReturnDto create(UserGroupInfo userGroup);

    /**
     * 修改家庭用户群用户
     *
     * @param userGroup
     * @return userGroup
     */
    ReturnDto modify(UserGroupInfo userGroup);

    /**
     * 删除家庭用户群用户
     *
     * @param userGroup
     */
    ReturnDto drop(UserGroupInfo userGroup);

    /**
     * 查询家庭用户群用户
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
     * @param idNo
     * @return
     */
    ReturnDto updateFinishState(UpdateOprInfo updateOprInfo, Long idNo);
}
