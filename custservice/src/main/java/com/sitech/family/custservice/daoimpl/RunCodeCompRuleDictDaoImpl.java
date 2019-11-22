package com.sitech.family.custservice.daoimpl;

import com.sitech.family.custservice.daoimpl.user.IRunCodeCompRule;
import com.sitech.family.custservice.dto.mapperdto.RunCodeCompRulePhysical;
import com.sitech.family.dao.dict.IRunCodeCompRuleDictDao;
import com.sitech.family.dto.dict.RunCodeCompRuleInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Zhangc
 * @version 1.0
 * @date 2019/3/13 17:28
 */
@Component
public class RunCodeCompRuleDictDaoImpl implements IRunCodeCompRuleDictDao {
    @Autowired
    private IRunCodeCompRule runCodeCompRule;
    @Override
    public RunCodeCompRuleInfo query(RunCodeCompRuleInfo runCodeCompRuleInfo) {
        RunCodeCompRulePhysical runCodeCompRulePhysical = new RunCodeCompRulePhysical();
        BeanUtils.copyProperties(runCodeCompRuleInfo,runCodeCompRulePhysical);
        RunCodeCompRulePhysical runCodePhysicalTemp = runCodeCompRule.query(runCodeCompRulePhysical);
        RunCodeCompRuleInfo runCodeLogicalTemp = new RunCodeCompRuleInfo();
        BeanUtils.copyProperties(runCodePhysicalTemp,runCodeLogicalTemp);
        return runCodeLogicalTemp;
    }
}
