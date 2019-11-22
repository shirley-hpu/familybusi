package com.sitech.family.common.util;

import com.sitech.family.common.dto.OprInfo;
import com.sitech.ijcf.message6.dt.Routing;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * @author wusm
 * @description 入参公共节点封装
 * @date 2018/9/27 17:30
 */
public class PackIndtoUtil {

    /**
     *  入参节点ROUTING封装
     * @param routing
     * @return map
     */
    public static MultiValueMap<String,String> packRoute(Routing routing){
        MultiValueMap<String,String> map = new LinkedMultiValueMap<>();

        map.add("ROUTE_KEY","路由类型");
        map.add("ROUTE_KEY", routing.getRouteKey());
        map.add("ROUTE_VALUE","路由值");
        map.add("ROUTE_VALUE", routing.getRouteValue());

        return map;
    }

    /**
     * 入参节点OPR_INFO封装
     * @param oprInfo
     * @return map
     */
    public static MultiValueMap<String,String> packOprInfo(OprInfo oprInfo){
        MultiValueMap<String,String> map = new LinkedMultiValueMap<>();

        map.add("REGION_ID","地市");
        map.add("REGION_ID",oprInfo.getRegionId());
        map.add("LOGIN_NO","工号");
        map.add("LOGIN_NO",oprInfo.getLoginNo());
        map.add("GROUP_ID","营业厅代码");
        map.add("GROUP_ID",oprInfo.getGroupId());
        map.add("CONTACT_ID","接触ID");
        map.add("CONTACT_ID",oprInfo.getContactId());
        map.add("OP_NOTE","操作备注");
        map.add("OP_NOTE",oprInfo.getOpNote());
        map.add("CHANNEL_TYPE","渠道类型");
        map.add("CHANNEL_TYPE",oprInfo.getChannelType());

        return map;
    }
}
