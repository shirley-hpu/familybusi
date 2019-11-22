/*
package com.sitech.family.custservice.atombusi.user.impl;

import com.sitech.family.custservice.daoimpl.user.impl.UserPrcMbrInsImpl;
import com.sitech.family.custservice.dto.mapperdto.UserPrcMbrIns;
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
public class UserPrcMbrInsImplTest {

    private static final Logger logger = LoggerFactory.getLogger(UserPrcMbrInsImplTest.class);

    @Autowired
    private UserPrcMbrInsImpl userPrcMbrInsImpl;

    private UserPrcMbrIns userPrcMbrIns;

    @Before
    public void setUp() throws Exception {
        userPrcMbrIns = new UserPrcMbrIns();
        userPrcMbrIns.setMemberId(BigDecimal.valueOf(10001));
        userPrcMbrIns.setProdPrcInsId(BigDecimal.valueOf(12345));
        userPrcMbrIns.setIdNo(10001L);
        userPrcMbrIns.setExpDate(new Date());
        userPrcMbrIns.setOpCode("新操作代码");
        userPrcMbrIns.setOpTime(new Date());
        userPrcMbrIns.setLoginNo("操作工号");
        userPrcMbrIns.setLoginAccept(100000000000000000L);

        userPrcMbrIns.setUpdateTime(new Date());
        userPrcMbrIns.setUpdateAccept(123456789012345678L);
        userPrcMbrIns.setUpdateType("D");
        userPrcMbrIns.setUpdateDate(20181214);
        userPrcMbrIns.setUpdateLogin("12345678901234567890");
        userPrcMbrIns.setUpdateCode("10001");

    }

    @After
    public void tearDown() throws Exception {
        userPrcMbrIns = null;
    }

    @Test
    public void create() {
        ReturnDto returnDto = userPrcMbrInsImpl.create(userPrcMbrIns);
        logger.debug("***** result ==> " + returnDto);
    }

    @Test
    public void drop() {
        ReturnDto returnDto = userPrcMbrInsImpl.drop(userPrcMbrIns);
        logger.debug("***** result ==> " + returnDto);
    }

    @Test
    public void modify() {
        ReturnDto returnDto = userPrcMbrInsImpl.modify(userPrcMbrIns);
        logger.debug("***** result ==> " + returnDto);
    }

    @Test
    public void qry() {
        UserPrcMbrIns qry = userPrcMbrInsImpl.qry(userPrcMbrIns);
        logger.debug("***** result ==> " + qry);
    }

    @Test
    public void qryUserPrcMbrInsHisList() {
        List<UserPrcMbrIns> list = userPrcMbrInsImpl.qryUserPrcMbrInsHisList(userPrcMbrIns);
        logger.debug("***** result ==> " + list);
    }
}*/
