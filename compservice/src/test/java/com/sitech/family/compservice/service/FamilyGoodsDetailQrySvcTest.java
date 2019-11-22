package com.sitech.family.compservice.service;

import com.sitech.crmcui.common.sequence.autoconfigure.SequenceClientProperties;
import com.sitech.crmcui.common.sequence.client.SequenceClient;
import com.sitech.family.common.dto.OprInfo;
import com.sitech.family.common.dto.RequestMessage;
import com.sitech.family.compservice.atombiz.impl.HotPrcQryAo;
import com.sitech.family.compservice.dto.indto.DetailGoodsInfo;
import com.sitech.family.compservice.dto.indto.FamilyGoodsDetailQry;
import com.sitech.family.compservice.dto.indto.FamilyGoodsMbrQry;
import com.sitech.family.compservice.dto.indto.MbrGoodsInfo;
import com.sitech.family.compservice.inter.IFamilyGoodsQryCoSvc;
import com.sitech.ijcf.boot.core.service.client.IServiceClient;
import com.sitech.ijcf.boot.core.util.SpringUtil;
import com.sitech.ijcf.message6.dt.Header;
import com.sitech.ijcf.message6.dt.Routing;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import org.I0Itec.zkclient.ZkClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class FamilyGoodsDetailQrySvcTest {

    private static final Logger logger = LoggerFactory.getLogger(FamilyGoodsDetailQrySvcTest.class);

    @Autowired
    IFamilyGoodsQryCoSvc familyGoodsDetailQrySvc;

//    @Autowired
//    @Qualifier(value = "remoteRestTemplate")
//    RestTemplate restTemplate;

    @Bean(name = "remoteRestTemplate")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    RestTemplate restTemplate = restTemplate();


    InDTO<RequestMessage<FamilyGoodsMbrQry>> requestMessage;
    Header header;
    Routing routing;
    OprInfo oprInfoDto;
    RequestMessage<FamilyGoodsMbrQry> familyGoodsDetailQryInDto;
    FamilyGoodsMbrQry busiInfoDto;
    MbrGoodsInfo familyGoodsInfoDto;
    OutDTO<Object> outDTO = null;

//    @Before
    public void setUp() throws Exception {
        logger.debug("***** test before 初始化对象*****");
        requestMessage = new InDTO<>();
        //1、header节点
        header = new Header();
        header.setChannelId("11");
        routing = new Routing();
        routing.setRouteKey("11");
        routing.setRouteValue("231221100000127259");
        header.setRouting(routing);

        requestMessage.getBodyHeader().setHeader(header);

        //2、body节点
        //2.1 oprInfo
        familyGoodsDetailQryInDto = new RequestMessage<FamilyGoodsMbrQry>();

        oprInfoDto = new OprInfo();
        oprInfoDto.setApplyId("si-tech");
        oprInfoDto.setRegionId("11");
        oprInfoDto.setLoginNo("aheb01");
        oprInfoDto.setChannelType("11");
        oprInfoDto.setOpCode("1090");
        oprInfoDto.setContactId("11201809110000001");
        oprInfoDto.setGroupId("12");
        oprInfoDto.setOpNote("调用接口");
        familyGoodsDetailQryInDto.setOprInfo(oprInfoDto);

        familyGoodsInfoDto = new MbrGoodsInfo();
        familyGoodsInfoDto.setGoodsId("101");
        //2.2 busiInfo
        busiInfoDto = new FamilyGoodsMbrQry();
        busiInfoDto.setFamilyGoodsInfo(familyGoodsInfoDto);
        familyGoodsDetailQryInDto.setBusiInfo(busiInfoDto);
        //2.3
        requestMessage.getBodyHeader().setBody(familyGoodsDetailQryInDto);
    }

//    @After
    public void tearDown() throws Exception {
        logger.debug("***** test after 销毁对象*****");
        requestMessage = null;
        header = null;
        routing = null;
        oprInfoDto = null;
        familyGoodsDetailQryInDto = null;
        busiInfoDto = null;
        familyGoodsInfoDto = null;
    }

    /**
     * 直接调用本地服务测试
     */
    @Test
    public void sFamilyGoodsDetailQry() {
//        logger.debug("***** local test begin *****");
//        logger.debug("\ntest inDto " + JSON.toJSONString(requestMessage));
//        //调用测试方法
//        outDTO = familyGoodsDetailQrySvc.sFamilyGoodsDetailQry(requestMessage);
//        //打印出参json报文
//        logger.debug("\ntest outDto " + outDTO.toJsonString());
//        logger.debug("\n***** local test end *****");

    }

    /**
     * spring提供的模板RestTemplate请求URL
     * 测试环境服务测试
     */
    @Test
    public void testPost() {
//        logger.debug("***** restTemplate test begin *****");
//        logger.debug("\ntest inDto " + JSON.toJSONString(requestMessage));
//        //spring模板调用测试环境服务
//        Object object = restTemplate.postForEntity
//                ("http://172.21.11.187:9090/comp/sFamilyGoodsDetailQry", requestMessage, Object.class);
//
//        logger.debug("\ntest outDto " + object);
//        logger.debug("\n***** restTemplate test end *****");
    }

    @Test
    public void test() {
        logger.debug("\n***** restTemplate test end *****");
    }

    @Test
    public void testHotPrcQryAo(){

        DetailGoodsInfo goodsInfo = new DetailGoodsInfo();
        goodsInfo.setPrcId("M030724");
        goodsInfo.setMemberRoleId("50002");
        FamilyGoodsDetailQry  familyGoodsDetailQry = new FamilyGoodsDetailQry();
        familyGoodsDetailQry.setDetailGoodsInfo(goodsInfo);

        Map<String,Object> map = new HashMap<>();

        map.put("HEADER",new Header());
        map.put("OPR_INFO",new OprInfo());
        map.put("BUSI_INFO",familyGoodsDetailQry);

        HotPrcQryAo hotPrcQryAo = new HotPrcQryAo();
        Map outMap = hotPrcQryAo.query(map);
        System.out.println("+++++++++++++++++++++"+outMap);
    }


}