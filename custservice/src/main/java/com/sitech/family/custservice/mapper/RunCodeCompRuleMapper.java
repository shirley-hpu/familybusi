package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.dto.mapperdto.RunCodeCompRulePhysical;
import org.springframework.stereotype.Repository;

/**
 * @author Zhangc
 * @version 1.0
 * @date 2019/3/13 17:46
 */
@Repository
public interface RunCodeCompRuleMapper {
    RunCodeCompRulePhysical query(RunCodeCompRulePhysical entity);
    void create(RunCodeCompRulePhysical entity);
}
