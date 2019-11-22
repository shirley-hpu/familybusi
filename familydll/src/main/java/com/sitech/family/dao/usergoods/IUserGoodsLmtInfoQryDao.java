package com.sitech.family.dao.usergoods;

import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.usergoods.UserGoodsLmtInfo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 家庭用户受限信息
 *
 * @author shirley
 * @date created in 2018/12/14
 */
public interface IUserGoodsLmtInfoQryDao {

    /**
     * 查询
     *
     * @return
     */
    UserGoodsLmtInfo query(BigDecimal limitinsId, BigDecimal goodsinsId);

    /**
     *
     * @param map
     * @return
     */
    List<UserGoodsLmtInfo> qryUserGoodsLmtInfoList(Map map);


}
