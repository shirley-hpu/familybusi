package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.dto.mapperdto.UserPrc;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description
 * @date 2018/12/7 10:04
 */
@Repository
public interface IUserPrcMapper {

    void create(UserPrc inDTO);

    void insert(UserPrc inDTO);

    void modify(UserPrc inDTO);

    void drop(BigDecimal prodprcinsId);

    UserPrc query(BigDecimal prodprcinsId);

    List<UserPrc> qryUserPrcInfoList(@Param("params") Map map);

    List<UserPrc> qryUserPrcInfoHisList(@Param("inparams") Map map);

    /**
     * 根据idNo更新状态
     * @param userPrc
     * @return
     */
    void updateFinishState(UserPrc userPrc);
}
