package com.sitech.family.custservice.compbusi.impl;

import com.sitech.family.common.constants.InsTypeEnum;
import com.sitech.family.common.constants.RelationTypeEnum;
import com.sitech.family.common.constants.RelopTypeEnum;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.atombusi.*;
import com.sitech.family.custservice.base.util.BaseLoginAccept;
import com.sitech.family.custservice.base.util.DateConst;
import com.sitech.family.custservice.base.util.SequenceConst;
import com.sitech.family.custservice.compbusi.IFamilyUserGoodsCo;
import com.sitech.family.custservice.dto.commondto.OprInfo;
import com.sitech.family.common.pubdto.FamilyUserApplyInfo;
import com.sitech.family.dto.UpdateOprInfo;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.usergoods.UserGoodsAttrInfo;
import com.sitech.family.dto.usergoods.UserGoodsInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.DateUtil;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * 组合服务:用户订购关系
 *
 * @author shirley
 * @date created in 2019/2/26
 */
@Component
public class FamilyUserGoodsCo implements IFamilyUserGoodsCo {

    private static Logger logger = LoggerFactory.getLogger(FamilyUserGoodsCo.class);

    //家庭商品订购
    private final IFamilyUserGoodsInfo familyUserGoodsInfoImpl;

    private final IFamilyUserGoodsAttrInfo familyUserGoodsAttrInfoImpl;

    private BaseLoginAccept baseLoginAccept;

    @Autowired
    public FamilyUserGoodsCo(IFamilyUserGoodsInfo familyUserGoodsInfoImpl, IFamilyUserGoodsAttrInfo familyUserGoodsAttrInfoImpl, BaseLoginAccept baseLoginAccept) {
        this.familyUserGoodsInfoImpl = familyUserGoodsInfoImpl;
        this.familyUserGoodsAttrInfoImpl = familyUserGoodsAttrInfoImpl;
        this.baseLoginAccept = baseLoginAccept;
    }

