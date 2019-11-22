package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.daoimpl.user.IConUserRate;
import com.sitech.family.custservice.dto.mapperdto.ConUserRate;
import com.sitech.ijcf.boot.core.util.DateUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wusm
 * @description
 * @date 2018/12/17 15:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ConUserRateAoTest {

    @Autowired
    private IConUserRate iConUserRate;

    private ConUserRate user;

    @Before
    public void setUp() throws Exception {
        user = new ConUserRate();
    }

    @After
    public void tearDown() throws Exception {
        user = null;
    }

    @Test
    public void create() {
        user.setRemark("测试1514");
        user.setOpCode("测试");
        user.setLoginNo("测试1514");
        user.setIdNo(123L);
        user.setDetalCode("测试1514");
        user.setBillOrder(12);
        user.setChkoutPri(12);
        user.setContractNo(123L);
        user.setEffDate(new Date());
        user.setExpDate(DateUtil.toDate("2099-12-31 23:59:59","YYYY-MM-dd HH:mm:ss"));
        user.setFeeCode("测试1514");
        user.setFeeRate(12.0);
        user.setFeeValue(12.0);
        user.setLoginAccept(12L);
        user.setOpTime(new Date());
        user.setServAcctId(12L);
        user.setUpdateType("A");
        user.setUpdateAccept(12L);
        user.setUpdateTime(new Date());
        user.setUpdateDate(12);

        iConUserRate.create(user);
    }

    @Test
    public void modify() {
        user.setOpCode("哈哈1");
        user.setLoginNo("哈哈1");
        user.setDetalCode("测试1514");
        user.setBillOrder(126);
        user.setChkoutPri(126);
        user.setContractNo(126L);
        user.setFeeCode("测试1514");
        user.setFeeRate(126.0);
        user.setFeeValue(126.0);
        user.setLoginAccept(12L);
        user.setOpTime(new Date());
        user.setExpDate(DateUtil.toDate("2099-12-31 23:59:59","YYYY-MM-dd HH:mm:ss"));
        user.setRemark("哈哈1");
        user.setServAcctId(12L);
        user.setEffDate(DateUtil.toDate("2019-03-21 21:04:01","YYYY-MM-dd HH:mm:ss"));
        user.setUpdateType("U");
        user.setUpdateAccept(123L);
        user.setUpdateTime(new Date());
        user.setUpdateDate(122);
        user.setIdNo(123L);

        iConUserRate.modify(user);
    }

    @Test
    public void delete() {
        user.setServAcctId(12L);
        user.setFeeCode("测试1514");
        user.setDetalCode("测试1514");
        user.setUpdateType("D");
        user.setUpdateAccept(123L);
        user.setUpdateTime(new Date());
        user.setUpdateDate(1);
        user.setEffDate(DateUtil.toDate("2019-03-21 20:43:34","YYYY-MM-dd HH:mm:ss"));

        iConUserRate.drop(user);
    }

    @Test
    public void query() {
        user.setServAcctId(12L);
        user.setFeeCode("测试1514");
        user.setDetalCode("测试1514");
        user.setEffDate(DateUtil.toDate("2019-03-21 20:43:34","YYYY-MM-dd HH:mm:ss"));

        iConUserRate.query(user.getServAcctId(),user.getEffDate(),user.getFeeCode(),user.getDetalCode());
    }

    @Test
    public void qryConUserRateList() {
        Map<String,Object> map = new HashMap<>();
        map.put("servAcctId",12L);
        map.put("idNo",123);

        iConUserRate.qryConUserRateList(map);
    }


    @Test
    public void qryConUserRateHisList() {
        Map<String,Object> map = new HashMap<>();
        map.put("servAcctId",12L);
        map.put("idNo",123);

        iConUserRate.qryConUserRateHisList(map);
    }
}