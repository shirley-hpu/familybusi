package com.sitech.family.custservice.daoimpl.user;


import com.sitech.family.custservice.dto.mapperdto.UserBrand;
import com.sitech.family.dto.ReturnDto;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IUserBrand {

    /**
     * 创建用户与品牌间的关系
     * @param userBrand
     * @return ReturnDto
     */
    ReturnDto create(UserBrand userBrand);


    /**
     * 更新用户与品牌间的关系
     * @param userBrand
     * @return ReturnDto
     */
    ReturnDto modify(UserBrand userBrand);

    /**
     * 删除用户与品牌间的关系
     * @param userBrand
     * @return ReturnDto
     */
    ReturnDto drop(UserBrand userBrand);

    /**
     * 查询用户与品牌间的关系
     * @param idNo,brandId,effDate
     * @return ReturnDto
     */
    UserBrand query(Long idNo, String brandId, Date effDate);

    /**
     * 查询用户与品牌间的关系
     * @param map
     * @return ReturnDto
     */
    List<UserBrand> qryUserBrandRelList(Map map);

    /**
     * 查询历史用户与品牌间的关系
     * @param map
     * @return ReturnDto
     */
    List<UserBrand> qryUserBrandRelHisList(Map map);
    

}
