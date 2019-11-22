package com.sitech.preservice.atombusi.impl;

import cn.hutool.json.JSONObject;
import cn.hutool.json.XML;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.service.ArchitectureType;
import com.sitech.ijcf.boot.core.service.client.IServiceClient;
import com.sitech.ijcf.message6.dt.Header;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.ijcf.message6.dt.support.MBean;
import com.sitech.preservice.atombusi.IStandardZoneQryAo;
import com.sitech.preservice.dto.indto.StandardZoneInDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
@Component("StandardZoneQryAo")
public class StandardZoneQryAo implements IStandardZoneQryAo {

    @Resource
    private IServiceClient serviceClient;

    @Resource
    private StandardAddressQryAo standardAddressQryAo;

    @Value("classpath:jsonfiles/zoneInfo")
    private org.springframework.core.io.Resource resource;

    @Override
    public OutDTO<Map> zoneQuery(Map<String, Object> inMap) {

        try {
//            MBean mBean = new MBean();
            Map indata = new HashMap();
            OutDTO<Map> outDTO = new OutDTO<>();

            Header header = (Header) inMap.get("header");
            StandardZoneInDto busiInfo = (StandardZoneInDto) inMap.get("busiInfo");
            String  cityName = busiInfo.getCityName();
            String  cellName = busiInfo.getCellName();
            String  countryName = busiInfo.getCountryName();

            indata.put("city_name",cityName);
            indata.put("county_name",countryName);
            indata.put("cell_name",cellName);

//            mBean.setHeader(header);
//            mBean.setBody(indata);
            Map mMap = new HashMap();
            mMap.put("form",indata);

        outDTO = serviceClient.callService("http://10.208.225.85:30411/esbWS/services/zoneQuery_new",mMap,OutDTO.class,ArchitectureType.ESB_XML);

//            outDTO = standardAddressQryAo.getOutData(resource);

            return outDTO;
        }catch (Exception e){
            throw new BusiException("03",e.getMessage());
        }

    }
}
