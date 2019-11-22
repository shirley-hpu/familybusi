/*
package com.sitech.family.custservice.atombusi.user.impl;

import com.sitech.family.custservice.daoimpl.user.impl.ConUserRelInfoImpl;
import com.sitech.family.custservice.dto.mapperdto.ConUserRel;
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

import java.util.Date;
import java.util.List;

*/
/**
 * 帐务付费明细 单元测试
 *//*

@SpringBootTest
@RunWith(SpringRunner.class)
public class ConUserRelInfoImplTest {

    private static final Logger logger = LoggerFactory.getLogger(ConUserRelInfoImplTest.class);

    @Autowired
    private ConUserRelInfoImpl conUserRelInfo;

    private ConUserRel conUserRelHis;


    @Before
    public void setUp() throws Exception {
        logger.debug("***** test before 初始化对象*****");
        conUserRelHis = new ConUserRel();
        conUserRelHis.setServAcctId(10000L);
        conUserRelHis.setContractNo(20000L);  //分片主键  不允许修改
        conUserRelHis.setIdNo(00001L);
        conUserRelHis.setPayType("0");
        conUserRelHis.setPayValue(100.0);
        conUserRelHis.setChkoutPri(9999);
        conUserRelHis.setBillOrder(99999999);
        conUserRelHis.setEffDate(new Date());
        conUserRelHis.setExpDate(new Date());
        conUserRelHis.setFinishFlag("Y");
        conUserRelHis.setOpCode("00001");
        conUserRelHis.setOpTime(new Date());
        conUserRelHis.setLoginNo("123456");
        conUserRelHis.setLoginAccept(10086L);
        conUserRelHis.setDateCycle(1);
        conUserRelHis.setRateFlag("Y");
        conUserRelHis.setCycleType("3");

        conUserRelHis.setUpdateTime(new Date());
        conUserRelHis.setUpdateAccept(123456789012345678L);
        conUserRelHis.setUpdateType("A");
        conUserRelHis.setUpdateDate(20181212);
        conUserRelHis.setUpdateLogin("12345678901234567890");
        conUserRelHis.setUpdateCode("00001");


    }

    @After
    public void tearDown() throws Exception {
        logger.debug("***** test after 销毁对象*****");
        conUserRelHis = null;
    }

    @Test
    public void create() {
        ReturnDto result = conUserRelInfo.create(conUserRelHis);
        logger.debug("***** result ==> " + result);
    }

    @Test
    public void drop() {
        ConUserRel conUserRel = conUserRelInfo.query(conUserRelHis);

        conUserRel.setUpdateTime(new Date());
        conUserRel.setUpdateAccept(123456789012345678L);
        conUserRel.setUpdateType("D");
        conUserRel.setUpdateDate(20181213);
        conUserRel.setUpdateLogin("12345678901234567890");
        conUserRel.setUpdateCode("00001");

        ReturnDto result = conUserRelInfo.drop(conUserRel);
        logger.debug("***** result ==> " + result);

    }

    @Test
    public void modify() {
        conUserRelHis.setServAcctId(10000L);

        conUserRelHis.setPayValue(999.00);

        conUserRelHis.setUpdateTime(new Date());
        conUserRelHis.setUpdateAccept(123456789012345678L);
        conUserRelHis.setUpdateType("U");
        conUserRelHis.setUpdateDate(20181213);
        conUserRelHis.setUpdateLogin("12345678901234567890");
        conUserRelHis.setUpdateCode("00001");

        ReturnDto result = conUserRelInfo.modify(conUserRelHis);
        logger.debug("***** result ==> " + result);


    }

    @Test
    public void qry() {
        ConUserRel conUserRel = conUserRelInfo.qry(conUserRelHis);
        logger.debug("***** conUserRel ==> " + conUserRel);

    }

    @Test
    public void qryContractRltHisList() {
        List<ConUserRel> list = conUserRelInfo.qryContractRltHisList(conUserRelHis);
        logger.debug("***** conUserRelHis ==> " + list);


    }
}*/
