package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.daoimpl.user.IUserGroupMbr;
import com.sitech.family.custservice.dto.mapperdto.UserGroupMbr;
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
public class UserGroupMbrImplTest {

    @Autowired
    private IUserGroupMbr iUserGroupMbr;

    private UserGroupMbr userGroupMbr;

    @Before
    public void setUp() throws Exception {
        userGroupMbr = new UserGroupMbr();
    }

    @After
    public void tearDown() throws Exception {
        userGroupMbr = null;
    }

    @Test
    public void create() {
        userGroupMbr.setUpdateType("A");
        userGroupMbr.setUpdateAccept(12L);
        userGroupMbr.setUpdateCode("12");
        userGroupMbr.setUpdateDate(12);
        userGroupMbr.setUpdateLogin("12");
        userGroupMbr.setUpdateTime(new Date());
        userGroupMbr.setEffDate(new Date());
        userGroupMbr.setExpDate(new Date());
        userGroupMbr.setFinishFlag("Y");
        userGroupMbr.setGroupId(BigDecimal.valueOf(22));
        userGroupMbr.setLockFlag("Y");
        userGroupMbr.setLoginAccept(22L);
        userGroupMbr.setLoginNo("22");
        userGroupMbr.setMemberDesc("33");
        userGroupMbr.setMemberId(BigDecimal.valueOf(22));
        userGroupMbr.setMemberName("33");
        userGroupMbr.setMbrRole(33l);
        userGroupMbr.setObjectId("33");
        userGroupMbr.setObjectType("Y");
        userGroupMbr.setOpCode("22");
        userGroupMbr.setOpTime(new Date());
        userGroupMbr.setShortNum("33");
        userGroupMbr.setState("22");
        userGroupMbr.setStateDate(new Date());

        iUserGroupMbr.create(userGroupMbr);
    }

    @Test
    public void drop() {
        userGroupMbr.setUpdateType("D");
        userGroupMbr.setUpdateAccept(12L);
        userGroupMbr.setUpdateCode("12");
        userGroupMbr.setUpdateDate(12);
        userGroupMbr.setUpdateLogin("12");
        userGroupMbr.setUpdateTime(new Date());

        userGroupMbr.setMemberId(BigDecimal.valueOf(22));

        iUserGroupMbr.drop(userGroupMbr);
    }

    @Test
    public void modify() {
        userGroupMbr.setUpdateType("U");
        userGroupMbr.setUpdateAccept(12L);
        userGroupMbr.setUpdateCode("12");
        userGroupMbr.setUpdateDate(12);
        userGroupMbr.setUpdateLogin("12");
        userGroupMbr.setUpdateTime(new Date());
        userGroupMbr.setEffDate(new Date());
        userGroupMbr.setExpDate(new Date());
        userGroupMbr.setFinishFlag("Y");
        userGroupMbr.setGroupId(BigDecimal.valueOf(22));
        userGroupMbr.setLockFlag("Y");
        userGroupMbr.setLoginAccept(22L);
        userGroupMbr.setLoginNo("22");
        userGroupMbr.setMemberDesc("33");
        userGroupMbr.setMemberId(BigDecimal.valueOf(22));
        userGroupMbr.setMemberName("33");
        userGroupMbr.setMbrRole(33l);
        userGroupMbr.setObjectId("33");
        userGroupMbr.setObjectType("Y");
        userGroupMbr.setOpCode("22");
        userGroupMbr.setOpTime(new Date());
        userGroupMbr.setShortNum("33");
        userGroupMbr.setState("22");
        userGroupMbr.setStateDate(new Date());

        iUserGroupMbr.modify(userGroupMbr);
    }

    @Test
    public void query() {
        userGroupMbr.setMemberId(BigDecimal.valueOf(22));

        iUserGroupMbr.query(userGroupMbr.getMemberId());
    }

    @Test
    public void qryUserGroupMbrList() {
        Map<String,Object> map = new HashMap<>();
        map.put("memberId",22);

        iUserGroupMbr.qryUserGroupMbrList(map);
    }

    @Test
    public void qryUserGroupMbrHisList() {
        Map<String,Object> map = new HashMap<>();
        map.put("memberId",22);

        iUserGroupMbr.qryUserGroupMbrHisList(map);
    }
}