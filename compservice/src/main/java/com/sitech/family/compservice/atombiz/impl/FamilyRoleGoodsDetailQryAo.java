package com.sitech.family.compservice.atombiz.impl;

import com.alibaba.fastjson.JSONArray;
import com.sitech.family.common.util.ChkOutParamUtil;
import com.sitech.family.common.util.PackHeaderOprInfo;
import com.sitech.family.compservice.atombiz.IGoodsQryAo;
import com.sitech.family.compservice.dto.indto.FamilyRoleGoodsDetailInDto;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.service.ArchitectureType;
import com.sitech.ijcf.boot.core.service.client.IServiceClient;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.ijcf.message6.dt.support.MBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: wusm
 * @Date: 2019-09-09 15:28
 * @Version: 1.0
 */
@Component("FamilyRoleGoodsDetailQry")
public class FamilyRoleGoodsDetailQryAo implements IGoodsQryAo {

    @Resource
    private IServiceClient serviceClient;

    /**
     * 原子服务产商品公共查询方法
     *
     * @param map
     * @return map
     */
    @Override
    public Map query(Map<String, Object> map) {
        OutDTO<Map> mapOutDTO = new OutDTO<>();
        Map outMap = new HashMap();

        try {
            MBean mBean = new MBean();

            //封装产商品HEADER和OPRINFO节点
            mBean = PackHeaderOprInfo.packHeaderOprInfo(map);

            FamilyRoleGoodsDetailInDto familyRoleGoodsDetail = (FamilyRoleGoodsDetailInDto) map.get("busiInfo");

            Map<String,String> busiMap = new HashMap<>();
            busiMap.put("PACKGE_PRC",familyRoleGoodsDetail.getPkgprcId());
            busiMap.put("ELEMENT_ID",familyRoleGoodsDetail.getElementId());

            mBean.addBody("BUSI_INFO",busiMap);

            mapOutDTO = serviceClient.callService("http://pgcent-family/sRoleGoodsDetailQrySvc",
                    mBean.toString(), OutDTO.class, ArchitectureType.SPRINGCLOUD);

            ChkOutParamUtil.chkOutParam(mapOutDTO);

            Map<Object, JSONArray> mapData = mapOutDTO.getBodyOutData();

            JSONArray jsonArray = mapData.get("GOODS_LIST");

            outMap.put("GOODS_LIST",jsonArray);
        } catch (Exception e) {
            throw new BusiException("-9999", e.getMessage());
        }
        return outMap;
    }
}
