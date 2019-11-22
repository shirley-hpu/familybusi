package com.sitech.family.custservice.mapper;

import com.sitech.family.custservice.dto.mapperdto.UserPrcMbrIns;
import com.sitech.family.dto.ReturnDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 家庭订购实例与成员实例关系
 *
 * @author shirley
 * @date created in 2018/12/21
 */
@Repository
public interface UserPrcMbrInsMapper {

    /**
     * @param memberId
     * @param prodPrcInsId
     * @return
     */
    void drop(@Param("memberId") BigDecimal memberId,@Param("prodPrcInsId") BigDecimal prodPrcInsId);

    /**
     * @param userGroupMbr
     * @return
     */
    void create(UserPrcMbrIns userGroupMbr);

    /**
     * @param userGroupMbr
     * @return
     */
    void insert(UserPrcMbrIns userGroupMbr);

    /**
     * @param memberId
     * @return
     */
    UserPrcMbrIns query(@Param("memberId") BigDecimal memberId,@Param("prodPrcInsId") BigDecimal prodPrcInsId);

    /**
     * @param userPrcMbrIns
     * @return
     */
    void modify(UserPrcMbrIns userPrcMbrIns);

    /**
     * @param map
     * @return List<UserPrcMbrIns>
     */
    List<UserPrcMbrIns> qryUserPrcMbrInsList(@Param("params") Map map);

    /**
     * @param map
     * @return List<UserPrcMbrIns>
     */
    List<UserPrcMbrIns> qryUserPrcMbrInsHisList(@Param("inparams") Map map);

    /**
     * 根据idNo更新状态
     * @param userPrcMbrIns
     * @return
     */
    void updateFinishState(UserPrcMbrIns userPrcMbrIns);

}
