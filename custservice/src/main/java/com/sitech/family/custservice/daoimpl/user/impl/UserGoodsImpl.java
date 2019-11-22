package com.sitech.family.custservice.daoimpl.user.impl;

import com.sitech.family.common.constants.FinishFlagEnum;
import com.sitech.family.common.constants.StateEnum;
import com.sitech.family.common.constants.UpdateTypeEnum;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.daoimpl.user.IUserGoods;
import com.sitech.family.custservice.dto.mapperdto.UserGoods;
import com.sitech.family.custservice.mapper.UserGoodsMapper;
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
 * 用户商品订购实例信息
 *
 * @author shirley
 * @date created in 2018/12/20
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class UserGoodsImpl implements IUserGoods {

    @Autowired
    private UserGoodsMapper userGoodsMapper;

    /**
     * 创建用户商品订购实例信息
     *
     * @param userGoods
     * @return ReturnDto
     */
    @Override
    public ReturnDto create(UserGoods userGoods) {
        ReturnDto returnDto = new ReturnDto();

        try {
            userGoodsMapper.create(userGoods);

            userGoodsMapper.insert(userGoods);
        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    /**
     * 删除用户商品订购实例信息
     *
     * @param userGoods
     * @return ReturnDto
     */
    @Override
    public ReturnDto drop(UserGoods userGoods) {
        ReturnDto returnDto = new ReturnDto();

        try {
            UserGoods userGoodsDrop = userGoodsMapper.query(userGoods.getGoodsinsId());

            if (StringUtil.isEmptyOrNull(userGoodsDrop)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,删除用户商品订购实例信息失败");
                return returnDto;
            }

            userGoodsDrop.setUpdateAccept(userGoods.getUpdateAccept());
            userGoodsDrop.setUpdateType(userGoods.getUpdateType());
            userGoodsDrop.setUpdateTime(userGoods.getUpdateTime());
            userGoodsDrop.setUpdateDate(userGoods.getUpdateDate());
            userGoodsDrop.setUpdateLogin(userGoods.getUpdateLogin());
            userGoodsDrop.setUpdateCode(userGoods.getUpdateCode());

            userGoodsMapper.insert(userGoodsDrop);

            userGoodsMapper.drop(userGoods.getGoodsinsId());
        } catch (Exception e) {
            throw new BusiException("删除用户商品订购实例信息失败:" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    /**
     * 更新用户商品订购实例信息
     *
     * @param userGoods
     * @return ReturnDto
     */
    @Override
    public ReturnDto modify(UserGoods userGoods) {
        ReturnDto returnDto = new ReturnDto();

        try {
            UserGoods userGoodsTemp = userGoodsMapper.query(userGoods.getGoodsinsId());

            if (StringUtil.isEmptyOrNull(userGoodsTemp)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,更新用户商品订购实例信息失败");
                return returnDto;
            }

            userGoodsTemp.setUpdateAccept(userGoods.getUpdateAccept());
            userGoodsTemp.setUpdateType(userGoods.getUpdateType());
            userGoodsTemp.setUpdateTime(userGoods.getUpdateTime());
            userGoodsTemp.setUpdateDate(userGoods.getUpdateDate());
            userGoodsTemp.setUpdateLogin(userGoods.getUpdateLogin());
            userGoodsTemp.setUpdateCode(userGoods.getUpdateCode());

            userGoodsMapper.insert(userGoodsTemp);

            userGoodsMapper.modify(userGoods);

            userGoods.setUpdateType(UpdateTypeEnum.VAL_X.getValue());

            userGoodsMapper.insert(userGoods);
        } catch (Exception e) {
            throw new BusiException("更新用户商品订购实例信息失败:" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    /**
     * 查询用户商品订购实例信息
     *
     * @param goodsinsId
     * @return ReturnDto
     */
    @Override
    public UserGoods query(BigDecimal goodsinsId) {
        UserGoods userGoods = new UserGoods();

        try {
            userGoods = userGoodsMapper.query(goodsinsId);
        } catch (Exception e) {
            throw new BusiException("查询用户商品订购实例信息失败:" + e.getMessage());
        }

        return userGoods;
    }

    /**
     * 查询用户商品订购实例信息
     *
     * @param map
     * @return List<UserGoods>
     */
    @Override
    public List<UserGoods> qryUserGoodsList(Map map) {
        List<UserGoods> list = new ArrayList<>();

        try {
            list = userGoodsMapper.qryUserGoodsList(map);
        } catch (Exception e) {
            throw new BusiException("查询用户商品订购实例信息失败:" + e.getMessage());
        }

        return list;
    }

    /**
     * 查询历史用户商品订购实例信息
     *
     * @param map
     * @return List<UserGoods>
     */
    @Override
    public List<UserGoods> qryUserGoodsHisList(Map map) {
        List<UserGoods> list = new ArrayList<>();

        try {
            list = userGoodsMapper.qryUserGoodsHisList(map);
        } catch (Exception e) {
            throw new BusiException("查询历史用户商品订购实例信息失败:" + e.getMessage());
        }

        return list;
    }

    /**
     * 根据idNo更新状态
     *
     * @param userGoods
     * @return
     */
    @Override
    public ReturnDto updateFinishState(UserGoods userGoods) {
        ReturnDto returnDto = new ReturnDto();

        try {
            Map<String,Object> map = new HashMap<>();
            map.put("idNo",userGoods.getIdNo());
            map.put("finishFlag", FinishFlagEnum.VAL_N.getValue());
            map.put("state", StateEnum.VAL_B.getValue());
            List<UserGoods> userGoodsList = qryUserGoodsList(map);

            if (userGoodsList.isEmpty()) {
                returnDto.setMessage("根据传入参数查询无此数据");
                return returnDto;
            }

            userGoodsMapper.updateFinishState(userGoods);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "根据idNo更新状态失败" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("根据idNo更新状态成功");
        return returnDto;
    }
}
