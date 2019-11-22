package com.sitech.family.custservice.daoimpl.user;

import com.sitech.family.custservice.dto.mapperdto.MbrPrcMid;
import com.sitech.family.dto.ReturnDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description 成员订购实例
 * @date 2019/4/17 16:41
 */
public interface IMbrPrcMid {

    /**
     * 创建成员订购实例
     *
     * @param mbrPrcMid
     * @return ReturnDto
     */
    ReturnDto create(MbrPrcMid mbrPrcMid);

    /**
     * 更新成员订购实例
     *
     * @param mbrPrcMid
     * @return ReturnDto
     */
    ReturnDto modify(MbrPrcMid mbrPrcMid);

    /**
     * 删除成员订购实例
     *
     * @param mbrPrcMid
     * @return ReturnDto
     */
    ReturnDto drop(MbrPrcMid mbrPrcMid);

    /**
     * 查询成员订购实例
     *
     * @param insType,insValue
     * @return MbrPrcMid
     */
    MbrPrcMid query(String insType, BigDecimal insValue);

    /**
     * 查询成员订购实例
     *
     * @param map
     * @return List<MbrPrcMid>
     */
    List<MbrPrcMid> qryMbrPrcMidList(Map map);

    /**
     * 查询历史表成员订购实例
     *
     * @param map
     * @return List<MbrPrcMid>
     */
    List<MbrPrcMid> qryMbrPrcMidHisList(Map map);

    /**
     * 根据idNo删除中间表数据
     *
     * @param mbrPrcMid
     * @return
     */
    ReturnDto delByIdNo(MbrPrcMid mbrPrcMid);
}
