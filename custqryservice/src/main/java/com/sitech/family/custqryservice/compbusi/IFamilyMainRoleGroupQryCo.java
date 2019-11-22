package com.sitech.family.custqryservice.compbusi;

import com.sitech.family.custqryservice.dto.outdto.FamilyGroupInfo;

import java.util.List;
import java.util.Map;

/**
 * 主号家庭信息查询
 *
 * @author shirley
 * @version 1.0
 * @date 2019/7/30 下午3:03
 */
public interface IFamilyMainRoleGroupQryCo {

    public List<FamilyGroupInfo> query(Map<String, Object> map);
}
