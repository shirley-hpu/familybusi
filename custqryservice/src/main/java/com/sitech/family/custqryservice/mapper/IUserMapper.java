package com.sitech.family.custqryservice.mapper;

import com.sitech.family.custqryservice.dto.mapperdto.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description 用户信息
 * @date 2018/12/19 17:48
 */
@Repository
public interface IUserMapper {

    /**
     * 查询用户信息
     * @param idNo
     * @return User
     */
    User query(Long idNo);

    /**
     * 查询用户信息
     * @param map
     * @return List<User>
     */
    List<User> qryUserList(@Param("params") Map map);

    /**
     * 手机号码查询已订购附加信息
     * @param phoneNo
     * @return list
     */
    List<User> qryOrderFeeByPhoneNo(String phoneNo,String goodsMainFlag);
}
