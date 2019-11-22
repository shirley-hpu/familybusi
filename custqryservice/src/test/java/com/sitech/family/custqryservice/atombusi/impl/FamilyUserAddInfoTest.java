package com.sitech.family.custqryservice.atombusi.impl;

import com.sitech.family.custqryservice.atombusi.IFamilyUserAddInfo;
import com.sitech.family.dto.user.UserAddInfo;
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
 * @date 2019/1/4 15:22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FamilyUserAddInfoTest {

    @Autowired
    private IFamilyUserAddInfo iFamilyUserAddInfo;

    private UserAddInfo userAddInfo;

    @Before
    public void setUp() throws Exception {
        userAddInfo = new UserAddInfo();
    }

    @After
    public void tearDown() throws Exception {
        userAddInfo = null;
    }

    @Test
    public void query() {
        userAddInfo.setIdNo(122L);
        userAddInfo.setFieldCode("126");

        iFamilyUserAddInfo.query(userAddInfo.getIdNo(), userAddInfo.getFieldCode());
    }
}