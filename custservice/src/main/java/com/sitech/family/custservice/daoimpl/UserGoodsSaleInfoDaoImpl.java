package com.sitech.family.custservice.daoimpl;

import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.daoimpl.user.IGoodsSale;
import com.sitech.family.custservice.daoimpl.user.IResSellTerm;
import com.sitech.family.custservice.dto.mapperdto.GoodsSale;
import com.sitech.family.custservice.dto.mapperdto.ResSellTerm;
import com.sitech.family.dao.usergoods.IUserGoodsSaleInfoDao;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.usergoods.UserGoodsSaleInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * 家庭商品销售轨迹信息
 *
 * @author shirley
 * @date created in 2018/12/17
 */
@Component
public class UserGoodsSaleInfoDaoImpl implements IUserGoodsSaleInfoDao {

    /**
     * 商品销售记录
     */
    @Autowired
    private IGoodsSale goodsSaleImpl;

    /**
     * 实物类资源销售记录 UR_RESSELLTERM_INFO
     */
    @Autowired
    private IResSellTerm resSellTermAo;

    @Override
    public ReturnDto create(UserGoodsSaleInfo userGoodsSaleInfoDto) {

        if (StringUtil.isEmptyOrNull(userGoodsSaleInfoDto)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }

        ReturnDto returnDto = new ReturnDto();
        try {
            //商品销售记录
            GoodsSale goodsSale = new GoodsSale();
            goodsSale.setLoginAccept(userGoodsSaleInfoDto.getLoginAccept());
            goodsSale.setGoodsinsId(userGoodsSaleInfoDto.getGoodsInsId());
            goodsSale.setIdNo(userGoodsSaleInfoDto.getIdNo());
            goodsSale.setOpCode(userGoodsSaleInfoDto.getOpCode());
            goodsSale.setGoodsType("1");
            goodsSale.setOpType(userGoodsSaleInfoDto.getOpType());
            goodsSale.setSellSerialNo(userGoodsSaleInfoDto.getSellSerialNo());
            goodsSale.setGoodsId(userGoodsSaleInfoDto.getGoodsId());
            goodsSale.setPrcId(userGoodsSaleInfoDto.getPrcId());
            goodsSale.setSkuId(userGoodsSaleInfoDto.getSkuId());
            goodsSale.setResourceNo(userGoodsSaleInfoDto.getResourceNo());
            goodsSale.setOldProdprcinsId(userGoodsSaleInfoDto.getOldProdprcinsId());
            goodsSale.setOldSellSerialNo(userGoodsSaleInfoDto.getOldSellSerialNo());
            goodsSale.setOldGoodsId(userGoodsSaleInfoDto.getOldGoodsId());
            goodsSale.setOldPrcId(userGoodsSaleInfoDto.getOldPrcId());
            goodsSale.setOldSkuId(userGoodsSaleInfoDto.getOldSkuId());
            goodsSale.setOldResourceNo(userGoodsSaleInfoDto.getOldResourceNo());
            goodsSale.setEffDate(userGoodsSaleInfoDto.getEffDate());
            goodsSale.setExpDate(userGoodsSaleInfoDto.getExpDate());
            goodsSale.setDevelopLogin(userGoodsSaleInfoDto.getDevelopLogin());
            goodsSale.setOpTime(userGoodsSaleInfoDto.getOpTime());
            goodsSale.setOpCode(userGoodsSaleInfoDto.getOpCode());
            goodsSale.setOpNote(userGoodsSaleInfoDto.getOpNote());
            goodsSale.setContactId(userGoodsSaleInfoDto.getContactId());
            goodsSale.setSubOrderId(userGoodsSaleInfoDto.getSubOrderId());
            goodsSale.setSubOrderAccept(userGoodsSaleInfoDto.getSubOrderAccept());
            goodsSale.setOrdlineId(userGoodsSaleInfoDto.getOrdlineId());
            goodsSale.setBackFlag(userGoodsSaleInfoDto.getBackFlag());
            goodsSale.setBackAcceptId(userGoodsSaleInfoDto.getBackAcceptId());
            goodsSale.setShouldPay(userGoodsSaleInfoDto.getShouldPay());
            goodsSale.setRealPay(userGoodsSaleInfoDto.getRealPay());
            goodsSale.setFavFee(userGoodsSaleInfoDto.getFavFee());
            goodsSale.setChantypeId(userGoodsSaleInfoDto.getChantypeId());
            goodsSale.setOpSource(userGoodsSaleInfoDto.getOpSource());
            goodsSale.setOutOrderId(userGoodsSaleInfoDto.getOutOrderId());
            goodsSale.setLoginNo(userGoodsSaleInfoDto.getLoginNo());
            goodsSale.setLoginAccept(userGoodsSaleInfoDto.getLoginAccept());
            goodsSale.setFinishFlag(userGoodsSaleInfoDto.getFinishFlag());

            returnDto = goodsSaleImpl.create(goodsSale);

            if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage(returnDto.getMessage());
                return returnDto;
            }

            //实物类资源销售记录
            ResSellTerm resSellTerm = new ResSellTerm();
            resSellTerm.setOpTime(userGoodsSaleInfoDto.getOpTime());
            resSellTerm.setResourceNo(userGoodsSaleInfoDto.getResourceNo());
            resSellTerm.setSellSerialNo(userGoodsSaleInfoDto.getSellSerialNo());
            resSellTerm.setLoginAccept(userGoodsSaleInfoDto.getLoginAccept());
            resSellTerm.setIdNo(userGoodsSaleInfoDto.getIdNo());
            resSellTerm.setResourceType(userGoodsSaleInfoDto.getResourceType());
            resSellTerm.setResourceCode(userGoodsSaleInfoDto.getResourceCode());
            resSellTerm.setSkuId(userGoodsSaleInfoDto.getSkuId());
            resSellTerm.setResourceModel(userGoodsSaleInfoDto.getOldResourceNo());
            resSellTerm.setReceiveName(userGoodsSaleInfoDto.getReceiveName());
            resSellTerm.setReceivePhone(userGoodsSaleInfoDto.getReceivePhone());
            resSellTerm.setSellType(userGoodsSaleInfoDto.getSellType());
            resSellTerm.setResCostPrice(userGoodsSaleInfoDto.getResCostPrice());
            resSellTerm.setResSellPrice(userGoodsSaleInfoDto.getResSellPrice());
            resSellTerm.setResActPrice(userGoodsSaleInfoDto.getResActPrice());
            resSellTerm.setSellNum(userGoodsSaleInfoDto.getSellNum());
            resSellTerm.setOutterLoginNo(userGoodsSaleInfoDto.getOutterLoginNo());
            resSellTerm.setOutterTime(userGoodsSaleInfoDto.getOutterTime());
            resSellTerm.setBackFlag(userGoodsSaleInfoDto.getBackFlag());
            resSellTerm.setBackAccept(userGoodsSaleInfoDto.getBackAccept());
            resSellTerm.setOrgGroup(userGoodsSaleInfoDto.getOrgGroup());
            resSellTerm.setUsePhone(userGoodsSaleInfoDto.getUsePhone());
            resSellTerm.setSellSolutionId(userGoodsSaleInfoDto.getSellSolutionId());
            resSellTerm.setSellMeanId(userGoodsSaleInfoDto.getSellMeanId());
            resSellTerm.setGoodsinsId(userGoodsSaleInfoDto.getGoodsInsId());

            resSellTermAo.create(resSellTerm);
        } catch (Exception e) {
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.getMessage());
            return returnDto;
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    @Override
    public ReturnDto modify(UserGoodsSaleInfo userGoodsSaleInfoDto) {
        if (StringUtil.isEmptyOrNull(userGoodsSaleInfoDto)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }

        ReturnDto returnDto = new ReturnDto();
        try {
            //商品销售记录
            GoodsSale goodsSale = new GoodsSale();
            goodsSale.setLoginAccept(userGoodsSaleInfoDto.getLoginAccept());
            goodsSale.setGoodsinsId(userGoodsSaleInfoDto.getGoodsInsId());
            goodsSale.setIdNo(userGoodsSaleInfoDto.getIdNo());
            goodsSale.setOpCode(userGoodsSaleInfoDto.getOpCode());
            goodsSale.setGoodsType("1");
            goodsSale.setOpType(userGoodsSaleInfoDto.getOpType());
            goodsSale.setSellSerialNo(userGoodsSaleInfoDto.getSellSerialNo());
            goodsSale.setGoodsId(userGoodsSaleInfoDto.getGoodsId());
            goodsSale.setPrcId(userGoodsSaleInfoDto.getPrcId());
            goodsSale.setSkuId(userGoodsSaleInfoDto.getSkuId());
            goodsSale.setResourceNo(userGoodsSaleInfoDto.getResourceNo());
            goodsSale.setOldProdprcinsId(userGoodsSaleInfoDto.getOldProdprcinsId());
            goodsSale.setOldSellSerialNo(userGoodsSaleInfoDto.getOldSellSerialNo());
            goodsSale.setOldGoodsId(userGoodsSaleInfoDto.getOldGoodsId());
            goodsSale.setOldPrcId(userGoodsSaleInfoDto.getOldPrcId());
            goodsSale.setOldSkuId(userGoodsSaleInfoDto.getOldSkuId());
            goodsSale.setOldResourceNo(userGoodsSaleInfoDto.getOldResourceNo());
            goodsSale.setEffDate(userGoodsSaleInfoDto.getEffDate());
            goodsSale.setExpDate(userGoodsSaleInfoDto.getExpDate());
            goodsSale.setDevelopLogin(userGoodsSaleInfoDto.getDevelopLogin());
            goodsSale.setOpTime(userGoodsSaleInfoDto.getOpTime());
            goodsSale.setOpCode(userGoodsSaleInfoDto.getOpCode());
            goodsSale.setOpNote(userGoodsSaleInfoDto.getOpNote());
            goodsSale.setContactId(userGoodsSaleInfoDto.getContactId());
            goodsSale.setSubOrderId(userGoodsSaleInfoDto.getSubOrderId());
            goodsSale.setSubOrderAccept(userGoodsSaleInfoDto.getSubOrderAccept());
            goodsSale.setOrdlineId(userGoodsSaleInfoDto.getOrdlineId());
            goodsSale.setBackFlag(userGoodsSaleInfoDto.getBackFlag());
            goodsSale.setBackAcceptId(userGoodsSaleInfoDto.getBackAcceptId());
            goodsSale.setShouldPay(userGoodsSaleInfoDto.getShouldPay());
            goodsSale.setRealPay(userGoodsSaleInfoDto.getRealPay());
            goodsSale.setFavFee(userGoodsSaleInfoDto.getFavFee());
            goodsSale.setChantypeId(userGoodsSaleInfoDto.getChantypeId());
            goodsSale.setOpSource(userGoodsSaleInfoDto.getOpSource());
            goodsSale.setOutOrderId(userGoodsSaleInfoDto.getOutOrderId());
            goodsSale.setLoginNo(userGoodsSaleInfoDto.getLoginNo());
            goodsSale.setLoginAccept(userGoodsSaleInfoDto.getLoginAccept());
            goodsSale.setFinishFlag(userGoodsSaleInfoDto.getFinishFlag());

            returnDto = goodsSaleImpl.modify(goodsSale);

            if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage(returnDto.getMessage());
                return returnDto;
            }

            //实物类资源销售记录
            ResSellTerm resSellTerm = new ResSellTerm();
            resSellTerm.setOpTime(userGoodsSaleInfoDto.getOpTime());
            resSellTerm.setResourceNo(userGoodsSaleInfoDto.getResourceNo());
            resSellTerm.setSellSerialNo(userGoodsSaleInfoDto.getSellSerialNo());
            resSellTerm.setLoginAccept(userGoodsSaleInfoDto.getLoginAccept());
            resSellTerm.setIdNo(userGoodsSaleInfoDto.getIdNo());
            resSellTerm.setResourceType(userGoodsSaleInfoDto.getResourceType());
            resSellTerm.setResourceCode(userGoodsSaleInfoDto.getResourceCode());
            resSellTerm.setSkuId(userGoodsSaleInfoDto.getSkuId());
            resSellTerm.setResourceModel(userGoodsSaleInfoDto.getOldResourceNo());
            resSellTerm.setReceiveName(userGoodsSaleInfoDto.getReceiveName());
            resSellTerm.setReceivePhone(userGoodsSaleInfoDto.getReceivePhone());
            resSellTerm.setSellType(userGoodsSaleInfoDto.getSellType());
            resSellTerm.setResCostPrice(userGoodsSaleInfoDto.getResCostPrice());
            resSellTerm.setResSellPrice(userGoodsSaleInfoDto.getResSellPrice());
            resSellTerm.setResActPrice(userGoodsSaleInfoDto.getResActPrice());
            resSellTerm.setSellNum(userGoodsSaleInfoDto.getSellNum());
            resSellTerm.setOutterLoginNo(userGoodsSaleInfoDto.getOutterLoginNo());
            resSellTerm.setOutterTime(userGoodsSaleInfoDto.getOutterTime());
            resSellTerm.setBackFlag(userGoodsSaleInfoDto.getBackFlag());
            resSellTerm.setBackAccept(userGoodsSaleInfoDto.getBackAccept());
            resSellTerm.setOrgGroup(userGoodsSaleInfoDto.getOrgGroup());
            resSellTerm.setUsePhone(userGoodsSaleInfoDto.getUsePhone());
            resSellTerm.setSellSolutionId(userGoodsSaleInfoDto.getSellSolutionId());
            resSellTerm.setSellMeanId(userGoodsSaleInfoDto.getSellMeanId());
            resSellTerm.setGoodsinsId(userGoodsSaleInfoDto.getGoodsInsId());

            resSellTermAo.modify(resSellTerm);
        } catch (Exception e) {
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.getMessage());
            return returnDto;
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    @Override
    public ReturnDto drop(UserGoodsSaleInfo userGoodsSaleInfoDto) {
        if (StringUtil.isEmptyOrNull(userGoodsSaleInfoDto.getLoginAccept())) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }

