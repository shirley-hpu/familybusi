package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.daoimpl.user.IFeePrice;
import com.sitech.family.custservice.dto.mapperdto.FeePrice;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author wusm
 * @description
 * @date 2019/3/22 13:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FeePriceImplTest {

    @Autowired
    private IFeePrice iFeePrice;

    private FeePrice feePrice;

    @Before
    public void setUp() throws Exception {
        feePrice = new FeePrice();
    }

    @After
    public void tearDown() throws Exception {
        feePrice = null;
    }

    @Test
    public void create() {
        feePrice.setActionId("12");
        feePrice.setBusiMode("Y");
        feePrice.setCalType("Y");
        feePrice.setDataType("Y");
        feePrice.setEffDate(new Date());
        feePrice.setExpDate(new Date());
        feePrice.setFeeCode("Y");
        feePrice.setFeeId(26L);
        feePrice.setFeeType("26");
        feePrice.setFeeUnit("26");
        feePrice.setFeeValue(26L);
        feePrice.setGroupId("a234");
        feePrice.setPayType("32");
        feePrice.setPrintFlag("Y");
        feePrice.setSvcId("23");

        iFeePrice.create(feePrice);
    }

    @Test
    public void modify() {
        feePrice.setActionId("12");
        feePrice.setBusiMode("Y");
        feePrice.setCalType("Y");
        feePrice.setDataType("Y");
        feePrice.setEffDate(new Date());
        feePrice.setExpDate(new Date());
        feePrice.setFeeCode("Y");
        feePrice.setFeeId(26L);
        feePrice.setFeeType("26");
        feePrice.setFeeUnit("26");
        feePrice.setFeeValue(26L);
        feePrice.setGroupId("a234");
        feePrice.setPayType("32");
        feePrice.setPrintFlag("Y");
        feePrice.setSvcId("23");

        iFeePrice.modify(feePrice);
    }

    @Test
    public void drop() {
        feePrice.setActionId("12");
        feePrice.setBusiMode("Y");
        feePrice.setCalType("Y");
        feePrice.setDataType("Y");
        feePrice.setEffDate(new Date());
        feePrice.setExpDate(new Date());
        feePrice.setFeeCode("Y");
        feePrice.setFeeId(26L);
        feePrice.setFeeType("26");
        feePrice.setFeeUnit("26");
        feePrice.setFeeValue(26L);
        feePrice.setGroupId("a234");
        feePrice.setPayType("32");
        feePrice.setPrintFlag("Y");
        feePrice.setSvcId("23");

        iFeePrice.drop(feePrice);
    }

    @Test
    public void query() {
        feePrice.setActionId("12");
        feePrice.setBusiMode("Y");
        feePrice.setCalType("Y");
        feePrice.setDataType("Y");
        feePrice.setEffDate(new Date());
        feePrice.setExpDate(new Date());
        feePrice.setFeeCode("Y");
        feePrice.setFeeId(26L);
        feePrice.setFeeType("26");
        feePrice.setFeeUnit("26");
        feePrice.setFeeValue(26L);
        feePrice.setGroupId("a234");
        feePrice.setPayType("32");
        feePrice.setPrintFlag("Y");
        feePrice.setSvcId("23");

        iFeePrice.query(feePrice.getGroupId(),feePrice.getSvcId(),feePrice.getActionId(),feePrice.getBusiMode(),feePrice.getFeeCode(),feePrice.getFeeType(),feePrice.getEffDate());
    }
}