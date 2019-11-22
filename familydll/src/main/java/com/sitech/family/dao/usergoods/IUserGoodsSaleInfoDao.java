package com.sitech.family.dao.usergoods;

import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.usergoods.UserGoodsSaleInfo;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 家庭商品销售轨迹信息
 *
 * @author shirley
 * @date created in 2018/12/17
 */
public interface IUserGoodsSaleInfoDao {

    /**
     * 新增
     *
     * @param userGoodsSaleInfo
     * @return
     */
    ReturnDto create(UserGoodsSaleInfo userGoodsSaleInfo);

    /**
     * 修改
     *
     * @param userGoodsSaleInfo
     * @return
     */
    ReturnDto modify(UserGoodsSaleInfo userGoodsSaleInfo);

    /**
     * 删除
     *
     * @param userGoodsSaleInfo
     * @return
     */
    ReturnDto drop(UserGoodsSaleInfo userGoodsSaleInfo);

    /**
     * 查询
     *
     * @return
     */
    UserGoodsSaleInfo query(Long loginAccept, String resourceNo, Long sellSerialNo, Date opTime);

    /**
     * @param map
     * @return
     */
    List<UserGoodsSaleInfo> qryUserGoodsSaleInfoList(Map map);
}
