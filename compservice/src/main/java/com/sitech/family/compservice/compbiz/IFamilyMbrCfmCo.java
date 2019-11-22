package com.sitech.family.compservice.compbiz;

import com.sitech.ijcf.message6.dt.out.OutDTO;

import java.util.Map;

public interface IFamilyMbrCfmCo {

    /**
     * 成员管理新增
     *
     * @param map
     * @return
     */
    Map cfmFamilyAddMbr(Map map);

    /**
     * 成员管理删除
     *
     * @param map
     * @return
     */
    OutDTO cfmFamilyDelMbr(Map<String, Object> map);

    /**
     * 家庭成员信息查询
     * @param map
     * @return
     */
    OutDTO cfmFamilyGroupMbr(Map<String,Object> map);
}
