package com.sitech.family.custservice.daoimpl;

import com.sitech.family.common.constants.FinishFlagEnum;
import com.sitech.family.common.constants.StateEnum;
import com.sitech.family.common.constants.UpdateTypeEnum;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.base.util.DateConst;
import com.sitech.family.custservice.daoimpl.user.IUserGroupMbr;
import com.sitech.family.custservice.daoimpl.user.IUserGroupMbrAttr;
import com.sitech.family.custservice.dto.mapperdto.UserGroupMbr;
import com.sitech.family.custservice.dto.mapperdto.UserGroupMbrAttr;
import com.sitech.family.dto.UpdateOprInfo;
import com.sitech.family.dao.usergroup.IUserGroupMbrAttrInfoDao;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.usergroup.UserGroupMbrAttrInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.DateUtil;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * 家庭群成员属性
 *
 * @author shirley
 * @date created in 2018/12/17
 */
@Component
public class UserGroupMbrAttrInfoDaoImpl implements IUserGroupMbrAttrInfoDao {

    /**
     * UserGroupMbrAttr
     */
    @Autowired
    private IUserGroupMbrAttr userGroupMbrAttrImpl;

    @Autowired
    private IUserGroupMbr iUserGroupMbr;

    @Override
    public ReturnDto create(UserGroupMbrAttrInfo userGroupMbrAttrInfoDto) {
        if (StringUtil.isEmptyOrNull(userGroupMbrAttrInfoDto)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }
        ReturnDto returnDto = new ReturnDto();
        try {
            UserGroupMbrAttr userGroupMbrAttr = new UserGroupMbrAttr();
            userGroupMbrAttr.setMemberId(userGroupMbrAttrInfoDto.getMemberId());
            userGroupMbrAttr.setAttrId(userGroupMbrAttrInfoDto.getAttrId());
            userGroupMbrAttr.setAttrNo(userGroupMbrAttrInfoDto.getAttrNo());
            userGroupMbrAttr.setAttrValue(userGroupMbrAttrInfoDto.getAttrValue());
            userGroupMbrAttr.setEffDate(userGroupMbrAttrInfoDto.getEffDate());
            userGroupMbrAttr.setExpDate(userGroupMbrAttrInfoDto.getExpDate());
            userGroupMbrAttr.setGrpNo(userGroupMbrAttrInfoDto.getGrpNo());
            userGroupMbrAttr.setLoginAccept(userGroupMbrAttrInfoDto.getLoginAccept());
            userGroupMbrAttr.setLoginNo(userGroupMbrAttrInfoDto.getLoginNo());
            userGroupMbrAttr.setOpCode(userGroupMbrAttrInfoDto.getOpCode());
            userGroupMbrAttr.setOpTime(userGroupMbrAttrInfoDto.getOpTime());
            userGroupMbrAttr.setState(userGroupMbrAttrInfoDto.getState());
            userGroupMbrAttr.setStateDate(userGroupMbrAttrInfoDto.getStateDate());

            userGroupMbrAttr.setUpdateType(UpdateTypeEnum.VAL_U.getValue());
            userGroupMbrAttr.setUpdateAccept(new Random().nextLong());
            userGroupMbrAttr.setUpdateCode("1");
            userGroupMbrAttr.setUpdateDate(1);
            userGroupMbrAttr.setUpdateLogin("1");
            userGroupMbrAttr.setUpdateTime(userGroupMbrAttrInfoDto.getOpTime());

            if ("A".equals(userGroupMbrAttrInfoDto.getState())) {
                userGroupMbrAttr.setFinishFlag(FinishFlagEnum.VAL_Y.getValue());
            } else {
                userGroupMbrAttr.setFinishFlag(FinishFlagEnum.VAL_N.getValue());
            }

            userGroupMbrAttrImpl.create(userGroupMbrAttr);

        } catch (Exception e) {
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.getMessage());
            return returnDto;
        }
        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    @Override
    public ReturnDto modify(UserGroupMbrAttrInfo userGroupMbrAttrInfoDto) {
        if (StringUtil.isEmptyOrNull(userGroupMbrAttrInfoDto)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }
        ReturnDto returnDto = new ReturnDto();
        try {
            UserGroupMbrAttr userGroupMbrAttr = new UserGroupMbrAttr();
            userGroupMbrAttr.setMemberId(userGroupMbrAttrInfoDto.getMemberId());
            userGroupMbrAttr.setAttrId(userGroupMbrAttrInfoDto.getAttrId());
            userGroupMbrAttr.setAttrNo(userGroupMbrAttrInfoDto.getAttrNo());
            userGroupMbrAttr.setAttrValue(userGroupMbrAttrInfoDto.getAttrValue());
            userGroupMbrAttr.setEffDate(userGroupMbrAttrInfoDto.getEffDate());
            userGroupMbrAttr.setExpDate(userGroupMbrAttrInfoDto.getExpDate());
            userGroupMbrAttr.setGrpNo(userGroupMbrAttrInfoDto.getGrpNo());
            userGroupMbrAttr.setLoginAccept(userGroupMbrAttrInfoDto.getLoginAccept());
            userGroupMbrAttr.setLoginNo(userGroupMbrAttrInfoDto.getLoginNo());
            userGroupMbrAttr.setOpCode(userGroupMbrAttrInfoDto.getOpCode());
            userGroupMbrAttr.setOpTime(userGroupMbrAttrInfoDto.getOpTime());
            userGroupMbrAttr.setState(userGroupMbrAttrInfoDto.getState());
            userGroupMbrAttr.setStateDate(userGroupMbrAttrInfoDto.getStateDate());
            userGroupMbrAttr.setUpdateType(UpdateTypeEnum.VAL_U.getValue());
            userGroupMbrAttr.setUpdateAccept(new Random().nextLong());
            userGroupMbrAttr.setUpdateCode("1");
            userGroupMbrAttr.setUpdateDate(1);
            userGroupMbrAttr.setUpdateLogin("1");
            userGroupMbrAttr.setUpdateTime(userGroupMbrAttrInfoDto.getOpTime());

            if ("A".equals(userGroupMbrAttrInfoDto.getState())) {
                userGroupMbrAttr.setFinishFlag(FinishFlagEnum.VAL_Y.getValue());
            } else {
                userGroupMbrAttr.setFinishFlag(FinishFlagEnum.VAL_N.getValue());
            }

            userGroupMbrAttrImpl.modify(userGroupMbrAttr);

        } catch (Exception e) {
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.getMessage());
            return returnDto;
        }
        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    @Override
    public ReturnDto drop(UserGroupMbrAttrInfo userGroupMbrAttrInfoDto) {
        if (StringUtil.isEmptyOrNull(userGroupMbrAttrInfoDto)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }
        ReturnDto returnDto = new ReturnDto();
        try {
            UserGroupMbrAttr userGroupMbrAttr = new UserGroupMbrAttr();
            userGroupMbrAttr.setMemberId(userGroupMbrAttrInfoDto.getMemberId());
            userGroupMbrAttr.setAttrId(userGroupMbrAttrInfoDto.getAttrId());
            userGroupMbrAttr.setAttrNo(userGroupMbrAttrInfoDto.getAttrNo());
            userGroupMbrAttr.setEffDate(userGroupMbrAttrInfoDto.getEffDate());
            userGroupMbrAttr.setUpdateType(UpdateTypeEnum.VAL_D.getValue());
            userGroupMbrAttr.setUpdateAccept(new Random().nextLong());
            userGroupMbrAttr.setUpdateCode("1");
            userGroupMbrAttr.setUpdateDate(1);
            userGroupMbrAttr.setUpdateLogin("1");
            userGroupMbrAttr.setUpdateTime(userGroupMbrAttrInfoDto.getOpTime());

            userGroupMbrAttrImpl.drop(userGroupMbrAttr);
        } catch (Exception e) {
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.getMessage());
            return returnDto;
        }
        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    @Override
    public UserGroupMbrAttrInfo query(BigDecimal memberId, String attrId, String attrNo, Date effDate) {

        if (StringUtil.isEmptyOrNull(memberId)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }
        if (StringUtil.isEmptyOrNull(attrId)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }
        if (StringUtil.isEmptyOrNull(attrNo)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }
        if (StringUtil.isEmptyOrNull(effDate)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }

        try {
            UserGroupMbrAttr userGroupMbrAttrTemp = new UserGroupMbrAttr();
            userGroupMbrAttrTemp.setMemberId(memberId);
            userGroupMbrAttrTemp.setAttrId(attrId);
            userGroupMbrAttrTemp.setAttrNo(attrNo);
            userGroupMbrAttrTemp.setEffDate(effDate);
            UserGroupMbrAttr userGroupMbrAttr = userGroupMbrAttrImpl.query(memberId, attrId, effDate, attrNo);

            if (StringUtil.isEmptyOrNull(userGroupMbrAttr)) {
                return new UserGroupMbrAttrInfo();
            }

            UserGroupMbrAttrInfo userGroupMbrAttrInfo = new UserGroupMbrAttrInfo();
            userGroupMbrAttrInfo.setAttrId(userGroupMbrAttr.getAttrId());
            userGroupMbrAttrInfo.setAttrNo(userGroupMbrAttr.getAttrNo());
            userGroupMbrAttrInfo.setAttrValue(userGroupMbrAttr.getAttrValue());
            userGroupMbrAttrInfo.setEffDate(userGroupMbrAttr.getEffDate());
            userGroupMbrAttrInfo.setExpDate(userGroupMbrAttr.getExpDate());
            userGroupMbrAttrInfo.setGrpNo(userGroupMbrAttr.getGrpNo());
            userGroupMbrAttrInfo.setLoginAccept(userGroupMbrAttr.getLoginAccept());
            userGroupMbrAttrInfo.setLoginNo(userGroupMbrAttr.getLoginNo());
            userGroupMbrAttrInfo.setMemberId(userGroupMbrAttr.getMemberId());
            userGroupMbrAttrInfo.setOpCode(userGroupMbrAttr.getOpCode());
            userGroupMbrAttrInfo.setOpTime(userGroupMbrAttr.getOpTime());
            userGroupMbrAttrInfo.setState(userGroupMbrAttr.getState());
            userGroupMbrAttrInfo.setStateDate(userGroupMbrAttr.getStateDate());
            userGroupMbrAttrInfo.setOpNote("1");
            userGroupMbrAttrInfo.setOutAccept("1");
            userGroupMbrAttrInfo.setSystemNote("1");

            return userGroupMbrAttrInfo;
        } catch (Exception e) {
            return new UserGroupMbrAttrInfo();
        }
    }

