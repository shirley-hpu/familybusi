package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.daoimpl.user.IResSellTerm;
import com.sitech.family.custservice.dto.mapperdto.ResSellTerm;
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
 * @date 2019/3/22 13:38
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ResSellTermImplTest {

    @Autowired
    private IResSellTerm iResSellTerm;

    private ResSellTerm resSellTerm;

    @Before
    public void setUp() throws Exception {
        resSellTerm = new ResSellTerm();
    }

    @After
    public void tearDown() throws Exception {
        resSellTerm = null;
    }

    @Test
    public void create() {
        resSellTerm.setUpdateType("A");
        resSellTerm.setUpdateAccept(12L);
        resSellTerm.setUpdateCode("12");
        resSellTerm.setUpdateDate(12);
        resSellTerm.setUpdateLogin("12");
        resSellTerm.setUpdateTime(new Date());
        resSellTerm.setBackAccept(123L);
        resSellTerm.setBackFlag("Y");
        resSellTerm.setBak1("13");
        resSellTerm.setBak2("342");
        resSellTerm.setBak3("243");
        resSellTerm.setGoodsinsId(BigDecimal.valueOf(321));
        resSellTerm.setIdNo(26L);
        resSellTerm.setLoginAccept(234L);
        resSellTerm.setOpCode("213");
        resSellTerm.setOpNote("123");
        resSellTerm.setLoginNo("A26");
        resSellTerm.setOpTime(new Date());
        resSellTerm.setOrgGroup("23");
        resSellTerm.setOutterLoginNo("1233");
        resSellTerm.setOutterTime(new Date());
        resSellTerm.setReceiveName("234");
        resSellTerm.setReceivePhone("213");
        resSellTerm.setResActPrice(25L);
        resSellTerm.setResCostPrice(26L);
        resSellTerm.setResourceCode("234");
        resSellTerm.setResourceModel("234");
        resSellTerm.setResourceNo("231");
        resSellTerm.setResourceType("Y");
        resSellTerm.setResSellPrice(25L);
        resSellTerm.setSellMeanId("26");
        resSellTerm.setSellNum(24);
        resSellTerm.setSellSerialNo(26L);
        resSellTerm.setSellSolutionId("26");
        resSellTerm.setSellType("Y");
        resSellTerm.setSkuId("123");
        resSellTerm.setUsePhone("132");

        iResSellTerm.create(resSellTerm);
    }

    @Test
    public void modify() {
        resSellTerm.setUpdateType("U");
        resSellTerm.setUpdateAccept(12L);
        resSellTerm.setUpdateCode("12");
        resSellTerm.setUpdateDate(12);
        resSellTerm.setUpdateLogin("12");
        resSellTerm.setUpdateTime(new Date());
        resSellTerm.setBackAccept(123L);
        resSellTerm.setBackFlag("Y");
        resSellTerm.setBak1("13");
        resSellTerm.setBak2("342");
        resSellTerm.setBak3("243");
        resSellTerm.setGoodsinsId(BigDecimal.valueOf(321));
        resSellTerm.setIdNo(26L);
        resSellTerm.setLoginAccept(234L);
        resSellTerm.setOpCode("213");
        resSellTerm.setOpNote("123");
        resSellTerm.setLoginNo("A26");
        resSellTerm.setOpTime(new Date());
        resSellTerm.setOrgGroup("23");
        resSellTerm.setOutterLoginNo("1233");
        resSellTerm.setOutterTime(new Date());
        resSellTerm.setReceiveName("234");
        resSellTerm.setReceivePhone("213");
        resSellTerm.setResActPrice(25L);
        resSellTerm.setResCostPrice(26L);
        resSellTerm.setResourceCode("234");
        resSellTerm.setResourceModel("234");
        resSellTerm.setResourceNo("231");
        resSellTerm.setResourceType("Y");
        resSellTerm.setResSellPrice(25L);
        resSellTerm.setSellMeanId("26");
        resSellTerm.setSellNum(24);
        resSellTerm.setSellSerialNo(26L);
        resSellTerm.setSellSolutionId("26");
        resSellTerm.setSellType("Y");
        resSellTerm.setSkuId("123");
        resSellTerm.setUsePhone("132");

        iResSellTerm.modify(resSellTerm);
    }

    @Test
    public void drop() {
        resSellTerm.setUpdateType("D");
        resSellTerm.setUpdateAccept(12L);
        resSellTerm.setUpdateCode("12");
        resSellTerm.setUpdateDate(12);
        resSellTerm.setUpdateLogin("12");
        resSellTerm.setUpdateTime(new Date());

        resSellTerm.setOpTime(DateUtil.toDate("2019-03-22 19:03:22","YYYY-MM-dd HH:mm:ss"));

        resSellTerm.setResourceNo("231");

        resSellTerm.setSellSerialNo(26L);

        iResSellTerm.drop(resSellTerm);
    }

    @Test
    public void query() {
        resSellTerm.setOpTime(DateUtil.toDate("2019-03-22 19:03:22","YYYY-MM-dd HH:mm:ss"));

        resSellTerm.setResourceNo("231");

        resSellTerm.setSellSerialNo(26L);

        iResSellTerm.query(resSellTerm.getOpTime(),resSellTerm.getResourceNo(),resSellTerm.getSellSerialNo());
    }

    @Test
    public void qryResSellTermList() {
        Map<String,Object> map = new HashMap<>();
        map.put("resourceNo",231);

        iResSellTerm.qryResSellTermList(map);
    }

    @Test
    public void qryResSellTermHisList() {
        Map<String,Object> map = new HashMap<>();
        map.put("resourceNo",231);

        iResSellTerm.qryResSellTermHisList(map);
    }
}