package com.sitech.family.familyservice.compbusi.impl;

import com.sitech.family.common.constants.InsTypeEnum;
import com.sitech.family.common.constants.RelationTypeEnum;
import com.sitech.family.common.constants.RelopTypeEnum;
import com.sitech.family.common.pubdto.FamilyMbrAdd;
import com.sitech.family.common.util.BaseLoginAccept;
import com.sitech.family.common.util.DateConst;
import com.sitech.family.common.util.SequenceConst;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.familyservice.atombusi.IFamilyMbrAttrMidInfo;
import com.sitech.family.familyservice.atombusi.IFamilyMbrPrcMidInfo;
import com.sitech.family.familyservice.compbusi.IFamilyMbrPrcMidCo;
import com.sitech.family.familyservice.dto.commondto.OprInfo;
import com.sitech.family.familyservice.dto.indto.FamilyAddMbrInDto;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.usergroup.UserMbrAttrMidInfo;
import com.sitech.family.dto.usergroup.UserMbrPrcMidInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.DateUtil;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description 在途订购实例实现
 * @date 2019/4/17 15:21
 */
@Component
public class FamilyMbrPrcMidCo implements IFamilyMbrPrcMidCo {
    private static Logger logger = LoggerFactory.getLogger(FamilyMbrPrcMidCo.class);

    @Autowired
    private IFamilyMbrPrcMidInfo iFamilyMbrPrcMidInfo;

    @Autowired
    private IFamilyMbrAttrMidInfo iFamilyMbrAttrMidInfo;

    @Autowired
    private BaseLoginAccept baseLoginAccept;


