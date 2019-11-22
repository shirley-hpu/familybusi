package com.sitech.family.custservice.daoimpl;

import com.sitech.family.common.constants.StateEnum;
import com.sitech.family.common.constants.UpdateTypeEnum;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.base.util.DateConst;
import com.sitech.family.custservice.daoimpl.user.IUserGroupMbr;
import com.sitech.family.custservice.daoimpl.user.IUserPrcMbrIns;
import com.sitech.family.custservice.dto.mapperdto.UserGroupMbr;
import com.sitech.family.custservice.dto.mapperdto.UserPrcMbrIns;
import com.sitech.family.dto.UpdateOprInfo;
import com.sitech.family.dao.usergroup.IUserPrcMbrInsInfoDao;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.usergroup.UserPrcMbrInsInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.DateUtil;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * 家庭订购实例与成员实例关系
 *
 * @author shirley
 * @date created in 2018/12/17
 */
@Component
public class UserPrcMbrInsInfoDaoImpl implements IUserPrcMbrInsInfoDao {

    /**
     * UserPrcMbrIns
     */
    @Autowired
    private IUserPrcMbrIns userPrcMbrInsImpl;

    @Autowired
    private IUserGroupMbr iUserGroupMbr;

    @Override
    public ReturnDto create(UserPrcMbrInsInfo userPrcMbrInsInfoDto) {
        if (StringUtil.isEmptyOrNull(userPrcMbrInsInfoDto)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }
        ReturnDto returnDto = new ReturnDto();
        try {
            UserPrcMbrIns userPrcMbrIns = new UserPrcMbrIns();
            userPrcMbrIns.setMemberId(userPrcMbrInsInfoDto.getMemberId());
            userPrcMbrIns.setProdPrcInsId(userPrcMbrInsInfoDto.getProdPrcInsId());
            userPrcMbrIns.setIdNo(userPrcMbrInsInfoDto.getIdNo());
            userPrcMbrIns.setExpDate(userPrcMbrInsInfoDto.getExpDate());
            userPrcMbrIns.setLoginAccept(userPrcMbrInsInfoDto.getLoginAccept());
            userPrcMbrIns.setLoginNo(userPrcMbrInsInfoDto.getLoginNo());
            userPrcMbrIns.setOpCode(userPrcMbrInsInfoDto.getOpCode());
            userPrcMbrIns.setOpTime(userPrcMbrInsInfoDto.getOpTime());
            userPrcMbrIns.setState(userPrcMbrInsInfoDto.getState());
            userPrcMbrIns.setStateDate(userPrcMbrInsInfoDto.getStateDate());
            userPrcMbrIns.setUpdateAccept(new Random().nextLong());
            userPrcMbrIns.setUpdateCode("1");
            userPrcMbrIns.setUpdateDate(1);
            userPrcMbrIns.setUpdateLogin("1");
            userPrcMbrIns.setUpdateTime(userPrcMbrInsInfoDto.getOpTime());
            userPrcMbrIns.setUpdateType(UpdateTypeEnum.VAL_A.getValue());

            userPrcMbrInsImpl.create(userPrcMbrIns);
        } catch (Exception e) {
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.getMessage());
            return returnDto;
        }
        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    @Override
    public ReturnDto modify(UserPrcMbrInsInfo userPrcMbrInsInfoDto) {
        if (StringUtil.isEmptyOrNull(userPrcMbrInsInfoDto)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }
        ReturnDto returnDto = new ReturnDto();
        try {
            UserPrcMbrIns userPrcMbrIns = new UserPrcMbrIns();
            userPrcMbrIns.setMemberId(userPrcMbrInsInfoDto.getMemberId());
            userPrcMbrIns.setProdPrcInsId(userPrcMbrInsInfoDto.getProdPrcInsId());
            userPrcMbrIns.setIdNo(userPrcMbrInsInfoDto.getIdNo());
            userPrcMbrIns.setExpDate(userPrcMbrInsInfoDto.getExpDate());
            userPrcMbrIns.setLoginAccept(userPrcMbrInsInfoDto.getLoginAccept());
            userPrcMbrIns.setLoginNo(userPrcMbrInsInfoDto.getLoginNo());
            userPrcMbrIns.setOpCode(userPrcMbrInsInfoDto.getOpCode());
            userPrcMbrIns.setOpTime(userPrcMbrInsInfoDto.getOpTime());
            userPrcMbrIns.setState(userPrcMbrInsInfoDto.getState());
            userPrcMbrIns.setStateDate(userPrcMbrInsInfoDto.getStateDate());
            userPrcMbrIns.setUpdateAccept(new Random().nextLong());
            userPrcMbrIns.setUpdateCode("1");
            userPrcMbrIns.setUpdateDate(1);
            userPrcMbrIns.setUpdateLogin("1");
            userPrcMbrIns.setUpdateTime(userPrcMbrInsInfoDto.getOpTime());
            userPrcMbrIns.setUpdateType(UpdateTypeEnum.VAL_U.getValue());

            userPrcMbrInsImpl.modify(userPrcMbrIns);
        } catch (Exception e) {
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.getMessage());
            return returnDto;
        }
        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    @Override
    public ReturnDto drop(UserPrcMbrInsInfo userPrcMbrInsInfoDto) {
        if (StringUtil.isEmptyOrNull(userPrcMbrInsInfoDto)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }
        ReturnDto returnDto = new ReturnDto();
        try {
            UserPrcMbrIns userPrcMbrIns = new UserPrcMbrIns();
            userPrcMbrIns.setMemberId(userPrcMbrInsInfoDto.getMemberId());
            userPrcMbrIns.setProdPrcInsId(userPrcMbrInsInfoDto.getProdPrcInsId());
            userPrcMbrIns.setUpdateAccept(new Random().nextLong());
            userPrcMbrIns.setUpdateCode("1");
            userPrcMbrIns.setUpdateDate(1);
            userPrcMbrIns.setUpdateLogin("1");
            userPrcMbrIns.setUpdateTime(userPrcMbrInsInfoDto.getOpTime());
            userPrcMbrIns.setUpdateType(UpdateTypeEnum.VAL_D.getValue());

            userPrcMbrInsImpl.drop(userPrcMbrIns);

        } catch (Exception e) {
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.getMessage());
            return returnDto;
        }
        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    @Override
    public UserPrcMbrInsInfo query(BigDecimal memberId, BigDecimal prodPrcInsId) {

        if (StringUtil.isEmptyOrNull(memberId) || StringUtil.isEmptyOrNull(prodPrcInsId)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }

        try {
            UserPrcMbrIns userPrcMbrIns = userPrcMbrInsImpl.query(memberId, prodPrcInsId);

            if (StringUtil.isEmptyOrNull(userPrcMbrIns)) {
                return new UserPrcMbrInsInfo();
            }

            UserPrcMbrInsInfo userPrcMbrInsInfo = new UserPrcMbrInsInfo();
            userPrcMbrInsInfo.setExpDate(userPrcMbrIns.getExpDate());
            userPrcMbrInsInfo.setIdNo(userPrcMbrIns.getIdNo());
            userPrcMbrInsInfo.setLoginAccept(userPrcMbrIns.getLoginAccept());
            userPrcMbrInsInfo.setLoginNo(userPrcMbrIns.getLoginNo());
            userPrcMbrInsInfo.setMemberId(userPrcMbrIns.getMemberId());
            userPrcMbrInsInfo.setOpCode(userPrcMbrIns.getOpCode());
            userPrcMbrInsInfo.setOpTime(userPrcMbrIns.getOpTime());
            userPrcMbrInsInfo.setProdPrcInsId(userPrcMbrIns.getProdPrcInsId());
            userPrcMbrInsInfo.setState(userPrcMbrIns.getState());
            userPrcMbrInsInfo.setStateDate(userPrcMbrIns.getStateDate());
            userPrcMbrInsInfo.setOpNote("1");
            userPrcMbrInsInfo.setOutAccept("1");
            userPrcMbrInsInfo.setSystemNote("1");

            return userPrcMbrInsInfo;
        } catch (Exception e) {
            return new UserPrcMbrInsInfo();
        }
    }

