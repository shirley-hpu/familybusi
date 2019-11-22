package com.sitech.family.custservice.compbusi;

import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.usergroup.UserGroupMbrInfo;

import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description
 * @date 2019/3/26 10:41
 */
public interface IFamilyUserGroupMbrCo {

    /**
     * @param map
     * @return ReturnDto
     */
    ReturnDto create(Map<String, Object> map);

    /**
     * 更新竣工标志
     *
     * @param map
     * @return ReturnDto
     */
    ReturnDto updateFinishState(Map<String, Object> map);

    /**
     * 根据roleId、state、groupId查询该群下有无长流程订单
     *
     * @param map
     * @return boolean
     */
    boolean qryLongProcessFlag(Map<String, Object> map);

    /**
     * 根据roleId、groupId查询该群下所有短流程订单
     *
     * @param map
     * @return list
     */
    List<UserGroupMbrInfo> qryShortProcessList(Map<String, Object> map);

    /**
     * 成员删除
     *
     * @param map
     * @return
     */
    ReturnDto drop(Map<String, Object> map);

    /**
     * 成员资费变更
     * @param map
     * @return ReturnDto
     */
    ReturnDto updateMbrPrcIns(Map<String, Object> map);
}
