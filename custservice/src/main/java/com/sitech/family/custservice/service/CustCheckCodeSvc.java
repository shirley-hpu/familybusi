package com.sitech.family.custservice.service;

import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.compbusi.ICustCheckCodeCo;
import com.sitech.family.custservice.dto.commondto.OprInfo;
import com.sitech.family.custservice.dto.commondto.RequestMessage;
import com.sitech.family.custservice.dto.indto.CustCheckCodeInDto;
import com.sitech.family.custservice.inter.ICustCheckCodeSvc;
import com.sitech.family.dto.ReturnDto;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author guanqp
 * @Description  验证码入表和查询操作
 * @date 2019/3/28 16:33
 */
@Service("CustCheckCodeSvc")
public class CustCheckCodeSvc implements ICustCheckCodeSvc {

    private static Logger logger = LoggerFactory.getLogger(CustCheckCodeSvc.class);

    @Autowired
    private ICustCheckCodeCo iCustCheckCodeCo;

    @Override
    @ResponseBody
    @RequestMapping("/sCheckCodeAdd")
    public OutDTO<Object> create(@Valid @RequestBody InDTO<RequestMessage<CustCheckCodeInDto>> inDTO) {
        logger.info("================");
        OutDTO<Object> outDTO = new OutDTO<>();
        ReturnDto returnDto = new ReturnDto();
        try {
            //插入操作
            RequestMessage requestMessage = inDTO.getBodyHeader().getBody();
            CustCheckCodeInDto custCheckCodeInDto = (CustCheckCodeInDto) requestMessage.getBusiInfo();
            OprInfo oprInfo = requestMessage.getOprInfo();

            Map<String, Object> checkCodeMap = new HashMap<>();
            checkCodeMap.put("OPR_INFO",oprInfo);
            checkCodeMap.put("BUSI_INFO",custCheckCodeInDto);

            returnDto = iCustCheckCodeCo.create(checkCodeMap);

            if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                outDTO.setBodyOutData("验证码入表失败");
                return outDTO;
            }

            outDTO.setBodyOutData(returnDto);
        } catch (Exception e) {
            logger.error("验证码入表失败" + e.getMessage());
            throw new BusiException(getErrorCode("1000", "15000"), e.getMessage());
        }
        return outDTO;
    }

    @Override
    @ResponseBody
    @RequestMapping("/sQueryCheckCodeAndEffe")
    public OutDTO<Object> query(@Valid @RequestBody InDTO<RequestMessage<CustCheckCodeInDto>> inDTO) {
        OutDTO<Object> outDTO = new OutDTO<>();
        Object returnDto = new Object();
        try {
            //查询
            RequestMessage requestMessage = inDTO.getBodyHeader().getBody();
            CustCheckCodeInDto custCheckCodeInDto = (CustCheckCodeInDto) requestMessage.getBusiInfo();
            OprInfo oprInfo = requestMessage.getOprInfo();

            Map<String, Object> checkCodeMap = new HashMap<>();
            checkCodeMap.put("OPR_INFO",oprInfo);
            checkCodeMap.put("BUSI_INFO",custCheckCodeInDto);

            returnDto = iCustCheckCodeCo.query(checkCodeMap);

            outDTO.setBodyOutData(returnDto);
        } catch (Exception e) {
            logger.error("验证码查询失败" + e.getMessage());
            throw new BusiException(getErrorCode("1000", "15000"), e.getMessage());
        }
        return outDTO;
    }
}
