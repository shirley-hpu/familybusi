package com.sitech.family.custqryservice.daoimpl.user;

import com.sitech.family.custqryservice.dto.mapperdto.MbrAttrMid;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description 成员订购属性实例
 * @date 2019/4/17 16:46
 */
public interface IMbrAttrMid {



    /**
     * 查询成员订购属性实例
     *
     * @param map
     * @return List<MbrAttrMid>
     */
    List<MbrAttrMid> qryMbrAttrMidList(Map map);

}
