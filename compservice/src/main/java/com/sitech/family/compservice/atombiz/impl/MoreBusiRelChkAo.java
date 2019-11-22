package com.sitech.family.compservice.atombiz.impl;

import com.sitech.family.common.JsonReader;
import com.sitech.family.common.dto.OprInfo;
import com.sitech.family.common.util.ChkOutParamUtil;
import com.sitech.family.common.util.PackHeaderOprInfo;
import com.sitech.family.compservice.atombiz.IGoodsChkAo;
import com.sitech.family.compservice.dto.indto.FamilyGoodsChk;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.service.ArchitectureType;
import com.sitech.ijcf.boot.core.service.client.IServiceClient;
import com.sitech.ijcf.boot.core.util.StringUtil;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.ijcf.message6.dt.support.MBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.*;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author wusm
 * @description 关系校验原子实体调用产商品接口服务
 * @date 2018/9/28 16:30
 */
@Component("MoreBusiRelChkAo")
public class MoreBusiRelChkAo implements IGoodsChkAo {

    private static Logger logger = LoggerFactory.getLogger(MoreBusiRelChkAo.class);

    @Autowired
    private IServiceClient serviceClient;

    @Value(value = "classpath:jsonfiles/goodscheck")
    private org.springframework.core.io.Resource resource;

    @Autowired
    private JsonReader jsonReader;

    /**
     * 关系校验
     *
     * @param map
     * @return outDTO
     */
    @Override
    public Map check(Map<String, Object> map) {
        OutDTO<Map> mapOutDTO = new OutDTO<>();
        Map chkMap = new HashMap();

        try {
            MBean mBean = new MBean();

            //封装产商品HEADER和OPRINFO节点
            mBean = PackHeaderOprInfo.packHeaderOprInfo(map);

            //拼接产商品接口busiInfo节点
            FamilyGoodsChk familyGoodsChk = (FamilyGoodsChk) map.get("busiInfo");
            OprInfo oprInfo = (OprInfo) map.get("oprInfo");

            Map<String, Object> busiMap = new HashMap<>();
            busiMap.put("ACTION", familyGoodsChk.getAction());
            busiMap.put("CHG_FLAG", "");
            busiMap.put("CHOOSE_FLAG", "");
            busiMap.put("CUST_ID", "");
            busiMap.put("FUN_EXP_DATE", familyGoodsChk.getPrcId());
            busiMap.put("GROUP_ID", oprInfo.getGroupId());
            busiMap.put("EFF_DATE", familyGoodsChk.getEffDate());
            busiMap.put("EXP_DATE", familyGoodsChk.getExpDate());
            busiMap.put("GOODSINS_ID", "");
            busiMap.put("GOODS_ID", familyGoodsChk.getGoodsId());
            busiMap.put("OP_TYPE", familyGoodsChk.getOpType());
            busiMap.put("PARPRC_ID", "");
            busiMap.put("PRC_ID", familyGoodsChk.getPrcId());
            busiMap.put("ID_NO", familyGoodsChk.getIdNo());

            if (StringUtil.isNotEmptyOrNull(familyGoodsChk.getFamilySelGoodsList())) {
                List<FamilyGoodsChk.FamilySelGoods> familySelGoodsList = familyGoodsChk.getFamilySelGoodsList();

                List<Map> mapList = new ArrayList<Map>();
                for (FamilyGoodsChk.FamilySelGoods familySelGoods : familySelGoodsList) {
                    Map<String, String> selMap = new HashMap<>();
                    selMap.put("EFF_DATE", familySelGoods.getEffDate());
                    selMap.put("EXP_DATE", familySelGoods.getExpDate());
                    selMap.put("GOODSINS_ID", "");
                    selMap.put("GOODS_ID", familySelGoods.getGoodsId());
                    selMap.put("OP_TYPE", familySelGoods.getOpType());
                    selMap.put("PARPRC_ID", "");
                    selMap.put("PRC_ID", familySelGoods.getPrcId());

                    mapList.add(selMap);
                }

                busiMap.put("SEL_BUSI", mapList);
            }
            mBean.addBody("BUSI_INFO", busiMap);

            mapOutDTO = serviceClient.callService("http://pgcent-family/sBusiRelChkCoSvc",
                    mBean.toString(), OutDTO.class, ArchitectureType.SPRINGCLOUD);

            //出参报文校验
            ChkOutParamUtil.chkOutParam(mapOutDTO);

            if (StringUtil.isNotEmptyOrNull(mapOutDTO.getBodyOutData())) {
                chkMap = mapOutDTO.getBodyOutData();
            }

        } catch (Exception e) {
            logger.error("关系校验失败" + e.getMessage());
            throw new BusiException(getErrorCode("1000", "15000"), "关系校验失败" + e.getMessage());
        }

        return chkMap;
    }
}
