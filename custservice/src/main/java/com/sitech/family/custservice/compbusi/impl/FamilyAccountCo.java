package com.sitech.family.custservice.compbusi.impl;

import com.sitech.family.common.pubdto.FamilyMbrAdd;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.atombusi.IFamilyConUserRateInfo;
import com.sitech.family.custservice.atombusi.IFamilyConUserRelInfo;
import com.sitech.family.custservice.atombusi.IFamilyUserGroupInfo;
import com.sitech.family.custservice.atombusi.IFamilyUserGroupMbrInfo;
import com.sitech.family.custservice.base.util.BaseLoginAccept;
import com.sitech.family.custservice.base.util.DateConst;
import com.sitech.family.custservice.compbusi.IFamilyAccountCo;
import com.sitech.family.custservice.dto.commondto.OprInfo;
import com.sitech.family.custservice.dto.indto.*;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.UpdateOprInfo;
import com.sitech.family.dto.account.ConUserRateInfo;
import com.sitech.family.dto.account.ConUserRelInfo;
import com.sitech.family.dto.usergroup.UserGroupInfo;
import com.sitech.family.dto.usergroup.UserGroupMbrInfo;
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

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author wusm
 * @description 家庭账户组合实体
 * @date 2019/3/26 10:47
 */
@Component
public class FamilyAccountCo implements IFamilyAccountCo {
    private static Logger logger = LoggerFactory.getLogger(FamilyAccountCo.class);

    @Autowired
    private IFamilyConUserRelInfo iFamilyConUserRelInfo;

    @Autowired
    private IFamilyConUserRateInfo iFamilyConUserRateInfo;

    @Autowired
    private IFamilyUserGroupInfo iFamilyUserGroupInfo;

    @Autowired
    private IFamilyUserGroupMbrInfo iFamilyUserGroupMbrInfo;

    @Autowired
    private BaseLoginAccept baseLoginAccept;

