package com.sitech.family.compservice.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sitech.family.common.JsonReader;
import com.sitech.family.common.dto.RequestMessage;
import com.sitech.family.common.util.CommonCheckUtil;
import com.sitech.family.compservice.dto.indto.FamilyBillInDto;
import com.sitech.family.compservice.inter.IFamilyBillQryCoSvc;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Zhangc
 * @version 1.0
 * @date 2019/9/18 9:36
 */
@Service
@Api("家庭账单查询")
public class FamilyBillQryCoSvc implements IFamilyBillQryCoSvc {

    private static Logger logger = LoggerFactory.getLogger(FamilyBillQryCoSvc.class);

    @Value("classpath:jsonfiles/familyBill")
    private Resource resource;

    @javax.annotation.Resource
    private JsonReader jsonReader;
    @Override
    @ResponseBody
    @RequestMapping("/sFamilyBillQry")
    @ApiOperation(value = "家庭账单查询", notes = "家庭账单查询", tags = "家庭账单查询")
    public OutDTO<Object> qryFamilyBill(@Valid @RequestBody InDTO<RequestMessage<FamilyBillInDto>> inDTO, BindingResult bindingResult) {
        //获取注解校验错误信息
        CommonCheckUtil.inDTOCheck(bindingResult);
        //header校验
        CommonCheckUtil.getHeaderDataCheck(inDTO);
        FamilyBillInDto familyBillInDto = inDTO.getBody().getBusiInfo();
        OutDTO outDTO = new OutDTO<>();
        //模拟测试数据
        String result = jsonReader.parseJson(resource);
        JSONArray jsonObject = JSONObject.parseObject(result).getJSONObject("ROOT")
                .getJSONObject("BODY").getJSONObject("OUT_DATA").getJSONArray("FAMILYBILL");
        // 暂时在goodsid上传goodsname,根据goodsname判断取值,以后需要及时改动
        String goodsid = familyBillInDto.getIdNo();
        Map<String,Object> outMap = new HashMap();
        for(int i=0;i<jsonObject.size();i++){
            if(jsonObject.getJSONObject(i).getString("GOODS_NAME").equals(goodsid)){
                outMap.put("FAMILY_BILL",jsonObject.getJSONObject(i));
            }
        }
        outDTO.setBodyOutData(outMap);
        return outDTO;
    }
}
