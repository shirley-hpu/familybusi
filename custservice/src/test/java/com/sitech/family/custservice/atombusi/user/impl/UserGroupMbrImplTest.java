/*
package com.sitech.family.custservice.atombusi.user.impl;

import com.sitech.family.custservice.daoimpl.user.impl.UserGroupMbrImpl;
import com.sitech.family.custservice.dto.mapperdto.UserGroupMbr;
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
public class UserGroupMbrImplTest {

    private static final Logger logger = LoggerFactory.getLogger(UserGroupMbrAttrImplTest.class);

    @Autowired
    private UserGroupMbrImpl userGroupMbrImpl;

    private UserGroupMbr userGroupMbr;

    @Before
    public void setUp() throws Exception {
        userGroupMbr = new UserGroupMbr();
        userGroupMbr.setMemberId(BigDecimal.valueOf(10001));
        userGroupMbr.setGroupId(BigDecimal.valueOf(1234567890L));
        userGroupMbr.setMemberRoleId(10L);
        userGroupMbr.setObjectType("3");
        userGroupMbr.setObjectId("10");   //分片主键
        userGroupMbr.setShortNum("更新短号码");
        userGroupMbr.setLockFlag("0");
        userGroupMbr.setState("A");
        userGroupMbr.setStateDate(new Date());
        userGroupMbr.setMemberDesc("成员描述");
        userGroupMbr.setMemberName("成员名称");
        userGroupMbr.setEffDate(new Date());
        userGroupMbr.setExpDate(new Date());
        userGroupMbr.setFinishFlag("A");
        userGroupMbr.setOpCode("操作代码");
        userGroupMbr.setOpTime(new Date());
        userGroupMbr.setLoginNo("操作工号");
        userGroupMbr.setLoginAccept(100000000000000000L);

        userGroupMbr.setUpdateTime(new Date());
        userGroupMbr.setUpdateAccept(123456789012345678L);
        userGroupMbr.setUpdateType("D");
        userGroupMbr.setUpdateDate(20181212);
        userGroupMbr.setUpdateLogin("12345678901234567890");
        userGroupMbr.setUpdateCode("00001");


    }

    @After
    public void tearDown() throws Exception {
        userGroupMbr = null;
    }

    @Test
    public void create() {
//        ReturnDto returnDto = userGroupMbrImpl.create(userGroupMbr);
//        logger.debug("***** result ==> " + returnDto);
    }

    @Test
    public void drop() {
        ReturnDto modify = userGroupMbrImpl.drop(userGroupMbr);
        logger.debug("***** result ==> " + modify);
    }

    @Test
    public void modify() {
        ReturnDto modify = userGroupMbrImpl.modify(userGroupMbr);
        logger.debug("***** result ==> " + modify);
    }

    @Test
    public void qry() {
        UserGroupMbr qry = userGroupMbrImpl.qry(userGroupMbr);
        logger.debug("***** result ==> " + qry);
    }

    @Test
    public void qryUserGroupMbrHisList() {
        List<UserGroupMbr> userGroupMbrs = userGroupMbrImpl.qryUserGroupMbrHisList(userGroupMbr);
        logger.debug("***** result ==> " + userGroupMbrs);
    }
}*/
