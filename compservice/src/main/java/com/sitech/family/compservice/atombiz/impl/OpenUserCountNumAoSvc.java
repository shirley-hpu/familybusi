package com.sitech.family.compservice.atombiz.impl;

import com.sitech.family.compservice.atombiz.IOpenUserCountNumAo;
import com.sitech.family.compservice.dto.indto.OpenUserInDto;
import com.sitech.family.compservice.dto.outdto.OpenUserCountNumBusiInfoOutDto;
import com.sitech.family.compservice.dto.outdto.OpenUserCountNumOutDto;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.service.client.IServiceClient;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.ijcf.message6.dt.support.MBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author guanqp
 * @Description  一证五号校验
 * @date 2019/01/14
 */
@Component("OpenUserCountNumAoSvc")
public class OpenUserCountNumAoSvc implements IOpenUserCountNumAo {

    private static Logger logger = LoggerFactory.getLogger(OpenUserCountNumAoSvc.class);

    @Resource
    private IServiceClient serviceClient;

    @Override
    public OutDTO<OpenUserCountNumOutDto> OpenUserCountNum(OpenUserInDto requestMessage) {

        MBean mBean = new MBean();
        OutDTO<OpenUserCountNumOutDto> outDTO = new OutDTO<OpenUserCountNumOutDto>();
        String outParam = "";
        try {
            /**
             * 拼接查询参数节点下的信息
             */
            Map<String, Object> busiInfo = new HashMap<>();

            busiInfo.put("RES_OPR", "3");
            busiInfo.put("LOGIN_NO", "wwwwww");
            busiInfo.put("GROUP_", requestMessage.getPhoneNo());
            busiInfo.put("QUERY_FLAG", "4");
            busiInfo.put("OP_CODE", "1000");
            busiInfo.put("MIN_COST_FEE", "0");
            busiInfo.put("NEED_ATTR", "Y");

            mBean.addBody("BUSI_INFO", busiInfo);

           /* OutDTO<Map> mapOutDTO = serviceClient.callService("com_sitech_res_inter_outinter_IUpdNoByNoGrpSvc_updPhoneStatus",
                    mBean.toString(), OutDTO.class);

            logger.info("mapOutDTO=", mapOutDTO);*/

            //outDTO.setBodyOutData(mapOutDTO);
            //做假数据
            OpenUserCountNumOutDto outlist = new OpenUserCountNumOutDto();
            OpenUserCountNumBusiInfoOutDto openUserCountNumBusiInfoOutDto = new OpenUserCountNumBusiInfoOutDto();

            openUserCountNumBusiInfoOutDto.setOpenResults("1");
            openUserCountNumBusiInfoOutDto.setIdIccid("452423199808059562");
            openUserCountNumBusiInfoOutDto.setIdName("身份证");

            outlist.setBusiInfo(openUserCountNumBusiInfoOutDto);
            outDTO.setBodyOutData(outlist);

        } catch (Exception e) {
            e.printStackTrace();
            throw new BusiException(getErrorCode("1000", "160050","调用一号五证校验接口错误" ), e);
        }

        return outDTO;
    }
}
