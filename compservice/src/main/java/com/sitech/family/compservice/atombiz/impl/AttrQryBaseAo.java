package com.sitech.family.compservice.atombiz.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sitech.family.common.util.ChkOutParamUtil;
import com.sitech.family.common.util.PackHeaderOprInfo;
import com.sitech.family.compservice.atombiz.IGoodsQryAo;
import com.sitech.family.compservice.dto.indto.FamilyGoodsPrcAttr;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.service.ArchitectureType;
import com.sitech.ijcf.boot.core.service.client.IServiceClient;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.ijcf.message6.dt.support.MBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author wusm
 * @description 商品定价属性查询
 * @date 2019/4/1 09:07
 */
@Component("AttrQryBaseAo")
public class AttrQryBaseAo implements IGoodsQryAo {

    private static Logger logger = LoggerFactory.getLogger(AttrQryBaseAo.class);

    @Autowired
    private IServiceClient serviceClient;

    /**
     * 商品定价属性查询
     *
     * @param map
     * @return outDTO
     */
    @Override
    public Map query(Map<String, Object> map) {
        OutDTO<Map> mapOutDTO = new OutDTO<>();
        Map prcAndSvcMap = new HashMap();

        try {
            MBean mBean = new MBean();

            //封装产商品HEADER和OPRINFO节点
            mBean = PackHeaderOprInfo.packHeaderOprInfo(map);

            //拼接产商品接口busiInfo节点
            FamilyGoodsPrcAttr familyGoodsPrcAttr = (FamilyGoodsPrcAttr) map.get("busiInfo");

            Map<String, Object> attrMap = new HashMap<>();
            attrMap.put("REGION_ID", "");
            attrMap.put("DIV_FLAG", "");
            attrMap.put("ID_NO", "");
            attrMap.put("GROUP_ID", "");
            attrMap.put("CUST_ID", "");
            attrMap.put("MASTER_SERV_ID", "");

            Map<String, Object> busiMap = new HashMap<>();
            busiMap.put("PRC_ID", familyGoodsPrcAttr.getPrcId());
            busiMap.put("GOODS_ID", "");
            busiMap.put("SVC_ID", "");
            busiMap.put("MEMBER_ID", "");
            busiMap.put("GROUP_TYPE", "");
            busiMap.put("GROUP_ID_NO", "");

            attrMap.put("ATTR_PARAM", busiMap);

            mBean.addBody("BUSI_INFO", attrMap);

            mapOutDTO = serviceClient.callService("http://pgcent-family/sAttrArrayQrySvc",
                    mBean.toString(), OutDTO.class, ArchitectureType.SPRINGCLOUD);

            //出参报文校验
            ChkOutParamUtil.chkOutParam(mapOutDTO);

            JSONArray attrArray = (JSONArray) mapOutDTO.getBodyOutData().get("ATTR_LIST");

            for (int i = 0; i < attrArray.size(); i++) {
                JSONObject attrObject = (JSONObject) attrArray.get(i);

                if ("资费属性".equals(attrObject.getString("ELEMENT_NAME"))) {
                    JSONArray attrEleArray = attrObject.getJSONArray("ELEMENT_LIST");

                    List<Map> attrlist = new ArrayList<>();
                    for (int j = 0; j < attrEleArray.size(); j++) {
                        JSONObject attrEleObject = (JSONObject) attrEleArray.get(j);

                        Map<String, String> elementMap = new HashMap<>();
                        elementMap.put("ATTR_DESC", attrEleObject.getString("ATTR_DESC"));
                        elementMap.put("ATTR_ID", attrEleObject.getString("ATTR_ID"));
                        attrlist.add(elementMap);
                    }

                    prcAndSvcMap.put("PRCATTRLIST", attrlist);
                }

                if ("服务属性".equals(attrObject.getString("ELEMENT_NAME"))) {
                    JSONArray svcEleArray = attrObject.getJSONArray("ELEMENT_LIST");

                    List<Map> svclist = new ArrayList<>();
                    for (int j = 0; j < svcEleArray.size(); j++) {
                        JSONObject svcEleObject = (JSONObject) svcEleArray.get(j);

                        Map<String, String> elementMap = new HashMap<>();
                        elementMap.put("ATTR_ID", svcEleObject.getString("ATTR_ID"));
                        elementMap.put("ATTR_DESC", svcEleObject.getString("ATTR_DESC"));
                        svclist.add(elementMap);
                    }

                    prcAndSvcMap.put("SVCATTRLIST", svclist);
                }
            }

            return prcAndSvcMap;
        } catch (Exception e) {
            logger.error("商品定价属性查询失败" + e.getMessage());
            throw new BusiException("-9999", e.getMessage());
        }
    }
}
