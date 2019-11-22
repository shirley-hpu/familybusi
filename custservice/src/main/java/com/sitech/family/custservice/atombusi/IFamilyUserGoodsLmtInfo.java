package com.sitech.family.custservice.atombusi;

import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.usergoods.UserGoodsLmtInfo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 家庭用户受限信息实体
 *
 * @author shirley
 * @date created in 2018/12/14
 */
public interface IFamilyUserGoodsLmtInfo {

    /**
     * 新增
     *
     * @param userGoodsLmtInfoDto
     * @return
     */
    ReturnDto create(UserGoodsLmtInfo userGoodsLmtInfoDto);

    /**
     * 修改
     *
     * @param userGoodsLmtInfoDto
     * @return
     */
    ReturnDto modify(UserGoodsLmtInfo userGoodsLmtInfoDto);

    /**
     * 删除
     *
     * @param userGoodsLmtInfoDto
     * @return
     */
    ReturnDto drop(UserGoodsLmtInfo userGoodsLmtInfoDto);

    /**
     * 查询
     *
     * @return
     */
    UserGoodsLmtInfo query(BigDecimal limitinsId, BigDecimal goodsinsId);

    /**
     * @param map
     * @return
     */
    List<UserGoodsLmtInfo> qryUserGoodsLmtInfoList(Map map);

}
