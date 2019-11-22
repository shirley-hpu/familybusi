package com.sitech.family.compservice.atombiz.impl;

import com.alibaba.fastjson.JSONObject;
import com.sitech.family.common.JsonReader;
import com.sitech.family.common.dto.OprInfo;
import com.sitech.family.compservice.atombiz.IUserInfoQryAo;
import com.sitech.family.compservice.dto.indto.UserInfoQryInDto;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.service.client.IServiceClient;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.ijcf.message6.dt.support.MBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author guanqp
 * @Description  用户基本信息查询
 * @date 2019/01/15
 */
@Component("UserInfoQryAoSvc")
public class UserInfoQryAoSvc implements IUserInfoQryAo {

    private static Logger logger = LoggerFactory.getLogger(UserInfoQryAoSvc.class);

    @Resource
    private IServiceClient serviceClient;

    @Value(value= "classpath:jsonfiles/userinfo")
    private org.springframework.core.io.Resource resource;

    @Resource
    private JsonReader jsonReader;

    @Override
    public OutDTO userInfoQry(UserInfoQryInDto requestMessage, OprInfo requestMessage1) {
        MBean mBean = new MBean();
        OutDTO outDTO = new OutDTO<>();
//        ParameterizedTypeReference inpara = new ParameterizedTypeReference<OutDTO<UserInfoOutDto>>(){};
//        String outParam = "";
        try {
            /**
             * 拼接查询参数节点下的信息
             */
            Map<String, Object> busiInfo = new HashMap<>();

            busiInfo.put("PHONE_NO", requestMessage.getPhoneNo());
            busiInfo.put("MASTER_SERV_ID", requestMessage.getMasterServId());

            Map<String, Object> oprInfo = new HashMap<>();

            oprInfo.put("CONTACT_ID",requestMessage1.getContactId());
            oprInfo.put("REGION_ID",requestMessage1.getRegionId());
            oprInfo.put("LOGIN_NO",requestMessage1.getLoginNo());
            oprInfo.put("OP_CODE",requestMessage1.getOpCode());
            oprInfo.put("OP_NOTE",requestMessage1.getOpNote());
            oprInfo.put("CHANNEL_TYPE",requestMessage1.getChannelType());
            oprInfo.put("APPLY_ID",requestMessage1.getApplyId());


            mBean.addBody("BUSI_INFO", busiInfo);
            mBean.addBody("OPR_INFO", oprInfo);

          /* OutDTO<UserInfoOutDto> mapOutDTO = serviceClient.callService("com_sitech_ordersvc_common_atom_inter_IUserInfoAoSvc_qryBaseInfo",
                    mBean.toString(), inpara);

            logger.info("mapOutDTO=", mapOutDTO);

            outDTO.setBodyOutData(mapOutDTO);*/

            //做测试数据
           /* UserInfoOutDto outlist = new UserInfoOutDto();
            UserInfo userInfo = new UserInfo();

            userInfo.setBillDay("2019-01-15 09:58:51");
            userInfo.setBillEndTime("2019-01-15 09:58:51");
            userInfo.setBillingMode("月付");
            userInfo.setBrandId("1000001");
            userInfo.setBrandName("全家桶套餐，一人付费全家享受");
            userInfo.setCadeType("vip");
            userInfo.setContraceNo("10001");
            userInfo.setCustId("11111");
            userInfo.setGroupId("北京市海淀区");
            userInfo.setIdNo("11");
            userInfo.setMasterServId("宽带");
            userInfo.setOpenTime("2019-01-15 09:58:51");
            userInfo.setOwnerType("家庭");
            userInfo.setPhoneNo("13878379233");
            userInfo.setRunCode("正常");
            userInfo.setRunName("测试数据");
            userInfo.setRunTime("2019-01-15 09:58:51");

            outlist.setUserInfo(userInfo);
            outDTO.setBodyOutData(outlist);*/
            String result = jsonReader.parseJson(resource);

            JSONObject jsonObject = JSONObject.parseObject(result);

            jsonObject = jsonObject.getJSONObject("ROOT").getJSONObject("BODY").
                    getJSONObject("OUT_DATA").getJSONObject("USER_INFO");

            jsonObject.put("ON_PHONE_NUM","1");
            jsonObject.put("ON_BROADBAND_NUM","1");
            logger.debug("++++++++++++++"+jsonObject);


            Map<String,JSONObject> outdata = new HashMap<>();
            outdata.put("USER_INFO",jsonObject);

            outDTO.setBodyOutData(outdata);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusiException(getErrorCode("1000", "160051","调用用户基本信息查询接口错误" ), e);
        }

        return outDTO;
    }
}