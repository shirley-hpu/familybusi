package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.daoimpl.user.IUserGoodsAttr;
import com.sitech.family.custservice.dto.mapperdto.UserGoodsAttr;
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
 * @date 2018/12/17 16:15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserGoodsAttrAoTest {

    @Autowired
    private IUserGoodsAttr iUserGoodsAttrAo;

    private UserGoodsAttr user;


    @Before
    public void setUp() throws Exception {
        user = new UserGoodsAttr();
    }

    @After
    public void tearDown() throws Exception {
        user = null;
    }

    @Test
    public void create() {
        user.setAttrId("测试1");
        user.setAttrNo("测试1");
        user.setGrpNo("user");
        user.setAttrValue("user");
        user.setPrcId("user");
        user.setIdNo(12L);
        user.setEffDate(new Date());
        user.setExpDate(DateUtil.toDate("2098-12-24 17:17:47","YYYY-MM-dd HH:mm:ss"));
        user.setLoginNo("user");
        user.setLoginAccept(12L);
        user.setOpTime(new Date());
        user.setOpCode("user");
        user.setFinishFlag("Y");
        user.setServOrderId("2018121700001");
        user.setGoodsinsId(BigDecimal.valueOf(126));
        user.setUpdateType("A");
        user.setUpdateAccept(126L);
        user.setUpdateTime(new Date());
        user.setUpdateDate(122);

        iUserGoodsAttrAo.create(user);
    }

    @Test
    public void modify() {
        user.setAttrId("测试1");
        user.setAttrNo("测试1");
        user.setGrpNo("1212");
        user.setAttrValue("1212");
        user.setPrcId("1212");
        user.setIdNo(12L);
        user.setEffDate(DateUtil.toDate("2019-03-22 09:50:19","YYYY-MM-dd HH:mm:ss"));
        user.setExpDate(DateUtil.toDate("2098-12-24 17:17:47","YYYY-MM-dd HH:mm:ss"));
        user.setLoginNo("1212");
        user.setLoginAccept(12L);
        user.setOpTime(new Date());
        user.setOpCode("1212");
        user.setFinishFlag("N");
        user.setServOrderId("2018121700001");
        user.setGoodsinsId(BigDecimal.valueOf(126));
        user.setUpdateType("U");
        user.setUpdateAccept(126L);
        user.setUpdateTime(new Date());
        user.setUpdateDate(122);

        iUserGoodsAttrAo.modify(user);
    }

    @Test
    public void delete() {
        user.setAttrId("测试1");
        user.setAttrNo("测试1");
        user.setEffDate(DateUtil.toDate("2019-03-22 09:50:19","YYYY-MM-dd HH:mm:ss"));
        user.setGoodsinsId(BigDecimal.valueOf(126));
        user.setUpdateType("D");
        user.setUpdateAccept(126L);
        user.setUpdateTime(new Date());
        user.setUpdateDate(122);

        iUserGoodsAttrAo.drop(user);
    }

    @Test
    public void query() {
        user.setAttrId("测试1");
        user.setAttrNo("测试1");
        user.setEffDate(DateUtil.toDate("2019-03-22 09:50:19","YYYY-MM-dd HH:mm:ss"));
        user.setGoodsinsId(BigDecimal.valueOf(126));

        iUserGoodsAttrAo.query(user.getGoodsinsId(),user.getAttrId(),user.getAttrNo(),user.getEffDate());
    }

    @Test
    public void qryUserGoodsAttrList() {
        Map<String,Object> map = new HashMap<>();
        map.put("attrId","测试1");

        iUserGoodsAttrAo.qryUserGoodsAttrList(map);
    }

    @Test
    public void qryUserGoodsAttrHisList() {
        Map<String,Object> map = new HashMap<>();
        map.put("attrId","测试1");

        iUserGoodsAttrAo.qryUserGoodsAttrHisList(map);
    }
}