package com.sitech.family.custservice.atombusi;

import com.sitech.family.dto.UpdateOprInfo;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.usergoods.UserGoodsInfo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description 家庭商品订购信息
 * @date 2018/12/17 14:07
 */
public interface IFamilyUserGoodsInfo {

    /**
     * 新增家庭商品订购信息
     *
     * @param userGoodsInfo
     * @return ReturnDto
     */
    ReturnDto create(UserGoodsInfo userGoodsInfo);

    /**
     * 修改家庭商品订购信息
     *
     * @param userGoodsInfo
     * @return ReturnDto
     */
    ReturnDto modify(UserGoodsInfo userGoodsInfo);

    /**
     * 删除家庭商品订购信息
     *
     * @param userGoodsInfo
     * @return ReturnDto
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
     *
     * @param idNo
     * @return
     */
    ReturnDto updateFinishState(UpdateOprInfo updateOprInfo, Long idNo);
}
