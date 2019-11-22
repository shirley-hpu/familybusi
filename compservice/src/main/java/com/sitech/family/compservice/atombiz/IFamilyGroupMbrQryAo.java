package com.sitech.family.compservice.atombiz;

import com.sitech.ijcf.message6.dt.out.OutDTO;

import java.util.Map;

/**
 * @author Zhangc
 * @version 1.0
 * @date 2019/8/2 14:52
 */
public interface IFamilyGroupMbrQryAo {
    /**
     * 家庭群成员信息查询
     * @param map
     * @return
     */
    public OutDTO qryFamilyGroupMbr(Map<String,Object> map);
}
