package com.sitech.family.custservice.atombusi;

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
 * @date 2019/4/17 21:41
 */
public interface IFamilyMbrAttrMidInfo {

    /**
     * 新增成员订购属性实例
     *
     * @param userMbrAttrMidInfo
     * @return ReturnDto
     */
    ReturnDto create(UserMbrAttrMidInfo userMbrAttrMidInfo);

    /**
     * 修改成员订购属性实例
     *
     * @param userMbrAttrMidInfo
     * @return ReturnDto
     */
    ReturnDto modify(UserMbrAttrMidInfo userMbrAttrMidInfo);

    /**
     * 删除成员订购属性实例
     *
     * @param userMbrAttrMidInfo
     * @return ReturnDto
     */
    ReturnDto drop(UserMbrAttrMidInfo userMbrAttrMidInfo);

    /**
     * 查询成员订购属性实例
     *
     * @param insType,insValue,attrId,effDate,attrNo
     * @return UserMbrAttrMidInfo
     */
    UserMbrAttrMidInfo query(String insType, BigDecimal insValue, String attrId, Date effDate, String attrNo);

    /**
     * 查询成员订购属性实例
     *
     * @param map
     * @return list
     */
    List<UserMbrAttrMidInfo> qryUserMbrAttrMidInfoList(Map map);

    /**
     * 删除成员订购属性实例
     *
     * @param updateOprInfo,insValue
     * @return ReturnDto
     */
    ReturnDto delByInsValue(UpdateOprInfo updateOprInfo, BigDecimal insValue);
}
