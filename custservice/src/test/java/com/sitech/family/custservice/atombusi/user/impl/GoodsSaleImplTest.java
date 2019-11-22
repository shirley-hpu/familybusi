/*
package com.sitech.family.custservice.atombusi.user.impl;

import com.sitech.family.custservice.daoimpl.user.impl.GoodsSaleImpl;
import com.sitech.family.custservice.dto.mapperdto.GoodsSale;
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

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GoodsSaleImplTest {

    private static final Logger logger = LoggerFactory.getLogger(GoodsSaleImplTest.class);

    @Autowired
    private GoodsSaleImpl goodsSaleImpl;

    private GoodsSale goodsSale;

    @Before
    public void setUp() throws Exception {
        goodsSale = new GoodsSale();
        goodsSale.setLoginAccept(100000000000000000L);
        goodsSale.setIdNo(10001L);
        goodsSale.setOpCode("1234");
        goodsSale.setSellSerialNo(10000L);
        goodsSale.setResourceNo("1");
        goodsSale.setOldProdprcinsId(BigDecimal.valueOf(10000L));
        goodsSale.setOldSellSerialNo(10000L);
        goodsSale.setOldResourceNo("100");
        goodsSale.setLoginNo("1234");
        goodsSale.setContactId("12345");
        goodsSale.setOpTime(new Date());
        goodsSale.setBackAcceptId("12345");

       */
/* goodsSale.setUpdateTime(new Date());
        goodsSale.setUpdateAccept(123456789012345678L);
        goodsSale.setUpdateType("A");
        goodsSale.setUpdateDate(20181224);
        goodsSale.setUpdateLogin("12345678901234567890");
        goodsSale.setUpdateCode("10001");*//*


    }

    @After
    public void tearDown() throws Exception {
        goodsSale = null;
    }

    @Test
    public void create() {
        ReturnDto returnDto = goodsSaleImpl.create(goodsSale);
        logger.debug("***** result ==> " + returnDto);
    }

    @Test
    public void drop() {
        ReturnDto returnDto = goodsSaleImpl.drop(goodsSale);
        logger.debug("***** result ==> " + returnDto);
    }

    @Test
    public void modify() {
        ReturnDto returnDto = goodsSaleImpl.modify(goodsSale);
        logger.debug("***** result ==> " + returnDto);
    }

    @Test
    public void qry() {
        GoodsSale qry = goodsSaleImpl.qry(goodsSale);
        logger.debug("***** result ==> " + qry);
    }
}*/
