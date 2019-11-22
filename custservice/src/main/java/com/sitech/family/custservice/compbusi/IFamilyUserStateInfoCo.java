package com.sitech.family.custservice.compbusi;

import java.util.Map;

/**
 * @author Zhangc
 * @version 1.0
 * @date 2019/3/8 16:47
 */
public interface IFamilyUserStateInfoCo {
    /**
     * 用户状态合成
     * @param param
     * @return void
     * @throws Exception
     */
    public void modify(Map<String,Object> param);
}
