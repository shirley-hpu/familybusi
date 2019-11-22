package com.sitech.family.custqryservice.mapper;

import com.sitech.family.custqryservice.dto.mapperdto.UserPrcMbrIns;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * 家庭订购实例与成员实例关系
 *
 * @author shirley
 * @date created in 2018/12/21
 */
@Repository
public interface UserPrcMbrInsMapper {

    /**
     * @param memberId
     * @return
     */
    UserPrcMbrIns query(@Param("memberId") BigDecimal memberId,@Param("prodPrcInsId") BigDecimal prodPrcInsId);

}
