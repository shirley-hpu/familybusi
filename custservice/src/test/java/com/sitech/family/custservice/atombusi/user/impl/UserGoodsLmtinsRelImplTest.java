/*
package com.sitech.family.custservice.atombusi.user.impl;

import com.sitech.family.custservice.daoimpl.user.impl.UserGoodsLmtinsRelImpl;
import com.sitech.family.custservice.dto.mapperdto.UserGoodsLmtins;
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

*/
/**
 * 商品订购实例与受限实例关系 单元测试
 *//*

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserGoodsLmtinsRelImplTest {

    private static final Logger logger = LoggerFactory.getLogger(UserGoodsLmtinsRelImplTest.class);

    @Autowired
    private UserGoodsLmtinsRelImpl userGoodsLmtinsRel;

    private UserGoodsLmtins userGoodsLmtinsHis;


    @Before
    public void setUp() throws Exception {
        logger.debug("***** test before 初始化对象*****");
        userGoodsLmtinsHis = new UserGoodsLmtins();
        userGoodsLmtinsHis.setLimitinsId(BigDecimal.valueOf(10000));
        userGoodsLmtinsHis.setGoodsinsId(BigDecimal.valueOf(100012));
        userGoodsLmtinsHis.setIdNo(00001L);
        userGoodsLmtinsHis.setEffDate(new Date());
        userGoodsLmtinsHis.setExpDate(new Date());

        userGoodsLmtinsHis.setUpdateTime(new Date());
        userGoodsLmtinsHis.setUpdateAccept(123456789012345678L);
        userGoodsLmtinsHis.setUpdateType("D");
        userGoodsLmtinsHis.setUpdateDate(20181214);
        userGoodsLmtinsHis.setUpdateLogin("12345678901234567890");
        userGoodsLmtinsHis.setUpdateCode("10001");


    }

    @After
    public void tearDown() throws Exception {
        logger.debug("***** test after 销毁对象*****");
        userGoodsLmtinsHis = null;
    }

    @Test
    public void create() {
        ReturnDto result = userGoodsLmtinsRel.create(userGoodsLmtinsHis);
        logger.debug("***** result ==> " + result);
    }

    @Test
    public void drop() {
        ReturnDto result = userGoodsLmtinsRel.drop(userGoodsLmtinsHis);
        logger.debug("***** result ==> " + result);
    }

    @Test
    public void modify() {
        userGoodsLmtinsHis.setLoginAccept(9999L);
        userGoodsLmtinsHis.setUpdateType("U");
        ReturnDto result = userGoodsLmtinsRel.modify(userGoodsLmtinsHis);
        logger.debug("***** result ==> " + result);
    }

    @Test
    public void qry() {
        UserGoodsLmtins userGoodsLmtins = userGoodsLmtinsRel.qry(userGoodsLmtinsHis);
        logger.debug("***** userGoodsLmtins ==> " + userGoodsLmtins);
    }

    @Test
    public void qryContractRltHisList() {
        List<UserGoodsLmtins> list = userGoodsLmtinsRel.qryContractRltHisList(userGoodsLmtinsHis);
        logger.debug("***** userGoodsLmtinsHis ==> " + list);
    }
}*/
