package com.sitech.family.custqryservice.daoimpl.user.impl;

import com.sitech.family.custqryservice.daoimpl.user.IUser;
import com.sitech.family.custqryservice.dto.mapperdto.User;
import com.sitech.family.custqryservice.dto.mapperdto.UserGoods;
import com.sitech.family.custqryservice.dto.mapperdto.UserGoodsAttr;
import com.sitech.family.custqryservice.mapper.IUserMapper;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author wusm
 * @description
 * @date 2018/12/19 17:44
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class UserImpl implements IUser {

    @Autowired
    private IUserMapper mapper;

    /**
     * 查询用户信息
     *
     * @param idNo
     * @return User
     */
    @Override
    public User query(Long idNo) {
        User user = new User();
        try {
            user = mapper.query(idNo);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询用户信息失败" + e.getMessage());
        }
        return user;
    }

    /**
     * 查询用户信息
     *
     * @param map
     * @return List<User>
     */
    @Override
    public List<User> qryUserList(Map map) {
        List<User> list = new ArrayList<>();
        try {
            list = mapper.qryUserList(map);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), e.getMessage());
        }
        return list;
    }

    /**
     * 手机号码查询已订购附加信息
     *
     * @param map
     * @return list
     */
    @Override
    public List<Map> qryOrderFeeByPhoneNo(Map map) {
        List<Map> outList = new ArrayList<>();
        Map outMap = new HashMap();

        try {
            String phoneNo = String.valueOf(map.get("PHONE_NO"));
            List<User> list = mapper.qryOrderFeeByPhoneNo(phoneNo,"1");

            Map<String, Integer> intMap = new HashMap<>();
            for (User user : list) {
                UserGoods userGoods = user.getGoods();
                UserGoodsAttr userGoodsAttr = userGoods.getGoodsattr();

                String goodsId = userGoods.getGoodsId();

                Integer count = 1;

                if (intMap.get(goodsId) != null) {
                    count = intMap.get(goodsId) + 1;
                }

                intMap.put(goodsId, count);
            }

            List<Map> listMap = new ArrayList<>();
            for (String key : intMap.keySet()) {
                List<Map> mapList = new ArrayList<>();
                Map<String, Object> goodsMap = new HashMap<>();

                for (User user : list) {
                    UserGoods userGoods = user.getGoods();
                    UserGoodsAttr userGoodsAttr = userGoods.getGoodsattr();

                    String goodsId = userGoods.getGoodsId();

                    if (key.equals(goodsId)) {
                        goodsMap.put("GOODS_ID", key);
                        goodsMap.put("PRC_ID", userGoods.getPrcId());
                        goodsMap.put("EFF_DATE", userGoods.getEffDate());
                        goodsMap.put("EXP_DATE", userGoods.getExpDate());

                        Map<String, String> attrMap = new HashMap<>();
                        if (userGoodsAttr.getAttrId() != null) {
                            attrMap.put("ATTR_ID", userGoodsAttr.getAttrId());
                            attrMap.put("ATTR_NO", userGoodsAttr.getAttrNo());
                            attrMap.put("ATTR_VALUE", userGoodsAttr.getAttrValue());
                        }

                        if (userGoodsAttr.getAttrId() != null) {
                            mapList.add(attrMap);
                        }
                    }
                }

                if (mapList != null) {
                    goodsMap.put("ATTRLIST", mapList);
                }

                listMap.add(goodsMap);
            }

            outMap.put("GOODSLIST", listMap);

            outList.add(outMap);
        } catch (Exception e) {
            throw new BusiException("-9999", e.getMessage());
        }

        return outList;
    }
}
