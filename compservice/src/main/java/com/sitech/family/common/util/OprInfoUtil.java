package com.sitech.family.common.util;

import com.sitech.family.common.dto.OprInfo;
import java.util.HashMap;
import java.util.Map;

public class OprInfoUtil {

    /**
     *  封装公共OPR_INFO节点
     * @param oprInfo
     * @return map
     */
    public static Map<String,String> packOprInfo(OprInfo oprInfo){
        Map<String,String> map = new HashMap<>();

        map.put("REGION_ID", oprInfo.getRegionId());
        map.put("LOGIN_NO", oprInfo.getLoginNo());
        map.put("OP_CODE", oprInfo.getOpCode());
        map.put("CONTACT_ID", oprInfo.getContactId());
        map.put("OP_NOTE", oprInfo.getOpNote());
        map.put("CHANNEL_TYPE", oprInfo.getChannelType());
        map.put("APPLY_ID", oprInfo.getApplyId());
        map.put("GROUP_ID",oprInfo.getGroupId());
        map.put("OP_TIME",oprInfo.getOpTime());
        map.put("POWER_RIGHT",oprInfo.getPowerRight());

        return map;
    }
}
