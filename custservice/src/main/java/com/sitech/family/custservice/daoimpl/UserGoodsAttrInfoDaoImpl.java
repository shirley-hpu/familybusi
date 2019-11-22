package com.sitech.family.custservice.daoimpl;

import com.sitech.family.common.constants.FinishFlagEnum;
import com.sitech.family.common.constants.InsTypeEnum;
import com.sitech.family.common.constants.StateEnum;
import com.sitech.family.common.constants.UpdateTypeEnum;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.base.util.DateConst;
import com.sitech.family.custservice.daoimpl.user.*;
import com.sitech.family.custservice.dto.mapperdto.UserGoods;
import com.sitech.family.custservice.dto.mapperdto.UserGoodsAttr;
import com.sitech.family.custservice.dto.mapperdto.UserPrc;
import com.sitech.family.custservice.dto.mapperdto.UserSvcAttrTrace;
import com.sitech.family.dao.usergoods.IUserGoodsAttrInfoDao;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.UpdateOprInfo;
import com.sitech.family.dto.usergoods.UserGoodsAttrInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.DateUtil;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author wusm
 * @description
 * @date 2018/12/17 14:30
 */
@Component
public class UserGoodsAttrInfoDaoImpl implements IUserGoodsAttrInfoDao {

    private static Logger logger = LoggerFactory.getLogger(UserGoodsAttrInfoDaoImpl.class);

    private final IUserSvcAttrTrace iUserSvcAttrTrace;

    private final IUserGoodsAttr iUserGoodsAttr;

    private final IUserGoods iUserGoods;

    private final IUserPrc iUserPrc;

    @Autowired
    public UserGoodsAttrInfoDaoImpl(IUserSvcAttrTrace iUserSvcAttrTrace, IUserGoodsAttr iUserGoodsAttr, IUserGoods iUserGoods, IUserSvcTrace iUserSvcTrace, IUserPrc iUserPrc) {
        this.iUserSvcAttrTrace = iUserSvcAttrTrace;
        this.iUserGoodsAttr = iUserGoodsAttr;
        this.iUserGoods = iUserGoods;
        this.iUserPrc = iUserPrc;
    }

