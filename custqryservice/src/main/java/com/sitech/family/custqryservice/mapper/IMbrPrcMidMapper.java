package com.sitech.family.custqryservice.mapper;

import com.sitech.family.custqryservice.dto.mapperdto.MbrPrcMid;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description
 * @date 2019/4/17 16:55
 */
@Repository
public interface IMbrPrcMidMapper {



    /**
     * 查询成员订购实例
     *
     * @param map
     * @return List<MbrPrcMid>
     */
    List<MbrPrcMid> qryMbrPrcMidList(@Param("params") Map map);

}
