/*
package com.sitech.family.custservice.atombusi.user.impl;

import com.sitech.family.custservice.daoimpl.user.impl.ResSellTermImpl;
import com.sitech.family.custservice.dto.mapperdto.ResSellTerm;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

*/
/**
 * @program: familybusi
 * @description: 终端资源销售记录信息测试类
 * @author: yang xing
 * @create: 2018-12-21 17:12
 *//*

@SpringBootTest
@RunWith(SpringRunner.class)
public class ResSellTermAoTest {
    private static final Logger logger = LoggerFactory.getLogger(ResSellTermAoTest.class);
    SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private ResSellTermImpl resSellTermAo;

    private ResSellTerm resSellTerm;

    @Before
    public void setUp() throws Exception {
        resSellTerm = new ResSellTerm();
        resSellTerm.setOpTime(new Date());
        resSellTerm.setResourceNo("test");
        resSellTerm.setSellSerialNo(1234L);
        resSellTerm.setLoginAccept(201812L);
        resSellTerm.setResourceType("通信");
        resSellTerm.setResourceCode("33u");
        resSellTerm.setSkuId("2");
        resSellTerm.setResourceModel("test");
        resSellTerm.setReceiveName("yang");
        resSellTerm.setReceivePhone("133");
        resSellTerm.setSellType("2");
        resSellTerm.setResCostPrice(1000L);
        resSellTerm.setResSellPrice(1500L);
        resSellTerm.setResActPrice(1400L);
        resSellTerm.setSellNum(100);
        resSellTerm.setOutterLoginNo("1234");
        resSellTerm.setOutterTime(new Date());
        resSellTerm.setBackFlag("1");
        resSellTerm.setBackAccept(201812L);
        resSellTerm.setOrgGroup("test");
        resSellTerm.setUsePhone("AHA");
        resSellTerm.setSellSolutionId("TE");
        resSellTerm.setSellMeanId("EE");
        resSellTerm.setLoginNo("test1");
        resSellTerm.setOpCode("测试");
        resSellTerm.setOpNote("ahhahhh");
        resSellTerm.setGoodsinsId(new BigDecimal(123344));

        resSellTerm.setUpdateTime(new Date());
        resSellTerm.setUpdateAccept(2018L);
        resSellTerm.setUpdateDate(1222);
        resSellTerm.setUpdateLogin("Test12");
        resSellTerm.setUpdateCode("测试");

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create(){
        resSellTerm.setIdNo(16L);
        resSellTermAo.create(resSellTerm);
    }

    @Test
    public void modify()throws Exception{
        resSellTerm.setResourceCode("修改资源型号");
        resSellTerm.setOpTime(format.parse("2018-12-24 19:28:21"));
        resSellTermAo.modify(resSellTerm);
    }

    @Test
    public void drop()throws Exception{
        resSellTerm.setOpTime(format.parse("2018-12-24 19:28:21"));
        resSellTermAo.drop(resSellTerm);
    }

    @Test
    public void query()throws Exception{
        resSellTerm.setOpTime(format.parse("2018-12-24 19:09:49"));
        logger.debug("***** resSellTerm ==> " + resSellTermAo.query(resSellTerm));
    }

    @Test
    public void qryResSellTermHisList()throws Exception{
        resSellTerm.setUpdateTime(format.parse("2018-12-24 19:28:21"));
        resSellTerm.setUpdateType("I");
        List<ResSellTerm> list = resSellTermAo.qryResSellTermHisList(resSellTerm);
        for (ResSellTerm r: list) {
            logger.debug("***** ResSellTermHisList ==> " + r);
        }
    }
}
*/
