package com.sitech.preservice.atombusi.impl;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.service.ArchitectureType;
import com.sitech.ijcf.boot.core.service.client.IBusiServiceClient;
import com.sitech.ijcf.boot.core.service.client.IServiceClient;
import com.sitech.ijcf.message6.dt.Header;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.ijcf.message6.dt.support.MBean;
import com.sitech.preservice.atombusi.IStandardRoomQryAo;
import com.sitech.preservice.dto.indto.StandardRoomInDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component("StandardRoomQryAo")
public class StandardRoomQryAo implements IStandardRoomQryAo {

    private static final Logger logger = LoggerFactory.getLogger(StandardRoomQryAo.class);

    @Resource
    private IServiceClient serviceClient;

    @Value("classpath:jsonfiles/roomsInfo")
    private org.springframework.core.io.Resource resource;

    @Resource
    private StandardAddressQryAo standardAddressQryAo;

    @Override
    public OutDTO<Map> roomQuery(Map<String, Object> inMap) {
        try {
            MBean mBean = new MBean();
            Map indata = new HashMap();
            OutDTO<Map> outDTO = new OutDTO();

            Header header = (Header) inMap.get("header");
            StandardRoomInDto standardRoomInDto = (StandardRoomInDto) inMap.get("busiInfo");

            indata.put("cell_intid",standardRoomInDto.getCellIntId());
            indata.put("building_intid",standardRoomInDto.getBuildingIntId());
            indata.put("unit_intid",standardRoomInDto.getUnitIntId());

            mBean.setHeader(header);
            mBean.addBody("OPR_INFO",inMap.get("oprInfo"));
            mBean.addBody("BUSI_INFO",indata);


            StringBuffer inXml = new StringBuffer();
//            inXml.append("<?xml version=\"1.0\" encoding=\"GBK\" standalone=\"no\"?>");
            inXml.append("<form>");
            inXml.append("<cell_intid>108166781</cell_intid>");
            inXml.append("<building_intid>210467712</building_intid>");
            inXml.append("<unit_intid>210467713</unit_intid>");
            inXml.append("</form>");


            Map inDto = new HashMap();
            inDto.put("form",indata);
            outDTO = serviceClient.callService("http://10.208.225.85:30411/esbWS/services/roomQuery_new",inDto,OutDTO.class,ArchitectureType.ESB_XML);
            logger.debug("++++++++++++++"+outDTO);
            /*Map map = (Map) mBean.getBody();
            outDTO = standardAddressQryAo.getOutData(resource);*/
            //优化出参结构
            if(outDTO == null){
                outDTO = new OutDTO<>();
                outDTO.setBodyOutData((Map) new HashMap().put("floor_room_info",new ArrayList<>()));
                return outDTO;
            }
            Map jsonObject =  outDTO.getBodyOutData();
            Map jsonMap = (Map) jsonObject.get("form");
            List jsonList = (List) jsonMap.get("info");
            List floorRoomInfoLists = new ArrayList();
            for(Object floorRoomInfo : jsonList ){
                Map floorRoomMap = (Map) floorRoomInfo;
                Map floorRoomMaps = new HashMap();
                List roomLists = new ArrayList();
                for(Object floorRoomInfoList : floorRoomInfoLists){
                    Map floorRoomInfoMap = (Map) floorRoomInfoList;
                    if(floorRoomInfoMap.containsValue(floorRoomMap.get("floor_intid"))){
                        floorRoomMaps = floorRoomInfoMap;
                        roomLists = (List) floorRoomMaps.get("room_info");
                    }
                }

                floorRoomInfoLists.remove(floorRoomMaps);

                floorRoomMaps.put("floor_name",floorRoomMap.get("floor_name"));
                floorRoomMaps.put("floor_intid",floorRoomMap.get("floor_intid"));

                Map roomMap = new HashMap();
                roomMap.put("room_name",floorRoomMap.get("room_name"));
                roomMap.put("room_intid",floorRoomMap.get("room_intid"));
                roomLists.add(roomMap);
                floorRoomMaps.put("room_info",roomLists);
                floorRoomInfoLists.add(floorRoomMaps);
            }

            Map floorRoomInfoMap = new HashMap();
            floorRoomInfoMap.put("floor_room_info",floorRoomInfoLists);
            outDTO.setBodyOutData(floorRoomInfoMap);
            return outDTO;
        }catch (Exception e){
            throw new BusiException("05",e.getMessage());
        }
    }
}
