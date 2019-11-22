package com.sitech.family.compservice.atombiz.impl;

import com.sitech.family.common.util.ChkOutParamUtil;
import com.sitech.family.common.util.PackHeaderOprInfo;
import com.sitech.family.compservice.atombiz.IGoodsQryAo;
import com.sitech.family.compservice.dto.indto.FamilyOrderPrcAttr;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.service.ArchitectureType;
import com.sitech.ijcf.boot.core.service.client.IServiceClient;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.ijcf.message6.dt.support.MBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: wusm
 * @Date: 2019-09-25 15:23
 * @Version: 1.0
 */
@Component("familyOrderPrcAttrQryAo")
public class FamilyOrderPrcAttrQryAo implements IGoodsQryAo {

    @Autowired
    private IServiceClient serviceClient;

    /**
     * 原子服务产商品公共查询方法
     *
     * @param map
     * @return map
     */
    @Override
    public Map query(Map<String, Object> map) {
        Map outMap = new HashMap();
        OutDTO<Map> mapOutDTO = new OutDTO<>();

        try {
            MBean mBean = new MBean();

            //封装产商品HEADER和OPRINFO节点
            mBean = PackHeaderOprInfo.packHeaderOprInfo(map);

            FamilyOrderPrcAttr familyOrderPrcAttr = (FamilyOrderPrcAttr) map.get("busiInfo");

            Map<String, String> busiMap = new HashMap<>();
            busiMap.put("ID_NO", familyOrderPrcAttr.getIdNo());
            busiMap.put("PRC_ID", familyOrderPrcAttr.getPrcId());

            mBean.addBody("BUSI_INFO", busiMap);

            mapOutDTO = serviceClient.callService("http://familybusi-custqryservice/sFamilyOrderPrcAttrQry",
                    mBean.toString(), OutDTO.class, ArchitectureType.SPRINGCLOUD);

            ChkOutParamUtil.chkOutParam(mapOutDTO);

            outMap.put("ATTR_LIST",mapOutDTO.getBodyOutData().get("ATTR_LIST"));

            return outMap;
        } catch (Exception e){
            throw new BusiException("-9999",e.getMessage());
        }
    }
}