    @Transactional(rollbackFor = BusiException.class)
    @Override
    public ReturnDto create(Map<String, Object> map) {

        if (StringUtil.isEmptyOrNull(map)) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "处理失败", "参数对象不存在或为空!");
        }

        try {
            // 1、获取参数节点
            String state = (String) map.get("STATE");
            OprInfo oprInfo = (OprInfo) map.get("OPR_INFO");
            FamilyUserApplyInfo userApplyInfo = (FamilyUserApplyInfo) map.get("USER_INFO");
            List<FamilyUserApplyInfo.FamilyUserGoodsInfo> familyUserGoodsInfoList = userApplyInfo.getFamilyUserGoodsInfo();

            //***** 获取序列值入参map *****//
            Map<String, String> accept = new HashMap<>();

            //循环取FamilyUserGoodsInfoList
            for (FamilyUserApplyInfo.FamilyUserGoodsInfo familyUserGoodsInfo : familyUserGoodsInfoList) {
                UserGoodsInfo userGoodsInfo = new UserGoodsInfo();
                userGoodsInfo.setMainFlag(familyUserGoodsInfo.getMainFlag());
                userGoodsInfo.setProdId(familyUserGoodsInfo.getProdId());
                userGoodsInfo.setEffDate(DateUtil.toDate(familyUserGoodsInfo.getEffDate(), DateConst.DATE_MODEL_8));
                userGoodsInfo.setExpDate(DateUtil.toDate(familyUserGoodsInfo.getExpDate(), DateConst.DATE_MODEL_8));
                userGoodsInfo.setOrderDate(DateUtil.toDate(oprInfo.getCreateTime(), DateConst.DATE_MODEL_8));//订购时间 取订单时间
                userGoodsInfo.setIdNo(Long.parseLong(userApplyInfo.getIdNo()));
                //userGoodsInfo.setParInsId(null);//父级实例标识
                userGoodsInfo.setRelopType(RelopTypeEnum.VAL_A.getValue());//关联操作类型
                userGoodsInfo.setRelationType(RelationTypeEnum.VAL_7.getValue());//关联方式
                //userGoodsInfo.setRelInsId(null);//关联实例标识
                userGoodsInfo.setOpNote(oprInfo.getOpNote());
                userGoodsInfo.setOpTime(DateUtil.toDate(oprInfo.getCreateTime(), DateConst.DATE_MODEL_8));
                userGoodsInfo.setOpCode(oprInfo.getOpCode());
                userGoodsInfo.setLoginNo(oprInfo.getLoginNo());
                userGoodsInfo.setLoginAccept(Long.parseLong(oprInfo.getLoginAccept()));
                userGoodsInfo.setSystemNote(oprInfo.getSystemNote());
                userGoodsInfo.setOupAccept(oprInfo.getOutAccept());
                userGoodsInfo.setState(state);
                userGoodsInfo.setStateDate(DateUtil.toDate(oprInfo.getCreateTime(), DateConst.DATE_MODEL_8));

                //***** 获取序列值 *****//
                //商品订购实例标识
                accept.put("ACCEPT_LABEL", SequenceConst.SEQ_FM_GOODSINS_ID);
                String goodsInsId = baseLoginAccept.getPubLoginAccept(accept);
                logger.debug("goodsInsId ==> " + goodsInsId);
                //服务订购实例标识
                accept.clear();
                accept.put("ACCEPT_LABEL", SequenceConst.SEQ_FM_SVCINSID);
                String svcInsId = baseLoginAccept.getPubLoginAccept(accept);
                logger.debug("svcInsId ==> " + svcInsId);
                //资费订购实例标识
                accept.clear();
                accept.put("ACCEPT_LABEL", SequenceConst.SEQ_FM_PRODPRCINS_ID);
                String prodPrcInsId = baseLoginAccept.getPubLoginAccept(accept);
                logger.debug("prodPrcInsId ==> " + prodPrcInsId);

                //商品订购
                if (StringUtil.isNotEmptyOrNull(familyUserGoodsInfo.getGoodsId()) &&
                        StringUtil.isNotEmptyOrNull(familyUserGoodsInfo.getPrcId())) {
                    userGoodsInfo.setGoodsId(familyUserGoodsInfo.getGoodsId());
                    userGoodsInfo.setPrcId(familyUserGoodsInfo.getPrcId());
                    userGoodsInfo.setInsType(InsTypeEnum.VAL_1.getValue());//实例分类 商品订购实例（GOODSINS_ID）
                    userGoodsInfo.setInsValue(new BigDecimal(goodsInsId));//实例标识值 序列获取
                    //userGoodsInfo.setOtherInsId(null);//其他相关实例值  ==> INS_TYPE为2时存GOODSINS_ID;为3时存PRODPRCINS_ID

                    ReturnDto returnDto = familyUserGoodsInfoImpl.create(userGoodsInfo);

                    if (!ReturnCode.RETURN_CODE_SUCCESS.getCode().equals(returnDto.getCode())) {
                        returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                        returnDto.setMessage(returnDto.getMessage());
                        return returnDto;
                    }

                    //循环取FamilyUserGoodsAttrInfoList节点
                    List<FamilyUserApplyInfo.FamilyUserGoodsAttrInfo> familyUserGoodsAttrInfoList = familyUserGoodsInfo.getFamilyUserGoodsAttrInfoList();
                    for (FamilyUserApplyInfo.FamilyUserGoodsAttrInfo familyUserGoodsAttrInfo : familyUserGoodsAttrInfoList) {
                        UserGoodsAttrInfo userGoodsAttrInfo = new UserGoodsAttrInfo();
                        userGoodsAttrInfo.setIdNo(Long.parseLong(userApplyInfo.getIdNo()));
                        userGoodsAttrInfo.setAttrId(familyUserGoodsAttrInfo.getAttrId());
                        userGoodsAttrInfo.setAttrNo(familyUserGoodsAttrInfo.getAttrNo());
                        userGoodsAttrInfo.setAttrValue(familyUserGoodsAttrInfo.getAttrValue());
                        userGoodsAttrInfo.setGrpNo(familyUserGoodsAttrInfo.getGrpNo());
                        userGoodsAttrInfo.setInsType(InsTypeEnum.VAL_1.getValue());  //1：商品订购实例标识（对应实例标识号为GOODSINS_ID） 2：服务订购实例标识 (对应实例标识号为SVCINS_ID)
                        userGoodsAttrInfo.setInsValue(goodsInsId);//对应INS_YPTE的具体实例标识值  序列获取
                        userGoodsAttrInfo.setEffDate(DateUtil.toDate(familyUserGoodsInfo.getEffDate(), DateConst.DATE_MODEL_8));
                        userGoodsAttrInfo.setExpDate(DateUtil.toDate(familyUserGoodsInfo.getExpDate(), DateConst.DATE_MODEL_8));
                        userGoodsAttrInfo.setOpNote(oprInfo.getOpNote());
                        userGoodsAttrInfo.setOpTime(DateUtil.toDate(oprInfo.getCreateTime(), DateConst.DATE_MODEL_8));
                        userGoodsAttrInfo.setOpCode(oprInfo.getOpCode());
                        userGoodsAttrInfo.setLoginNo(oprInfo.getLoginNo());
                        userGoodsAttrInfo.setLoginAccept(Long.parseLong(oprInfo.getLoginAccept()));
                        userGoodsAttrInfo.setSystemNote(oprInfo.getSystemNote());
                        userGoodsAttrInfo.setOupAccept(oprInfo.getOutAccept());
                        userGoodsAttrInfo.setState(state);
                        userGoodsAttrInfo.setStateDate(DateUtil.toDate(oprInfo.getCreateTime(), DateConst.DATE_MODEL_8));
                        ReturnDto result = familyUserGoodsAttrInfoImpl.create(userGoodsAttrInfo);

                        if (!ReturnCode.RETURN_CODE_SUCCESS.getCode().equals(result.getCode())) {
                            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                            returnDto.setMessage(result.getMessage());
                            return returnDto;
                        }
                    }
                }

                //服务订购
                if (StringUtil.isNotEmptyOrNull(familyUserGoodsInfo.getSvcId())) {
                    userGoodsInfo.setGoodsId(null);
                    userGoodsInfo.setPrcId(null);
                    userGoodsInfo.setSvcId(familyUserGoodsInfo.getSvcId());
                    userGoodsInfo.setInsType(InsTypeEnum.VAL_3.getValue());//实例分类 服务订购实例（SVCINS_ID）
                    userGoodsInfo.setInsValue(new BigDecimal(svcInsId));//实例标识值 序列获取
                    userGoodsInfo.setOtherInsId(new BigInteger(prodPrcInsId));//其他相关实例值  ==> INS_TYPE为2时存GOODSINS_ID;为3时存PRODPRCINS_ID

                    ReturnDto returnDto = familyUserGoodsInfoImpl.create(userGoodsInfo);

                    if (!ReturnCode.RETURN_CODE_SUCCESS.getCode().equals(returnDto.getCode())) {
                        returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                        returnDto.setMessage(returnDto.getMessage());
                        return returnDto;
                    }

                    //循环取FamilyUserSvcAttrInfoList节点
                    List<FamilyUserApplyInfo.FamilyUserSvcAttrInfo> familyUserSvcAttrInfoList = familyUserGoodsInfo.getFamilyUserSvcAttrInfoList();
                    for (FamilyUserApplyInfo.FamilyUserSvcAttrInfo familyUserSvcAttrInfo : familyUserSvcAttrInfoList) {
                        UserGoodsAttrInfo userSvcAttrInfo = new UserGoodsAttrInfo();
                        userSvcAttrInfo.setIdNo(Long.parseLong(userApplyInfo.getIdNo()));
                        userSvcAttrInfo.setAttrId(familyUserSvcAttrInfo.getAttrId());
                        userSvcAttrInfo.setAttrNo(familyUserSvcAttrInfo.getAttrNo());
                        userSvcAttrInfo.setAttrValue(familyUserSvcAttrInfo.getAttrValue());
                        userSvcAttrInfo.setGrpNo(familyUserSvcAttrInfo.getGrpNo());
                        userSvcAttrInfo.setInsType(InsTypeEnum.VAL_3.getValue()); //1：商品订购实例标识（对应实例标识号为GOODSINS_ID） 2：服务订购实例标识 (对应实例标识号为SVCINS_ID)
                        userSvcAttrInfo.setInsValue(svcInsId);//对应INS_YPTE的具体实例标识值  序列获取
                        userSvcAttrInfo.setEffDate(DateUtil.toDate(familyUserGoodsInfo.getEffDate(), DateConst.DATE_MODEL_8));
                        userSvcAttrInfo.setExpDate(DateUtil.toDate(familyUserGoodsInfo.getExpDate(), DateConst.DATE_MODEL_8));
                        userSvcAttrInfo.setOpNote(oprInfo.getOpNote());
                        userSvcAttrInfo.setOpTime(DateUtil.toDate(oprInfo.getCreateTime(), DateConst.DATE_MODEL_8));
                        userSvcAttrInfo.setOpCode(oprInfo.getOpCode());
                        userSvcAttrInfo.setLoginNo(oprInfo.getLoginNo());
                        userSvcAttrInfo.setLoginAccept(Long.parseLong(oprInfo.getLoginAccept()));
                        userSvcAttrInfo.setSystemNote(oprInfo.getSystemNote());
                        userSvcAttrInfo.setOupAccept(oprInfo.getOutAccept());
                        userSvcAttrInfo.setState(state);
                        userSvcAttrInfo.setStateDate(DateUtil.toDate(oprInfo.getCreateTime(), DateConst.DATE_MODEL_8));
                        ReturnDto result = familyUserGoodsAttrInfoImpl.create(userSvcAttrInfo);

                        if (!ReturnCode.RETURN_CODE_SUCCESS.getCode().equals(result.getCode())) {
                            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                            returnDto.setMessage(result.getMessage());
                            return returnDto;
                        }
                    }
                }

                //资费订购
                if (StringUtil.isNotEmptyOrNull(familyUserGoodsInfo.getPrcId())) {
                    userGoodsInfo.setSvcId(null);
                    userGoodsInfo.setPrcId(familyUserGoodsInfo.getPrcId());
                    userGoodsInfo.setInsType(InsTypeEnum.VAL_2.getValue());//实例分类 资费订购实例（PRODPRCINS_ID
                    userGoodsInfo.setInsValue(new BigDecimal(prodPrcInsId));//实例标识值 序列获取
                    userGoodsInfo.setOtherInsId(new BigInteger(goodsInsId));//其他相关实例值  ==> INS_TYPE为2时存GOODSINS_ID;为3时存PRODPRCINS_ID

                    ReturnDto returnDto = familyUserGoodsInfoImpl.create(userGoodsInfo);

                    if (!ReturnCode.RETURN_CODE_SUCCESS.getCode().equals(returnDto.getCode())) {
                        returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                        returnDto.setMessage(returnDto.getMessage());
                        return returnDto;
                    }

                    //循环取FamilyUserGoodsAttrInfoList节点
                    List<FamilyUserApplyInfo.FamilyUserGoodsAttrInfo> familyUserGoodsAttrInfoList = familyUserGoodsInfo.getFamilyUserGoodsAttrInfoList();
                    for (FamilyUserApplyInfo.FamilyUserGoodsAttrInfo familyUserGoodsAttrInfo : familyUserGoodsAttrInfoList) {
                        UserGoodsAttrInfo userGoodsAttrInfo = new UserGoodsAttrInfo();
                        userGoodsAttrInfo.setIdNo(Long.parseLong(userApplyInfo.getIdNo()));
                        userGoodsAttrInfo.setAttrId(familyUserGoodsAttrInfo.getAttrId());
                        userGoodsAttrInfo.setAttrNo(familyUserGoodsAttrInfo.getAttrNo());
                        userGoodsAttrInfo.setAttrValue(familyUserGoodsAttrInfo.getAttrValue());
                        userGoodsAttrInfo.setGrpNo(familyUserGoodsAttrInfo.getGrpNo());
                        userGoodsAttrInfo.setInsType(InsTypeEnum.VAL_2.getValue());  //1：商品订购实例标识（对应实例标识号为GOODSINS_ID） 2：服务订购实例标识 (对应实例标识号为SVCINS_ID)
                        userGoodsAttrInfo.setInsValue(prodPrcInsId);//对应INS_YPTE的具体实例标识值  序列获取
                        userGoodsAttrInfo.setEffDate(DateUtil.toDate(familyUserGoodsInfo.getEffDate(), DateConst.DATE_MODEL_8));
                        userGoodsAttrInfo.setExpDate(DateUtil.toDate(familyUserGoodsInfo.getExpDate(), DateConst.DATE_MODEL_8));
                        userGoodsAttrInfo.setOpNote(oprInfo.getOpNote());
                        userGoodsAttrInfo.setOpTime(DateUtil.toDate(oprInfo.getCreateTime(), DateConst.DATE_MODEL_8));
                        userGoodsAttrInfo.setOpCode(oprInfo.getOpCode());
                        userGoodsAttrInfo.setLoginNo(oprInfo.getLoginNo());
                        userGoodsAttrInfo.setLoginAccept(Long.parseLong(oprInfo.getLoginAccept()));
                        userGoodsAttrInfo.setSystemNote(oprInfo.getSystemNote());
                        userGoodsAttrInfo.setOupAccept(oprInfo.getOutAccept());
                        userGoodsAttrInfo.setState(state);
                        userGoodsAttrInfo.setStateDate(DateUtil.toDate(oprInfo.getCreateTime(), DateConst.DATE_MODEL_8));
                        ReturnDto result = familyUserGoodsAttrInfoImpl.create(userGoodsAttrInfo);
                        if (!ReturnCode.RETURN_CODE_SUCCESS.getCode().equals(result.getCode())) {
                            returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                            returnDto.setMessage(result.getMessage());
                            return returnDto;
                        }
                    }
                }
            }
        } catch (Exception e) {
            ReturnDto result = new ReturnDto();
            result.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
            result.setMessage(e.getMessage());
            return result;
        }
        //返回方法信息
        ReturnDto result = new ReturnDto();
        result.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        return result;
    }


    /**
     * 更新竣工标志
     *
     * @param map
     * @return ReturnDto
     */
    @Override
    public ReturnDto updateFinishState(Map<String, Object> map) {
        ReturnDto returnDto = new ReturnDto();

        try {
            UpdateOprInfo updateOprInfo = (UpdateOprInfo) map.get("oprInfo");
            Long idNo = Long.valueOf(String.valueOf(map.get("idNo"))).longValue();

            returnDto = familyUserGoodsInfoImpl.updateFinishState(updateOprInfo, idNo);

            if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                returnDto.setCode(ReturnCode.RETURN_CODE_FAIL.getCode());
                return returnDto;
            }

            returnDto = familyUserGoodsAttrInfoImpl.updateFinishState(updateOprInfo, idNo);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), "更新竣工标志失败" + e.getMessage());
        }
        returnDto.setCode(returnDto.getCode());
        returnDto.setMessage(returnDto.getMessage());
        return returnDto;
    }
}
