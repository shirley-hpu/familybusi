/*
package com.sitech.family.custservice.atombusi.user.impl;

import com.sitech.family.custservice.daoimpl.user.impl.UserBrandImpl;
import com.sitech.family.custservice.dto.mapperdto.UserBrand;
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
import java.util.List;

*/
/**
 * @program: familybusi
 * @description: 用户与品牌关系测试类
 * @author: yang xing
 * @create: 2018-12-20 14:51
 *//*

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserBrandAoTest {

    private static final Logger logger = LoggerFactory.getLogger(UserBrandAoTest.class);
    SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private UserBrandImpl iUserBrandAo;

    private UserBrand userBrand;

    @Before
    public void setUp() throws Exception {
        logger.debug("***** test before 初始化对象*****");
        userBrand=new UserBrand();
        userBrand.setIdNo(100L);
        userBrand.setBrandId("test");
        userBrand.setEffDate(new Date());
        userBrand.setExpDate(new Date());
        userBrand.setFinishFlag("1");
        userBrand.setLoginNo("test1");
        userBrand.setLoginAccept(10086L);
        userBrand.setOpCode("测试");
        userBrand.setOpTime(new Date());
        userBrand.setUpdateTime(new Date());
        userBrand.setUpdateDate(12);
        userBrand.setUpdateLogin("12345");
        userBrand.setUpdateCode("12");
        userBrand.setUpdateAccept(12L);
        userBrand.setUpdateType("I");

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create() {
        userBrand.setBrandId("Test9");
        userBrand.setIdNo(1022L);
        iUserBrandAo.create(userBrand);

    }

    @Test
    public void modify()throws Exception {
        userBrand.setOpCode("修改字段");
        userBrand.setBrandId("Test33");
        userBrand.setIdNo(103L);
        userBrand.setEffDate(format.parse("2018-12-24 19:37:25"));
        iUserBrandAo.modify(userBrand);
    }

    @Test
    public void drop()throws Exception{
        userBrand.setBrandId("Test11");
        userBrand.setIdNo(102L);
        userBrand.setEffDate(format.parse("2018-12-26 09:22:22"));
        iUserBrandAo.drop(userBrand);
    }

    @Test
    public void query()throws Exception {
        userBrand.setBrandId("Test33");
        userBrand.setIdNo(103L);
        userBrand.setEffDate(format.parse("2018-12-24 19:37:25"));
        UserBrand userBrand1=iUserBrandAo.query(userBrand);
        logger.debug("***** userBrand ==> " + userBrand1);
    }

    @Test
    public void qryUserBrandRelHisList()throws Exception{
        userBrand.setBrandId("Test11");
        userBrand.setIdNo(102L);
        userBrand.setEffDate(format.parse("2018-12-26 09:22:22"));
        List<UserBrand> list=iUserBrandAo.qryUserBrandRelHisList(userBrand);
        for (UserBrand u : list) {
            logger.debug("***** UserBrandRelHisList ==> " + u);
        }

    }

    @Test
    public void qryUserBrandRelHisListByUpdateTime()throws Exception{
        Date updateTime=format.parse("2018-12-26 09:22:22");
        List<UserBrand> list=iUserBrandAo.qryUserBrandRelHisListByUpdateTime(updateTime);
        for (UserBrand u : list) {
            logger.debug("***** UserBrandRelHisList ==> " + u);
        }
    }

    @Test
    public void qryUserBrandRelHisListByUpdateAccept(){
        List<UserBrand> list=iUserBrandAo.qryUserBrandRelHisListByUpdateAccept(12);
        for (UserBrand u : list) {
            logger.debug("***** UserBrandRelHisList ==> " + u);
        }
    }
}
*/
