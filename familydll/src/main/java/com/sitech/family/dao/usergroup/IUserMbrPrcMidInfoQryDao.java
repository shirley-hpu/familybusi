package com.sitech.family.dao.usergroup;

import com.sitech.family.dto.usergroup.UserMbrPrcMidInfo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description
 * @date 2019/4/17 21:33
 */
public interface IUserMbrPrcMidInfoQryDao {

    /**
     * 查询
     *
     * @param insValue
     * @return
     */
    UserMbrPrcMidInfo query(BigDecimal insValue);

    /**
     * @param map
     * @return
     */
    List<UserMbrPrcMidInfo> qryUserMbrPrcMidInfoList(Map map);
}
