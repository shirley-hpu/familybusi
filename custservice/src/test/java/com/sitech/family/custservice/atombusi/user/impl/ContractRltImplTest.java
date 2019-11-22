package com.sitech.family.custservice.atombusi.user.impl;

import com.sitech.family.custservice.daoimpl.user.IContractRlt;
import com.sitech.family.custservice.dto.mapperdto.AccountRel;
import com.sitech.family.dao.account.IAccountRelInfoDao;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.account.AccountRelInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;


@SpringBootTest
@RunWith(SpringRunner.class)
public class ContractRltImplTest {

    private static final Logger logger = LoggerFactory.getLogger(ContractRltImplTest.class);

    @Autowired
    private IContractRlt contractRlt;

    private AccountRelInfo accountRelHis;

    private AccountRel accountRel;

    @Autowired
    private IAccountRelInfoDao accountRelInfoDao;

    @Before
    public void setUp() throws Exception {
        logger.debug("***** test before 初始化对象*****");
        accountRelHis = new AccountRelInfo();
        accountRelHis.setServAcctId(12000L);
        accountRelHis.setLoginAccept(14086L);
        accountRelHis.setContractNo(20000L);  //分片主键  不允许修改
        accountRelHis.setRelContractNo(6666L);
        accountRelHis.setAcctRelType("1");
        accountRelHis.setAcctItems("test2");
        accountRelHis.setPayValue(7777.00);
        //accountRelHis.setPayPri(8888);
        accountRelHis.setEffDate(new Date());
        accountRelHis.setExpDate(new Date());
        accountRelHis.setLoginNo("123456");
        accountRelHis.setOpTime(new Date());



        accountRel = new AccountRel();
        accountRel.setServAcctId(10000L);
    }

    @After
    public void tearDown() throws Exception {
        logger.debug("***** test after 销毁对象*****");
        accountRelHis = null;
        accountRel = null;
    }


    @Test
    public void create() {
        ReturnDto result = accountRelInfoDao.create(accountRelHis);
        logger.debug("***** result ==> " + result);

    }

    @Test
    public void drop() {
    //    AccountRel accountRel = contractRlt.qry(accountRelHis);
   //     accountRelHis = new AccountRelHis(accountRel);

   //     ReturnDto result = contractRlt.drop( accountRelHis);
   //     logger.debug("***** result ==> " + result);

    }

    @Test
    public void modify() {
        accountRelHis.setServAcctId(10000L);

        accountRelHis.setLoginAccept(10001L);


   //     ReturnDto result = contractRlt.modify(accountRelHis);
   //     logger.debug("***** result ==> " + result);

    }

    @Test
    public void qry() {
   //     AccountRel accountRel = contractRlt.qry(accountRelHis);
   //     logger.debug("***** accountRel ==> " + accountRel);
    }

    @Test
    public void qryContractRltHisList() {
   //     List<AccountRelHis> list = contractRlt.qryContractRltHisList(accountRelHis);
   //     logger.debug("***** list ==> " + list);
    }


}