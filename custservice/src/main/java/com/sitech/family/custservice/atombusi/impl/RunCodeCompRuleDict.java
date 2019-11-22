package com.sitech.family.custservice.atombusi.impl;

import com.sitech.family.custservice.atombusi.IRunCodeCompRuleDict;
import com.sitech.family.dao.dict.IRunCodeCompRuleDictDao;
import com.sitech.family.dto.dict.RunCodeCompRuleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Zhangc
 * @version 1.0
 * @date 2019/3/13 17:18
 */
@Component
public class RunCodeCompRuleDict implements IRunCodeCompRuleDict {
    @Autowired
    private IRunCodeCompRuleDictDao runCodeCompRuleDictDao;

    @Override
    public RunCodeCompRuleInfo query(RunCodeCompRuleInfo runCodeCompRuleInfo) {
        return runCodeCompRuleDictDao.query(runCodeCompRuleInfo);
    }
}
