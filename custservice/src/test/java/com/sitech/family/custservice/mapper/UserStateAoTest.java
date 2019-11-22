package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.daoimpl.user.IUserState;
import com.sitech.family.custservice.dto.mapperdto.UserState;
import com.sitech.ijcf.boot.core.util.DateUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * @author wusm
 * @description
 * @date 2018/12/21 18:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserStateAoTest {

    @Autowired
    private IUserState iUserStateAo;

    private UserState user;

    @Before
    public void setUp() throws Exception {
        user = new UserState();
    }

    @After
    public void tearDown() throws Exception {
        user = null;
    }

    @Test
    public void create() {
        user.setEffDate(new Date());
        user.setExpDate(DateUtil.toDate("2099-12-31 12:12:12","YYYY-MM-dd HH:mm:ss"));
        user.setFinishFlag("Y");
        user.setIdNo(1212L);
        user.setLoginAccept(121L);
        user.setLoginNo("122");
        user.setLoginNo("122");
        user.setOpCode("122");
        user.setOpNote("122");
        user.setOpTime(new Date());
        user.setRunCode("Y");
        user.setStateChangeNo(100L);
        user.setSystemNote("122");
        user.setUpdateType("A");
        user.setUpdateAccept(126L);

        iUserStateAo.create(user);
    }

    @Test
    public void modify() {
        user.setEffDate(new Date());
        user.setExpDate(DateUtil.toDate("2099-12-31 12:12:12","YYYY-MM-dd HH:mm:ss"));
        user.setFinishFlag("Y");
        user.setIdNo(123L);
        user.setLoginAccept(123L);
        user.setLoginNo("126");
        user.setLoginNo("126");
        user.setOpCode("126");
        user.setOpNote("126");
        user.setOpTime(new Date());
        user.setRunCode("Y");
        user.setStateChangeNo(100L);
        user.setSystemNote("126");
        user.setUpdateType("U");
        user.setUpdateAccept(126L);

        iUserStateAo.modify(user);
    }

    @Test
    public void delete() {
        user.setStateChangeNo(100L);
        user.setUpdateType("D");
        user.setUpdateAccept(126L);

        iUserStateAo.drop(user);
    }

    @Test
    public void query() {
        user.setStateChangeNo(100L);

        iUserStateAo.query(user.getStateChangeNo());
    }

    @Test
    public void qryUserStateList() {
        Map<String,Object> map = new HashMap<>();
        map.put("stateChangeNo",100L);

        iUserStateAo.qryUserStateList(map);
    }

    @Test
    public void qryUserStateHisList() {
        Map<String,Object> map = new HashMap<>();
        map.put("stateChangeNo",100L);

        iUserStateAo.qryUserStateHisList(map);
    }
}