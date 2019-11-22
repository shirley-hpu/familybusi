package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.daoimpl.user.IUserGoodsRel;
import com.sitech.family.custservice.dto.mapperdto.UserGoodsRel;
import com.sitech.ijcf.boot.core.util.DateUtil;
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
 * @date 2018/12/28 11:10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserGoodsRelAoTest {

    @Autowired
    private IUserGoodsRel iUserGoodsRelAo;

    private UserGoodsRel userGoodsRel;

    @Before
    public void setUp() throws Exception {
        userGoodsRel = new UserGoodsRel();
    }

    @After
    public void tearDown() throws Exception {
        userGoodsRel = null;
    }

    @Test
    public void create() {
        userGoodsRel.setEffDate(new Date());
        userGoodsRel.setExpDate(DateUtil.toDate("2099-12-31 23:59:59","YYYY-MM-dd HH:mm:ss"));
        userGoodsRel.setGoodsinsId(BigDecimal.valueOf(122));
        userGoodsRel.setIdNo(122L);
        userGoodsRel.setLoginAccept(122L);
        userGoodsRel.setLoginNo("122");
        userGoodsRel.setOpTime(new Date());
        userGoodsRel.setRelationType("122");
        userGoodsRel.setRelgoodsinsId(BigDecimal.valueOf(122));
        userGoodsRel.setRelopType("2");
        userGoodsRel.setRemark("测试");
        userGoodsRel.setServOrderId("122");
        userGoodsRel.setUpdateType("A");
        userGoodsRel.setUpdateAccept(126L);
        userGoodsRel.setUpdateTime(new Date());
        userGoodsRel.setUpdateDate(122);

        iUserGoodsRelAo.create(userGoodsRel);
    }

    @Test
    public void modify() {
        userGoodsRel.setEffDate(new Date());
        userGoodsRel.setExpDate(DateUtil.toDate("2099-12-31 23:59:59","YYYY-MM-dd HH:mm:ss"));
        userGoodsRel.setGoodsinsId(BigDecimal.valueOf(122));
        userGoodsRel.setIdNo(123123L);
        userGoodsRel.setLoginAccept(122L);
        userGoodsRel.setLoginNo("126");
        userGoodsRel.setOpTime(new Date());
        userGoodsRel.setRelationType("126");
        userGoodsRel.setRelgoodsinsId(BigDecimal.valueOf(122));
        userGoodsRel.setRelopType("2");
        userGoodsRel.setRemark("测试125");
        userGoodsRel.setServOrderId("122");
        userGoodsRel.setUpdateType("U");
        userGoodsRel.setUpdateAccept(126L);
        userGoodsRel.setUpdateTime(new Date());
        userGoodsRel.setUpdateDate(122);

        iUserGoodsRelAo.modify(userGoodsRel);
    }

    @Test
    public void delete() {
        userGoodsRel.setGoodsinsId(BigDecimal.valueOf(122));
        userGoodsRel.setRelgoodsinsId(BigDecimal.valueOf(122));
        userGoodsRel.setLoginAccept(122L);
        userGoodsRel.setUpdateType("D");
        userGoodsRel.setUpdateAccept(1226L);
        userGoodsRel.setUpdateTime(new Date());
        userGoodsRel.setUpdateDate(122);

        iUserGoodsRelAo.drop(userGoodsRel);
    }

    @Test
    public void query() {
        userGoodsRel.setGoodsinsId(BigDecimal.valueOf(122));
        userGoodsRel.setRelgoodsinsId(BigDecimal.valueOf(122));
        userGoodsRel.setLoginAccept(122L);

        iUserGoodsRelAo.query(userGoodsRel.getGoodsinsId(),userGoodsRel.getRelgoodsinsId(),userGoodsRel.getLoginAccept());
    }

    @Test
    public void qryUserGoodsRelList() {
        Map<String,Object> map = new HashMap<>();
        map.put("goodsinsId",122L);

        iUserGoodsRelAo.qryUserGoodsRelList(map);
    }

    @Test
    public void qryUserGoodsRelHisList() {
        Map<String,Object> map = new HashMap<>();
        map.put("goodsinsId",122L);

        iUserGoodsRelAo.qryUserGoodsRelHisList(map);
    }
}