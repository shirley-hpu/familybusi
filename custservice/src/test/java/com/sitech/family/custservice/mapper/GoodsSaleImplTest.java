package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.daoimpl.user.IGoodsSale;
import com.sitech.family.custservice.dto.mapperdto.GoodsSale;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wusm
 * @description
 * @date 2019/3/22 13:38
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsSaleImplTest {

    @Autowired
    private IGoodsSale iGoodsSale;

    private GoodsSale goodsSale;

    @Before
    public void setUp() throws Exception {
        goodsSale = new GoodsSale();
    }

    @After
    public void tearDown() throws Exception {
        goodsSale = null;
    }

    @Test
    public void create() {
        goodsSale.setBackAcceptId("22");
        goodsSale.setBackFlag("2");
        goodsSale.setBuyIccid("22");
        goodsSale.setBuyName("22");
        goodsSale.setChantypeId("33");
        goodsSale.setContactId("33");
        goodsSale.setDevelopLogin("A22");
        goodsSale.setEffDate(new Date());
        goodsSale.setExpDate(new Date());
        goodsSale.setFavFee(22.3);
        goodsSale.setFinishFlag("Y");
        goodsSale.setGoodsId("22");
        goodsSale.setGoodsinsId(BigDecimal.valueOf(22));
        goodsSale.setGoodsType("2");
        goodsSale.setIdNo(26L);
        goodsSale.setLoginAccept(231L);
        goodsSale.setLoginNo("22");
        goodsSale.setOldGoodsId("22");
        goodsSale.setOldPrcId("323");
        goodsSale.setOldProdprcinsId(BigDecimal.valueOf(23));
        goodsSale.setOldResourceNo("22");
        goodsSale.setOldSellSerialNo(26L);
        goodsSale.setOldSkuId("324");
        goodsSale.setOpCode("2323");
        goodsSale.setOpNote("324");
        goodsSale.setOpSource("2");
        goodsSale.setOpTime(new Date());
        goodsSale.setOpType("Y");
        goodsSale.setOrdlineId("2343");
        goodsSale.setOutOrderId("234");
        goodsSale.setPrcId("123");
        goodsSale.setRealPay(234.32);
        goodsSale.setResourceNo("43");
        goodsSale.setSellSerialNo(23L);
        goodsSale.setShouldPay(324.23);
        goodsSale.setSkuId("23");
        goodsSale.setSubOrderAccept(25L);
        goodsSale.setSubOrderId("423");

        iGoodsSale.create(goodsSale);
    }

    @Test
    public void drop() {
        goodsSale.setLoginAccept(231L);

        iGoodsSale.drop(goodsSale);
    }

    @Test
    public void modify() {
        goodsSale.setBackAcceptId("22");
        goodsSale.setBackFlag("2");
        goodsSale.setBuyIccid("22");
        goodsSale.setBuyName("22");
        goodsSale.setChantypeId("33");
        goodsSale.setContactId("33");
        goodsSale.setDevelopLogin("A22");
        goodsSale.setEffDate(new Date());
        goodsSale.setExpDate(new Date());
        goodsSale.setFavFee(22.3);
        goodsSale.setFinishFlag("Y");
        goodsSale.setGoodsId("22");
        goodsSale.setGoodsinsId(BigDecimal.valueOf(22));
        goodsSale.setGoodsType("2");
        goodsSale.setIdNo(26L);
        goodsSale.setLoginAccept(231L);
        goodsSale.setLoginNo("22");
        goodsSale.setOldGoodsId("22");
        goodsSale.setOldPrcId("323");
        goodsSale.setOldProdprcinsId(BigDecimal.valueOf(23));
        goodsSale.setOldResourceNo("22");
        goodsSale.setOldSellSerialNo(26L);
        goodsSale.setOldSkuId("324");
        goodsSale.setOpCode("2323");
        goodsSale.setOpNote("324");
        goodsSale.setOpSource("2");
        goodsSale.setOpTime(new Date());
        goodsSale.setOpType("Y");
        goodsSale.setOrdlineId("2343");
        goodsSale.setOutOrderId("234");
        goodsSale.setPrcId("123");
        goodsSale.setRealPay(234.32);
        goodsSale.setResourceNo("43");
        goodsSale.setSellSerialNo(23L);
        goodsSale.setShouldPay(324.23);
        goodsSale.setSkuId("23");
        goodsSale.setSubOrderAccept(25L);
        goodsSale.setSubOrderId("423");

        iGoodsSale.modify(goodsSale);
    }

    @Test
    public void query() {
        goodsSale.setLoginAccept(231L);

        iGoodsSale.query(goodsSale.getLoginAccept());

    }
}