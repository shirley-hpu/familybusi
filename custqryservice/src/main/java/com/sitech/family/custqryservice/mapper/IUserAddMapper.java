package com.sitech.family.custqryservice.mapper;

import com.sitech.family.custqryservice.dto.mapperdto.UserAdd;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author wusm
 * @description 扩展属性信息
 * @date 2018/12/20 11:14
 */
@Repository
public interface IUserAddMapper {

    /**
     * 查询扩展属性信息
     * @param idNo
     * @return UserAdd
     */
    UserAdd query(@Param("idNo") Long idNo, @Param("fieldCode")String fieldCode);

}
