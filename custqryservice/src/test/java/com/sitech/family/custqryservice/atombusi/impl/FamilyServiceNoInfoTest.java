package com.sitech.family.custqryservice.atombusi.impl;

import com.sitech.family.custqryservice.atombusi.IFamilyServiceNoInfo;
import com.sitech.family.dto.user.UserServiceNoInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author wusm
 * @description
 * @date 2019/1/4 15:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FamilyServiceNoInfoTest {

    @Autowired
    private IFamilyServiceNoInfo iFamilyServiceNoInfo;

    private UserServiceNoInfo userServiceNoInfo;

    @Before
    public void setUp() throws Exception {
        userServiceNoInfo = new UserServiceNoInfo();
    }

    @After
    public void tearDown() throws Exception {
        userServiceNoInfo = null;
    }

    @Test
    public void query() {
        userServiceNoInfo.setServiceNo("188");
        userServiceNoInfo.setIdNo(122L);
        userServiceNoInfo.setServiceType("Y");

        iFamilyServiceNoInfo.query(userServiceNoInfo.getServiceNo(), userServiceNoInfo.getIdNo(), userServiceNoInfo.getServiceType());
    }
}