package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.daoimpl.user.IServiceNo;
import com.sitech.family.custservice.dto.mapperdto.ServiceNo;
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
public class ServiceNoAoTest {

    @Autowired
    private IServiceNo iServiceNoAo;

    private ServiceNo no;

    @Before
    public void setUp() throws Exception {
        no = new ServiceNo();
    }

    @After
    public void tearDown() throws Exception {
        no = null;
    }

    @Test
    public void create() {
        no.setFinishFlag("Y");
        no.setIdNo(12L);
        no.setLoginAccept(12L);
        no.setLoginNo("126");
        no.setMasterServId("127");
        no.setOpCode("127");
        no.setOpTime(new Date());
        no.setServiceNo("128");
        no.setServiceType("Y");
        no.setUpdateType("A");
        no.setUpdateAccept(123L);
        no.setUpdateTime(new Date());
        no.setUpdateDate(122);

        iServiceNoAo.create(no);
    }

    @Test
    public void modify() {
        no.setFinishFlag("N");
        no.setIdNo(12L);
        no.setLoginAccept(122L);
        no.setLoginNo("127");
        no.setMasterServId("127");
        no.setOpCode("126");
        no.setOpTime(new Date());
        no.setServiceNo("128");
        no.setServiceType("Y");
        no.setUpdateAccept(123L);
        no.setUpdateTime(new Date());
        no.setUpdateDate(122);
        no.setUpdateType("U");

        iServiceNoAo.modify(no);
    }

    @Test
    public void delete() {
        no.setServiceType("Y");
        no.setServiceNo("128");
        no.setIdNo(12L);
        no.setUpdateAccept(123L);
        no.setUpdateTime(new Date());
        no.setUpdateDate(122);
        no.setUpdateType("D");

        iServiceNoAo.drop(no);
    }

    @Test
    public void query() {
        no.setServiceType("Y");
        no.setServiceNo("128");
        no.setIdNo(12L);

        iServiceNoAo.query(no.getIdNo(),no.getServiceNo(),no.getServiceType());
    }

    @Test
    public void qryServiceNoList() {
        Map<String,Object> map = new HashMap<>();
        map.put("idNo",12L);

        iServiceNoAo.qryServiceNoList(map);
    }

    @Test
    public void qryServiceNoHisList() {
        Map<String,Object> map = new HashMap<>();
        map.put("idNo",12L);

        iServiceNoAo.qryServiceNoHisList(map);
    }
}