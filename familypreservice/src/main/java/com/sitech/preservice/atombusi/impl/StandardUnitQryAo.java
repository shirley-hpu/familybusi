package com.sitech.preservice.atombusi.impl;


import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.service.ArchitectureType;
import com.sitech.ijcf.boot.core.service.client.IServiceClient;
import com.sitech.ijcf.message6.dt.Header;
import com.sitech.ijcf.message6.dt.out.OutBody;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.ijcf.message6.dt.support.MBean;
import com.sitech.preservice.atombusi.IStandardUnitQryAo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

@Component("StandardUnitQryAo")
public class StandardUnitQryAo implements IStandardUnitQryAo {

    @Resource
    private IServiceClient serviceClient;

    @Value("classpath:jsonfiles/unitInfo")
    private org.springframework.core.io.Resource resource;

    @Resource
    private StandardAddressQryAo standardAddressQryAo;

    @Override
    public OutDTO<Map> unitQuery(Map<String, Object> inMap) {
        OutDTO<Map> outDTO = new OutDTO<>();
        try {
//            MBean mBean = new MBean();
            Map indata = new HashMap();

            Header header = (Header) inMap.get("header");
            Map busiInfo = (Map) inMap.get("busiInfo");
            indata.put("city_intid",busiInfo.get("CELL_INTID"));


//            mBean.setHeader(header);
//            mBean.setBody(indata);

            Map mMap = new HashMap();
            mMap.put("form",indata);
            outDTO = serviceClient.callService("http://10.208.225.85:30411/esbWS/services/unitQuery",mMap,OutDTO.class,ArchitectureType.ESB_XML);
//                outDTO = standardAddressQryAo.getOutData(resource);

            if(outDTO == null){
                outDTO = new OutDTO<>();
                outDTO.setBodyOutData((Map) new HashMap().put("building_unit_lists",new ArrayList<>()));
                return outDTO;
            }
            Map jsonObject =  outDTO.getBodyOutData();
            Map jsonMap = (Map) jsonObject.get("form");
            List jsonList = (List) jsonMap.get("info");
            List buildUnitLists = new ArrayList();
            for(Object buildUnitInfo : jsonList){
                Map buildUnitInfoMap = (Map)buildUnitInfo;
                Map buildUnitMap = new HashMap();
                List unitList = new ArrayList();
                for(Object buildUnitList : buildUnitLists){
                    Map buildUnitMaps = (Map) buildUnitList;
                    if(buildUnitMaps.containsValue(buildUnitInfoMap.get("building_intid"))){
                        buildUnitMap = buildUnitMaps;
                        unitList = (List) buildUnitMap.get("unit_info");
                    }
                }
                buildUnitLists.remove(buildUnitMap);
                if(!buildUnitMap.containsKey(buildUnitInfoMap.get("building_intid"))){
                    buildUnitMap.put("building_name",buildUnitInfoMap.get("building_name"));
                    buildUnitMap.put("building_intid",buildUnitInfoMap.get("building_intid"));
                }

                Map unitMap = new HashMap();
                unitMap.put("unit_name",buildUnitInfoMap.get("unit_name"));
                unitMap.put("unit_intid",buildUnitInfoMap.get("unit_intid"));
                unitList.add(unitMap);

                buildUnitMap.put("unit_info",unitList);

                buildUnitLists.add(buildUnitMap);
            }
            Map outMap = new HashMap();
            outMap.put("building_unit_lists",buildUnitLists);
            outDTO.setBodyOutData(outMap);
//            return outDTO;
        }catch (Exception e){
            throw new BusiException("04",e.getMessage());
        }
        return outDTO;
    }
}
