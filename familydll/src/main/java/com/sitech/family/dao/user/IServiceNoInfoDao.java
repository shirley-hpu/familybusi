package com.sitech.family.dao.user;


import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.UpdateOprInfo;
import com.sitech.family.dto.user.UserServiceNoInfo;

import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description 家庭用户状态变化
 * @date 2018/12/14 17:20
 */
public interface IServiceNoInfoDao {

    /**
     * 新增家庭用户状态
     *
     * @param userServiceNoInfo
     */
    ReturnDto create(UserServiceNoInfo userServiceNoInfo);

    /**
     * 修改家庭用户状态
     *
     * @param userServiceNoInfo
     */
    ReturnDto modify(UserServiceNoInfo userServiceNoInfo);

    /**
     * 删除家庭用户状态
     *
     * @param userServiceNoInfo
     */
    ReturnDto drop(UserServiceNoInfo userServiceNoInfo);

    /**
     * 查询家庭用户状态
     */
    UserServiceNoInfo query(String serviceNo, Long idNo, String serviceType);

    /**
     * @param map
     * @return list
     */
    List<UserServiceNoInfo> qryUserServiceNoInfoList(Map map);

    /**
     * 根据idNo更新状态
     * @param idNo
     * @return
     */
    ReturnDto updateFinishState(UpdateOprInfo updateOprInfo, Long idNo);
}
