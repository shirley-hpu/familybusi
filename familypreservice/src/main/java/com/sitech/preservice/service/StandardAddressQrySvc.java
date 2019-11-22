package com.sitech.preservice.service;

import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.message6.dt.Header;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.preservice.atombusi.*;
import com.sitech.preservice.dto.commondto.OprInfo;
import com.sitech.preservice.dto.commondto.RequestMessage;
import com.sitech.preservice.dto.indto.StandardRoomInDto;
import com.sitech.preservice.dto.indto.StandardZoneInDto;
import com.sitech.preservice.inter.IStandardAddressQrySvc;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
/**
 * TODO
 * @author liangjy
 */
@Service
public class StandardAddressQrySvc implements IStandardAddressQrySvc {

    @Resource
    private IStandardAddressQryAo iStandardAddressQryAo;
    @Resource
    private IStandardZoneQryAo iStandardZoneQryAo;
    @Resource
    private IStandardUnitQryAo iStandardUnitQryAo;
    @Resource
    private IStandardRoomQryAo iStandardRoomQryAo;

    //查询的为浪潮所提供的地址接口
    //查询区县
    @Override
    @RequestMapping("/sStandardCountyQry")
    @ResponseBody
    public OutDTO<Map> addrQuery(@Valid @RequestBody InDTO<RequestMessage<Map>> inDTO) {
        try {
            Header header = inDTO.getHeader();
            OprInfo oprInfo = inDTO.getBody().getOprInfo();
            Map busiInfo = inDTO.getBody().getBusiInfo();

            Map<String,Object> inMap = new HashMap<>();
            inMap.put("header",header);
            inMap.put("oprInfo",oprInfo);
            inMap.put("busiInfo",busiInfo);
            OutDTO<Map> outDTO = iStandardAddressQryAo.addrQuery(inMap);
            return outDTO;
        }catch (BusiException e){
            throw new BusiException("0000"+e.getErrCode(),e.getMessage());
        }
    }

    //查询小区
    @Override
    @RequestMapping("/sStandardZoneQry")
    @ResponseBody
    public OutDTO<Map> zoneQuery(@Valid @RequestBody InDTO<RequestMessage<StandardZoneInDto>> inDTO) {
        try {
            Header header = inDTO.getHeader();
            OprInfo oprInfo = inDTO.getBody().getOprInfo();
            StandardZoneInDto busiInfo = inDTO.getBody().getBusiInfo();

            Map<String,Object> inMap = new HashMap<>();
            inMap.put("header",header);
            inMap.put("oprInfo",oprInfo);
            inMap.put("busiInfo",busiInfo);
            OutDTO<Map> outDTO = iStandardZoneQryAo.zoneQuery(inMap);
            return outDTO;
        }catch (BusiException e){
            throw new BusiException("0000"+e.getErrCode(),e.getMessage());
        }
    }

    //查询楼、单元
    @Override
    @RequestMapping("/sStandardUnitQry")
    @ResponseBody
    public OutDTO<Map> unitQuery(@Valid @RequestBody InDTO<RequestMessage<Map>> inDTO) {
        try {
            Header header = inDTO.getHeader();
            OprInfo oprInfo = inDTO.getBody().getOprInfo();
            Map busiInfo = inDTO.getBody().getBusiInfo();

            Map<String,Object> inMap = new HashMap<>();
            inMap.put("header",header);
            inMap.put("oprInfo",oprInfo);
            inMap.put("busiInfo",busiInfo);
            OutDTO<Map> outDTO = iStandardUnitQryAo.unitQuery(inMap);
            return outDTO;
        }catch (BusiException e){
            throw new BusiException("0000"+e.getErrCode(),e.getMessage());
        }
    }

    //查询房号
    @Override
    @RequestMapping("/sStandardRoomQry")
    @ResponseBody
    public OutDTO<Map> roomQuery(@Valid @RequestBody InDTO<RequestMessage<StandardRoomInDto>> inDTO) {
        try {
            Header header = inDTO.getHeader();
            OprInfo oprInfo = inDTO.getBody().getOprInfo();
            StandardRoomInDto busiInfo = inDTO.getBody().getBusiInfo();

            Map<String,Object> inMap = new HashMap<>();
            inMap.put("header",header);
            inMap.put("oprInfo",oprInfo);
            inMap.put("busiInfo",busiInfo);
            OutDTO<Map> outDTO = iStandardRoomQryAo.roomQuery(inMap);
            return outDTO;
        }catch (BusiException e){
            throw new BusiException("0000"+e.getErrCode(),e.getMessage());
        }
    }

}
