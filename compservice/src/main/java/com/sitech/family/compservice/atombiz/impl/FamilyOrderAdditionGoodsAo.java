package com.sitech.family.compservice.atombiz.impl;

import com.sitech.family.common.util.ChkOutParamUtil;
import com.sitech.family.common.util.PackHeaderOprInfo;
import com.sitech.family.compservice.atombiz.IGoodsQryAo;
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
 * @Date: 2019-09-20 10:14
 * @Version: 1.0
 */
@Component("FamilyOrderAdditionGoodsAo")
public class FamilyOrderAdditionGoodsAo implements IGoodsQryAo {

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

            Map<String, Object> busiMap = new HashMap<>();
            busiMap.put("ID_NO",map.get("idNo"));

            mBean.addBody("BUSI_INFO", busiMap);

            mapOutDTO = serviceClient.callService("http://familybusi-custqryservice/sFamilyOrderAdditionGoodsQry",
                    mBean.toString(), OutDTO.class, ArchitectureType.SPRINGCLOUD);

            ChkOutParamUtil.chkOutParam(mapOutDTO);

            outMap = mapOutDTO.getBodyOutData();
        } catch (Exception e) {
            throw new BusiException("-9999", e.getMessage());
        }

        return outMap;
    }
}
