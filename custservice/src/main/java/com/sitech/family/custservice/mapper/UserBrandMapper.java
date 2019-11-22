package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.dto.mapperdto.UserBrand;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface UserBrandMapper {

    void create(UserBrand userBrand);

    void insert(UserBrand userBrand);

    void modify(UserBrand userBrand);

    void drop(UserBrand userBrand);

    UserBrand query(@Param("idNo")Long idNo,@Param("brandId") String brandId,@Param("effDate") Date effDate);

    List<UserBrand> qryUserBrandRelList(@Param("params") Map map);

    List<UserBrand> qryUserBrandRelHisList(@Param("inparams") Map map);
}
