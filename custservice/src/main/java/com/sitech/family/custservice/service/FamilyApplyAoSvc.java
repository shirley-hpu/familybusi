package com.sitech.family.custservice.service;

import com.sitech.family.common.constants.StateEnum;
import com.sitech.family.common.pubdto.ReturnMap;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.compbusi.*;
import com.sitech.family.custservice.dto.commondto.OprInfo;
import com.sitech.family.custservice.dto.commondto.RequestMessage;
import com.sitech.family.custservice.dto.indto.FamilyApplyFnsInDto;
import com.sitech.family.custservice.dto.indto.FamilyUserApplyInDto;
import com.sitech.family.common.pubdto.FamilyUserApplyInfo;
import com.sitech.family.custservice.inter.IFamilyApplyAoSvc;
import com.sitech.family.dto.UpdateOprInfo;
import com.sitech.family.dto.ReturnDto;
import com.sitech.family.dto.usergroup.UserGroupMbrInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @description
 * @date 2019/3/13 17:55
 */
@Service
@Api("用户资料落地")
public class FamilyApplyAoSvc implements IFamilyApplyAoSvc {

    private static final Logger logger = LoggerFactory.getLogger(FamilyUserApplyInfo.class);

    @Resource
    private IFamilyUserCo familyUserCo;

    @Resource
    private IFamilyUserGoodsCo familyUserGoodsCo;

    @Autowired
    private IFamilyUserGroupMbrCo iFamilyUserGroupMbrCo;

    @Autowired
    private IFamilyAccountCo iFamilyAccountCo;

    @Autowired
    private IFamilyMbrPrcMidCo iFamilyMbrPrcMidCo;

    @Autowired
    private IFamilyUserFavCo familyUserFavCo;

    /**
     * 用户资料落地
     *
     * @param inDTO
     * @return Object
     */
    @Override
    @ResponseBody
    @RequestMapping("/sFamilyUserApplyCfm")
    @ApiOperation(value = "用户资料落地", notes = "群用户开户资料落地", tags = "cfmFamilyUserApply")
    public OutDTO<ReturnDto> cfmFamilyUserApply(@Valid @RequestBody InDTO<RequestMessage<FamilyUserApplyInDto>> inDTO, BindingResult bindingResult) {

        //获取注解校验错误信息
        List<String> errorInfo;

        if (bindingResult.hasErrors()) {

            errorInfo = new ArrayList<>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();

            for (FieldError fieldError : fieldErrors) {
                //日志打印不符合校验的字段名和错误提示
                logger.debug("error field is : {} ,message is : {} ", fieldError.getField(), fieldError.getDefaultMessage());
                errorInfo.add(fieldError.getDefaultMessage());
            }
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "群用户创建失败", errorInfo.toString());
        }

        //获取节点参数
        OprInfo oprInfo = inDTO.getBody().getOprInfo();
        FamilyUserApplyInfo familyUserApplyInfo = inDTO.getBody().getBusiInfo().getFamilyUserApplyInfo();

        logger.debug("***** inDto：*****" + inDTO.toString());

        //拼接map 调用组合服务
        Map<String, Object> param = new HashMap<>();
        param.put("OPR_INFO", oprInfo);
        param.put("USER_INFO", familyUserApplyInfo);
        //正常状态
        param.put("STATE", StateEnum.VAL_A.getValue());

