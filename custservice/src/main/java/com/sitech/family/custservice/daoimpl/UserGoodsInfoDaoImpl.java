package com.sitech.family.custservice.daoimpl;

import com.sitech.family.common.constants.*;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.base.util.DateConst;
import com.sitech.family.custservice.daoimpl.user.IUserGoods;
import com.sitech.family.custservice.daoimpl.user.IUserGoodsRel;
import com.sitech.family.custservice.daoimpl.user.IUserPrc;
import com.sitech.family.custservice.daoimpl.user.IUserSvcTrace;
import com.sitech.family.custservice.dto.mapperdto.UserGoods;
import com.sitech.family.custservice.dto.mapperdto.UserGoodsRel;
import com.sitech.family.custservice.dto.mapperdto.UserPrc;
import com.sitech.family.custservice.dto.mapperdto.UserSvcTrace;
import com.sitech.family.dto.UpdateOprInfo;
import com.sitech.family.dao.usergoods.IUserGoodsInfoDao;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.usergoods.UserGoodsInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.DateUtil;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author wusm
 * @description
 * @date 2018/12/17 11:46
 */
@Component
public class UserGoodsInfoDaoImpl implements IUserGoodsInfoDao {

    private static Logger logger = LoggerFactory.getLogger(UserGoodsInfoDaoImpl.class);

    private final IUserGoods iUserGoods;

    private final IUserGoodsRel iUserGoodsRel;

    private final IUserSvcTrace iUserSvcTrace;

    private final IUserPrc iUserPrc;

    @Autowired
    public UserGoodsInfoDaoImpl(IUserGoods iUserGoods, IUserGoodsRel iUserGoodsRel, IUserSvcTrace iUserSvcTrace, IUserPrc iUserPrc) {
        this.iUserGoods = iUserGoods;
        this.iUserGoodsRel = iUserGoodsRel;
        this.iUserSvcTrace = iUserSvcTrace;
        this.iUserPrc = iUserPrc;
    }

