package com.sitech.family.compservice.service;

import com.sitech.family.compservice.compbiz.ISubPrcCheckCo;
import com.sitech.family.common.dto.OprInfo;
import com.sitech.family.common.dto.RequestMessage;
import com.sitech.family.compservice.dto.indto.SubPrcCheckInDto;
import com.sitech.family.compservice.dto.outdto.SubPrcCheckOutDto;
import com.sitech.family.compservice.inter.ISubPrcCheck;
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
 * @Description  主资费校验
 * @date 2019/3/13 9:41
 */
@Service("SubPrcCheckSvc")
public class SubPrcCheckSvc implements ISubPrcCheck {

    private static Logger logger=LoggerFactory.getLogger(SubPrcCheckSvc.class);

    @Resource
    private ISubPrcCheckCo iSubPrcCheckCo;

    @Override
    @ResponseBody
    @RequestMapping("/sSubPrcCheck")
    public OutDTO<SubPrcCheckOutDto> subPrcCheck(@Valid @RequestBody InDTO<RequestMessage<SubPrcCheckInDto>> requestMessage) {
        if(StringUtil.isEmptyOrNull(requestMessage.getBody().getBusiInfo())){
            throw new BusiException(getErrorCode("1000", "160001"), "入参节点BUSI_INFO不能为空!");
        }
        System.out.println("hello");

        OprInfo oprInfo = requestMessage.getBody().getOprInfo();
        SubPrcCheckInDto subPrcCheckInDto = requestMessage.getBody().getBusiInfo();
        OutDTO<SubPrcCheckOutDto> subPrcCheckOutDto = iSubPrcCheckCo.subPrcCheckCo(subPrcCheckInDto, oprInfo);
        return subPrcCheckOutDto;
    }
}
