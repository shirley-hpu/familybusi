package com.sitech.family.familyservice.atombusi;

import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.UpdateOprInfo;
import com.sitech.family.dto.usergroup.UserMbrPrcMidInfo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description
 * @date 2019/4/17 21:41
 */
public interface IFamilyMbrPrcMidInfo {

    /**
     * 新增成员订购实例
     *
     * @param userMbrPrcMidInfo
     * @return ReturnDto
     */
    ReturnDto create(UserMbrPrcMidInfo userMbrPrcMidInfo);

    /**
     * 修改成员订购实例
     *
     * @param userMbrPrcMidInfo
     * @return ReturnDto
     */
    ReturnDto modify(UserMbrPrcMidInfo userMbrPrcMidInfo);

    /**
     * 删除成员订购实例
     *
     * @param userMbrPrcMidInfo
     * @return ReturnDto
     */
    ReturnDto drop(UserMbrPrcMidInfo userMbrPrcMidInfo);

    /**
     * 查询成员订购实例
     *
     * @param insType,insValue
     * @return UserMbrPrcMidInfo
     */
    UserMbrPrcMidInfo query(String insType, BigDecimal insValue);

    /**
     * 查询成员订购实例
     *
     * @param map
     * @return list
     */
    List<UserMbrPrcMidInfo> qryUserMbrPrcMidInfoList(Map map);

    /**
     * 根据idNo删除中间表数据
     *
     * @param idNo
     * @return
     */
    ReturnDto delByIdNo(UpdateOprInfo updateOprInfo, Long idNo);
}
