package com.sitech.preservice.atombusi.impl;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.DateUtil;
import com.sitech.ijcf.boot.core.util.StringUtil;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.preservice.atombusi.IFamilyPreOrderRdComAo;
import com.sitech.preservice.constants.PreNoteEnum;
import com.sitech.preservice.dto.FmPreOrderRdOutDto;
import com.sitech.preservice.dto.ReturnOutDto;
import com.sitech.preservice.mapper.FmPreOrderRdMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@Component("FamilyPreOrderRdComAo")
public class FamilyPreOrderRdComAo implements IFamilyPreOrderRdComAo {

    @Resource
    private FmPreOrderRdMapper fmPreOrderRdMapper;

    @Value("classpath:jsonfiles/preNotes")
    private org.springframework.core.io.Resource resource;

    @Override
    public OutDTO commit(Map<String, Object> inMap) {
        OutDTO outDTO = new OutDTO();
        Map busiInfo = (Map) inMap.get("busiInfo");
        Map indata = new HashMap();

        indata.put("phoneNo",busiInfo.get("PHONE_NO"));
        indata.put("opDate",DateUtil.format(new Date(),"yyyyMMdd"));
        indata.put("opTime",DateUtil.format(new Date(),"yyyyMMddHHmmss"));
        indata.put("preOpCode",busiInfo.get("PRE_OP_CODE"));
        indata.put("preOpName",busiInfo.get("PRE_OP_NAME"));
        indata.put("preNote" ,busiInfo.get("PRE_NOTE"));
        indata.put("prePrcId",busiInfo.get("PRE_PRC_ID"));
        indata.put("preRelId", busiInfo.get("PRE_REL_ID"));
        indata.put("preRelName", busiInfo.get("PRE_REL_NAME"));
        indata.put("prePrcName", busiInfo.get("PRE_PRC_NAME"));
        indata.put("prePrcDesc",busiInfo.get("PRE_PRC_DESC"));
        indata.put("prePrcPrice",busiInfo.get("PRE_PRC_PRICE"));
        indata.put("preAddressId",busiInfo.get("PRE_ADDRESS_ID"));
        indata.put("preAddressInfo",busiInfo.get("PRE_ADDRESS_INFO"));
        indata.put("preInstallTime",busiInfo.get("PRE_INSTALL_TIME"));
        int count = fmPreOrderRdMapper.commit(indata);
        if(count<0){
            throw new BusiException("03","提交失败");
        }else {
            ReturnOutDto returnOutDto = new ReturnOutDto();
            returnOutDto.setRtnMsg("提交成功");
            returnOutDto.setRtnCode("0");
            outDTO.setBodyOutData(returnOutDto);
        }
        return outDTO;
    }

    @Override
    public OutDTO query(Map<String, Object> inMap) {
        OutDTO outDTO = new OutDTO();
        Map indata = new HashMap();
        try {
            List<Map> outList = new ArrayList<>();

            Map busiInfo = (Map) inMap.get("busiInfo");
            indata.put("phoneNo",busiInfo.get("PHONE_NO"));
            indata.put("opDate",DateUtil.format(new Date(),"yyyyMMdd"));
            indata.put("preOpCode",busiInfo.get("PRE_OP_CODE"));

            List<FmPreOrderRdOutDto> fmPreOrderRdOutDtoList = fmPreOrderRdMapper.query(indata);

            if(fmPreOrderRdOutDtoList.isEmpty()){
                ReturnOutDto returnOutDto = new ReturnOutDto();
                returnOutDto.setRtnCode("1");
                returnOutDto.setRtnMsg("该用户今日无预约记录");
                outDTO.setBodyOutData(returnOutDto);
                return outDTO;
            }
            for(FmPreOrderRdOutDto fmPreOrderRdOutDto : fmPreOrderRdOutDtoList){
                //读取json文件，将预约原因转化为汉字
                Map preNotesMap = new HashMap();
                Map outMap = new HashMap();
                String preNote = fmPreOrderRdOutDto.getPreNote();
                if(!"".equals(preNote) && preNote != null){
                    String[] preNoteNums = preNote.split(",");
                    /*BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()));
                    String line = null;
                    StringBuilder message = new StringBuilder();
                    while ((line = br.readLine()) != null){
                        message.append(line);
                    }
                    String defaultString = message.toString();
                    String result = defaultString.replace("\r\n", "").replaceAll(" +", "");
                    Map preNoteMap = (Map) JSONObject.parse(result);*/
                    for (String preNoteNum : preNoteNums){
//                        String preNoteStr = (String) preNoteMap.get(preNoteNum);
//                        preNotesMap.put(preNoteNum, preNotesMap.get(preNoteNum));
                        switch (preNoteNum){
                            case "00":
                                 preNotesMap.put("00",PreNoteEnum.VAL_00.getLabel());
                                 break;
                            case "01":
                                preNotesMap.put("01",PreNoteEnum.VAL_01.getLabel());
                                break;
                            case "02":
                                preNotesMap.put("02",PreNoteEnum.VAL_02.getLabel());
                                break;
                            case "03":
                                preNotesMap.put("03",PreNoteEnum.VAL_03.getLabel());
                                break;
                            case "04":
                                preNotesMap.put("04",PreNoteEnum.VAL_04.getLabel());
                                break;
                            case "05":
                                preNotesMap.put("05",PreNoteEnum.VAL_05.getLabel());
                                break;
                            case "06":
                                preNotesMap.put("06",PreNoteEnum.VAL_06.getLabel());
                                break;
                            case "07":
                                preNotesMap.put("07",PreNoteEnum.VAL_07.getLabel());
                                break;
                            default:
                                preNotesMap.put("08",PreNoteEnum.VAL_08.getLabel());
                                break;
                        }
                    }
                }
                outMap.put("PHONE_NO",fmPreOrderRdOutDto.getPhoneNo());
                outMap.put("OP_DATE",fmPreOrderRdOutDto.getOpDate());
                outMap.put("OP_TIME",fmPreOrderRdOutDto.getOpTime());
                outMap.put("PRE_OP_CODE",fmPreOrderRdOutDto.getPreOpCode());
                outMap.put("PRE_OP_NAME",fmPreOrderRdOutDto.getPreOpName());
                outMap.put("PRE_NOTE",preNotesMap);
                outMap.put("PRE_PRC_ID",fmPreOrderRdOutDto.getPrePrcId());
                outMap.put("PRE_REL_ID",fmPreOrderRdOutDto.getPreRelId());
                outMap.put("PRE_REL_NAME",fmPreOrderRdOutDto.getPreRelName());
                outMap.put("PRE_PRC_NAME",fmPreOrderRdOutDto.getPrePrcName());
                outMap.put("PRE_PRC_DESC",fmPreOrderRdOutDto.getPrePrcDesc());
                outMap.put("PRE_PRC_PRICE",fmPreOrderRdOutDto.getPrePrcPrice());
                outMap.put("PRE_ADDRESS_ID",fmPreOrderRdOutDto.getPreAddressId());
                outMap.put("PRE_ADDRESS_INFO",fmPreOrderRdOutDto.getPreAddressInfo());
                outMap.put("PRE_INSTALL_TIME",fmPreOrderRdOutDto.getPreInstallTime());

                outList.add(outMap);
            }
            outDTO.setBodyOutData(outList);
        }catch (Exception e1){
            throw new BusiException("02",e1.getMessage());
        }
        return outDTO;
    }

}
