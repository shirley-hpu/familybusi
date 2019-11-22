package com.sitech.family.custservice.daoimpl.user.impl;

import com.sitech.family.common.constants.UpdateTypeEnum;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.daoimpl.user.IUserGoodsLmtinsRel;
import com.sitech.family.custservice.dto.mapperdto.UserGoodsLmtins;
import com.sitech.family.custservice.mapper.UserGoodsLmtinsMapper;
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
 * 商品订购实例与受限实例关系 实现
 *
 * @author shirley
 * @date created in 2018/12/10
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class UserGoodsLmtinsRelImpl implements IUserGoodsLmtinsRel {

    @Autowired
    private UserGoodsLmtinsMapper userGoodsLmtinsMapper;

    /**
     * 创建商品订购实例与受限实例关系信息
     *
     * @param userGoodsLmtins
     * @return int
     */

    @Override
    public ReturnDto create(UserGoodsLmtins userGoodsLmtins) {
        ReturnDto returnDto = new ReturnDto();

        try {
            userGoodsLmtinsMapper.insert(userGoodsLmtins);

            userGoodsLmtinsMapper.create(userGoodsLmtins);
        } catch (Exception e) {
            throw new BusiException("创建商品订购实例与受限实例关系信息失败:" + e.getMessage());
        }


        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    /**
     * 删除商品订购实例与受限实例关系信息
     *
     * @param userGoodsLmtins
     * @return ReturnDto
     */
    @Override
    public ReturnDto drop(UserGoodsLmtins userGoodsLmtins) {
        ReturnDto returnDto = new ReturnDto();

        try {

            UserGoodsLmtins userGoodsLmtinsQry = userGoodsLmtinsMapper.query(userGoodsLmtins.getLimitinsId(), userGoodsLmtins.getGoodsinsId());

            if (StringUtil.isEmptyOrNull(userGoodsLmtinsQry)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,删除商品订购实例与受限实例关系信息失败");
                return returnDto;
            }

            userGoodsLmtinsQry.setUpdateAccept(userGoodsLmtins.getUpdateAccept());
            userGoodsLmtinsQry.setUpdateType(userGoodsLmtins.getUpdateType());
            userGoodsLmtinsQry.setUpdateTime(userGoodsLmtins.getUpdateTime());
            userGoodsLmtinsQry.setUpdateDate(userGoodsLmtins.getUpdateDate());
            userGoodsLmtinsQry.setUpdateLogin(userGoodsLmtins.getUpdateLogin());
            userGoodsLmtinsQry.setUpdateCode(userGoodsLmtins.getUpdateCode());

            userGoodsLmtinsMapper.insert(userGoodsLmtinsQry);

            userGoodsLmtinsMapper.drop(userGoodsLmtins.getLimitinsId(), userGoodsLmtins.getGoodsinsId());
        } catch (Exception e) {
            throw new BusiException("删除商品订购实例与受限实例关系信息失败:" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    /**
     * 更新商品订购实例与受限实例关系信息
     *
     * @param userGoodsLmtins
     * @return ReturnDto
     */
    @Override
    public ReturnDto modify(UserGoodsLmtins userGoodsLmtins) {
        ReturnDto returnDto = new ReturnDto();

        try {
            UserGoodsLmtins userGoodsLmtinsQry = userGoodsLmtinsMapper.query(userGoodsLmtins.getLimitinsId(), userGoodsLmtins.getGoodsinsId());

            if (StringUtil.isEmptyOrNull(userGoodsLmtinsQry)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,更新商品订购实例与受限实例关系信息失败");
                return returnDto;
            }

            userGoodsLmtinsQry.setUpdateAccept(userGoodsLmtins.getUpdateAccept());
            userGoodsLmtinsQry.setUpdateType(userGoodsLmtins.getUpdateType());
            userGoodsLmtinsQry.setUpdateTime(userGoodsLmtins.getUpdateTime());
            userGoodsLmtinsQry.setUpdateDate(userGoodsLmtins.getUpdateDate());
            userGoodsLmtinsQry.setUpdateLogin(userGoodsLmtins.getUpdateLogin());
            userGoodsLmtinsQry.setUpdateCode(userGoodsLmtins.getUpdateCode());

            userGoodsLmtinsMapper.insert(userGoodsLmtinsQry);

            userGoodsLmtinsMapper.modify(userGoodsLmtins);

            userGoodsLmtins.setUpdateType(UpdateTypeEnum.VAL_X.getValue());

            userGoodsLmtinsMapper.insert(userGoodsLmtins);
        } catch (Exception e) {
            throw new BusiException("更新商品订购实例与受限实例关系信息失败:" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    /**
     * 查询帐务付费明细信息
     *
     * @param limitinsId
     * @param goodsinsId
     * @return UserGoodsLmtins
     */
    @Override
    public UserGoodsLmtins query(BigDecimal limitinsId, BigDecimal goodsinsId) {
        UserGoodsLmtins userGoodsLmtins = new UserGoodsLmtins();

        try {
            userGoodsLmtins = userGoodsLmtinsMapper.query(limitinsId, goodsinsId);
        } catch (Exception e) {
            throw new BusiException("查询商品订购实例与受限实例关系信息失败:" + e.getMessage());
        }

        return userGoodsLmtins;
    }

    /**
     * 查询商品订购实例与受限实例关系信息
     *
     * @param map
     * @return List<UserGoodsLmtins>
     */
    @Override
    public List<UserGoodsLmtins> qryContractRltList(Map map) {
        List<UserGoodsLmtins> list = new ArrayList<>();

        try {
            list = userGoodsLmtinsMapper.qryContractRltList(map);
        } catch (Exception e) {
            throw new BusiException("查询商品订购实例与受限实例关系信息失败:" + e.getMessage());
        }

        return list;
    }

    /**
     * 查询商品订购实例与受限实例关系历史信息
     *
     * @param map
     * @return List<UserGoodsLmtins>
     */
    @Override
    public List<UserGoodsLmtins> qryContractRltHisList(Map map) {
        List<UserGoodsLmtins> list = new ArrayList<>();

        try {
            list = userGoodsLmtinsMapper.qryContractRltHisList(map);
        } catch (Exception e) {
            throw new BusiException("查询商品订购实例与受限实例关系历史信息失败:" + e.getMessage());
        }

        return list;
    }
}
