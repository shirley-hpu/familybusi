package com.sitech.family.dao.user;

import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.user.UserAddInfo;

import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description 家庭用户附加信息
 * @date 2018/12/14 17:51
 */
public interface IUserAddInfoDao {

    /**
     * 新增家庭用户附加信息
     *
     * @param userAddInfo
     */
    ReturnDto create(UserAddInfo userAddInfo);

    /**
     * 修改家庭用户附加信息
     *
     * @param userAddInfo
     */
    ReturnDto modify(UserAddInfo userAddInfo);

    /**
     * 删除家庭用户附加信息
     *
     * @param userAddInfo
     */
    ReturnDto drop(UserAddInfo userAddInfo);

    /**
     * 查询家庭用户附加信息
     */
    UserAddInfo query(Long idNo, String fieldCode);

    /**
     * @param map
     * @return list
     */
    List<UserAddInfo> qryUserAddInfoList(Map map);
}
