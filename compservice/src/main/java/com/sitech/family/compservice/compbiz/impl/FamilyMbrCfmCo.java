package com.sitech.family.compservice.compbiz.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sitech.family.common.dto.OprInfo;
import com.sitech.family.compservice.atombiz.IFamilyGroupMbrQryAo;
import com.sitech.family.compservice.compbiz.IFamilyMbrCfmCo;
import com.sitech.family.compservice.dto.indto.FamilyMbrDelInDto;
import com.sitech.family.compservice.dto.indto.FamilyMbrMngInDto;
import com.sitech.family.compservice.dto.indto.UniOrderInfoDto;
import com.sitech.family.constants.ReturnCode;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

@Component("FamilyMbrCfmCo")
public class FamilyMbrCfmCo implements IFamilyMbrCfmCo {

    private static Logger logger = LoggerFactory.getLogger(FamilyMbrCfmCo.class);
    @Autowired
    private IFamilyGroupMbrQryAo familyGroupMbrQryAo;
    /**
     * 成员管理新增
     *
     * @param map
     * @return
     */
    @Override
    public Map cfmFamilyAddMbr(Map map) {
        Map retMap = new HashMap();

        try {
            FamilyMbrMngInDto familyMbrMngInDto = (FamilyMbrMngInDto) map.get("busiInfo");
            OprInfo oprInfo = (OprInfo) map.get("oprInfo");

            if (StringUtil.isEmptyOrNull(familyMbrMngInDto.getUserGroupMbrInfoList())) {
                retMap.put("retCode", "-9999");
                return retMap;
            }

            Map<String, Object> inMap = new HashMap<>();
            Map<String, String> oprMap = new HashMap<>();
            oprMap.put("CHANNEL_TYPE", oprInfo.getChannelType());
            oprMap.put("CONTACT_ID", oprInfo.getContactId());
            oprMap.put("CUST_ID_TYPE", "1");
            oprMap.put("CUST_ID_VALUE", "1");
            oprMap.put("GROUP_ID", oprInfo.getGroupId());
            oprMap.put("LOGIN_NO", oprInfo.getLoginNo());
            oprMap.put("OUT_ORDER_ID", "1");
            oprMap.put("REGION_ID", oprInfo.getRegionId());
            oprMap.put("REMARK", oprInfo.getOpNote());
            oprMap.put("SERVICE_NO", "1");

            inMap.put("OPR_INFO", oprMap);

            List<FamilyMbrMngInDto.UserGroupMbrInfo> userGroupMbrInfoList = familyMbrMngInDto.getUserGroupMbrInfoList();

            List<Map> orderList = new ArrayList<>();
            for (FamilyMbrMngInDto.UserGroupMbrInfo userGroupMbrInfo : userGroupMbrInfoList) {
                Map<String, Object> groupMbrMap = new HashMap<>();
                groupMbrMap.put("EFF_DATE", userGroupMbrInfo.getEffDate());
                groupMbrMap.put("EXP_DATE", userGroupMbrInfo.getExpDate());
                groupMbrMap.put("FINISH_FLAG", userGroupMbrInfo.getFinishFlag());
                groupMbrMap.put("ID_NO", userGroupMbrInfo.getIdNo());
                groupMbrMap.put("MEMBER_DESC", userGroupMbrInfo.getMemberDesc());
                groupMbrMap.put("MEMBER_ROLE_ID", userGroupMbrInfo.getMemberRoleId());
                groupMbrMap.put("OBJECT_ID", userGroupMbrInfo.getObjectId());
                groupMbrMap.put("OBJECT_TYPE", userGroupMbrInfo.getObjectType());
                groupMbrMap.put("OPEN_FLAG", userGroupMbrInfo.getOpenFlag());
                groupMbrMap.put("PHONE_NO", userGroupMbrInfo.getPhoneNo());
                groupMbrMap.put("ROLE_ID", userGroupMbrInfo.getRoleId());

                if (StringUtil.isNotEmptyOrNull(userGroupMbrInfo.getConUsrRelInfoList())) {
                    List<FamilyMbrMngInDto.ConUsrRelInfo> conUsrRelInfoList = userGroupMbrInfo.getConUsrRelInfoList();

                    List<Map> list = new ArrayList<>();
                    for (FamilyMbrMngInDto.ConUsrRelInfo conUsrRelInfo : conUsrRelInfoList) {
                        Map<String, Object> conUsrRelMap = new HashMap<>();
                        conUsrRelMap.put("CONTRACT_NO", conUsrRelInfo.getContractNo());
                        conUsrRelMap.put("CYCLE_TYPE", conUsrRelInfo.getCycleType());
                        conUsrRelMap.put("DATE_CYCLE", conUsrRelInfo.getDateCycle());
                        conUsrRelMap.put("EFF_DATE", conUsrRelInfo.getEffDate());
                        conUsrRelMap.put("EXP_DATE", conUsrRelInfo.getExpDate());
                        conUsrRelMap.put("PAY_TYPE", conUsrRelInfo.getPayType());
                        conUsrRelMap.put("PAY_VALUE", conUsrRelInfo.getPayValue());
                        conUsrRelMap.put("RATE_FLAG", conUsrRelInfo.getRateFlag());

                        if (StringUtil.isNotEmptyOrNull(conUsrRelInfo.getConUserRateInfoList())) {
                            List<FamilyMbrMngInDto.ConUserRateInfo> conUserRateInfoList = conUsrRelInfo.getConUserRateInfoList();

                            List<Map> rateList = new ArrayList<>();
                            for (FamilyMbrMngInDto.ConUserRateInfo conUserRateInfo : conUserRateInfoList) {
                                Map<String, Object> conUserRateMap = new HashMap<>();
                                conUserRateMap.put("FEE_CODE", conUserRateInfo.getFeeCode());
                                conUserRateMap.put("DETAIL_CODE", conUserRateInfo.getDetailCode());
                                conUserRateMap.put("RATE_BILL_ORDER", conUserRateInfo.getRateBillOrder());
                                conUserRateMap.put("FEE_RATE", conUserRateInfo.getFeeRate());
                                conUserRateMap.put("EFF_DATE", conUserRateInfo.getEffDate());
                                conUserRateMap.put("EXP_DATE", conUserRateInfo.getExpDate());
                                rateList.add(conUserRateMap);
                            }

                            conUsrRelMap.put("CONUSERRATEINFOLIST", rateList);
                        }

                        list.add(conUsrRelMap);
                    }

                    groupMbrMap.put("CONUSRRELINFOLIST", list);

                    if (StringUtil.isNotEmptyOrNull(userGroupMbrInfo.getUserGroupMbrAttrInfoList())) {
                        List<FamilyMbrMngInDto.UserGroupMbrAttrInfo> userGroupMbrAttrInfoList = userGroupMbrInfo.getUserGroupMbrAttrInfoList();

                        List<Map> groupMbrAttrList = new ArrayList<>();
                        for (FamilyMbrMngInDto.UserGroupMbrAttrInfo userGroupMbrAttrInfo : userGroupMbrAttrInfoList) {
                            Map<String, Object> groupMbrAttrMap = new HashMap<>();
                            groupMbrAttrMap.put("EFF_DATE", userGroupMbrAttrInfo.getEffDate());
                            groupMbrAttrMap.put("EXP_DATE", userGroupMbrAttrInfo.getExpDate());
                            groupMbrAttrMap.put("ATTR_ID", userGroupMbrAttrInfo.getAttrId());
                            groupMbrAttrMap.put("ATTR_VALUE", userGroupMbrAttrInfo.getAttrValue());
                            groupMbrAttrMap.put("GRP_NO", userGroupMbrAttrInfo.getGrpNo());

                            groupMbrAttrList.add(groupMbrAttrMap);
                        }

                        groupMbrMap.put("USERGROUPMBRATTRINFOLIST", groupMbrAttrList);
                    }

                    if (StringUtil.isNotEmptyOrNull(userGroupMbrInfo.getUserGroupMbrGoodsInfoList())) {
                        List<FamilyMbrMngInDto.UserGroupMbrGoodsInfo> userGroupMbrGoodsInfoList = userGroupMbrInfo.getUserGroupMbrGoodsInfoList();

                        List<Map> groupMbrGoodsList = new ArrayList<>();
                        for (FamilyMbrMngInDto.UserGroupMbrGoodsInfo userGroupMbrGoodsInfo : userGroupMbrGoodsInfoList) {
                            Map<String, Object> groupMbrGoodsMap = new HashMap<>();
                            groupMbrGoodsMap.put("GOODS_TYPE", userGroupMbrGoodsInfo.getGoodsType());
                            groupMbrGoodsMap.put("MEMBER_FLAG", userGroupMbrGoodsInfo.getMemberFlag());
                            groupMbrGoodsMap.put("SVC_ID", userGroupMbrGoodsInfo.getSvcId());
                            groupMbrGoodsMap.put("PROD_ID", userGroupMbrGoodsInfo.getProdId());
                            groupMbrGoodsMap.put("GOODS_ID", userGroupMbrGoodsInfo.getGoodsId());
                            groupMbrGoodsMap.put("PRC_ID", userGroupMbrGoodsInfo.getPrcId());
                            groupMbrGoodsMap.put("EFF_DATE", userGroupMbrGoodsInfo.getEffDate());
                            groupMbrGoodsMap.put("EXP_DATE", userGroupMbrGoodsInfo.getExpDate());


                            if (StringUtil.isNotEmptyOrNull(userGroupMbrGoodsInfo.getUserGroupMbrGoodsAttrInfoList())) {
                                List<FamilyMbrMngInDto.UserGroupMbrAttr> userGroupMbrGoodsAttrInfoList = userGroupMbrGoodsInfo.getUserGroupMbrGoodsAttrInfoList();

                                List<Map> mbrGoodsAttrList = new ArrayList<>();
                                for (FamilyMbrMngInDto.UserGroupMbrAttr userGroupMbrAttr : userGroupMbrGoodsAttrInfoList) {
                                    Map<String, Object> mbrGoodsAttrMap = new HashMap<>();
                                    mbrGoodsAttrMap.put("ATTR_ID", userGroupMbrAttr.getAttrId());
                                    mbrGoodsAttrMap.put("ATTR_VALUE", userGroupMbrAttr.getAttrValue());
                                    mbrGoodsAttrMap.put("GRP_NO", userGroupMbrAttr.getGrpNo());
                                    mbrGoodsAttrList.add(mbrGoodsAttrMap);
                                }
                                groupMbrGoodsMap.put("USERGROUPMBRGOODSATTRINFOLIST", mbrGoodsAttrList);
                            }

                            if (StringUtil.isNotEmptyOrNull(userGroupMbrGoodsInfo.getUserGroupMbrSvcAttrInfoList())) {
                                List<FamilyMbrMngInDto.UserGroupMbrAttr> userGroupMbrSvcAttrInfoList = userGroupMbrGoodsInfo.getUserGroupMbrSvcAttrInfoList();

                                List<Map> mbrGoodsSvcList = new ArrayList<>();
                                for (FamilyMbrMngInDto.UserGroupMbrAttr userGroupMbrAttr : userGroupMbrSvcAttrInfoList) {
                                    Map<String, Object> mbrSvcAttrMap = new HashMap<>();
                                    mbrSvcAttrMap.put("ATTR_ID", userGroupMbrAttr.getAttrId());
                                    mbrSvcAttrMap.put("GRP_NO", userGroupMbrAttr.getGrpNo());
                                    mbrSvcAttrMap.put("ATTR_VALUE", userGroupMbrAttr.getAttrValue());
                                    mbrGoodsSvcList.add(mbrSvcAttrMap);
                                }
                                groupMbrGoodsMap.put("USERGROUPMBRSVCATTRINFOLIST", mbrGoodsSvcList);
                            }

                            groupMbrGoodsList.add(groupMbrGoodsMap);
                        }

                        groupMbrMap.put("USERGROUPMBRGOODSINFOLIST", groupMbrGoodsList);
                    }
                }

                if ("Y".equals(userGroupMbrInfo.getOpenFlag())) {
                    Map<String, Object> goodsInfoMap = new HashMap<>();
                    goodsInfoMap.put("GOODS_INFO", groupMbrMap);

                    orderList.add(goodsInfoMap);
                }

                Map<String, Object> userGroupMap = new HashMap<>();
                userGroupMap.put("USERGROUPMBRINFOLIST", groupMbrMap);

                Map<String, Object> goodsInfoMap = new HashMap<>();
                goodsInfoMap.put("GOODS_INFO", userGroupMap);
                goodsInfoMap.put("GROUP_ID", familyMbrMngInDto.getGroupId());

                orderList.add(goodsInfoMap);

                inMap.put("ORDERITEM_LIST", orderList);
            }

            JSONObject json = new JSONObject(inMap);


            JSONArray jsonArray = json.getJSONArray("ORDERITEM_LIST");

            for (int i = 0; i < jsonArray.size(); i++) {
                HashMap jsonObject = (HashMap)jsonArray.get(i);

                System.out.println(jsonObject.get("GOODS_INFO"));
            }

            /*//System.out.println(JSON.toJSONString(inMap));
            for(String key : inMap.keySet()){
                ArrayList value = (ArrayList) inMap.get(key);

                System.out.println(key+"  "+value);
            }*/

            //Object obj = inMap.get("USERGROUPMBRINFOLIST");

            //System.out.println(obj);

            /*System.out.println(obj.getClass().getName().substring(obj.getClass().getName().lastIndexOf(".") + 1));*/

            retMap = null;
        } catch (Exception e) {
            throw new BusiException("-9999", e.getMessage());
        }

        return retMap;
    }


