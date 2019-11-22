package com.sitech.family.familyservice.daoimpl.user;

import com.sitech.family.familyservice.dto.mapperdto.MbrAttrMid;
import com.sitech.family.dto.ReturnDto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description 成员订购属性实例
 * @date 2019/4/17 16:46
 */
public interface IMbrAttrMid {

    /**
     * 创建成员订购属性实例
     *
     * @param mbrAttrMid
     * @return ReturnDto
     */
    ReturnDto create(MbrAttrMid mbrAttrMid);

    /**
     * 更新成员订购属性实例
     *
     * @param mbrAttrMid
     * @return ReturnDto
     */
    ReturnDto modify(MbrAttrMid mbrAttrMid);

    /**
     * 删除成员订购属性实例
     *
     * @param mbrAttrMid
     * @return ReturnDto
     */
    ReturnDto drop(MbrAttrMid mbrAttrMid);

    /**
     * 查询成员订购属性实例
     *
     * @param insType,insValue,attrId,effDate,attrNo
     * @return MbrPrcMid
     */
    MbrAttrMid query(String insType, BigDecimal insValue, String attrId, Date effDate, String attrNo);

    /**
     * 查询成员订购属性实例
     *
     * @param map
     * @return List<MbrAttrMid>
     */
    List<MbrAttrMid> qryMbrAttrMidList(Map map);

    /**
     * 查询历史表成员订购属性实例
     *
     * @param map
     * @return List<MbrAttrMid>
     */
    List<MbrAttrMid> qryMbrAttrMidHisList(Map map);

    /**
     * 删除成员订购属性实例
     *
     * @param mbrAttrMid
     * @return ReturnDto
     */
    ReturnDto delByInsValue(MbrAttrMid mbrAttrMid);
}
