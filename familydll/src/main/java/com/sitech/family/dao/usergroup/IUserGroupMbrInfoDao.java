package com.sitech.family.dao.usergroup;

import com.sitech.family.dto.UpdateOprInfo;
import com.sitech.family.dto.ReturnDto;
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
public interface IUserGroupMbrInfoDao {

    /**
     * 新增
     *
     * @param userGroupMbrInfo
     * @return
     */
    ReturnDto create(UserGroupMbrInfo userGroupMbrInfo);

    /**
     * 修改
     *
     * @param userGroupMbrInfo
     * @return
     */
    ReturnDto modify(UserGroupMbrInfo userGroupMbrInfo);

    /**
     * 删除
     *
     * @param userGroupMbrInfo
     * @return
     */
    ReturnDto drop(UserGroupMbrInfo userGroupMbrInfo);

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
    List<UserGroupMbrInfo> qryUserGroupMbrInfoList(Map map);

    /**
     * 根据idNo更新状态
     *
     * @param idNo
     * @return
     */
    ReturnDto updateFinishState(UpdateOprInfo updateOprInfo, String idNo);

    /**
     * 查询短流程订单
     * @param map
     * @return
     */
    List<UserGroupMbrInfo> qryShortProcessList(Map map);
}
