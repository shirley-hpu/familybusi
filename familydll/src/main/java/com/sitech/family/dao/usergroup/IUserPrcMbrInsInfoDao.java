package com.sitech.family.dao.usergroup;

import com.sitech.family.dto.UpdateOprInfo;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.usergroup.UserPrcMbrInsInfo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 家庭订购实例与成员实例关系
 *
 * @author shirley
 * @date created in 2018/12/17
 */
public interface IUserPrcMbrInsInfoDao {


    /**
     * 新增
     *
     * @param userPrcMbrInsInfo
     * @return
     */
    ReturnDto create(UserPrcMbrInsInfo userPrcMbrInsInfo);

    /**
     * 修改
     *
     * @param userPrcMbrInsInfo
     * @return
     */
    ReturnDto modify(UserPrcMbrInsInfo userPrcMbrInsInfo);

    /**
     * 删除
     *
     * @param userPrcMbrInsInfo
     * @return
     */
    ReturnDto drop(UserPrcMbrInsInfo userPrcMbrInsInfo);

    /**
     * 查询
     *
     * @return
     */
    UserPrcMbrInsInfo query(BigDecimal memberId, BigDecimal prodPrcInsId);

    /**
     * @param map
     * @return
     */
    List<UserPrcMbrInsInfo> qryUserPrcMbrInsInfoList(Map map);

    /**
     * 根据idNo更新状态
     * @param idNo
     * @return
     */
    ReturnDto updateFinishState(UpdateOprInfo updateOprInfo, String idNo);
}
