package com.sitech.family.custservice.compbusi.impl;

import com.sitech.family.common.constants.StateEnum;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.atombusi.IFamilyUserGroupInfo;
import com.sitech.family.custservice.atombusi.IFamilyUserGroupMbrAttrInfo;
import com.sitech.family.custservice.atombusi.IFamilyUserGroupMbrInfo;
import com.sitech.family.custservice.atombusi.IFamilyUserPrcMbrInsInfo;
import com.sitech.family.custservice.base.util.DateConst;
import com.sitech.family.custservice.compbusi.IFamilyUserGroupMbrCo;
import com.sitech.family.custservice.dto.commondto.OprInfo;
import com.sitech.family.custservice.dto.indto.FamilyAddMbrInDto;
import com.sitech.family.common.pubdto.FamilyMbrAdd;
import com.sitech.family.custservice.dto.indto.FamilyMbrPrcInsInDto;
import com.sitech.family.dto.UpdateOprInfo;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.usergroup.UserGroupInfo;
import com.sitech.family.dto.usergroup.UserGroupMbrAttrInfo;
import com.sitech.family.dto.usergroup.UserGroupMbrInfo;
import com.sitech.family.dto.usergroup.UserPrcMbrInsInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.DateUtil;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author wusm
 * @description 家庭用户订购关系资料组合实体
 * @date 2019/3/26 10:46
 */
@Component
public class FamilyUserGroupMbrCo implements IFamilyUserGroupMbrCo {

    private static Logger logger = LoggerFactory.getLogger(FamilyUserGroupMbrCo.class);

    @Autowired
    private IFamilyUserGroupMbrInfo iFamilyUserGroupMbrInfo;

    @Autowired
    private IFamilyUserGroupInfo iFamilyUserGroupInfo;

    @Autowired
    private IFamilyUserGroupMbrAttrInfo iFamilyUserGroupMbrAttrInfo;

    @Autowired
    private IFamilyUserPrcMbrInsInfo iFamilyUserPrcMbrInsInfo;

