package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.daoimpl.user.ICrmToBossState;
import com.sitech.family.custservice.dto.mapperdto.CrmToBossState;
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
 * @date 2019/3/22 13:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CrmToBossStateImplTest {

    @Autowired
    private ICrmToBossState iCrmToBossState;

    private CrmToBossState crmToBossState;

    @Before
    public void setUp() throws Exception {
        crmToBossState = new CrmToBossState();
    }

    @After
    public void tearDown() throws Exception {
        crmToBossState = null;
    }

    @Test
    public void create() {
        crmToBossState.setUpdateType("A");
        crmToBossState.setUpdateAccept(12L);
        crmToBossState.setUpdateCode("12");
        crmToBossState.setUpdateDate(12);
        crmToBossState.setUpdateLogin("12");
        crmToBossState.setUpdateTime(new Date());
        crmToBossState.setRunCode("1");
        crmToBossState.setOpCode("12");
        crmToBossState.setLoginNo("A26");
        crmToBossState.setCrmRunTime(new Date());
        crmToBossState.setCrmRunCode("2");
        crmToBossState.setBossRunTime(new Date());
        crmToBossState.setBossRunCode("22");
        crmToBossState.setBakField("11");
        crmToBossState.setIdNo(26L);
        crmToBossState.setLoginAccept(123L);
        crmToBossState.setOpTime(new Date());

        iCrmToBossState.create(crmToBossState);
    }

    @Test
    public void modify() {
        crmToBossState.setUpdateType("U");
        crmToBossState.setUpdateAccept(12L);
        crmToBossState.setUpdateCode("12");
        crmToBossState.setUpdateDate(12);
        crmToBossState.setUpdateLogin("12");
        crmToBossState.setUpdateTime(new Date());
        crmToBossState.setRunCode("1");
        crmToBossState.setOpCode("12");
        crmToBossState.setLoginNo("A26");
        crmToBossState.setCrmRunTime(new Date());
        crmToBossState.setCrmRunCode("2");
        crmToBossState.setBossRunTime(new Date());
        crmToBossState.setBossRunCode("22");
        crmToBossState.setBakField("11");
        crmToBossState.setIdNo(26L);
        crmToBossState.setLoginAccept(123L);
        crmToBossState.setOpTime(new Date());

        iCrmToBossState.modify(crmToBossState);
    }

    @Test
    public void drop() {
        crmToBossState.setUpdateType("D");
        crmToBossState.setUpdateAccept(12L);
        crmToBossState.setUpdateCode("12");
        crmToBossState.setUpdateDate(12);
        crmToBossState.setUpdateLogin("12");
        crmToBossState.setUpdateTime(new Date());
        crmToBossState.setIdNo(26L);

        iCrmToBossState.drop(crmToBossState);
    }

    @Test
    public void query() {
        crmToBossState.setIdNo(26L);

        iCrmToBossState.query(crmToBossState.getIdNo());
    }

    @Test
    public void qryCrmToBossStateList() {
        Map<String,Object> map = new HashMap<>();
        map.put("idNo",26L);

        iCrmToBossState.qryCrmToBossStateList(map);
    }

    @Test
    public void qryCrmToBossStateHisList() {
        Map<String,Object> map = new HashMap<>();
        map.put("idNo",26L);
        map.put("updateType","X");

        iCrmToBossState.qryCrmToBossStateList(map);
    }
}