package com.sitech.family.custservice.daoimpl.user.impl;

import com.sitech.family.common.constants.StateEnum;
import com.sitech.family.common.constants.UpdateTypeEnum;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.daoimpl.user.IUserPrcMbrIns;
import com.sitech.family.custservice.dto.mapperdto.UserPrcMbrIns;
import com.sitech.family.custservice.mapper.UserPrcMbrInsMapper;
import com.sitech.family.dto.ReturnDto;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * 家庭订购实例与成员实例关系
 *
 * @author shirley
 * @date created in 2018/12/21
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class UserPrcMbrInsImpl implements IUserPrcMbrIns {

    @Autowired
    private UserPrcMbrInsMapper userPrcMbrInsMapper;

    /**
     * 创建家庭订购实例与成员实例关系
     *
     * @param userPrcMbrIns
     * @return ReturnDto
     */
    @Override
    public ReturnDto create(UserPrcMbrIns userPrcMbrIns) {
        ReturnDto returnDto = new ReturnDto();

        try {
            userPrcMbrInsMapper.insert(userPrcMbrIns);

            userPrcMbrInsMapper.create(userPrcMbrIns);
        } catch (Exception e) {
            throw new BusiException("创建家庭订购实例与成员实例关系失败:" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    /**
     * 删除家庭订购实例与成员实例关系
     *
     * @param userPrcMbrIns
     * @return ReturnDto
     */
    @Override
    public ReturnDto drop(UserPrcMbrIns userPrcMbrIns) {
        ReturnDto returnDto = new ReturnDto();

        try {
            UserPrcMbrIns userPrcMbrInsDrop = userPrcMbrInsMapper.query(userPrcMbrIns.getMemberId(), userPrcMbrIns.getProdPrcInsId());

            if (StringUtil.isEmptyOrNull(userPrcMbrInsDrop)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,删除家庭订购实例与成员实例关系失败");
                return returnDto;
            }

            userPrcMbrInsDrop.setUpdateAccept(userPrcMbrIns.getUpdateAccept());
            userPrcMbrInsDrop.setUpdateType(userPrcMbrIns.getUpdateType());
            userPrcMbrInsDrop.setUpdateTime(userPrcMbrIns.getUpdateTime());
            userPrcMbrInsDrop.setUpdateDate(userPrcMbrIns.getUpdateDate());
            userPrcMbrInsDrop.setUpdateLogin(userPrcMbrIns.getUpdateLogin());
            userPrcMbrInsDrop.setUpdateCode(userPrcMbrIns.getUpdateCode());

            userPrcMbrInsMapper.insert(userPrcMbrInsDrop);

            userPrcMbrInsMapper.drop(userPrcMbrIns.getMemberId(), userPrcMbrIns.getProdPrcInsId());
        } catch (Exception e) {
            throw new BusiException("删除家庭订购实例与成员实例关系失败:" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    /**
     * 更新家庭订购实例与成员实例关系
     *
     * @param userPrcMbrIns
     * @return ReturnDto
     */
    @Override
    public ReturnDto modify(UserPrcMbrIns userPrcMbrIns) {
        ReturnDto returnDto = new ReturnDto();

        try {
            UserPrcMbrIns userPrcMbrInsTemp = userPrcMbrInsMapper.query(userPrcMbrIns.getMemberId(), userPrcMbrIns.getProdPrcInsId());

            if (StringUtil.isEmptyOrNull(userPrcMbrInsTemp)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,更新家庭订购实例与成员实例关系失败");
                return returnDto;
            }

            userPrcMbrInsTemp.setUpdateAccept(userPrcMbrIns.getUpdateAccept());
            userPrcMbrInsTemp.setUpdateType(userPrcMbrIns.getUpdateType());
            userPrcMbrInsTemp.setUpdateTime(userPrcMbrIns.getUpdateTime());
            userPrcMbrInsTemp.setUpdateDate(userPrcMbrIns.getUpdateDate());
            userPrcMbrInsTemp.setUpdateLogin(userPrcMbrIns.getUpdateLogin());
            userPrcMbrInsTemp.setUpdateCode(userPrcMbrIns.getUpdateCode());

            userPrcMbrInsMapper.insert(userPrcMbrInsTemp);

            userPrcMbrInsMapper.modify(userPrcMbrIns);

            userPrcMbrIns.setUpdateType(UpdateTypeEnum.VAL_X.getValue());

            userPrcMbrInsMapper.insert(userPrcMbrIns);
        } catch (Exception e) {
            throw new BusiException("更新家庭订购实例与成员实例关系失败:" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    /**
     * 查询家庭订购实例与成员实例关系
     *
     * @param memberId
     * @param prodPrcInsId
     * @return ReturnDto
     */
    @Override
    public UserPrcMbrIns query(BigDecimal memberId, BigDecimal prodPrcInsId) {
        UserPrcMbrIns userPrcMbrIns = new UserPrcMbrIns();

        try {
            userPrcMbrIns = userPrcMbrInsMapper.query(memberId, prodPrcInsId);
        } catch (Exception e) {
            throw new BusiException("查询家庭订购实例与成员实例关系失败:" + e.getMessage());
        }

        return userPrcMbrIns;
    }

    /**
     * 查询家庭订购实例与成员实例关系
     *
     * @param map
     * @return List<UserPrcMbrIns>
     */
    @Override
    public List<UserPrcMbrIns> qryUserPrcMbrInsList(Map map) {
        List<UserPrcMbrIns> list = new ArrayList<>();

        try {
            list = userPrcMbrInsMapper.qryUserPrcMbrInsList(map);
        } catch (Exception e) {
            throw new BusiException("查询家庭订购实例与成员实例关系失败:" + e.getMessage());
        }

        return list;
    }

    /**
     * 查询历史家庭订购实例与成员实例关系
     *
     * @param map
     * @return List<UserPrcMbrIns>
     */
    @Override
    public List<UserPrcMbrIns> qryUserPrcMbrInsHisList(Map map) {
        List<UserPrcMbrIns> list = new ArrayList<>();

        try {
            list = userPrcMbrInsMapper.qryUserPrcMbrInsHisList(map);
        } catch (Exception e) {
            throw new BusiException("查询历史家庭订购实例与成员实例关系失败:" + e.getMessage());
        }

        return list;
    }

    /**
     * 根据idNo更新状态
     *
     * @param userPrcMbrIns
     * @return
     */
    @Override
    public ReturnDto updateFinishState(UserPrcMbrIns userPrcMbrIns) {
        ReturnDto returnDto = new ReturnDto();

        try {
            Map<String,Object> map = new HashMap<>();
            map.put("memberId",userPrcMbrIns.getMemberId());
            map.put("state", StateEnum.VAL_B.getValue());
            List<UserPrcMbrIns> userPrcMbrInsList = qryUserPrcMbrInsList(map);

            if (userPrcMbrInsList.isEmpty()) {
                returnDto.setMessage("根据传入参数查询无此数据");
                return returnDto;
            }

            userPrcMbrInsMapper.updateFinishState(userPrcMbrIns);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "根据idNo更新状态失败" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("根据idNo更新状态成功");
        return returnDto;
    }
}
