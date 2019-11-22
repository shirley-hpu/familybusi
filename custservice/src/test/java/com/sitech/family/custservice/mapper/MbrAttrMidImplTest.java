package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.daoimpl.user.IMbrAttrMid;
import com.sitech.family.custservice.dto.mapperdto.MbrAttrMid;
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
import java.util.Random;

/**
 * @author wusm
 * @description
 * @date 2019/4/18 15:14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MbrAttrMidImplTest {

    @Autowired
    private IMbrAttrMid iMbrAttrMid;

    private MbrAttrMid mbrAttrMid;

    @Before
    public void setUp() throws Exception {
        mbrAttrMid = new MbrAttrMid();
    }

    @After
    public void tearDown() throws Exception {
        mbrAttrMid = null;
    }

    @Test
    public void create() {
        mbrAttrMid.setInsType("Y");
        mbrAttrMid.setInsValue(BigDecimal.valueOf(222));
        mbrAttrMid.setAttrId("2222");
        mbrAttrMid.setEffDate(new Date());
        mbrAttrMid.setAttrNo("2222");
        mbrAttrMid.setAttrValue("2222");
        mbrAttrMid.setGrpNo("2222");
        mbrAttrMid.setExpDate(new Date());
        mbrAttrMid.setOpTime(new Date());
        mbrAttrMid.setOpCode("2222");
        mbrAttrMid.setLoginNo("222");
        mbrAttrMid.setOutAccept("2222");
        mbrAttrMid.setLoginAccept(222l);
        mbrAttrMid.setOpNote("22222");
        mbrAttrMid.setSystemNote("222");
        mbrAttrMid.setUpdateType("A");
        mbrAttrMid.setUpdateAccept(new Random().nextLong());
        mbrAttrMid.setUpdateCode("26");
        mbrAttrMid.setUpdateDate(26);
        mbrAttrMid.setUpdateLogin("26");
        mbrAttrMid.setUpdateTime(new Date());

        iMbrAttrMid.create(mbrAttrMid);
    }

    @Test
    public void modify() {
        mbrAttrMid.setInsType("Y");
        mbrAttrMid.setInsValue(BigDecimal.valueOf(222));
        mbrAttrMid.setAttrId("2222");
        mbrAttrMid.setEffDate(DateUtil.toDate("2019-04-18", "YYYY-MM-dd"));
        mbrAttrMid.setAttrNo("2222");
        mbrAttrMid.setAttrValue("2222");
        mbrAttrMid.setGrpNo("2222");
        mbrAttrMid.setExpDate(new Date());
        mbrAttrMid.setOpTime(new Date());
        mbrAttrMid.setOpCode("2222");
        mbrAttrMid.setLoginNo("222");
        mbrAttrMid.setOutAccept("2222");
        mbrAttrMid.setLoginAccept(222l);
        mbrAttrMid.setOpNote("22222");
        mbrAttrMid.setSystemNote("222");
        mbrAttrMid.setUpdateType("U");
        mbrAttrMid.setUpdateAccept(new Random().nextLong());
        mbrAttrMid.setUpdateCode("26");
        mbrAttrMid.setUpdateDate(26);
        mbrAttrMid.setUpdateLogin("26");
        mbrAttrMid.setUpdateTime(new Date());

        iMbrAttrMid.modify(mbrAttrMid);
    }

    @Test
    public void drop() {
        mbrAttrMid.setUpdateType("D");
        mbrAttrMid.setUpdateAccept(new Random().nextLong());
        mbrAttrMid.setUpdateCode("26");
        mbrAttrMid.setUpdateDate(26);
        mbrAttrMid.setUpdateLogin("26");
        mbrAttrMid.setUpdateTime(new Date());
        mbrAttrMid.setInsValue(BigDecimal.valueOf(222));
        mbrAttrMid.setAttrId("2222");
        mbrAttrMid.setEffDate(DateUtil.toDate("2019-04-18", "YYYY-MM-dd"));
        mbrAttrMid.setAttrNo("2222");

        iMbrAttrMid.drop(mbrAttrMid);
    }

    @Test
    public void query() {
        mbrAttrMid.setInsValue(BigDecimal.valueOf(222));
        mbrAttrMid.setAttrId("2222");
        mbrAttrMid.setEffDate(DateUtil.toDate("2019-04-18", "YYYY-MM-dd"));
        mbrAttrMid.setAttrNo("2222");
        mbrAttrMid.setInsType("1");

        iMbrAttrMid.query(mbrAttrMid.getInsType(), mbrAttrMid.getInsValue(), mbrAttrMid.getAttrId(), mbrAttrMid.getEffDate(), mbrAttrMid.getAttrNo());
    }

    @Test
    public void qryMbrAttrMidList() {
        Map<String, Object> map = new HashMap<>();
        map.put("insValue", 222);
        map.put("attrId", 2222);

        iMbrAttrMid.qryMbrAttrMidList(map);

    }

    @Test
    public void qryMbrAttrMidHisList() {
        Map<String, Object> map = new HashMap<>();
        map.put("insValue", 222);
        map.put("attrId", 2222);

        iMbrAttrMid.qryMbrAttrMidHisList(map);
    }
}