        ReturnDto returnDto = new ReturnDto();
        try {
            //商品销售记录
            GoodsSale goodsSale = new GoodsSale();
            goodsSale.setLoginAccept(userGoodsSaleInfoDto.getLoginAccept());
            returnDto = goodsSaleImpl.drop(goodsSale);

            if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage(returnDto.getMessage());
                return returnDto;
            }

            //实物类资源销售记录
            ResSellTerm resSellTerm = new ResSellTerm();
            resSellTerm.setOpTime(userGoodsSaleInfoDto.getOpTime());
            resSellTerm.setResourceNo(userGoodsSaleInfoDto.getResourceNo());
            resSellTerm.setSellSerialNo(userGoodsSaleInfoDto.getSellSerialNo());

            resSellTermAo.drop(resSellTerm);

        } catch (Exception e) {
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.getMessage());
            return returnDto;
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    @Override
    public UserGoodsSaleInfo query(Long loginAccept, String resourceNo, Long sellSerialNo, Date opTime) {
        if (StringUtil.isEmptyOrNull(loginAccept)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }
        if (StringUtil.isEmptyOrNull(resourceNo)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }
        if (StringUtil.isEmptyOrNull(sellSerialNo)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }
        if (StringUtil.isEmptyOrNull(opTime)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }

        try {
            //1、查询 商品销售记录
            GoodsSale goodsSale = goodsSaleImpl.query(loginAccept);

            //2、查询 实物类资源销售记录
            ResSellTerm resSellTerm = resSellTermAo.query(opTime, resourceNo, sellSerialNo);

            //3、拼接出参对象实例
            UserGoodsSaleInfo userGoodsSaleInfo = new UserGoodsSaleInfo();
            userGoodsSaleInfo.setLoginAccept(goodsSale.getLoginAccept());
            userGoodsSaleInfo.setGoodsInsId(goodsSale.getGoodsinsId());
            userGoodsSaleInfo.setIdNo(goodsSale.getIdNo());
            userGoodsSaleInfo.setGoodsId(goodsSale.getGoodsId());
            userGoodsSaleInfo.setPrcId(goodsSale.getPrcId());
            userGoodsSaleInfo.setSkuId(goodsSale.getSkuId());
            userGoodsSaleInfo.setResourceNo(goodsSale.getResourceNo());
            userGoodsSaleInfo.setSellSerialNo(goodsSale.getSellSerialNo());
            userGoodsSaleInfo.setBackFlag(goodsSale.getBackFlag());
            userGoodsSaleInfo.setBackAccept(resSellTerm.getBackAccept());
            userGoodsSaleInfo.setShouldPay(goodsSale.getShouldPay());
            userGoodsSaleInfo.setRealPay(goodsSale.getRealPay());
            userGoodsSaleInfo.setFavFee(goodsSale.getFavFee());
            userGoodsSaleInfo.setOpTime(goodsSale.getOpTime());
            userGoodsSaleInfo.setOpCode(goodsSale.getOpCode());
            userGoodsSaleInfo.setLoginNo(goodsSale.getLoginNo());
            userGoodsSaleInfo.setOpNote(goodsSale.getOpNote());
            //userGoodsSaleInfo.setOupAccept(null);   //数据库无该字段
            //userGoodsSaleInfo.setSystemNote(null);  //数据库无该字段

            userGoodsSaleInfo.setEffDate(goodsSale.getEffDate());
            userGoodsSaleInfo.setExpDate(goodsSale.getExpDate());
            userGoodsSaleInfo.setFinishFlag(goodsSale.getFinishFlag());
            userGoodsSaleInfo.setOpType(goodsSale.getOpType());
            userGoodsSaleInfo.setOldProdprcinsId(goodsSale.getOldProdprcinsId());
            userGoodsSaleInfo.setOldSellSerialNo(goodsSale.getOldSellSerialNo());
            userGoodsSaleInfo.setOldGoodsId(goodsSale.getOldGoodsId());
            userGoodsSaleInfo.setOldPrcId(goodsSale.getOldPrcId());
            userGoodsSaleInfo.setOldSkuId(goodsSale.getOldSkuId());
            userGoodsSaleInfo.setOldResourceNo(goodsSale.getOldResourceNo());
            userGoodsSaleInfo.setDevelopLogin(goodsSale.getDevelopLogin());
            userGoodsSaleInfo.setBuyName(goodsSale.getBuyName());
            userGoodsSaleInfo.setBuyIccid(goodsSale.getBuyIccid());
            userGoodsSaleInfo.setContactId(goodsSale.getContactId());
            userGoodsSaleInfo.setSubOrderId(goodsSale.getSubOrderId());
            userGoodsSaleInfo.setSubOrderAccept(goodsSale.getSubOrderAccept());
            userGoodsSaleInfo.setOrdlineId(goodsSale.getOrdlineId());
            userGoodsSaleInfo.setBackAcceptId(goodsSale.getBackAcceptId());
            userGoodsSaleInfo.setBackAccept(goodsSale.getLoginAccept());
            userGoodsSaleInfo.setChantypeId(goodsSale.getChantypeId());
            userGoodsSaleInfo.setOpSource(goodsSale.getOpSource());
            userGoodsSaleInfo.setOutOrderId(goodsSale.getOutOrderId());
            userGoodsSaleInfo.setResourceType(goodsSale.getGoodsType());
            userGoodsSaleInfo.setResourceCode(resSellTerm.getResourceCode());
            userGoodsSaleInfo.setResourceModel(resSellTerm.getResourceModel());
            userGoodsSaleInfo.setReceiveName(resSellTerm.getReceiveName());
            userGoodsSaleInfo.setReceivePhone(resSellTerm.getReceivePhone());
            userGoodsSaleInfo.setSellType(resSellTerm.getSellType());
            userGoodsSaleInfo.setResCostPrice(resSellTerm.getResCostPrice());
            userGoodsSaleInfo.setResSellPrice(resSellTerm.getResSellPrice());
            userGoodsSaleInfo.setResActPrice(resSellTerm.getResActPrice());
            userGoodsSaleInfo.setSellNum(resSellTerm.getSellNum());
            userGoodsSaleInfo.setOutterLoginNo(resSellTerm.getOutterLoginNo());
            userGoodsSaleInfo.setOutterTime(resSellTerm.getOutterTime());
            userGoodsSaleInfo.setOrgGroup(resSellTerm.getOrgGroup());
            userGoodsSaleInfo.setUsePhone(resSellTerm.getUsePhone());
            userGoodsSaleInfo.setSellSolutionId(resSellTerm.getSellSolutionId());
            userGoodsSaleInfo.setSellMeanId(resSellTerm.getSellMeanId());

            return userGoodsSaleInfo;

        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "修改家庭订购属性信息失败");
        }
    }

    @Override
    public List<UserGoodsSaleInfo> qryUserGoodsSaleInfoList(Map map) {
        if (StringUtil.isEmptyOrNull(map)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }

        try {
            //TODO 待物理层方法修改好后


            return null;
        } catch (Exception e) {
            throw new BusiException("逻辑模型层异常:" + e.getMessage());
        }
    }
}
