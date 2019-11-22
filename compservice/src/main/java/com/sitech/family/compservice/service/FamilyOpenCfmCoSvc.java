package com.sitech.family.compservice.service;

import com.sitech.family.common.dto.OprInfo;
import com.sitech.family.common.dto.RequestMessage;
import com.sitech.family.compservice.compbiz.IFamilyOpenCo;
import com.sitech.family.compservice.dto.indto.FamilyOpenCfmInDto;
import com.sitech.family.compservice.inter.IFamilyOpenCfmCoSvc;
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
 * Created by xuwei on 2019/4/16.
 */

@Service("sFamilyOpenCfm")
public class FamilyOpenCfmCoSvc implements IFamilyOpenCfmCoSvc {
    private static Logger logger = LoggerFactory.getLogger(FamilyOpenCfmCoSvc.class);

    @Resource(name = "FamilyOpenCoImpl")
    private  IFamilyOpenCo familyOpenCo;

    @Override
    @ResponseBody
    @RequestMapping("/sFamilyOpenCfm")
    public OutDTO<Object> cfmFamilyOpen(@Valid @RequestBody(required = false) InDTO<RequestMessage<FamilyOpenCfmInDto>> requestMessage) {
        if(StringUtil.isEmptyOrNull(requestMessage.getBody().getBusiInfo())){
            throw new BusiException(getErrorCode("1000", "160300"), "家庭业务开户入参节点BUSI_INFO不能为空!");
        }
        FamilyOpenCfmInDto familyOpenCfmInDto = requestMessage.getBody().getBusiInfo();
        OprInfo oprInfo = requestMessage.getBody().getOprInfo();
        OutDTO<Object> outDTO = familyOpenCo.create(familyOpenCfmInDto, oprInfo);
        return outDTO;
    }
}
