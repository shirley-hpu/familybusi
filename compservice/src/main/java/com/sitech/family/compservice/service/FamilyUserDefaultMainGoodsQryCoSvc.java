package com.sitech.family.compservice.service;

import com.alibaba.fastjson.JSONArray;
import com.sitech.family.common.dto.RequestMessage;
import com.sitech.family.common.util.CommonCheckUtil;
import com.sitech.family.compservice.atombiz.IFamilyUserDefaultMainGoodsQryAo;
import com.sitech.family.compservice.atombiz.impl.HotPrcQryAo;
import com.sitech.family.compservice.dto.indto.DetailGoodsInfo;
import com.sitech.family.compservice.dto.indto.FamilyGoodsDetailQry;
import com.sitech.family.compservice.inter.IFamilyUserDefaultMainGoodsQryCoSvc;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.message6.dt.Header;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @date 2019/8/23 10:48
 */
@Service("FamilyUserDefaultMainGoodsQryCoSvc")
@Api("大众市场默认主商品查询")
public class FamilyUserDefaultMainGoodsQryCoSvc implements IFamilyUserDefaultMainGoodsQryCoSvc {
    private static final Logger logger = LoggerFactory.getLogger(FamilyUserDefaultMainGoodsQryCoSvc.class);

    @Autowired
    private IFamilyUserDefaultMainGoodsQryAo familyUserDefaultMainGoodsQryAo;

    @Autowired
    private HotPrcQryAo hotPrcQryAo;

    /**
     * 大众市场默认主资费
     */
    @Override
    @RequestMapping("/sFamilyUserDefaultMainGoodsQry")
    @ResponseBody
    @ApiOperation(value = "大众市场默认主商品查询", notes = "根据入参查询大众市场默认主商品", tags = "qryDefaultMainGoods")
    public OutDTO qryDefaultMainGoods(@Valid @RequestBody InDTO<RequestMessage<Map>> inDTO,BindingResult bindingResult) {
        //获取注解校验错误信息
        CommonCheckUtil.inDTOCheck(bindingResult);
        //header校验
        CommonCheckUtil.getHeaderDataCheck(inDTO);
        RequestMessage<Map> body = inDTO.getBody();
        String prcId = (String)body.getBusiInfo().get("PRC_ID");

        String memRoleId = (String)body.getBusiInfo().get("MEMBER_ROLE_ID");

//        try{
            Header header = inDTO.getBodyHeader().getHeader();
            Map<String, Object> param = new HashMap<>();
//            param.put("PKGPRC_ID",prcId);
            param.put("header",header);
            param.put("oprInfo",body.getOprInfo());


            FamilyGoodsDetailQry familyGoodsDetailQry = new FamilyGoodsDetailQry();

        DetailGoodsInfo goodsInfo = new DetailGoodsInfo();

//            DetailGoodsInfo goodsInfo = familyGoodsDetailQry.getDetailGoodsInfo();
            goodsInfo.setMemberRoleId(memRoleId);
            goodsInfo.setPrcId(prcId);
            familyGoodsDetailQry.setDetailGoodsInfo(goodsInfo);
            param.put("BUSI_INFO",familyGoodsDetailQry);


//            Map<String, Object> qryHotOutDto = familyUserDefaultMainGoodsQryAo.query(param);
            Map<String, Object> qryHotOutDto = hotPrcQryAo.query(param);
            OutDTO<Map> outDTO = new OutDTO<>();
            outDTO.setBodyOutData(qryHotOutDto);
            return outDTO;
//        }catch (Exception e){
//            throw new BusiException("99999999999999999", "默认主商品查询失败", e.getMessage());
//        }
    }
}
