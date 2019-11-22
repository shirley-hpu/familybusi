package com.sitech.family.dao.user;

import com.sitech.family.dto.user.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description
 * @date 2019/1/3 10:12
 */
public interface IUserInfoQryDao {

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
     * 手机号码查询已订购附加信息
     * @param map
     * @return list
     */
    List qryOrderFeeByPhoneNo(Map map);
}
