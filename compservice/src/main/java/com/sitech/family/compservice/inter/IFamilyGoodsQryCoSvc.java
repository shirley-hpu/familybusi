package com.sitech.family.compservice.inter;

import com.sitech.family.common.dto.RequestMessage;
import com.sitech.family.compservice.dto.indto.*;
import com.sitech.family.compservice.dto.outdto.FamilyGoodsDetailOutDto;
import com.sitech.family.compservice.dto.outdto.GoodsPrcInfo;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

/**
 * 家庭套餐查询 相关服务
 *
 * @author shirley
 * @date created in 2019/3/13
 */
public interface IFamilyGoodsQryCoSvc {


    /**
     * 套餐查询
     *
     * @param inDTO
     * @return OutDTO
     */
    public OutDTO qryFamilyGoods(@RequestBody(required = false) InDTO<RequestMessage<FamilyGoods>> inDTO, BindingResult bindingResult);

    /**
     * 家庭套餐构成查询
     *
     * @param inDTO
     * @return OutDTO
     **/
    public OutDTO<Map> qryFamilyGoodsDetail(@RequestBody(required = false) InDTO<RequestMessage<FamilyGoodsDetailQry>> inDTO, BindingResult bindingResult);

    /**
     * 成员资费查询
     *
     * @param inDTO
     * @return OutDTO
     **/
    public OutDTO<List<GoodsPrcInfo>> qryFamilyGoodsMbrPrc(@RequestBody(required = false) InDTO<RequestMessage<FamilyGoodsMbrQry>> inDTO, BindingResult bindingResult);

    /**
     * 商品定价属性查询
     * @param inDTO
     * @return outDTO
     */
    public OutDTO qryFamilyGoodsPrcAttr(InDTO<RequestMessage<FamilyGoodsPrcAttr>> inDTO);

    /**
     * 商品信息查询
     *
     * @param inDTO
     * @return OutDTO
     **/
    public OutDTO<Map<String,GoodsPrcInfo>> qryFamilyGoodsDict(@RequestBody(required = false) InDTO<RequestMessage<FamilyGoodsDictQry>> inDTO, BindingResult bindingResult);

    /**
     * 商品资费优惠信息查询
     *
     * @param inDTO
     * @return OutDTO
     **/
    public OutDTO qryFamilyGoodsPrcDiscount(InDTO<RequestMessage<FamilyGoodsPrcDiscount>> inDTO);

    /**
     * 角色商品构成信息查询
     *
     * @param inDTO
     * @return OutDTO
     **/
    public OutDTO qryFamilyRoleGoodsDetail(InDTO<RequestMessage<FamilyRoleGoodsDetailInDto>> inDTO);

    /**
     * 家庭已订购附加商品信息查询
     *
     * @param inDTO
     * @return OutDTO
     **/
    public OutDTO qryFamilyOrderAdditionGoods(InDTO<RequestMessage<FamilyOrderAdditionGoods>> inDTO);

    /**
     * 查询家庭套餐基本信息
     * @param inDTO
     * @return
     */
    public OutDTO qryFamilyGoodsInfo(InDTO<RequestMessage<FamilyPkgGoodsInfo>> inDTO);

    /**
     * 查询已订购资费属性信息
     * @param inDTO
     * @return outDTO
     */
    public OutDTO qryFamilyOrderPrcAttrInfo(InDTO<RequestMessage<FamilyOrderPrcAttr>> inDTO);

}
