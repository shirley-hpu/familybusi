package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.dto.mapperdto.ConUserRel;
import com.sitech.family.dto.ReturnDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 帐务关系
 */
@Repository
public interface ConUserRelMapper {

    /**
     * @param servAcctId
     * @return
     */
    void drop(Long servAcctId);

    /**
     * @param conUserRel
     * @return
     */
    void create(ConUserRel conUserRel);

    /**
     * @param conUserRel
     * @return
     */
    void insert(ConUserRel conUserRel);

    /**
     * @param servAcctId
     * @return
     */
    ConUserRel query(Long servAcctId);

    /**
     * @param conUserRel
     * @return
     */
    void modify(ConUserRel conUserRel);

    /**
     * @param map
     * @return List<ConUserRel>
     */
    List<ConUserRel> qryContractRltList(@Param("params") Map map);

    /**
     * @param map
     * @return List<ConUserRel>
     */
    List<ConUserRel> qryContractRltHisList(@Param("inparams") Map map);

    /**
     * 根据idNo更新状态
     * @param conUserRel
     * @return
     */
    void updateFinishState(ConUserRel conUserRel);
}