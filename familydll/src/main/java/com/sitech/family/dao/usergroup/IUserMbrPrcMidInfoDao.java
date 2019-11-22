package com.sitech.family.dao.usergroup;

import com.sitech.family.dto.UpdateOprInfo;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.usergroup.UserMbrPrcMidInfo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description
 * @date 2019/4/17 21:32
 */
public interface IUserMbrPrcMidInfoDao {

    /**
     * 新增
     *
     * @param userMbrPrcMidInfo
     * @return
     */
    ReturnDto create(UserMbrPrcMidInfo userMbrPrcMidInfo);

    /**
     * 修改
     *
     * @param userMbrPrcMidInfo
     * @return
     */
    ReturnDto modify(UserMbrPrcMidInfo userMbrPrcMidInfo);

    /**
     * 删除
     *
     * @param userMbrPrcMidInfo
     * @return
     */
    ReturnDto drop(UserMbrPrcMidInfo userMbrPrcMidInfo);

    /**
     * 查询
     *
     * @param insType,insValue
     * @return
     */
    UserMbrPrcMidInfo query(String insType, BigDecimal insValue);

    /**
     * @param map
     * @return
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