    /**
     * 新增家庭商品订购信息
     *
     * @param userGoodsInfo
     */
    @Override
    public ReturnDto create(UserGoodsInfo userGoodsInfo) {
        ReturnDto returnDto;

        try {

            //用户商品订购实例 判断 商品GOODS_ID<>null && 定价PRC_ID<>null
            if (StringUtil.isNotEmptyOrNull(userGoodsInfo.getGoodsId()) &&
                    StringUtil.isNotEmptyOrNull(userGoodsInfo.getPrcId())) {
                UserGoods userGoods = new UserGoods();

                userGoods.setGoodsinsId(userGoodsInfo.getInsValue());//商品订购实例ID 非空 序列

                userGoods.setCancleSource(SourceCodeEnum.VAL_03.getValue());//退订渠道 定义枚举值 可空
                userGoods.setOrderSource(SourceCodeEnum.VAL_02.getValue());//订购渠道 定义枚举值 可空
                //生效状态 定义枚举值 非空
                if (StateEnum.VAL_A.getValue().equals(userGoodsInfo.getState())) {
                    userGoods.setFinishFlag(FinishFlagEnum.VAL_Y.getValue());
                } else {
                    userGoods.setFinishFlag(FinishFlagEnum.VAL_N.getValue());
                }
                userGoods.setState(userGoodsInfo.getState());//状态 非空
                userGoods.setStateDate(userGoodsInfo.getStateDate());//状态变更时间 非空
                userGoods.setDataOpsource("0");//数据操作来源 可空
                userGoods.setDevelopLogin("0");//发展人工号 非空
                userGoods.setOrderLoginno("0");//订购工号 可空
                userGoods.setParprcId("0");//父级定价ID 可空
                userGoods.setRelgoodsinsId(BigDecimal.valueOf(0));//父级商品订购实例标识 非空
                userGoods.setServOrderId("0");//订单行编号 非空
                userGoods.setTrangoodsinsId(BigDecimal.valueOf(0));//转移计划商品订购实例标识 非空
                userGoods.setEffDate(userGoodsInfo.getExpDate());
                userGoods.setExpDate(userGoodsInfo.getExpDate());
                userGoods.setGoodsId(userGoodsInfo.getGoodsId());
                userGoods.setGoodsMainFlag(userGoodsInfo.getMainFlag());
                userGoods.setIdNo(userGoodsInfo.getIdNo());
                userGoods.setLoginAccept(userGoodsInfo.getLoginAccept());
                userGoods.setLoginNo(userGoodsInfo.getLoginNo());
                userGoods.setOpCode(userGoodsInfo.getOpCode());
                userGoods.setOpTime(userGoodsInfo.getOpTime());
                userGoods.setOrderDate(userGoodsInfo.getOrderDate());
                userGoods.setPrcId(userGoodsInfo.getPrcId());
                userGoods.setRemark(userGoodsInfo.getSystemNote());

                userGoods.setUpdateAccept(Long.valueOf(userGoodsInfo.getInsValue().toString()));
                userGoods.setUpdateCode("0");
                userGoods.setUpdateDate(0);
                userGoods.setUpdateLogin("0");
                userGoods.setUpdateTime(userGoodsInfo.getOpTime());
                userGoods.setUpdateType(UpdateTypeEnum.VAL_A.getValue());

                returnDto = iUserGoods.create(userGoods);

                if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                    returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                    returnDto.setMessage(returnDto.getMessage());
                    return returnDto;
                }

                // todo  用户商品实例关系  relationType = 1、7、8 入表  其他的不入表
                if (RelationTypeEnum.VAL_1.getValue().equals(userGoodsInfo.getRelationType()) || RelationTypeEnum.VAL_7.getValue().equals(userGoodsInfo.getRelationType()) ||
                        RelationTypeEnum.VAL_8.getValue().equals(userGoodsInfo.getRelationType())) {

                    UserGoodsRel userGoodsRel = new UserGoodsRel();
                    userGoodsRel.setGoodsinsId(userGoodsInfo.getInsValue());//商品订购实例ID 非空 序列
                    userGoodsRel.setRelopType(RelopTypeEnum.VAL_A.getValue());//关联操作类型 定义枚举值 非空
                    userGoodsRel.setServOrderId("1");//订单行编号 非空
                    userGoodsRel.setRelgoodsinsId(BigDecimal.valueOf(0));//关联商品订购实例标识 非空
                    userGoodsRel.setRemark(userGoodsInfo.getSystemNote());
                    userGoodsRel.setRelationType(userGoodsInfo.getRelationType());//关联方式 定义枚举值 非空userGoodsRel.setOpTime(userGoodsInfo.getOpTime());
                    userGoodsRel.setLoginNo(userGoodsInfo.getLoginNo());
                    userGoodsRel.setLoginAccept(userGoodsInfo.getLoginAccept());
                    userGoodsRel.setIdNo(userGoodsInfo.getIdNo());
                    userGoodsRel.setExpDate(userGoodsInfo.getExpDate());
                    userGoodsRel.setEffDate(userGoodsInfo.getExpDate());
                    userGoodsRel.setOpTime(userGoodsInfo.getOpTime());

                    userGoodsRel.setUpdateAccept(Long.valueOf(userGoodsInfo.getInsValue().toString()));
                    userGoodsRel.setUpdateCode("0");
                    userGoodsRel.setUpdateDate(0);
                    userGoodsRel.setUpdateLogin("0");
                    userGoodsRel.setUpdateTime(userGoodsInfo.getOpTime());
                    userGoodsRel.setUpdateType(UpdateTypeEnum.VAL_A.getValue());

                    returnDto = iUserGoodsRel.create(userGoodsRel);

                    if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                        returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                        returnDto.setMessage(returnDto.getMessage());
                        return returnDto;
                    }
                }

            }

