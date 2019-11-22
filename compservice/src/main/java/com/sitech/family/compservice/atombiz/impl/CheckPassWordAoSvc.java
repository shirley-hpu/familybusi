package com.sitech.family.compservice.atombiz.impl;

import com.sitech.family.common.dto.OprInfo;
import com.sitech.family.compservice.atombiz.ICheckPassWordAo;
import com.sitech.family.compservice.dto.indto.CheckPassWordInDto;
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
 * @Description  密码校验服务
 * @date 2019/1/22 15:10
 */
@Component("CheckPassWordAoSvc")
public class CheckPassWordAoSvc implements ICheckPassWordAo {
    private static Logger logger = LoggerFactory.getLogger(CheckPassWordAoSvc.class);
    @Resource
    private IServiceClient serviceClient;
    @Override
    public OutDTO<Object> checkPassWord(CheckPassWordInDto checkPassWordInDto, OprInfo requestMessage) {
        OutDTO<Object> outDTO = new OutDTO<>();
        MBean mBean = new MBean();
        String outParam = "";
        try {
            Map<String, Object> busiInfo = new HashMap<>();//拼接查询参数节点下的信息
            busiInfo.put("USER_PASSWD", checkPassWordInDto.getUserPasswd());

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
           /* OutDTO<Map> mapOutDTO = serviceClient.callService("com_sitech_custsvc_comp_inter_IChkPwdCoSvc_checkPassWord",
                    mBean.toString(), OutDTO.class);
            logger.info("mapOutDTO=", mapOutDTO);*/
            //outDTO.setBodyOutData(mapOutDTO);
            //做测试数据
            Map<String, Object> map = new HashMap<>(16);
            map.put("USER_PASSWD","当然是正确的啊");

            outDTO.setBodyOutData(map);

        } catch (Exception e) {
            e.printStackTrace();
            throw new BusiException(getErrorCode("1000", "160054","调用密码校验服务接口错误" ), e);
        }

        return outDTO;
    }
}