package com.sitech.family.compservice.atombiz.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sitech.family.common.JsonReader;
import com.sitech.family.compservice.atombiz.IStandardAddressQryAo;
import com.sitech.family.compservice.dto.outdto.AddressListOut;
import com.sitech.family.compservice.dto.outdto.StandarAddressOutDto;
import com.sitech.ijcf.boot.core.service.client.IServiceClient;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.ijcf.message6.dt.support.MBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author guanqp
 * @description 宽带安装地址查询
 * @date 2018/12/18
 */
@Component("StandardAddressQryAoSvc")
public class StandardAddressQryAoSvc implements IStandardAddressQryAo{

    @Resource
    private IServiceClient serviceClient;

    @Value("classpath:jsonfiles/address")
    private org.springframework.core.io.Resource resource;

    @Resource
    private JsonReader jsonReader;

    /**
     * 宽带安装地址查询
     *
     * @param inDTO
     * @return outDTO
     */
    @Override
    public OutDTO<StandarAddressOutDto> query(InDTO<Map> inDTO) {
        Map map = (Map)inDTO.getBody().get("BUSI_INFO");
        OutDTO outDTO = new OutDTO();
        if("0".equals(map.get("QUERY_TYPE"))){
            MBean mBean = new MBean();
            mBean.addBody("BUSI_INFO", inDTO.getBody());
            ParameterizedTypeReference inpara = new ParameterizedTypeReference<OutDTO<StandarAddressOutDto>>(){};

            outDTO = new OutDTO<StandarAddressOutDto>();
            StandarAddressOutDto outlist = new StandarAddressOutDto();
            List standarAddressEntity = new ArrayList<AddressListOut>();
            for(int i=0;i<5;i++){
                AddressListOut entity = new AddressListOut();
                entity.setAccessType("接入类型"+String.valueOf(i));
                entity.setAddressId("小区地址ID"+ String.valueOf(i));
                entity.setStandardAddressName("标准地址名称"+String.valueOf(i));
                entity.setStandardAddressId("标准地址ID"+ String.valueOf(i));
                entity.setUserInstallAreaId("归属地市"+ String.valueOf(i));
                standarAddressEntity.add(entity);
            }
            outlist.setAddressList(standarAddressEntity);
            outDTO.setBodyOutData(outlist);
            // OutDTO<StandarAddressOutDto> outDTO = serviceClient.callService("http://custCenter/rs/com_sitech_ijcf_demo_inter_ICustInfoAoSvc_qyrCustInfo", mBean.toString(), inpara);
        }else {
            MBean mBean = new MBean();
            Map inMap = new HashMap();

            inMap.put("ADDRESS",map.get("ADDRESS"));
//            inMap.put("ADDRESS_NOTE",map.get("ADDRESS_NOTE"));

            mBean.setHeader(inDTO.getHeader());
            mBean.setBody("OPR_INFO",inDTO.getBody().get("OPR_INFO"));
            mBean.setBody("BUSI_INFO",inMap);
//            outDTO = serviceClient.callService("",mBean.toString(),OutDTO.class,ArchitectureType.SPRINGCLOUD);

            //模拟测试数据
            String result = jsonReader.parseJson(resource);
            JSONArray jsonObject = JSONObject.parseObject(result).getJSONObject("ROOT")
                    .getJSONObject("BODY").getJSONObject("OUT_DATA").getJSONArray("ADDRESS_LIST");

            Map<String,JSONArray> outMap = new HashMap();
            outMap.put("ADDRESS_LIST",jsonObject);
            outDTO.setBodyOutData(outMap);
        }
        return outDTO;
    }
}
