package com.sitech.family.compservice.compbiz.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
@Component("FamilyGoodsDictQryCo")
public class FamilyGoodsDictQryCo implements IFamilyGoodsQryCo {

    private static final Logger logger = LoggerFactory.getLogger(FamilyGoodsDictQryCo.class);

    /**
     * 成员资费
     */
    @Resource(name = "qryGoodsDictAo")
    private IGoodsQryAo qryGoodsDictAo;

    @Override
    public Map query(Map<String, Object> inDTO) {

        try {
            //获取入参 调用原子服务
            Map qryOutDto = qryGoodsDictAo.query(inDTO);
            //获取出参
            JSONObject bodyOutData = (JSONObject) qryOutDto.get("GOODS_PRC_INFO");
            //获取出参节点
            GoodsPrcInfo goodsPrcInfo = new GoodsPrcInfo();
            goodsPrcInfo.setPrcId(bodyOutData.getString("PRC_ID"));
            goodsPrcInfo.setPrcName(bodyOutData.getString("PRC_NAME"));
            goodsPrcInfo.setPrcDesc(bodyOutData.getString("PRC_DESC"));
            goodsPrcInfo.setGoodsId(bodyOutData.getString("GOODS_ID"));
            goodsPrcInfo.setGoodsName(bodyOutData.getString("GOODS_NAME"));
            goodsPrcInfo.setGoodsType(bodyOutData.getString("GOODS_TYPE"));
            goodsPrcInfo.setSvcId(bodyOutData.getString("SVC_ID"));
            goodsPrcInfo.setProdId(bodyOutData.getString("PROD_ID"));
            goodsPrcInfo.setEffDate(bodyOutData.getString("EFF_DATE"));
            goodsPrcInfo.setExpDate(bodyOutData.getString("EXP_DATE"));
            goodsPrcInfo.setMasterServId(bodyOutData.getString("MASTER_SERV_ID"));
            goodsPrcInfo.setFreeSum(bodyOutData.getString("FREE_SUM"));
            goodsPrcInfo.setUseRange(bodyOutData.getString("USE_RANGE"));
            goodsPrcInfo.setGroupType(bodyOutData.getString("GROUP_TYPE"));
            goodsPrcInfo.setPictureUrl(bodyOutData.getString("PICTURE_URL"));

            Map<String, Object> map = new HashMap<>(1);
            map.put("GOODS_PRC_INFO", goodsPrcInfo);
            return map;

        } catch (Exception e) {
            throw new BusiException("处理失败", e.getMessage());
        }
    }
}
