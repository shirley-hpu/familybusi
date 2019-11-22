package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.service.UserStateChange;
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
 * @date 2019/3/15 18:13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserStageChangeTest {

    @Resource
    private UserStateChange userStateChange;
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
        userStateChange.test();
    }
}