            //服务实例轨迹信息 判断 服务标识SVC_ID<>null
            if (StringUtil.isNotEmptyOrNull(userGoodsInfo.getSvcId())) {
                UserSvcTrace userSvcTrace = new UserSvcTrace();

                userSvcTrace.setSvcinsId(userGoodsInfo.getInsValue());//todo 服务实例标识 非空 序列

                userSvcTrace.setSvcId(userGoodsInfo.getSvcId());
                //生效状态 定义枚举值 非空
                if (StateEnum.VAL_A.getValue().equals(userGoodsInfo.getState())) {
                    userSvcTrace.setFinishFlag(FinishFlagEnum.VAL_Y.getValue());
                } else {
                    userSvcTrace.setFinishFlag(FinishFlagEnum.VAL_N.getValue());
                }
                userSvcTrace.setState(userGoodsInfo.getState());//状态 非空
                userSvcTrace.setStateDate(userGoodsInfo.getStateDate());//状态变更时间 非空
                userSvcTrace.setServOrderId("0");//订单行编号 非空
                userSvcTrace.setSvcType("0");//服务类型 非空
                userSvcTrace.setProdprcinsId(new BigDecimal(userGoodsInfo.getOtherInsId().toString()));//产品资费实例标识 非空
                userSvcTrace.setOpCode(userGoodsInfo.getOpCode());
                userSvcTrace.setLoginNo(userGoodsInfo.getLoginNo());
                userSvcTrace.setEffDate(userGoodsInfo.getEffDate());
                userSvcTrace.setExpDate(userGoodsInfo.getExpDate());
                userSvcTrace.setIdNo(userGoodsInfo.getIdNo());
                userSvcTrace.setLoginAccept(userGoodsInfo.getLoginAccept());
                userSvcTrace.setOpTime(userGoodsInfo.getOpTime());

                userSvcTrace.setUpdateAccept(Long.valueOf(userGoodsInfo.getInsValue().toString()));
                userSvcTrace.setUpdateCode("0");
                userSvcTrace.setUpdateDate(0);
                userSvcTrace.setUpdateLogin("0");
                userSvcTrace.setUpdateTime(userGoodsInfo.getOpTime());
                userSvcTrace.setUpdateType(UpdateTypeEnum.VAL_A.getValue());

                returnDto = iUserSvcTrace.create(userSvcTrace);

                if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                    returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                    returnDto.setMessage(returnDto.getMessage());
                    return returnDto;
                }
            }


            //产品资费实例 判断 定价PRC_ID<>null
            if (StringUtil.isNotEmptyOrNull(userGoodsInfo.getPrcId()) &&
                    StringUtil.isEmptyOrNull(userGoodsInfo.getGoodsId())) {
                UserPrc userPrc = new UserPrc();
                //TODO  PRC_ID对应PRICING_ID
                userPrc.setPricingId(0L);

                userPrc.setProdprcinsId(userGoodsInfo.getInsValue());//todo 产品资费实例标识 非空 序列

                userPrc.setOrderLoginno("0");//订购工号 可空
                userPrc.setCancleSource(SourceCodeEnum.VAL_02.getValue());//退订渠道 定义枚举值 可空
                userPrc.setOrderSource(SourceCodeEnum.VAL_05.getValue());//订购渠道 定义枚举值 可空
                userPrc.setFinishFlag(FinishFlagEnum.VAL_N.getValue());//生效状态	 定义枚举值 非空
                userPrc.setState(userGoodsInfo.getState());//状态 非空
                userPrc.setStateDate(userGoodsInfo.getStateDate());//状态变更时间 非空
                userPrc.setDataOpsource("0");//数据操作来源 可空
                userPrc.setServOrderId("0");//订单行编号 非空
                userPrc.setDevelopLogin("0");//发展人工号 非空
                userPrc.setParprcId("");//父级定价ID 可空
                userPrc.setProdPrcid(userGoodsInfo.getPrcId());//产品资费标识
                userPrc.setGoodsinsId(new BigDecimal(userGoodsInfo.getOtherInsId().toString()));//商品订购实例ID 非空
                userPrc.setGroupId(BigDecimal.valueOf(0));//群标识 非空
                userPrc.setRelprcinsId(BigDecimal.valueOf(0));//父级产品资费实例标识 非空
                userPrc.setTeamId(BigDecimal.valueOf(0));//组标识 非空
                userPrc.setTranprcinsId(BigDecimal.valueOf(0));//转移计划资费实例标识 非空
                userPrc.setOpCode(userGoodsInfo.getOpCode());
                userPrc.setOpTime(userGoodsInfo.getOpTime());
                userPrc.setLoginNo(userGoodsInfo.getLoginNo());
                userPrc.setRemark(userGoodsInfo.getSystemNote());
                userPrc.setOrderDate(userGoodsInfo.getOrderDate());
                userPrc.setProdMainFlag(userGoodsInfo.getMainFlag());
                userPrc.setExpDate(userGoodsInfo.getExpDate());
                userPrc.setEffDate(userGoodsInfo.getEffDate());
                userPrc.setProdId(userGoodsInfo.getProdId());//非产品受限 此值为NULL
                userPrc.setIdNo(userGoodsInfo.getIdNo());
                userPrc.setLoginAccept(userGoodsInfo.getLoginAccept());

                userPrc.setUpdateAccept(Long.valueOf(userGoodsInfo.getInsValue().toString()));
                userPrc.setUpdateCode("0");
                userPrc.setUpdateDate(0);
                userPrc.setUpdateLogin("0");
                userPrc.setUpdateTime(userGoodsInfo.getOpTime());
                userPrc.setUpdateType(UpdateTypeEnum.VAL_A.getValue());

                returnDto = iUserPrc.create(userPrc);

                if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                    returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                    returnDto.setMessage(returnDto.getMessage());
                    return returnDto;
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
     * 修改家庭商品订购信息
     *
     * @param userGoodsInfo
     */
    @Override
    public ReturnDto modify(UserGoodsInfo userGoodsInfo) {
        ReturnDto returnDto = new ReturnDto();

        try {
            UserGoods userGoods = new UserGoods();
            //userGoods.setCancleSource();
            //userGoods.setDataOpsource();
            //userGoods.setDevelopLogin();
            userGoods.setEffDate(userGoodsInfo.getEffDate());
            userGoods.setExpDate(userGoodsInfo.getExpDate());
            //userGoods.setFinishFlag();
            userGoods.setGoodsId(userGoodsInfo.getGoodsId());
            //userGoods.setGoodsinsId();
            userGoods.setGoodsMainFlag(userGoodsInfo.getMainFlag());
            userGoods.setIdNo(userGoodsInfo.getIdNo());
            userGoods.setLoginAccept(userGoodsInfo.getLoginAccept());
            userGoods.setLoginNo(userGoodsInfo.getLoginNo());
            userGoods.setOpCode(userGoodsInfo.getOpCode());
            userGoods.setOpTime(userGoodsInfo.getOpTime());
            userGoods.setOrderDate(userGoodsInfo.getOrderDate());
            //userGoods.setOrderLoginno();
            //userGoods.setOrderSource();
            //userGoods.setParprcId();
            userGoods.setPrcId(userGoodsInfo.getPrcId());
            //userGoods.setRelgoodsinsId();
            userGoods.setRemark(userGoodsInfo.getSystemNote());
            //userGoods.setServOrderId();
            //userGoods.setState();
            //userGoods.setStateDate();
            //userGoods.setTrangoodsinsId();

            returnDto = iUserGoods.modify(userGoods);

            if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage(returnDto.getMessage());
                return returnDto;
            }

            UserGoodsRel userGoodsRel = new UserGoodsRel();
            //userGoodsRel.setServOrderId();
            userGoodsRel.setRemark(userGoodsInfo.getSystemNote());
            userGoodsRel.setRelopType(userGoodsInfo.getRelopType());
            //userGoodsRel.setRelgoodsinsId();
            userGoodsRel.setRelationType(userGoodsInfo.getRelationType());
            userGoodsRel.setOpTime(userGoodsInfo.getOpTime());
            userGoodsRel.setLoginNo(userGoodsInfo.getLoginNo());
            userGoodsRel.setLoginAccept(userGoodsInfo.getLoginAccept());
            userGoodsRel.setIdNo(userGoodsInfo.getIdNo());
            //userGoodsRel.setGoodsinsId();
            userGoodsRel.setExpDate(userGoodsInfo.getExpDate());
            userGoodsRel.setEffDate(userGoodsInfo.getExpDate());

            returnDto = iUserGoodsRel.modify(userGoodsRel);

            if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage(returnDto.getMessage());
                return returnDto;
            }

            UserSvcTrace userSvcTrace = new UserSvcTrace();
            userSvcTrace.setSvcId(userGoodsInfo.getSvcId());
            //userSvcTrace.setFinishFlag();
            //userSvcTrace.setServOrderId();
            userSvcTrace.setOpCode(userGoodsInfo.getOpCode());
            userSvcTrace.setLoginNo(userGoodsInfo.getLoginNo());
            //userSvcTrace.setState();
            //userSvcTrace.setSvcType();
            userSvcTrace.setEffDate(userGoodsInfo.getEffDate());
            userSvcTrace.setExpDate(userGoodsInfo.getExpDate());
            userSvcTrace.setIdNo(userGoodsInfo.getIdNo());
            userSvcTrace.setLoginAccept(userGoodsInfo.getLoginAccept());
            userSvcTrace.setOpTime(userGoodsInfo.getOpTime());
            //userSvcTrace.setProdprcinsId();
            //userSvcTrace.setStateDate();
            //userSvcTrace.setSvcinsId();

            returnDto = iUserSvcTrace.modify(userSvcTrace);

            if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage(returnDto.getMessage());
                return returnDto;
            }

            UserPrc userPrc = new UserPrc();
            //userPrc.setOrderLoginno();
            //userPrc.setCancleSource();
            //userPrc.setOrderSource();
            //userPrc.setDataOpsource();
            userPrc.setOpCode(userGoodsInfo.getOpCode());
            userPrc.setOpTime(userGoodsInfo.getOpTime());
            userPrc.setLoginNo(userGoodsInfo.getLoginNo());
            //userPrc.setServOrderId();
            userPrc.setRemark(userGoodsInfo.getSystemNote());
            userPrc.setOrderDate(userGoodsInfo.getOrderDate());
            //userPrc.setFinishFlag();
            userPrc.setProdMainFlag(userGoodsInfo.getMainFlag());
            //userPrc.setDevelopLogin();
            //userPrc.setStateDate();
            //userPrc.setState();
            userPrc.setExpDate(userGoodsInfo.getExpDate());
            userPrc.setEffDate(userGoodsInfo.getEffDate());
            userPrc.setProdId(userGoodsInfo.getProdId());
            //userPrc.setParprcId();
            //userPrc.setProdPrcid();
            //userPrc.setGoodsinsId();
            //userPrc.setGroupId();
            userPrc.setIdNo(userGoodsInfo.getIdNo());
            userPrc.setLoginAccept(userGoodsInfo.getLoginAccept());
            //userPrc.setPricingId();
            //userPrc.setProdprcinsId();
            //userPrc.setRelprcinsId();
            //userPrc.setTeamId();
            //userPrc.setTranprcinsId();

            returnDto = iUserPrc.modify(userPrc);

            if (ReturnCode.RETURN_CODE_SUCCESS.getCode().equals(returnDto.getCode())) {
                returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
                returnDto.setMessage(returnDto.getMessage());
            }
        } catch (Exception e) {
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.toString());
            return returnDto;
        }

        return returnDto;
    }

    /**
     * 删除家庭商品订购信息
     *
     * @param userGoodsInfo
     */
    @Override
    public ReturnDto drop(UserGoodsInfo userGoodsInfo) {
        ReturnDto returnDto = new ReturnDto();

        try {
            UserGoods userGoods = new UserGoods();
            //userGoods.setGoodsinsId();

            returnDto = iUserGoods.drop(userGoods);

            if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage(returnDto.getMessage());
                return returnDto;
            }

            UserGoodsRel userGoodsRel = new UserGoodsRel();
            //userGoodsRel.setGoodsinsId();
            //userGoodsRel.setRelgoodsinsId();
            userGoodsRel.setLoginAccept(userGoodsInfo.getLoginAccept());

            returnDto = iUserGoodsRel.drop(userGoodsRel);

            if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage(returnDto.getMessage());
                return returnDto;
            }

            UserSvcTrace userSvcTrace = new UserSvcTrace();
            //userSvcTrace.setSvcinsId();

            returnDto = iUserSvcTrace.drop(userSvcTrace);

            if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                returnDto.setMessage(returnDto.getMessage());
                return returnDto;
            }

            UserPrc userPrc = new UserPrc();
            //userPrc.setProdprcinsId();

            returnDto = iUserPrc.drop(userPrc);

            if (ReturnCode.RETURN_CODE_SUCCESS.getCode().equals(returnDto.getCode())) {
                returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
                returnDto.setMessage(returnDto.getMessage());
            }
        } catch (Exception e) {
            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            returnDto.setMessage(e.toString());
            return returnDto;
        }
        return returnDto;
    }

    /**
     * 查询家庭商品订购信息
     *
     * @return userGoodsInfo
     */
    @Override
    public UserGoodsInfo query(BigDecimal goodsinsId, BigDecimal relgoodsinsId, BigDecimal svcinsId, BigDecimal prodprcinsId, Long loginAccept) {

        if (StringUtil.isEmptyOrNull(goodsinsId)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }
        if (StringUtil.isEmptyOrNull(relgoodsinsId)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }
        if (StringUtil.isEmptyOrNull(svcinsId)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }
        if (StringUtil.isEmptyOrNull(prodprcinsId)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }
        if (StringUtil.isEmptyOrNull(loginAccept)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }
        try {
            /**
             * 用户商品订购实例信息查询
             */
            UserGoods userGoods = new UserGoods();
            //userGoods.setGoodsinsId();

            userGoods = iUserGoods.query(goodsinsId);

            UserGoodsInfo userGoodsInfo = new UserGoodsInfo();

            userGoodsInfo.setIdNo(userGoods.getIdNo());
            //userGoodsInfo.setInsType();
            //userGoodsInfo.setInsValue();
            //userGoodsInfo.setParInsId();
            //userGoodsInfo.setOtherInsId();
            //userGoodsInfo.setRelInsId();
            userGoodsInfo.setMainFlag(userGoods.getGoodsMainFlag());
            userGoodsInfo.setGoodsId(userGoods.getGoodsId());
            userGoodsInfo.setPrcId(userGoods.getPrcId());
            userGoodsInfo.setEffDate(userGoods.getEffDate());
            userGoodsInfo.setExpDate(userGoods.getExpDate());
            userGoodsInfo.setOrderDate(userGoods.getOrderDate());
            userGoodsInfo.setOpTime(userGoods.getOpTime());
            userGoodsInfo.setOpCode(userGoods.getOpCode());
            userGoodsInfo.setLoginNo(userGoods.getLoginNo());
            //userGoodsInfo.setOupAccept();
            userGoodsInfo.setLoginAccept(userGoods.getLoginAccept());
            //userGoodsInfo.setOpNote();
            userGoodsInfo.setSystemNote(userGoods.getRemark());

            /**
             *查询用户商品实例关系
             */
            UserGoodsRel userGoodsRel = new UserGoodsRel();
            //userGoodsRel.setGoodsinsId();
            //userGoodsRel.setRelgoodsinsId();

            userGoodsRel = iUserGoodsRel.query(goodsinsId, relgoodsinsId, loginAccept);

            userGoodsInfo.setRelopType(userGoodsRel.getRelopType());
            userGoodsInfo.setRelationType(userGoodsRel.getRelationType());

            /**
             * 查询服务实例轨迹信息
             */
            UserSvcTrace userSvcTrace = new UserSvcTrace();
            //userSvcTrace.setSvcinsId();

            userSvcTrace = iUserSvcTrace.query(svcinsId);

            userGoodsInfo.setSvcId(userSvcTrace.getSvcId());

            /**
             * 查询用户订购产品资费实例信息
             */
            UserPrc userPrc = new UserPrc();
            //userPrc.setProdprcinsId();

            userPrc = iUserPrc.query(prodprcinsId);

            userGoodsInfo.setProdId(userPrc.getProdId());

            return userGoodsInfo;

        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "查询家庭商品订购信息失败");
        }
    }

    @Override
    public List<UserGoodsInfo> qryUserGoodsInfoList(Map map) {
        if (StringUtil.isEmptyOrNull(map)) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败,参数对象不存在或为空!");
        }

        List<UserGoodsInfo> userGoodsInfoList = new ArrayList<UserGoodsInfo>();
        try {
            List<UserGoods> userGoodsList = iUserGoods.qryUserGoodsList(map);

            if (StringUtil.isNotEmptyOrNull(userGoodsList)) {
                for (UserGoods userGoods : userGoodsList) {
                    UserGoodsInfo userGoodsInfo = new UserGoodsInfo();
                    userGoodsInfo.setOpNote("1");
                    userGoodsInfo.setOupAccept("1");
                    userGoodsInfo.setRelInsId(1L);
                    userGoodsInfo.setOtherInsId(null);
                    userGoodsInfo.setParInsId(null);
                    userGoodsInfo.setInsValue(userGoods.getGoodsinsId());
                    userGoodsInfo.setInsType(InsTypeEnum.VAL_1.getValue());
                    userGoodsInfo.setIdNo(userGoods.getIdNo());
                    userGoodsInfo.setProdId("1");
                    userGoodsInfo.setRelationType(RelationTypeEnum.VAL_7.getValue());
                    userGoodsInfo.setRelopType(RelopTypeEnum.VAL_A.getValue());
                    userGoodsInfo.setLoginAccept(userGoods.getLoginAccept());
                    userGoodsInfo.setOpCode(userGoods.getOpCode());
                    userGoodsInfo.setOpTime(userGoods.getOpTime());
                    userGoodsInfo.setLoginNo(userGoods.getLoginNo());
                    userGoodsInfo.setSystemNote("1");
                    userGoodsInfo.setGoodsId(userGoods.getGoodsId());
                    userGoodsInfo.setOrderDate(userGoods.getOrderDate());
                    userGoodsInfo.setMainFlag(userGoods.getGoodsMainFlag());
                    userGoodsInfo.setStateDate(userGoods.getStateDate());
                    userGoodsInfo.setExpDate(userGoods.getExpDate());
                    userGoodsInfo.setEffDate(userGoods.getEffDate());

                    userGoodsInfoList.add(userGoodsInfo);
                }
            }

            List<UserSvcTrace> userSvcTraceList = iUserSvcTrace.qryUserSvcTraceInfoList(map);

            if (StringUtil.isNotEmptyOrNull(userSvcTraceList)) {
                for (UserSvcTrace userSvcTrace : userSvcTraceList) {
                    UserGoodsInfo userGoodsInfo = new UserGoodsInfo();
                    userGoodsInfo.setSvcId(userSvcTrace.getSvcId());
                    userGoodsInfo.setOpNote("1");
                    userGoodsInfo.setOupAccept("1");
                    userGoodsInfo.setRelInsId(1L);
                    userGoodsInfo.setOtherInsId(null);
                    userGoodsInfo.setParInsId(null);
                    userGoodsInfo.setInsValue(userSvcTrace.getSvcinsId());
                    userGoodsInfo.setInsType(InsTypeEnum.VAL_3.getValue());
                    userGoodsInfo.setIdNo(userSvcTrace.getIdNo());
                    userGoodsInfo.setProdId("1");
                    userGoodsInfo.setRelationType(RelationTypeEnum.VAL_7.getValue());
                    userGoodsInfo.setRelopType(RelopTypeEnum.VAL_A.getValue());
                    userGoodsInfo.setLoginAccept(userSvcTrace.getLoginAccept());
                    userGoodsInfo.setOpCode(userSvcTrace.getOpCode());
                    userGoodsInfo.setOpTime(userSvcTrace.getOpTime());
                    userGoodsInfo.setLoginNo(userSvcTrace.getLoginNo());
                    userGoodsInfo.setSystemNote("1");
                    userGoodsInfo.setOrderDate(userSvcTrace.getOpTime());
                    userGoodsInfo.setMainFlag("1");
                    userGoodsInfo.setStateDate(userSvcTrace.getStateDate());
                    userGoodsInfo.setExpDate(userSvcTrace.getExpDate());
                    userGoodsInfo.setEffDate(userSvcTrace.getEffDate());

                    userGoodsInfoList.add(userGoodsInfo);
                }
            }

            List<UserPrc> userPrcList = iUserPrc.qryUserPrcInfoList(map);

            if (StringUtil.isNotEmptyOrNull(userPrcList)) {
                for (UserPrc userPrc : userPrcList) {
                    UserGoodsInfo userGoodsInfo = new UserGoodsInfo();
                    userGoodsInfo.setPrcId(String.valueOf(userPrc.getPricingId()));
                    userGoodsInfo.setOpNote("1");
                    userGoodsInfo.setOupAccept("1");
                    userGoodsInfo.setRelInsId(1L);
                    userGoodsInfo.setOtherInsId(null);
                    userGoodsInfo.setParInsId(null);
                    userGoodsInfo.setInsValue(userPrc.getGoodsinsId());
                    userGoodsInfo.setInsType(InsTypeEnum.VAL_2.getValue());
                    userGoodsInfo.setIdNo(userPrc.getIdNo());
                    userGoodsInfo.setProdId("1");
                    userGoodsInfo.setRelationType(RelationTypeEnum.VAL_7.getValue());
                    userGoodsInfo.setRelopType(RelopTypeEnum.VAL_A.getValue());
                    userGoodsInfo.setLoginAccept(userPrc.getLoginAccept());
                    userGoodsInfo.setOpCode(userPrc.getOpCode());
                    userGoodsInfo.setOpTime(userPrc.getOpTime());
                    userGoodsInfo.setLoginNo(userPrc.getLoginNo());
                    userGoodsInfo.setSystemNote("1");
                    userGoodsInfo.setOrderDate(userPrc.getOpTime());
                    userGoodsInfo.setMainFlag("1");
                    userGoodsInfo.setStateDate(userPrc.getStateDate());
                    userGoodsInfo.setExpDate(userPrc.getExpDate());
                    userGoodsInfo.setEffDate(userPrc.getEffDate());

                    userGoodsInfoList.add(userGoodsInfo);
                }
            }

            return userGoodsInfoList;
        } catch (Exception e) {
            return new ArrayList<UserGoodsInfo>();
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
            String state = StateEnum.VAL_A.getValue();
            String finishFlag = FinishFlagEnum.VAL_Y.getValue();

            UserGoods userGoods = new UserGoods();
            userGoods.setIdNo(idNo);
            userGoods.setState(state);
            userGoods.setStateDate(DateUtil.toDate(updateOprInfo.getCreateTime(), DateConst.DATE_MODEL_8));
            userGoods.setFinishFlag(finishFlag);
            userGoods.setOpTime(DateUtil.toDate(updateOprInfo.getCreateTime(), DateConst.DATE_MODEL_8));
            userGoods.setLoginNo(updateOprInfo.getLoginNo());
            userGoods.setOpCode(updateOprInfo.getOpCode());
            userGoods.setLoginAccept(Long.valueOf(updateOprInfo.getLoginAccept()));

            returnDto = iUserGoods.updateFinishState(userGoods);

            if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
            }

            UserSvcTrace userSvcTrace = new UserSvcTrace();
            userSvcTrace.setIdNo(idNo);
            userSvcTrace.setState(state);
            userSvcTrace.setStateDate(DateUtil.toDate(updateOprInfo.getCreateTime(), DateConst.DATE_MODEL_8));
            userSvcTrace.setFinishFlag(finishFlag);
            userSvcTrace.setOpTime(DateUtil.toDate(updateOprInfo.getCreateTime(), DateConst.DATE_MODEL_8));
            userSvcTrace.setLoginNo(updateOprInfo.getLoginNo());
            userSvcTrace.setOpCode(updateOprInfo.getOpCode());
            userSvcTrace.setLoginAccept(Long.valueOf(updateOprInfo.getLoginAccept()));

            returnDto = iUserSvcTrace.updateFinishState(userSvcTrace);

            if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
            }

            UserPrc userPrc = new UserPrc();
            userPrc.setIdNo(idNo);
            userPrc.setState(state);
            userPrc.setStateDate(DateUtil.toDate(updateOprInfo.getCreateTime(), DateConst.DATE_MODEL_8));
            userPrc.setFinishFlag(finishFlag);
            userPrc.setOpTime(DateUtil.toDate(updateOprInfo.getCreateTime(), DateConst.DATE_MODEL_8));
            userPrc.setLoginNo(updateOprInfo.getLoginNo());
            userPrc.setOpCode(updateOprInfo.getOpCode());
            userPrc.setLoginAccept(Long.valueOf(updateOprInfo.getLoginAccept()));

            returnDto = iUserPrc.updateFinishState(userPrc);
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
