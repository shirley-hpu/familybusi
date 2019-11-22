package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.daoimpl.user.IContractRlt;
import com.sitech.family.custservice.dto.mapperdto.AccountRel;
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
 * @date 2019/3/22 13:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ContractRltImplTest {

    @Autowired
    private IContractRlt iContractRlt;

    private AccountRel accountRel;

    @Before
    public void setUp() throws Exception {
        accountRel = new AccountRel();
    }

    @After
    public void tearDown() throws Exception {
        accountRel = null;
    }

    @Test
    public void create() {
        accountRel.setUpdateType("A");
        accountRel.setUpdateAccept(12L);
        accountRel.setUpdateCode("12");
        accountRel.setUpdateDate(12);
        accountRel.setUpdateLogin("12");
        accountRel.setUpdateTime(new Date());
        accountRel.setAcctItems("12");
        accountRel.setAcctRelType("Y");
        accountRel.setContractNo(26L);
        accountRel.setEffDate(new Date());
        accountRel.setExpDate(new Date());
        accountRel.setLoginAccept(26L);
        accountRel.setLoginNo("A26");
        accountRel.setOpTime(new Date());
        accountRel.setPayPri(12);
        accountRel.setPayValue(22.0);
        accountRel.setRelContractNo(26L);
        accountRel.setRemark("26");
        accountRel.setServAcctId(26L);

        iContractRlt.create(accountRel);
    }

    @Test
    public void drop() {
        accountRel.setUpdateType("D");
        accountRel.setUpdateAccept(12L);
        accountRel.setUpdateCode("12");
        accountRel.setUpdateDate(12);
        accountRel.setUpdateLogin("12");
        accountRel.setUpdateTime(new Date());
        accountRel.setServAcctId(26L);

        iContractRlt.drop(accountRel);
    }

    @Test
    public void modify() {
        accountRel.setUpdateType("U");
        accountRel.setUpdateAccept(26L);
        accountRel.setUpdateCode("12");
        accountRel.setUpdateDate(12);
        accountRel.setUpdateLogin("12");
        accountRel.setUpdateTime(new Date());
        accountRel.setAcctItems("12");
        accountRel.setAcctRelType("Y");
        accountRel.setContractNo(26L);
        accountRel.setEffDate(new Date());
        accountRel.setExpDate(new Date());
        accountRel.setLoginAccept(26L);
        accountRel.setLoginNo("A26");
        accountRel.setOpTime(new Date());
        accountRel.setPayPri(12);
        accountRel.setPayValue(22.0);
        accountRel.setRelContractNo(26L);
        accountRel.setRemark("26");
        accountRel.setServAcctId(26L);

        iContractRlt.modify(accountRel);
    }

    @Test
    public void query() {
        accountRel.setServAcctId(26L);

        iContractRlt.query(accountRel.getServAcctId());
    }

    @Test
    public void qryContractRltList() {
        Map<String,Object> map = new HashMap<>();
        map.put("servAcctId",26L);
        map.put("contractNo",26L);

        iContractRlt.qryContractRltList(map);

    }

    @Test
    public void qryContractRltHisList() {
        Map<String,Object> map = new HashMap<>();
        map.put("servAcctId",26L);
        map.put("updateType","U");

        iContractRlt.qryContractRltHisList(map);
    }
}