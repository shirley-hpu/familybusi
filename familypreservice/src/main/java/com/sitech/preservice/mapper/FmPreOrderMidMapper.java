package com.sitech.preservice.mapper;

import com.sitech.preservice.dto.FamilyPreOrderCfm;
import com.sitech.preservice.dto.FmPreOrderMid;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 预受理
 *
 * @author shirley
 * @date created in 2018/12/20
 */
@Repository
public interface FmPreOrderMidMapper {


    /**
     * 预受理查询
     *
     * @param map
     * @return List<FmPreOrderMid>
     */
    List<FmPreOrderMid> qryFmPreOrderMidList(@Param("params") Map map);

    /**
     * 预受理提交服务
     * @param preoderInfo
     * @return
     */
    int commit(FamilyPreOrderCfm.PreoderInfo preoderInfo);
}
