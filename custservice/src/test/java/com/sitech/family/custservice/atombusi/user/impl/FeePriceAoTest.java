/*
package com.sitech.family.custservice.atombusi.user.impl;

import com.sitech.family.custservice.daoimpl.user.impl.FeePriceImpl;
import com.sitech.family.custservice.dto.mapperdto.FeePrice;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

*/
/**
 * @program: familybusi
 * @description: 服务请求费用计算配置信息测试类
 * @author: yang xing
 * @create: 2018-12-21 14:18
 *//*

@SpringBootTest
@RunWith(SpringRunner.class)
public class FeePriceAoTest {
    private static final Logger logger = LoggerFactory.getLogger(FeePriceAoTest.class);
    SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private FeePriceImpl feePriceAo;

    private FeePrice feePrice;

    @Before
    public void setUp() throws Exception {
        logger.debug("***** test before 初始化对象*****");
        feePrice= new FeePrice();
        feePrice.setFeeId(100L);
        feePrice.setGroupId("Test");
        feePrice.setSvcId("Test1");
        feePrice.setActionId("Test2");
        feePrice.setBusiMode("Test3");
        feePrice.setFeeCode("Test4");
        feePrice.setFeeType("话费");
        feePrice.setEffDate(new Date());
        feePrice.setExpDate(new Date());
        feePrice.setDataType("测试");
        feePrice.setFeeValue(133L);
        feePrice.setFeeUnit("元");
        feePrice.setCalType("无");
        feePrice.setPrintFlag("1");
        feePrice.setPayType("1");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create(){
        feePrice.setFeeId(105L);
        feePrice.setSvcId("test14");
        feePriceAo.create(feePrice);
    }

    @Test
    public void modify()throws Exception{
        feePrice.setDataType("修改");
        feePrice.setEffDate(format.parse("2018-12-26 09:46:44"));
        feePriceAo.modify(feePrice);
    }

    @Test
    public void drop()throws Exception{
        feePrice.setSvcId("test11");
        feePrice.setEffDate(format.parse("2018-12-26 09:47:17"));
        feePriceAo.drop(feePrice);
    }

    @Test
    public void query()throws Exception{
        feePrice.setEffDate(format.parse("2018-12-26 09:46:44"));
        logger.debug("***** feePrice ==> " + feePriceAo.query(feePrice));
    }

}
*/
