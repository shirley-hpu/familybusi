package com.sitech.family.custservice.atombusi;

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
public interface IFamilyUserGoodsSaleInfo {

    /**
     * 新增
     *
     * @param userGoodsSaleInfoDto
     * @return
     */
    ReturnDto create(UserGoodsSaleInfo userGoodsSaleInfoDto);

    /**
     * 修改
     *
     * @param userGoodsSaleInfoDto
     * @return
     */
    ReturnDto modify(UserGoodsSaleInfo userGoodsSaleInfoDto);

    /**
     * 删除
     *
     * @param userGoodsSaleInfoDto
     * @return
     */
    ReturnDto drop(UserGoodsSaleInfo userGoodsSaleInfoDto);

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
