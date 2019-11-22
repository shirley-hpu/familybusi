package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.dto.mapperdto.RunCodeCompRulePhysical;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author Zhangc
 * @version 1.0
 * @date 2019/3/15 13:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RunCodeCompRuleDictTest {
    @Resource
    private RunCodeCompRuleMapper runCodeCompRuleMapper;
    @Before
    public void init() {
        System.out.println("开始测试-----------------");
    }

    @After
    public void after() {
        System.out.println("测试结束-----------------");
    }
    @Test
    public void runCodeDictTest(){
        RunCodeCompRulePhysical runCodeEntity = new RunCodeCompRulePhysical();
        runCodeEntity.setBossRunCode("A");
        runCodeEntity.setCrmRunCode("L");
        runCodeEntity.setRunCode("L");
        runCodeEntity.setTimePriority("1");
        runCodeCompRuleMapper.create(runCodeEntity);
    }
    @Test
    public void query(){
        RunCodeCompRulePhysical runCodeEntity = new RunCodeCompRulePhysical();
        runCodeEntity.setBossRunCode("A");
        runCodeEntity.setCrmRunCode("G");
        RunCodeCompRulePhysical temp = runCodeCompRuleMapper.query(runCodeEntity);
        System.out.println(temp.getBossRunCode()+"  "+ temp.getCrmRunCode()+"  "+ temp.getRunCode());
    }
}
