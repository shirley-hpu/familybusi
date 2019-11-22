package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.daoimpl.user.IUserGroup;
import com.sitech.family.custservice.dto.mapperdto.UserGroup;
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
 * @date 2018/12/21 18:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserGroupAoTest {

    @Autowired
    private IUserGroup iUserGroupAo;

    private UserGroup userGroup;

    @Before
    public void setUp() throws Exception {
        userGroup = new UserGroup();
    }

    @After
    public void tearDown() throws Exception {
        userGroup = null;
    }

    @Test
    public void create() {
        userGroup.setEffDate(new Date());
        userGroup.setExpDate(DateUtil.toDate("2099-12-31 12:12:12","YYYY-MM-dd HH:mm:ss"));
        userGroup.setFinishFlag("Y");
        userGroup.setGroupCode("122");
        userGroup.setGroupDesc("122");
        userGroup.setGroupId(BigDecimal.valueOf(122));
        userGroup.setGroupName("122");
        userGroup.setGroupType("122");
        userGroup.setIdNo(1231232L);
        userGroup.setLockFlag("Y");
        userGroup.setLoginAccept(231L);
        userGroup.setLoginNo("122");
        userGroup.setOpCode("122");
        userGroup.setOpTime(new Date());
        userGroup.setState("Y");
        userGroup.setStateDate(new Date());
        userGroup.setUpdateType("A");
        userGroup.setUpdateAccept(126L);

        iUserGroupAo.create(userGroup);

    }

    @Test
    public void modify() {
        userGroup.setEffDate(new Date());
        userGroup.setExpDate(DateUtil.toDate("2099-12-31 12:12:12","YYYY-MM-dd HH:mm:ss"));
        userGroup.setFinishFlag("Y");
        userGroup.setGroupCode("126");
        userGroup.setGroupDesc("126");
        userGroup.setGroupId(BigDecimal.valueOf(122));
        userGroup.setGroupName("126");
        userGroup.setGroupType("126");
        userGroup.setIdNo(1233212L);
        userGroup.setLockFlag("Y");
        userGroup.setLoginAccept(1123L);
        userGroup.setLoginNo("122");
        userGroup.setOpCode("122");
        userGroup.setOpTime(new Date());
        userGroup.setState("Y");
        userGroup.setStateDate(new Date());
        userGroup.setUpdateType("U");
        userGroup.setUpdateAccept(126L);

        iUserGroupAo.modify(userGroup);
    }

    @Test
    public void delete() {
        userGroup.setGroupId(BigDecimal.valueOf(122));
        userGroup.setUpdateType("D");
        userGroup.setUpdateAccept(126L);

        iUserGroupAo.drop(userGroup);
    }

    @Test
    public void query() {
        userGroup.setGroupId(BigDecimal.valueOf(122));

        iUserGroupAo.query(userGroup.getGroupId());
    }

    @Test
    public void qryUserGroupList() {
        Map<String,Object> map = new HashMap<>();
        map.put("groupId",122);

        iUserGroupAo.qryUserGroupList(map);
    }

    @Test
    public void qryUserGroupHisList() {
        Map<String,Object> map = new HashMap<>();
        map.put("groupId",122);

        iUserGroupAo.qryUserGroupHisList(map);
    }
}