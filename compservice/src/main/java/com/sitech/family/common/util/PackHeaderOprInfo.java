package com.sitech.family.common.util;

import com.sitech.family.common.dto.OprInfo;
import com.sitech.ijcf.message6.dt.Header;
import com.sitech.ijcf.message6.dt.support.MBean;

import java.util.Map;

/**
 * @author wusm
 * @description 原子层调用产商品接口封装HEADER和OPRINFO节点
 * @date 2019/4/3 17:05
 */
public class PackHeaderOprInfo {


    public static MBean packHeaderOprInfo(Map<String, Object> map){
        MBean mBean = new MBean();

        //拼接产商品接口header节点
        Header header = (Header) map.get("header");
        mBean.setHeader(HeaderUtil.packMapHeader(header));

        //拼接产商品接口oprInfo节点
        OprInfo oprInfo = (OprInfo) map.get("oprInfo");
        mBean.addBody("OPR_INFO", OprInfoUtil.packOprInfo(oprInfo));

        return mBean;
    }
}
