package com.sitech.family.custservice.daoimpl.user.impl;

import com.sitech.family.common.constants.UpdateTypeEnum;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.daoimpl.user.IUserGoodsLmt;
import com.sitech.family.custservice.dto.mapperdto.UserGoodsLmt;
import com.sitech.family.custservice.mapper.UserGoodsLmtMapper;
import com.sitech.family.dto.ReturnDto;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 用户商品受限信息
 *
 * @author shirley
 * @date created in 2018/12/20
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class UserGoodsLmtImpl implements IUserGoodsLmt {

    @Autowired
    private UserGoodsLmtMapper userGoodsLmtMapper;

    /**
     * 创建用户商品受限信息
     *
     * @param userGoodsLmt
     * @return
     */
    @Override
    public ReturnDto create(UserGoodsLmt userGoodsLmt) {
        ReturnDto returnDto = new ReturnDto();

        try {
            userGoodsLmtMapper.insert(userGoodsLmt);

            userGoodsLmtMapper.create(userGoodsLmt);
        } catch (Exception e) {
            throw new BusiException("创建用户商品受限信息失败:" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    /**
     * 删除用户商品受限信息
     *
     * @param userGoodsLmt
     * @return ReturnDto
     */
    @Override
    public ReturnDto drop(UserGoodsLmt userGoodsLmt) {
        ReturnDto returnDto = new ReturnDto();

        try {
            UserGoodsLmt userGoodsLmtQry = userGoodsLmtMapper.query(userGoodsLmt.getLimitinsId());

            if (StringUtil.isEmptyOrNull(userGoodsLmtQry)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,删除用户商品受限信息失败");
                return returnDto;
            }

            userGoodsLmtQry.setUpdateAccept(userGoodsLmt.getUpdateAccept());
            userGoodsLmtQry.setUpdateType(userGoodsLmt.getUpdateType());
            userGoodsLmtQry.setUpdateTime(userGoodsLmt.getUpdateTime());
            userGoodsLmtQry.setUpdateDate(userGoodsLmt.getUpdateDate());
            userGoodsLmtQry.setUpdateLogin(userGoodsLmt.getUpdateLogin());
            userGoodsLmtQry.setUpdateCode(userGoodsLmt.getUpdateCode());

            userGoodsLmtMapper.insert(userGoodsLmtQry);

            userGoodsLmtMapper.drop(userGoodsLmt.getLimitinsId());
        } catch (Exception e) {
            throw new BusiException("删除用户商品受限信息失败:" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    /**
     * 更新用户商品受限信息
     *
     * @param userGoodsLmt
     * @return ReturnDto
     */
    @Override
    public ReturnDto modify(UserGoodsLmt userGoodsLmt) {
        ReturnDto returnDto = new ReturnDto();

        try {
            UserGoodsLmt userGoodsLmtQry = userGoodsLmtMapper.query(userGoodsLmt.getLimitinsId());

            if (StringUtil.isEmptyOrNull(userGoodsLmtQry)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,更新用户商品受限信息失败");
                return returnDto;
            }

            userGoodsLmtQry.setUpdateAccept(userGoodsLmt.getUpdateAccept());
            userGoodsLmtQry.setUpdateType(userGoodsLmt.getUpdateType());
            userGoodsLmtQry.setUpdateTime(userGoodsLmt.getUpdateTime());
            userGoodsLmtQry.setUpdateDate(userGoodsLmt.getUpdateDate());
            userGoodsLmtQry.setUpdateLogin(userGoodsLmt.getUpdateLogin());
            userGoodsLmtQry.setUpdateCode(userGoodsLmt.getUpdateCode());

            userGoodsLmtMapper.insert(userGoodsLmtQry);

            userGoodsLmtMapper.modify(userGoodsLmt);

            userGoodsLmt.setUpdateType(UpdateTypeEnum.VAL_X.getValue());

            userGoodsLmtMapper.insert(userGoodsLmt);
        } catch (Exception e) {
            throw new BusiException("更新用户商品受限信息失败:" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    /**
     * 查询用户商品受限信息
     *
     * @param limitinsId
     * @return UserGoodsLmt
     */
    @Override
    public UserGoodsLmt query(BigDecimal limitinsId) {
        UserGoodsLmt userGoodsLmt = new UserGoodsLmt();

        try {
            userGoodsLmt = userGoodsLmtMapper.query(limitinsId);
        } catch (Exception e) {
            throw new BusiException("查询用户商品受限信息失败:" + e.getMessage());
        }

        return userGoodsLmt;
    }

    /**
     * 查询用户商品受限信息
     *
     * @param map
     * @return List<UserGoodsLmt>
     */
    @Override
    public List<UserGoodsLmt> qryUserGoodsLmtList(Map map) {
        List<UserGoodsLmt> list = new ArrayList<>();

        try {
            list = userGoodsLmtMapper.qryUserGoodsLmtList(map);
        } catch (Exception e) {
            throw new BusiException("查询用户商品受限信息失败:" + e.getMessage());
        }

        return list;
    }

    /**
     * 查询历史用户商品受限信息
     *
     * @param map
     * @return List<UserGoodsLmt>
     */
    @Override
    public List<UserGoodsLmt> qryUserGoodsLmtHisList(Map map) {
        List<UserGoodsLmt> list = new ArrayList<>();

        try {
            list = userGoodsLmtMapper.qryUserGoodsLmtHisList(map);
        } catch (Exception e) {
            throw new BusiException("查询历史用户商品受限信息失败:" + e.getMessage());
        }

        return list;
    }
}
