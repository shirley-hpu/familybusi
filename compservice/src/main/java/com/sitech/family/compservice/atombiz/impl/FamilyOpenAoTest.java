package com.sitech.family.compservice.atombiz.impl;

import com.alibaba.fastjson.JSON;
import com.sitech.family.common.constants.FinishFlagEnum;
import com.sitech.family.common.util.BaseLoginAccept;
import com.sitech.family.common.util.DateConst;
import com.sitech.family.compservice.atombiz.IFamilyOpenAoTest;
import com.sitech.family.compservice.dto.indto.*;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.service.ArchitectureType;
import com.sitech.ijcf.boot.core.service.client.IServiceClient;
import com.sitech.ijcf.boot.core.util.DateUtil;
import com.sitech.ijcf.boot.core.util.StringUtil;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.ijcf.message6.dt.support.MBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * 融合开户提交测试服务
 *
 * @author wusm
 * @date 2019/5/14 11:21
 */
@Component("FamilyOpenAoTest")
public class FamilyOpenAoTest implements IFamilyOpenAoTest {

    private static final Logger logger = LoggerFactory.getLogger(FamilyOpenAoTest.class);

    @Resource
    private IServiceClient serviceClient;

    @Resource
    private BaseLoginAccept baseLoginAccept;


    /**
     * 在途状态 Y
     * 正常状态 N
     *
     * @param familyOrderBodyInfoDto
     * @return
     */
    @Override
    public OutDTO createUniOrderTest(UniOrderInfoDto.FamilyOrderBodyInfoDto familyOrderBodyInfoDto) {
        System.out.println(JSON.toJSONString(familyOrderBodyInfoDto));
        OutDTO outDTO = new OutDTO();

        String datetime = DateUtil.format(new Date(), DateConst.DATE_MODEL_8);

        try {
            List<UniOrderInfoDto.FamilyOrderItemInfoDto> familyOrderItemInfoDtoList = familyOrderBodyInfoDto.getFamilyOrderItemInfoDtoList();
            MBean mBean = new MBean();

            Map<String, String> mapTwo = new HashMap<>();
            mapTwo.put("ACCEPT_LABEL", "SEQ_FM_GROUPID");
            //String groupId = baseLoginAccept.getPubLoginAccept(mapTwo);
            String groupId = "68000000000000012";

            //初始化状态为Y
            String finish = FinishFlagEnum.VAL_Y.getValue();

            /* 获取群成员信息 判断每组群成员信息中FINISH_FLAG字段是否有N 有的话走在途流程；如果都是的Y话走正常流程 */
            for (UniOrderInfoDto.FamilyOrderItemInfoDto familyOrderItemInfoDto : familyOrderItemInfoDtoList) {

                // 获取业务信息节点GOODS_INFO
                Object object = familyOrderItemInfoDto.getGoodsInfo();
                String className = object.getClass().getName().substring(object.getClass().getName().lastIndexOf(".") + 1);

                if ("FamilyOpenCfmInDto".equals(className)) {
                    FamilyOpenCfmInDto familyOpenCfmInDto = (FamilyOpenCfmInDto) familyOrderItemInfoDto.getGoodsInfo();

                    if (familyOpenCfmInDto.getUserGroupMbrInfoList() != null) {
                        List<FamilyMbrUserInfoInDto> familyMbrUserInfoInDtoList = familyOpenCfmInDto.getUserGroupMbrInfoList();

                        for (FamilyMbrUserInfoInDto familyMbrUserInfoInDto : familyMbrUserInfoInDtoList) {
                            String finishFlag = familyMbrUserInfoInDto.getFinishFlag();

                            //FINISH_FLAG字段是否含有N 有则改变finish值为N
                            if (!FinishFlagEnum.VAL_N.getValue().equals(finishFlag)) {

                                finish = FinishFlagEnum.VAL_N.getValue();
                                break;//若有N类型，则直接跳出当前循环，执行在途业务
                            }
                        }
                    }
                }
            }


            switch (finish) {

                //在途状态流程
                case "N":
                    //
                    for (UniOrderInfoDto.FamilyOrderItemInfoDto familyOrderItemInfoDto : familyOrderItemInfoDtoList) {
                        UniOrderInfoDto.FamilyOrderOprInfoDto familyOrderOprInfoDto = familyOrderBodyInfoDto.getFamilyOrderOprInfoDto();

                        Map<String, Object> oprInfoMap = new HashMap<>(11);
                        oprInfoMap.put("REGION_ID", familyOrderOprInfoDto.getRegionId());
                        oprInfoMap.put("LOGIN_NO", familyOrderOprInfoDto.getLoginNo());
                        oprInfoMap.put("GROUP_ID", familyOrderOprInfoDto.getGroupId());
                        oprInfoMap.put("CONTACT_ID", familyOrderOprInfoDto.getContactId());
                        oprInfoMap.put("OP_NOTE", "1");
                        oprInfoMap.put("CHANNEL_TYPE", familyOrderOprInfoDto.getChannelType());
                        Map<String, String> sequenceMap = new HashMap<>(2);
                        sequenceMap.put("ACCEPT_LABEL", "SEQ_FM_LOGINACCEPT");
                        // 获取 操作流水序列
                        //String loginAccept = baseLoginAccept.getPubLoginAccept(sequenceMap);
                        String loginAccept = "222222222";
                        oprInfoMap.put("LOGIN_ACCEPT", loginAccept);
                        oprInfoMap.put("CREATE_TIME", datetime);
                        oprInfoMap.put("OP_CODE", "1");
                        oprInfoMap.put("SYSTEM_NOTE", "1");
                        oprInfoMap.put("OUT_ACCEPT", "1");

                        Map<String, Object> routeMap = new HashMap<>();
                        routeMap.put("ROUTE_KEY", "1");
                        routeMap.put("ROUTE_VALUE", "1");
                        Map<String, Object> routingMap = new HashMap<>();
                        routingMap.put("ROUTING", routeMap);

                        Object o = familyOrderItemInfoDto.getGoodsInfo();

                        String className = o.getClass().getName().substring(o.getClass().getName().lastIndexOf(".") + 1);

                        if ("FamilyOpenCfmInDto".equals(className)) {

                            FamilyOpenCfmInDto familyOpenCfmInDto = (FamilyOpenCfmInDto) familyOrderItemInfoDto.getGoodsInfo();

                            FamilyUserInfoDto familyUserInfoDto = familyOpenCfmInDto.getUserInfo();

                            sequenceMap.clear();
                            sequenceMap.put("ACCEPT_LABEL", "SEQ_FM_USERID_2301");
                            sequenceMap.put("REGION_ID", "01");
                            // 获取 家庭用户标识序列
                            //String idNo = baseLoginAccept.getPubLoginAccept(sequenceMap);
                            String idNo = "1000000000312213";
                            Map<String, Object> userInfoMap = new HashMap<>();
                            userInfoMap.put("ID_NO", idNo);
                            userInfoMap.put("PHONE_NO", idNo);

                            sequenceMap.clear();
                            sequenceMap.put("ACCEPT_LABEL", "SEQ_FM_ACCTID");
                            // 获取 家庭用户标识序列
                            //String contractNo = baseLoginAccept.getPubLoginAccept(sequenceMap);
                            String contractNo = "8312098310091";
                            userInfoMap.put("CONTRACT_NO", contractNo);

                            sequenceMap.clear();
                            sequenceMap.put("ACCEPT_LABEL", "SEQ_CT_CUSTID_2301");
                            sequenceMap.put("REGION_ID", "01");
                            // 获取 家庭用户标识序列
                            //String custId = baseLoginAccept.getPubLoginAccept(sequenceMap);
                            String custId = "13978193278913";
                            userInfoMap.put("CUST_ID", custId);
                            if (StringUtil.isEmptyOrNull(familyUserInfoDto.getEmpId())) {
                                userInfoMap.put("EMP_ID", "1");
                            } else {
                                userInfoMap.put("EMP_ID", familyUserInfoDto.getEmpId());
                            }
                            if (StringUtil.isEmptyOrNull(familyUserInfoDto.getEmpGroup())) {
                                userInfoMap.put("EMP_GROUP", "1");
                            } else {
                                userInfoMap.put("EMP_GROUP", familyUserInfoDto.getEmpGroup());
                            }

                            FamilyGroupInfoInDto familyGroupInfoInDto = familyUserInfoDto.getUserGroupInfo();

                            Map<String, Object> userGroupInfoMap = new HashMap<>();
                            userGroupInfoMap.put("GROUP_ID", groupId);
                            if (StringUtil.isEmptyOrNull(familyGroupInfoInDto.getUseAddress())) {
                                userGroupInfoMap.put("USE_ADDRESS", "1");
                            } else {
                                userGroupInfoMap.put("USE_ADDRESS", familyGroupInfoInDto.getUseAddress());
                            }
                            if (StringUtil.isEmptyOrNull(familyGroupInfoInDto.getGroupCode())) {
                                userGroupInfoMap.put("GROUP_CODE", "1");
                            } else {
                                userGroupInfoMap.put("GROUP_CODE", familyGroupInfoInDto.getGroupCode());
                            }
                            if (StringUtil.isEmptyOrNull(familyGroupInfoInDto.getGroupType())) {
                                userGroupInfoMap.put("GROUP_TYPE", "1");
                            } else {
                                userGroupInfoMap.put("GROUP_TYPE", familyGroupInfoInDto.getGroupType());
                            }
                            if (StringUtil.isEmptyOrNull(familyGroupInfoInDto.getGroupName())) {
                                userGroupInfoMap.put("GROUP_NAME", "1");
                            } else {
                                userGroupInfoMap.put("GROUP_NAME", familyGroupInfoInDto.getGroupName());
                            }
                            if (StringUtil.isEmptyOrNull(familyGroupInfoInDto.getGroupDesc())) {
                                userGroupInfoMap.put("GROUP_DESC", "1");
                            } else {
                                userGroupInfoMap.put("GROUP_DESC", familyGroupInfoInDto.getGroupDesc());
                            }
                            userInfoMap.put("USERGROUP_INFO", userGroupInfoMap);

                            List<FamilyUserGoodsInfoDto> familyUserGoodsInfoDtoList = familyUserInfoDto.getUserGoodsInfoList();

                            // 群用户商品订购实例 在途
                            List<Map> familyUserGoodsInfoList = new ArrayList<>();
                            for (FamilyUserGoodsInfoDto familyUserGoodsInfoDto : familyUserGoodsInfoDtoList) {
                                Map<String, Object> userGoodsInfoMap = new HashMap<>();
                                userGoodsInfoMap.put("SVC_ID", familyUserGoodsInfoDto.getSvcId());
                                userGoodsInfoMap.put("GOODS_ID", familyUserGoodsInfoDto.getGoodsId());
                                userGoodsInfoMap.put("PRC_ID", familyUserGoodsInfoDto.getPrcId());
                                if (StringUtil.isEmptyOrNull(familyUserGoodsInfoDto.getGoodsType())) {
                                    userGoodsInfoMap.put("MAIN_FLAG", "1");
                                } else {
                                    userGoodsInfoMap.put("MAIN_FLAG", "1");
                                }
                                if (StringUtil.isEmptyOrNull(familyUserGoodsInfoDto.getProdId())) {
                                    userGoodsInfoMap.put("PROD_ID", "1");
                                } else {
                                    userGoodsInfoMap.put("PROD_ID", familyUserGoodsInfoDto.getProdId());
                                }
                                if (StringUtil.isEmptyOrNull(familyUserGoodsInfoDto.getEffDate())) {
                                    userGoodsInfoMap.put("EFF_DATE", datetime);
                                } else {
                                    userGoodsInfoMap.put("EFF_DATE", familyUserGoodsInfoDto.getEffDate());
                                }
                                if (StringUtil.isEmptyOrNull(familyUserGoodsInfoDto.getExpDate())) {
                                    userGoodsInfoMap.put("EXP_DATE", "20191220010101");
                                } else {
                                    userGoodsInfoMap.put("EXP_DATE", familyUserGoodsInfoDto.getExpDate());
                                }

                                // 群用户商品订购属性 在途
                                if (familyUserGoodsInfoDto.getUserGoodsAttrInfoList() != null) {
                                    List<FamilyBaseAttrInfo> familyBaseAttrInfoList = familyUserGoodsInfoDto.getUserGoodsAttrInfoList();

                                    List<Map> familyUserGoodsAttrInfoList = new ArrayList<>();
                                    for (FamilyBaseAttrInfo familyBaseAttrInfo : familyBaseAttrInfoList) {
                                        Map<String, Object> userGoodsAttrInfoMap = new HashMap<>();
                                        if (StringUtil.isEmptyOrNull(familyBaseAttrInfo.getAttrId())) {
                                            userGoodsAttrInfoMap.put("ATTR_ID", "1");
                                        } else {
                                            userGoodsAttrInfoMap.put("ATTR_ID", familyBaseAttrInfo.getAttrId());
                                        }
                                        userGoodsAttrInfoMap.put("ATTR_NO", "1");
                                        if (StringUtil.isEmptyOrNull(familyBaseAttrInfo.getAttrValue())) {
                                            userGoodsAttrInfoMap.put("ATTR_VALUE", "1");
                                        } else {
                                            userGoodsAttrInfoMap.put("ATTR_VALUE", familyBaseAttrInfo.getAttrValue());
                                        }
                                        if (StringUtil.isEmptyOrNull(familyBaseAttrInfo.getGrpNo())) {
                                            userGoodsAttrInfoMap.put("GRP_NO", "1");
                                        } else {
                                            userGoodsAttrInfoMap.put("GRP_NO", familyBaseAttrInfo.getGrpNo());
                                        }
                                        familyUserGoodsAttrInfoList.add(userGoodsAttrInfoMap);
                                    }
                                    userGoodsInfoMap.put("USERGOODSATTRINFOLIST", familyUserGoodsAttrInfoList);
                                }

                                // 群用户服务订购属性 在途
                                if (familyUserGoodsInfoDto.getUserSvcAttrInfoList() != null) {
                                    List<FamilyBaseAttrInfo> familyBaseAttrInfoList = familyUserGoodsInfoDto.getUserSvcAttrInfoList();

                                    List<Map> familyUserSvcAttrInfoList = new ArrayList<>();
                                    for (FamilyBaseAttrInfo familyBaseAttrInfo : familyBaseAttrInfoList) {
                                        Map<String, Object> userSvcAttrInfoMap = new HashMap<>();
                                        userSvcAttrInfoMap.put("ATTR_NO", "1");
                                        if (StringUtil.isEmptyOrNull(familyBaseAttrInfo.getAttrId())) {
                                            userSvcAttrInfoMap.put("ATTR_ID", "1");
                                        } else {
                                            userSvcAttrInfoMap.put("ATTR_ID", familyBaseAttrInfo.getAttrId());
                                        }
                                        if (StringUtil.isEmptyOrNull(familyBaseAttrInfo.getAttrValue())) {
                                            userSvcAttrInfoMap.put("ATTR_VALUE", "1");
                                        } else {
                                            userSvcAttrInfoMap.put("ATTR_VALUE", familyBaseAttrInfo.getAttrValue());
                                        }
                                        if (StringUtil.isEmptyOrNull(familyBaseAttrInfo.getGrpNo())) {
                                            userSvcAttrInfoMap.put("GRP_NO", "1");
                                        } else {
                                            userSvcAttrInfoMap.put("GRP_NO", familyBaseAttrInfo.getGrpNo());
                                        }
                                        familyUserSvcAttrInfoList.add(userSvcAttrInfoMap);
                                    }
                                    userGoodsInfoMap.put("USERSVCATTRINFOLIST", familyUserSvcAttrInfoList);
                                }
                                familyUserGoodsInfoList.add(userGoodsInfoMap);
                            }
                            userInfoMap.put("USERGOODSINFOLIST", familyUserGoodsInfoList);
                            Map<String, Object> userMap = new HashMap<>();
                            userMap.put("USER_INFO", userInfoMap);

                            mBean.addBody("BUSI_INFO", userMap);
                            mBean.setHeader(routingMap);
                            mBean.addBody("OPR_INFO", oprInfoMap);

                            //outDTO = serviceClient.callService("http://familybusi-custservice/sFamilyUserPreApplyCfm",
                            //        mBean.toString(), OutDTO.class, ArchitectureType.SPRINGCLOUD);
//
                            //if (!"0".equals(outDTO.getRtnCode())) {
                            //    throw new BusiException(getErrorCode("1000", "15000"), "全网订单开户测试失败", outDTO.getRtnDetailMsg());
                            //}

                            // 群成员 在途
                            if (familyOpenCfmInDto.getUserGroupMbrInfoList() != null) {
                                List<FamilyMbrUserInfoInDto> familyMbrUserInfoInDtoList = familyOpenCfmInDto.getUserGroupMbrInfoList();

                                for (FamilyMbrUserInfoInDto familyMbrUserInfoInDto : familyMbrUserInfoInDtoList) {
                                    MBean mBeanOne = new MBean();
                                    Map<String, Object> userGroupMbrInfoListMap = new HashMap<>();

                                    List<Map> familyMbrAddList = new ArrayList<>();
                                    Map<String, Object> familyMbrAddMap = new HashMap<>();

                                    sequenceMap.clear();
                                    sequenceMap.put("ACCEPT_LABEL", "SEQ_FM_MEMBERID");
                                    // 获取 成员标识序列
                                    //String memberId = baseLoginAccept.getPubLoginAccept(sequenceMap);
                                    String memberId = "7987931279130";
                                    familyMbrAddMap.put("MEMBER_ID", memberId);
                                    familyMbrAddMap.put("REL_MEMBER_ID", "1");
                                    familyMbrAddMap.put("GROUP_ID", groupId);
                                    if (StringUtil.isEmptyOrNull(familyMbrUserInfoInDto.getRoleId())) {
                                        familyMbrAddMap.put("ROLE_ID", "1");
                                    } else {
                                        familyMbrAddMap.put("ROLE_ID", familyMbrUserInfoInDto.getRoleId());
                                    }
                                    if (StringUtil.isEmptyOrNull(familyMbrUserInfoInDto.getMemberRoleId())) {
                                        familyMbrAddMap.put("MEMBER_ROLE_ID", "1");
                                    } else {
                                        familyMbrAddMap.put("MEMBER_ROLE_ID", familyMbrUserInfoInDto.getMemberRoleId());
                                    }
                                    if (StringUtil.isEmptyOrNull(familyMbrUserInfoInDto.getObjectType())) {
                                        familyMbrAddMap.put("OBJECT_TYPE", "1");
                                    } else {
                                        familyMbrAddMap.put("OBJECT_TYPE", familyMbrUserInfoInDto.getObjectType());
                                    }

                                    sequenceMap.clear();
                                    sequenceMap.put("ACCEPT_LABEL", "SEQ_UR_USERID_2301");
                                    sequenceMap.put("REGION_ID", "01");
                                    // 获取 个人用户标识序列
                                    //String objectId = baseLoginAccept.getPubLoginAccept(sequenceMap);
                                    String objectId = "8093890800809";
                                    familyMbrAddMap.put("OBJECT_ID", objectId);

                                    if (StringUtil.isEmptyOrNull(familyMbrUserInfoInDto.getMemberDesc())) {
                                        familyMbrAddMap.put("MEMBER_DESC", "1");
                                    } else {
                                        familyMbrAddMap.put("MEMBER_DESC", familyMbrUserInfoInDto.getMemberDesc());
                                    }
                                    if (StringUtil.isEmptyOrNull(familyMbrUserInfoInDto.getEffDate())) {
                                        familyMbrAddMap.put("EFF_DATE", datetime);
                                    } else {
                                        familyMbrAddMap.put("EFF_DATE", familyMbrUserInfoInDto.getEffDate());
                                    }
                                    if (StringUtil.isEmptyOrNull(familyMbrUserInfoInDto.getExpDate())) {
                                        familyMbrAddMap.put("EXP_DATE", "20180520010101");
                                    } else {
                                        familyMbrAddMap.put("EXP_DATE", familyMbrUserInfoInDto.getExpDate());
                                    }
                                    if (StringUtil.isEmptyOrNull(familyMbrUserInfoInDto.getPhoneNO())) {
                                        familyMbrAddMap.put("PHONE_NO", "18888888888");
                                    } else {
                                        familyMbrAddMap.put("PHONE_NO", familyMbrUserInfoInDto.getPhoneNO());
                                    }
                                    familyMbrAddMap.put("MEMBER_NAME", "1");

                                    // 群成员属性 在途
                                    if (familyMbrUserInfoInDto.getUserGroupMbrAttrInfoList() != null) {
                                        List<FamilyMbrAttrInfoInDto> familyMbrAttrInfoInDtoList = familyMbrUserInfoInDto.getUserGroupMbrAttrInfoList();

                                        List<Map> familyUserGroupMbrAttrList = new ArrayList<>();
                                        for (FamilyMbrAttrInfoInDto familyMbrAttrInfoInDto : familyMbrAttrInfoInDtoList) {
                                            Map<String, Object> familyUserGroupMbrAttrMap = new HashMap<>();
                                            if (StringUtil.isEmptyOrNull(familyMbrAttrInfoInDto.getAttrId())) {
                                                familyUserGroupMbrAttrMap.put("ATTR_ID", "1");
                                            } else {
                                                familyUserGroupMbrAttrMap.put("ATTR_ID", familyMbrAttrInfoInDto.getAttrId());
                                            }
                                            familyUserGroupMbrAttrMap.put("ATTR_NO", "1");
                                            if (StringUtil.isEmptyOrNull(familyMbrAttrInfoInDto.getAttrValue())) {
                                                familyUserGroupMbrAttrMap.put("ATTR_VALUE", "1");
                                            } else {
                                                familyUserGroupMbrAttrMap.put("ATTR_VALUE", familyMbrAttrInfoInDto.getAttrValue());
                                            }
                                            if (StringUtil.isEmptyOrNull(familyMbrAttrInfoInDto.getEffDate())) {
                                                familyUserGroupMbrAttrMap.put("EFF_DATE", datetime);
                                            } else {
                                                familyUserGroupMbrAttrMap.put("EFF_DATE", familyMbrAttrInfoInDto.getEffDate());
                                            }
                                            if (StringUtil.isEmptyOrNull(familyMbrAttrInfoInDto.getGrpNo())) {
                                                familyUserGroupMbrAttrMap.put("GRP_NO", "1");
                                            } else {
                                                familyUserGroupMbrAttrMap.put("GRP_NO", familyMbrAttrInfoInDto.getGrpNo());
                                            }
                                            if (StringUtil.isEmptyOrNull(familyMbrAttrInfoInDto.getExpDate())) {
                                                familyUserGroupMbrAttrMap.put("EXP_DATE", "20180520010101");
                                            } else {
                                                familyUserGroupMbrAttrMap.put("EXP_DATE", familyMbrAttrInfoInDto.getExpDate());
                                            }
                                            familyUserGroupMbrAttrList.add(familyUserGroupMbrAttrMap);
                                        }
                                        familyMbrAddMap.put("USERGROUPMBRATTRINFOLIST", familyUserGroupMbrAttrList);
                                    }


                                    // 群成员订购实例 在途
                                    if (familyMbrUserInfoInDto.getUserGroupMbrGoodsInfoList() != null) {
                                        List<FamilyMbrGoodsInfoInDto> familyMbrGoodsInfoInDtoList = familyMbrUserInfoInDto.getUserGroupMbrGoodsInfoList();

                                        List<Map> familyUserPrcMbrInsList = new ArrayList<>();
                                        for (FamilyMbrGoodsInfoInDto familyMbrGoodsInfoInDto : familyMbrGoodsInfoInDtoList) {
                                            Map<String, Object> familyUserPrcMbrInsMap = new HashMap<>();

                                            sequenceMap.clear();
                                            sequenceMap.put("ACCEPT_LABEL", "SEQ_FM_MEMBERID");
                                            // 获取 成员标识序列
                                            //String prodprcinsId = baseLoginAccept.getPubLoginAccept(sequenceMap);
                                            String prodprcinsId = "90139012300221";
                                            familyUserPrcMbrInsMap.put("PRODPRCINS_ID", prodprcinsId);

                                            if (StringUtil.isEmptyOrNull(familyMbrGoodsInfoInDto.getExpDate())) {
                                                familyUserPrcMbrInsMap.put("EXP_DATE", "20990520010101");
                                            } else {
                                                familyUserPrcMbrInsMap.put("EXP_DATE", familyMbrGoodsInfoInDto.getExpDate());
                                            }
                                            if (StringUtil.isEmptyOrNull(familyMbrGoodsInfoInDto.getExpDate())) {
                                                familyUserPrcMbrInsMap.put("EFF_DATE", datetime);
                                            } else {
                                                familyUserPrcMbrInsMap.put("EFF_DATE", familyMbrGoodsInfoInDto.getEffDate());
                                            }
                                            familyUserPrcMbrInsMap.put("MAIN_FLAG", familyMbrGoodsInfoInDto.getGoodsType());
                                            familyUserPrcMbrInsMap.put("GOODS_ID", familyMbrGoodsInfoInDto.getGoodsId());
                                            familyUserPrcMbrInsMap.put("PROD_ID", familyMbrGoodsInfoInDto.getProdId());
                                            familyUserPrcMbrInsMap.put("PRC_ID", familyMbrGoodsInfoInDto.getPrcId());
                                            familyUserPrcMbrInsMap.put("SVC_ID", familyMbrGoodsInfoInDto.getSvcId());
                                            familyUserPrcMbrInsMap.put("ID_NO", objectId);

                                            if (familyMbrGoodsInfoInDto.getUserGroupMbrGoodsAttrInfoList() != null){
                                                List<FamilyBaseAttrInfo> userGoodsAttrInfoList = familyMbrGoodsInfoInDto.getUserGroupMbrGoodsAttrInfoList();

                                                List<Map> userGroupMbrlist = new ArrayList<>();
                                                for (FamilyBaseAttrInfo familyBaseAttrInfo : userGoodsAttrInfoList){
                                                    Map<String, Object> userGroupMbrMap = new HashMap<>();
                                                    if (StringUtil.isEmptyOrNull(familyBaseAttrInfo.getAttrId())) {
                                                        userGroupMbrMap.put("ATTR_ID", "1");
                                                    } else {
                                                        userGroupMbrMap.put("ATTR_ID", familyBaseAttrInfo.getAttrId());
                                                    }
                                                    if (StringUtil.isEmptyOrNull(familyBaseAttrInfo.getAttrValue())) {
                                                        userGroupMbrMap.put("ATTR_VALUE", "1");
                                                    } else {
                                                        userGroupMbrMap.put("ATTR_VALUE", familyBaseAttrInfo.getAttrValue());
                                                    }
                                                    userGroupMbrMap.put("ATTR_NO", "1");
                                                    if (StringUtil.isEmptyOrNull(familyBaseAttrInfo.getGrpNo())) {
                                                        userGroupMbrMap.put("GRP_NO", "1");
                                                    } else {
                                                        userGroupMbrMap.put("GRP_NO", familyBaseAttrInfo.getGrpNo());
                                                    }
                                                    userGroupMbrlist.add(userGroupMbrMap);
                                                }
                                                familyUserPrcMbrInsMap.put("USERGROUPMBRGOODSATTRINFOLIST",userGroupMbrlist);
                                            }

                                            if (familyMbrGoodsInfoInDto.getUserGroupMbrSvcAttrInfoList() != null){
                                                List<FamilyBaseAttrInfo> userSvcAttrInfoList = familyMbrGoodsInfoInDto.getUserGroupMbrSvcAttrInfoList();

                                                List<Map> userGroupMbrSvclist = new ArrayList<>();
                                                for (FamilyBaseAttrInfo familyBaseAttrInfo : userSvcAttrInfoList){
                                                    Map<String, Object> userGroupMbrSvcMap = new HashMap<>();
                                                    if (StringUtil.isEmptyOrNull(familyBaseAttrInfo.getAttrId())) {
                                                        userGroupMbrSvcMap.put("ATTR_ID", "1");
                                                    } else {
                                                        userGroupMbrSvcMap.put("ATTR_ID", familyBaseAttrInfo.getAttrId());
                                                    }
                                                    userGroupMbrSvcMap.put("ATTR_NO", "1");
                                                    if (StringUtil.isEmptyOrNull(familyBaseAttrInfo.getGrpNo())) {
                                                        userGroupMbrSvcMap.put("GRP_NO", "1");
                                                    } else {
                                                        userGroupMbrSvcMap.put("GRP_NO", familyBaseAttrInfo.getGrpNo());
                                                    }
                                                    if (StringUtil.isEmptyOrNull(familyBaseAttrInfo.getAttrValue())) {
                                                        userGroupMbrSvcMap.put("ATTR_VALUE", "1");
                                                    } else {
                                                        userGroupMbrSvcMap.put("ATTR_VALUE", familyBaseAttrInfo.getAttrValue());
                                                    }

                                                    userGroupMbrSvclist.add(userGroupMbrSvcMap);
                                                }
                                                familyUserPrcMbrInsMap.put("USERGROUPMBRSVCATTRINFOLIST",userGroupMbrSvclist);
                                            }

                                            familyUserPrcMbrInsList.add(familyUserPrcMbrInsMap);
                                        }
                                        familyMbrAddMap.put("USERGROUPMBRGOODSINFOLIST", familyUserPrcMbrInsList);
                                    }

                                    // 群成员付费关系
                                    if (familyMbrUserInfoInDto.getConUsrRelInfoList() != null) {
                                        List<FamilyMbrConuserRelInfoInDto> familyMbrConuserRelInfoInDtoList = familyMbrUserInfoInDto.getConUsrRelInfoList();

                                        List<Map> familyConUserrelList = new ArrayList<>();
                                        for (FamilyMbrConuserRelInfoInDto familyMbrConuserRelInfoInDto : familyMbrConuserRelInfoInDtoList) {
                                            Map<String, Object> familyConUserrelMap = new HashMap<>();
                                            familyConUserrelMap.put("CONTRACT_NO", contractNo);
                                            if (StringUtil.isEmptyOrNull(familyMbrConuserRelInfoInDto.getPayType())) {
                                                familyConUserrelMap.put("PAY_TYPE", "1");
                                            } else {
                                                familyConUserrelMap.put("PAY_TYPE", familyMbrConuserRelInfoInDto.getPayType());
                                            }
                                            if (StringUtil.isEmptyOrNull(familyMbrConuserRelInfoInDto.getPayValue())) {
                                                familyConUserrelMap.put("PAY_VALUE", "1");
                                            } else {
                                                familyConUserrelMap.put("PAY_VALUE", familyMbrConuserRelInfoInDto.getPayValue());
                                            }
                                            if (StringUtil.isEmptyOrNull(familyMbrConuserRelInfoInDto.getCycleType())) {
                                                familyConUserrelMap.put("CYCLE_TYPE", "1");
                                            } else {
                                                familyConUserrelMap.put("CYCLE_TYPE", familyMbrConuserRelInfoInDto.getCycleType());
                                            }
                                            if (StringUtil.isEmptyOrNull(familyMbrConuserRelInfoInDto.getDateCycle())) {
                                                familyConUserrelMap.put("DATE_CYCLE", "1");
                                            } else {
                                                familyConUserrelMap.put("DATE_CYCLE", familyMbrConuserRelInfoInDto.getDateCycle());
                                            }
                                            if (StringUtil.isEmptyOrNull(familyMbrConuserRelInfoInDto.getRateFlag())) {
                                                familyConUserrelMap.put("RATE_FLAG", "1");
                                            } else {
                                                familyConUserrelMap.put("RATE_FLAG", familyMbrConuserRelInfoInDto.getRateFlag());
                                            }
                                            if (StringUtil.isEmptyOrNull(familyMbrConuserRelInfoInDto.getExpDate())) {
                                                familyConUserrelMap.put("EXP_DATE", "20180520010101");
                                            } else {
                                                familyConUserrelMap.put("EXP_DATE", familyMbrConuserRelInfoInDto.getExpDate());
                                            }
                                            if (StringUtil.isEmptyOrNull(familyMbrConuserRelInfoInDto.getEffDate())) {
                                                familyConUserrelMap.put("EFF_DATE", datetime);
                                            } else {
                                                familyConUserrelMap.put("EFF_DATE", familyMbrConuserRelInfoInDto.getEffDate());
                                            }

                                            familyConUserrelList.add(familyConUserrelMap);
                                        }
                                        familyMbrAddMap.put("CONUSRRELINFOLIST", familyConUserrelList);

                                        familyMbrAddList.add(familyMbrAddMap);
                                    }

                                    userGroupMbrInfoListMap.put("USERGROUPMBRINFOLIST", familyMbrAddList);
                                    mBeanOne.addBody("BUSI_INFO", userGroupMbrInfoListMap);
                                    mBeanOne.addBody("OPR_INFO", oprInfoMap);
                                    mBeanOne.setHeader(routingMap);

                                    System.out.println(JSON.toJSONString(mBeanOne.toString()));

                                    outDTO = serviceClient.callService("http://familybusi-custservice/sFamilyPreAddMbrCfm",
                                            mBeanOne.toString(), OutDTO.class, ArchitectureType.SPRINGCLOUD);

                                    if (!"0".equals(outDTO.getRtnCode())) {
                                        throw new BusiException(getErrorCode("1000", "15000"), "全网订单开户测试失败", outDTO.getRtnDetailMsg());
                                    }
                                }
                            }
                        }
                    }
                    break;

                //正常状态流程
                default:
                    //
                    for (UniOrderInfoDto.FamilyOrderItemInfoDto familyOrderItemInfoDto : familyOrderItemInfoDtoList) {
                        UniOrderInfoDto.FamilyOrderOprInfoDto familyOrderOprInfoDto = familyOrderBodyInfoDto.getFamilyOrderOprInfoDto();

                        Map<String, Object> oprInfoMap = new HashMap<>();
                        oprInfoMap.put("REGION_ID", familyOrderOprInfoDto.getRegionId());
                        oprInfoMap.put("LOGIN_NO", familyOrderOprInfoDto.getLoginNo());
                        oprInfoMap.put("GROUP_ID", familyOrderOprInfoDto.getGroupId());
                        oprInfoMap.put("CONTACT_ID", familyOrderOprInfoDto.getContactId());
                        oprInfoMap.put("OP_NOTE", "1");
                        oprInfoMap.put("CHANNEL_TYPE", familyOrderOprInfoDto.getChannelType());

                        // 获取 操作流水序列
                        Map<String, String> sequenceMap = new HashMap<>(2);
                        sequenceMap.put("ACCEPT_LABEL", "SEQ_FM_LOGINACCEPT");
                        //String loginAccept = baseLoginAccept.getPubLoginAccept(sequenceMap);
                        String loginAccept = "89021380832018";
                        oprInfoMap.put("LOGIN_ACCEPT", loginAccept);
                        oprInfoMap.put("CREATE_TIME", datetime);
                        oprInfoMap.put("OP_CODE", "1");
                        oprInfoMap.put("SYSTEM_NOTE", "1");
                        oprInfoMap.put("OUT_ACCEPT", "1");

                        Map<String, Object> routeMap = new HashMap<>();
                        routeMap.put("ROUTE_KEY", "1");
                        routeMap.put("ROUTE_VALUE", "1");
                        Map<String, Object> routingMap = new HashMap<>();
                        routingMap.put("ROUTING", routeMap);

                        Object o = familyOrderItemInfoDto.getGoodsInfo();

                        String className = o.getClass().getName().substring(o.getClass().getName().lastIndexOf(".") + 1);

                        if ("FamilyOpenCfmInDto".equals(className)) {

                            FamilyOpenCfmInDto familyOpenCfmInDto = (FamilyOpenCfmInDto) familyOrderItemInfoDto.getGoodsInfo();

                            FamilyUserInfoDto familyUserInfoDto = familyOpenCfmInDto.getUserInfo();

                            //获取 家庭用户标识序列
                            sequenceMap.clear();
                            sequenceMap.put("ACCEPT_LABEL", "SEQ_FM_USERID_2301");
                            sequenceMap.put("REGION_ID", "01");
                            //String idNo = baseLoginAccept.getPubLoginAccept(sequenceMap);
                            String idNo = "80802380381123";
                            Map<String, Object> userInfoMap = new HashMap<>();
                            userInfoMap.put("ID_NO", idNo);
                            userInfoMap.put("PHONE_NO", idNo);

                            //获取 家庭账务关系标识序列
                            sequenceMap.clear();
                            sequenceMap.put("ACCEPT_LABEL", "SEQ_FM_ACCTID");
                            //String contractNo = baseLoginAccept.getPubLoginAccept(sequenceMap);
                            String contractNo = "80831082139080";
                            userInfoMap.put("CONTRACT_NO", contractNo);
                            Map<String, String> mapTen = new HashMap<>();
                            mapTen.put("ACCEPT_LABEL", "SEQ_CT_CUSTID_2301");
                            mapTen.put("REGION_ID", "01");
                            //String custId = baseLoginAccept.getPubLoginAccept(mapTen);
                            String custId = "9737981237917";
                            userInfoMap.put("CUST_ID", custId);
                            if (StringUtil.isEmptyOrNull(familyUserInfoDto.getEmpId())) {
                                userInfoMap.put("EMP_ID", "1");
                            } else {
                                userInfoMap.put("EMP_ID", familyUserInfoDto.getEmpId());
                            }
                            if (StringUtil.isEmptyOrNull(familyUserInfoDto.getEmpGroup())) {
                                userInfoMap.put("EMP_GROUP", "1");
                            } else {
                                userInfoMap.put("EMP_GROUP", familyUserInfoDto.getEmpGroup());
                            }

                            FamilyGroupInfoInDto familyGroupInfoInDto = familyUserInfoDto.getUserGroupInfo();

                            Map<String, Object> userGroupInfoMap = new HashMap<>();
                            userGroupInfoMap.put("GROUP_ID", groupId);
                            if (StringUtil.isEmptyOrNull(familyGroupInfoInDto.getUseAddress())) {
                                userGroupInfoMap.put("USE_ADDRESS", "1");
                            } else {
                                userGroupInfoMap.put("USE_ADDRESS", familyGroupInfoInDto.getUseAddress());
                            }
                            if (StringUtil.isEmptyOrNull(familyGroupInfoInDto.getGroupCode())) {
                                userGroupInfoMap.put("GROUP_CODE", "1");
                            } else {
                                userGroupInfoMap.put("GROUP_CODE", familyGroupInfoInDto.getGroupCode());
                            }
                            if (StringUtil.isEmptyOrNull(familyGroupInfoInDto.getGroupType())) {
                                userGroupInfoMap.put("GROUP_TYPE", "1");
                            } else {
                                userGroupInfoMap.put("GROUP_TYPE", familyGroupInfoInDto.getGroupType());
                            }
                            if (StringUtil.isEmptyOrNull(familyGroupInfoInDto.getGroupName())) {
                                userGroupInfoMap.put("GROUP_NAME", "1");
                            } else {
                                userGroupInfoMap.put("GROUP_NAME", familyGroupInfoInDto.getGroupName());
                            }
                            if (StringUtil.isEmptyOrNull(familyGroupInfoInDto.getGroupDesc())) {
                                userGroupInfoMap.put("GROUP_DESC", "1");
                            } else {
                                userGroupInfoMap.put("GROUP_DESC", familyGroupInfoInDto.getGroupDesc());
                            }
                            userInfoMap.put("USERGROUP_INFO", userGroupInfoMap);

                            List<FamilyUserGoodsInfoDto> familyUserGoodsInfoDtoList = familyUserInfoDto.getUserGoodsInfoList();

                            List<Map> familyUserGoodsInfoList = new ArrayList<>();
                            for (FamilyUserGoodsInfoDto familyUserGoodsInfoDto : familyUserGoodsInfoDtoList) {
                                Map<String, Object> userGoodsInfoMap = new HashMap<>();
                                userGoodsInfoMap.put("GOODS_ID", familyUserGoodsInfoDto.getGoodsId());
                                userGoodsInfoMap.put("SVC_ID", familyUserGoodsInfoDto.getSvcId());
                                userGoodsInfoMap.put("PRC_ID", familyUserGoodsInfoDto.getPrcId());
                                if (StringUtil.isEmptyOrNull(familyUserGoodsInfoDto.getGoodsType())) {
                                    userGoodsInfoMap.put("MAIN_FLAG", "1");
                                } else {
                                    userGoodsInfoMap.put("MAIN_FLAG", "1");
                                }
                                if (StringUtil.isEmptyOrNull(familyUserGoodsInfoDto.getProdId())) {
                                    userGoodsInfoMap.put("PROD_ID", "1");
                                } else {
                                    userGoodsInfoMap.put("PROD_ID", familyUserGoodsInfoDto.getProdId());
                                }
                                if (StringUtil.isEmptyOrNull(familyUserGoodsInfoDto.getEffDate())) {
                                    userGoodsInfoMap.put("EFF_DATE", datetime);
                                } else {
                                    userGoodsInfoMap.put("EFF_DATE", familyUserGoodsInfoDto.getEffDate());
                                }
                                if (StringUtil.isEmptyOrNull(familyUserGoodsInfoDto.getExpDate())) {
                                    userGoodsInfoMap.put("EXP_DATE", "20191220010101");
                                } else {
                                    userGoodsInfoMap.put("EXP_DATE", familyUserGoodsInfoDto.getExpDate());
                                }

                                if (familyUserGoodsInfoDto.getUserGoodsAttrInfoList() != null) {
                                    List<FamilyBaseAttrInfo> familyBaseAttrInfoList = familyUserGoodsInfoDto.getUserGoodsAttrInfoList();

                                    List<Map> familyUserGoodsAttrInfoList = new ArrayList<>();
                                    for (FamilyBaseAttrInfo familyBaseAttrInfo : familyBaseAttrInfoList) {
                                        Map<String, Object> userGoodsAttrInfoMap = new HashMap<>();
                                        if (StringUtil.isEmptyOrNull(familyBaseAttrInfo.getAttrId())) {
                                            userGoodsAttrInfoMap.put("ATTR_ID", "1");
                                        } else {
                                            userGoodsAttrInfoMap.put("ATTR_ID", familyBaseAttrInfo.getAttrId());
                                        }
                                        userGoodsAttrInfoMap.put("ATTR_NO", "1");
                                        if (StringUtil.isEmptyOrNull(familyBaseAttrInfo.getAttrValue())) {
                                            userGoodsAttrInfoMap.put("ATTR_VALUE", "1");
                                        } else {
                                            userGoodsAttrInfoMap.put("ATTR_VALUE", familyBaseAttrInfo.getAttrValue());
                                        }
                                        if (StringUtil.isEmptyOrNull(familyBaseAttrInfo.getGrpNo())) {
                                            userGoodsAttrInfoMap.put("GRP_NO", "1");
                                        } else {
                                            userGoodsAttrInfoMap.put("GRP_NO", familyBaseAttrInfo.getGrpNo());
                                        }
                                        familyUserGoodsAttrInfoList.add(userGoodsAttrInfoMap);
                                    }
                                    userGoodsInfoMap.put("USERGOODSATTRINFOLIST", familyUserGoodsAttrInfoList);
                                }

                                if (familyUserGoodsInfoDto.getUserSvcAttrInfoList() != null) {
                                    List<FamilyBaseAttrInfo> familyBaseAttrInfoList = familyUserGoodsInfoDto.getUserSvcAttrInfoList();

                                    List<Map> familyUserSvcAttrInfoList = new ArrayList<>();
                                    for (FamilyBaseAttrInfo familyBaseAttrInfo : familyBaseAttrInfoList) {
                                        Map<String, Object> userSvcAttrInfoMap = new HashMap<>();
                                        if (StringUtil.isEmptyOrNull(familyBaseAttrInfo.getAttrId())) {
                                            userSvcAttrInfoMap.put("ATTR_ID", "1");
                                        } else {
                                            userSvcAttrInfoMap.put("ATTR_ID", familyBaseAttrInfo.getAttrId());
                                        }
                                        if (StringUtil.isEmptyOrNull(familyBaseAttrInfo.getAttrValue())) {
                                            userSvcAttrInfoMap.put("ATTR_VALUE", "1");
                                        } else {
                                            userSvcAttrInfoMap.put("ATTR_VALUE", familyBaseAttrInfo.getAttrValue());
                                        }
                                        userSvcAttrInfoMap.put("ATTR_NO", "1");
                                        if (StringUtil.isEmptyOrNull(familyBaseAttrInfo.getGrpNo())) {
                                            userSvcAttrInfoMap.put("GRP_NO", "1");
                                        } else {
                                            userSvcAttrInfoMap.put("GRP_NO", familyBaseAttrInfo.getGrpNo());
                                        }
                                        familyUserSvcAttrInfoList.add(userSvcAttrInfoMap);
                                    }
                                    userGoodsInfoMap.put("USERSVCATTRINFOLIST", familyUserSvcAttrInfoList);
                                }
                                familyUserGoodsInfoList.add(userGoodsInfoMap);
                            }
                            userInfoMap.put("USERGOODSINFOLIST", familyUserGoodsInfoList);
                            Map<String, Object> userMap = new HashMap<>();
                            userMap.put("USER_INFO", userInfoMap);

                            mBean.addBody("BUSI_INFO", userMap);
                            mBean.setHeader(routingMap);
                            mBean.addBody("OPR_INFO", oprInfoMap);

                            //outDTO = serviceClient.callService("http://familybusi-custservice/sFamilyUserApplyCfm",
                            //        mBean.toString(), OutDTO.class, ArchitectureType.SPRINGCLOUD);
//
                            //if (!"0".equals(outDTO.getRtnCode())) {
                            //    throw new BusiException(getErrorCode("1000", "15000"), "全网订单开户测试失败", outDTO.getRtnDetailMsg());
                            //}

                            if (familyOpenCfmInDto.getUserGroupMbrInfoList() != null) {
                                List<FamilyMbrUserInfoInDto> familyMbrUserInfoInDtoList = familyOpenCfmInDto.getUserGroupMbrInfoList();

                                for (FamilyMbrUserInfoInDto familyMbrUserInfoInDto : familyMbrUserInfoInDtoList) {
                                    MBean mBeanOne = new MBean();
                                    Map<String, Object> userGroupMbrInfoListMap = new HashMap<>();

                                    List<Map> familyMbrAddList = new ArrayList<>();

                                    Map<String, Object> familyMbrAddMap = new HashMap<>();

                                    //获取 家庭账务关系标识序列
                                    sequenceMap.clear();
                                    sequenceMap.put("ACCEPT_LABEL", "SEQ_FM_MEMBERID");
                                    //String memberId = baseLoginAccept.getPubLoginAccept(sequenceMap);
                                    String memberId = "8080912380983210";

                                    familyMbrAddMap.put("MEMBER_ID", memberId);
                                    familyMbrAddMap.put("REL_MEMBER_ID", "1");
                                    familyMbrAddMap.put("GROUP_ID", groupId);
                                    if (StringUtil.isEmptyOrNull(familyMbrUserInfoInDto.getRoleId())) {
                                        familyMbrAddMap.put("ROLE_ID", "1");
                                    } else {
                                        familyMbrAddMap.put("ROLE_ID", familyMbrUserInfoInDto.getRoleId());
                                    }
                                    if (StringUtil.isEmptyOrNull(familyMbrUserInfoInDto.getMemberRoleId())) {
                                        familyMbrAddMap.put("MEMBER_ROLE_ID", "1");
                                    } else {
                                        familyMbrAddMap.put("MEMBER_ROLE_ID", familyMbrUserInfoInDto.getMemberRoleId());
                                    }
                                    if (StringUtil.isEmptyOrNull(familyMbrUserInfoInDto.getObjectType())) {
                                        familyMbrAddMap.put("OBJECT_TYPE", "1");
                                    } else {
                                        familyMbrAddMap.put("OBJECT_TYPE", familyMbrUserInfoInDto.getObjectType());
                                    }

                                    //获取 个人用户标识序列
                                    sequenceMap.clear();
                                    sequenceMap.put("ACCEPT_LABEL", "SEQ_UR_USERID_2301");
                                    sequenceMap.put("REGION_ID", "01");
                                    //String objectId = baseLoginAccept.getPubLoginAccept(sequenceMap);
                                    String objectId = "893892804802138";
                                    familyMbrAddMap.put("OBJECT_ID", objectId);

                                    if (StringUtil.isEmptyOrNull(familyMbrUserInfoInDto.getMemberDesc())) {
                                        familyMbrAddMap.put("MEMBER_DESC", "1");
                                    } else {
                                        familyMbrAddMap.put("MEMBER_DESC", familyMbrUserInfoInDto.getMemberDesc());
                                    }
                                    if (StringUtil.isEmptyOrNull(familyMbrUserInfoInDto.getEffDate())) {
                                        familyMbrAddMap.put("EFF_DATE", datetime);
                                    } else {
                                        familyMbrAddMap.put("EFF_DATE", familyMbrUserInfoInDto.getEffDate());
                                    }
                                    if (StringUtil.isEmptyOrNull(familyMbrUserInfoInDto.getExpDate())) {
                                        familyMbrAddMap.put("EXP_DATE", "20180520010101");
                                    } else {
                                        familyMbrAddMap.put("EXP_DATE", familyMbrUserInfoInDto.getExpDate());
                                    }
                                    if (StringUtil.isEmptyOrNull(familyMbrUserInfoInDto.getPhoneNO())) {
                                        familyMbrAddMap.put("PHONE_NO", "1");
                                    } else {
                                        familyMbrAddMap.put("PHONE_NO", familyMbrUserInfoInDto.getPhoneNO());
                                    }
                                    familyMbrAddMap.put("MEMBER_NAME", "1");

                                    if (familyMbrUserInfoInDto.getUserGroupMbrAttrInfoList() != null) {
                                        List<FamilyMbrAttrInfoInDto> familyMbrAttrInfoInDtoList = familyMbrUserInfoInDto.getUserGroupMbrAttrInfoList();

                                        List<Map> familyUserGroupMbrAttrList = new ArrayList<>();
                                        for (FamilyMbrAttrInfoInDto familyMbrAttrInfoInDto : familyMbrAttrInfoInDtoList) {
                                            Map<String, Object> familyUserGroupMbrAttrMap = new HashMap<>();
                                            if (StringUtil.isEmptyOrNull(familyMbrAttrInfoInDto.getAttrId())) {
                                                familyUserGroupMbrAttrMap.put("ATTR_ID", "1");
                                            } else {
                                                familyUserGroupMbrAttrMap.put("ATTR_ID", familyMbrAttrInfoInDto.getAttrId());
                                            }
                                            familyUserGroupMbrAttrMap.put("ATTR_NO", "1");
                                            if (StringUtil.isEmptyOrNull(familyMbrAttrInfoInDto.getAttrValue())) {
                                                familyUserGroupMbrAttrMap.put("ATTR_VALUE", "1");
                                            } else {
                                                familyUserGroupMbrAttrMap.put("ATTR_VALUE", familyMbrAttrInfoInDto.getAttrValue());
                                            }
                                            if (StringUtil.isEmptyOrNull(familyMbrAttrInfoInDto.getEffDate())) {
                                                familyUserGroupMbrAttrMap.put("EFF_DATE", datetime);
                                            } else {
                                                familyUserGroupMbrAttrMap.put("EFF_DATE", familyMbrAttrInfoInDto.getEffDate());
                                            }
                                            if (StringUtil.isEmptyOrNull(familyMbrAttrInfoInDto.getGrpNo())) {
                                                familyUserGroupMbrAttrMap.put("GRP_NO", "1");
                                            } else {
                                                familyUserGroupMbrAttrMap.put("GRP_NO", familyMbrAttrInfoInDto.getGrpNo());
                                            }
                                            if (StringUtil.isEmptyOrNull(familyMbrAttrInfoInDto.getExpDate())) {
                                                familyUserGroupMbrAttrMap.put("EXP_DATE", "20191220010101");
                                            } else {
                                                familyUserGroupMbrAttrMap.put("EXP_DATE", familyMbrAttrInfoInDto.getExpDate());
                                            }
                                            familyUserGroupMbrAttrList.add(familyUserGroupMbrAttrMap);
                                        }
                                        familyMbrAddMap.put("USERGROUPMBRATTRINFOLIST", familyUserGroupMbrAttrList);
                                    }


                                    //群成员订购实例
                                    if (familyMbrUserInfoInDto.getUserGroupMbrGoodsInfoList() != null) {
                                        List<FamilyMbrGoodsInfoInDto> familyMbrGoodsInfoInDtoList = familyMbrUserInfoInDto.getUserGroupMbrGoodsInfoList();

                                        List<Map> familyUserPrcMbrInsList = new ArrayList<>();
                                        for (FamilyMbrGoodsInfoInDto familyMbrGoodsInfoInDto : familyMbrGoodsInfoInDtoList) {
                                            Map<String, Object> familyUserPrcMbrInsMap = new HashMap<>();

                                            //获取 成员标识序列
                                            sequenceMap.clear();
                                            sequenceMap.put("ACCEPT_LABEL", "SEQ_FM_MEMBERID");
                                            //String prodprcinsId = baseLoginAccept.getPubLoginAccept(sequenceMap);
                                            String prodprcinsId = "8081239080928";
                                            if (StringUtil.isEmptyOrNull(familyMbrGoodsInfoInDto.getExpDate())) {
                                                familyUserPrcMbrInsMap.put("EXP_DATE", "20180520010101");
                                            } else {
                                                familyUserPrcMbrInsMap.put("EXP_DATE", familyMbrGoodsInfoInDto.getExpDate());
                                            }
                                            familyUserPrcMbrInsMap.put("PRODPRCINS_ID", prodprcinsId);

                                            familyUserPrcMbrInsList.add(familyUserPrcMbrInsMap);
                                        }
                                        familyMbrAddMap.put("USERGROUPMBRGOODSINFOLIST", familyUserPrcMbrInsList);
                                    }

                                    if (familyMbrUserInfoInDto.getConUsrRelInfoList() != null) {
                                        List<FamilyMbrConuserRelInfoInDto> familyMbrConuserRelInfoInDtoList = familyMbrUserInfoInDto.getConUsrRelInfoList();

                                        List<Map> familyConUserrelList = new ArrayList<>();
                                        for (FamilyMbrConuserRelInfoInDto familyMbrConuserRelInfoInDto : familyMbrConuserRelInfoInDtoList) {
                                            Map<String, Object> familyConUserrelMap = new HashMap<>();
                                            familyConUserrelMap.put("CONTRACT_NO", contractNo);
                                            if (StringUtil.isEmptyOrNull(familyMbrConuserRelInfoInDto.getPayType())) {
                                                familyConUserrelMap.put("PAY_TYPE", "1");
                                            } else {
                                                familyConUserrelMap.put("PAY_TYPE", familyMbrConuserRelInfoInDto.getPayType());
                                            }
                                            if (StringUtil.isEmptyOrNull(familyMbrConuserRelInfoInDto.getPayValue())) {
                                                familyConUserrelMap.put("PAY_VALUE", "1");
                                            } else {
                                                familyConUserrelMap.put("PAY_VALUE", familyMbrConuserRelInfoInDto.getPayValue());
                                            }
                                            if (StringUtil.isEmptyOrNull(familyMbrConuserRelInfoInDto.getCycleType())) {
                                                familyConUserrelMap.put("CYCLE_TYPE", "1");
                                            } else {
                                                familyConUserrelMap.put("CYCLE_TYPE", familyMbrConuserRelInfoInDto.getCycleType());
                                            }
                                            if (StringUtil.isEmptyOrNull(familyMbrConuserRelInfoInDto.getDateCycle())) {
                                                familyConUserrelMap.put("DATE_CYCLE", "1");
                                            } else {
                                                familyConUserrelMap.put("DATE_CYCLE", familyMbrConuserRelInfoInDto.getDateCycle());
                                            }
                                            if (StringUtil.isEmptyOrNull(familyMbrConuserRelInfoInDto.getRateFlag())) {
                                                familyConUserrelMap.put("RATE_FLAG", "1");
                                            } else {
                                                familyConUserrelMap.put("RATE_FLAG", familyMbrConuserRelInfoInDto.getRateFlag());
                                            }
                                            if (StringUtil.isEmptyOrNull(familyMbrConuserRelInfoInDto.getExpDate())) {
                                                familyConUserrelMap.put("EXP_DATE", "20191220010101");
                                            } else {
                                                familyConUserrelMap.put("EXP_DATE", familyMbrConuserRelInfoInDto.getExpDate());
                                            }
                                            if (StringUtil.isEmptyOrNull(familyMbrConuserRelInfoInDto.getEffDate())) {
                                                familyConUserrelMap.put("EFF_DATE", datetime);
                                            } else {
                                                familyConUserrelMap.put("EFF_DATE", familyMbrConuserRelInfoInDto.getEffDate());
                                            }
                                            familyConUserrelList.add(familyConUserrelMap);
                                        }
                                        familyMbrAddMap.put("CONUSRRELINFOLIST", familyConUserrelList);

                                        familyMbrAddList.add(familyMbrAddMap);
                                    }

                                    userGroupMbrInfoListMap.put("USERGROUPMBRINFOLIST", familyMbrAddList);
                                    mBeanOne.addBody("BUSI_INFO", userGroupMbrInfoListMap);
                                    mBeanOne.addBody("OPR_INFO", oprInfoMap);
                                    mBeanOne.setHeader(routingMap);

                                    System.out.println(JSON.toJSONString(mBeanOne.toString()));

                                    outDTO = serviceClient.callService("http://familybusi-custservice/sFamilyAddMbrCfm",
                                            mBeanOne.toString(), OutDTO.class, ArchitectureType.SPRINGCLOUD);

                                    if (!"0".equals(outDTO.getRtnCode())) {
                                        throw new BusiException(getErrorCode("1000", "15000"), "全网订单开户测试失败", outDTO.getRtnDetailMsg());
                                    }
                                }
                            }
                        }
                    }
                    break;
            }

        } catch (Exception e) {
            throw new BusiException("99999999999999999", "全网订单开户测试API接口失败", e.getMessage());
        }

        outDTO.setBodyOutData("全网订单开户测试API接口成功");
        return outDTO;
    }
}
