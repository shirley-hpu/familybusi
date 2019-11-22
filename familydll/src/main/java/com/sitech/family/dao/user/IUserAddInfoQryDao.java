package com.sitech.family.dao.user;

import com.sitech.family.dto.user.UserAddInfo;

import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description
 * @date 2019/1/3 10:21
 */
public interface IUserAddInfoQryDao {

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
