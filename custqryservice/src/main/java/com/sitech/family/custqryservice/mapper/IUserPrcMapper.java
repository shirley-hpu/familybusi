package com.sitech.family.custqryservice.mapper;

import com.sitech.family.custqryservice.dto.mapperdto.UserPrc;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * @author wusm
 * @description
 * @date 2018/12/7 10:04
 */
@Repository
public interface IUserPrcMapper {

    UserPrc query(BigDecimal prodprcinsId);

}
