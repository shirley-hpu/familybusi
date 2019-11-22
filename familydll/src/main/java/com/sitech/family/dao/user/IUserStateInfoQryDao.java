package com.sitech.family.dao.user;

import com.sitech.family.dto.user.UserStateInfo;

import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description
 * @date 2019/1/3 10:23
 */
public interface IUserStateInfoQryDao {

    /**
     * 查询家庭用户状态变化
     *
     * @param stateChangeNo
     * @return userStateInfo
     */
    UserStateInfo query(Long stateChangeNo);

    /**
     * @param map
     * @return list
     */
    List<UserStateInfo> qryUserStateInfoList(Map map);
}
