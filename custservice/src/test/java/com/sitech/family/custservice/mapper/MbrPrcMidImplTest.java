package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.daoimpl.user.IMbrPrcMid;
import com.sitech.family.custservice.dto.mapperdto.MbrPrcMid;
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
public class MbrPrcMidImplTest {

    @Autowired
    private IMbrPrcMid iMbrPrcMid;

    private MbrPrcMid mbrPrcMid;

    @Before
    public void setUp() throws Exception {
        mbrPrcMid = new MbrPrcMid();
    }

    @After
    public void tearDown() throws Exception {
        mbrPrcMid = null;
    }

    @Test
    public void create() {
        mbrPrcMid.setMemberId(BigDecimal.valueOf(226));
        mbrPrcMid.setInsType("Y");
        mbrPrcMid.setInsValue(BigDecimal.valueOf(226));
        mbrPrcMid.setParinsId(BigDecimal.valueOf(226));
        mbrPrcMid.setOtherinsId(BigDecimal.valueOf(226));
        mbrPrcMid.setRelopType("Y");
        mbrPrcMid.setRelationType("Y");
        mbrPrcMid.setRelinsId(BigDecimal.valueOf(226));
        mbrPrcMid.setMainFlag("Y");
        mbrPrcMid.setGoodsId("225342");
        mbrPrcMid.setPrcId("2322");
        mbrPrcMid.setSvcId("2323");
        mbrPrcMid.setProdId("23124");
        mbrPrcMid.setEffDate(new Date());
        mbrPrcMid.setExpDate(new Date());
        mbrPrcMid.setOrderDate(new Date());
        mbrPrcMid.setOpTime(new Date());
        mbrPrcMid.setOpCode("3424");
        mbrPrcMid.setLoginNo("213");
        mbrPrcMid.setOutAccept("1323");
        mbrPrcMid.setLoginAccept(226L);
        mbrPrcMid.setOpNote("2323");
        mbrPrcMid.setSystemNote("AFAFJ");
        mbrPrcMid.setUpdateType("A");
        mbrPrcMid.setUpdateAccept(new Random().nextLong());
        mbrPrcMid.setUpdateCode("26");
        mbrPrcMid.setUpdateDate(26);
        mbrPrcMid.setUpdateLogin("26");
        mbrPrcMid.setUpdateTime(new Date());

        iMbrPrcMid.create(mbrPrcMid);
    }

    @Test
    public void modify() {
        mbrPrcMid.setMemberId(BigDecimal.valueOf(226));
        mbrPrcMid.setInsType("Y");
        mbrPrcMid.setInsValue(BigDecimal.valueOf(226));
        mbrPrcMid.setParinsId(BigDecimal.valueOf(226));
        mbrPrcMid.setOtherinsId(BigDecimal.valueOf(226));
        mbrPrcMid.setRelopType("Y");
        mbrPrcMid.setRelationType("Y");
        mbrPrcMid.setRelinsId(BigDecimal.valueOf(226));
        mbrPrcMid.setMainFlag("Y");
        mbrPrcMid.setGoodsId("225342");
        mbrPrcMid.setPrcId("2322");
        mbrPrcMid.setSvcId("2323");
        mbrPrcMid.setProdId("23124");
        mbrPrcMid.setEffDate(new Date());
        mbrPrcMid.setExpDate(new Date());
        mbrPrcMid.setOrderDate(new Date());
        mbrPrcMid.setOpTime(new Date());
        mbrPrcMid.setOpCode("3424");
        mbrPrcMid.setLoginNo("213");
        mbrPrcMid.setOutAccept("1323");
        mbrPrcMid.setLoginAccept(226L);
        mbrPrcMid.setOpNote("2323");
        mbrPrcMid.setSystemNote("AFAFJ");
        mbrPrcMid.setUpdateType("U");
        mbrPrcMid.setUpdateAccept(new Random().nextLong());
        mbrPrcMid.setUpdateCode("26");
        mbrPrcMid.setUpdateDate(26);
        mbrPrcMid.setUpdateLogin("26");
        mbrPrcMid.setUpdateTime(new Date());

        iMbrPrcMid.modify(mbrPrcMid);
    }

    @Test
    public void drop() {
        mbrPrcMid.setUpdateType("D");
        mbrPrcMid.setUpdateAccept(new Random().nextLong());
        mbrPrcMid.setUpdateCode("26");
        mbrPrcMid.setUpdateDate(26);
        mbrPrcMid.setUpdateLogin("26");
        mbrPrcMid.setUpdateTime(new Date());
        mbrPrcMid.setInsValue(BigDecimal.valueOf(226));

        iMbrPrcMid.drop(mbrPrcMid);
    }

    @Test
    public void query() {
        BigDecimal insValue = BigDecimal.valueOf(226);
        String insType = "1";

        iMbrPrcMid.query(insType, insValue);
    }

    @Test
    public void qryMbrPrcMidList() {
        Map<String, Object> map = new HashMap<>();
        map.put("memberId", 226);
        map.put("opNote", 2323);

        iMbrPrcMid.qryMbrPrcMidList(map);
    }

    @Test
    public void qryMbrPrcMidHisList() {
        Map<String, Object> map = new HashMap<>();
        map.put("memberId", "226");
        map.put("opNote", "2323");

        iMbrPrcMid.qryMbrPrcMidHisList(map);
    }
}