    /**
     * 在途订购实例组合实体新增
     *
     * @param map
     * @return ReturnDto
     */
    @Override
    public ReturnDto create(Map<String, Object> map) {
        ReturnDto returnDto = new ReturnDto();

        try {
            //获取oprInfo节点信息
            OprInfo oprInfo = (OprInfo) map.get("oprInfo");
            String createTime = oprInfo.getCreateTime();
            String loginNo = oprInfo.getLoginNo();
            String loginAccept = oprInfo.getLoginAccept();
            String outAccept = oprInfo.getOutAccept();
            String opNote = oprInfo.getOpNote();
            String opCode = oprInfo.getOpCode();
            String systemNote = oprInfo.getSystemNote();

            //获取busiInfo节点信息
            FamilyAddMbrInDto familyAddMbrInDto = (FamilyAddMbrInDto) map.get("busiInfo");

            //判断家庭群成员关系list节点是否存在
            if (StringUtil.isNotEmptyOrNull(familyAddMbrInDto.getFamilyMbrAddList())) {
                List<FamilyMbrAdd> familyMbrAddList = familyAddMbrInDto.getFamilyMbrAddList();

                for (FamilyMbrAdd familyMbrAdd : familyMbrAddList) {
                    Map<String, String> acceptMap = new HashMap<>();

                    //判断成员订购实例中间list节点是否存在
                    if (StringUtil.isNotEmptyOrNull(familyMbrAdd.getFamilyUserPrcMbrInsList())) {
                        List<FamilyMbrAdd.FamilyUserPrcMbrIns> familyMbrPrcList = familyMbrAdd.getFamilyUserPrcMbrInsList();

                        for (FamilyMbrAdd.FamilyUserPrcMbrIns familyUserPrcMbrIns : familyMbrPrcList) {
                            UserMbrPrcMidInfo userMbrPrcMidInfo = new UserMbrPrcMidInfo();
                            userMbrPrcMidInfo.setIdNo(Long.parseLong(familyMbrAdd.getObjectId()));
                            userMbrPrcMidInfo.setMemberId(new BigDecimal(familyMbrAdd.getMemberId()));
                            userMbrPrcMidInfo.setParinsId(new BigDecimal("1"));
                            userMbrPrcMidInfo.setRelopType(RelopTypeEnum.VAL_A.getValue());
                            userMbrPrcMidInfo.setRelationType(RelationTypeEnum.VAL_7.getValue());
                            userMbrPrcMidInfo.setRelinsId(new BigDecimal("1"));
                            userMbrPrcMidInfo.setMainFlag(familyUserPrcMbrIns.getMainFlag());
                            userMbrPrcMidInfo.setProdId(familyUserPrcMbrIns.getProdId());
                            if (StringUtil.isNotEmptyOrNull(familyUserPrcMbrIns.getEffDate())) {
                                userMbrPrcMidInfo.setEffDate(DateUtil.toDate(familyUserPrcMbrIns.getEffDate(), DateConst.DATE_MODEL_8));
                            }
                            userMbrPrcMidInfo.setExpDate(DateUtil.toDate(familyUserPrcMbrIns.getExpDate(), DateConst.DATE_MODEL_8));
                            userMbrPrcMidInfo.setOrderDate(DateUtil.toDate(createTime, DateConst.DATE_MODEL_8));
                            userMbrPrcMidInfo.setOpTime(DateUtil.toDate(createTime, DateConst.DATE_MODEL_8));
                            userMbrPrcMidInfo.setOpCode(opCode);
                            userMbrPrcMidInfo.setLoginNo(loginNo);
                            userMbrPrcMidInfo.setOutAccept(outAccept);
                            userMbrPrcMidInfo.setLoginAccept(Long.parseLong(loginAccept));
                            userMbrPrcMidInfo.setOpNote(opNote);
                            userMbrPrcMidInfo.setSystemNote(systemNote);

                            if (StringUtil.isNotEmptyOrNull(familyUserPrcMbrIns.getGoodsId())) {
                                userMbrPrcMidInfo.setGoodsId(familyUserPrcMbrIns.getGoodsId());
                                acceptMap.put("ACCEPT_LABEL", SequenceConst.SEQ_FM_GOODSINS_ID);
                                String goodsInsId = baseLoginAccept.getPubLoginAccept(acceptMap);
                                userMbrPrcMidInfo.setInsValue(new BigDecimal(goodsInsId));
                                userMbrPrcMidInfo.setInsType(InsTypeEnum.VAL_1.getValue());
                                userMbrPrcMidInfo.setOtherinsId(new BigDecimal("1"));

                                returnDto = iFamilyMbrPrcMidInfo.create(userMbrPrcMidInfo);

                                if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                                    returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                                    return returnDto;
                                }
                                //判断订购实例属性中间list节点是否存在
                                if (StringUtil.isNotEmptyOrNull(familyUserPrcMbrIns.getFamilyMbrPrcAttrMidList())) {
                                    List<FamilyMbrAdd.FamilyMbrPrcAttrMid> familyMbrPrcAttrMidList = familyUserPrcMbrIns.getFamilyMbrPrcAttrMidList();

                                    for (FamilyMbrAdd.FamilyMbrPrcAttrMid familyMbrPrcAttrMid : familyMbrPrcAttrMidList) {
                                        UserMbrAttrMidInfo userMbrAttrMidInfo = new UserMbrAttrMidInfo();

                                        userMbrAttrMidInfo.setInsType(InsTypeEnum.VAL_1.getValue());
                                        userMbrAttrMidInfo.setInsValue(new BigDecimal(goodsInsId));
                                        userMbrAttrMidInfo.setAttrId(familyMbrPrcAttrMid.getAttrId());
                                        if (StringUtil.isNotEmptyOrNull(familyUserPrcMbrIns.getEffDate())) {
                                            userMbrAttrMidInfo.setEffDate(DateUtil.toDate(familyUserPrcMbrIns.getEffDate(), DateConst.DATE_MODEL_8));
                                        }
                                        userMbrAttrMidInfo.setAttrNo(familyMbrPrcAttrMid.getAttrNo());
                                        userMbrAttrMidInfo.setAttrValue(familyMbrPrcAttrMid.getAttrValue());
                                        userMbrAttrMidInfo.setGrpNo(familyMbrPrcAttrMid.getGrpNo());
                                        userMbrAttrMidInfo.setExpDate(DateUtil.toDate(familyUserPrcMbrIns.getExpDate(), DateConst.DATE_MODEL_8));
                                        userMbrAttrMidInfo.setOpTime(DateUtil.toDate(createTime, DateConst.DATE_MODEL_8));
                                        userMbrAttrMidInfo.setOpCode(opCode);
                                        userMbrAttrMidInfo.setLoginNo(loginNo);
                                        userMbrAttrMidInfo.setOutAccept(outAccept);
                                        userMbrAttrMidInfo.setLoginAccept(Long.parseLong(loginAccept));
                                        userMbrAttrMidInfo.setOpNote(opNote);
                                        userMbrAttrMidInfo.setSystemNote(systemNote);

                                        returnDto = iFamilyMbrAttrMidInfo.create(userMbrAttrMidInfo);

                                        if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                                            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                                            return returnDto;
                                        }
                                    }
                                }
                            }

                            acceptMap.clear();

                            if (StringUtil.isNotEmptyOrNull(familyUserPrcMbrIns.getPrcId())) {
                                userMbrPrcMidInfo.setPrcId(familyUserPrcMbrIns.getPrcId());
                                acceptMap.put("ACCEPT_LABEL", SequenceConst.SEQ_FM_PRODPRCINS_ID);
                                String prodPrcInsId = baseLoginAccept.getPubLoginAccept(acceptMap);
                                userMbrPrcMidInfo.setInsValue(new BigDecimal(prodPrcInsId));
                                userMbrPrcMidInfo.setInsType(InsTypeEnum.VAL_2.getValue());
                                userMbrPrcMidInfo.setOtherinsId(new BigDecimal("2"));

                                returnDto = iFamilyMbrPrcMidInfo.create(userMbrPrcMidInfo);

                                if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                                    returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                                    return returnDto;
                                }
                            }

                            acceptMap.clear();

                            if (StringUtil.isNotEmptyOrNull(familyUserPrcMbrIns.getSvcId())) {
                                userMbrPrcMidInfo.setSvcId(familyUserPrcMbrIns.getSvcId());
                                acceptMap.put("ACCEPT_LABEL", SequenceConst.SEQ_FM_SVCINSID);
                                String svcInsId = baseLoginAccept.getPubLoginAccept(acceptMap);
                                userMbrPrcMidInfo.setInsValue(new BigDecimal(svcInsId));
                                userMbrPrcMidInfo.setInsType(InsTypeEnum.VAL_3.getValue());
                                userMbrPrcMidInfo.setOtherinsId(new BigDecimal("3"));

                                returnDto = iFamilyMbrPrcMidInfo.create(userMbrPrcMidInfo);

                                if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                                    returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                                    return returnDto;
                                }

                                //判断订购实例属性中间list节点是否存在
                                if (StringUtil.isNotEmptyOrNull(familyUserPrcMbrIns.getFamilyMbrSvcAttrMidList())) {
                                    List<FamilyMbrAdd.FamilyMbrSvcAttrMid> familyMbrSvcAttrMidList = familyUserPrcMbrIns.getFamilyMbrSvcAttrMidList();

                                    for (FamilyMbrAdd.FamilyMbrSvcAttrMid familyMbrSvcAttrMid : familyMbrSvcAttrMidList) {
                                        UserMbrAttrMidInfo userMbrAttrMidInfo = new UserMbrAttrMidInfo();

                                        userMbrAttrMidInfo.setInsType("3");
                                        userMbrAttrMidInfo.setInsValue(new BigDecimal(svcInsId));
                                        userMbrAttrMidInfo.setAttrId(familyMbrSvcAttrMid.getAttrId());
                                        if (StringUtil.isNotEmptyOrNull(familyUserPrcMbrIns.getEffDate())) {
                                            userMbrAttrMidInfo.setEffDate(DateUtil.toDate(familyUserPrcMbrIns.getEffDate(), DateConst.DATE_MODEL_8));
                                        }
                                        userMbrAttrMidInfo.setAttrNo(familyMbrSvcAttrMid.getAttrNo());
                                        userMbrAttrMidInfo.setAttrValue(familyMbrSvcAttrMid.getAttrValue());
                                        userMbrAttrMidInfo.setGrpNo(familyMbrSvcAttrMid.getGrpNo());
                                        userMbrAttrMidInfo.setExpDate(DateUtil.toDate(familyUserPrcMbrIns.getExpDate(), DateConst.DATE_MODEL_8));
                                        userMbrAttrMidInfo.setOpTime(DateUtil.toDate(createTime, DateConst.DATE_MODEL_8));
                                        userMbrAttrMidInfo.setOpCode(opCode);
                                        userMbrAttrMidInfo.setLoginNo(loginNo);
                                        userMbrAttrMidInfo.setOutAccept(outAccept);
                                        userMbrAttrMidInfo.setLoginAccept(Long.parseLong(loginAccept));
                                        userMbrAttrMidInfo.setOpNote(opNote);
                                        userMbrAttrMidInfo.setSystemNote(systemNote);

                                        returnDto = iFamilyMbrAttrMidInfo.create(userMbrAttrMidInfo);

                                        if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                                            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                                            return returnDto;
                                        }
                                    }
                                }
                            }

                            acceptMap.clear();
                        }
                    }
                }
            }
        } catch (Exception e) {
            logger.error("家庭在途订购实例创建失败" + e.getMessage());
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("家庭在途订购实例创建成功");

        return returnDto;
    }


}
