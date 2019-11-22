package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.daoimpl.user.IUserSvcTrace;
import com.sitech.family.custservice.dto.mapperdto.UserSvcTrace;
import com.sitech.ijcf.boot.core.util.DateUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wusm
 * @description
 * @date 2018/12/18 09:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserSvcTraceAoTest {

    @Autowired
    private IUserSvcTrace iUserSvcTraceAo;

    private UserSvcTrace user;

    @Before
    public void setUp() throws Exception {
        user = new UserSvcTrace();
    }

    @After
    public void tearDown() throws Exception {
        user = null;
    }

    @Test
    public void create() {
        user.setProdprcinsId(BigDecimal.valueOf(126));
        user.setIdNo(122L);
        user.setSvcId("126");
        user.setSvcType("126");
        user.setEffDate(new Date());
        user.setExpDate(DateUtil.toDate("2099-12-31 23:59:59","YYYY-MM-dd HH:mm:ss"));
        user.setState("Y");
        user.setStateDate(new Date());
        user.setLoginNo("126");
        user.setLoginAccept(122L);
        user.setOpTime(new Date());
        user.setOpCode("126");
        user.setServOrderId("126");
        user.setFinishFlag("Y");
        user.setSvcinsId(BigDecimal.valueOf(126));
        user.setUpdateType("A");
        user.setUpdateAccept(126L);

        iUserSvcTraceAo.create(user);
    }

    @Test
    public void modify() {
        user.setProdprcinsId(BigDecimal.valueOf(126));
        user.setIdNo(122L);
        user.setSvcId("91126");
        user.setSvcType("91");
        user.setEffDate(new Date());
        user.setExpDate(DateUtil.toDate("2099-12-31 23:59:59","YYYY-MM-dd HH:mm:ss"));
        user.setState("Y");
        user.setStateDate(new Date());
        user.setLoginNo("91126");
        user.setLoginAccept(122L);
        user.setOpTime(DateUtil.toDate("2099-12-31 23:59:59","YYYY-MM-dd HH:mm:ss"));
        user.setOpCode("91126");
        user.setServOrderId("91126");
        user.setFinishFlag("Y");
        user.setSvcinsId(BigDecimal.valueOf(126));
        user.setUpdateType("U");
        user.setUpdateAccept(126L);

        iUserSvcTraceAo.modify(user);

    }

    @Test
    public void delete() {
        user.setSvcinsId(BigDecimal.valueOf(126));
        user.setUpdateType("D");
        user.setUpdateAccept(126L);

        iUserSvcTraceAo.drop(user);
    }

    @Test
    public void query() {
        user.setSvcinsId(BigDecimal.valueOf(126));

        iUserSvcTraceAo.query(user.getSvcinsId());
    }

    @Test
    public void qryUserSvcTraceInfoList() {
        Map<String,Object> map = new HashMap<>();
        map.put("svcinsId",126);

        iUserSvcTraceAo.qryUserSvcTraceInfoList(map);

    }

    @Test
    public void qryUserSvcTraceInfoHisList() {
        Map<String,Object> map = new HashMap<>();
        map.put("svcinsId",126);

        iUserSvcTraceAo.qryUserSvcTraceInfoHisList(map);

    }
}