    /**
     * 家庭用户订购关系料组合实体新增
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
                List<FamilyMbrAdd> familyUserGroupMbrList = familyAddMbrInDto.getFamilyMbrAddList();

                for (FamilyMbrAdd familyMbrAdd : familyUserGroupMbrList) {
                    UserGroupMbrInfo userGroupMbrInfo = new UserGroupMbrInfo();

                    userGroupMbrInfo.setMemberId(new BigDecimal(familyMbrAdd.getMemberId()));
                    userGroupMbrInfo.setRelMemberId(new BigDecimal(familyMbrAdd.getRelMemberId()));
                    userGroupMbrInfo.setGroupId(new BigDecimal(familyMbrAdd.getGroupId()));
                    userGroupMbrInfo.setMbrRole(Long.parseLong(familyMbrAdd.getMemberRoleId()));
                    userGroupMbrInfo.setObjectType(familyMbrAdd.getObjectType());
                    userGroupMbrInfo.setObjectId(familyMbrAdd.getObjectId());
                    userGroupMbrInfo.setMemberDesc(familyMbrAdd.getMemberDesc());
                    userGroupMbrInfo.setMemberName(familyMbrAdd.getMemberName());
                    userGroupMbrInfo.setEffDate(DateUtil.toDate(familyMbrAdd.getEffDate(), DateConst.DATE_MODEL_8));
                    userGroupMbrInfo.setExpDate(DateUtil.toDate(familyMbrAdd.getExpDate(), DateConst.DATE_MODEL_8));
                    userGroupMbrInfo.setOpTime(DateUtil.toDate(createTime, DateConst.DATE_MODEL_8));
                    userGroupMbrInfo.setOpCode(opCode);
                    userGroupMbrInfo.setLoginNo(loginNo);
                    userGroupMbrInfo.setLoginAccept(Long.parseLong(loginAccept));
                    userGroupMbrInfo.setOutAccept(outAccept);
                    userGroupMbrInfo.setOpNote(opNote);
                    userGroupMbrInfo.setSystemNote(systemNote);
                    userGroupMbrInfo.setPhoneNo(familyMbrAdd.getPhoneNo());
                    userGroupMbrInfo.setState(String.valueOf(map.get("state")));
                    userGroupMbrInfo.setStateDate(DateUtil.toDate(createTime, DateConst.DATE_MODEL_8));

                    returnDto = iFamilyUserGroupMbrInfo.create(userGroupMbrInfo);

                    if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                        returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                        return returnDto;
                    }

                    //判断家庭群成员属性list节点是否存在
                    if (StringUtil.isNotEmptyOrNull(familyMbrAdd.getFamilyUserGroupMbrAttrList())) {
                        List<FamilyMbrAdd.FamilyUserGroupMbrAttr> familyUserGroupMbrAttrList = familyMbrAdd.getFamilyUserGroupMbrAttrList();

                        for (FamilyMbrAdd.FamilyUserGroupMbrAttr familyUserGroupMbrAttr : familyUserGroupMbrAttrList) {
                            UserGroupMbrAttrInfo userGroupMbrAttrInfo = new UserGroupMbrAttrInfo();
                            userGroupMbrAttrInfo.setMemberId(new BigDecimal(familyMbrAdd.getMemberId()));
                            userGroupMbrAttrInfo.setAttrId(familyUserGroupMbrAttr.getAttrId());
                            userGroupMbrAttrInfo.setEffDate(DateUtil.toDate(familyUserGroupMbrAttr.getEffDate(), DateConst.DATE_MODEL_8));
                            userGroupMbrAttrInfo.setAttrNo(familyUserGroupMbrAttr.getAttrNo());
                            userGroupMbrAttrInfo.setAttrValue(familyUserGroupMbrAttr.getAttrValue());
                            userGroupMbrAttrInfo.setGrpNo(familyUserGroupMbrAttr.getGrpNo());
                            userGroupMbrAttrInfo.setExpDate(DateUtil.toDate(familyUserGroupMbrAttr.getExpDate(), DateConst.DATE_MODEL_8));
                            userGroupMbrAttrInfo.setOpTime(DateUtil.toDate(createTime, DateConst.DATE_MODEL_8));
                            userGroupMbrAttrInfo.setOpCode(opCode);
                            userGroupMbrAttrInfo.setLoginNo(loginNo);
                            userGroupMbrAttrInfo.setLoginAccept(Long.parseLong(loginAccept));
                            userGroupMbrAttrInfo.setOutAccept(outAccept);
                            userGroupMbrAttrInfo.setOpNote(opNote);
                            userGroupMbrAttrInfo.setSystemNote(systemNote);
                            userGroupMbrAttrInfo.setState(String.valueOf(map.get("state")));
                            userGroupMbrAttrInfo.setStateDate(DateUtil.toDate(createTime, DateConst.DATE_MODEL_8));

                            returnDto = iFamilyUserGroupMbrAttrInfo.create(userGroupMbrAttrInfo);

                            if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                                return returnDto;
                            }
                        }
                    }

                    //判断订购实例与成员实例关系list节点是否存在
                    if (StringUtil.isNotEmptyOrNull(familyMbrAdd.getFamilyUserPrcMbrInsList())) {
                        List<FamilyMbrAdd.FamilyUserPrcMbrIns> familyUserPrcMbrInsList = familyMbrAdd.getFamilyUserPrcMbrInsList();

                        for (FamilyMbrAdd.FamilyUserPrcMbrIns familyUserPrcMbrIns : familyUserPrcMbrInsList) {
                            UserPrcMbrInsInfo userPrcMbrInsInfo = new UserPrcMbrInsInfo();
                            userPrcMbrInsInfo.setMemberId(new BigDecimal(familyMbrAdd.getMemberId()));
                            userPrcMbrInsInfo.setProdPrcInsId(new BigDecimal(familyUserPrcMbrIns.getProdprcinsId()));
                            userPrcMbrInsInfo.setIdNo(Long.parseLong(familyMbrAdd.getObjectId()));
                            userPrcMbrInsInfo.setExpDate(DateUtil.toDate(familyUserPrcMbrIns.getExpDate(), DateConst.DATE_MODEL_8));
                            userPrcMbrInsInfo.setOpTime(DateUtil.toDate(createTime, DateConst.DATE_MODEL_8));
                            userPrcMbrInsInfo.setOpCode(opCode);
                            userPrcMbrInsInfo.setLoginNo(loginNo);
                            userPrcMbrInsInfo.setLoginAccept(Long.parseLong(loginAccept));
                            userPrcMbrInsInfo.setOutAccept(outAccept);
                            userPrcMbrInsInfo.setOpNote(opNote);
                            userPrcMbrInsInfo.setSystemNote(systemNote);
                            userPrcMbrInsInfo.setState(String.valueOf(map.get("state")));
                            userPrcMbrInsInfo.setStateDate(DateUtil.toDate(createTime, DateConst.DATE_MODEL_8));

                            returnDto = iFamilyUserPrcMbrInsInfo.create(userPrcMbrInsInfo);

                            if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                                return returnDto;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            logger.error("家庭用户订购关系料创建失败" + e.getMessage());
            throw new BusiException(getErrorCode("1000", "15000"), "家庭用户订购关系料创建失败" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("家庭用户订购关系料创建成功");

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
            String objectId = String.valueOf(map.get("objectId"));

            returnDto = iFamilyUserGroupMbrInfo.updateFinishState(updateOprInfo, objectId);

            if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                return returnDto;
            }

            returnDto = iFamilyUserGroupMbrAttrInfo.updateFinishState(updateOprInfo, objectId);

            if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                return returnDto;
            }

            returnDto = iFamilyUserPrcMbrInsInfo.updateFinishState(updateOprInfo, objectId);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "更新竣工标志失败" + e.getMessage());
        }

        returnDto.setCode(returnDto.getCode());
        returnDto.setMessage(returnDto.getMessage());
        return returnDto;
    }

    /**
     * 根据roleId、state、groupId查询该群下有无长流程订单
     *
     * @param map
     * @return boolean
     */
    @Override
    public boolean qryLongProcessFlag(Map<String, Object> map) {
        BigDecimal groupId = null;
        Long roleId = null;

        try {
            List<UserGroupInfo> list = iFamilyUserGroupInfo.qryUserGroupInfoList(map);

            if (!list.isEmpty()) {
                for (UserGroupInfo userGroupInfo : list) {
                    groupId = userGroupInfo.getGroupId();
                }
            }

            Map<String, Object> mapOne = new HashMap<>();
            mapOne.put("groupId", groupId);
            mapOne.put("roleId", "12");
            mapOne.put("state", StateEnum.VAL_B.getValue());

            List<UserGroupMbrInfo> userGroupMbrInfoList = iFamilyUserGroupMbrInfo.qryUserGroupMbrInfoList(mapOne);

            if (userGroupMbrInfoList.isEmpty()) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询长流程订单失败" + e.getMessage());
        }
    }

