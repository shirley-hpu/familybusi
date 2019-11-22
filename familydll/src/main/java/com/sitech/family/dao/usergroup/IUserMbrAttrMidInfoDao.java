package com.sitech.family.dao.usergroup;

import com.sitech.family.dto.UpdateOprInfo;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.usergroup.UserMbrAttrMidInfo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description
 * @date 2019/4/17 21:37
 */
public interface IUserMbrAttrMidInfoDao {

    /**
     * 新增
     *
     * @param userMbrAttrMidInfo
     * @return
     */
    ReturnDto create(UserMbrAttrMidInfo userMbrAttrMidInfo);

    /**
     * 修改
     *
     * @param userMbrAttrMidInfo
     * @return
     */
    ReturnDto modify(UserMbrAttrMidInfo userMbrAttrMidInfo);

    /**
     * 删除
     *
     * @param userMbrAttrMidInfo
     * @return
     */
    ReturnDto drop(UserMbrAttrMidInfo userMbrAttrMidInfo);

    /**
     * 查询
     *
     * @param insType,insValue,attrId,effDate,attrNo
     * @return
     */
    UserMbrAttrMidInfo query(String insType,BigDecimal insValue, String attrId, Date effDate, String attrNo);

    /**
     * 查询
     *
     * @param map
     * @return
     */
    List<UserMbrAttrMidInfo> qryUserMbrAttrMidInfoList(Map map);

    /**
     * 删除成员订购属性实例
     * @param updateOprInfo,insValue
     * @return ReturnDto
     */
    ReturnDto delByInsValue(UpdateOprInfo updateOprInfo, BigDecimal insValue);
}
