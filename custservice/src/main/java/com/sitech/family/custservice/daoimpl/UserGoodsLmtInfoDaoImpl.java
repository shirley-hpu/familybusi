package com.sitech.family.custservice.daoimpl;

import com.sitech.family.common.constants.UpdateTypeEnum;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.daoimpl.user.IUser;
import com.sitech.family.custservice.daoimpl.user.IUserGoodsLmt;
import com.sitech.family.custservice.daoimpl.user.IUserGoodsLmtinsRel;
import com.sitech.family.custservice.dto.mapperdto.UserGoodsLmt;
import com.sitech.family.custservice.dto.mapperdto.UserGoodsLmtins;
import com.sitech.family.dao.usergoods.IUserGoodsLmtInfoDao;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.usergoods.UserGoodsLmtInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * 家庭用户受限信息
 *
 * @author shirley
 * @date created in 2018/12/14
 */
@Component
public class UserGoodsLmtInfoDaoImpl implements IUserGoodsLmtInfoDao {

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

    @Autowired
    private IUser iUser;

    @Override
    public ReturnDto create(UserGoodsLmtInfo userGoodsLmtInfoDto) {
        if (StringUtil.isEmptyOrNull(userGoodsLmtInfoDto)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }

        ReturnDto returnDto = new ReturnDto();
        try {
            UserGoodsLmt userGoodsLmt = new UserGoodsLmt();
            userGoodsLmt.setLimitinsId(userGoodsLmtInfoDto.getLimitinsId());
            userGoodsLmt.setIdNo(userGoodsLmtInfoDto.getIdNo());
            userGoodsLmt.setRuleId(userGoodsLmtInfoDto.getRuleId());
            userGoodsLmt.setRemark(userGoodsLmtInfoDto.getOpNote());
            userGoodsLmt.setOpTime(userGoodsLmtInfoDto.getOpTime());
            userGoodsLmt.setOpCode(userGoodsLmtInfoDto.getOpCode());
            userGoodsLmt.setMixValue(userGoodsLmtInfoDto.getMinValue());
            userGoodsLmt.setMaxValue(userGoodsLmtInfoDto.getMaxValue());
            userGoodsLmt.setLoginNo(userGoodsLmtInfoDto.getLoginNo());
            userGoodsLmt.setLoginAccept(userGoodsLmtInfoDto.getLoginAccept());
            userGoodsLmt.setLimitType(userGoodsLmtInfoDto.getLimitType());
            userGoodsLmt.setLimitLevelId(userGoodsLmtInfoDto.getLimitLevel());
            userGoodsLmt.setLimitFlag(userGoodsLmtInfoDto.getLimitFlag());
            userGoodsLmt.setLimitDetailmsg(userGoodsLmtInfoDto.getLimitDetailMsg());
            userGoodsLmt.setExpDate(userGoodsLmtInfoDto.getExpDate());
            userGoodsLmt.setEffDate(userGoodsLmtInfoDto.getEffDate());
            userGoodsLmt.setBrandId("1");
            userGoodsLmt.setPrcId("1");
            userGoodsLmt.setGoodsId("1");
            userGoodsLmt.setFunctionCode("1");

            userGoodsLmt.setUpdateAccept(new Random().nextLong());
            userGoodsLmt.setUpdateCode("1");
            userGoodsLmt.setUpdateDate(1);
            userGoodsLmt.setUpdateLogin("1");
            userGoodsLmt.setUpdateTime(userGoodsLmtInfoDto.getOpTime());
            userGoodsLmt.setUpdateType(UpdateTypeEnum.VAL_A.getValue());

            returnDto = userGoodsLmtImpl.create(userGoodsLmt);

            if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage(returnDto.getMessage());
                return returnDto;
            }

            //商品订购实例与受限实例关系
            UserGoodsLmtins userGoodsLmtins = new UserGoodsLmtins();
            userGoodsLmtins.setIdNo(userGoodsLmtInfoDto.getIdNo());
            userGoodsLmtins.setLoginAccept(userGoodsLmtInfoDto.getLoginAccept());
            userGoodsLmtins.setExpDate(userGoodsLmtInfoDto.getExpDate());
            userGoodsLmtins.setEffDate(userGoodsLmtInfoDto.getEffDate());
            userGoodsLmtins.setLimitinsId(userGoodsLmtInfoDto.getLimitinsId());
            userGoodsLmtins.setLoginNo(userGoodsLmtInfoDto.getLoginNo());
            userGoodsLmtins.setOpCode(userGoodsLmtInfoDto.getOpCode());
            userGoodsLmtins.setOpTime(userGoodsLmtInfoDto.getOpTime());
            userGoodsLmtins.setGoodsinsId(new BigDecimal("1"));
            userGoodsLmtins.setUpdateAccept(new Random().nextLong());
            userGoodsLmtins.setUpdateCode("1");
            userGoodsLmtins.setUpdateDate(1);
            userGoodsLmtins.setUpdateLogin("1");
            userGoodsLmtins.setUpdateTime(userGoodsLmtInfoDto.getOpTime());
            userGoodsLmtins.setUpdateType(UpdateTypeEnum.VAL_A.getValue());

            userGoodsLmtinsRelImpl.create(userGoodsLmtins);
        } catch (Exception e) {
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.getMessage());
            return returnDto;
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    @Override
    public ReturnDto modify(UserGoodsLmtInfo userGoodsLmtInfoDto) {
        if (StringUtil.isEmptyOrNull(userGoodsLmtInfoDto)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }

        ReturnDto returnDto = new ReturnDto();
        try {
            //用户商品受限
            UserGoodsLmt userGoodsLmt = new UserGoodsLmt();
            userGoodsLmt.setIdNo(userGoodsLmtInfoDto.getIdNo());
            userGoodsLmt.setRuleId(userGoodsLmtInfoDto.getRuleId());
            userGoodsLmt.setRemark(userGoodsLmtInfoDto.getOpNote());
            userGoodsLmt.setOpTime(userGoodsLmtInfoDto.getOpTime());
            userGoodsLmt.setOpCode(userGoodsLmtInfoDto.getOpCode());
            userGoodsLmt.setMixValue(userGoodsLmtInfoDto.getMinValue());
            userGoodsLmt.setMaxValue(userGoodsLmtInfoDto.getMaxValue());
            userGoodsLmt.setLoginNo(userGoodsLmtInfoDto.getLoginNo());
            userGoodsLmt.setLoginAccept(userGoodsLmtInfoDto.getLoginAccept());
            userGoodsLmt.setLimitType(userGoodsLmtInfoDto.getLimitType());
            userGoodsLmt.setLimitLevelId(userGoodsLmtInfoDto.getLimitLevel());
            userGoodsLmt.setLimitinsId(userGoodsLmtInfoDto.getLimitinsId());
            userGoodsLmt.setLimitFlag(userGoodsLmtInfoDto.getLimitFlag());
            userGoodsLmt.setLimitDetailmsg(userGoodsLmtInfoDto.getLimitDetailMsg());
            userGoodsLmt.setExpDate(userGoodsLmtInfoDto.getExpDate());
            userGoodsLmt.setEffDate(userGoodsLmtInfoDto.getEffDate());
            userGoodsLmt.setBrandId("1");
            userGoodsLmt.setPrcId("1");
            userGoodsLmt.setGoodsId("1");
            userGoodsLmt.setFunctionCode("1");

            userGoodsLmt.setUpdateAccept(new Random().nextLong());
            userGoodsLmt.setUpdateCode("1");
            userGoodsLmt.setUpdateDate(1);
            userGoodsLmt.setUpdateLogin("1");
            userGoodsLmt.setUpdateTime(userGoodsLmtInfoDto.getOpTime());
            userGoodsLmt.setUpdateType(UpdateTypeEnum.VAL_U.getValue());

            returnDto = userGoodsLmtImpl.modify(userGoodsLmt);

            if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage(returnDto.getMessage());
                return returnDto;
            }

            //商品订购实例与受限实例关系
            UserGoodsLmtins userGoodsLmtins = new UserGoodsLmtins();
            userGoodsLmtins.setIdNo(userGoodsLmtInfoDto.getIdNo());
            userGoodsLmtins.setLoginAccept(userGoodsLmtInfoDto.getLoginAccept());
            userGoodsLmtins.setExpDate(userGoodsLmtInfoDto.getExpDate());
            userGoodsLmtins.setEffDate(userGoodsLmtInfoDto.getEffDate());
            userGoodsLmtins.setLimitinsId(userGoodsLmtInfoDto.getLimitinsId());
            userGoodsLmtins.setLoginNo(userGoodsLmtInfoDto.getLoginNo());
            userGoodsLmtins.setOpCode(userGoodsLmtInfoDto.getOpCode());
            userGoodsLmtins.setOpTime(userGoodsLmtInfoDto.getOpTime());
            userGoodsLmtins.setGoodsinsId(new BigDecimal("1"));
            userGoodsLmtins.setUpdateAccept(new Random().nextLong());
            userGoodsLmtins.setUpdateCode("1");
            userGoodsLmtins.setUpdateDate(1);
            userGoodsLmtins.setUpdateLogin("1");
            userGoodsLmtins.setUpdateTime(userGoodsLmtInfoDto.getOpTime());
            userGoodsLmtins.setUpdateType(UpdateTypeEnum.VAL_U.getValue());

            userGoodsLmtinsRelImpl.modify(userGoodsLmtins);
        } catch (Exception e) {
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.getMessage());
            return returnDto;
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    @Override
    public ReturnDto drop(UserGoodsLmtInfo userGoodsLmtInfoDto) {
        if (StringUtil.isEmptyOrNull(userGoodsLmtInfoDto)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }

        ReturnDto returnDto = new ReturnDto();
        try {
            //用户商品受限
            UserGoodsLmt userGoodsLmt = new UserGoodsLmt();
            userGoodsLmt.setLimitinsId(userGoodsLmtInfoDto.getLimitinsId());
            userGoodsLmt.setUpdateAccept(new Random().nextLong());
            userGoodsLmt.setUpdateCode("1");
            userGoodsLmt.setUpdateDate(1);
            userGoodsLmt.setUpdateLogin("1");
            userGoodsLmt.setUpdateTime(userGoodsLmtInfoDto.getOpTime());
            userGoodsLmt.setUpdateType(UpdateTypeEnum.VAL_D.getValue());
            returnDto = userGoodsLmtImpl.drop(userGoodsLmt);

            if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage(returnDto.getMessage());
                return returnDto;
            }

            //商品订购实例与受限实例关系
            UserGoodsLmtins userGoodsLmtins = new UserGoodsLmtins();
            userGoodsLmtins.setLimitinsId(userGoodsLmtInfoDto.getLimitinsId());
            userGoodsLmtins.setGoodsinsId(new BigDecimal("1"));
            userGoodsLmtins.setUpdateCode("1");
            userGoodsLmtins.setUpdateDate(1);
            userGoodsLmtins.setUpdateLogin("1");
            userGoodsLmtins.setUpdateTime(userGoodsLmtInfoDto.getOpTime());
            userGoodsLmtins.setUpdateType(UpdateTypeEnum.VAL_D.getValue());
            userGoodsLmtinsRelImpl.drop(userGoodsLmtins);

        } catch (Exception e) {
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.getMessage());
            return returnDto;
        }

        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    @Override
    public UserGoodsLmtInfo query(BigDecimal limitinsId, BigDecimal goodsinsId) {

        if (StringUtil.isEmptyOrNull(limitinsId) || StringUtil.isEmptyOrNull(goodsinsId)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }

        try {
            // 1、查询 用户商品受限实例
            UserGoodsLmt userGoodsLmt = userGoodsLmtImpl.query(limitinsId);

            // 2、查询 商品订购实例与受限实例
            UserGoodsLmtins userGoodsLmtins = userGoodsLmtinsRelImpl.query(limitinsId, goodsinsId);

            // 3、拼接出参对象实例
            UserGoodsLmtInfo userGoodsLmtInfo = new UserGoodsLmtInfo();
            userGoodsLmtInfo.setLimitinsId(userGoodsLmt.getLimitinsId());
            userGoodsLmtInfo.setIdNo(userGoodsLmt.getIdNo());
            userGoodsLmtInfo.setBusiType("1");
            userGoodsLmtInfo.setLimitType(userGoodsLmt.getLimitType());
            userGoodsLmtInfo.setRuleId(userGoodsLmt.getRuleId());
            userGoodsLmtInfo.setEffDate(userGoodsLmt.getEffDate());
            userGoodsLmtInfo.setExpDate(userGoodsLmt.getExpDate());
            userGoodsLmtInfo.setBusiInfoValue("1");
            userGoodsLmtInfo.setLimitLevel(userGoodsLmt.getLimitLevelId());
            userGoodsLmtInfo.setLimitFlag(userGoodsLmt.getLimitFlag());
            userGoodsLmtInfo.setMaxValue(userGoodsLmt.getMaxValue());
            userGoodsLmtInfo.setMinValue(userGoodsLmt.getMixValue());
            userGoodsLmtInfo.setLoginNo(userGoodsLmt.getLoginNo());
            userGoodsLmtInfo.setLoginAccept(userGoodsLmt.getLoginAccept());
            userGoodsLmtInfo.setOpTime(userGoodsLmt.getOpTime());
            userGoodsLmtInfo.setOpCode(userGoodsLmt.getOpCode());
            userGoodsLmtInfo.setOupAccept("1");
            userGoodsLmtInfo.setOpNote("1");
            userGoodsLmtInfo.setSystemNote("1");
            userGoodsLmtInfo.setLimitDetailMsg(userGoodsLmt.getLimitDetailmsg());

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
