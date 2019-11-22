package com.sitech.family.compservice.atombiz.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sitech.family.common.util.CommonCheckUtil;
import com.sitech.family.common.util.PackHeaderOprInfo;
import com.sitech.family.compservice.atombiz.IFamilyMainRoleGroupQryAo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.service.ArchitectureType;
import com.sitech.ijcf.boot.core.service.client.IServiceClient;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.ijcf.message6.dt.support.MBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * todo
 *
 * @author shirley
 * @version 1.0
 * @date 2019-07-31 15:54
 */
@Component("familyMainRoleGroupQryAo")
public class FamilyMainRoleGroupQryAo implements IFamilyMainRoleGroupQryAo {

    private static final Logger logger = LoggerFactory.getLogger(FamilyMainRoleGroupQryAo.class);

    @Resource
    private IServiceClient serviceClient;

    @Override
    public Map qryFamilyMainRoleGroup(Map<String, Object> inDTO) {

        try {
            //获取业务层传入数据
            MBean mBean = PackHeaderOprInfo.packHeaderOprInfo(inDTO);
            mBean.addBody("BUSI_INFO", inDTO.get("BUSI_INFO"));

            logger.debug("MBean ==> " + mBean.toString());
            //调用家客私有服务
            OutDTO<Map> mapOutDTO = serviceClient.callService("http://familybusi-custqryservice/sFamilyMainRoleGroupQry",
                    mBean.toString(), OutDTO.class, ArchitectureType.SPRINGCLOUD);

            logger.debug("OutDTO ==> " + mapOutDTO.toJsonString());
            //真实数据出参校验
            CommonCheckUtil.getOutParamCheck(mapOutDTO);

            //数据解析
            JSONObject jsonObject = JSONObject.parseObject(mapOutDTO.toJsonString());
            JSONArray outData = jsonObject.getJSONObject("ROOT").getJSONObject("BODY").
                    getJSONObject("OUT_DATA").getJSONArray("UR_USERGROUP_INFO_LIST");

            //定义出参存入数据
            Map<String, JSONArray> map = new HashMap<>();
            map.put("UR_USERGROUP_INFO_LIST", outData);
            return map;
        } catch (Exception e) {
            throw new BusiException("处理失败", e.getMessage());
        }
    }

    @Override
    public OutDTO<Object> qryFamilyUserBasicInfo(Map<String,Object> map) {

        MBean mBean = PackHeaderOprInfo.packHeaderOprInfo(map);
        mBean.addBody("BUSI_INFO",map.get("busiInfo"));
        OutDTO outDTO = serviceClient.callService("http://familybusi-custqryservice/sFamilyUserBasicInfoQry", mBean.toString(), OutDTO.class, ArchitectureType.SPRINGCLOUD);
        return outDTO;
    }
}
