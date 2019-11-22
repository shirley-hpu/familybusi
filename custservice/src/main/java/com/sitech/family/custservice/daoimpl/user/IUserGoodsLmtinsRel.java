package com.sitech.family.custservice.daoimpl.user;

import com.sitech.family.custservice.dto.mapperdto.UserGoodsLmtins;
import com.sitech.family.dto.ReturnDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 商品订购实例与受限实例关系
 *
 * @author shirley
 * @date created in 2018/12/10
 */
public interface IUserGoodsLmtinsRel {

    /**
     * 创建商品订购实例与受限实例关系信息
     *
     * @param userGoodsLmtins
     * @return ReturnDto
     */
    ReturnDto create(UserGoodsLmtins userGoodsLmtins);

    /**
     * 删除商品订购实例与受限实例关系
     *
     * @param userGoodsLmtins
     * @return ReturnDto
     */
    ReturnDto drop(UserGoodsLmtins userGoodsLmtins);

    /**
     * 更新商品订购实例与受限实例关系信息
     *
     * @param userGoodsLmtins
     * @return ReturnDto
     */
    ReturnDto modify(UserGoodsLmtins userGoodsLmtins);

    /**
     * 查询商品订购实例与受限实例关系
     *
     * @param limitinsId,goodsinsId
     * @return UserGoodsLmtins
     */
    UserGoodsLmtins query(BigDecimal limitinsId, BigDecimal goodsinsId);

    /**
     * 查询商品订购实例与受限实例关系
     *
     * @param map
     * @return List<UserGoodsLmtins>
     */
    List<UserGoodsLmtins> qryContractRltList(Map map);

    /**
     * 查询商品订购实例与受限实例关系历史信息
     *
     * @param map
     * @return List<UserGoodsLmtins>
     */
    List<UserGoodsLmtins> qryContractRltHisList(Map map);

}
