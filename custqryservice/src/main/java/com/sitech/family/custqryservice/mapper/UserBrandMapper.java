package com.sitech.family.custqryservice.mapper;

import com.sitech.family.custqryservice.dto.mapperdto.UserBrand;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface UserBrandMapper {

    UserBrand query(@Param("idNo")Long idNo,@Param("brandId") String brandId,@Param("effDate") Date effDate);

}
