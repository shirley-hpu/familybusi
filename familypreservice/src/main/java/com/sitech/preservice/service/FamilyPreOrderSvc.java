package com.sitech.preservice.service;

import com.sitech.family.constants.ReturnCode;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.preservice.dto.FmPreOrderMid;
import com.sitech.preservice.dto.commondto.RequestMessage;
import com.sitech.preservice.dto.indto.FmPreOrderMidInDto;
import com.sitech.preservice.inter.IFamilyPreOrderSvc;
import com.sitech.preservice.mapper.FmPreOrderMidMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
 * 预受理
 *
 * @author shirley
 * @date created in 2019/5/30
 */
@Service
public class FamilyPreOrderSvc implements IFamilyPreOrderSvc {

    private static final Logger logger = LoggerFactory.getLogger(FamilyPreOrderSvc.class);

    @Resource
    private FmPreOrderMidMapper mapper;


    /**
     * 预受理查询
     *
     * @param inDTO
     * @return
     */
    @ResponseBody
    @RequestMapping("/sFamilyPreOrderQry")
    @Override
    public OutDTO<Object> qryFmPreOrderMidList(@Valid @RequestBody InDTO<RequestMessage<FmPreOrderMidInDto>> inDTO, BindingResult bindingResult) {

        //获取注解校验错误信息
        List<String> errorInfo;

        if (bindingResult.hasErrors()) {

            errorInfo = new ArrayList<>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();

            for (FieldError fieldError : fieldErrors) {
                //日志打印不符合校验的字段名和错误提示
                logger.debug("error field is : {} ,message is : {} ", fieldError.getField(), fieldError.getDefaultMessage());
                errorInfo.add(fieldError.getDefaultMessage());
            }
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), errorInfo.toString());
        }


        //获取节点参数
        FmPreOrderMidInDto param = inDTO.getBody().getBusiInfo();

        try {

            Map params = new HashMap<>();
            params.put("phoneNo", param.getFmPreOrderMid().getPhoneNo());
            List<FmPreOrderMid> fmPreOrderMidList = mapper.qryFmPreOrderMidList(params);

            if (fmPreOrderMidList.isEmpty()) {
                throw new BusiException(ReturnCode.RETURN_CODE_SUCCESS.getCode(), "查询数据为空");
            }

            OutDTO<Object> outDTO = new OutDTO<>();
            outDTO.setHeader(inDTO.getBodyHeader().getHeader());
            params.clear();
            params.put("PREODER_INFO", fmPreOrderMidList.get(0));
            outDTO.setBodyOutData(params);
            return outDTO;

        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "failed query", e.getMessage());
        }
    }
}
