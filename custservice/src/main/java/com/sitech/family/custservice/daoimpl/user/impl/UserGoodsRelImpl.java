package com.sitech.family.custservice.daoimpl.user.impl;

import com.sitech.family.common.constants.UpdateTypeEnum;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.daoimpl.user.IUserGoodsRel;
import com.sitech.family.custservice.dto.mapperdto.UserGoodsRel;
import com.sitech.family.custservice.mapper.IUserGoodsRelMapper;
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

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author wusm
 * @description 用户商品实例关系
 * @date 2018/12/28 10:19
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class UserGoodsRelImpl implements IUserGoodsRel {

    @Autowired
    private IUserGoodsRelMapper mapper;

    /**
     * 创建用户商品实例关系
     *
     * @param userGoodsRel
     * @return returnDto
     */
    @Override
    public ReturnDto create(UserGoodsRel userGoodsRel) {
        ReturnDto returnDto = new ReturnDto();

        try {
            mapper.create(userGoodsRel);

            mapper.insert(userGoodsRel);
        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("创建用户商品实例关系成功");
        return returnDto;
    }

    /**
     * 更新用户商品实例关系
     *
     * @param userGoodsRel
     * @return returnDto
     */
    @Override
    public ReturnDto modify(UserGoodsRel userGoodsRel) {
        ReturnDto returnDto = new ReturnDto();

        try {
            BigDecimal goodsinsId = userGoodsRel.getGoodsinsId();
            BigDecimal relgoodsinsId = userGoodsRel.getRelgoodsinsId();
            Long loginAccept = userGoodsRel.getLoginAccept();

            UserGoodsRel userGoodsRel1 = mapper.query(goodsinsId, relgoodsinsId, loginAccept);

            if (StringUtil.isEmptyOrNull(userGoodsRel1)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,更新用户商品实例关系失败");
                return returnDto;
            }

            userGoodsRel1.setUpdateAccept(userGoodsRel.getUpdateAccept());
            userGoodsRel1.setUpdateType(userGoodsRel.getUpdateType());
            userGoodsRel1.setUpdateTime(userGoodsRel.getUpdateTime());
            userGoodsRel1.setUpdateDate(userGoodsRel.getUpdateDate());
            userGoodsRel1.setUpdateLogin(userGoodsRel.getUpdateLogin());
            userGoodsRel1.setUpdateCode(userGoodsRel.getUpdateCode());

            mapper.insert(userGoodsRel1);

            mapper.modify(userGoodsRel);

            userGoodsRel.setUpdateType(UpdateTypeEnum.VAL_X.getValue());

            mapper.insert(userGoodsRel);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "修改用户商品实例关系失败");
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("修改用户商品实例关系成功");
        return returnDto;
    }

    /**
     * 删除用户商品实例关系
     *
     * @param userGoodsRel
     * @return returnDto
     */
    @Override
    public ReturnDto drop(UserGoodsRel userGoodsRel) {
        ReturnDto returnDto = new ReturnDto();

        try {
            BigDecimal goodsinsId = userGoodsRel.getGoodsinsId();
            BigDecimal relgoodsinsId = userGoodsRel.getRelgoodsinsId();
            Long loginAccept = userGoodsRel.getLoginAccept();

            UserGoodsRel userGoodsRel1 = mapper.query(goodsinsId, relgoodsinsId, loginAccept);

            if (StringUtil.isEmptyOrNull(userGoodsRel1)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,删除用户商品实例关系失败");
                return returnDto;
            }

            userGoodsRel1.setUpdateAccept(userGoodsRel.getUpdateAccept());
            userGoodsRel1.setUpdateType(userGoodsRel.getUpdateType());
            userGoodsRel1.setUpdateTime(userGoodsRel.getUpdateTime());
            userGoodsRel1.setUpdateDate(userGoodsRel.getUpdateDate());
            userGoodsRel1.setUpdateLogin(userGoodsRel.getUpdateLogin());
            userGoodsRel1.setUpdateCode(userGoodsRel.getUpdateCode());

            mapper.insert(userGoodsRel1);

            mapper.drop(userGoodsRel);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "删除用户商品实例关系失败");
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("删除用户商品实例关系成功");
        return returnDto;
    }

    /**
     * 查询用户商品实例关系
     *
     * @param goodsinsId,relgoodsinsId,loginAccept
     * @return UserGoodsRel
     */
    @Override
    public UserGoodsRel query(BigDecimal goodsinsId, BigDecimal relgoodsinsId, Long loginAccept) {
        UserGoodsRel userGoodsRel = new UserGoodsRel();

        try {
            userGoodsRel = mapper.query(goodsinsId, relgoodsinsId, loginAccept);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询用户商品实例关系失败" + e.getMessage());
        }

        return userGoodsRel;
    }

    /**
     * 查询用户商品实例关系
     *
     * @param map
     * @return List<UserGoodsRel>
     */
    @Override
    public List<UserGoodsRel> qryUserGoodsRelList(Map map) {
        List<UserGoodsRel> list = new ArrayList<>();

        try {
            list = mapper.qryUserGoodsRelList(map);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询用户商品实例关系失败" + e.getMessage());
        }

        return list;
    }

    /**
     * 查询用户商品实例关系
     *
     * @param map
     * @return List<UserGoodsRel>
     */
    @Override
    public List<UserGoodsRel> qryUserGoodsRelHisList(Map map) {
        List<UserGoodsRel> list = new ArrayList<>();

        try {
            list = mapper.qryUserGoodsRelHisList(map);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询用户商品实例关系失败" + e.getMessage());
        }

        return list;
    }
}
