package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.daoimpl.user.IUserPrcMbrIns;
import com.sitech.family.custservice.dto.mapperdto.UserPrcMbrIns;
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
 * @date 2019/3/22 13:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserPrcMbrInsImplTest {

    @Autowired
    private IUserPrcMbrIns iUserPrcMbrIns;

    private UserPrcMbrIns userPrcMbrIns;

    @Before
    public void setUp() throws Exception {
        userPrcMbrIns = new UserPrcMbrIns();
    }

    @After
    public void tearDown() throws Exception {
        userPrcMbrIns = null;
    }

    @Test
    public void create() {
        userPrcMbrIns.setUpdateType("A");
        userPrcMbrIns.setUpdateAccept(12L);
        userPrcMbrIns.setUpdateCode("12");
        userPrcMbrIns.setUpdateDate(12);
        userPrcMbrIns.setUpdateLogin("12");
        userPrcMbrIns.setUpdateTime(new Date());
        userPrcMbrIns.setExpDate(new Date());
        userPrcMbrIns.setIdNo(22L);
        userPrcMbrIns.setLoginAccept(22L);
        userPrcMbrIns.setLoginNo("333");
        userPrcMbrIns.setMemberId(BigDecimal.valueOf(33));
        userPrcMbrIns.setOpCode("33");
        userPrcMbrIns.setOpTime(new Date());
        userPrcMbrIns.setProdPrcInsId(BigDecimal.valueOf(22));

        iUserPrcMbrIns.create(userPrcMbrIns);
    }

    @Test
    public void drop() {
        userPrcMbrIns.setUpdateType("D");
        userPrcMbrIns.setUpdateAccept(12L);
        userPrcMbrIns.setUpdateCode("12");
        userPrcMbrIns.setUpdateDate(12);
        userPrcMbrIns.setUpdateLogin("12");
        userPrcMbrIns.setUpdateTime(new Date());
        userPrcMbrIns.setExpDate(new Date());
        userPrcMbrIns.setIdNo(22L);
        userPrcMbrIns.setLoginAccept(22L);
        userPrcMbrIns.setLoginNo("333");
        userPrcMbrIns.setMemberId(BigDecimal.valueOf(33));
        userPrcMbrIns.setOpCode("33");
        userPrcMbrIns.setOpTime(new Date());
        userPrcMbrIns.setProdPrcInsId(BigDecimal.valueOf(22));

        iUserPrcMbrIns.drop(userPrcMbrIns);
    }

    @Test
    public void modify() {
        userPrcMbrIns.setUpdateType("U");
        userPrcMbrIns.setUpdateAccept(12L);
        userPrcMbrIns.setUpdateCode("12");
        userPrcMbrIns.setUpdateDate(12);
        userPrcMbrIns.setUpdateLogin("12");
        userPrcMbrIns.setUpdateTime(new Date());
        userPrcMbrIns.setExpDate(new Date());
        userPrcMbrIns.setIdNo(22L);
        userPrcMbrIns.setLoginAccept(22L);
        userPrcMbrIns.setLoginNo("333");
        userPrcMbrIns.setMemberId(BigDecimal.valueOf(33));
        userPrcMbrIns.setOpCode("33");
        userPrcMbrIns.setOpTime(new Date());
        userPrcMbrIns.setProdPrcInsId(BigDecimal.valueOf(22));

        iUserPrcMbrIns.modify(userPrcMbrIns);
    }

    @Test
    public void query() {
        userPrcMbrIns.setMemberId(BigDecimal.valueOf(33));

        userPrcMbrIns.setProdPrcInsId(BigDecimal.valueOf(22));

        iUserPrcMbrIns.query(userPrcMbrIns.getMemberId(),userPrcMbrIns.getProdPrcInsId());
    }

    @Test
    public void qryUserPrcMbrInsList() {
        Map<String,Object> map = new HashMap<>();
        map.put("memberId","49000000000609");
        map.put("prodPrcInsId","49000000000612");

        iUserPrcMbrIns.qryUserPrcMbrInsList(map);
    }

    @Test
    public void qryUserPrcMbrInsHisList() {
        Map<String,Object> map = new HashMap<>();
        map.put("memberId",33);
        map.put("prodPrcInsId",22);

        iUserPrcMbrIns.qryUserPrcMbrInsHisList(map);
    }
}