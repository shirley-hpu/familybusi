package com.sitech.family.custqryservice.daoimpl;

import com.sitech.family.custqryservice.daoimpl.user.IGoodsSale;
import com.sitech.family.custqryservice.daoimpl.user.IResSellTerm;
import com.sitech.family.custqryservice.dto.mapperdto.GoodsSale;
import com.sitech.family.custqryservice.dto.mapperdto.ResSellTerm;
import com.sitech.family.dao.usergoods.IUserGoodsSaleInfoQryDao;
import com.sitech.family.dto.usergoods.UserGoodsSaleInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service("userGoodsSaleInfoQryDaoImpl")
public class UserGoodsSaleInfoQryDaoImpl implements IUserGoodsSaleInfoQryDao {

    /**
     * 商品销售记录
     */
    @Autowired
    private IGoodsSale goodsSaleImpl;

    /**
     * 实物类资源销售记录模型  UR_RESSELLTERM_INFO  待研讨
     * ResSellTerm
     */
    @Autowired
    private IResSellTerm resSellTermImpl;

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
            ResSellTerm resSellTerm = resSellTermImpl.query(opTime,resourceNo,sellSerialNo);

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

            //userGoodsSaleInfo.setEffDate(goodsSale.getEffDate());
            //userGoodsSaleInfo.setExpDate(goodsSale.getExpDate());
            //userGoodsSaleInfo.setFinishFlag(goodsSale.getFinishFlag());
            //userGoodsSaleInfo.setOpType(goodsSale.getOpType());
            //userGoodsSaleInfo.setOldProdprcinsId(goodsSale.getOldProdprcinsId());
            //userGoodsSaleInfo.setOldSellSerialNo(goodsSale.getOldSellSerialNo());
            //userGoodsSaleInfo.setOldGoodsId(goodsSale.getOldGoodsId());
            //userGoodsSaleInfo.setOldPrcId(goodsSale.getOldPrcId());
            //userGoodsSaleInfo.setOldSkuId(goodsSale.getOldSkuId());
            //userGoodsSaleInfo.setOldResourceNo(goodsSale.getOldResourceNo());
            //userGoodsSaleInfo.setDevelopLogin(goodsSale.getDevelopLogin());
            //userGoodsSaleInfo.setBuyName(goodsSale.getBuyName());
            //userGoodsSaleInfo.setBuyIccid(goodsSale.getBuyIccid());
            //userGoodsSaleInfo.setContactId(goodsSale.getContactId());
            //userGoodsSaleInfo.setSubOrderId(goodsSale.getSubOrderId());
            //userGoodsSaleInfo.setSubOrderAccept(goodsSale.getSubOrderAccept());
            //userGoodsSaleInfo.setOrdlineId(goodsSale.getOrdlineId());
            //userGoodsSaleInfo.setBackAcceptId(goodsSale.getBackAcceptId());
            //userGoodsSaleInfo.setBackAccept(goodsSale.getLoginAccept());
            //userGoodsSaleInfo.setChantypeId(goodsSale.getChantypeId());
            //userGoodsSaleInfo.setOpSource(goodsSale.getOpSource());
            //userGoodsSaleInfo.setOutOrderId(goodsSale.getOutOrderId());
            //userGoodsSaleInfo.setResourceType(goodsSale.getGoodsType());
            //userGoodsSaleInfo.setResourceCode(resSellTerm.getResourceCode());
            //userGoodsSaleInfo.setResourceModel(resSellTerm.getResourceModel());
            //userGoodsSaleInfo.setReceiveName(resSellTerm.getReceiveName());
            //userGoodsSaleInfo.setReceivePhone(resSellTerm.getReceivePhone());
            //userGoodsSaleInfo.setSellType(resSellTerm.getSellType());
            //userGoodsSaleInfo.setResCostPrice(resSellTerm.getResCostPrice());
            //userGoodsSaleInfo.setResSellPrice(resSellTerm.getResSellPrice());
            //userGoodsSaleInfo.setResActPrice(resSellTerm.getResActPrice());
            //userGoodsSaleInfo.setSellNum(resSellTerm.getSellNum());
            //userGoodsSaleInfo.setOutterLoginNo(resSellTerm.getOutterLoginNo());
            //userGoodsSaleInfo.setOutterTime(resSellTerm.getOutterTime());
            //userGoodsSaleInfo.setOrgGroup(resSellTerm.getOrgGroup());
            //userGoodsSaleInfo.setUsePhone(resSellTerm.getUsePhone());
            //userGoodsSaleInfo.setSellSolutionId(resSellTerm.getSellSolutionId());
            //userGoodsSaleInfo.setSellMeanId(resSellTerm.getSellMeanId());

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
