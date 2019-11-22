package com.sitech.family.compservice.atombiz.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sitech.family.common.util.CommonCheckUtil;
import com.sitech.family.common.util.PackHeaderOprInfo;
import com.sitech.family.compservice.atombiz.IFamilyUserDefaultMainGoodsQryAo;
import com.sitech.family.compservice.service.FamilyUserDefaultMainGoodsQryCoSvc;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.service.ArchitectureType;
import com.sitech.ijcf.boot.core.service.client.IServiceClient;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.ijcf.message6.dt.support.MBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Zhangc
 * @version 1.0
 * @date 2019/8/23 13:41
 */
@Component
public class FamilyUserDefaultMainGoodsQryAo implements IFamilyUserDefaultMainGoodsQryAo {

    private static final Logger logger = LoggerFactory.getLogger(FamilyUserDefaultMainGoodsQryCoSvc.class);
    @Resource
    private IServiceClient serviceClient;

    @Override
    public Map query(Map<String, Object> param) {
        try {
            MBean mBean = PackHeaderOprInfo.packHeaderOprInfo(param);
            String prcId = (String)param.get("PKGPRC_ID");
            Map<String, Object> busiMap = new HashMap<>();
            busiMap.put("PKGPRC_ID", prcId);
            mBean.addBody("BUSI_INFO", busiMap);
            //调用产商品中心服务
            OutDTO<Map> mapOutDTO = serviceClient.callService("http://pgcent-family/sPMemHotPrcQrySvc",
                    mBean.toString(), OutDTO.class, ArchitectureType.SPRINGCLOUD);

            CommonCheckUtil.getOutParamCheck(mapOutDTO);

            JSONObject jsonObject = JSONObject.parseObject(mapOutDTO.toJsonString());
            /*JSONArray outData = jsonObject.getJSONObject("ROOT").getJSONObject("BODY").
                    getJSONObject("OUT_DATA").getJSONArray("MBR_OPEN_LIST");*/
            JSONObject outData = jsonObject.getJSONObject("ROOT").getJSONObject("BODY").
                    getJSONObject("OUT_DATA");

            logger.debug("出参结果 ===>" + outData);

            Map<String, Object> map = new HashMap<>();
            map.put("MBR_OPEN_LIST", outData);

            return map;
        }catch (Exception e){
            throw new BusiException("99999999999999999", "默认主商品查询失败", e.getMessage());
        }
    }
}
