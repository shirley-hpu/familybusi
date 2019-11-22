package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.daoimpl.user.IUserGoodsLmtinsRel;
import com.sitech.family.custservice.dto.mapperdto.UserGoodsLmtins;
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
 * @date 2019/3/22 13:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserGoodsLmtinsRelImplTest {

    @Autowired
    private IUserGoodsLmtinsRel iUserGoodsLmtinsRel;

    private UserGoodsLmtins userGoodsLmtins;

    @Before
    public void setUp() throws Exception {
        userGoodsLmtins = new UserGoodsLmtins();
    }

    @After
    public void tearDown() throws Exception {
        userGoodsLmtins = null;
    }

    @Test
    public void create() {
        userGoodsLmtins.setUpdateType("A");
        userGoodsLmtins.setUpdateAccept(12L);
        userGoodsLmtins.setUpdateCode("12");
        userGoodsLmtins.setUpdateDate(12);
        userGoodsLmtins.setUpdateLogin("12");
        userGoodsLmtins.setUpdateTime(new Date());
        userGoodsLmtins.setEffDate(new Date());
        userGoodsLmtins.setExpDate(new Date());
        userGoodsLmtins.setIdNo(26L);
        userGoodsLmtins.setGoodsinsId(BigDecimal.valueOf(22));
        userGoodsLmtins.setLimitinsId(BigDecimal.valueOf(22));
        userGoodsLmtins.setLoginAccept(22l);
        userGoodsLmtins.setLoginNo("22");
        userGoodsLmtins.setOpCode("33");
        userGoodsLmtins.setOpTime(new Date());

        iUserGoodsLmtinsRel.create(userGoodsLmtins);
    }

    @Test
    public void drop() {
        userGoodsLmtins.setUpdateType("D");
        userGoodsLmtins.setUpdateAccept(12L);
        userGoodsLmtins.setUpdateCode("12");
        userGoodsLmtins.setUpdateDate(12);
        userGoodsLmtins.setUpdateLogin("12");
        userGoodsLmtins.setUpdateTime(new Date());
        userGoodsLmtins.setGoodsinsId(BigDecimal.valueOf(22));
        userGoodsLmtins.setLimitinsId(BigDecimal.valueOf(22));

        iUserGoodsLmtinsRel.drop(userGoodsLmtins);
    }

    @Test
    public void modify() {
        userGoodsLmtins.setUpdateType("U");
        userGoodsLmtins.setUpdateAccept(222L);
        userGoodsLmtins.setUpdateCode("12");
        userGoodsLmtins.setUpdateDate(12);
        userGoodsLmtins.setUpdateLogin("12");
        userGoodsLmtins.setUpdateTime(new Date());
        userGoodsLmtins.setEffDate(new Date());
        userGoodsLmtins.setExpDate(new Date());
        userGoodsLmtins.setIdNo(26L);
        userGoodsLmtins.setGoodsinsId(BigDecimal.valueOf(22));
        userGoodsLmtins.setLimitinsId(BigDecimal.valueOf(22));
        userGoodsLmtins.setLoginAccept(22l);
        userGoodsLmtins.setLoginNo("22");
        userGoodsLmtins.setOpCode("33");
        userGoodsLmtins.setOpTime(new Date());

        iUserGoodsLmtinsRel.modify(userGoodsLmtins);
    }

    @Test
    public void query() {
        userGoodsLmtins.setGoodsinsId(BigDecimal.valueOf(22));
        userGoodsLmtins.setLimitinsId(BigDecimal.valueOf(22));

        iUserGoodsLmtinsRel.query(userGoodsLmtins.getLimitinsId(),userGoodsLmtins.getGoodsinsId());
    }

    @Test
    public void qryContractRltList() {
        Map<String,Object> map = new HashMap<>();
        map.put("goodsinsId",22);
        map.put("limitinsId",22);

        iUserGoodsLmtinsRel.qryContractRltList(map);
    }

    @Test
    public void qryContractRltHisList() {
        Map<String,Object> map = new HashMap<>();
        map.put("goodsinsId",22);
        map.put("limitinsId",22);

        iUserGoodsLmtinsRel.qryContractRltHisList(map);
    }
}