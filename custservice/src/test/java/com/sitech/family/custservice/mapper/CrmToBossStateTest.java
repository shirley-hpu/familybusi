/*
package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.base.util.StringUtils;
import com.sitech.family.custservice.daoimpl.user.ICrmToBossStateAo;
import com.sitech.family.custservice.dto.mapperdto.CrmToBossState;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

*/
/**
 * @author Zhangc
 * @version 1.0
 * @date 2019/3/15 14:58
 *//*

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrmToBossStateTest {
    @Resource
    private ICrmToBossStateAo crmToBossStateAo;
    @Before
    public void init() {
        System.out.println("开始测试-----------------");
    }

    @After
    public void after() {
        System.out.println("测试结束-----------------");
    }

    @Test
    public void create(){
        CrmToBossState crmToBossState = new CrmToBossState();
        crmToBossState.setIdNo(StringUtils.castToLong("2019051500003"));
        crmToBossState.setCrmRunCode("A");
        crmToBossState.setCrmRunTime(new Date());
        crmToBossState.setBossRunCode("A");
        crmToBossState.setBossRunTime(new Date());
        crmToBossState.setOpCode("0001");
        crmToBossState.setOpTime(new Date());
        crmToBossState.setLoginNo("shanghai");
        crmToBossState.setBakField("");
        crmToBossState.setLoginAccept(StringUtils.castToLong("00003"));
        crmToBossState.setRunCode("A");
        crmToBossStateAo.create(crmToBossState);
    }
}
*/
