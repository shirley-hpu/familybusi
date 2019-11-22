package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.dto.mapperdto.MbrPrcMid;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
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
     * 创建成员订购实例
     *
     * @param mbrPrcMid
     * @return
     */
    void create(MbrPrcMid mbrPrcMid);

    /**
     * 创建历史表成员订购实例
     *
     * @param mbrPrcMid
     * @return
     */
    void insert(MbrPrcMid mbrPrcMid);

    /**
     * 更新成员订购实例
     *
     * @param mbrPrcMid
     * @return
     */
    void modify(MbrPrcMid mbrPrcMid);

    /**
     * 删除成员订购实例
     *
     * @param mbrPrcMid
     * @return
     */
    void drop(MbrPrcMid mbrPrcMid);

    /**
     * 查询成员订购实例
     *
     * @param insType,insValue
     * @return MbrPrcMid
     */
    MbrPrcMid query(@Param("insType") String insType, @Param("insValue") BigDecimal insValue);

    /**
     * 查询成员订购实例
     *
     * @param map
     * @return List<MbrPrcMid>
     */
    List<MbrPrcMid> qryMbrPrcMidList(@Param("params") Map map);

    /**
     * 查询历史表成员订购实例
     *
     * @param map
     * @return List<MbrPrcMid>
     */
    List<MbrPrcMid> qryMbrPrcMidHisList(@Param("inparams") Map map);

    /**
     * 根据idNo删除中间表数据
     *
     * @param mbrPrcMid
     * @return
     */
    void delByIdNo(MbrPrcMid mbrPrcMid);
}
