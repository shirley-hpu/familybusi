package com.sitech.family.custqryservice.mapper;

import com.sitech.family.custqryservice.dto.mapperdto.PdGoodsPrcDict;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author
 * @description 查询商品资费信息
 * @date 2018/12/19 17:48
 */
@Repository
public interface IPdGoodsPrcDictMapper {

    /**
     * 查询商品资费信息
     * @param map
     * @return
     */
    PdGoodsPrcDict qryGoodsPrcInfo(@Param("params") Map map);

}
