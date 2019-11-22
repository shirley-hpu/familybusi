package com.sitech.family.compservice.compbiz.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sitech.family.compservice.atombiz.IGoodsQryAo;
import com.sitech.family.compservice.compbiz.IFamilyGoodsQryCo;
import com.sitech.family.compservice.dto.indto.DetailGoodsInfo;
import com.sitech.family.compservice.dto.indto.FamilyGoodsDetailQry;
import com.sitech.family.compservice.dto.outdto.*;
import com.sitech.family.compservice.dto.outdto.FamilyGoodsOutDto;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @description 家庭套餐构成查询
 * @update 2019/3/28 14:46
 **/
@Component("FamilyGoodsDetailQryCo")
public class FamilyGoodsDetailQryCo implements IFamilyGoodsQryCo {

    private static final Logger logger = LoggerFactory.getLogger(FamilyGoodsDetailQryCo.class);

    /**
     * 资费构成
     */
    @Resource(name = "qryGoodsPrcDetailAo")
    private IGoodsQryAo qryGoodsPrcDetailAo;

    /**
     * 成员资费
     */
    @Resource(name = "qryHotPrcAo")
    private IGoodsQryAo qryHotPrcAo;

    /**
     * 资费属性、服务属性
     */
    @Resource(name = "attrQryAo")
    private IGoodsQryAo attrQryAo;

