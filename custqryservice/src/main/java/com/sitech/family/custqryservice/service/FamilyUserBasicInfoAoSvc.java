package com.sitech.family.custqryservice.service;

import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custqryservice.compbusi.IFamilyUserBasicInfoCo;
import com.sitech.family.custqryservice.dto.commondto.OprInfo;
import com.sitech.family.custqryservice.dto.commondto.RequestMessage;
import com.sitech.family.custqryservice.inter.IFamilyUserBasicInfoAoSvc;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 家庭用户基本信息查询
 *
 * @author liangjy
 * @date created in 2019/8/7
 */
@Service
@Api("家庭用户基本信息查询")
public class FamilyUserBasicInfoAoSvc implements IFamilyUserBasicInfoAoSvc {

    private static final Logger logger = LoggerFactory.getLogger(FamilyUserBasicInfoAoSvc.class);

    @Resource
    private IFamilyUserBasicInfoCo iFamilyUserBasicInfoCo;

    @Override
    @ResponseBody
    @RequestMapping("sFamilyUserBasicInfoQry")
    public OutDTO<Object> qryFamilyUserBasicInfo(@RequestBody InDTO<RequestMessage<Map>> inDTO) {

        OprInfo oprInfo = inDTO.getBody().getOprInfo();
        Map busiInfo = inDTO.getBody().getBusiInfo();

        Object idNo = busiInfo.get("ID_NO");
        if(StringUtil.isEmptyOrNull(idNo)){
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(),"请求失败","入参不能为空");
        }
        try{
            Map<String,Object> mapData = iFamilyUserBasicInfoCo.qryFamilyUserBasicInfo(busiInfo);

            OutDTO<Object> outDTO = new OutDTO<>();
            outDTO.setHeader(inDTO.getBodyHeader().getHeader());
            outDTO.setBodyOutData(mapData);
            logger.debug(""+outDTO);
            return outDTO;
        }catch(Exception e){
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(),"svc处理失败",e.getMessage());
        }

    }
}
