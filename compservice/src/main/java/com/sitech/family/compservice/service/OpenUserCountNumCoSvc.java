package com.sitech.family.compservice.service;

import com.sitech.family.compservice.compbiz.IOpenUserCountNumCo;
import com.sitech.family.common.dto.RequestMessage;
import com.sitech.family.compservice.dto.indto.OpenUserInDto;
import com.sitech.family.compservice.dto.outdto.OpenUserCountNumOutDto;
import com.sitech.family.compservice.inter.IOpenUserCountNumCoSvc;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
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

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author guanqp
 * @Description  一证五号校验
 * @date 2019/01/14
 */
@Service("OpenUserCountNumCoSvc")
public class OpenUserCountNumCoSvc implements IOpenUserCountNumCoSvc {

    private static Logger logger = LoggerFactory.getLogger(OpenUserCountNumCoSvc.class);

    @Resource
    private IOpenUserCountNumCo iOpenUserCountNumCo;

    @Override
    @ResponseBody
    @RequestMapping("/sOpenUserCountNumChk")
    public OutDTO<OpenUserCountNumOutDto> chkOpenUserCountNum(@Valid @RequestBody InDTO<RequestMessage<OpenUserInDto>> requestMessage) {
        if(StringUtil.isEmptyOrNull(requestMessage.getBody().getBusiInfo())){
            throw new BusiException(getErrorCode("1000", "160001"), "入参节点BUSI_INFO不能为空!");
        }
        OpenUserInDto openUserInDto = requestMessage.getBody().getBusiInfo();
        OutDTO<OpenUserCountNumOutDto> outDTO = iOpenUserCountNumCo.check(openUserInDto);
        return outDTO;
    }
}
