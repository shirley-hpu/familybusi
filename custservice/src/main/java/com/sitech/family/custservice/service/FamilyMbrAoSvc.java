package com.sitech.family.custservice.service;

import com.sitech.family.common.constants.FinishFlagEnum;
import com.sitech.family.common.constants.StateEnum;
import com.sitech.family.common.pubdto.FamilyMbrAdd;
import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custservice.compbusi.IFamilyAccountCo;
import com.sitech.family.custservice.compbusi.IFamilyMbrPrcMidCo;
import com.sitech.family.custservice.compbusi.IFamilyUserGroupMbrCo;
import com.sitech.family.custservice.dto.commondto.OprInfo;
import com.sitech.family.custservice.dto.commondto.RequestMessage;
import com.sitech.family.custservice.dto.indto.*;
import com.sitech.family.custservice.inter.IFamilyMbrAoSvc;
import com.sitech.family.dto.ReturnDto;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author wusm
 * @description
 * @date 2019/2/26 10:27
 */
@Service("FamilyMbrAoSvc")
public class FamilyMbrAoSvc implements IFamilyMbrAoSvc {
    private static Logger logger = LoggerFactory.getLogger(FamilyMbrAoSvc.class);

    @Autowired
    private IFamilyUserGroupMbrCo iFamilyUserGroupMbrCo;

    @Autowired
    private IFamilyAccountCo iFamilyAccountCo;

    @Autowired
    private IFamilyMbrPrcMidCo iFamilyMbrPrcMidCo;

