package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.daoimpl.user.IUser;
import com.sitech.family.custservice.dto.mapperdto.User;
import com.sitech.ijcf.boot.core.util.DateUtil;
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
 * @date 2018/12/21 18:10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserAoTest {

    @Autowired
    private IUser iUserAo;

    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User();
    }

    @After
    public void tearDown() throws Exception {
        user = null;
    }

    @Test
    public void create() {
        user.setAccessType("Y");
        user.setAssureFlag("Y");
        user.setBakField("1");
        user.setBakField1("2");
        user.setBillEndTime(DateUtil.toDate("2099-12-31 12:12:12","YYYY-MM-dd HH:mm:ss"));

        user.setBillStartTime(new Date());
        user.setBillType(122);user.setBillingCycleTypeId(122L);
        user.setBrandCreateType("Y");
        user.setCmdRight(122L);
        user.setCompletedDate(new Date());
        user.setContractNo(122L);
        user.setCreateDate(new Date());
        user.setCreateLogin("126");
        user.setCustId(122L);
        user.setEmpGroup("122");
        user.setEmpId("122");
        user.setFinishFlag("Y");
        user.setFirstUsedate(new Date());
        user.setGroupFlag("Y");
        user.setGroupId("122");
        user.setIdNo(122L);
        user.setLoginAccept(122L);
        user.setLoginNo("122");
        user.setMasterServId("122");
        user.setOpCode("122");
        user.setOpenTime(new Date());
        user.setOwnedChnlId("122");
        user.setOpTime(new Date());
        user.setOwnerType(1222);
        user.setPhoneNo("188");
        user.setPhotoFlag("Y");
        user.setRentDate(new Date());
        user.setServiceGroup("122");
        user.setStopRentDate(DateUtil.toDate("2099-12-31 12:12:12","YYYY-MM-dd HH:mm:ss"));
        user.setUpdateType("A");
        user.setUpdateAccept(126L);

        iUserAo.create(user);
    }

    @Test
    public void modify() {
        user.setAccessType("Y");
        user.setAssureFlag("Y");
        user.setBakField("1");
        user.setBakField1("2");
        user.setBillEndTime(DateUtil.toDate("2099-12-31 12:12:12","YYYY-MM-dd HH:mm:ss"));
        user.setBillingCycleTypeId(132L);
        user.setBillStartTime(new Date());
        user.setBillType(132);
        user.setBrandCreateType("Y");
        user.setCmdRight(132L);
        user.setCompletedDate(new Date());
        user.setContractNo(132L);
        user.setCreateDate(new Date());
        user.setCreateLogin("126");
        user.setCustId(132L);
        user.setEmpGroup("132");
        user.setEmpId("132");
        user.setFinishFlag("Y");
        user.setFirstUsedate(new Date());
        user.setGroupFlag("Y");
        user.setGroupId("122");
        user.setIdNo(122L);
        user.setLoginAccept(132L);
        user.setLoginNo("122");
        user.setMasterServId("122");
        user.setOpCode("122");
        user.setOpenTime(new Date());
        user.setOwnedChnlId("122");
        user.setOpTime(new Date());
        user.setOwnerType(132);
        user.setPhoneNo("132");
        user.setPhotoFlag("Y");
        user.setRentDate(new Date());
        user.setServiceGroup("122");
        user.setStopRentDate(DateUtil.toDate("2099-12-31 12:12:12","YYYY-MM-dd HH:mm:ss"));
        user.setUpdateType("U");
        user.setUpdateAccept(126L);

        iUserAo.modify(user);
    }

    @Test
    public void delete() {
        user.setIdNo(122L);
        user.setUpdateType("D");
        user.setUpdateAccept(126L);

        iUserAo.drop(user);
    }

    @Test
    public void query() {
        user.setIdNo(122L);

        iUserAo.query(user.getIdNo());
    }

    @Test
    public void qryUserList() {
        Map<String,Object> map = new HashMap<>();
        map.put("idNo",122L);

        iUserAo.qryUserList(map);
    }

    @Test
    public void qryUserHisList() {
        Map<String,Object> map = new HashMap<>();
        map.put("idNo",122L);

        iUserAo.qryUserHisList(map);
    }
}