package com.sitech.family.configservice.service;

import com.sitech.family.common.dto.RequestMessage;
import com.sitech.family.common.util.BaseLoginAccept;
import com.sitech.family.configservice.atombusi.CsMenuConfigAo;
import com.sitech.family.configservice.dll.dto.CsMenuConfigDto;
import com.sitech.family.configservice.dto.indto.CsMenuConfigInDto;
import com.sitech.family.configservice.dto.outdto.CsMenuConfigOutDto;
import com.sitech.family.configservice.inter.ICsMenuConfig;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.message6.dt.in.InDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Zhangc
 * @version 1.0
 * @date 2018/12/12 13:20
 */
@Service("CsMenuConfigSvc")
public class CsMenuConfig implements ICsMenuConfig {
    private static Logger logger= LoggerFactory.getLogger(CsMenuConfig.class);

    @Resource
    private CsMenuConfigAo csMenuConfigAo;
    @Resource
    private BaseLoginAccept baseLoginAccept;

    @ResponseBody
    @RequestMapping("/queryMenuList")
    @Override
    public List<CsMenuConfigOutDto> qryMenuList(@Valid @RequestBody InDTO<RequestMessage<CsMenuConfigInDto>> inDto,BindingResult result) {
        if (result.hasErrors()){
            List<ObjectError> errorList = result.getAllErrors();
            for(ObjectError error : errorList){
                System.out.println(error.getDefaultMessage());
            }
            throw new BusiException( "15002", errorList.get(0).getDefaultMessage());
        }
        String ownerBottom = inDto.getBody().getBusiInfo().getOwnerBottom();
        List<CsMenuConfigDto> queryMenuList = csMenuConfigAo.qryMenuList(ownerBottom);
        List<CsMenuConfigOutDto> queryReqInfoList = new ArrayList<>();
        for (CsMenuConfigDto csMenuConfigDto:queryMenuList){
            CsMenuConfigOutDto csMenuConfigOutDto = new CsMenuConfigOutDto();
            BeanUtils.copyProperties(csMenuConfigDto,csMenuConfigOutDto);
            queryReqInfoList.add(csMenuConfigOutDto);
        }
        return queryReqInfoList;
    }

    @ResponseBody
    @RequestMapping("/aaa")
    public List<CsMenuConfigOutDto> aaa(@Valid @RequestBody InDTO<RequestMessage<CsMenuConfigInDto>> inDto) {
        String ownerBottom = inDto.getBody().getBusiInfo().getOwnerBottom();
        List<CsMenuConfigDto> queryMenuList = csMenuConfigAo.qryMenuList(ownerBottom);
        List<CsMenuConfigOutDto> queryReqInfoList = new ArrayList<>();
        for (CsMenuConfigDto csMenuConfigDto:queryMenuList){
            CsMenuConfigOutDto csMenuConfigOutDto = new CsMenuConfigOutDto();
            BeanUtils.copyProperties(csMenuConfigDto,csMenuConfigOutDto);
            queryReqInfoList.add(csMenuConfigOutDto);
        }
        return queryReqInfoList;
    }

    @RequestMapping("/getSequence")
    @Override
    public void getSequence() {
        try {
            Map accept = new HashMap<String,String>();
            accept.put("ACCEPT_LABEL","ID_SEQ");
            // 地市编码，可不传
            accept.put("REGION_ID","sd");
            String str = baseLoginAccept.getPubLoginAccept(accept);
            System.out.println("序列值："+str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
