package com.sitech.family.compservice.atombiz.impl;

import com.sitech.family.compservice.atombiz.IFamilyOpenAo;
import com.sitech.family.compservice.dto.indto.UniOrderInfoDto;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.service.client.IServiceClient;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuwei on 2019/4/24.
 */

@Component("createUniOrderAo")
public class FamilyOpenAo implements IFamilyOpenAo {
    @Resource
    private IServiceClient serviceClient;

    private static final Logger logger = LoggerFactory.getLogger(FamilyOpenAo.class);

    @Override
    public OutDTO<Object> createUniOrder(UniOrderInfoDto.FamilyOrderBodyInfoDto familyOrderBodyInfoDto)
    {
        try {
            Map<String, Object>  map = new HashMap();
            System.out.println("进入调用全网订单创建服务");
            OutDTO<Object> outDTO= serviceClient.callService("com_sitech_crm_order_inter_service_UniOrderInfoService_createOrderInfoPubService",
                    familyOrderBodyInfoDto, OutDTO.class);
            outDTO.getBodyOutData().toString();
            return outDTO;
        } catch (Exception e) {
            throw new BusiException("创建全网订单错误", e.getMessage());
        }
    }
}
