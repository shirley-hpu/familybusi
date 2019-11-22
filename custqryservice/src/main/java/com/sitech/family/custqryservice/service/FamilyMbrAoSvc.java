package com.sitech.family.custqryservice.service;

import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custqryservice.atombusi.IFamilyUserGroupMbrInfo;
import com.sitech.family.custqryservice.compbusi.IFamilyMbrPrcMidCo;
import com.sitech.family.custqryservice.dto.commondto.OprInfo;
import com.sitech.family.custqryservice.dto.commondto.RequestMessage;
import com.sitech.family.custqryservice.dto.outdto.CssCodeDefDict;
import com.sitech.family.custqryservice.dto.outdto.FamilyGroupMbr;
import com.sitech.family.custqryservice.dto.outdto.MbrPrcMidInfo;
import com.sitech.family.custqryservice.inter.IFamilyMbrAoSvc;
import com.sitech.family.dto.dict.CssCodeDefInfo;
import com.sitech.family.dto.usergroup.UserGroupMbrInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

/**
 * 成员资费预约订购记录查询
 *
 * @author shirley
 * @date created in 2019/4/22
 */
@Service
@Api("成员资费预约订购记录查询")
public class FamilyMbrAoSvc implements IFamilyMbrAoSvc {

    private static final Logger logger = LoggerFactory.getLogger(FamilyMbrAoSvc.class);

    @Resource
    private IFamilyMbrPrcMidCo familyMbrPrcMidCo;
    @Resource
    private IFamilyUserGroupMbrInfo familyUserGroupMbrInfo;

    @Override
    @ResponseBody
    @RequestMapping("/sFamilyPreMbrPrcQry")
    @ApiOperation(value = "qryFamilyPreMbrPrc", notes = "qryFamilyPreMbrPrc", tags = "qryFamilyPreMbrPrc")
    public OutDTO<Object> qryFamilyPreMbrPrc(@Valid @RequestBody InDTO<RequestMessage<Map>> inDTO, BindingResult bindingResult) {

        //获取节点参数
        OprInfo oprInfo = inDTO.getBody().getOprInfo();
        Map busiInfo = inDTO.getBody().getBusiInfo();
        
        logger.debug("***** inDto：*****" + inDTO.toString());

        try {
            //拼接map 调用组合服务
            List<MbrPrcMidInfo> list = familyMbrPrcMidCo.query(busiInfo);

            OutDTO<Object> outDTO = new OutDTO<>();
            outDTO.setHeader(inDTO.getBodyHeader().getHeader());
            Map queryData = new HashMap();
            queryData.put("MBRPRCMIDINFOLIST", list);
            outDTO.setBodyOutData(queryData);
            return outDTO;
        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "处理失败", e.getMessage());
        }
    }

    @Override
    @ResponseBody
    @RequestMapping("/sFamilyGroupMbrQry")
    @ApiOperation(value = "qryFamilyGroupMbr", notes = "qryFamilyGroupMbr", tags = "qryFamilyGroupMbr")
    public OutDTO<Object> qryFamilyGroupMbr(@RequestBody InDTO<RequestMessage<Map>> inDTO, BindingResult bindingResult) {
        Map busiInfo = inDTO.getBody().getBusiInfo();
        Map<String,Object> map = new HashMap<>();
        map.put("groupId",busiInfo.get("GROUP_ID"));
        try {
            List<FamilyGroupMbr> list = familyUserGroupMbrInfo.qryUserGroupMbrInfoList(map);
            OutDTO<Object> outDTO = new OutDTO<>();
            outDTO.setHeader(inDTO.getBodyHeader().getHeader());
            Map data = new HashMap();
            data.put("UR_USERGROUPMBR_LIST",list);
            outDTO.setBodyOutData(data);
            return outDTO;
        }catch (Exception e){
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "处理失败", e.getMessage());
        }
    }
}
