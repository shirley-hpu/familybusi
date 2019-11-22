package com.sitech.family.dao.user;


import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.user.UserStateInfo;

import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description 家庭用户状态变化实体
 * @date 2018/12/13 18:07
 */
public interface IUserStateInfoDao {

    /**
     * 新增家庭用户状态变化
     * @param userStateInfo
     */
    ReturnDto create(UserStateInfo userStateInfo);

    /**
     * 修改家庭用户状态变化
     * @param userStateInfo
     */
    ReturnDto modify(UserStateInfo userStateInfo);

    /**
     * 删除家庭用户状态变化
     * @param userStateInfo
     */
    ReturnDto drop(UserStateInfo userStateInfo);

    /**
     * 查询家庭用户状态变化
     * @param stateChangeNo
     * @return userStateInfo
     */
    UserStateInfo query(Long stateChangeNo);

    /**
     *
     * @param map
     * @return list
     */
    List<UserStateInfo> qryUserStateInfoList(Map map);
}