    /**
     * 根据roleId、groupId查询该群下所有短流程订单
     *
     * @param map
     * @return list
     */
    @Override
    public List<UserGroupMbrInfo> qryShortProcessList(Map<String, Object> map) {
        try {
            BigDecimal groupId = null;
            Long roleId = null;

            List<UserGroupInfo> list = iFamilyUserGroupInfo.qryUserGroupInfoList(map);

            if (!list.isEmpty()) {
                for (UserGroupInfo userGroupInfo : list) {
                    groupId = userGroupInfo.getGroupId();
                }
            }

            Map<String, Object> mapOne = new HashMap<>();
            mapOne.put("groupId", groupId);
            mapOne.put("roleId", "12");

            List<UserGroupMbrInfo> userGroupMbrInfoList = iFamilyUserGroupMbrInfo.qryShortProcessList(mapOne);

            return userGroupMbrInfoList;
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询短流程订单失败" + e.getMessage());
        }

    }

    /**
     * 成员删除
     *
     * @param map
     * @return
     */
    @Override
    public ReturnDto drop(Map<String, Object> map) {

        ReturnDto returnDto;

        try {
            //获取memberId
            String memberId = (String) map.get("memberId");

            if (StringUtil.isEmptyOrNull(memberId)) {
                throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "参数不能为空");
            }

            // 1.成员关系删除
            UserGroupMbrInfo groupMbrInfo = iFamilyUserGroupMbrInfo.query(new BigDecimal(memberId));

            if (StringUtil.isEmptyOrNull(groupMbrInfo.getMemberId())) {
                throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "未找到成员关系信息");
            }

