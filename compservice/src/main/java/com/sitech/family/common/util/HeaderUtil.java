package com.sitech.family.common.util;

import com.sitech.ijcf.message6.dt.Header;
import com.sitech.ijcf.message6.dt.Routing;
import com.sitech.ijcf.message6.dt.in.InDTO;

import java.util.HashMap;
import java.util.Map;

public class HeaderUtil {

    public static Map<String, Object> packHeader(InDTO<Object> inDTO) {
        Map<String, Object> route = new HashMap<>();
        Routing map = inDTO.getBodyHeader().getHeader().getRouting();
        route.put("ROUTE_KEY", map.getRouteKey());
        route.put("ROUTE_VALUE", map.getRouteValue());

        return route;
    }

    public static Map<String, Object> packHeaderChannel(InDTO<Object> inDTO) {
        Map<String, Object> header = new HashMap<>();
        header.put("CHANNEL_ID", inDTO.getBodyHeader().getHeader().getChannelId());

        Map<String, String> route = new HashMap<>();
        Routing map = inDTO.getBodyHeader().getHeader().getRouting();
        route.put("ROUTE_KEY", map.getRouteKey());
        route.put("ROUTE_VALUE", map.getRouteValue());
        header.put("ROUTING", route);

        return header;
    }

    public static Map<String, Object> packMapHeader(Header header) {
        Routing routing = new Routing();
        routing.setRouteKey(header.getRouting().getRouteKey());
        routing.setRouteValue(header.getRouting().getRouteValue());

        Map<String,Object> routeMap = new HashMap<>();
        routeMap.put("ROUTING",routing);
        routeMap.put("CHANNEL_ID",header.getChannelId());

        return routeMap;
    }
}
