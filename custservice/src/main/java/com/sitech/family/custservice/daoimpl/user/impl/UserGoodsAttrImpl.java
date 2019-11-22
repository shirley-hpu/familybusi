package com.sitech.family.custservice.daoimpl.user.impl;

import com.sitech.family.common.constants.FinishFlagEnum;
import com.sitech.family.common.constants.UpdateTypeEnum;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.daoimpl.user.IUserGoodsAttr;
import com.sitech.family.custservice.dto.mapperdto.UserGoodsAttr;
import com.sitech.family.custservice.mapper.IUserGoodsAttrMapper;
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
 * @author wusm
 * @description 商品定价属性实例
 * @date 2018/12/10 10:14
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class UserGoodsAttrImpl implements IUserGoodsAttr {

    @Autowired
    private IUserGoodsAttrMapper mapper;

    /**
     * 创建商品定价属性实例信息
     *
     * @param userGoodsAttr
     * @return returnDto
     */
    @Override
    public ReturnDto create(UserGoodsAttr userGoodsAttr) {
        ReturnDto returnDto = new ReturnDto();

        try {
            mapper.create(userGoodsAttr);

            mapper.insert(userGoodsAttr);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "创建商品定价属性实例信息失败"+e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("创建商品定价属性实例信息成功");
        return returnDto;
    }

    /**
     * 更新商品定价属性实例信息
     *
     * @param userGoodsAttr
     * @return returnDto
     */
    @Override
    public ReturnDto modify(UserGoodsAttr userGoodsAttr) {
        ReturnDto returnDto = new ReturnDto();

        try {
            BigDecimal goodsinsId = userGoodsAttr.getGoodsinsId();
            String attrId = userGoodsAttr.getAttrId();
            String attrNo = userGoodsAttr.getAttrNo();
            Date effDate = userGoodsAttr.getEffDate();

            UserGoodsAttr userGoodsAttr1 = mapper.query(goodsinsId,attrId,attrNo,effDate);

            if (StringUtil.isEmptyOrNull(userGoodsAttr1)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,更新商品定价属性实例信息失败");
                return returnDto;
            }

            userGoodsAttr1.setUpdateAccept(userGoodsAttr.getUpdateAccept());
            userGoodsAttr1.setUpdateType(userGoodsAttr.getUpdateType());
            userGoodsAttr1.setUpdateTime(userGoodsAttr.getUpdateTime());
            userGoodsAttr1.setUpdateDate(userGoodsAttr.getUpdateDate());
            userGoodsAttr1.setUpdateLogin(userGoodsAttr.getUpdateLogin());
            userGoodsAttr1.setUpdateCode(userGoodsAttr.getUpdateCode());

            mapper.insert(userGoodsAttr1);

            mapper.modify(userGoodsAttr);

            userGoodsAttr.setUpdateType(UpdateTypeEnum.VAL_X.getValue());

            mapper.insert(userGoodsAttr);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "修改商品定价属性实例信息失败"+e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("修改商品定价属性实例信息成功");
        return returnDto;
    }

    /**
     * 删除商品定价属性实例信息
     *
     * @param userGoodsAttr
     * @return returnDto
     */
    @Override
    public ReturnDto drop(UserGoodsAttr userGoodsAttr) {
        ReturnDto returnDto = new ReturnDto();

        try {
            BigDecimal goodsinsId = userGoodsAttr.getGoodsinsId();
            String attrId = userGoodsAttr.getAttrId();
            String attrNo = userGoodsAttr.getAttrNo();
            Date effDate = userGoodsAttr.getEffDate();

            UserGoodsAttr userGoodsAttr1 = mapper.query(goodsinsId, attrId, attrNo, effDate);

            if (StringUtil.isEmptyOrNull(userGoodsAttr1)) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage("根据传入参数查询无此数据,删除商品定价属性实例信息失败");
                return returnDto;
            }

            userGoodsAttr1.setUpdateAccept(userGoodsAttr.getUpdateAccept());
            userGoodsAttr1.setUpdateType(userGoodsAttr.getUpdateType());
            userGoodsAttr1.setUpdateTime(userGoodsAttr.getUpdateTime());
            userGoodsAttr1.setUpdateDate(userGoodsAttr.getUpdateDate());
            userGoodsAttr1.setUpdateLogin(userGoodsAttr.getUpdateLogin());
            userGoodsAttr1.setUpdateCode(userGoodsAttr.getUpdateCode());

            mapper.insert(userGoodsAttr1);

            mapper.drop(userGoodsAttr);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "删除商品定价属性实例信息失败" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("删除商品定价属性实例信息成功");
        return returnDto;
    }

    /**
     * 查询商品定价属性实例信息
     *
     * @param goodsinsId,attrId,attrNo,effDate
     * @return List<UserGoodsAttr>
     */
    @Override
    public UserGoodsAttr query(BigDecimal goodsinsId, String attrId, String attrNo, Date effDate) {
        UserGoodsAttr userGoodsAttr = new UserGoodsAttr();
        try {
            userGoodsAttr = mapper.query(goodsinsId,attrId,attrNo,effDate);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询商品定价属性实例信息失败"+e.getMessage());
        }

        return userGoodsAttr;
    }

    /**
     * 查询商品定价属性实例信息
     *
     * @param map
     * @return List<UserGoodsAttr>
     */
    @Override
    public List<UserGoodsAttr> qryUserGoodsAttrList(Map map) {
        List<UserGoodsAttr> list = new ArrayList<>();

        try {
            list = mapper.qryUserGoodsAttrList(map);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询商品定价属性实例信息失败" + e.getMessage());
        }

        return list;
    }

    /**
     * 查询历史表商品定价属性实例信息
     *
     * @param map
     * @return List<UserGoodsAttr>
     */
    @Override
    public List<UserGoodsAttr> qryUserGoodsAttrHisList(Map map) {
        List<UserGoodsAttr> list = new ArrayList<>();

        try {
            list = mapper.qryUserGoodsAttrHisList(map);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询商品定价属性实例信息失败" + e.getMessage());
        }

        return list;
    }

    /**
     * 根据idNo更新状态
     *
     * @param userGoodsAttr
     * @return
     */
    @Override
    public ReturnDto updateFinishState(UserGoodsAttr userGoodsAttr) {
        ReturnDto returnDto = new ReturnDto();

        try {
            Map<String,Object> map = new HashMap<>();
            map.put("idNo",userGoodsAttr.getIdNo());
            map.put("finishFlag", FinishFlagEnum.VAL_N.getValue());
            List<UserGoodsAttr> userGoodsAttrList = qryUserGoodsAttrList(map);

            if (userGoodsAttrList.isEmpty()) {
                returnDto.setMessage("根据传入参数查询无此数据");
                return returnDto;
            }

            mapper.updateFinishState(userGoodsAttr);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "根据idNo更新状态失败" + e.getMessage());
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        returnDto.setMessage("根据idNo更新状态成功");
        return returnDto;
    }
}
