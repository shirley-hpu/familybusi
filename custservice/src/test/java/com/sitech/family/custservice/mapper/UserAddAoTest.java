package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.daoimpl.user.IUserAdd;
import com.sitech.family.custservice.dto.mapperdto.UserAdd;
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
 * @date 2018/12/21 18:10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserAddAoTest {

    @Autowired
    private IUserAdd iUserAddAo;

    private UserAdd user;

    @Before
    public void setUp() throws Exception {
        user = new UserAdd();
    }

    @After
    public void tearDown() throws Exception {
        user = null;
    }

    @Test
    public void create() {
        user.setBusiType("126");
        user.setFieldCode("126");
        user.setFieldOrder(2018);
        user.setFieldValue("126");
        user.setFinishFlag("Y");
        user.setIdNo(122L);
        user.setLoginAccept(2018L);
        user.setLoginNo("126");
        user.setOpCode("126");
        user.setOpNote("测试");
        user.setOpTime(new Date());
        user.setOtherValue("126");
        user.setSystemNote("126");
        user.setUpdateType("A");
        user.setUpdateAccept(126L);
        user.setUpdateTime(new Date());
        user.setUpdateDate(122);

        iUserAddAo.create(user);
    }

    @Test
    public void modify() {
        user.setBusiType("127");
        user.setFieldCode("126");
        user.setFieldOrder(201);
        user.setFieldValue("127");
        user.setFinishFlag("Y");
        user.setIdNo(122L);
        user.setLoginAccept(2018L);
        user.setLoginNo("126");
        user.setOpCode("126");
        user.setOpNote("测试1");
        user.setOpTime(new Date());
        user.setOtherValue("127");
        user.setSystemNote("127");
        user.setUpdateType("U");
        user.setUpdateAccept(123L);
        user.setUpdateTime(new Date());
        user.setUpdateDate(122);

        iUserAddAo.modify(user);
    }

    @Test
    public void delete() {
        user.setFieldCode("126");
        user.setIdNo(122L);
        user.setUpdateType("D");
        user.setUpdateAccept(123L);
        user.setUpdateTime(new Date());
        user.setUpdateDate(122);

        iUserAddAo.drop(user);
    }

    @Test
    public void query() {
        user.setFieldCode("126");
        user.setIdNo(122L);
        iUserAddAo.query(user.getIdNo(),user.getFieldCode());
    }

    @Test
    public void qryUserAddList() {
        Map<String,Object> map = new HashMap<>();
        map.put("idNo",122L);

        iUserAddAo.qryUserAddList(map);
    }

    @Test
    public void qryUserAddHisList() {
        Map<String,Object> map = new HashMap<>();
        map.put("idNo",122L);

        iUserAddAo.qryUserAddHisList(map);
    }
}