    /**
     * 家庭账户组合实体新增
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
            String systemNote = oprInfo.getSystemNote();
            String opCode = oprInfo.getOpCode();

            //获取busiInfo节点信息
            FamilyAddMbrInDto familyAddMbrInDto = (FamilyAddMbrInDto) map.get("busiInfo");

            //判断家庭群成员关系list节点是否存在
            if (StringUtil.isNotEmptyOrNull(familyAddMbrInDto.getFamilyMbrAddList())) {
                List<FamilyMbrAdd> familyMbrAddList = familyAddMbrInDto.getFamilyMbrAddList();

                for (FamilyMbrAdd familyMbrAdd : familyMbrAddList) {
                    Map<String, String> stringMap = new HashMap<>();
                    stringMap.put("ACCEPT_LABEL", "SEQ_FM_ACCTID");
                    Long servAcctId = Long.parseLong(baseLoginAccept.getPubLoginAccept(stringMap));

                    //判断家庭付费关系list节点是否存在
                    if (StringUtil.isNotEmptyOrNull(familyMbrAdd.getFamilyConUsrrelList())) {
                        List<FamilyMbrAdd.FamilyConUserrel> familyConUsrrelList = familyMbrAdd.getFamilyConUsrrelList();

                        for (FamilyMbrAdd.FamilyConUserrel familyConUserrel : familyConUsrrelList) {
                            ConUserRelInfo conUserRelInfo = new ConUserRelInfo();
                            conUserRelInfo.setServAcctId(servAcctId);
                            conUserRelInfo.setIdNo(Long.parseLong(familyMbrAdd.getObjectId()));
                            conUserRelInfo.setContractNo(Long.valueOf(familyConUserrel.getContractNo()));
                            conUserRelInfo.setPayType(familyConUserrel.getPayType());
                            conUserRelInfo.setPayValue(Double.parseDouble(familyConUserrel.getPayValue()));
                            conUserRelInfo.setCycleType(familyConUserrel.getCycleType());
                            conUserRelInfo.setDateCycle(Integer.valueOf(familyConUserrel.getDateCycle()));
                            conUserRelInfo.setRateFlag(familyConUserrel.getRateFlag());
                            //参考之前的代码怎么传值
                            conUserRelInfo.setBillOrder(1);
                            conUserRelInfo.setPayOrder(1);
                            conUserRelInfo.setEffDate(DateUtil.toDate(familyConUserrel.getEffDate(), DateConst.DATE_MODEL_8));
                            conUserRelInfo.setExpDate(DateUtil.toDate(familyConUserrel.getExpDate(), DateConst.DATE_MODEL_8));
                            conUserRelInfo.setOpTime(DateUtil.toDate(createTime, DateConst.DATE_MODEL_8));
                            conUserRelInfo.setOpCode(opCode);
                            conUserRelInfo.setLoginNo(loginNo);
                            conUserRelInfo.setLoginAccept(Long.parseLong(loginAccept));
                            conUserRelInfo.setOutAccept(outAccept);
                            conUserRelInfo.setOpNote(opNote);
                            conUserRelInfo.setSystemNote(systemNote);
                            conUserRelInfo.setFinishFlag(String.valueOf(map.get("finishFlag")));

                            returnDto = iFamilyConUserRelInfo.create(conUserRelInfo);

                            if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                                return returnDto;
                            }

                            //判断家庭付费明细list节点是否存在
                            if (StringUtil.isNotEmptyOrNull(familyConUserrel.getFamilyConUserRateList())) {
                                List<FamilyMbrAdd.FamilyConUserRate> familyConUserRateList = familyConUserrel.getFamilyConUserRateList();

                                for (FamilyMbrAdd.FamilyConUserRate familyConUserRate : familyConUserRateList) {
                                    ConUserRateInfo conUserRateInfo = new ConUserRateInfo();

                                    conUserRateInfo.setServAcctId(servAcctId);
                                    conUserRateInfo.setFeeCode(familyConUserRate.getFeeCode());
                                    conUserRateInfo.setDetailCode(familyConUserRate.getDetailCode());
                                    conUserRateInfo.setRateBillOrder(Integer.valueOf(familyConUserRate.getRateBillOrder()));
                                    conUserRateInfo.setFeeRate(Double.parseDouble(familyConUserRate.getFeeRate()));
                                    conUserRateInfo.setFeeValue(Double.parseDouble(familyConUserRate.getFeeValue()));
                                    conUserRateInfo.setEffDate(DateUtil.toDate(familyConUserRate.getEffDate(), DateConst.DATE_MODEL_8));
                                    conUserRateInfo.setExpDate(DateUtil.toDate(familyConUserRate.getExpDate(), DateConst.DATE_MODEL_8));
                                    conUserRateInfo.setOpTime(DateUtil.toDate(createTime, DateConst.DATE_MODEL_8));
                                    conUserRateInfo.setOpCode(opCode);
                                    conUserRateInfo.setLoginNo(loginNo);
                                    conUserRateInfo.setLoginAccept(Long.parseLong(loginAccept));
                                    conUserRateInfo.setOupAccept(outAccept);
                                    conUserRateInfo.setOpNote(opNote);
                                    conUserRateInfo.setSystemNote(systemNote);

                                    returnDto = iFamilyConUserRateInfo.create(conUserRateInfo);

                                    if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                                        returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                                        return returnDto;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            logger.error("家庭账户创建失败" + e.getMessage());
            throw new BusiException(getErrorCode("1000", "15000"), "家庭账户创建失败" + e.getMessage());

        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("家庭账户创建成功");

        return returnDto;
    }

    /**
     * 更新竣工标志
     *
     * @param map
     * @return ReturnDto
     */
    @Override
    public ReturnDto updateFinishState(Map<String, Object> map) {
        ReturnDto returnDto = new ReturnDto();

        try {
            UpdateOprInfo updateOprInfo = (UpdateOprInfo) map.get("oprInfo");
            List<UserGroupInfo> list = iFamilyUserGroupInfo.qryUserGroupInfoList(map);

            BigDecimal groupId = null;
            if (!list.isEmpty()) {
                for (UserGroupInfo userGroupInfo : list) {
                    groupId = userGroupInfo.getGroupId();
                }
            }

            Map<String, Object> mapOne = new HashMap<>();
            mapOne.put("groupId", groupId);

            List<UserGroupMbrInfo> userGroupMbrInfoList = iFamilyUserGroupMbrInfo.qryUserGroupMbrInfoList(mapOne);

            for (UserGroupMbrInfo userGroupMbrInfo : userGroupMbrInfoList) {
                returnDto = iFamilyConUserRelInfo.updateFinishState(updateOprInfo, Long.valueOf(userGroupMbrInfo.getObjectId()));

                if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                    returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                    return returnDto;
                }
            }
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "更新竣工标志失败" + e.getMessage());
        }

        returnDto.setCode(returnDto.getCode());
        returnDto.setMessage(returnDto.getMessage());
        return returnDto;
    }

    /**
     * 账户组合实体删除
     *
     * @param map
     * @return
     */
    @Override
    public ReturnDto drop(Map<String, Object> map) {

        ReturnDto returnDto;

        try {
            //获取 用户标识 账户标识
            String idNo = (String) map.get("idNo");
            String contractNo = (String) map.get("contractNo");

            if (StringUtil.isEmptyOrNull(idNo) || StringUtil.isEmptyOrNull(contractNo)) {
                throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "处理失败", "参数不能为空");
            }

            // 1.家庭付费关系删除
            List<ConUserRelInfo> relInfoList = iFamilyConUserRelInfo.qryConUserRelInfoList(map);
            if (relInfoList.size() == 0) {
                throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "未找到成员付费关系信息");
            }

            ReturnDto relResult = iFamilyConUserRelInfo.drop(relInfoList.get(0));
            if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(relResult.getCode())) {
                returnDto = new ReturnDto();
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage(relResult.getMessage());
                return returnDto;
            }

            // 2.家庭付费明细
            Map<String, Object> inDto = new HashMap<>();
            inDto.put("servAcctId", relInfoList.get(0).getServAcctId());
            inDto.put("idNo",idNo);
            List<ConUserRateInfo> rateInfoList = iFamilyConUserRateInfo.qryConUserRateInfoList(inDto);

            if (rateInfoList.size() == 0) {
                throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "未找到成员付费明细关系信息");
            }

            ReturnDto rateResult = iFamilyConUserRateInfo.drop(rateInfoList.get(0));
            if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(rateResult.getCode())) {
                returnDto = new ReturnDto();
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage(rateResult.getMessage());
                return returnDto;
            }


            returnDto = new ReturnDto();
            returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
            return returnDto;

        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), e.getMessage());
        }
    }
}
