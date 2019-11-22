package com.sitech.family.custservice.atombusi;

import com.sitech.family.dto.dict.RunCodeCompRuleInfo;

/**
 * @author Zhangc
 * @version 1.0
 * @date 2019/3/13 17:17
 */
public interface IRunCodeCompRuleDict {

    /**
     * 合成状态码表查询
     * @param runCodeCompRuleInfo
     * @return
     */
    RunCodeCompRuleInfo query(RunCodeCompRuleInfo runCodeCompRuleInfo);
}
