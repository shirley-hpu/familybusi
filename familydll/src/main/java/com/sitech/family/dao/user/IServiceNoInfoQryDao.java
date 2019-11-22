package com.sitech.family.dao.user;

import com.sitech.family.dto.user.UserServiceNoInfo;

import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description
 * @date 2019/1/3 10:20
 */
public interface IServiceNoInfoQryDao {

    /**
     * 查询家庭用户状态
     */
    UserServiceNoInfo query(String serviceNo, Long idNo, String serviceType);

    /**
     * @param map
     * @return list
     */
    List<UserServiceNoInfo> qryUserServiceNoInfoList(Map map);
}
