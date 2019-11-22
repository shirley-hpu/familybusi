package com.sitech.family.compservice.service;

import com.sitech.family.common.dto.OprInfo;
import com.sitech.family.common.dto.RequestMessage;
import com.sitech.family.common.util.CommonCheckUtil;
import com.sitech.family.compservice.atombiz.IGoodsQryAo;
import com.sitech.family.compservice.compbiz.IFamilyGoodsQryCo;
import com.sitech.family.compservice.dto.indto.*;
import com.sitech.family.compservice.dto.outdto.GoodsPrcInfo;
import com.sitech.family.compservice.inter.IFamilyGoodsQryCoSvc;
import com.sitech.family.constants.ReturnCode;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.message6.dt.Header;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;

import java.util.*;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * 家庭套餐查询 相关服务
 *
 * @author shirley
 * @date created in 2019/3/13
 */
@Service("FamilyGoodsQryCoSvc")
@Api("家庭相关查询")
public class FamilyGoodsQryCoSvc implements IFamilyGoodsQryCoSvc {

    private static final Logger logger = LoggerFactory.getLogger(FamilyGoodsQryCoSvc.class);

    @Resource(name = "FamilyGoodsQryCo")
    private IFamilyGoodsQryCo familyGoodsQryCo;

    @Resource(name = "FamilyGoodsDetailQryCo")
    private IFamilyGoodsQryCo familyGoodsDetailQryCo;

    @Resource(name = "FamilyGoodsMbrQryCo")
    private IFamilyGoodsQryCo familyMbrGoodsQryCo;

    @Resource(name = "FamilyGoodsPrcAttrQryCo")
    private IFamilyGoodsQryCo familyGoodsPrcAttrQryCo;

    @Resource(name = "FamilyGoodsDictQryCo")
    private IFamilyGoodsQryCo familyGoodsDictQryCo;

    @Resource(name = "familyGoodsPrcDiscountQryCo")
    private IFamilyGoodsQryCo familyDiscountQryCo;

    @Resource(name = "qryGoodsPrcDetailAo")
    private IGoodsQryAo goodsPrcDetailQryAo;

    @Resource(name = "FamilyRoleGoodsDetailQryCo")
    private IFamilyGoodsQryCo familyRoleGoodsDetailQryCo;

    @Resource(name = "FamilyOrderAdditionGoodsCo")
    private IFamilyGoodsQryCo familyOrderAdditionGoodsCo;

    @Resource(name = "familyPkgGoodsQryCo")
    private IFamilyGoodsQryCo familyPkgGoodsQryCo;

    @Resource(name = "familyOrderPrcAttrQryCo")
    private IFamilyGoodsQryCo familyOrderPrcAttrQryCo;

    @Override
    @ResponseBody
    @RequestMapping("/sFamilyGoodsQry")
    @ApiOperation(value = "家庭套餐查询", notes = "根据入参查询套餐", tags = "qryFamilyGoods")
    public OutDTO qryFamilyGoods(@Valid @RequestBody(required = false) InDTO<RequestMessage<FamilyGoods>> inDTO, BindingResult bindingResult) {
        OutDTO outDTO = new OutDTO<>();

        //获取注解校验错误信息
        CommonCheckUtil.inDTOCheck(bindingResult);

        //header校验
        CommonCheckUtil.getHeaderDataCheck(inDTO);

        try {
            //调用 compbiz业务逻辑层 封装map 返回Map
            Header header = inDTO.getBodyHeader().getHeader();
            RequestMessage<FamilyGoods> body = inDTO.getBodyHeader().getBody();

            Map<String, Object> paramInDto = new HashMap<>(3);
            paramInDto.put("header", header);
            paramInDto.put("oprInfo", body.getOprInfo());
            paramInDto.put("BUSI_INFO", body.getBusiInfo());

            Map<String, Object> map = familyGoodsQryCo.query(paramInDto);

            outDTO.setBodyOutData(map);
            return outDTO;

        } catch (Exception e) {
            throw new BusiException("99999999999999999", "query failed", e.getMessage());
        }
    }

