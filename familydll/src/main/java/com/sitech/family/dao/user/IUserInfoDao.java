package com.sitech.family.dao.user;

import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.UpdateOprInfo;
import com.sitech.family.dto.user.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description
 * @date 2018/12/20 09:45
 */
public interface IUserInfoDao {

    /**
     * 新增家庭用户
     *
     * @param userInfo
     */
    ReturnDto create(UserInfo userInfo);

    /**
     * 修改家庭用户
     *
     * @param userInfo
     */
    ReturnDto modify(UserInfo userInfo);

    /**
     * 删除家庭用户
     *
     * @param userInfo
     */
    ReturnDto drop(UserInfo userInfo);

    /**
     * 查询家庭用户
     *
     * @param idNo
     * @return userInfo
     */
    UserInfo query(Long idNo);

    /**
     * @param map
     * @return
     */
    List<UserInfo> qryUserInfoList(Map map);

    /**
     * 根据idNo更新状态
     * @param idNo
     * @return
     */
    ReturnDto updateFinishState(UpdateOprInfo updateOprInfo, Long idNo);
}
