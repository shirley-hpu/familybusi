package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.daoimpl.user.IUserGoodsLmt;
import com.sitech.family.custservice.dto.mapperdto.UserGoodsLmt;
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
 * @date 2019/3/22 13:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserGoodsLmtImplTest {

    @Autowired
    private IUserGoodsLmt iUserGoodsLmt;

    private UserGoodsLmt userGoodsLmt;

    @Before
    public void setUp() throws Exception {
        userGoodsLmt = new UserGoodsLmt();
    }

    @After
    public void tearDown() throws Exception {
        userGoodsLmt = null;
    }

    @Test
    public void create() {
        userGoodsLmt.setUpdateType("A");
        userGoodsLmt.setUpdateAccept(12L);
        userGoodsLmt.setUpdateCode("12");
        userGoodsLmt.setUpdateDate(12);
        userGoodsLmt.setUpdateLogin("12");
        userGoodsLmt.setUpdateTime(new Date());
        userGoodsLmt.setBrandId("22");
        userGoodsLmt.setEffDate(new Date());
        userGoodsLmt.setExpDate(new Date());
        userGoodsLmt.setFunctionCode("232");
        userGoodsLmt.setGoodsId("323");
        userGoodsLmt.setIdNo(33L);
        userGoodsLmt.setLimitDetailmsg("333");
        userGoodsLmt.setLimitFlag("Y");
        userGoodsLmt.setLimitinsId(BigDecimal.valueOf(333));
        userGoodsLmt.setLimitLevelId("333");
        userGoodsLmt.setLimitType("2");
        userGoodsLmt.setLoginAccept(33l);
        userGoodsLmt.setLoginNo("333");
        userGoodsLmt.setMaxValue(22);
        userGoodsLmt.setMixValue(333);
        userGoodsLmt.setOpCode("333");
        userGoodsLmt.setOpTime(new Date());
        userGoodsLmt.setPrcId("33");
        userGoodsLmt.setRemark("333");
        userGoodsLmt.setRuleId(23);

        iUserGoodsLmt.create(userGoodsLmt);
    }

    @Test
    public void drop() {
        userGoodsLmt.setUpdateType("D");
        userGoodsLmt.setUpdateAccept(12L);
        userGoodsLmt.setUpdateCode("12");
        userGoodsLmt.setUpdateDate(12);
        userGoodsLmt.setUpdateLogin("12");
        userGoodsLmt.setUpdateTime(new Date());
        userGoodsLmt.setLimitinsId(BigDecimal.valueOf(333));

        iUserGoodsLmt.drop(userGoodsLmt);
    }

    @Test
    public void modify() {
        userGoodsLmt.setUpdateType("U");
        userGoodsLmt.setUpdateAccept(12L);
        userGoodsLmt.setUpdateCode("12");
        userGoodsLmt.setUpdateDate(12);
        userGoodsLmt.setUpdateLogin("12");
        userGoodsLmt.setUpdateTime(new Date());
        userGoodsLmt.setBrandId("22");
        userGoodsLmt.setEffDate(new Date());
        userGoodsLmt.setExpDate(new Date());
        userGoodsLmt.setFunctionCode("232");
        userGoodsLmt.setGoodsId("323");
        userGoodsLmt.setIdNo(33L);
        userGoodsLmt.setLimitDetailmsg("333");
        userGoodsLmt.setLimitFlag("Y");
        userGoodsLmt.setLimitinsId(BigDecimal.valueOf(333));
        userGoodsLmt.setLimitLevelId("333");
        userGoodsLmt.setLimitType("2");
        userGoodsLmt.setLoginAccept(33l);
        userGoodsLmt.setLoginNo("333");
        userGoodsLmt.setMaxValue(22);
        userGoodsLmt.setMixValue(333);
        userGoodsLmt.setOpCode("333");
        userGoodsLmt.setOpTime(new Date());
        userGoodsLmt.setPrcId("33");
        userGoodsLmt.setRemark("333");
        userGoodsLmt.setRuleId(23);

        iUserGoodsLmt.modify(userGoodsLmt);
    }

    @Test
    public void query() {
        userGoodsLmt.setLimitinsId(BigDecimal.valueOf(333));

        iUserGoodsLmt.query(userGoodsLmt.getLimitinsId());
    }

    @Test
    public void qryUserGoodsLmtList() {
        Map<String,Object> map = new HashMap<>();
        map.put("limitinsId",122L);

        iUserGoodsLmt.qryUserGoodsLmtList(map);
    }

    @Test
    public void qryUserGoodsLmtHisList() {
        Map<String,Object> map = new HashMap<>();
        map.put("limitinsId",333);

        iUserGoodsLmt.qryUserGoodsLmtHisList(map);
    }
}