    /**
     * 成员资料创建(正常状态)
     *
     * @param inDTO
     * @return
     */
    @Override
    @ResponseBody
    @RequestMapping("/sFamilyAddMbrCfm")
    public OutDTO sFamilyAddMbrCfm(@Valid @RequestBody InDTO<RequestMessage<FamilyAddMbrInDto>> inDTO) {
        OutDTO outDTO = new OutDTO<>();
        ReturnDto returnDto = new ReturnDto();

        try {
            RequestMessage requestMessage = inDTO.getBodyHeader().getBody();
            FamilyAddMbrInDto familyAddMbrInDto = (FamilyAddMbrInDto) requestMessage.getBusiInfo();
            OprInfo oprInfo = requestMessage.getOprInfo();

            Map<String, Object> userGroupMap = new HashMap<>();
            userGroupMap.put("oprInfo", oprInfo);
            userGroupMap.put("busiInfo", familyAddMbrInDto);
            userGroupMap.put("state", StateEnum.VAL_A.getValue());

            returnDto = iFamilyUserGroupMbrCo.create(userGroupMap);

            if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                outDTO.setBodyOutData("成员资料创建失败");
                return outDTO;
            }

            Map<String, Object> accountMap = new HashMap<>();
            accountMap.put("oprInfo", oprInfo);
            accountMap.put("busiInfo", familyAddMbrInDto);
            accountMap.put("finishFlag", FinishFlagEnum.VAL_Y.getValue());

            returnDto = iFamilyAccountCo.create(accountMap);

            if (ReturnCode.RETURN_CODE_SUCCESS.getCode().equals(returnDto.getCode())) {
                outDTO.setBodyOutData("成员资料创建成功");
            } else {
                outDTO.setBodyOutData("成员资料创建失败");
            }
        } catch (Exception e) {
            logger.error("成员资料创建失败" + e.getMessage());
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "失败", "创建失败");
        }

        return outDTO;
    }

    /**
     * 成员资料创建(在途状态)
     *
     * @param inDTO
     * @return OutDTO
     */
    @Override
    @ResponseBody
    @RequestMapping("/sFamilyPreAddMbrCfm")
    public OutDTO sFamilyPreAddMbrCfm(@Valid @RequestBody InDTO<RequestMessage<FamilyAddMbrInDto>> inDTO) {
        OutDTO outDTO = new OutDTO<>();
        ReturnDto returnDto = new ReturnDto();

        try {
            RequestMessage requestMessage = inDTO.getBodyHeader().getBody();
            FamilyAddMbrInDto familyAddMbrInDto = (FamilyAddMbrInDto) requestMessage.getBusiInfo();
            OprInfo oprInfo = requestMessage.getOprInfo();

            Map<String, Object> userGroupMap = new HashMap<>();
            userGroupMap.put("oprInfo", oprInfo);
            userGroupMap.put("busiInfo", familyAddMbrInDto);
            userGroupMap.put("state", StateEnum.VAL_B.getValue());

            returnDto = iFamilyUserGroupMbrCo.create(userGroupMap);

            if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                outDTO.setBodyOutData("成员资料创建失败");
                return outDTO;
            }

            if (familyAddMbrInDto.getFamilyMbrAddList() != null) {
                List<FamilyMbrAdd> familyMbrAddList = familyAddMbrInDto.getFamilyMbrAddList();

                String midFlag = null;
                for (FamilyMbrAdd familyMbrAdd : familyMbrAddList) {
                    if (familyMbrAdd.getFamilyUserPrcMbrInsList() != null) {
                        List<FamilyMbrAdd.FamilyUserPrcMbrIns> familyUserPrcMbrInsList = familyMbrAdd.getFamilyUserPrcMbrInsList();

                        for (FamilyMbrAdd.FamilyUserPrcMbrIns familyUserPrcMbrIns : familyUserPrcMbrInsList) {
                            if (familyUserPrcMbrIns.getMainFlag() != null) {
                                midFlag = "Y";
                            }
                        }
                    }
                }

                if ("Y".equals(midFlag)) {
                    returnDto = iFamilyMbrPrcMidCo.create(userGroupMap);

                    if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(returnDto.getCode())) {
                        outDTO.setBodyOutData("成员资料创建失败");
                        return outDTO;
                    }
                }
            }

            Map<String, Object> accountMap = new HashMap<>();
            accountMap.put("oprInfo", oprInfo);
            accountMap.put("busiInfo", familyAddMbrInDto);
            accountMap.put("finishFlag", FinishFlagEnum.VAL_N.getValue());

            returnDto = iFamilyAccountCo.create(accountMap);

            if (ReturnCode.RETURN_CODE_SUCCESS.getCode().equals(returnDto.getCode())) {
                outDTO.setBodyOutData("成员资料创建成功");
            } else {
                outDTO.setBodyOutData("成员资料创建失败");
            }
        } catch (Exception e) {
            logger.error("成员资料创建失败" + e.getMessage());
            throw new BusiException(getErrorCode("1000", "15000"), e.getMessage());
        }

        return outDTO;
    }


    /**
     * 成员删除资料处理
     *
     * @param inDTO serviceParams
     * @return outDto
     */
    @Override
    @ResponseBody
    @RequestMapping("/sFamilyDelMbrCfm")
    public OutDTO<ReturnDto> cfmFamilyDelMbr(@RequestBody InDTO<RequestMessage<Map>> inDTO) {

        //获取业务参数信息
        RequestMessage requestMessage = inDTO.getBodyHeader().getBody();
        Map busiInfo = (Map) requestMessage.getBusiInfo();

        Object idNo = busiInfo.get("ID_NO");
        Object memberId = busiInfo.get("MEMBER_ID");
        Object contractNo = busiInfo.get("CONTRACT_NO");

        if (StringUtil.isEmptyOrNull(idNo) || StringUtil.isEmptyOrNull(memberId) || StringUtil.isEmptyOrNull(contractNo)) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "参数不能为空");
        }

        try {
            //成员关系删除
            Map<String, Object> params = new HashMap<>();
            params.put("memberId", memberId);
            ReturnDto mbrResult = iFamilyUserGroupMbrCo.drop(params);
            if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(mbrResult.getCode())) {
                throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), mbrResult.getMessage());
            }

            //成员账户关系删除
            params.clear();
            params.put("idNo", idNo);
            params.put("contractNo", contractNo);
            ReturnDto accountResult = iFamilyAccountCo.drop(params);
            if (ReturnCode.RETURN_CODE_FAIL.getCode().equals(accountResult.getCode())) {
                throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), accountResult.getMessage());
            }

        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "处理失败", e.getMessage());
        }
        OutDTO<ReturnDto> outDTO = new OutDTO<>();
        ReturnDto returnDto = new ReturnDto();
        returnDto.setCode(ReturnCode.RETURN_CODE_SUCCESS.getCode());
        outDTO.setBodyOutData(returnDto);
        return outDTO;
    }

    /**
     * 成员资料变更
     *
     * @param inDTO
     * @return OutDTO
     */
    @Override
    @ResponseBody
    @RequestMapping("/sFamilyMbrPrcChgCfm")
    public OutDTO cfmFamilyMbrPrcChg(@Valid @RequestBody InDTO<RequestMessage<FamilyMbrPrcInsInDto>> inDTO) {
        OutDTO outDTO = new OutDTO();
        ReturnDto returnDto = new ReturnDto();

        try {
            RequestMessage requestMessage = inDTO.getBodyHeader().getBody();
            FamilyMbrPrcInsInDto familyMbrPrcInsInDto = (FamilyMbrPrcInsInDto) requestMessage.getBusiInfo();
            OprInfo oprInfo = requestMessage.getOprInfo();

            Map<String, Object> map = new HashMap<>();
            map.put("busiInfo",familyMbrPrcInsInDto);
            map.put("oprInfo",oprInfo);

            returnDto = iFamilyUserGroupMbrCo.updateMbrPrcIns(map);

            if (ReturnCode.RETURN_CODE_SUCCESS.getCode().equals(returnDto.getCode())) {
                outDTO.setBodyOutData("成员资料变更成功");
            } else {
                outDTO.setBodyOutData("成员资料变更失败");
            }
        } catch (Exception e) {
            logger.error("成员资料变更失败" + e.getMessage());
            throw new BusiException(getErrorCode("1000", "15000"), e.getMessage());
        }

        return outDTO;
    }


}