            ReturnDto mbrResult = iFamilyUserGroupMbrInfo.drop(groupMbrInfo);
            if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(mbrResult.getCode())) {
                returnDto = new ReturnDto();
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage(mbrResult.getMessage());
                return returnDto;
            }

            // 2.成员属性删除
            List<UserGroupMbrAttrInfo> attrInfoList = iFamilyUserGroupMbrAttrInfo.qryUserGroupMbrAttrInfoList(map);

            if (!StringUtil.isEmptyOrNull(attrInfoList)) {
                for (UserGroupMbrAttrInfo temp : attrInfoList) {
                    UserGroupMbrAttrInfo attrInfoDto = new UserGroupMbrAttrInfo();
                    attrInfoDto.setMemberId(temp.getMemberId());
                    attrInfoDto.setAttrId(temp.getAttrId());
                    attrInfoDto.setAttrNo(temp.getAttrNo());
                    attrInfoDto.setEffDate(temp.getEffDate());
                    attrInfoDto.setOpTime(temp.getOpTime());
                    ReturnDto attrResult = iFamilyUserGroupMbrAttrInfo.drop(attrInfoDto);
                    if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(attrResult.getCode())) {
                        returnDto = new ReturnDto();
                        returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                        returnDto.setMessage(attrResult.getMessage());
                        return returnDto;
                    }
                }
            }

            // 3.成员订购实例关系删除
            List<UserPrcMbrInsInfo> insInfoList = iFamilyUserPrcMbrInsInfo.qryUserPrcMbrInsInfoList(map);

            if (!StringUtil.isEmptyOrNull(insInfoList)) {
                for (UserPrcMbrInsInfo temp : insInfoList) {
                    UserPrcMbrInsInfo insInfoDto = new UserPrcMbrInsInfo();
                    insInfoDto.setMemberId(temp.getMemberId());
                    insInfoDto.setProdPrcInsId(temp.getProdPrcInsId());
                    insInfoDto.setOpTime(temp.getOpTime());
                    ReturnDto insResult = iFamilyUserPrcMbrInsInfo.drop(insInfoDto);
                    if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(insResult.getCode())) {
                        returnDto = new ReturnDto();
                        returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                        returnDto.setMessage(insResult.getMessage());
                        return returnDto;
                    }
                }
            }

            returnDto = new ReturnDto();
            returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
            return returnDto;

        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), e.getMessage());
        }
    }

    /**
     * 成员资费变更
     *
     * @param map
     * @return ReturnDto
     */
    @Override
    public ReturnDto updateMbrPrcIns(Map<String, Object> map) {
        ReturnDto returnDto = new ReturnDto();

        try {
            OprInfo oprInfo = (OprInfo) map.get("oprInfo");
            String createTime = oprInfo.getCreateTime();
            String loginNo = oprInfo.getLoginNo();
            String outAccept = oprInfo.getOutAccept();
            String opNote = oprInfo.getOpNote();
            String opCode = oprInfo.getOpCode();
            String loginAccept = oprInfo.getLoginAccept();
            String systemNote = oprInfo.getSystemNote();

            FamilyMbrPrcInsInDto familyMbrPrcInsInDto = (FamilyMbrPrcInsInDto) map.get("busiInfo");

            Map<String, Object> userGroupMap = new HashMap<>();
            userGroupMap.put("objectId", familyMbrPrcInsInDto.getIdNo());
            userGroupMap.put("groupId", familyMbrPrcInsInDto.getGroupId());

            List<UserGroupMbrInfo> userGrouplist = iFamilyUserGroupMbrInfo.qryUserGroupMbrInfoList(userGroupMap);

            if (userGrouplist.size() == 0 || userGrouplist == null) {
                returnDto.setCode("-9999");
                returnDto.setMessage("该成员所在群不存在");
                return returnDto;
            }

            if (!familyMbrPrcInsInDto.getMbrPrcInsInfoList().isEmpty()) {
                List<FamilyMbrPrcInsInDto.MbrPrcInsInfo> mbrPrcInsInfoList = familyMbrPrcInsInDto.getMbrPrcInsInfoList();

                Map<String, Object> memberMap = new HashMap<>();
                memberMap.put("memberId", familyMbrPrcInsInDto.getMemberId());

                List<UserPrcMbrInsInfo> memberList = iFamilyUserPrcMbrInsInfo.qryUserPrcMbrInsInfoList(memberMap);

                List<BigDecimal> listOriginal = new ArrayList<BigDecimal>();
                List<BigDecimal> listNow = new ArrayList<BigDecimal>();

                for (UserPrcMbrInsInfo userPrcMbrInsInfo : memberList) {
                    listOriginal.add(userPrcMbrInsInfo.getProdPrcInsId());
                }

                for (FamilyMbrPrcInsInDto.MbrPrcInsInfo mbrPrcInsInfo : mbrPrcInsInfoList) {
                    listNow.add(new BigDecimal(mbrPrcInsInfo.getProdprcinsId()));
                }

                if (memberList.size() > mbrPrcInsInfoList.size()) {
                    List<BigDecimal> list = new ArrayList<BigDecimal>(listOriginal);
                    list.removeAll(listNow);

                    for (BigDecimal bigDecimal : list) {
                        UserPrcMbrInsInfo userPrcMbrInsInfo = new UserPrcMbrInsInfo();
                        userPrcMbrInsInfo.setMemberId(new BigDecimal(familyMbrPrcInsInDto.getMemberId()));
                        userPrcMbrInsInfo.setProdPrcInsId(bigDecimal);

                        returnDto = iFamilyUserPrcMbrInsInfo.drop(userPrcMbrInsInfo);

                        if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                            return returnDto;
                        }
                    }

                    listOriginal.removeAll(list);
                    listNow.removeAll(listOriginal);

                    for (BigDecimal bigDecimal : listNow) {
                        UserPrcMbrInsInfo userPrcMbrInsInfo = new UserPrcMbrInsInfo();

                        userPrcMbrInsInfo.setMemberId(new BigDecimal(familyMbrPrcInsInDto.getMemberId()));
                        userPrcMbrInsInfo.setIdNo(Long.parseLong(familyMbrPrcInsInDto.getIdNo()));
                        userPrcMbrInsInfo.setProdPrcInsId(bigDecimal);
                        for (FamilyMbrPrcInsInDto.MbrPrcInsInfo mbrPrcInsInfo : mbrPrcInsInfoList) {
                            if (bigDecimal.equals(new BigDecimal(mbrPrcInsInfo.getProdprcinsId()))) {
                                userPrcMbrInsInfo.setExpDate(DateUtil.toDate(mbrPrcInsInfo.getExpDate(), DateConst.DATE_MODEL_8));
                            }
                        }
                        userPrcMbrInsInfo.setOpCode(opCode);
                        userPrcMbrInsInfo.setOpNote(opNote);
                        userPrcMbrInsInfo.setLoginNo(loginNo);
                        userPrcMbrInsInfo.setOutAccept(outAccept);
                        userPrcMbrInsInfo.setSystemNote(systemNote);
                        userPrcMbrInsInfo.setState(StateEnum.VAL_A.getValue());
                        userPrcMbrInsInfo.setLoginAccept(Long.parseLong(loginAccept));
                        userPrcMbrInsInfo.setOpTime(DateUtil.toDate(createTime, DateConst.DATE_MODEL_8));
                        userPrcMbrInsInfo.setStateDate(DateUtil.toDate(createTime, DateConst.DATE_MODEL_8));

                        returnDto = iFamilyUserPrcMbrInsInfo.create(userPrcMbrInsInfo);

                        if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                            return returnDto;
                        }
                    }
                } else {
                    List<BigDecimal> list = new ArrayList<BigDecimal>(listNow);
                    list.removeAll(listOriginal);

                    for (BigDecimal bigDecimal : list) {
                        UserPrcMbrInsInfo userPrcMbrInsInfo = new UserPrcMbrInsInfo();

                        userPrcMbrInsInfo.setMemberId(new BigDecimal(familyMbrPrcInsInDto.getMemberId()));
                        userPrcMbrInsInfo.setProdPrcInsId(bigDecimal);
                        userPrcMbrInsInfo.setIdNo(Long.parseLong(familyMbrPrcInsInDto.getIdNo()));
                        for (FamilyMbrPrcInsInDto.MbrPrcInsInfo mbrPrcInsInfo : mbrPrcInsInfoList) {
                            if (bigDecimal.equals(new BigDecimal(mbrPrcInsInfo.getProdprcinsId()))) {
                                userPrcMbrInsInfo.setExpDate(DateUtil.toDate(mbrPrcInsInfo.getExpDate(), DateConst.DATE_MODEL_8));
                            }
                        }
                        userPrcMbrInsInfo.setOpCode(opCode);
                        userPrcMbrInsInfo.setOpNote(opNote);
                        userPrcMbrInsInfo.setOutAccept(outAccept);
                        userPrcMbrInsInfo.setLoginNo(loginNo);
                        userPrcMbrInsInfo.setSystemNote(systemNote);
                        userPrcMbrInsInfo.setLoginAccept(Long.parseLong(loginAccept));
                        userPrcMbrInsInfo.setState(StateEnum.VAL_A.getValue());
                        userPrcMbrInsInfo.setOpTime(DateUtil.toDate(createTime, DateConst.DATE_MODEL_8));
                        userPrcMbrInsInfo.setStateDate(DateUtil.toDate(createTime, DateConst.DATE_MODEL_8));

                        returnDto = iFamilyUserPrcMbrInsInfo.create(userPrcMbrInsInfo);

                        if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                            return returnDto;
                        }
                    }

                    listNow.removeAll(list);
                    listOriginal.removeAll(listNow);

                    for (BigDecimal bigDecimal : listOriginal) {
                        UserPrcMbrInsInfo userPrcMbrInsInfo = new UserPrcMbrInsInfo();

                        userPrcMbrInsInfo.setProdPrcInsId(bigDecimal);
                        userPrcMbrInsInfo.setMemberId(new BigDecimal(familyMbrPrcInsInDto.getMemberId()));

                        returnDto = iFamilyUserPrcMbrInsInfo.drop(userPrcMbrInsInfo);

                        if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                            return returnDto;
                        }
                    }

                }
            }
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "成员资费变更失败" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage(returnDto.getMessage());
        return returnDto;
    }
}
