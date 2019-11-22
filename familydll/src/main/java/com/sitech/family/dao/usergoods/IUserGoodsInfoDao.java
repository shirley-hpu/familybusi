package com.sitech.family.dao.usergoods;


import com.sitech.family.dto.UpdateOprInfo;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.usergoods.UserGoodsInfo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description 家庭商品订购信息
 * @date 2018/12/17 11:43
 */
public interface IUserGoodsInfoDao {

    /**
     * 新增家庭商品订购信息
     *
     * @param userGoodsInfo
     */
    ReturnDto create(UserGoodsInfo userGoodsInfo);

    /**
     * 修改家庭商品订购信息
     *
     * @param userGoodsInfo
     */
    ReturnDto modify(UserGoodsInfo userGoodsInfo);

    /**
     * 删除家庭商品订购信息
     *
     * @param userGoodsInfo
     */
    ReturnDto drop(UserGoodsInfo userGoodsInfo);

    /**
     * 查询家庭商品订购信息
     *
     * @return userGoodsInfo
     */
    UserGoodsInfo query(BigDecimal goodsinsId, BigDecimal relgoodsinsId, BigDecimal svcinsId, BigDecimal prodprcinsId, Long loginAccept);

    /**
     * @param map
     * @return
     */
    List<UserGoodsInfo> qryUserGoodsInfoList(Map map);

    /**
     * 根据idNo更新状态
     * @param idNo
     * @return
     */
    ReturnDto updateFinishState(UpdateOprInfo updateOprInfo, Long idNo);
}
