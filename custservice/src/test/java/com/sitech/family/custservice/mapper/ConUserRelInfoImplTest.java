package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.daoimpl.user.IConUserRelInfo;
import com.sitech.family.custservice.dto.mapperdto.ConUserRel;
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
public class ConUserRelInfoImplTest {

    @Autowired
    private IConUserRelInfo iConUserRelInfo;

    private ConUserRel conUserRel;

    @Before
    public void setUp() throws Exception {
        conUserRel = new ConUserRel();
    }

    @After
    public void tearDown() throws Exception {
        conUserRel = null;
    }

    @Test
    public void create() {
        conUserRel.setUpdateType("A");
        conUserRel.setUpdateAccept(12L);
        conUserRel.setUpdateCode("12");
        conUserRel.setUpdateDate(12);
        conUserRel.setUpdateLogin("12");
        conUserRel.setUpdateTime(new Date());
        conUserRel.setBillOrder(26);
        conUserRel.setChkoutPri(26);
        conUserRel.setContractNo(26L);
        conUserRel.setCycleType("g");
        conUserRel.setDateCycle(26);
        conUserRel.setEffDate(new Date());
        conUserRel.setExpDate(new Date());
        conUserRel.setFinishFlag("Y");
        conUserRel.setIdNo(26L);
        conUserRel.setLoginAccept(26L);
        conUserRel.setLoginNo("A26");
        conUserRel.setOpCode("A26");
        conUserRel.setOpTime(new Date());
        conUserRel.setPayType("Y");
        conUserRel.setPayValue(22.22);
        conUserRel.setRateFlag("Y");
        conUserRel.setRemark("fd;lasjlksdfjl");
        conUserRel.setServAcctId(27L);

        iConUserRelInfo.create(conUserRel);
    }

    @Test
    public void drop() {
        conUserRel.setUpdateType("D");
        conUserRel.setUpdateAccept(12L);
        conUserRel.setUpdateCode("12");
        conUserRel.setUpdateDate(12);
        conUserRel.setUpdateLogin("12");
        conUserRel.setUpdateTime(new Date());
        conUserRel.setServAcctId(27L);

        iConUserRelInfo.drop(conUserRel);
    }

    @Test
    public void modify() {
        conUserRel.setUpdateType("U");
        conUserRel.setUpdateAccept(12L);
        conUserRel.setUpdateCode("12");
        conUserRel.setUpdateDate(12);
        conUserRel.setUpdateLogin("12");
        conUserRel.setUpdateTime(new Date());
        conUserRel.setBillOrder(26);
        conUserRel.setChkoutPri(26);
        conUserRel.setContractNo(26L);
        conUserRel.setCycleType("g");
        conUserRel.setDateCycle(26);
        conUserRel.setEffDate(new Date());
        conUserRel.setExpDate(new Date());
        conUserRel.setFinishFlag("Y");
        conUserRel.setIdNo(26L);
        conUserRel.setLoginAccept(26L);
        conUserRel.setLoginNo("A26");
        conUserRel.setOpCode("A26");
        conUserRel.setOpTime(new Date());
        conUserRel.setPayType("Y");
        conUserRel.setPayValue(22.22);
        conUserRel.setRateFlag("Y");
        conUserRel.setRemark("fd;lasjlksdfjl");
        conUserRel.setServAcctId(26L);

        iConUserRelInfo.modify(conUserRel);
    }

    @Test
    public void query() {
        conUserRel.setServAcctId(26L);

        iConUserRelInfo.query(conUserRel.getServAcctId());
    }

    @Test
    public void qryContractRltList() {
        Map<String,Object> map = new HashMap<>();
        map.put("servAcctId",26L);
        map.put("contractNo",26L);

        iConUserRelInfo.qryContractRltList(map);

    }

    @Test
    public void qryContractRltHisList() {
        Map<String,Object> map = new HashMap<>();
        map.put("servAcctId",26L);
        map.put("contractNo",26L);

        iConUserRelInfo.qryContractRltHisList(map);
    }
}