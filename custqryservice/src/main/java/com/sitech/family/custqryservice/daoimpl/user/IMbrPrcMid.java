package com.sitech.family.custqryservice.daoimpl.user;

import com.sitech.family.custqryservice.dto.mapperdto.MbrPrcMid;
import java.util.List;
import java.util.Map;

/**
 * @author wusm
 * @description 成员订购实例
 * @date 2019/4/17 16:41
 */
public interface IMbrPrcMid {



    /**
     * 查询成员订购实例
     *
     * @param map
     * @return List<MbrPrcMid>
     */
    List<MbrPrcMid> qryMbrPrcMidList(Map map);


}
