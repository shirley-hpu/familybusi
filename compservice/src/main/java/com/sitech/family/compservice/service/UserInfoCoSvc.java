package com.sitech.family.compservice.service;

import com.sitech.family.compservice.compbiz.IUserInfoCo;
import com.sitech.family.common.dto.OprInfo;
import com.sitech.family.common.dto.RequestMessage;
import com.sitech.family.compservice.dto.indto.CheckCodeInDto;
import com.sitech.family.compservice.dto.indto.GetCheckCodeInDto;
import com.sitech.family.compservice.dto.indto.UserInfoQryInDto;
import com.sitech.family.compservice.dto.outdto.UserInfoOutDto;
import com.sitech.family.compservice.inter.IUserInfoCoSvc;
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
 * @Description  用户基本信息查询
 * @date 2019/01/15
 */
@Service("UserInfoCoSvc")
public class UserInfoCoSvc implements IUserInfoCoSvc {

    private static Logger logger = LoggerFactory.getLogger(UserInfoCoSvc.class);

    @Resource
    private IUserInfoCo iUserInfoCo;

    @Override
    @ResponseBody
    @RequestMapping("/sUserInfoQry")
    public OutDTO qryUserInfo(@Valid @RequestBody InDTO<RequestMessage<UserInfoQryInDto>> requestMessage) {
        if(StringUtil.isEmptyOrNull(requestMessage.getBody().getBusiInfo())){
            throw new BusiException(getErrorCode("1000", "160001"), "入参节点BUSI_INFO不能为空!");
        }
        //要传递的参数
        UserInfoQryInDto userInfoQryInDto = requestMessage.getBody().getBusiInfo();
        OprInfo oprInfo = requestMessage.getBody().getOprInfo();

        OutDTO outDTO = iUserInfoCo.query(userInfoQryInDto,oprInfo);

        return outDTO;
    }

    @Override
    @ResponseBody
    @RequestMapping("/sGetCheckCode")
    public OutDTO<Object> qryCheckCode(@Valid @RequestBody InDTO<RequestMessage<GetCheckCodeInDto>> requestMessage) {
        if(StringUtil.isEmptyOrNull(requestMessage.getBody().getBusiInfo())){
            throw new BusiException(getErrorCode("1000", "160001"), "入参节点BUSI_INFO不能为空!");
        }
        //要传递的参数
        GetCheckCodeInDto busiInfo = requestMessage.getBody().getBusiInfo();
        OprInfo oprInfo = requestMessage.getBody().getOprInfo();
        OutDTO<Object> outDto = iUserInfoCo.qryCheckCode(busiInfo,oprInfo);
        return outDto;
    }

    /**
     * 验证码或密码提交校验
     *
     * @param requestMessage
     * @return
     */
    @Override
    @ResponseBody
    @RequestMapping("/sCheckCode")
    public OutDTO<Object> chkCheckCode(@Valid@RequestBody  InDTO<RequestMessage<CheckCodeInDto>> requestMessage) {
        if(StringUtil.isEmptyOrNull(requestMessage.getBody().getBusiInfo())){
            throw new BusiException(getErrorCode("1000", "160001"), "入参节点BUSI_INFO不能为空!");
        }
        CheckCodeInDto busiInfo = requestMessage.getBody().getBusiInfo();
        OprInfo oprInfo = requestMessage.getBody().getOprInfo();
        OutDTO<Object> outDto = iUserInfoCo.chkCheckCode(busiInfo,oprInfo);
        return outDto;
    }
}
