package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.base.util.Constants;
import com.sitech.family.custservice.base.util.DateConst;
import com.sitech.family.custservice.base.util.StringUtils;
import com.sitech.family.custservice.dto.mapperdto.UserDetail;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author Zhangc
 * @version 1.0
 * @date 2019/3/16 11:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDetailTest {

    @Resource
    private UserDetailMapper userDetailMapper;
    @Resource
    private UserDetailHisMapper userDetailHisMapper;

    @Before
    public void init() {
        System.out.println("开始测试-----------------");
    }

    @After
    public void after() {
        System.out.println("测试结束-----------------");
    }

    @Test
    public void test(){
        UserDetail userDetail = new UserDetail();
        userDetail.setIdNo(StringUtils.castToLong("2019051500001"));
        userDetail.setRunCode("A");
        userDetail.setRunTime(new Date());
        userDetail.setUserGradeCode("1");
        userDetail.setStopFlag("N");
        userDetail.setOwedFlag("N");
        userDetail.setUserPasswd("123456");
        userDetail.setPasswdType("1");
        userDetail.setCardType(StringUtils.castToLong("100"));
        userDetail.setVipCardNo("11020190316");
        userDetail.setVipCreateType(1);
        userDetail.setOldRun("A");
        userDetail.setQueryCdrflag("Y");
        userDetail.setLmtAdjustType("a");
        userDetail.setOpTime(new Date());
        userDetail.setLoginNo("1111");
        userDetail.setLoginAccept(StringUtils.castToLong("201903161201"));
        userDetail.setOpCode("001");
        userDetail.setOpNote("op");
        userDetail.setSystemNote("sys");
        userDetail.setBak1("");
        userDetail.setBak2("");
        userDetailMapper.insert(userDetail);
        userDetail.setUpdateTime(new Date());
        userDetail.setUpdateAccept(userDetail.getLoginAccept());
        userDetail.setUpdateType(Constants.Entity.UPDATE_TYPE_INSERT);
        userDetail.setUpdateDate(DateConst.getUpdateDate(new Date(),DateConst.DATE_MODEL_11));
        userDetail.setUpdateLogin(userDetail.getLoginNo());
        userDetail.setUpdateCode(userDetail.getOpCode());
        userDetailHisMapper.insert(userDetail);
    }
}
