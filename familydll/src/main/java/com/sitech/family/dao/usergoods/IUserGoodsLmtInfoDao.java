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
public interface IUserGoodsLmtInfoDao {


    /**
     * 新增
     *
     * @param userGoodsLmtInfo
     * @return
     */
    ReturnDto create(UserGoodsLmtInfo userGoodsLmtInfo);

    /**
     * 修改
     *
     * @param userGoodsLmtInfo
     * @return
     */
    ReturnDto modify(UserGoodsLmtInfo userGoodsLmtInfo);

    /**
     * 删除
     *
     * @param userGoodsLmtInfo
     * @return
     */
    ReturnDto drop(UserGoodsLmtInfo userGoodsLmtInfo);

    /**
     * 查询
     *
     * @return
     */
    UserGoodsLmtInfo query(BigDecimal limitinsId,BigDecimal goodsinsId);

    /**
     *
     * @param map
     * @return
     */
    List<UserGoodsLmtInfo> qryUserGoodsLmtInfoList(Map map);


}
