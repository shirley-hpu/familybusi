package com.sitech.family.compservice.atombiz.impl;

import com.sitech.family.common.dto.OprInfo;
import com.sitech.family.compservice.atombiz.ISubPrcCheckAo;
import com.sitech.family.compservice.dto.indto.SubPrcCheckInDto;
import com.sitech.family.compservice.dto.outdto.SubPrcCheckOutDto;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.service.client.IServiceClient;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.ijcf.message6.dt.support.MBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author guanqp
 * @Description  主资费校验
 * @date 2019/3/13 10:12
 */
@Component("SubPrcCheckAoSvc")
public class SubPrcCheckAoSvc implements ISubPrcCheckAo {

    private static Logger logger = LoggerFactory.getLogger(SubPrcCheckAoSvc.class);

    @Resource
    private IServiceClient serviceClient;

    @Override
    public OutDTO<SubPrcCheckOutDto> subPrcCheckAo(SubPrcCheckInDto subPrcCheckInDto, OprInfo requestMessage) {

        MBean mBean = new MBean();
        OutDTO outDTO = new OutDTO<>();
        ParameterizedTypeReference inpara = new ParameterizedTypeReference<OutDTO<SubPrcCheckOutDto>>(){};
        String outParam = "";
        try {
            //拼接查询参数节点下的信息
            Map<String, Object> busiInfo = new HashMap<>();
            busiInfo.put("ID_NO", subPrcCheckInDto.getIdNo());
            busiInfo.put("GROUP_ID", subPrcCheckInDto.getGroupId());
            busiInfo.put("ACTION", subPrcCheckInDto.getAction());
            busiInfo.put("POWER_CODE", subPrcCheckInDto.getPowerCode());
            busiInfo.put("PARPRC_ID", subPrcCheckInDto.getParprcId());
            busiInfo.put("SEL_BUSI", subPrcCheckInDto.getSelBusi());
            busiInfo.put("BUY_BUSI", subPrcCheckInDto.getBuyBusi());

            Map<String, Object> oprInfo = new HashMap<>();

            oprInfo.put("CONTACT_ID",requestMessage.getContactId());
            oprInfo.put("REGION_ID",requestMessage.getRegionId());
            oprInfo.put("LOGIN_NO",requestMessage.getLoginNo());
            oprInfo.put("OP_CODE",requestMessage.getOpCode());
            oprInfo.put("OP_NOTE",requestMessage.getOpNote());
            oprInfo.put("CHANNEL_TYPE",requestMessage.getChannelType());
            oprInfo.put("APPLY_ID",requestMessage.getApplyId());
            mBean.addBody("BUSI_INFO", busiInfo);
            mBean.addBody("OPR_INFO", oprInfo);
            OutDTO<SubPrcCheckOutDto> mapOutDTO = serviceClient.callService("com_sitech_pgmng_comp_inter_IMoreBusiRelChkCoSvc_chkMoreBusiRel",
                    mBean.toString(), inpara);
            logger.info("mapOutDTO=", mapOutDTO);
            outDTO.setBodyOutData(mapOutDTO);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusiException(getErrorCode("1000", "160054","调用资费校验服务接口错误" ), e);
        }

        return outDTO;
    }
}
