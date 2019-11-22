package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.daoimpl.user.IBillDay;
import com.sitech.family.custservice.dto.mapperdto.BillDay;
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
 * @date 2018/12/21 18:10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BillDayAoTest {

    @Autowired
    private IBillDay iBillDayAo;

    private BillDay bill;

    @Before
    public void setUp() throws Exception {
        bill = new BillDay();
    }

    @After
    public void tearDown() throws Exception {
        bill = null;
    }

    @Test
    public void create() {
        bill.setEffDate(new Date());
        bill.setContractNo(122L);
        bill.setMasterServId("126126");
        bill.setPhoneNo("13888888888");
        bill.setBillDay("24");
        bill.setExpDate(DateUtil.toDate("2099-12-31 23:59:59","YYYY-MM-dd HH:mm:ss"));
        bill.setDurFlag("Y");
        bill.setLoginNo("A126");
        bill.setLoginAccept(122L);
        bill.setOpCode("结账日测试");
        bill.setOpTime(new Date());
        bill.setIdNo(1021L);
        bill.setUpdateType("A");
        bill.setUpdateAccept(126L);

        iBillDayAo.create(bill);
    }

    @Test
    public void modify() {
        bill.setEffDate(DateUtil.toDate("2019-03-21 15:45:24","YYYY-MM-dd HH:mm:ss"));
        bill.setContractNo(122L);
        bill.setMasterServId("127");
        bill.setPhoneNo("2222");
        bill.setBillDay("24");
        bill.setExpDate(DateUtil.toDate("2099-12-31 23:59:59","YYYY-MM-dd HH:mm:ss"));
        bill.setDurFlag("Y");
        bill.setLoginNo("222");
        bill.setLoginAccept(126L);
        bill.setOpCode("结账日修改");
        bill.setOpTime(new Date());
        bill.setIdNo(1021L);
        bill.setUpdateType("U");
        bill.setUpdateAccept(1926L);

        iBillDayAo.modify(bill);
    }

    @Test
    public void delete() {
        bill.setBillDay("24");
        bill.setIdNo(1021L);
        bill.setEffDate(DateUtil.toDate("2019-03-21 15:45:24","YYYY-MM-dd HH:mm:ss"));
        bill.setContractNo(122L);
        bill.setUpdateType("D");
        bill.setUpdateAccept(1026L);

        iBillDayAo.drop(bill);
    }

    @Test
    public void query() {
        bill.setBillDay("24");
        bill.setIdNo(101L);
        bill.setEffDate(DateUtil.toDate("2019-03-21 16:35:17","YYYY-MM-dd HH:mm:ss"));
        bill.setContractNo(122L);

        iBillDayAo.query(bill.getIdNo(),bill.getEffDate(),bill.getContractNo(),bill.getBillDay());
    }

    @Test
    public void qryBillDayList() {
        Map<String,Object> map = new HashMap<>();
        map.put("contractNo",122L);

        iBillDayAo.qryBillDayList(map);
    }

    @Test
    public void qryBillDayHisList() {
        Map<String,Object> map = new HashMap<>();
        map.put("contractNo",122L);
        map.put("billDay",24);
        map.put("updateType","X");

        iBillDayAo.qryBillDayHisList(map);
    }
}