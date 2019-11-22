package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.daoimpl.user.IUserPrc;
import com.sitech.family.custservice.dto.mapperdto.UserPrc;
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
 * @date 2018/12/17 16:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserPrcAoTest {

    @Autowired
    private IUserPrc iUserPrcAo;

    private UserPrc user;

    @Before
    public void setUp() throws Exception {
        user = new UserPrc();
    }

    @After
    public void tearDown() throws Exception {
        user = null;
    }

    @Test
    public void create() {
        user.setIdNo(1126L);
        user.setRelprcinsId(BigDecimal.valueOf(126));
        user.setTranprcinsId(BigDecimal.valueOf(126));
        user.setProdPrcid("user.set");
        user.setParprcId("user.set");
        user.setProdId("user.set");
        user.setPricingId(126L);
        user.setEffDate(new Date());
        user.setExpDate(DateUtil.toDate("2098-12-24 17:17:47","YYYY-MM-dd HH:mm:ss"));
        user.setState("成功");
        user.setStateDate(new Date());
        user.setGroupId(BigDecimal.valueOf(1926));
        user.setTeamId(BigDecimal.valueOf(1926));
        user.setDevelopLogin("user.set");
        user.setProdMainFlag("Y");
        user.setFinishFlag("Y");
        user.setOrderDate(new Date());
        user.setRemark("user.set");
        user.setServOrderId("user.set");
        user.setLoginNo("1926");
        user.setOpTime(new Date());
        user.setOpCode("use");
        user.setLoginAccept(123L);
        user.setDataOpsource("user.set");
        user.setOrderSource("user.set");
        user.setCancleSource("user.set");
        user.setOrderLoginno("user.set");
        user.setGoodsinsId(BigDecimal.valueOf(1926));
        user.setProdprcinsId(BigDecimal.valueOf(1926));
        user.setUpdateType("A");
        user.setUpdateAccept(126L);

        iUserPrcAo.create(user);
    }

    @Test
    public void modify() {
        user.setIdNo(1126L);
        user.setRelprcinsId(BigDecimal.valueOf(126));
        user.setTranprcinsId(BigDecimal.valueOf(126));
        user.setProdPrcid("ceshi");
        user.setParprcId("ceshi");
        user.setProdId("ceshi");
        user.setPricingId(126L);
        user.setEffDate(DateUtil.toDate("2098-12-24 17:17:47","YYYY-MM-dd HH:mm:ss"));
        user.setExpDate(new Date());
        user.setState("成功");
        user.setStateDate(new Date());
        user.setGroupId(BigDecimal.valueOf(126));
        user.setTeamId(BigDecimal.valueOf(126));
        user.setDevelopLogin("ceshi");
        user.setProdMainFlag("Y");
        user.setFinishFlag("Y");
        user.setOrderDate(new Date());
        user.setRemark("ceshi");
        user.setServOrderId("ceshi");
        user.setLoginNo("126");
        user.setOpTime(new Date());
        user.setOpCode("use");
        user.setLoginAccept(222L);
        user.setDataOpsource("ceshi");
        user.setOrderSource("ceshi");
        user.setCancleSource("ceshi");
        user.setOrderLoginno("ceshi");
        user.setGoodsinsId(BigDecimal.valueOf(126));
        user.setProdprcinsId(BigDecimal.valueOf(1926));
        user.setUpdateType("U");
        user.setUpdateAccept(126L);


        iUserPrcAo.modify(user);

    }

    @Test
    public void delete() {
        user.setProdprcinsId(BigDecimal.valueOf(1926));
        user.setUpdateType("D");
        user.setUpdateAccept(126L);

        iUserPrcAo.drop(user);
    }

    @Test
    public void query() {
        user.setProdprcinsId(BigDecimal.valueOf(1926));

        iUserPrcAo.query(user.getProdprcinsId());
    }

    @Test
    public void qryUserPrcInfoList() {
        Map<String,Object> map = new HashMap<>();
        map.put("prodprcinsId",1926);
        map.put("finishFlag","Y");

        iUserPrcAo.qryUserPrcInfoList(map);
    }

    @Test
    public void qryUserPrcInfoHisList() {
        Map<String,Object> map = new HashMap<>();
        map.put("prodprcinsId",1926);

        iUserPrcAo.qryUserPrcInfoHisList(map);
    }
}