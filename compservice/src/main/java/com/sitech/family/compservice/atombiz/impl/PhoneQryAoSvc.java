package com.sitech.family.compservice.atombiz.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sitech.family.common.JsonReader;
import com.sitech.family.common.dto.OprInfo;
import com.sitech.family.common.util.PackHeaderOprInfo;
import com.sitech.family.compservice.atombiz.IPhoneQryAo;
import com.sitech.family.compservice.dto.indto.PhoneQryInDto;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.service.client.IServiceClient;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.ijcf.message6.dt.support.MBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * Created by xuwei on 2018/12/14.
 */

@Component("PhoneQryAoSvc")
public class PhoneQryAoSvc implements IPhoneQryAo {

    private static Logger logger = LoggerFactory.getLogger(PhoneQryAoSvc.class);

    @Resource
    private IServiceClient serviceClient;
    @Value(value= "classpath:jsonfiles/phoneNo")
    private org.springframework.core.io.Resource resPhoneNo;
    @Value(value= "classpath:jsonfiles/telephoneNo")
    private org.springframework.core.io.Resource resourceTelePhoneNo;
    @Value(value="classpath:jsonfiles/simCardNo")
    private org.springframework.core.io.Resource resourceSimCardNo;
    @Autowired
    private JsonReader jsonReader;
    @Override
    public Map<String,Object> query(Map<String, Object> map) {

        OutDTO<Map> outDTO = new OutDTO<>();
        Map<String,Object> outMap = new HashMap<String,Object>();

        try {
            /**
             * 拼接查询参数节点下的信息
             */
            MBean mBean = PackHeaderOprInfo.packHeaderOprInfo(map);
            PhoneQryInDto phoneNoQuery = (PhoneQryInDto)map.get("BUSI_INFO");
            String groupId = phoneNoQuery.getGroupId();
            String maxNum  = phoneNoQuery.getMaxNum();
            String resCode = phoneNoQuery.getResCode();

            Map<String, Object> busiInfo = new HashMap<>();
            busiInfo.put("GROUP_ID",groupId);
            busiInfo.put("MAX_NUM",maxNum);
            busiInfo.put("RES_CODE",resCode);
            mBean.addBody("BUSI_INFO",busiInfo);

            /*outDTO = serviceClient.callService("com_sitech_pgmng_atom_inter_ISearchPgPrcAoSvc_searchPgPrc",
                    mBean.toString(), OutDTO.class);*/
            String result = "";
            if(resCode.equals("001")){
                result = jsonReader.parseJson(resPhoneNo);
            }else if(resCode.equals("002")){
                result = jsonReader.parseJson(resourceTelePhoneNo);
            }

            JSONObject jsonObject = JSONObject.parseObject(result);
            JSONArray outData = jsonObject.getJSONObject("ROOT").getJSONObject("BODY").
                    getJSONObject("OUT_DATA").getJSONArray("PHONENOINFOLIST");

            // 山西号码资源查询入参
            /*busiInfo.put("RES_OPR", "3");
            busiInfo.put("LOGIN_NO", "wwwwww");
            busiInfo.put("GROUP_ID", requestMessage.getGroupId());
            busiInfo.put("QUERY_FLAG", "4");
            busiInfo.put("OP_CODE", "1000");
            busiInfo.put("MAX_NUM", requestMessage.getMaxNum());
            busiInfo.put("MIN_COST_FEE", "0");
            busiInfo.put("NEED_ATTR", "Y");

            mBean.addBody("BUSI_INFO", busiInfo);*/
            if(resCode.equals("002")){
                JSONArray datalist = new JSONArray();
                List<Integer> list = new ArrayList<>();
                for(int i = 0;i<outData.size() && i < 6;i++){
                    int index = (int)Math.floor(outData.size()*Math.random());
                    if(!list.contains(index)){
                        datalist.add(outData.get(index));
                        list.add(index);
                    }else{
                        i = i-1;
                    }
                }
                logger.debug("============"+datalist);

                Map<String, Object> temp = new HashMap<>();
                temp.put("PHONENOINFOLIST", datalist);
                outDTO.setBodyOutData(outMap);
                return temp;
            }

            Map<String, Object> temp = new HashMap<>();
            temp.put("PHONENOINFOLIST", outData);
            outDTO.setBodyOutData(outMap);
            return temp;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusiException(getErrorCode("1000", "160020","调用资源接口错误" ), e);
        }
    }

    @Override
    public Map<String, Object> querySim(Map<String, Object> map) {
        OutDTO<Map> outDTO = new OutDTO<>();
        Map<String, Object> outMap = new HashMap<String, Object>();

        try {
            MBean mBean = PackHeaderOprInfo.packHeaderOprInfo(map);
            OprInfo oprInfo = (OprInfo) map.get("oprInfo");
            String groupId = oprInfo.getGroupId();

            Map<String, Object> busiInfo = new HashMap<>();
            busiInfo.put("GROUP_ID", groupId);
            mBean.addBody("BUSI_INFO", busiInfo);

            /*outDTO = serviceClient.callService("com_sitech_pgmng_atom_inter_ISearchPgPrcAoSvc_searchPgPrc",
                    mBean.toString(), OutDTO.class);*/
            String result = jsonReader.parseJson(resourceSimCardNo);

            JSONObject jsonObject = JSONObject.parseObject(result);
            JSONArray outData = jsonObject.getJSONObject("ROOT").getJSONObject("BODY").
                    getJSONObject("OUT_DATA").getJSONArray("SIMNOINFOLIST");

            Map<String, Object> temp = new HashMap<>();
            temp.put("SIMNOINFOLIST", outData);
            outDTO.setBodyOutData(outMap);
            return temp;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusiException(getErrorCode("1000", "160020", "调用资源接口错误"), e);
        }
    }
}