    @Override
    public Map query(Map<String, Object> inDTO) {

        try {

            /// 1、资费属性(PRC_ATTR)、服务属性(SVC_ATTR)
            Map<String, JSONArray> qryAttrOutDto = attrQryAo.query(inDTO);
            //获取出参参数
            JSONArray attrJsonArray = qryAttrOutDto.get("ATTR_LIST");

            // 1.1资费属性
            List<FamilyGoodsAttr> goodsPrcAttrList = new ArrayList<>();
            // 1.2服务属性
            List<FamilyGoodsAttr> goodsSvcAttrList = new ArrayList<>();

            for (int i = 0; i < attrJsonArray.size(); i++) {
                JSONObject jsonObject = attrJsonArray.getJSONObject(i);

                if ("资费属性".equals(jsonObject.get("ELEMENT_NAME"))) {
                    JSONArray elementList = jsonObject.getJSONArray("ELEMENT_LIST");
                    if (StringUtil.isNotEmptyOrNull(elementList)) {
                        for (int j = 0; j < elementList.size(); j++) {
                            FamilyGoodsAttr goodsPrcAttr = new FamilyGoodsAttr();
                            JSONObject json = elementList.getJSONObject(j);
                            goodsPrcAttr.setPrcId(json.getString("PRC_ID"));
                            goodsPrcAttr.setAttrId(json.getString("ATTR_ID"));
                            goodsPrcAttr.setAttrName(json.getString("ELEMENT_NAME"));
                            goodsPrcAttr.setAttrDesc(json.getString("ATTR_DESC"));
                            goodsPrcAttr.setIfDefaultValue(json.getString("IF_DEFAULT_VALUE"));
                            goodsPrcAttr.setState(json.getString("STATE"));
                            goodsPrcAttr.setStateDate(json.getString("STATE_DATE"));
                            goodsPrcAttr.setMinValue(json.getString("MIN_VALUE"));
                            goodsPrcAttr.setMaxValue(json.getString("MAX_VALUE"));
                            goodsPrcAttr.setCreateDate(json.getString("CREATE_DATE"));
                            goodsPrcAttr.setShowOrder(json.getString("SHOW_ORDER"));
                            goodsPrcAttr.setBillSendFlag(json.getString("BILL_SEND_FLAG"));
                            goodsPrcAttr.setEffDate(json.getString("EFF_DATE"));
                            goodsPrcAttr.setExpDate(json.getString("EXP_DATE"));
                            goodsPrcAttr.setDefaultValue(json.getString("DEFAULT_VALUE"));
                            goodsPrcAttr.setGrpNo(json.getString("GRP_NO"));
                            goodsPrcAttrList.add(goodsPrcAttr);
                        }
                    }
                }

                if ("服务属性".equals(jsonObject.get("ELEMENT_NAME"))) {
                    JSONArray elementList = jsonObject.getJSONArray("ELEMENT_LIST");
                    if (StringUtil.isNotEmptyOrNull(elementList)) {
                        for (int j = 0; j < elementList.size(); j++) {
                            FamilyGoodsAttr goodsSvcAttr = new FamilyGoodsAttr();
                            JSONObject json = elementList.getJSONObject(j);
                            goodsSvcAttr.setSvcId(json.getString("SVC_ID"));
                            goodsSvcAttr.setAttrId(json.getString("ATTR_ID"));
                            goodsSvcAttr.setAttrName(json.getString("ELEMENT_NAME"));
                            goodsSvcAttr.setAttrDesc(json.getString("ATTR_DESC"));
                            goodsSvcAttr.setIfDefaultValue(json.getString("IF_DEFAULT_VALUE"));
                            goodsSvcAttr.setState(json.getString("STATE"));
                            goodsSvcAttr.setStateDate(json.getString("STATE_DATE"));
                            goodsSvcAttr.setMinValue(json.getString("MIN_VALUE"));
                            goodsSvcAttr.setMaxValue(json.getString("MAX_VALUE"));
                            goodsSvcAttr.setCreateDate(json.getString("CREATE_DATE"));
                            goodsSvcAttr.setShowOrder(json.getString("SHOW_ORDER"));
                            goodsSvcAttr.setBillSendFlag(json.getString("BILL_SEND_FLAG"));
                            goodsSvcAttr.setEffDate(json.getString("EFF_DATE"));
                            goodsSvcAttr.setExpDate(json.getString("EXP_DATE"));
                            goodsSvcAttr.setDefaultValue(json.getString("DEFAULT_VALUE"));
                            goodsSvcAttr.setGrpNo(json.getString("GRP_NO"));
                            goodsSvcAttrList.add(goodsSvcAttr);
                        }
                    }
                }
            }

            /// 2、资费构成信息
            //资费构成
            Map<String, JSONArray> qryDetailOutDto = qryGoodsPrcDetailAo.query(inDTO);
            JSONArray bodyOutData = qryDetailOutDto.get("GOODS_LIST");


            Map<String,JSONArray> qryHotOutDto = qryHotPrcAo.query(inDTO);
            JSONArray mbrOpenList = qryHotOutDto.get("MBR_OPEN_LIST");


            //获取出参节点
            List<FamilyGroupRole> groupRoleList = new ArrayList<>();
            FamilyGroupRole groupRole;

            //查询所有角色信息
            for (int i = 0; i < bodyOutData.size(); i++) {
                groupRole = new FamilyGroupRole();
                JSONObject jsonObject = bodyOutData.getJSONObject(i);
                groupRole.setRoleName(jsonObject.getString("ROLE_NAME"));
                groupRole.setRoleId(jsonObject.getString("ROLE_ID"));
                groupRole.setMaxAmount(jsonObject.getLong("MAX_AMOUNT"));
                groupRole.setMinAmount(jsonObject.getLong("MIN_AMOUNT"));

                groupRole.setMemberRoleId(jsonObject.getString("MEMBER_ROLE_ID"));
                groupRole.setMemberRoleName(jsonObject.getString("MEMBER_ROLE_NAME"));

                //获取成员角色类型 added by shirley
                groupRole.setSelFlag(jsonObject.getString("SEL_FLAG"));

                if ("70053".equals(groupRole.getMemberRoleId())) {
                    groupRole.setRelRoleId("35003");//对应角色ID 根据ROLE_ID查询统一配置代码表CS_CSSCODEDEF_DICT
                    groupRole.setRelMemberRoleId("M");//对应成员角色ID（主角或成员）根据MEMBER_ROLE_ID查询统一配置代码表CS_CSSCODEDEF_DICT
                } else if ("70054".equals(groupRole.getMemberRoleId())) {
                    groupRole.setRelRoleId("35003");//对应角色ID 根据ROLE_ID查询统一配置代码表CS_CSSCODEDEF_DICT
                    groupRole.setRelMemberRoleId("N");//对应成员角色ID（主角或成员）根据MEMBER_ROLE_ID查询统一配置代码表CS_CSSCODEDEF_DICT
                } else if ("50002".equals(groupRole.getMemberRoleId())) {
                    groupRole.setRelRoleId("35002");//对应角色ID 根据ROLE_ID查询统一配置代码表CS_CSSCODEDEF_DICT
                    groupRole.setRelMemberRoleId("N");//对应成员角色ID（主角或成员）根据MEMBER_ROLE_ID查询统一配置代码表CS_CSSCODEDEF_DICT
                } else if ("10240".equals(groupRole.getMemberRoleId())) {
                    groupRole.setRelRoleId("35004");//对应角色ID 根据ROLE_ID查询统一配置代码表CS_CSSCODEDEF_DICT
                    groupRole.setRelMemberRoleId("N");//对应成员角色ID（主角或成员）根据MEMBER_ROLE_ID查询统一配置代码表CS_CSSCODEDEF_DICT
                } else if ("50001".equals(groupRole.getMemberRoleId())) {
                    groupRole.setRelRoleId("35005");//对应角色ID 根据ROLE_ID查询统一配置代码表CS_CSSCODEDEF_DICT
                    groupRole.setRelMemberRoleId("N");//对应成员角色ID（主角或成员）根据MEMBER_ROLE_ID查询统一配置代码表CS_CSSCODEDEF_DICT
                }

                /// 角色节点下商品信息list节点
                List<FamilyGoodsOutDto> goodsList = new ArrayList<>();
                FamilyGoodsOutDto familyGoods;
                for (int q = 0; q < bodyOutData.size(); q++) {
                    JSONObject jsonObj = bodyOutData.getJSONObject(q);
                    //遍历出参中获取对应roleId下所有商品goodsId
                    if (jsonObject.getString("ROLE_ID").equals(jsonObj.getString("ROLE_ID")) &&
                            jsonObject.getString("MEMBER_ROLE_ID").equals(jsonObj.getString("MEMBER_ROLE_ID"))) {
                        familyGoods = new FamilyGoodsOutDto();
                        //familyGoods.setGoodsId(jsonObj.getString("GOODS_ID"));
                        familyGoods.setGoodsName(jsonObj.getString("GOODS_NAME"));
                        familyGoods.setGoodsDesc(jsonObj.getString("GOODS_DESC"));
                        familyGoods.setMasterServId(jsonObj.getString("MASTER_SERV_ID"));
                        familyGoods.setGoodsType(jsonObj.getString("GOODS_TYPE"));
                        familyGoods.setSelFlag(jsonObj.getString("SEL_FLAG"));
                        familyGoods.setMemberFlag(jsonObj.getString("MBR_FLAG"));
                        //产商品暂无数据，暂时写死
                        familyGoods.setSvcId("BSM0230003");
                        familyGoods.setProdId("BSM0230003");

                        //获取对应商品下的定价信息list
                        JSONArray reprcJson = jsonObj.getJSONArray("REPRC_LIST");

                        familyGoods.setGoodsId(reprcJson.getJSONObject(0).getString("GOODS_ID"));

                        List<FamilyGoodsPrc> goodsPrcList = new ArrayList<>();
                        FamilyGoodsPrc goodsPrc;
                        for (int j = 0; j < reprcJson.size(); j++) {
                            goodsPrc = new FamilyGoodsPrc();
                            goodsPrc.setPrcId(reprcJson.getJSONObject(j).getString("PRC_ID"));
                            goodsPrc.setPrcName(reprcJson.getJSONObject(j).getString("PRC_NAME"));
                            goodsPrc.setPrcDesc(reprcJson.getJSONObject(j).getString("GOODS_PRC_DESC"));
                            goodsPrc.setEffDate(reprcJson.getJSONObject(j).getString("EFF_DATE"));
                            goodsPrc.setExpDate(reprcJson.getJSONObject(j).getString("CANCEL_DATE"));
                            goodsPrcList.add(goodsPrc);
                        }
                        //对应商品下的定价信息list放入对应商品信息中
                        familyGoods.setFamilyGoodsPrcList(goodsPrcList);
                        //返回商品信息list
                        goodsList.add(familyGoods);
                    }
                }
                //角色节点下 商品信息list节点赋值
                groupRole.setGoodsList(goodsList);


               /* FamilyGoodsDetailQry familyGoodsDetailQry = (FamilyGoodsDetailQry) inDTO.get("BUSI_INFO");
                DetailGoodsInfo goodsInfo = familyGoodsDetailQry.getDetailGoodsInfo();
                goodsInfo.setMemberRoleId(groupRole.getMemberRoleId());
                familyGoodsDetailQry.setDetailGoodsInfo(goodsInfo);
                inDTO.replace("BUSI_INFO",familyGoodsDetailQry);
                //成员默认主资费
                Map<String, List<FamilyMbrGoods>> qryHotOutDto = qryHotPrcAo.query(inDTO);
                List<FamilyMbrGoods> mbrOpenList = (List<FamilyMbrGoods>)qryHotOutDto.get("MBR_OPEN_LIST");*/

                /// 角色节点下 成员商品信息list节点
                List<FamilyMbrGoods> mbrGoodsList = new ArrayList<>();
                FamilyMbrGoods mbrGoods;
                for (int k = 0; k < mbrOpenList.size(); k++) {
                    JSONObject mbrOpenListJSONObject = mbrOpenList.getJSONObject(k);

//                    if (groupRole.getMemberRoleId().equals(mbrOpenListJSONObject.getString("MEMBER_ROLE_ID"))) {
                    //groupRole属性值
                    groupRole.setMarketFlag(mbrOpenListJSONObject.getString("MARKET_FLAG"));
                    groupRole.setFinishFlag(mbrOpenListJSONObject.getString("FINISH_FLAG"));
                    groupRole.setOpenFlag(mbrOpenListJSONObject.getString("OPEN_FLAG"));

                    //成员商品信息
                    JSONArray reprcJson = mbrOpenListJSONObject.getJSONArray("MBR_GOODS_LIST");
                    for (int j = 0; j < reprcJson.size(); j++) {
                        mbrGoods = new FamilyMbrGoods();
                        mbrGoods.setMbrGoodsName(reprcJson.getJSONObject(j).getString("GOODS_NAME"));
                        mbrGoods.setMbrGoodsDesc(reprcJson.getJSONObject(j).getString("GOODS_DESC"));
                        mbrGoods.setMbrGoodsId(reprcJson.getJSONObject(j).getString("GOODS_ID"));

                        //成员商品节点下 资费信息list节点
                        JSONArray jsonArray = reprcJson.getJSONObject(j).getJSONArray("MBR_PRC_LIST");
                        List<FamilyMbrPrc> mbrPrcList = new ArrayList<>();
                        FamilyMbrPrc mbrPrc;
                        for (int t = 0; t < jsonArray.size(); t++) {
                            mbrPrc = new FamilyMbrPrc();
                            mbrPrc.setMbrPrcDesc(jsonArray.getJSONObject(t).getString("MBR_PRC_DESC"));
                            mbrPrc.setMbrPrcId(jsonArray.getJSONObject(t).getString("MBR_PRC_ID"));
                            mbrPrc.setMbrPrcName(jsonArray.getJSONObject(t).getString("MBR_PRC_NAME"));
                            mbrPrcList.add(mbrPrc);
                        }
                        mbrGoods.setMbrPrcList(mbrPrcList);
                        mbrGoodsList.add(mbrGoods);
                    }
                    //}
                }

//                角色节点下成员资费信息list节点赋值
                groupRole.setMbrGoodsList(mbrGoodsList);
//                groupRole.setMbrGoodsList(mbrOpenList);

                ///角色属性
                FamilyGoodsDetailQry familyGoodsInfo = (FamilyGoodsDetailQry) inDTO.get("BUSI_INFO");
                familyGoodsInfo.getDetailGoodsInfo().setGoodsId(null);
                familyGoodsInfo.getDetailGoodsInfo().setPrcId(null);
                familyGoodsInfo.getDetailGoodsInfo().setMemberRoleId(groupRole.getMemberRoleId());
                inDTO.replace("BUSI_INFO", familyGoodsInfo);
                Map<String, JSONArray> qryroleAttrOutDto = attrQryAo.query(inDTO);
                JSONArray roleAttrJsonArray = qryroleAttrOutDto.get("ATTR_LIST");

                /// 角色节点下成员角色属性list节点
                List<FamilyMbrRoleAttr> mbrRoleAttrList = new ArrayList<>();
                for (int s = 0; s < roleAttrJsonArray.size(); s++) {
                    JSONObject roleJson = roleAttrJsonArray.getJSONObject(s);
                    if ("角色属性".equals(roleJson.get("ELEMENT_NAME"))) {
                        JSONArray elementList = roleJson.getJSONArray("ELEMENT_LIST");
                        FamilyMbrRoleAttr familyMbrRoleAttr;
                        for (int j = 0; j < elementList.size(); j++) {
                            familyMbrRoleAttr = new FamilyMbrRoleAttr();
                            JSONObject jsonObj = elementList.getJSONObject(j);
                            familyMbrRoleAttr.setAttrId(jsonObj.getString("ATTR_ID"));
                            familyMbrRoleAttr.setAttrName(jsonObj.getString("ATTR_NAME"));
                            familyMbrRoleAttr.setAttrDesc(jsonObj.getString("ATTR_DESC"));
                            familyMbrRoleAttr.setIfDefaultValue(jsonObj.getString("IF_DEFAULT_VALUE"));
                            familyMbrRoleAttr.setState(jsonObj.getString("STATE"));
                            familyMbrRoleAttr.setStateDate(jsonObj.getString("STATE_DATE"));
                            familyMbrRoleAttr.setMinValue(jsonObj.getString("MIN_VALUE"));
                            familyMbrRoleAttr.setMaxValue(jsonObj.getString("MAX_VALUE"));
                            familyMbrRoleAttr.setCreateDate(jsonObj.getString("CREATE_DATE"));
                            familyMbrRoleAttr.setShowOrder(jsonObj.getString("SHOW_ORDER"));
                            familyMbrRoleAttr.setBillSendFlag(jsonObj.getString("BILL_SEND_FLAG"));
                            familyMbrRoleAttr.setEffDate(jsonObj.getString("EFF_DATE"));
                            familyMbrRoleAttr.setExpDate(jsonObj.getString("EXP_DATE"));
                            familyMbrRoleAttr.setDefaultValue(jsonObj.getString("DEFAULT_VALUE"));
                            familyMbrRoleAttr.setGrpNo(jsonObj.getString("GRP_NO"));
                            mbrRoleAttrList.add(familyMbrRoleAttr);
                        }
                    }
                }

                //角色节点下 成员角色属性list节点赋值
                groupRole.setMbrRoleAttrList(mbrRoleAttrList);

                //角色list成员角色属性list节点赋值
                groupRoleList.add(groupRole);
            }


            //去除list中重复roleId角色对象
            HashMap<String, FamilyGroupRole> tempMap = new HashMap<>();
            for (FamilyGroupRole role : groupRoleList) {
                String key = role.getRoleId();
                if (!tempMap.containsKey(key)) {
                    tempMap.put(key, role);
                }
            }
            List<FamilyGroupRole> tempList = new ArrayList<>();
            for (String key : tempMap.keySet()) {
                tempList.add(tempMap.get(key));
            }

            // 同一ROLE_ID 下若 MEMBER_ROLE_ID不相同的 一并返回
            List<FamilyGroupRole> groupRoleListNew = new ArrayList<>();

            for (FamilyGroupRole oldRole : groupRoleList) {
                for (FamilyGroupRole role : tempList) {
                    if (oldRole.getRoleId().equals(role.getRoleId()) && !oldRole.getMemberRoleId().equals(role.getMemberRoleId())) {
                        groupRoleListNew.add(oldRole);
                    }
                }
            }

            tempList.addAll(groupRoleListNew);


            //出参节点下角色list节点信息
            //获取出参节点
            FamilyGoodsDetail pkgGoodsInfo = new FamilyGoodsDetail();
            pkgGoodsInfo.setGroupRoleList(tempList);
            pkgGoodsInfo.setGoodsPrcAttrList(goodsPrcAttrList);
            pkgGoodsInfo.setGoodsSvcAttrList(goodsSvcAttrList);

            Map<String, Object> map = new HashMap<>(1);
            map.put("PKG_GOODS_INFO", pkgGoodsInfo);
            return map;

        } catch (Exception e) {
            throw new BusiException("99999999999999999", "query failed", e.getMessage());
        }
    }

}
