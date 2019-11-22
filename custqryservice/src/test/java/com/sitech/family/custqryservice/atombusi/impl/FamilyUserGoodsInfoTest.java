package com.sitech.family.custqryservice.atombusi.impl;

import com.sitech.family.custqryservice.atombusi.IFamilyUserGoodsInfo;
import com.sitech.family.dto.usergoods.UserGoodsInfo;
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
 * @date 2019/1/4 15:27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FamilyUserGoodsInfoTest {

    @Autowired
    private IFamilyUserGoodsInfo iFamilyUserGoodsInfo;

    private UserGoodsInfo userGoodsInfo;

    @Before
    public void setUp() throws Exception {
        userGoodsInfo = new UserGoodsInfo();
    }

    @After
    public void tearDown() throws Exception {
        userGoodsInfo = null;
    }

    @Test
    public void query() {
     //   userGoodsInfo.setGoodsinsId(BigDecimal.valueOf(12));
     //   userGoodsInfo.setRelgoodsinsId(BigDecimal.valueOf(12));
     //   userGoodsInfo.setLoginAccept(12L);
     //   userGoodsInfo.setRelopType("Y");
     //   userGoodsInfo.setRelationType("N");
     //   userGoodsInfo.setSvcinsId(BigDecimal.valueOf(12));
     //   userGoodsInfo.setProdprcinsId(BigDecimal.valueOf(12));
//
     //   iFamilyUserGoodsInfo.query(userGoodsInfo);
    }
}