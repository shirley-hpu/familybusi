package com.sitech.family.compservice.compbiz.impl;

import com.alibaba.fastjson.JSONArray;
import com.sitech.family.compservice.atombiz.IGoodsQryAo;
import com.sitech.family.compservice.compbiz.IFamilyGoodsQryCo;
import com.sitech.family.compservice.dto.outdto.GoodsPrcInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 成员资费查询
 *
 * @author shirley
 * @date created in 2019/3/4
 */
@Component("FamilyGoodsMbrQryCo")
public class FamilyGoodsMbrQryCo implements IFamilyGoodsQryCo {

    private static final Logger logger = LoggerFactory.getLogger(FamilyGoodsMbrQryCo.class);

    /**
     * 成员资费
     */
    @Resource(name = "qryFamilyMbrGoodsAo")
    private IGoodsQryAo qryFamilyMbrGoodsAo;

    @Override
    public Map query(Map<String, Object> inDTO) {

        try {
            //获取入参 调用原子服务
            Map<String, Object> qryOutDto = qryFamilyMbrGoodsAo.query(inDTO);
            //获取出参
            JSONArray bodyOutData = (JSONArray) qryOutDto.get("GOODS_LIST");
            //获取出参节点
            List<GoodsPrcInfo> mbrGoodsList = new ArrayList<>();
            //循环取出所需节点参数值
            for (int i = 0; i < bodyOutData.size(); i++) {
                //REPRC_LIST节点循环取值拼参
                JSONArray reprcJson = bodyOutData.getJSONObject(i).getJSONArray("REPRC_LIST");
                GoodsPrcInfo goodsPrcInfo;
                for (int j = 0; j < reprcJson.size(); j++) {
                    goodsPrcInfo = new GoodsPrcInfo();
                    goodsPrcInfo.setPrcId(reprcJson.getJSONObject(j).getString("PRC_ID"));
                    goodsPrcInfo.setPrcName(reprcJson.getJSONObject(j).getString("PRC_NAME"));
                    goodsPrcInfo.setPrcDesc(reprcJson.getJSONObject(j).getString("GOODS_PRC_DESC"));
                    goodsPrcInfo.setEffDate(reprcJson.getJSONObject(j).getString("EFF_DATE"));
                    goodsPrcInfo.setExpDate(reprcJson.getJSONObject(j).getString("EXP_DATE"));
                    goodsPrcInfo.setUseRange(reprcJson.getJSONObject(j).getString("USE_RANGE"));
                    goodsPrcInfo.setPrcType(reprcJson.getJSONObject(j).getString("PRC_TYPE"));
                    goodsPrcInfo.setSelFlag(reprcJson.getJSONObject(j).getString("SEL_FLAG"));
                    mbrGoodsList.add(goodsPrcInfo);
                }
            }

            Map<String, Object> map = new HashMap<>(1);
            map.put("GOODS_PRC", mbrGoodsList);
            return map;

        } catch (Exception e) {
            throw new BusiException("99999999999999999", e.getMessage());
        }
    }
}
