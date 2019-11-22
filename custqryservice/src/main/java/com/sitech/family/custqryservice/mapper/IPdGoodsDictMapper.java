package com.sitech.family.custqryservice.mapper;

import com.sitech.family.custqryservice.dto.outdto.GoodsPrcInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @description
 * @date 2019/4/17 16:55
 */
@Repository
public interface IPdGoodsDictMapper {



    /**
     * 查询商品信息
     *
     * @param map
     * @return List<GoodsPrcInfo>
     */
    List<GoodsPrcInfo> qryGoodsDict(@Param("params") Map map);

}
