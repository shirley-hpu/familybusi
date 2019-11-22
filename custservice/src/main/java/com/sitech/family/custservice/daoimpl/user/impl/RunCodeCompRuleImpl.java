package com.sitech.family.custservice.daoimpl.user.impl;

import com.sitech.family.custservice.daoimpl.user.IRunCodeCompRule;
import com.sitech.family.custservice.dto.mapperdto.RunCodeCompRulePhysical;
import com.sitech.family.custservice.mapper.RunCodeCompRuleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Zhangc
 * @version 1.0
 * @date 2019/3/13 17:35
 */
@Component
public class RunCodeCompRuleImpl implements IRunCodeCompRule {
    @Autowired
    private RunCodeCompRuleMapper runCodeCompRuleMapper;
    @Override
    public RunCodeCompRulePhysical query(RunCodeCompRulePhysical entity) {
        return runCodeCompRuleMapper.query(entity);
    }
}
