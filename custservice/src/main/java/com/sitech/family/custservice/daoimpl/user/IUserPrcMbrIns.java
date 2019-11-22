package com.sitech.family.custservice.daoimpl.user;

import com.sitech.family.custservice.dto.mapperdto.UserPrcMbrIns;
import com.sitech.family.dto.ReturnDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 家庭订购实例与成员实例关系
 *
 * @author shirley
 * @date created in 2018/12/21
 */
public interface IUserPrcMbrIns {

    /**
     * 创建家庭订购实例与成员实例关系
     *
     * @param userPrcMbrIns
     * @return ReturnDto
     */
    ReturnDto create(UserPrcMbrIns userPrcMbrIns);

    /**
     * 删除家庭订购实例与成员实例关系
     *
     * @param userPrcMbrIns
     * @return ReturnDto
     */
    ReturnDto drop(UserPrcMbrIns userPrcMbrIns);

    /**
     * 更新家庭订购实例与成员实例关系
     *
     * @param userPrcMbrIns
     * @return ReturnDto
     */
    ReturnDto modify(UserPrcMbrIns userPrcMbrIns);

    /**
     * 查询家庭订购实例与成员实例关系
     *
     * @param memberId,prodPrcInsId
     * @return ReturnDto
     */
    UserPrcMbrIns query(BigDecimal memberId, BigDecimal prodPrcInsId);

    /**
     * 查询家庭订购实例与成员实例关系
     *
     * @param map
     * @return List<UserPrcMbrIns>
     */
    List<UserPrcMbrIns> qryUserPrcMbrInsList(Map map);

    /**
     * 查询历史家庭订购实例与成员实例关系
     *
     * @param map
     * @return List<UserPrcMbrIns>
     */
    List<UserPrcMbrIns> qryUserPrcMbrInsHisList(Map map);

    /**
     * 根据idNo更新状态
     * @param userPrcMbrIns
     * @return
     */
    ReturnDto updateFinishState(UserPrcMbrIns userPrcMbrIns);
}
