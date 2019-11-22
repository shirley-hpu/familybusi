package com.sitech.family.compservice.atombiz.impl;

import com.sitech.family.common.dto.OprInfo;
import com.sitech.family.compservice.atombiz.IGetCheckCodeAo;
import com.sitech.family.compservice.dto.indto.GetCheckCodeInDto;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.service.ArchitectureType;
import com.sitech.ijcf.boot.core.service.client.IServiceClient;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.ijcf.message6.dt.support.MBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author guanqp
 * @Description  获取验证码
 * @date 2019/01/21
 */
@Component("GetCheckCodeAoSvc")
public class GetCheckCodeAoSvc implements IGetCheckCodeAo {

    private static Logger logger = LoggerFactory.getLogger(GetCheckCodeAoSvc.class);

    @Resource
    private IServiceClient serviceClient;

    @Override
    public OutDTO<Object> getCheckCode(GetCheckCodeInDto getCheckCodeInDto, OprInfo requestMessage1) {
        OutDTO<Object> outDTO = new OutDTO<>();
        MBean mBean = new MBean();
        MBean CheckmBean = new MBean();
        String outParam = "";
        try {
            /**
             * 拼接查询参数节点下的信息
             */
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
            Map<String, Object> busiInfo = new HashMap<>();
            busiInfo.put("PWD_TYPE", getCheckCodeInDto.getPwdType());

            Map<String, Object> oprInfo = new HashMap<>();

            oprInfo.put("CONTACT_ID",requestMessage1.getContactId());
            oprInfo.put("REGION_ID",requestMessage1.getRegionId());
            oprInfo.put("LOGIN_NO",requestMessage1.getLoginNo());
            oprInfo.put("OP_CODE",requestMessage1.getOpCode());
            oprInfo.put("OP_NOTE",requestMessage1.getOpNote());
            oprInfo.put("CHANNEL_TYPE",requestMessage1.getChannelType());
            oprInfo.put("APPLY_ID",requestMessage1.getApplyId());
            oprInfo.put("GROUP_ID",requestMessage1.getGroupId());
            mBean.addBody("BUSI_INFO", busiInfo);
            mBean.addBody("OPR_INFO", oprInfo);
           /* OutDTO<Map> mapOutDTO = serviceClient.callService("com_sitech_custsvc_atom_inter_IGetCheckCodeAoSvc_getCheckCodeAO",
                    mBean.toString(), OutDTO.class);

            logger.info("mapOutDTO=", mapOutDTO);*/

           //默认短信下发成功：1、拼接oprinfo 2、拼接busiInfo 3、用callService,调用私有服务
            Map<String, Object> oprInfo1 = new HashMap<>();
            oprInfo1.put("CONTACT_ID",requestMessage1.getContactId());
            oprInfo1.put("REGION_ID",requestMessage1.getRegionId());
            oprInfo1.put("LOGIN_NO",requestMessage1.getLoginNo());
            oprInfo1.put("OP_CODE","252114"); //只是做非空校验
            oprInfo1.put("OP_NOTE",requestMessage1.getOpNote());
            oprInfo1.put("CHANNEL_TYPE",requestMessage1.getChannelType());
            oprInfo1.put("LOGIN_ACCEPT","110642");
            oprInfo1.put("GROUP_ID",requestMessage1.getGroupId());
            oprInfo1.put("SYSTEM_NOTE","2451");
            oprInfo1.put("CREATE_TIME","5223");

            Map<String, Object> checkBusiInfo = new HashMap<>();

            //生成6位随机吗
            checkBusiInfo.put("CHECK_CODE", Integer.toString((int)((Math.random()*9+1)*100000)));
            checkBusiInfo.put("PHONE_NO", getCheckCodeInDto.getPhoneNo());
            checkBusiInfo.put("OP_TIME", sdf.format(new Date()));  //操作时间
            //获取当前时间

            checkBusiInfo.put("EFFECTIVE_TIME", "180"); //有效时间

            CheckmBean.addBody("BUSI_INFO",checkBusiInfo);
            CheckmBean.addBody("OPR_INFO",oprInfo1);

            OutDTO<Map> mapOutDTO = serviceClient.callService("http://familybusi-custservice/sCheckCodeAdd",
                    CheckmBean.toString(), OutDTO.class,ArchitectureType.SPRINGCLOUD);

            logger.info("mapOutDTO=" + mapOutDTO);


            //outDTO.setBodyOutData(mapOutDTO);
            //做假数据
            Map<String, Object> map = new HashMap<>(16);
            map.put("getCheckCode","1008601");

            outDTO.setBodyOutData(map);

        } catch (Exception e) {
            e.printStackTrace();
            throw new BusiException(getErrorCode("1000", "160052","调用获取验证码接口错误" ), e);
        }

        return outDTO;
    }
}