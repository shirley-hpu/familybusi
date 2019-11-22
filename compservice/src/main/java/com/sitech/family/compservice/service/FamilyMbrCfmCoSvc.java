package com.sitech.family.compservice.service;

import com.alibaba.fastjson.JSON;
import com.sitech.family.common.dto.OprInfo;
import com.sitech.family.common.dto.RequestMessage;
import com.sitech.family.compservice.compbiz.IFamilyMbrCfmCo;
import com.sitech.family.compservice.dto.indto.FamilyGroupMbrInDto;
import com.sitech.family.compservice.dto.indto.FamilyMbrDelInDto;
import com.sitech.family.compservice.dto.indto.FamilyMbrMngInDto;
import com.sitech.family.compservice.inter.IFamilyMbrCfmCoSvc;
import com.sitech.family.constants.ReturnCode;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Service
public class FamilyMbrCfmCoSvc implements IFamilyMbrCfmCoSvc {

    private static Logger logger = LoggerFactory.getLogger(FamilyMbrCfmCoSvc.class);

    @Resource(name = "FamilyMbrCfmCo")
    private IFamilyMbrCfmCo iFamilyMbrCfmCo;

    /**
     * 成员管理新增
     *
     * @param inDTO
     * @return
     */
    @Override
    @ResponseBody
    @RequestMapping("/sFamilyAddMbrCfm")
    public OutDTO cfmFamilyAddMbr(@RequestBody @Valid InDTO<RequestMessage<FamilyMbrMngInDto>> inDTO) {
        OutDTO outDTO = new OutDTO();

        try {
            RequestMessage requestMessage = inDTO.getBody();
            FamilyMbrMngInDto familyMbrMngInDto = (FamilyMbrMngInDto) requestMessage.getBusiInfo();
            OprInfo oprInfo = requestMessage.getOprInfo();

            Map<String, Object> map = new HashMap<>();
            map.put("busiInfo", familyMbrMngInDto);
            map.put("oprInfo", oprInfo);

            Map outMap = iFamilyMbrCfmCo.cfmFamilyAddMbr(map);

            outDTO.setBodyOutData(outMap);
        } catch (Exception e) {
            throw new BusiException("-9999", e.getMessage());
        }

        return outDTO;
    }

    /**
     * 成员关系删除
     *
     * @param inDTO
     * @return
     */
    @Override
    @ResponseBody
    @RequestMapping("/sFamilyDelMbrCfm")
    public OutDTO cfmFamilyDelMbr(@Valid @RequestBody InDTO<RequestMessage<FamilyMbrDelInDto>> inDTO) {

        //获取业务参数信息
        RequestMessage requestMessage = inDTO.getBodyHeader().getBody();
        FamilyMbrDelInDto mbrDelInDto = (FamilyMbrDelInDto) requestMessage.getBusiInfo();

        try {
            //成员关系删除
            Map<String, Object> params = new HashMap<>();
            params.put("BUSI_INFO", mbrDelInDto);
            params.put("OPR_INFO", inDTO.getBody().getOprInfo());
            params.put("HEADER", inDTO.getHeader());


            OutDTO result = iFamilyMbrCfmCo.cfmFamilyDelMbr(params);
            logger.debug(" ==> " + JSON.toJSONString(result));

            OutDTO outDTO = new OutDTO<>();
            outDTO.setBodyOutData(result.getBodyOutData());
            return outDTO;
        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "处理失败", e.getMessage());
        }
    }

    @Override
    @ResponseBody
    @RequestMapping("/sFamilyGroupMbrQry")
    public OutDTO<Object> cfmFamilyGroupMbr(@RequestBody InDTO<RequestMessage<FamilyGroupMbrInDto>> inDTO) {
        RequestMessage requestMessage = inDTO.getBodyHeader().getBody();
        FamilyGroupMbrInDto mbrInfoInDto = (FamilyGroupMbrInDto) requestMessage.getBusiInfo();
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("BUSI_INFO", mbrInfoInDto);
            params.put("oprInfo", inDTO.getBody().getOprInfo());
            params.put("header", inDTO.getHeader());
            OutDTO outDTO = iFamilyMbrCfmCo.cfmFamilyGroupMbr(params);
            return outDTO;
        }catch (Exception e){
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "群成员信息查询失败", e.getMessage());
        }
    }
}
