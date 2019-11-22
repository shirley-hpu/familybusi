package com.sitech.family.custqryservice.mapper;

import com.sitech.family.custqryservice.dto.mapperdto.MbrAttrMid;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description
 * @date 2019/4/17 16:57
 */
@Repository
public interface IMbrAttrMidMapper {

     /**
     * 查询成员订购属性实例
     *
     * @param map
     * @return List<MbrAttrMid>
     */
    List<MbrAttrMid> qryMbrAttrMidList(@Param("params") Map map);


}