    /**
     * 成员管理删除
     *
     * @param map
     * @return
     */
    @Override
    public OutDTO cfmFamilyDelMbr(Map<String, Object> map) {

        //获取入参节点
        FamilyMbrDelInDto familyMbrDelInDto = (FamilyMbrDelInDto) map.get("BUSI_INFO");
        OprInfo oprInfo = (OprInfo) map.get("OPR_INFO");
        Object header = map.get("HEADER");
        try {

            if (StringUtil.isEmptyOrNull(familyMbrDelInDto) || StringUtil.isEmptyOrNull(oprInfo)) {
                throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "参数不能为空");
            }

            //全网订单业务信息
            UniOrderInfoDto.FamilyOrderItemInfoDto itemInfoDto = new UniOrderInfoDto.FamilyOrderItemInfoDto();
            itemInfoDto.setGoodsInfo(familyMbrDelInDto);
            itemInfoDto.setBusiType("2000");//待确认家客订单行流程，需要和具体的业务和对应流程确认
            itemInfoDto.setChannelType(oprInfo.getChannelType());
            itemInfoDto.setCustIdValue("");//待确认


            //定义需要创送给全网订单的变量
            UniOrderInfoDto.FamilyOrderBodyInfoDto familyOrderBodyInfoDto = new UniOrderInfoDto.FamilyOrderBodyInfoDto();
            UniOrderInfoDto.FamilyOrderOprInfoDto familyOrderOprInfoDto = new UniOrderInfoDto.FamilyOrderOprInfoDto();
            List<UniOrderInfoDto.FamilyOrderItemInfoDto> orderItemList = new ArrayList<>();
            orderItemList.add(itemInfoDto);

            //设置oprinfo节点
            familyOrderOprInfoDto.setChannelType(oprInfo.getChannelType());
            familyOrderOprInfoDto.setContactId(oprInfo.getContactId());
            familyOrderOprInfoDto.setCustIdType("1"); //待确认值类型
            familyOrderOprInfoDto.setCustIdValue("13434343");//待确认值类型
            familyOrderOprInfoDto.setGroupId(oprInfo.getGroupId());
            familyOrderOprInfoDto.setLoginNo(oprInfo.getLoginNo());
            familyOrderOprInfoDto.setOutOrderId("");
            familyOrderOprInfoDto.setRegionId(oprInfo.getRegionId());
            familyOrderOprInfoDto.setRemark(oprInfo.getOpNote());
            familyOrderOprInfoDto.setServcieNO("13812121212");// 待确认值类型。

            //拼接全网订单
            familyOrderBodyInfoDto.setFamilyOrderOprInfoDto(familyOrderOprInfoDto);
            familyOrderBodyInfoDto.setFamilyOrderItemInfoDtoList(orderItemList);


            OutDTO outDTO = new OutDTO();
            outDTO.setHeader(header);
            outDTO.setBodyOutData(familyOrderBodyInfoDto);
            return outDTO;
        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), e.getMessage());
        }
    }

    @Override
    public OutDTO<Object> cfmFamilyGroupMbr(Map<String, Object> map) {
        try {
            OutDTO<Object> mbrOutDto = familyGroupMbrQryAo.qryFamilyGroupMbr(map);
            return mbrOutDto;
        }catch (Exception e){
            throw new BusiException(getErrorCode("1000", "15000"), e.getMessage());
        }
    }
}
