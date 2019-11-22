package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.daoimpl.user.IUserSvcAttrTrace;
import com.sitech.family.custservice.dto.mapperdto.UserSvcAttrTrace;
import com.sitech.ijcf.boot.core.util.DateUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author guanqp
 * @description  服务属性实例轨迹信息测试类
 * @date 2018/12/29
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserSvcAttrTraceAoTest {

    private static final Logger logger = LoggerFactory.getLogger(UserSvcAttrTraceAoTest.class);

    @Autowired
    private IUserSvcAttrTrace iUserSvcAttrTrace;

    private UserSvcAttrTrace userSvcAttrTrace;

    @Before
    public void setUp() throws Exception {
        userSvcAttrTrace= new UserSvcAttrTrace();
    }

    @After
    public void tearDown() throws Exception {
        userSvcAttrTrace=null;
    }

    @Test
    public void create() {
        userSvcAttrTrace.setSvcinsId(BigDecimal.valueOf(126));
        userSvcAttrTrace.setSvcId("112");
        userSvcAttrTrace.setAttrId("122");
        userSvcAttrTrace.setAttrNo("112");
        userSvcAttrTrace.setEffDate(new Date());
        userSvcAttrTrace.setExpDate(DateUtil.toDate("2018-12-29 17:02:44","YYYY-MM-dd HH:mm:ss"));
        userSvcAttrTrace.setIdNo(11L);
        userSvcAttrTrace.setAttrValue("hello");
        userSvcAttrTrace.setLoginNo("126");
        userSvcAttrTrace.setLoginAccept(122L);
        userSvcAttrTrace.setOpTime(new Date());
        userSvcAttrTrace.setOpCode("126");
        userSvcAttrTrace.setServOrderId("126");
        userSvcAttrTrace.setFinishFlag("Y");
        userSvcAttrTrace.setGrpNo("haha");
        userSvcAttrTrace.setUpdateTime(new Date());
        userSvcAttrTrace.setUpdateAccept(123456789012345678L);
        userSvcAttrTrace.setUpdateType("A");
        userSvcAttrTrace.setUpdateDate(20181224);
        userSvcAttrTrace.setUpdateLogin("12345678901234567890");
        userSvcAttrTrace.setUpdateCode("10001");

        iUserSvcAttrTrace.create(userSvcAttrTrace);

    }

    @Test
    public void modify() {
        userSvcAttrTrace.setSvcinsId(BigDecimal.valueOf(126));
        userSvcAttrTrace.setSvcId("114");
        userSvcAttrTrace.setAttrId("122");
        userSvcAttrTrace.setAttrNo("112");
        userSvcAttrTrace.setEffDate(DateUtil.toDate("2019-03-22 11:21:59","YYYY-MM-dd HH:mm:ss"));
        userSvcAttrTrace.setExpDate(DateUtil.toDate("2099-12-31 23:59:59","YYYY-MM-dd HH:mm:ss"));
        userSvcAttrTrace.setIdNo(11L);
        userSvcAttrTrace.setAttrValue("hello");
        userSvcAttrTrace.setLoginNo("126");
        userSvcAttrTrace.setLoginAccept(122L);
        userSvcAttrTrace.setOpTime(new Date());
        userSvcAttrTrace.setOpCode("126");
        userSvcAttrTrace.setServOrderId("126");
        userSvcAttrTrace.setFinishFlag("Y");
        userSvcAttrTrace.setGrpNo("21123");
        userSvcAttrTrace.setUpdateTime(new Date());
        userSvcAttrTrace.setUpdateAccept(101234561L);
        userSvcAttrTrace.setUpdateType("U");
        userSvcAttrTrace.setUpdateDate(20181224);
        userSvcAttrTrace.setUpdateLogin("12345678901234567890");
        userSvcAttrTrace.setUpdateCode("10001");

        iUserSvcAttrTrace.modify(userSvcAttrTrace);
    }

    @Test
    public void delete() {
        userSvcAttrTrace.setAttrId("122");
        userSvcAttrTrace.setAttrNo("112");
        userSvcAttrTrace.setEffDate(DateUtil.toDate("2019-03-22 11:21:59","YYYY-MM-dd HH:mm:ss"));
        userSvcAttrTrace.setSvcinsId(BigDecimal.valueOf(126));
        userSvcAttrTrace.setUpdateTime(new Date());
        userSvcAttrTrace.setUpdateAccept(101234561L);
        userSvcAttrTrace.setUpdateType("D");
        userSvcAttrTrace.setUpdateDate(20181224);
        userSvcAttrTrace.setUpdateLogin("12345678901234567890");
        userSvcAttrTrace.setUpdateCode("10001");

        iUserSvcAttrTrace.drop(userSvcAttrTrace);
    }

    @Test
    public void query(){
        userSvcAttrTrace.setAttrId("122");
        userSvcAttrTrace.setAttrNo("112");
        userSvcAttrTrace.setEffDate(DateUtil.toDate("2019-03-22 11:21:59","YYYY-MM-dd HH:mm:ss"));
        userSvcAttrTrace.setSvcinsId(BigDecimal.valueOf(126));

        UserSvcAttrTrace use= iUserSvcAttrTrace.query(userSvcAttrTrace.getSvcinsId(),userSvcAttrTrace.getAttrId(),userSvcAttrTrace.getAttrNo(),userSvcAttrTrace.getEffDate());
    }

    @Test
    public void qryUserSvcAttrTraceList() {
        Map<String,Object> map = new HashMap<>();
        map.put("attrId",122);
        map.put("attrNo",112);

        iUserSvcAttrTrace.qryUserSvcAttrTraceList(map);
    }

    @Test
    public void qryUserSvcAttrTraceHisList() {
        Map<String,Object> map = new HashMap<>();
        map.put("attrId",122);
        map.put("attrNo",112);

        iUserSvcAttrTrace.qryUserSvcAttrTraceHisList(map);
    }
}