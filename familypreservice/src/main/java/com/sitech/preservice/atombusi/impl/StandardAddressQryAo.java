package com.sitech.preservice.atombusi.impl;

import cn.hutool.json.JSONObject;
import cn.hutool.json.XML;
import com.alibaba.fastjson.JSON;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.service.ArchitectureType;
import com.sitech.ijcf.boot.core.service.client.IServiceClient;
import com.sitech.ijcf.message6.dt.Header;
import com.sitech.ijcf.message6.dt.Routing;
import com.sitech.ijcf.message6.dt.out.OutBody;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.ijcf.message6.dt.support.MBean;
import com.sitech.preservice.atombusi.IStandardAddressQryAo;
import com.sitech.preservice.dto.commondto.OprInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
@Component("StandardAddressQryAo")
public class StandardAddressQryAo implements IStandardAddressQryAo {
    @Resource
    private IServiceClient serviceClient;
    @Value("classpath:jsonfiles/countryInfo")
    private org.springframework.core.io.Resource resource;

    @Override
    public OutDTO<Map> addrQuery(Map<String, Object> inMap) {
        try {
//            MBean mBean = new MBean();
            Map indata = new HashMap<>();
            OutDTO<Map> outDTO = new OutDTO<>();

            Header header = (Header)inMap.get("header");
            OprInfo oprInfo = (OprInfo)inMap.get("oprInfo");
            Map busiInfo = (Map) inMap.get("busiInfo");

            String addrType = (String) busiInfo.get("ADDR_TYPE");
            String cityName = "";
            if("country".equals(addrType)){
                cityName = (String) busiInfo.get("CITY_NAME");
                if("".equals(cityName) || null == cityName){
                    OutBody outBody = new OutBody();
                    outBody.setDetailMsg("false");
                    outBody.setPromptMsg("地市不能为空");
                    outBody.setReturnCode("02");
                    outBody.setReturnMsg("false");
                    outBody.setUserMsg("false");
                    outDTO.setBody(outBody);
                    return outDTO;
                }
            }
            indata.put("Addr_type",addrType);
            indata.put("City_name",cityName);

            Map inDto = new HashMap();
            inDto.put("form",indata);

//            mBean.setHeader(header);
//            mBean.setBody(indata);

//            StringBuffer inXml = new StringBuffer();
//            inXml.append("<?xml version=\"1.0\" encoding=\"GBK\" standalone=\"no\"?>");
//            inXml.append("<form>");
//            inXml.append("<Addr_type>"+ addrType +"</Addr_type>");
//            inXml.append("<City_name>"+cityName  +"</City_name>");
//            inXml.append("</form>");

            outDTO = serviceClient.callService("http://10.208.225.84:30411/esbWS/services/addrQuery?wsdl",inDto,OutDTO.class,ArchitectureType.ESB_XML);
//            outDTO = getOutData(resource);
            return outDTO;
        }catch (Exception e){
            throw new BusiException("02",e.getMessage());
        }

    }
    //抽取公共模拟测试数据
    public OutDTO<Map> getOutData(org.springframework.core.io.Resource resource){
        OutDTO<Map> outDTO = new OutDTO<>();
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            StringBuilder message = new StringBuilder();
            String line = null;
            while ((line = bf.readLine())!= null){
                message.append(line);
            }
            String defaultString = message.toString();
            String result = defaultString.replace("\r\n", "").replaceAll(" +", "");
            JSONObject jsonObject = XML.toJSONObject(result);
            outDTO.setBodyOutData(jsonObject);
        } catch (IOException e) {
            throw new BusiException("-666",e.getMessage());
        }
        return outDTO;
    }

}
