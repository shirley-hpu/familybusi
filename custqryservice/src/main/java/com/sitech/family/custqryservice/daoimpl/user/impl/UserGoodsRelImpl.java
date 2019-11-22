package com.sitech.family.custqryservice.daoimpl.user.impl;

import com.sitech.family.custqryservice.daoimpl.user.IUserGoodsRel;
import com.sitech.family.custqryservice.dto.mapperdto.UserGoodsRel;
import com.sitech.family.custqryservice.mapper.IUserGoodsRelMapper;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

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

}
