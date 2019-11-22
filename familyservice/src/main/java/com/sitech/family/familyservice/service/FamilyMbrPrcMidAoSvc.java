package com.sitech.family.familyservice.service;

import com.alibaba.fastjson.JSON;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.familyservice.compbusi.IFamilyMbrPrcMidCo;
import com.sitech.family.familyservice.dto.commondto.OprInfo;
import com.sitech.family.familyservice.dto.commondto.RequestMessage;
import com.sitech.family.familyservice.dto.indto.FamilyAddMbrInDto;
import com.sitech.family.familyservice.inter.IFamilyMbrPrcMidAoSvc;
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
import java.util.HashMap;
import java.util.Map;

/**
 * 在途成员资费订购
 *
 * @author shirley
 * @version 1.0
 * @date 2019/7/22 下午2:41
 */
@Service
public class FamilyMbrPrcMidAoSvc implements IFamilyMbrPrcMidAoSvc {

    private static Logger logger = LoggerFactory.getLogger(FamilyMbrPrcMidAoSvc.class);

    @Resource
    private IFamilyMbrPrcMidCo familyMbrPrcMidCo;

    
    @Override
    @ResponseBody
    @RequestMapping("/sFamilyMbrPrcMidCfm")
    public OutDTO sFamilyMbrPrcMidCfm(@RequestBody InDTO<RequestMessage<FamilyAddMbrInDto>> inDTO) {

        logger.debug("InDTO ==> " + JSON.toJSONString(inDTO));

        //获取节点参数
        OprInfo oprInfo = inDTO.getBody().getOprInfo();
        FamilyAddMbrInDto familyAddMbrInDto = inDTO.getBody().getBusiInfo();

        Map<String, Object> map = new HashMap<>();
        map.put("oprInfo", oprInfo);
        map.put("busiInfo", familyAddMbrInDto);

        try {

            ReturnDto returnDto = familyMbrPrcMidCo.create(map);

            if (!ReturnCode.RETURN_CODE_SUCCESS.getCode().equals(returnDto.getCode())) {
                throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), returnDto.getMessage());
            }

            OutDTO<ReturnDto> outDTO = new OutDTO<>();
            outDTO.setHeader(inDTO.getBodyHeader().getHeader());
            outDTO.setBodyOutData(returnDto);
            return outDTO;

        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "在途成员资费订购失败", e.getMessage());
        }
    }
}
