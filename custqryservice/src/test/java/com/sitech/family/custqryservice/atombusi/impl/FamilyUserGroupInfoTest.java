package com.sitech.family.custqryservice.atombusi.impl;

import com.sitech.family.custqryservice.atombusi.IFamilyUserGroupInfo;
import com.sitech.family.dto.usergroup.UserGroupInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author wusm
 * @description
 * @date 2019/1/4 15:36
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FamilyUserGroupInfoTest {

    @Autowired
    private IFamilyUserGroupInfo iFamilyUserGroupInfo;

    private UserGroupInfo userGroupInfo;

    @Before
    public void setUp() throws Exception {
        userGroupInfo = new UserGroupInfo();
    }

    @After
    public void tearDown() throws Exception {
        userGroupInfo = null;
    }

    @Test
    public void query() {
        userGroupInfo.setGroupId(BigDecimal.valueOf(122));

        iFamilyUserGroupInfo.query(userGroupInfo.getGroupId());
    }
}