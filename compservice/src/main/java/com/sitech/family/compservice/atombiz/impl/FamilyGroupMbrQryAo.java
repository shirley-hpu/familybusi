package com.sitech.family.compservice.atombiz.impl;

import com.sitech.family.common.util.PackHeaderOprInfo;
import com.sitech.family.compservice.atombiz.IFamilyGroupMbrQryAo;
import com.sitech.family.compservice.dto.indto.FamilyGroupMbrInDto;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.service.ArchitectureType;
import com.sitech.ijcf.boot.core.service.client.IServiceClient;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.ijcf.message6.dt.support.MBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author Zhangc
 * @version 1.0
 * @date 2019/8/2 14:53
 */
@Component("familyGroupMbrQryAo")
public class FamilyGroupMbrQryAo implements IFamilyGroupMbrQryAo {

    @Resource
    private IServiceClient serviceClient;

    @Override
    public OutDTO<Object> qryFamilyGroupMbr(Map<String, Object> map) {
        OutDTO<Map> mapOutDTO = new OutDTO<>();
        Map<String,Object> groupMbr = new HashMap<>();
        try {
            MBean mBean = new MBean();
            mBean = PackHeaderOprInfo.packHeaderOprInfo(map);
            FamilyGroupMbrInDto mbrInDto = (FamilyGroupMbrInDto)map.get("BUSI_INFO");
            Map<String, String> busiInfo = new HashMap<>();
            busiInfo.put("GROUP_ID",mbrInDto.getGroupId());
            mBean.addBody("BUSI_INFO", busiInfo);

            OutDTO<Object> outDTO = serviceClient.callService("http://familybusi-custqryservice/sFamilyGroupMbrQry",
                    mBean.toString(), OutDTO.class, ArchitectureType.SPRINGCLOUD);
            return outDTO;
        }catch (Exception e){
            throw new BusiException(getErrorCode("1000", "15000"), "群成员信息查询失败" + e.getMessage());
        }
    }
}
