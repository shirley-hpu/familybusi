package com.sitech.family.dao.dict;

import com.sitech.family.dto.dict.RunCodeCompRuleInfo;

/**
 * @author Zhangc
 * @version 1.0
 * @date 2019/3/19 9:45
 */
public interface IRunCodeCompRuleDictDao {
    /**
     * 查询状态合成码表
     * @param runCodeCompRuleInfo
     * @return runCodeCompRuleInfo
     */
    RunCodeCompRuleInfo query(RunCodeCompRuleInfo runCodeCompRuleInfo);
}
