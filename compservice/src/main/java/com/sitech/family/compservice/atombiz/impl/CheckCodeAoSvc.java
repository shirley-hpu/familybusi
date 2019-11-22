package com.sitech.family.compservice.atombiz.impl;

import com.sitech.family.common.dto.OprInfo;
import com.sitech.family.compservice.atombiz.ICheckCodeAo;
import com.sitech.family.compservice.dto.indto.CheckCodeInDto;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.service.ArchitectureType;
import com.sitech.ijcf.boot.core.service.client.IServiceClient;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.ijcf.message6.dt.support.MBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author guanqp
 * @Description 验证码校验
 * @date 2019/1/21 18:13
 */
@Component("CheckCodeAoSvc")
public class CheckCodeAoSvc implements ICheckCodeAo {

    private static Logger logger = LoggerFactory.getLogger(CheckCodeAoSvc.class);

    @Resource
    private IServiceClient serviceClient;

    @Override
    public OutDTO<Object> checkCode(CheckCodeInDto checkCodeInDto, OprInfo requestMessage) {
        OutDTO<Object> outDTO = new OutDTO<>();
        MBean chkMBean = new MBean();
        MBean pwdMBean = new MBean();
        String outParam = "";
        try {
            /**
             * 拼接密码校验查询参数节点下的信息
             */
            Map<String, Object> busiInfo = new HashMap<>();
            busiInfo.put("CHK_PWD", checkCodeInDto.getChkPwd());

            Map<String, Object> oprInfo = new HashMap<>();

            oprInfo.put("CONTACT_ID", requestMessage.getContactId());
            oprInfo.put("REGION_ID", requestMessage.getRegionId());
            oprInfo.put("LOGIN_NO", requestMessage.getLoginNo());
            oprInfo.put("OP_CODE", requestMessage.getOpCode());
            oprInfo.put("OP_NOTE", requestMessage.getOpNote());
            oprInfo.put("CHANNEL_TYPE", requestMessage.getChannelType());
            oprInfo.put("APPLY_ID", requestMessage.getApplyId());
            pwdMBean.addBody("BUSI_INFO", busiInfo);
            pwdMBean.addBody("OPR_INFO", oprInfo);
            /**
             * 拼接查询验证码参数节点下的信息  1、拼接oprinfo 2、拼接busiInfo 3、用callService,调用私有服务
             */
            Map<String, Object> oprInfo1 = new HashMap<>();
            oprInfo1.put("CONTACT_ID", requestMessage.getContactId());
            oprInfo1.put("REGION_ID", requestMessage.getRegionId());
            oprInfo1.put("LOGIN_NO", requestMessage.getLoginNo());
            oprInfo1.put("OP_CODE", "2222");
            oprInfo1.put("OP_NOTE", requestMessage.getOpNote());
            oprInfo1.put("CHANNEL_TYPE", requestMessage.getChannelType());
            oprInfo1.put("LOGIN_ACCEPT", "110642");
            oprInfo1.put("GROUP_ID", requestMessage.getGroupId());
            oprInfo1.put("SYSTEM_NOTE", "2451");
            oprInfo1.put("CREATE_TIME", "5223");

            Map<String, Object> checkBusiInfo = new HashMap<>();

            checkBusiInfo.put("CHECK_CODE", "000000");   //随机码，这里不重要，只是为做非空校验
            checkBusiInfo.put("PHONE_NO", checkCodeInDto.getPhoneNo());  //重要，根据号码查询验证码
            checkBusiInfo.put("OP_TIME", "20190302122536");  //操作时间,这里不重要，只是为做非空校验
            checkBusiInfo.put("EFFECTIVE_TIME", "20190302122536"); //有效时间,这里不重要，只是为做非空校验

            chkMBean.addBody("BUSI_INFO", checkBusiInfo);
            chkMBean.addBody("OPR_INFO", oprInfo1);


            //PWD_TYPE为01则做验证码校验，02则做密码校验
            if (null != checkCodeInDto.getPwdType() && checkCodeInDto.getPwdType().equals("01")) {

                OutDTO<Map> mapOutDTO = serviceClient.callService("http://familybusi-custservice/com_sitech_family_custservice_inter_ICustCheckCodeSvc_query",
                        chkMBean.toString(), OutDTO.class,ArchitectureType.SPRINGCLOUD);

                String chkCode = (String) mapOutDTO.getBodyOutData().get("CHECK_CODE");
                String effecTime = (String) mapOutDTO.getBodyOutData().get("EFFECTIVE_TIME");
                String opTime = (String)mapOutDTO.getBodyOutData().get("OP_TIME");

                //判断验证码是否过期，
                boolean b = chkEff(opTime,effecTime);

                if (chkCode.equals(checkCodeInDto.getChkPwd()) && b) {
                    Map<String, Object> map = new HashMap<>(16);
                    map.put("CheckCode", "正确");

                    outDTO.setBodyOutData(map);
                } else {
                    Map<String, Object> map = new HashMap<>(16);
                    map.put("CheckCode", "验证码错误");

                    outDTO.setBodyOutData(map);
                    return outDTO;
                }

            } else if (null != checkCodeInDto.getPwdType() && checkCodeInDto.getPwdType().equals("02")) {
                /* OutDTO<Map> pwdMapOutDTO = serviceClient.callService("com_sitech_custsvc_comp_inter_IChkPwdCoSvc_checkPassWord",
                    pwdMBean.toString(), OutDTO.class);
                logger.info("mapOutDTO=", pwdMapOutDTO);*/
                //outDTO.setBodyOutData(pwdMapOutDTO);
                //做测试数据
                Map<String, Object> map = new HashMap<>(16);
                map.put("CheckCode", "正确");

                outDTO.setBodyOutData(map);

            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new BusiException(getErrorCode("1000", "160053", "调用校验接口错误"), e);
        }

        return outDTO;
    }

    /**
     * 判断验证码是否有效
     *
     * @param effecTime
     * @return
     */
    private boolean chkEff(String opTime,String effecTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now;
        Date opT =Timestamp.valueOf(opTime);
        Long eff = new Long(effecTime);
        boolean flag = false;
        try {
            now = sdf.parse((sdf.format(new Date()).toString()));

            long time1 = now.getTime();
            long time2 = opT.getTime();
            long diff = time1 - time2;
            if (diff / 1000 < eff) {
                flag = true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return flag;
    }


}