package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.daoimpl.user.IUserGroupMbrAttr;
import com.sitech.family.custservice.dto.mapperdto.UserGroupMbrAttr;
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
 * @date 2019/3/22 13:42
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserGroupMbrAttrImplTest {

    @Autowired
    private IUserGroupMbrAttr iUserGroupMbrAttr;

    private UserGroupMbrAttr userGroupMbrAttr;

    @Before
    public void setUp() throws Exception {
        userGroupMbrAttr = new UserGroupMbrAttr();
    }

    @After
    public void tearDown() throws Exception {
        userGroupMbrAttr = null;
    }

    @Test
    public void create() {
        userGroupMbrAttr.setUpdateType("A");
        userGroupMbrAttr.setUpdateAccept(12L);
        userGroupMbrAttr.setUpdateCode("12");
        userGroupMbrAttr.setUpdateDate(12);
        userGroupMbrAttr.setUpdateLogin("12");
        userGroupMbrAttr.setUpdateTime(new Date());
        userGroupMbrAttr.setAttrId("qq");
        userGroupMbrAttr.setAttrNo("33");
        userGroupMbrAttr.setAttrValue("333");
        userGroupMbrAttr.setEffDate(new Date());
        userGroupMbrAttr.setExpDate(new Date());
        userGroupMbrAttr.setFinishFlag("Y");
        userGroupMbrAttr.setGrpNo("222");
        userGroupMbrAttr.setLoginAccept(22L);
        userGroupMbrAttr.setLoginNo("22");
        userGroupMbrAttr.setMemberId(BigDecimal.valueOf(22));
        userGroupMbrAttr.setOpCode("332");
        userGroupMbrAttr.setOpTime(new Date());

        iUserGroupMbrAttr.create(userGroupMbrAttr);
    }

    @Test
    public void drop() {
        userGroupMbrAttr.setUpdateType("D");
        userGroupMbrAttr.setUpdateAccept(12L);
        userGroupMbrAttr.setUpdateCode("12");
        userGroupMbrAttr.setUpdateDate(12);
        userGroupMbrAttr.setUpdateLogin("12");
        userGroupMbrAttr.setUpdateTime(DateUtil.toDate("2019-03-22 21:52:02","YYYY-MM-dd HH:mm:ss"));
        userGroupMbrAttr.setAttrId("qq");
        userGroupMbrAttr.setAttrNo("33");
        userGroupMbrAttr.setEffDate(DateUtil.toDate("2019-03-22 21:52:02","YYYY-MM-dd HH:mm:ss"));
        userGroupMbrAttr.setMemberId(BigDecimal.valueOf(22));

        iUserGroupMbrAttr.drop(userGroupMbrAttr);
    }

    @Test
    public void modify() {
        userGroupMbrAttr.setUpdateType("U");
        userGroupMbrAttr.setUpdateAccept(12L);
        userGroupMbrAttr.setUpdateCode("12");
        userGroupMbrAttr.setUpdateDate(12);
        userGroupMbrAttr.setUpdateLogin("12");
        userGroupMbrAttr.setUpdateTime(DateUtil.toDate("2019-03-22 21:52:02","YYYY-MM-dd HH:mm:ss"));
        userGroupMbrAttr.setAttrId("qq");
        userGroupMbrAttr.setAttrNo("33");
        userGroupMbrAttr.setAttrValue("333");
        userGroupMbrAttr.setEffDate(DateUtil.toDate("2019-03-22 21:52:02","YYYY-MM-dd HH:mm:ss"));
        userGroupMbrAttr.setExpDate(new Date());
        userGroupMbrAttr.setFinishFlag("Y");
        userGroupMbrAttr.setGrpNo("222");
        userGroupMbrAttr.setLoginAccept(22L);
        userGroupMbrAttr.setLoginNo("22");
        userGroupMbrAttr.setMemberId(BigDecimal.valueOf(22));
        userGroupMbrAttr.setOpCode("332");
        userGroupMbrAttr.setOpTime(new Date());

        iUserGroupMbrAttr.modify(userGroupMbrAttr);
    }

    @Test
    public void query() {
        userGroupMbrAttr.setAttrId("qq");
        userGroupMbrAttr.setAttrNo("33");
        userGroupMbrAttr.setEffDate(DateUtil.toDate("2019-03-22 21:52:02","YYYY-MM-dd HH:mm:ss"));
        userGroupMbrAttr.setMemberId(BigDecimal.valueOf(22));

        iUserGroupMbrAttr.query(userGroupMbrAttr.getMemberId(),userGroupMbrAttr.getAttrId(),userGroupMbrAttr.getEffDate(),userGroupMbrAttr.getAttrNo());
    }

    @Test
    public void qryUserGroupMbrList() {
        Map<String,Object> map = new HashMap<>();
        map.put("attrId","qq");
        map.put("attrNo",33);

        iUserGroupMbrAttr.qryUserGroupMbrAttrList(map);
    }

    @Test
    public void qryUserGroupMbrHisList() {
        Map<String,Object> map = new HashMap<>();
        map.put("attrId","qq");
        map.put("attrNo",33);

        iUserGroupMbrAttr.qryUserGroupMbrAttrList(map);
    }
}