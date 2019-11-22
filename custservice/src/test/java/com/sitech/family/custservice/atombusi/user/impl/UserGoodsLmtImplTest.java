/*
package com.sitech.family.custservice.atombusi.user.impl;

import com.sitech.family.custservice.daoimpl.user.impl.UserGoodsLmtImpl;
import com.sitech.family.custservice.dto.mapperdto.UserGoodsLmt;
import com.sitech.family.dto.ReturnDto;
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
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserGoodsLmtImplTest {

    private static final Logger logger = LoggerFactory.getLogger(UserGoodsLmtImplTest.class);

    @Autowired
    private UserGoodsLmtImpl userGoodsLmtImpl;

    private UserGoodsLmt userGoodsLmt;

    @Before
    public void setUp() throws Exception {
        userGoodsLmt = new UserGoodsLmt();
        userGoodsLmt.setLimitinsId(BigDecimal.valueOf(10000));
        userGoodsLmt.setIdNo(10001L);
        userGoodsLmt.setGoodsId("12345");
        userGoodsLmt.setExpDate(new Date());
        userGoodsLmt.setLimitLevelId("1");
        userGoodsLmt.setLimitFlag("0");
        userGoodsLmt.setBrandId("54321");
        userGoodsLmt.setOpCode("操作代码");
        userGoodsLmt.setOpTime(new Date());
        userGoodsLmt.setLoginNo("操作工号");
        userGoodsLmt.setLoginAccept(100000000000000000L);

        userGoodsLmt.setUpdateTime(new Date());
        userGoodsLmt.setUpdateAccept(123456789012345678L);
        userGoodsLmt.setUpdateType("D");
        userGoodsLmt.setUpdateDate(20181214);
        userGoodsLmt.setUpdateLogin("12345678901234567890");
        userGoodsLmt.setUpdateCode("10001");

    }

    @After
    public void tearDown() throws Exception {
        userGoodsLmt = null;
    }

    @Test
    public void create() {
        ReturnDto returnDto = userGoodsLmtImpl.create(userGoodsLmt);
        logger.debug("***** result ==> " + returnDto);
    }

    @Test
    public void drop() {
        ReturnDto returnDto = userGoodsLmtImpl.drop(userGoodsLmt);
        logger.debug("***** result ==> " + returnDto);
    }

    @Test
    public void modify() {
        ReturnDto returnDto = userGoodsLmtImpl.modify(userGoodsLmt);
        logger.debug("***** result ==> " + returnDto);
    }

    @Test
    public void qry() {
        UserGoodsLmt qry = userGoodsLmtImpl.qry(userGoodsLmt);
        logger.debug("***** result ==> " + qry);
    }

    @Test
    public void qryUserGoodsLmtHisList() {
        List<UserGoodsLmt> userGoodsLmtHis = userGoodsLmtImpl.qryUserGoodsLmtHisList(userGoodsLmt);
        logger.debug("***** result ==> " + userGoodsLmtHis);
    }
}*/