        try {

            ReturnDto userResult = familyUserCo.create(param);

            if (!ReturnCode.RETURN_CODE_SUCCESS.getCode().equals(userResult.getCode())) {
                throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), userResult.getMessage());
            }

            ReturnDto goodsResult = familyUserGoodsCo.create(param);

            if (!ReturnCode.RETURN_CODE_SUCCESS.getCode().equals(goodsResult.getCode())) {
                throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), goodsResult.getMessage());
            }

            ReturnDto favResult = familyUserFavCo.create(param);

            if (!ReturnCode.RETURN_CODE_SUCCESS.getCode().equals(favResult.getCode())) {
                throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), favResult.getMessage());
            }

            OutDTO<ReturnDto> outDTO = new OutDTO<>();
            outDTO.setHeader(inDTO.getBodyHeader().getHeader());
            outDTO.setBodyOutData(userResult);
            return outDTO;

        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "群用户创建失败", e.getMessage());
        }
    }


    /**
     * 用户在途资料落地
     *
     * @param inDTO
     * @return Object
     */
    @Override
    @ResponseBody
    @RequestMapping("/sFamilyUserPreApplyCfm")
    @ApiOperation(value = "用户在途资料落地", notes = "群用户在途开户资料落地", tags = "cfmFamilyUserPreApply")
    public OutDTO<ReturnDto> cfmFamilyUserPreApply(@Valid @RequestBody InDTO<RequestMessage<FamilyUserApplyInDto>> inDTO, BindingResult bindingResult) {

        //获取注解校验错误信息
        List<String> errorInfo;

        if (bindingResult.hasErrors()) {

            errorInfo = new ArrayList<>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();

            for (FieldError fieldError : fieldErrors) {
                //日志打印不符合校验的字段名和错误提示
                logger.debug("error field is : {} ,message is : {} ", fieldError.getField(), fieldError.getDefaultMessage());
                errorInfo.add(fieldError.getDefaultMessage());
            }
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "群用户创建失败", errorInfo.toString());
        }

        //获取节点参数
        OprInfo oprInfo = inDTO.getBody().getOprInfo();
        FamilyUserApplyInfo familyUserApplyInfo = inDTO.getBody().getBusiInfo().getFamilyUserApplyInfo();

        logger.debug("***** inDto：*****" + inDTO.toString());

        //拼接map 调用组合服务
        Map<String, Object> param = new HashMap<>();
        param.put("OPR_INFO", oprInfo);
        param.put("USER_INFO", familyUserApplyInfo);
        //在途状态
        param.put("STATE", StateEnum.VAL_B.getValue());

        try {

            ReturnDto userResult = familyUserCo.create(param);

            if (!ReturnCode.RETURN_CODE_SUCCESS.getCode().equals(userResult.getCode())) {
                throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), userResult.getMessage());
            }

            ReturnDto goodsResult = familyUserGoodsCo.create(param);

            if (!ReturnCode.RETURN_CODE_SUCCESS.getCode().equals(goodsResult.getCode())) {
                throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), goodsResult.getMessage());
            }

            ReturnDto favResult = familyUserFavCo.create(param);

            if (!ReturnCode.RETURN_CODE_SUCCESS.getCode().equals(favResult.getCode())) {
                throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), favResult.getMessage());
            }

            OutDTO<ReturnDto> outDTO = new OutDTO<>();
            outDTO.setHeader(inDTO.getBodyHeader().getHeader());
            outDTO.setBodyOutData(userResult);
            return outDTO;

        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "群用户创建失败", e.getMessage());
        }
    }

    /**
     * 群用户竣工
     *
     * @param inDTO
     * @return OutDTO
     */
    @Override
    @ResponseBody
    @RequestMapping("/sFamilyApplyFns")
    @ApiOperation(value = "群用户竣工", notes = "群用户竣工", tags = "fnsFamilyApply")
    public OutDTO fnsFamilyApply(@Valid @RequestBody InDTO<RequestMessage<FamilyApplyFnsInDto>> inDTO) {
        OutDTO outDTO = new OutDTO();
        ReturnDto returnDto = new ReturnDto();
        Map<String, String> map = new HashMap<>();

        try {
            RequestMessage requestMessage = inDTO.getBodyHeader().getBody();
            FamilyApplyFnsInDto familyApplyFnsInDto = (FamilyApplyFnsInDto) requestMessage.getBusiInfo();

            OprInfo oprInfo = requestMessage.getOprInfo();

            UpdateOprInfo updateOprInfo = new UpdateOprInfo();
            BeanUtils.copyProperties(oprInfo,updateOprInfo);

            Map<String, Object> userMap = new HashMap<>();
            userMap.put("oprInfo", updateOprInfo);
            userMap.put("idNo", familyApplyFnsInDto.getIdNo());
            userMap.put("objectId", familyApplyFnsInDto.getObjectId());

            map = familyUserCo.getUserFinishFlag(userMap);

            if ("-9999".equals(map.get("RETURN_CODE"))) {
                outDTO.setBodyOutData(map);
                return outDTO;
            }

            returnDto = iFamilyUserGroupMbrCo.updateFinishState(userMap);
            map = ReturnMap.ReturnMsg(returnDto);

            boolean flag = iFamilyUserGroupMbrCo.qryLongProcessFlag(userMap);

            if (flag) {
                map.put("RETURN_CODE", "-9999");
                map.put("RETURN_MSG", "该订单所在群有长流程未结束,暂时无法竣工");
                outDTO.setBodyOutData(map);
                return outDTO;
            }

            returnDto = familyUserCo.updateFinishState(userMap);
            map = ReturnMap.ReturnMsg(returnDto);

            returnDto = familyUserGoodsCo.updateFinishState(userMap);
            map = ReturnMap.ReturnMsg(returnDto);

            returnDto = iFamilyAccountCo.updateFinishState(userMap);
            map = ReturnMap.ReturnMsg(returnDto);

            List<UserGroupMbrInfo> list = iFamilyUserGroupMbrCo.qryShortProcessList(userMap);

            for (UserGroupMbrInfo userGroupMbrInfo : list) {
                Map<String, Object> userGroupMap = new HashMap<>();
                userGroupMap.put("objectId", userGroupMbrInfo.getObjectId());
                userGroupMap.put("oprInfo", updateOprInfo);

                returnDto = iFamilyUserGroupMbrCo.updateFinishState(userGroupMap);

                if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                    map.put("RETURN_CODE", "-9999");
                    map.put("RETURN_MSG", "该订单所在群中成员号码为" + userGroupMbrInfo.getObjectId() + "更新状态失败");

                    outDTO.setBodyOutData(map);
                    return outDTO;
                } else {
                    map.put("RETURN_CODE", "0");
                    map.put("RETURN_MSG", "该订单竣工成功");
                }
            }

            returnDto = iFamilyMbrPrcMidCo.delByIdNo(userMap);

            outDTO.setBodyOutData(map);
        } catch (Exception e) {
            throw new BusiException(getErrorCode("1000", "15000"), e.getMessage());
        }

        return outDTO;
    }
}