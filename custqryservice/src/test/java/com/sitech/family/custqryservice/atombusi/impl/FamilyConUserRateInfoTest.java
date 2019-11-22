package com.sitech.family.custqryservice.atombusi.impl;

import com.sitech.family.custqryservice.atombusi.IFamilyConUserRateInfo;
import com.sitech.family.dto.account.ConUserRateInfo;
import com.sitech.ijcf.boot.core.util.DateUtil;
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
 * @date 2019/1/4 14:14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FamilyConUserRateInfoTest {

    @Autowired
    private IFamilyConUserRateInfo iFamilyConUserRateInfo;

    private ConUserRateInfo conUserRateInfo;


    @Before
    public void setUp() throws Exception {
        conUserRateInfo = new ConUserRateInfo();
    }

    @After
    public void tearDown() throws Exception {
        conUserRateInfo = null;
    }

    @Test
    public void query() {
        conUserRateInfo.setServAcctId(12L);
        conUserRateInfo.setFeeCode("测试1514");
        conUserRateInfo.setDetailCode("测试1514");
        conUserRateInfo.setEffDate(DateUtil.toDate("2019-01-04 14:20:19", "YYYY-MM-dd HH:mm:ss"));

        iFamilyConUserRateInfo.query(conUserRateInfo.getServAcctId(), conUserRateInfo.getFeeCode(), conUserRateInfo.getEffDate(), conUserRateInfo.getDetailCode());

    }
}