    /**
     * 新增家庭订购属性信息
     *
     * @param userGoodsAttrInfo
     */
    @Override
    public ReturnDto create(UserGoodsAttrInfo userGoodsAttrInfo) {
        ReturnDto returnDto;

        try {

            //服务属性实例 判断InsType=3
            if (InsTypeEnum.VAL_3.getValue().equals(userGoodsAttrInfo.getInsType())) {
                UserSvcAttrTrace userSvcAttrTrace = new UserSvcAttrTrace();

                //根据服务订购实例记录主键获取对应记录
                //UserSvcTrace userSvcTrace = iUserSvcTrace.query(new BigDecimal(userGoodsAttrInfo.getInsValue()));
                userSvcAttrTrace.setSvcinsId(new BigDecimal(userGoodsAttrInfo.getInsValue()));//TODO 服务实例标识 非空 如何传入？

                //生效状态 定义枚举值 非空
                if (StateEnum.VAL_A.getValue().equals(userGoodsAttrInfo.getState())) {
                    userSvcAttrTrace.setFinishFlag(FinishFlagEnum.VAL_Y.getValue());
                } else {
                    userSvcAttrTrace.setFinishFlag(FinishFlagEnum.VAL_N.getValue());
                }
                userSvcAttrTrace.setIdNo(userGoodsAttrInfo.getIdNo());//用户标识 非空
                userSvcAttrTrace.setServOrderId("1");//订单行编号 非空
                userSvcAttrTrace.setSvcId(userGoodsAttrInfo.getInsType());//服务标识 非空
                userSvcAttrTrace.setAttrId(userGoodsAttrInfo.getAttrId());
                userSvcAttrTrace.setAttrNo(userGoodsAttrInfo.getAttrNo());
                userSvcAttrTrace.setEffDate(userGoodsAttrInfo.getEffDate());
                userSvcAttrTrace.setAttrValue(userGoodsAttrInfo.getAttrValue());
                userSvcAttrTrace.setExpDate(userGoodsAttrInfo.getExpDate());
                userSvcAttrTrace.setGrpNo(userGoodsAttrInfo.getGrpNo());
                userSvcAttrTrace.setLoginAccept(userGoodsAttrInfo.getLoginAccept());
                userSvcAttrTrace.setLoginNo(userGoodsAttrInfo.getLoginNo());
                userSvcAttrTrace.setOpCode(userGoodsAttrInfo.getOpCode());
                userSvcAttrTrace.setOpTime(userGoodsAttrInfo.getOpTime());

                userSvcAttrTrace.setUpdateAccept(Long.valueOf(userGoodsAttrInfo.getInsValue()));
                userSvcAttrTrace.setUpdateCode("1");
                userSvcAttrTrace.setUpdateDate(1);
                userSvcAttrTrace.setUpdateLogin("1");
                userSvcAttrTrace.setUpdateTime(userGoodsAttrInfo.getOpTime());
                userSvcAttrTrace.setUpdateType(UpdateTypeEnum.VAL_A.getValue());

                returnDto = iUserSvcAttrTrace.create(userSvcAttrTrace);

                if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                    returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                    returnDto.setMessage(returnDto.getMessage());
                }
            }

            //商品定价属性实例 判断InsType=1或2
            if (InsTypeEnum.VAL_1.getValue().equals(userGoodsAttrInfo.getInsType()) ||
                    InsTypeEnum.VAL_2.getValue().equals(userGoodsAttrInfo.getInsType())) {
                UserGoodsAttr userGoodsAttr = new UserGoodsAttr();

                //根据服务订购实例记录主键获取对应记录
                String prcId = null;

                if (InsTypeEnum.VAL_1.getValue().equals(userGoodsAttrInfo.getInsType())) {
                    UserGoods userGoods = iUserGoods.query(new BigDecimal(userGoodsAttrInfo.getInsValue()));
                    prcId = userGoods.getPrcId();
                } else if (InsTypeEnum.VAL_2.getValue().equals(userGoodsAttrInfo.getInsType())) {
                    UserPrc userPrc = iUserPrc.query(new BigDecimal(userGoodsAttrInfo.getInsValue()));
                    prcId = userPrc.getPricingId().toString();
                }

                userGoodsAttr.setGoodsinsId(new BigDecimal(userGoodsAttrInfo.getInsValue()));//TODO 商品订购实例标识 非空 如何传入？
                userGoodsAttr.setPrcId(prcId);//TODO 定价标识 非空 如何传入？

                userGoodsAttr.setAttrId(userGoodsAttrInfo.getAttrId());
                userGoodsAttr.setAttrNo(userGoodsAttrInfo.getAttrNo());
                userGoodsAttr.setGrpNo(userGoodsAttrInfo.getGrpNo());
                userGoodsAttr.setAttrValue(userGoodsAttrInfo.getAttrValue());
                userGoodsAttr.setIdNo(userGoodsAttrInfo.getIdNo());
                userGoodsAttr.setEffDate(userGoodsAttrInfo.getEffDate());
                userGoodsAttr.setExpDate(userGoodsAttrInfo.getExpDate());
                userGoodsAttr.setLoginNo(userGoodsAttrInfo.getLoginNo());
                userGoodsAttr.setLoginAccept(userGoodsAttrInfo.getLoginAccept());
                userGoodsAttr.setOpTime(userGoodsAttrInfo.getOpTime());
                userGoodsAttr.setOpCode(userGoodsAttrInfo.getOpCode());
                if (StateEnum.VAL_A.getValue().equals(userGoodsAttrInfo.getState())) {
                    userGoodsAttr.setFinishFlag(FinishFlagEnum.VAL_Y.getValue());
                } else {
                    userGoodsAttr.setFinishFlag(FinishFlagEnum.VAL_N.getValue());
                }
                userGoodsAttr.setServOrderId("1");//订单行编号 非空

                userGoodsAttr.setUpdateAccept(Long.valueOf(userGoodsAttrInfo.getInsValue()));
                userGoodsAttr.setUpdateCode("1");
                userGoodsAttr.setUpdateDate(1);
                userGoodsAttr.setUpdateLogin("1");
                userGoodsAttr.setUpdateTime(userGoodsAttrInfo.getOpTime());
                userGoodsAttr.setUpdateType(UpdateTypeEnum.VAL_A.getValue());

                returnDto = iUserGoodsAttr.create(userGoodsAttr);

                if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                    returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                    returnDto.setMessage(returnDto.getMessage());
                }
            }

        } catch (Exception e) {
            returnDto = new ReturnDto();
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.toString());
            return returnDto;
        }
        returnDto = new ReturnDto();
        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return returnDto;
    }

    /**
     * 修改家庭订购属性信息
     *
     * @param userGoodsAttrInfo
     */
    @Override
    public ReturnDto modify(UserGoodsAttrInfo userGoodsAttrInfo) {
        ReturnDto returnDto = new ReturnDto();

        try {
            UserSvcAttrTrace userSvcAttrTrace = new UserSvcAttrTrace();

            userSvcAttrTrace.setSvcinsId(BigDecimal.valueOf(123));
            if ("A".equals(userGoodsAttrInfo.getState())) {
                userSvcAttrTrace.setFinishFlag(FinishFlagEnum.VAL_Y.getValue());
            } else {
                userSvcAttrTrace.setFinishFlag(FinishFlagEnum.VAL_N.getValue());
            }
            userSvcAttrTrace.setIdNo(1212L);
            userSvcAttrTrace.setServOrderId("12");
            userSvcAttrTrace.setSvcId("SVCD");
            userSvcAttrTrace.setAttrId(userGoodsAttrInfo.getAttrId());
            userSvcAttrTrace.setAttrNo(userGoodsAttrInfo.getAttrNo());
            userSvcAttrTrace.setEffDate(userGoodsAttrInfo.getEffDate());
            //userSvcAttrTrace.setSvcinsId();
            userSvcAttrTrace.setAttrValue(userGoodsAttrInfo.getAttrValue());
            userSvcAttrTrace.setExpDate(userGoodsAttrInfo.getExpDate());
            //userSvcAttrTrace.setFinishFlag();
            userSvcAttrTrace.setGrpNo(userGoodsAttrInfo.getGrpNo());
            //userSvcAttrTrace.setIdNo();
            userSvcAttrTrace.setLoginAccept(userGoodsAttrInfo.getLoginAccept());
            userSvcAttrTrace.setLoginNo(userGoodsAttrInfo.getLoginNo());
            userSvcAttrTrace.setOpCode(userGoodsAttrInfo.getOpCode());
            userSvcAttrTrace.setOpTime(userGoodsAttrInfo.getOpTime());

            userSvcAttrTrace.setUpdateAccept(12345678901234567L);
            userSvcAttrTrace.setUpdateCode("code");
            userSvcAttrTrace.setUpdateDate(20190327);
            userSvcAttrTrace.setUpdateLogin("工号");
            userSvcAttrTrace.setUpdateTime(new Date());
            userSvcAttrTrace.setUpdateType("A");

            returnDto = iUserSvcAttrTrace.modify(userSvcAttrTrace);

            if (ReturnCode.RETURN_CODE_SUCCESS.getCode().equals(returnDto.getCode())) {
                returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
                returnDto.setMessage(returnDto.getMessage());
            }

            UserGoodsAttr userGoodsAttr = new UserGoodsAttr();
            userGoodsAttr.setGoodsinsId(new BigDecimal("2222"));
            userGoodsAttr.setAttrId(userGoodsAttrInfo.getAttrId());
            userGoodsAttr.setAttrNo(userGoodsAttrInfo.getAttrNo());
            userGoodsAttr.setGrpNo(userGoodsAttrInfo.getGrpNo());
            userGoodsAttr.setAttrValue(userGoodsAttrInfo.getAttrValue());
            userGoodsAttr.setPrcId("26256");
            userGoodsAttr.setIdNo(26L);
            userGoodsAttr.setEffDate(userGoodsAttrInfo.getEffDate());
            userGoodsAttr.setExpDate(userGoodsAttrInfo.getExpDate());
            userGoodsAttr.setLoginNo(userGoodsAttrInfo.getLoginNo());
            userGoodsAttr.setLoginAccept(userGoodsAttrInfo.getLoginAccept());
            userGoodsAttr.setOpTime(userGoodsAttrInfo.getOpTime());
            userGoodsAttr.setOpCode(userGoodsAttrInfo.getOpCode());
            if ("A".equals(userGoodsAttrInfo.getState())) {
                userGoodsAttr.setFinishFlag(FinishFlagEnum.VAL_Y.getValue());
            } else {
                userGoodsAttr.setFinishFlag(FinishFlagEnum.VAL_N.getValue());
            }
            userGoodsAttr.setServOrderId("2626");

            userGoodsAttr.setUpdateAccept(12345678901234567L);
            userGoodsAttr.setUpdateCode("code");
            userGoodsAttr.setUpdateDate(20190327);
            userGoodsAttr.setUpdateLogin("工号");
            userGoodsAttr.setUpdateTime(new Date());
            userGoodsAttr.setUpdateType("A");

            returnDto = iUserGoodsAttr.modify(userGoodsAttr);

            if (ReturnCode.RETURN_CODE_SUCCESS.getCode().equals(returnDto.getCode())) {
                returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
                returnDto.setMessage(returnDto.getMessage());
            }
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "修改家庭订购属性信息失败");
        }

        return returnDto;
    }

    /**
     * 删除家庭订购属性信息
     *
     * @param userGoodsAttrInfo
     */
    @Override
    public ReturnDto drop(UserGoodsAttrInfo userGoodsAttrInfo) {
        return null;
    }


    /**
     * 查询家庭订购属性信息
     *
     * @return userGoodsAttrInfo
     */
    @Override
    public UserGoodsAttrInfo query(BigDecimal goodsinsId, BigDecimal svcinsId, String attrId, String attrNo, Date effDate) {
        UserGoodsAttrInfo userGoodsAttrInfo = new UserGoodsAttrInfo();

        try {
            UserSvcAttrTrace userSvcAttrTrace = iUserSvcAttrTrace.query(svcinsId, attrId, attrNo, effDate);

            UserGoodsAttr userGoodsAttr = iUserGoodsAttr.query(goodsinsId, attrId, attrNo, effDate);

            userGoodsAttrInfo.setInsType("");
            userGoodsAttrInfo.setInsValue("");


        } catch (Exception e) {

        }


        return userGoodsAttrInfo;
    }

    @Override
    public List<UserGoodsAttrInfo> qryUserGoodsAttrInfoList(Map map) {
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

    /**
     * 根据idNo更新状态
     *
     * @param idNo
     * @return
     */
    @Override
    public ReturnDto updateFinishState(UpdateOprInfo updateOprInfo, Long idNo) {
        ReturnDto returnDto = new ReturnDto();

        try {
            String finishFlag = FinishFlagEnum.VAL_Y.getValue();

            UserGoodsAttr userGoodsAttr = new UserGoodsAttr();
            userGoodsAttr.setIdNo(idNo);
            userGoodsAttr.setFinishFlag(finishFlag);
            userGoodsAttr.setOpTime(DateUtil.toDate(updateOprInfo.getCreateTime(), DateConst.DATE_MODEL_8));
            userGoodsAttr.setLoginNo(updateOprInfo.getLoginNo());
            userGoodsAttr.setOpCode(updateOprInfo.getOpCode());
            userGoodsAttr.setLoginAccept(Long.valueOf(updateOprInfo.getLoginAccept()));

            returnDto = iUserGoodsAttr.updateFinishState(userGoodsAttr);

            UserSvcAttrTrace userSvcAttrTrace = new UserSvcAttrTrace();
            userSvcAttrTrace.setIdNo(idNo);
            userSvcAttrTrace.setFinishFlag(finishFlag);
            userSvcAttrTrace.setOpTime(DateUtil.toDate(updateOprInfo.getCreateTime(), DateConst.DATE_MODEL_8));
            userSvcAttrTrace.setLoginNo(updateOprInfo.getLoginNo());
            userSvcAttrTrace.setOpCode(updateOprInfo.getOpCode());
            userSvcAttrTrace.setLoginAccept(Long.valueOf(updateOprInfo.getLoginAccept()));

            returnDto = iUserSvcAttrTrace.updateFinishState(userSvcAttrTrace);
        } catch (Exception e) {
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.getMessage());
            return returnDto;
        }

        returnDto.setCode(returnDto.getCode());
        returnDto.setMessage(returnDto.getMessage());
        return returnDto;
    }
}
