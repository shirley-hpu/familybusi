package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.daoimpl.user.IUserGoods;
import com.sitech.family.custservice.dto.mapperdto.UserGoods;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wusm
 * @description
 * @date 2019/3/22 13:39
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserGoodsImplTest {

    @Autowired
    private IUserGoods iUserGoods;

    private UserGoods userGoods;

    @Before
    public void setUp() throws Exception {
        userGoods = new UserGoods();
    }

    @After
    public void tearDown() throws Exception {
        userGoods = null;
    }

    @Test
    public void create() {
        userGoods.setGoodsinsId(BigDecimal.valueOf(22));
        userGoods.setStateDate(new Date());
        userGoods.setState("2");
        userGoods.setServOrderId("22");
        userGoods.setRemark("22");
        userGoods.setRelgoodsinsId(BigDecimal.valueOf(22));
        userGoods.setTrangoodsinsId(BigDecimal.valueOf(22));
        userGoods.setPrcId("22");
        userGoods.setParprcId("22");
        userGoods.setOrderSource("22");
        userGoods.setOrderLoginno("22");
        userGoods.setOrderDate(new Date());
        userGoods.setOpTime(new Date());
        userGoods.setOpCode("22");
        userGoods.setLoginNo("22");
        userGoods.setLoginAccept(22L);
        userGoods.setIdNo(22L);
        userGoods.setGoodsMainFlag("Y");
        userGoods.setGoodsId("222");
        userGoods.setFinishFlag("Y");
        userGoods.setExpDate(new Date());
        userGoods.setEffDate(new Date());
        userGoods.setDevelopLogin("22");
        userGoods.setDataOpsource("222");
        userGoods.setCancleSource("userGoods");
        userGoods.setUpdateType("A");
        userGoods.setUpdateAccept(12L);
        userGoods.setUpdateCode("12");
        userGoods.setUpdateDate(12);
        userGoods.setUpdateLogin("12");
        userGoods.setUpdateTime(new Date());

        iUserGoods.create(userGoods);
    }

    @Test
    public void drop() {
        userGoods.setGoodsinsId(BigDecimal.valueOf(22));

        userGoods.setUpdateType("D");
        userGoods.setUpdateAccept(12L);
        userGoods.setUpdateCode("12");
        userGoods.setUpdateDate(12);
        userGoods.setUpdateLogin("12");
        userGoods.setUpdateTime(new Date());

        iUserGoods.drop(userGoods);
    }

    @Test
    public void modify() {
        userGoods.setGoodsinsId(BigDecimal.valueOf(22));
        userGoods.setStateDate(new Date());
        userGoods.setState("2");
        userGoods.setServOrderId("22");
        userGoods.setRemark("22");
        userGoods.setRelgoodsinsId(BigDecimal.valueOf(22));
        userGoods.setTrangoodsinsId(BigDecimal.valueOf(22));
        userGoods.setPrcId("22");
        userGoods.setParprcId("22");
        userGoods.setOrderSource("22");
        userGoods.setOrderLoginno("22");
        userGoods.setOrderDate(new Date());
        userGoods.setOpTime(new Date());
        userGoods.setOpCode("22");
        userGoods.setLoginNo("22");
        userGoods.setLoginAccept(22L);
        userGoods.setIdNo(22L);
        userGoods.setGoodsMainFlag("Y");
        userGoods.setGoodsId("222");
        userGoods.setFinishFlag("Y");
        userGoods.setExpDate(new Date());
        userGoods.setEffDate(new Date());
        userGoods.setDevelopLogin("22");
        userGoods.setDataOpsource("222");
        userGoods.setCancleSource("userGoods");
        userGoods.setUpdateType("U");
        userGoods.setUpdateAccept(12L);
        userGoods.setUpdateCode("12");
        userGoods.setUpdateDate(12);
        userGoods.setUpdateLogin("12");
        userGoods.setUpdateTime(new Date());

        iUserGoods.modify(userGoods);
    }

    @Test
    public void query() {
        userGoods.setGoodsinsId(BigDecimal.valueOf(22));

        iUserGoods.query(userGoods.getGoodsinsId());
    }

    @Test
    public void qryUserGoodsList() {
        Map<String,Object> map = new HashMap<>();
        map.put("goodsinsId",22);

        iUserGoods.qryUserGoodsList(map);
    }

    @Test
    public void qryUserGoodsHisList() {
        Map<String,Object> map = new HashMap<>();
        map.put("goodsinsId",22);
        map.put("updateType","X");

        iUserGoods.qryUserGoodsList(map);
    }
}