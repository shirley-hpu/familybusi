package com.sitech.family.dao.usergroup;

import com.sitech.family.dto.usergroup.UserPrcMbrInsInfo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 家庭订购实例与成员实例关系
 *
 * @author shirley
 * @date created in 2018/12/17
 */
public interface IUserPrcMbrInsInfoQryDao {

    /**
     * 查询
     *
     * @return
     */
    UserPrcMbrInsInfo query(BigDecimal memberId, BigDecimal prodPrcInsId);

    /**
     * @param map
     * @return
     */
    List<UserPrcMbrInsInfo> qryUserPrcMbrInsInfoList(Map map);
}
