package com.sitech.family.familyservice.mapper;

import com.sitech.family.familyservice.dto.mapperdto.MbrAttrMid;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
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
     * 创建成员订购属性实例
     *
     * @param mbrAttrMid
     * @return
     */
    void create(MbrAttrMid mbrAttrMid);

    /**
     * 创建历史表成员订购属性实例
     * @param mbrAttrMid
     * @return
     */
    void insert(MbrAttrMid mbrAttrMid);

    /**
     * 更新成员订购属性实例
     *
     * @param mbrAttrMid
     * @return
     */
    void modify(MbrAttrMid mbrAttrMid);

    /**
     * 删除成员订购属性实例
     *
     * @param mbrAttrMid
     * @return
     */
    void drop(MbrAttrMid mbrAttrMid);

    /**
     * 查询成员订购属性实例
     *
     * @param insType,insValue,attrId,effDate,attrNo
     * @return MbrPrcMid
     */
    MbrAttrMid query(@Param("insType") String insType, @Param("insValue") BigDecimal insValue, @Param("attrId") String attrId, @Param("effDate") Date effDate, @Param("attrNo") String attrNo);

    /**
     * 查询成员订购属性实例
     *
     * @param map
     * @return List<MbrAttrMid>
     */
    List<MbrAttrMid> qryMbrAttrMidList(@Param("params") Map map);

    /**
     * 查询历史表成员订购属性实例
     *
     * @param map
     * @return List<MbrAttrMid>
     */
    List<MbrAttrMid> qryMbrAttrMidHisList(@Param("inparams") Map map);

    /**
     * 删除成员订购属性实例
     *
     * @param mbrAttrMid
     * @return
     */
    void delByInsValue(MbrAttrMid mbrAttrMid);
}
