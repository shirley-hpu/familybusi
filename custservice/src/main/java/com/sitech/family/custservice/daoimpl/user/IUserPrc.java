package com.sitech.family.custservice.daoimpl.user;

import com.sitech.family.custservice.dto.mapperdto.UserPrc;
import com.sitech.family.dto.ReturnDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description 用户订购产品资费实例
 * @date 2018/12/10 10:20
 */
public interface IUserPrc {

    /**
     * 创建用户订购产品资费实例信息
     * @param userPrc
     * @return ReturnDto
     */
    ReturnDto create(UserPrc userPrc) ;

    /**
     * 更新用户订购产品资费实例信息
     * @param userPrc
     * @return ReturnDto
     */
    ReturnDto modify(UserPrc userPrc);

    /**
     * 删除用户订购产品资费实例信息
     * @param userPrc
     * @return ReturnDto
     */
    ReturnDto drop(UserPrc userPrc);

    /**
     * 查询用户订购产品资费实例信息
     * @param prodprcinsId
     * @return List<UserPrc>
     */
    UserPrc query(BigDecimal prodprcinsId);

    /**
     * 查询用户订购产品资费实例历史信息
     * @param map
     * @return List<UserPrc>
     */
    List<UserPrc> qryUserPrcInfoList(Map map);

    /**
     * 查询用户订购产品资费实例历史信息
     * @param map
     * @return List<UserPrc>
     */
    List<UserPrc> qryUserPrcInfoHisList(Map map);

    /**
     * 根据idNo更新状态
     * @param userPrc
     * @return
     */
    ReturnDto updateFinishState(UserPrc userPrc);
}