    @Override
    @RequestMapping("/sFamilyGoodsDetailQry")
    @ResponseBody
    @ApiOperation(value = "家庭套餐构成查询", notes = "根据入参查询套餐构成", tags = "qryFamilyGoodsDetail")
    public OutDTO<Map> qryFamilyGoodsDetail(@Valid @RequestBody(required = false) InDTO<RequestMessage<FamilyGoodsDetailQry>> inDTO, BindingResult bindingResult) {

        //获取注解校验错误信息
        CommonCheckUtil.inDTOCheck(bindingResult);

        //header校验
        CommonCheckUtil.getHeaderDataCheck(inDTO);

        try {
            //调用 compbiz业务逻辑层 封装map 返回Map
            Header header = inDTO.getBodyHeader().getHeader();
            RequestMessage<FamilyGoodsDetailQry> body = inDTO.getBodyHeader().getBody();

            Map<String, Object> paramInDto = new HashMap<>(3);
            paramInDto.put("header", header);
            paramInDto.put("oprInfo", body.getOprInfo());
            paramInDto.put("BUSI_INFO", body.getBusiInfo());

            Map<String, Object> map = goodsPrcDetailQryAo.query(paramInDto);

            OutDTO<Map> outDTO = new OutDTO<>();
            Map outData = new HashMap();
            outData.put("GROUP_ROLE_LIST", map.get("GROUP_ROLE_LIST"));
            outDTO.setBodyOutData(outData);
            return outDTO;

        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "查询失败", e.getMessage());
        }
    }

    @Override
    @RequestMapping("/sFamilyGoodsMbrPrcQry")
    @ResponseBody
    @ApiOperation(value = "成员资费查询", notes = "根据入参查询成员资费", tags = "qryFamilyGoodsMbrPrc")
    public OutDTO<List<GoodsPrcInfo>> qryFamilyGoodsMbrPrc(@Valid @RequestBody(required = false) InDTO<RequestMessage<FamilyGoodsMbrQry>> inDTO, BindingResult bindingResult) {


        //获取注解校验错误信息
        CommonCheckUtil.inDTOCheck(bindingResult);

        //获取header校验
        CommonCheckUtil.getHeaderDataCheck(inDTO);

        try {
            //调用 compbiz业务逻辑层 封装map 返回Map
            Header header = inDTO.getBodyHeader().getHeader();
            RequestMessage<FamilyGoodsMbrQry> body = inDTO.getBodyHeader().getBody();

            Map<String, Object> paramInDto = new HashMap<>(3);
            paramInDto.put("header", header);
            paramInDto.put("oprInfo", body.getOprInfo());
            paramInDto.put("BUSI_INFO", body.getBusiInfo());

            Map<String, Object> map = familyMbrGoodsQryCo.query(paramInDto);
            List<GoodsPrcInfo> list = (List) map.get("GOODS_PRC");

            OutDTO<List<GoodsPrcInfo>> outDTO = new OutDTO<>();
            outDTO.setBodyOutData(list);
            return outDTO;

        } catch (Exception e) {
            throw new BusiException("99999999999999999", "query failed", e.getMessage());
        }
    }

    /**
     * 商品定价属性查询
     *
     * @param inDTO
     * @return outDTO
     */
    @Override
    @ResponseBody
    @RequestMapping("/sFamilyGoodsPrcAttrQry")
    @ApiOperation(value = "商品定价属性查询", notes = "根据入参查询商品定价属性", tags = "qryFamilyGoodsPrcAttr")
    public OutDTO qryFamilyGoodsPrcAttr(@Valid @RequestBody InDTO<RequestMessage<FamilyGoodsPrcAttr>> inDTO) {
        OutDTO outDTO = new OutDTO<>();

        try {
            Header header = inDTO.getHeader();
            OprInfo oprInfo = inDTO.getBodyHeader().getBody().getOprInfo();
            FamilyGoodsPrcAttr familyGoodsPrcAttr = (FamilyGoodsPrcAttr) inDTO.getBodyHeader().getBody().getBusiInfo();

            Map<String, Object> map = new HashMap<>();
            map.put("header", header);
            map.put("oprInfo", oprInfo);
            map.put("busiInfo", familyGoodsPrcAttr);

            Map prcMap = familyGoodsPrcAttrQryCo.query(map);

            outDTO.setBodyOutData(prcMap);
        } catch (Exception e) {
            logger.error("商品定价属性查询" + e.getMessage());
            throw new BusiException(getErrorCode("1000", "15000"), e.getMessage());
        }

        return outDTO;
    }

    @Override
    @RequestMapping("/sFamilyGoodsDictQry")
    @ResponseBody
    @ApiOperation(value = "商品信息查询", notes = "根据入参查询商品信息", tags = "qryFamilyGoodsDict")
    public OutDTO<Map<String, GoodsPrcInfo>> qryFamilyGoodsDict(@Valid @RequestBody(required = false) InDTO<RequestMessage<FamilyGoodsDictQry>> inDTO, BindingResult bindingResult) {

        //获取注解校验错误信息
        CommonCheckUtil.inDTOCheck(bindingResult);

        //header校验
        CommonCheckUtil.getHeaderDataCheck(inDTO);

        Header header = inDTO.getBodyHeader().getHeader();
        RequestMessage<FamilyGoodsDictQry> body = inDTO.getBodyHeader().getBody();

        try {
            //调用 compbiz业务逻辑层 封装map 返回Map
            Map<String, Object> paramInDto = new HashMap<>(3);
            paramInDto.put("header", header);
            paramInDto.put("oprInfo", body.getOprInfo());
            paramInDto.put("BUSI_INFO", body.getBusiInfo());

            Map map = familyGoodsDictQryCo.query(paramInDto);
            GoodsPrcInfo goodsPrcInfo = (GoodsPrcInfo) map.get("GOODS_PRC_INFO");

            Map<String, GoodsPrcInfo> outData = new HashMap<>();
            outData.put("GOODS_PRC_INFO", goodsPrcInfo);

            OutDTO<Map<String, GoodsPrcInfo>> outDTO = new OutDTO<>();
            outDTO.setBodyOutData(outData);
            return outDTO;

        } catch (Exception e) {
            throw new BusiException("99999999999999999", "查询失败", e.getMessage());
        }
    }

    /**
     * 商品资费优惠信息查询
     *
     * @param inDTO
     * @return OutDTO
     **/
    @Override
    @ResponseBody
    @RequestMapping("/sFamilyGoodsPrcDiscountQry")
    @ApiOperation(value = "商品资费优惠信息查询", notes = "根据入参查询商品资费优惠信息", tags = "qryFamilyGoodsPrcDiscount")
    public OutDTO qryFamilyGoodsPrcDiscount(@RequestBody @Valid InDTO<RequestMessage<FamilyGoodsPrcDiscount>> inDTO) {
        OutDTO outDTO = new OutDTO();

        try {
            RequestMessage requestMessage = inDTO.getBodyHeader().getBody();
            OprInfo oprInfo = requestMessage.getOprInfo();
            Header header = inDTO.getBodyHeader().getHeader();
            FamilyGoodsPrcDiscount discount = (FamilyGoodsPrcDiscount) requestMessage.getBusiInfo();

            Map<String, Object> map = new HashMap<>();
            map.put("oprInfo", oprInfo);
            map.put("header", header);
            map.put("busiInfo", discount);

            Map<String, Object> outMap = familyDiscountQryCo.query(map);

            outDTO.setBodyOutData(outMap);
        } catch (Exception e) {
            throw new BusiException("-9999", e.getMessage());
        }

        return outDTO;
    }

    /**
     * 角色商品构成信息查询
     *
     * @param inDTO
     * @return OutDTO
     **/
    @Override
    @ResponseBody
    @RequestMapping("/sFamilyRoleGoodsDetailQry")
    @ApiOperation(value = "角色商品构成信息查询", notes = "根据入参查询角色商品构成信息", tags = "qryFamilyRoleGoodsDetail")
    public OutDTO qryFamilyRoleGoodsDetail(@RequestBody @Valid InDTO<RequestMessage<FamilyRoleGoodsDetailInDto>> inDTO) {
        OutDTO outDTO = new OutDTO();

        try {
            RequestMessage requestMessage = inDTO.getBodyHeader().getBody();
            Header header = inDTO.getBodyHeader().getHeader();
            OprInfo oprInfo = requestMessage.getOprInfo();
            FamilyRoleGoodsDetailInDto familyRoleGoodsDetail = (FamilyRoleGoodsDetailInDto) requestMessage.getBusiInfo();

            Map<String, Object> map = new HashMap<>();
            map.put("header", header);
            map.put("oprInfo", oprInfo);
            map.put("busiInfo", familyRoleGoodsDetail);

            Map<String, Object> outMap = familyRoleGoodsDetailQryCo.query(map);

            outDTO.setBodyOutData(outMap);
        } catch (Exception e) {
            throw new BusiException("-9999", e.getMessage());
        }

        return outDTO;
    }

    /**
     * 家庭已订购附加商品信息查询
     *
     * @param inDTO
     * @return OutDTO
     **/
    @Override
    @ResponseBody
    @RequestMapping("/sFamilyOrderAdditionGoodsQry")
    @ApiOperation(value = "家庭已订购附加商品信息查询", notes = "根据入参查询家庭已订购附加商品信息", tags = "qryFamilyOrderAdditionGoods")
    public OutDTO qryFamilyOrderAdditionGoods(@Valid @RequestBody InDTO<RequestMessage<FamilyOrderAdditionGoods>> inDTO) {
        OutDTO outDTO = new OutDTO();

        try {
            RequestMessage requestMessage = inDTO.getBodyHeader().getBody();
            Header header = inDTO.getBodyHeader().getHeader();
            OprInfo oprInfo = requestMessage.getOprInfo();
            FamilyOrderAdditionGoods familyOrderAdditionGoods = (FamilyOrderAdditionGoods) requestMessage.getBusiInfo();

            Map<String, Object> map = new HashMap<>();
            map.put("header", header);
            map.put("oprInfo", oprInfo);
            map.put("idNo", familyOrderAdditionGoods.getIdNo());

            Map outMap = familyOrderAdditionGoodsCo.query(map);

            outDTO.setBodyOutData(outMap);

            return outDTO;
        } catch (Exception e) {
            throw new BusiException("-9999", e.getMessage());
        }
    }

    /**
     * 查询家庭套餐基本信息
     *
     * @param inDTO
     * @return
     */
    @Override
    @ResponseBody
    @RequestMapping("/sFamilyPkgGoodsInfo")
    @ApiOperation(value = "查询家庭套餐基本信息", notes = "根据入参查询查询家庭套餐基本信息", tags = "qryFamilyGoodsInfo")
    public OutDTO qryFamilyGoodsInfo(@Valid @RequestBody InDTO<RequestMessage<FamilyPkgGoodsInfo>> inDTO) {
        OutDTO outDTO = new OutDTO();

        try {
            RequestMessage requestMessage = inDTO.getBodyHeader().getBody();
            Header header = inDTO.getBodyHeader().getHeader();
            OprInfo oprInfo = requestMessage.getOprInfo();
            FamilyPkgGoodsInfo familyPkgGoodsInfo = (FamilyPkgGoodsInfo) requestMessage.getBusiInfo();

            Map<String, Object> map = new HashMap<>();
            map.put("oprInfo", oprInfo);
            map.put("header", header);
            map.put("busiInfo", familyPkgGoodsInfo);

            Map outMap = familyPkgGoodsQryCo.query(map);

            outDTO.setBodyOutData(outMap);

            return outDTO;
        } catch (Exception e) {
            throw new BusiException("-9999", e.getMessage());
        }
    }

    /**
     * 查询已订购资费属性信息
     *
     * @param inDTO
     * @return outDTO
     */
    @Override
    @ResponseBody
    @RequestMapping("/sFamilyOrderPrcAttrInfo")
    @ApiOperation(value = "已订购资费属性信息查询", notes = "根据入参查询已订购资费属性信息", tags = "qryFamilyOrderPrcAttrInfo")
    public OutDTO qryFamilyOrderPrcAttrInfo(@Valid @RequestBody InDTO<RequestMessage<FamilyOrderPrcAttr>> inDTO) {
        OutDTO outDTO = new OutDTO();

        try {
            Header header = inDTO.getBodyHeader().getHeader();
            RequestMessage requestMessage = inDTO.getBodyHeader().getBody();
            OprInfo oprInfo = requestMessage.getOprInfo();
            FamilyOrderPrcAttr familyOrderPrcAttr = (FamilyOrderPrcAttr) requestMessage.getBusiInfo();

            Map<String,Object> map = new HashMap<>();
            map.put("busiInfo", familyOrderPrcAttr);
            map.put("oprInfo", oprInfo);
            map.put("header", header);

            Map outMap = familyOrderPrcAttrQryCo.query(map);

            outDTO.setBodyOutData(outMap);

            return outDTO;
        } catch (Exception e){
            throw new BusiException("-9999",e.getMessage());
        }
    }
}
