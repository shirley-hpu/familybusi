package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.daoimpl.user.IUserDetail;
import com.sitech.family.custservice.dto.mapperdto.UserDetail;
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
 * @date 2019/3/22 13:39
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDetailImplTest {

    @Autowired
    private IUserDetail iUserDetail;

    private UserDetail userDetail;

    @Before
    public void setUp() throws Exception {
        userDetail = new UserDetail();
    }

    @After
    public void tearDown() throws Exception {
        userDetail = null;
    }

    @Test
    public void create() {
        userDetail.setUpdateType("A");
        userDetail.setUpdateAccept(12L);
        userDetail.setUpdateCode("12");
        userDetail.setUpdateDate(12);
        userDetail.setUpdateLogin("12");
        userDetail.setUpdateTime(new Date());
        userDetail.setIdNo(26L);
        userDetail.setVipCreateType(33);
        userDetail.setVipCardNo("26");
        userDetail.setUserPasswd("26");
        userDetail.setUserGradeCode("24");
        userDetail.setSystemNote("222");
        userDetail.setStopFlag("Y");
        userDetail.setRunTime(new Date());
        userDetail.setRunCode("11");
        userDetail.setQueryCdrflag("Y");
        userDetail.setPasswdType("2");
        userDetail.setOwedFlag("Y");
        userDetail.setOpTime(new Date());
        userDetail.setOpNote("22");
        userDetail.setOpCode("22");
        userDetail.setOldRun("22");
        userDetail.setLoginNo("22");
        userDetail.setLoginAccept(26L);
        userDetail.setLmtAdjustType("22");
        userDetail.setCardType(22L);
        userDetail.setBak2("22");
        userDetail.setBak1("22");

        iUserDetail.create(userDetail);
    }

    @Test
    public void drop() {
        userDetail.setIdNo(26L);
        userDetail.setUpdateType("D");
        userDetail.setUpdateAccept(12L);
        userDetail.setUpdateCode("12");
        userDetail.setUpdateDate(12);
        userDetail.setUpdateLogin("12");
        userDetail.setUpdateTime(new Date());

        iUserDetail.drop(userDetail);
    }

    @Test
    public void modify() {
        userDetail.setUpdateType("U");
        userDetail.setUpdateAccept(126L);
        userDetail.setUpdateCode("12");
        userDetail.setUpdateDate(12);
        userDetail.setUpdateLogin("12");
        userDetail.setUpdateTime(new Date());
        userDetail.setIdNo(26L);
        userDetail.setVipCreateType(33);
        userDetail.setVipCardNo("26");
        userDetail.setUserPasswd("26");
        userDetail.setUserGradeCode("24");
        userDetail.setSystemNote("222");
        userDetail.setStopFlag("Y");
        userDetail.setRunTime(new Date());
        userDetail.setRunCode("11");
        userDetail.setQueryCdrflag("Y");
        userDetail.setPasswdType("2");
        userDetail.setOwedFlag("Y");
        userDetail.setOpTime(new Date());
        userDetail.setOpNote("22");
        userDetail.setOpCode("22");
        userDetail.setOldRun("22");
        userDetail.setLoginNo("22");
        userDetail.setLoginAccept(26L);
        userDetail.setLmtAdjustType("22");
        userDetail.setCardType(292L);
        userDetail.setBak2("22");
        userDetail.setBak1("22");

        iUserDetail.modify(userDetail);
    }

    @Test
    public void query() {
        userDetail.setIdNo(26L);

        iUserDetail.query(userDetail.getIdNo());
    }

    @Test
    public void qryUserDetailList() {
        Map<String,Object> map = new HashMap<>();
        map.put("idNo",26L);

        iUserDetail.qryUserDetailList(map);
    }

    @Test
    public void qryUserDetailHisList() {
        Map<String,Object> map = new HashMap<>();
        map.put("idNo",26L);

        iUserDetail.qryUserDetailHisList(map);
    }
}