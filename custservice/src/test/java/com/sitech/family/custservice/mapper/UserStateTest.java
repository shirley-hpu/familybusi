package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.base.util.StringUtils;
import com.sitech.family.custservice.daoimpl.user.IUserState;
import com.sitech.family.custservice.dto.mapperdto.UserState;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author Zhangc
 * @version 1.0
 * @date 2019/3/15 17:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserStateTest {
    @Resource
    private IUserState iUserState;
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
        UserState userState = new UserState();
        userState.setStateChangeNo(StringUtils.castToLong("20190315175223005"));
        userState.setIdNo(StringUtils.castToLong("2019051500005"));
        userState.setRunCode("A");
        //userState.setEffDate(new Date());
        //userState.setExpDate(new Date());
        //userState.setFinishFlag("Y");
        userState.setOpTime(new Date());
        userState.setLoginNo("shanghai");
        userState.setLoginAccept(StringUtils.castToLong("1"));
        userState.setOpCode("0005");
        userState.setOpNote("");
        userState.setSystemNote("");
        iUserState.create(userState);
    }
}
