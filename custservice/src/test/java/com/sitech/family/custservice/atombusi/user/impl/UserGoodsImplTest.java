/*
package com.sitech.family.custservice.atombusi.user.impl;

import com.sitech.family.custservice.daoimpl.user.impl.UserGoodsImpl;
import com.sitech.family.custservice.dto.mapperdto.UserGoods;
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
public class UserGoodsImplTest {

    private static final Logger logger = LoggerFactory.getLogger(UserGoodsImplTest.class);

    @Autowired
    private UserGoodsImpl userGoodsImpl;

    private UserGoods userGoods;

    @Before
    public void setUp() throws Exception {
        userGoods = new UserGoods();
        userGoods.setGoodsinsId(BigDecimal.valueOf(10000));
        userGoods.setIdNo(10001L);
        userGoods.setRelgoodsinsId(BigDecimal.valueOf(12345));
        userGoods.setTrangoodsinsId(BigDecimal.valueOf(12345));
        userGoods.setPrcId("1");
        userGoods.setGoodsId("12345");
        userGoods.setEffDate(new Date());
        userGoods.setExpDate(new Date());
        userGoods.setState("A");
        userGoods.setStateDate(new Date());
        userGoods.setGoodsMainFlag("0");
        userGoods.setFinishFlag("M");
        userGoods.setOrderDate(new Date());
        userGoods.setServOrderId("12345");
        userGoods.setOpCode("新操作代码");
        userGoods.setOpTime(new Date());
        userGoods.setLoginNo("操作工号");
        userGoods.setLoginAccept(100000000000000000L);
        userGoods.setDataOpsource("AH");
        userGoods.setOrderSource("01");
        userGoods.setCancleSource("01");
        userGoods.setOrderLoginno("12345");

        userGoods.setUpdateTime(new Date());
        userGoods.setUpdateAccept(123456789012345678L);
        userGoods.setUpdateType("U");
        userGoods.setUpdateDate(20181212);
        userGoods.setUpdateLogin("12345678901234567890");
        userGoods.setUpdateCode("00001");

    }

    @After
    public void tearDown() throws Exception {
        userGoods = null;
    }

    @Test
    public void create() {
        ReturnDto returnDto = userGoodsImpl.create(userGoods);
        logger.debug("***** result ==> " + returnDto);
    }

    @Test
    public void drop() {
        ReturnDto returnDto = userGoodsImpl.drop(userGoods);
        logger.debug("***** result ==> " + returnDto);
    }

    @Test
    public void modify() {
        ReturnDto returnDto = userGoodsImpl.modify(userGoods);
        logger.debug("***** result ==> " + returnDto);
    }

    @Test
    public void qry() {
        UserGoods qry = userGoodsImpl.qry(userGoods);
        logger.debug("***** result ==> " + qry);
    }

    @Test
    public void qryUserGoodsHisList() {
        List<UserGoods> userGoods = userGoodsImpl.qryUserGoodsHisList(this.userGoods);
        logger.debug("***** result ==> " + userGoods);
    }
}*/