    @Override
    public List<UserGroupMbrAttrInfo> qryUserGroupMbrAttrInfoList(Map map) {

        if (map.isEmpty()) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "处理失败", "参数对象不存在或为空!");
        }

        try {
            //条件查询成员属性集
            List<UserGroupMbrAttr> userGroupMbrAttrList = userGroupMbrAttrImpl.qryUserGroupMbrAttrList(map);

            if (userGroupMbrAttrList.size() > 0) {

                List<UserGroupMbrAttrInfo> list = new ArrayList<>();
                for (UserGroupMbrAttr temp : userGroupMbrAttrList) {
                    UserGroupMbrAttrInfo mbrAttrInfo = new UserGroupMbrAttrInfo();
                    mbrAttrInfo.setAttrId(temp.getAttrId());
                    mbrAttrInfo.setAttrNo(temp.getAttrNo());
                    mbrAttrInfo.setAttrValue(temp.getAttrValue());
                    mbrAttrInfo.setEffDate(temp.getEffDate());
                    mbrAttrInfo.setExpDate(temp.getExpDate());
                    mbrAttrInfo.setGrpNo(temp.getGrpNo());
                    mbrAttrInfo.setLoginAccept(temp.getLoginAccept());
                    mbrAttrInfo.setLoginNo(temp.getLoginNo());
                    mbrAttrInfo.setMemberId(temp.getMemberId());
                    mbrAttrInfo.setOpCode(temp.getOpCode());
                    mbrAttrInfo.setOpTime(temp.getOpTime());
                    mbrAttrInfo.setState(temp.getState());
                    mbrAttrInfo.setStateDate(temp.getStateDate());
                    mbrAttrInfo.setOpNote("1");
                    mbrAttrInfo.setOutAccept("1");
                    mbrAttrInfo.setSystemNote("1");
                    list.add(mbrAttrInfo);
                }
                return list;
            }
            return null;
        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), e.getMessage());
        }
    }

    /**
     * 根据idNo更新状态
     *
     * @param idNo
     * @return
     */
    @Override
    public ReturnDto updateFinishState(UpdateOprInfo updateOprInfo, String idNo) {
        ReturnDto returnDto = new ReturnDto();

        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("objectId", idNo);
            List<UserGroupMbr> userGroupMbrList = iUserGroupMbr.qryUserGroupMbrList(map);

            if (!userGroupMbrList.isEmpty()) {
                for (UserGroupMbr userGroupMbr : userGroupMbrList) {
                    UserGroupMbrAttr userGroupMbrAttr = new UserGroupMbrAttr();
                    userGroupMbrAttr.setFinishFlag(FinishFlagEnum.VAL_Y.getValue());
                    userGroupMbrAttr.setState(StateEnum.VAL_A.getValue());
                    userGroupMbrAttr.setStateDate(DateUtil.toDate(updateOprInfo.getCreateTime(), DateConst.DATE_MODEL_8));
                    userGroupMbrAttr.setMemberId(userGroupMbr.getMemberId());
                    userGroupMbrAttr.setOpTime(DateUtil.toDate(updateOprInfo.getCreateTime(), DateConst.DATE_MODEL_8));
                    userGroupMbrAttr.setLoginNo(updateOprInfo.getLoginNo());
                    userGroupMbrAttr.setOpCode(updateOprInfo.getOpCode());
                    userGroupMbrAttr.setLoginAccept(Long.valueOf(updateOprInfo.getLoginAccept()));

                    returnDto = userGroupMbrAttrImpl.updateFinishState(userGroupMbrAttr);
                }
            }
        } catch (Exception e) {
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.toString());
            return returnDto;
        }
        returnDto.setCode(returnDto.getCode());
        returnDto.setMessage(returnDto.getMessage());
        return returnDto;
    }
}
