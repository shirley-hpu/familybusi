package com.sitech.family.custservice.daoimpl.user.impl;

import com.sitech.family.common.constants.FinishFlagEnum;
import com.sitech.family.common.constants.StateEnum;
import com.sitech.family.common.constants.UpdateTypeEnum;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.daoimpl.user.IUserGroupMbrAttr;
import com.sitech.family.custservice.dto.mapperdto.UserGroupMbrAttr;
import com.sitech.family.custservice.mapper.UserGroupMbrAttrMapper;
import com.sitech.family.dto.ReturnDto;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * 群成员属性实例
 *
 * @author shirley
 * @date created in 2018/12/21
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class UserGroupMbrAttrImpl implements IUserGroupMbrAttr {

    @Autowired
    private UserGroupMbrAttrMapper userGroupMbrAttrMapper;

    /**
     * 创建群成员属性实例
     *
     * @param userGroupMbrAttr
     * @return ReturnDto
     */
    @Override
    public ReturnDto create(UserGroupMbrAttr userGroupMbrAttr) {
        ReturnDto returnDto = new ReturnDto();

        try {
            userGroupMbrAttrMapper.insert(userGroupMbrAttr);

            userGroupMbrAttrMapper.create(userGroupMbrAttr);
        } catch (Exception e) {
            throw new BusiException("创建群成员属性实例失败:" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    /**
     * 删除群成员属性实例
     *
     * @param userGroupMbrAttr
     * @return ReturnDto
     */
    @Override
    public ReturnDto drop(UserGroupMbrAttr userGroupMbrAttr) {
        ReturnDto returnDto = new ReturnDto();

        try {
            BigDecimal memberId = userGroupMbrAttr.getMemberId();
            String attrId = userGroupMbrAttr.getAttrId();
            Date effDate = userGroupMbrAttr.getEffDate();
            String attrNo = userGroupMbrAttr.getAttrNo();

            UserGroupMbrAttr userGroupMbrAttrDrop = userGroupMbrAttrMapper.query(memberId, attrId, effDate, attrNo);

            if (StringUtil.isEmptyOrNull(userGroupMbrAttrDrop)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,删除群成员属性实例失败");
                return returnDto;
            }

            userGroupMbrAttrDrop.setUpdateAccept(userGroupMbrAttr.getUpdateAccept());
            userGroupMbrAttrDrop.setUpdateType(userGroupMbrAttr.getUpdateType());
            userGroupMbrAttrDrop.setUpdateTime(userGroupMbrAttr.getUpdateTime());
            userGroupMbrAttrDrop.setUpdateDate(userGroupMbrAttr.getUpdateDate());
            userGroupMbrAttrDrop.setUpdateLogin(userGroupMbrAttr.getUpdateLogin());
            userGroupMbrAttrDrop.setUpdateCode(userGroupMbrAttr.getUpdateCode());

            userGroupMbrAttrMapper.insert(userGroupMbrAttrDrop);

            userGroupMbrAttrMapper.drop(userGroupMbrAttr);
        } catch (Exception e) {
            throw new BusiException("删除群成员属性实例失败:" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    /**
     * 更新群成员属性实例
     *
     * @param userGroupMbrAttr
     * @return ReturnDto
     */
    @Override
    public ReturnDto modify(UserGroupMbrAttr userGroupMbrAttr) {
        ReturnDto returnDto = new ReturnDto();

        try {
            BigDecimal memberId = userGroupMbrAttr.getMemberId();
            String attrId = userGroupMbrAttr.getAttrId();
            Date effDate = userGroupMbrAttr.getEffDate();
            String attrNo = userGroupMbrAttr.getAttrNo();

            UserGroupMbrAttr userGroupMbrAttrTemp = userGroupMbrAttrMapper.query(memberId, attrId, effDate, attrNo);

            if (StringUtil.isEmptyOrNull(userGroupMbrAttrTemp)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,更新群成员属性实例失败");
                return returnDto;
            }

            userGroupMbrAttrTemp.setUpdateAccept(userGroupMbrAttr.getUpdateAccept());
            userGroupMbrAttrTemp.setUpdateType(userGroupMbrAttr.getUpdateType());
            userGroupMbrAttrTemp.setUpdateTime(userGroupMbrAttr.getUpdateTime());
            userGroupMbrAttrTemp.setUpdateDate(userGroupMbrAttr.getUpdateDate());
            userGroupMbrAttrTemp.setUpdateLogin(userGroupMbrAttr.getUpdateLogin());
            userGroupMbrAttrTemp.setUpdateCode(userGroupMbrAttr.getUpdateCode());

            userGroupMbrAttrMapper.insert(userGroupMbrAttrTemp);

            userGroupMbrAttrMapper.modify(userGroupMbrAttr);

            userGroupMbrAttr.setUpdateType(UpdateTypeEnum.VAL_X.getValue());

            userGroupMbrAttrMapper.insert(userGroupMbrAttr);
        } catch (Exception e) {
            throw new BusiException("更新群成员属性实例失败:" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    /**
     * 查询群成员属性实例
     *
     * @param memberId
     * @param attrId
     * @param effDate
     * @param attrNo
     * @return UserGroupMbrAttr
     */
    @Override
    public UserGroupMbrAttr query(BigDecimal memberId, String attrId, Date effDate, String attrNo) {
        UserGroupMbrAttr userGroupMbrAttr = new UserGroupMbrAttr();

        try {
            userGroupMbrAttr = userGroupMbrAttrMapper.query(memberId, attrId, effDate, attrNo);
        } catch (Exception e) {
            throw new BusiException("查询群成员属性实例失败:" + e.getMessage());
        }

        return userGroupMbrAttr;
    }

    /**
     * 查询群成员属性实例
     *
     * @param map
     * @return List<UserGroupMbrAttr>
     */
    @Override
    public List<UserGroupMbrAttr> qryUserGroupMbrAttrList(Map map) {
        List<UserGroupMbrAttr> list = new ArrayList<>();

        try {
            list = userGroupMbrAttrMapper.qryUserGroupMbrAttrList(map);
        } catch (Exception e) {
            throw new BusiException("查询群成员属性实例失败:" + e.getMessage());
        }

        return list;
    }

    /**
     * 查询历史群成员属性实例
     *
     * @param map
     * @return List<UserGroupMbrAttr>
     */
    @Override
    public List<UserGroupMbrAttr> qryUserGroupMbrAttrHisList(Map map) {
        List<UserGroupMbrAttr> list = new ArrayList<>();

        try {
            list = userGroupMbrAttrMapper.qryUserGroupMbrAttrHisList(map);
        } catch (Exception e) {
            throw new BusiException("查询历史群成员属性实例失败:" + e.getMessage());
        }

        return list;
    }

    /**
     * 根据idNo更新状态
     *
     * @param userGroupMbrAttr
     * @return
     */
    @Override
    public ReturnDto updateFinishState(UserGroupMbrAttr userGroupMbrAttr) {
        ReturnDto returnDto = new ReturnDto();

        try {
            Map<String,Object> map = new HashMap<>();
            map.put("memberId",userGroupMbrAttr.getMemberId());
            map.put("finishFlag", FinishFlagEnum.VAL_N.getValue());
            map.put("state", StateEnum.VAL_B.getValue());
            List<UserGroupMbrAttr> userGroupMbrList = userGroupMbrAttrMapper.qryUserGroupMbrAttrList(map);

            if (userGroupMbrList.isEmpty()) {
                returnDto.setMessage("根据传入参数查询无此数据");
                return returnDto;
            }

            userGroupMbrAttrMapper.updateFinishState(userGroupMbrAttr);
        } catch (Exception e) {
            System.out.println(e.toString());
            throw new BusiException(getErrorCode("1000", "15000"), "根据idNo更新状态失败" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("根据idNo更新状态成功");
        return returnDto;
    }
}
