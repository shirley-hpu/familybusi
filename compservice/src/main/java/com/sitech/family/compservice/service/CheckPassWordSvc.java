package com.sitech.family.compservice.service;

import com.sitech.family.compservice.compbiz.ICheckPassWordCo;
import com.sitech.family.common.dto.OprInfo;
import com.sitech.family.common.dto.RequestMessage;
import com.sitech.family.compservice.dto.indto.CheckPassWordInDto;
import com.sitech.family.compservice.inter.ICheckPassWord;
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
 * @Description  密码校验服务
 * @date 2019/1/22 14:54
 */
@Service("CheckPassWordSvc")
public class CheckPassWordSvc implements ICheckPassWord {

    private static Logger logger = LoggerFactory.getLogger(CheckPassWordSvc.class);

    @Resource
    private ICheckPassWordCo iCheckPassWordCo;

    @Override
    @ResponseBody
    @RequestMapping("sCheckPassWord")
    public OutDTO<Object> checkPassWord(@Valid@RequestBody InDTO<RequestMessage<CheckPassWordInDto>> requestMessage) {
        if(StringUtil.isEmptyOrNull(requestMessage.getBody().getBusiInfo())){
            throw new BusiException(getErrorCode("1000", "160001"), "入参节点BUSI_INFO不能为空!");
        }
        CheckPassWordInDto busiInfo = requestMessage.getBody().getBusiInfo();
        OprInfo oprInfo = requestMessage.getBody().getOprInfo();
        OutDTO<Object> OutDTO = iCheckPassWordCo.checkPassWord(busiInfo,oprInfo);
        return OutDTO;
    }
}
