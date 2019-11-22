package com.sitech.family.custservice.atombusi;

import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.UpdateOprInfo;
import com.sitech.family.dto.usergoods.UserGoodsAttrInfo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description 家庭订购属性信息
 * @date 2018/12/17 14:39
 */
public interface IFamilyUserGoodsAttrInfo {

    /**
     * 新增家庭订购属性信息
     *
     * @param userGoodsAttrInfo
     * @return ReturnDto
     */
    ReturnDto create(UserGoodsAttrInfo userGoodsAttrInfo);

    /**
     * 修改家庭订购属性信息
     *
     * @param userGoodsAttrInfo
     * @return ReturnDto
     */
    ReturnDto modify(UserGoodsAttrInfo userGoodsAttrInfo);

    /**
     * 删除家庭订购属性信息
     *
     * @param userGoodsAttrInfo
     * @return ReturnDto
     */
    ReturnDto drop(UserGoodsAttrInfo userGoodsAttrInfo);

    /**
     * 查询家庭订购属性信息
     *
     * @param goodsinsId
     * @param svcinsId
     * @param attrId
     * @param attrNo
     * @param effDate
     * @return UserGoodsAttrInfo
     */
    UserGoodsAttrInfo query(BigDecimal goodsinsId, BigDecimal svcinsId, String attrId, String attrNo, Date effDate);

    /**
     * @param map
     * @return
     */
    List<UserGoodsAttrInfo> qryUserGoodsAttrInfoList(Map map);

    /**
     * 根据idNo更新状态
     *
     * @param idNo
     * @return
     */
    ReturnDto updateFinishState(UpdateOprInfo updateOprInfo, Long idNo);
}
