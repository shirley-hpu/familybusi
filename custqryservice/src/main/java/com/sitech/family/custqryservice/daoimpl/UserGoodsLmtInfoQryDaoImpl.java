package com.sitech.family.custqryservice.daoimpl;

import com.sitech.family.custqryservice.daoimpl.user.IUserGoodsLmt;
import com.sitech.family.custqryservice.daoimpl.user.IUserGoodsLmtinsRel;
import com.sitech.family.custqryservice.dto.mapperdto.UserGoodsLmt;
import com.sitech.family.custqryservice.dto.mapperdto.UserGoodsLmtins;
import com.sitech.family.dao.usergoods.IUserGoodsLmtInfoQryDao;
import com.sitech.family.dto.usergoods.UserGoodsLmtInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * 家庭用户受限信息
 *
 * @author shirley
 * @date created in 2018/12/14
 */
@Service("userGoodsLmtInfoQryDaoImpl")
public class UserGoodsLmtInfoQryDaoImpl implements IUserGoodsLmtInfoQryDao {

    /**
     * 商品订购实例与受限实例关系表
     */
    @Autowired
    private IUserGoodsLmtinsRel userGoodsLmtinsRelImpl;

    /**
     * 用户商品受限表
     */
    @Autowired
    private IUserGoodsLmt userGoodsLmtImpl;

    @Override
    public UserGoodsLmtInfo query(BigDecimal limitinsId, BigDecimal goodsinsId) {
        if (StringUtil.isEmptyOrNull(limitinsId) || StringUtil.isEmptyOrNull(goodsinsId)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }

        try {
            // 1、查询 用户商品受限实例
            UserGoodsLmt userGoodsLmt = userGoodsLmtImpl.query(limitinsId);

            // 2、查询 商品订购实例与受限实例
            UserGoodsLmtins userGoodsLmtins = userGoodsLmtinsRelImpl.query(limitinsId,goodsinsId);

            // 3、拼接出参对象实例
            UserGoodsLmtInfo userGoodsLmtInfo = new UserGoodsLmtInfo();
            userGoodsLmtInfo.setLimitinsId(userGoodsLmt.getLimitinsId());
            userGoodsLmtInfo.setIdNo(userGoodsLmt.getIdNo());
            userGoodsLmtInfo.setLimitType(userGoodsLmt.getLimitType());
            userGoodsLmtInfo.setRuleId(userGoodsLmt.getRuleId());
            userGoodsLmtInfo.setEffDate(userGoodsLmt.getEffDate());
            userGoodsLmtInfo.setExpDate(userGoodsLmt.getExpDate());
            userGoodsLmtInfo.setLimitLevel(userGoodsLmt.getLimitLevelId());
            userGoodsLmtInfo.setLimitFlag(userGoodsLmt.getLimitFlag());
            userGoodsLmtInfo.setMaxValue(userGoodsLmt.getMaxValue());
            userGoodsLmtInfo.setMinValue(userGoodsLmt.getMixValue());
            userGoodsLmtInfo.setLoginNo(userGoodsLmt.getLoginNo());
            userGoodsLmtInfo.setLoginAccept(userGoodsLmt.getLoginAccept());
            userGoodsLmtInfo.setOpTime(userGoodsLmt.getOpTime());
            userGoodsLmtInfo.setOpCode(userGoodsLmt.getOpCode());
            userGoodsLmtInfo.setLimitDetailMsg(userGoodsLmt.getLimitDetailmsg());
            //        userGoodsLmtInfo.setGoodsinsId(userGoodsLmtins.getGoodsinsId());
            //        userGoodsLmtInfo.setGoodsId(userGoodsLmt.getGoodsId());
            //        userGoodsLmtInfo.setPrcId(userGoodsLmt.getPrcId());
            //        userGoodsLmtInfo.setFunctionCode(userGoodsLmt.getFunctionCode());
            //        userGoodsLmtInfo.setBrandId(userGoodsLmt.getBrandId());

            return userGoodsLmtInfo;
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "修改家庭订购属性信息失败");
        }
    }

    @Override
    public List<UserGoodsLmtInfo> qryUserGoodsLmtInfoList(Map map) {
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
