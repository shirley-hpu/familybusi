package com.sitech.family.custservice.daoimpl.user;

import com.sitech.family.custservice.dto.mapperdto.RunCodeCompRulePhysical;

/**
 * @author Zhangc
 * @version 1.0
 * @date 2019/3/13 17:34
 */
public interface IRunCodeCompRule {

    RunCodeCompRulePhysical query(RunCodeCompRulePhysical entity);
}