    @Override
    public List<UserPrcMbrInsInfo> qryUserPrcMbrInsInfoList(Map map) {

        if (map.isEmpty()) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "处理失败", "参数对象不存在或为空!");
        }

        try {
            //
            List<UserPrcMbrIns> userPrcMbrInsList = userPrcMbrInsImpl.qryUserPrcMbrInsList(map);

            if (!StringUtil.isEmptyOrNull(userPrcMbrInsList)) {

                List<UserPrcMbrInsInfo> list = new ArrayList<>();
                for (UserPrcMbrIns temp : userPrcMbrInsList) {
                    UserPrcMbrInsInfo mbrInsInfo = new UserPrcMbrInsInfo();
                    mbrInsInfo.setExpDate(temp.getExpDate());
                    mbrInsInfo.setIdNo(temp.getIdNo());
                    mbrInsInfo.setLoginAccept(temp.getLoginAccept());
                    mbrInsInfo.setLoginNo(temp.getLoginNo());
                    mbrInsInfo.setMemberId(temp.getMemberId());
                    mbrInsInfo.setOpCode(temp.getOpCode());
                    mbrInsInfo.setOpTime(temp.getOpTime());
                    mbrInsInfo.setProdPrcInsId(temp.getProdPrcInsId());
                    mbrInsInfo.setState(temp.getState());
                    mbrInsInfo.setStateDate(temp.getStateDate());
                    mbrInsInfo.setOpNote("1");
                    mbrInsInfo.setOutAccept("1");
                    mbrInsInfo.setSystemNote("1");
                    list.add(mbrInsInfo);
                }
                return list;
            }
            return new ArrayList<>();
        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "处理失败", e.getMessage());
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

            if (userGroupMbrList != null) {
                for (UserGroupMbr userGroupMbr : userGroupMbrList) {
                    UserPrcMbrIns userPrcMbrIns = new UserPrcMbrIns();
                    userPrcMbrIns.setState(StateEnum.VAL_A.getValue());
                    userPrcMbrIns.setStateDate(DateUtil.toDate(updateOprInfo.getCreateTime(), DateConst.DATE_MODEL_8));
                    userPrcMbrIns.setMemberId(userGroupMbr.getMemberId());
                    userPrcMbrIns.setOpTime(DateUtil.toDate(updateOprInfo.getCreateTime(), DateConst.DATE_MODEL_8));
                    userPrcMbrIns.setLoginNo(updateOprInfo.getLoginNo());
                    userPrcMbrIns.setOpCode(updateOprInfo.getOpCode());
                    userPrcMbrIns.setLoginAccept(Long.valueOf(updateOprInfo.getLoginAccept()));

                    returnDto = userPrcMbrInsImpl.updateFinishState(userPrcMbrIns);
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
