package com.sitech.family.custqryservice.daoimpl.user.impl;

import com.sitech.family.custqryservice.daoimpl.user.IUserGoodsAttr;
import com.sitech.family.custqryservice.dto.mapperdto.UserGoodsAttr;
import com.sitech.family.custqryservice.mapper.IUserGoodsAttrMapper;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
     * 查询商品定价属性实例信息
     *
     * @param goodsinsId,attrId,attrNo,effDate
     * @return List<UserGoodsAttr>
     */
    @Override
    public UserGoodsAttr query(BigDecimal goodsinsId, String attrId, String attrNo, Date effDate) {
        UserGoodsAttr userGoodsAttr = new UserGoodsAttr();
        try {
            userGoodsAttr = mapper.query(goodsinsId, attrId, attrNo, effDate);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询商品定价属性实例信息失败" + e.getMessage());
        }

        return userGoodsAttr;
    }

    @Override
    public List<UserGoodsAttr> qryUserGoodsAttrList(Map map) {

        try {
            List<UserGoodsAttr> list = mapper.qryUserGoodsAttrList(map);
            return list;
        } catch (Exception e) {
            throw new BusiException("-9999",e.getMessage());
        }

    }
}
