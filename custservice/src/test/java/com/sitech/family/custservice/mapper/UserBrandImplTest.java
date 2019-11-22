package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.daoimpl.user.IUserBrand;
import com.sitech.family.custservice.dto.mapperdto.UserBrand;
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
 * @date 2019/3/22 13:39
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserBrandImplTest {

    @Autowired
    private IUserBrand iUserBrand;

    private UserBrand userBrand;

    @Before
    public void setUp() throws Exception {
        userBrand = new UserBrand();
    }

    @After
    public void tearDown() throws Exception {
        userBrand = null;
    }

    @Test
    public void create() {
        userBrand.setUpdateType("A");
        userBrand.setUpdateAccept(12L);
        userBrand.setUpdateCode("12");
        userBrand.setUpdateDate(12);
        userBrand.setUpdateLogin("12");
        userBrand.setUpdateTime(new Date());
        userBrand.setBrandId("23");
        userBrand.setEffDate(new Date());
        userBrand.setExpDate(new Date());
        userBrand.setFinishFlag("Y");
        userBrand.setIdNo(26L);
        userBrand.setLoginAccept(26L);
        userBrand.setLoginNo("26");
        userBrand.setOpCode("23");
        userBrand.setOpTime(new Date());

        iUserBrand.create(userBrand);
    }

    @Test
    public void modify() {
        userBrand.setUpdateType("U");
        userBrand.setUpdateAccept(12L);
        userBrand.setUpdateCode("12");
        userBrand.setUpdateDate(12);
        userBrand.setUpdateLogin("12");
        userBrand.setUpdateTime(new Date());
        userBrand.setBrandId("23");
        userBrand.setEffDate(new Date());
        userBrand.setExpDate(new Date());
        userBrand.setFinishFlag("Y");
        userBrand.setIdNo(26L);
        userBrand.setLoginAccept(26L);
        userBrand.setLoginNo("26");
        userBrand.setOpCode("23");
        userBrand.setOpTime(new Date());

        iUserBrand.modify(userBrand);
    }

    @Test
    public void drop() {
        userBrand.setUpdateType("U");
        userBrand.setUpdateAccept(12L);
        userBrand.setUpdateCode("12");
        userBrand.setUpdateDate(12);
        userBrand.setUpdateLogin("12");
        userBrand.setUpdateTime(new Date());
        userBrand.setBrandId("23");
        userBrand.setEffDate(DateUtil.toDate("2019-03-22 19:35:57","YYYY-MM-dd HH:mm:ss"));
        userBrand.setExpDate(new Date());
        userBrand.setFinishFlag("Y");
        userBrand.setIdNo(26L);
        userBrand.setLoginAccept(26L);
        userBrand.setLoginNo("26");
        userBrand.setOpCode("23");
        userBrand.setOpTime(new Date());

        iUserBrand.drop(userBrand);
    }

    @Test
    public void query() {
        userBrand.setBrandId("23");
        userBrand.setEffDate(DateUtil.toDate("2019-03-22 19:35:57","YYYY-MM-dd HH:mm:ss"));
        userBrand.setIdNo(26L);

        iUserBrand.query(userBrand.getIdNo(),userBrand.getBrandId(),userBrand.getEffDate());
    }

    @Test
    public void qryUserBrandRelList() {
        Map<String,Object> map = new HashMap<>();
        map.put("idNo",26L);
        map.put("brandId",23);

        iUserBrand.qryUserBrandRelList(map);

    }

    @Test
    public void qryUserBrandRelHisList() {
        Map<String,Object> map = new HashMap<>();
        map.put("idNo",26L);
        map.put("brandId",23);

        iUserBrand.qryUserBrandRelHisList(map);
    }
}