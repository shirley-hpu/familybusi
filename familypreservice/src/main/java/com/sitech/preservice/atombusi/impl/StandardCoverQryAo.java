package com.sitech.preservice.atombusi.impl;

import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.service.ArchitectureType;
import com.sitech.ijcf.boot.core.service.client.IServiceClient;
import com.sitech.ijcf.message6.dt.Header;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.ijcf.message6.dt.support.MBean;
import com.sitech.preservice.atombusi.IStandardCoverQryAo;
import com.sitech.preservice.dto.indto.StandardCoverInDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
@Component("StandardCoverQryAo")
public class StandardCoverQryAo implements IStandardCoverQryAo {

    @Resource
    private IServiceClient serviceClient;

    @Value("classpath:jsonfiles/coverInfo")
    private org.springframework.core.io.Resource resource;

    @Resource
    private StandardAddressQryAo standardAddressQryAo;

    @Override
    public OutDTO<Map> coverQuery(Map<String, Object> inMap) {
        try {
            MBean mBean = new MBean();
            Map indata = new HashMap();
            OutDTO<Map> outDTO = new OutDTO<>();

            Header header = (Header) inMap.get("header");
            StandardCoverInDto standardCoverInDto = (StandardCoverInDto) inMap.get("busiInfo");

            indata.put("Cell_intid",standardCoverInDto.getCellIniId());
            indata.put("building_intid",standardCoverInDto.getBuindingIntId());
            indata.put("unit_intid",standardCoverInDto.getUnitIntId());
            indata.put("room_intid",standardCoverInDto.getRoomIntId());

            mBean.setHeader(header);
            mBean.setBody(indata);

//        outDTO = serviceClient.callService("",mBean.toString(),OutDTO.class,ArchitectureType.ESB_REST);
            outDTO = standardAddressQryAo.getOutData(resource);
            return outDTO;
        }catch (Exception e){
            throw new BusiException("-777",e.getMessage());
        }

    }
}
