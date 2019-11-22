package com.sitech.family.custqryservice.service;

import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custqryservice.compbusi.IFamilyMainRoleGroupQryCo;
import com.sitech.family.custqryservice.dto.commondto.RequestMessage;
import com.sitech.family.custqryservice.dto.outdto.FamilyGroupInfo;
import com.sitech.family.custqryservice.inter.IFamilyMainRoleGroupQryAoSvc;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 主号家庭信息查询
 *
 * @author shirley
 * @version 1.0
 * @date 2019/7/30 下午3:55
 */
@Service
@Api("主号家庭信息查询")
public class FamilyMainRoleGroupQryAoSvc implements IFamilyMainRoleGroupQryAoSvc {

   private static final Logger logger = LoggerFactory.getLogger(FamilyMainRoleGroupQryAoSvc.class);
    @Resource
    private IFamilyMainRoleGroupQryCo mainRoleGroupQryCoImpl;


    @Override
    @ResponseBody
    @RequestMapping("/sFamilyMainRoleGroupQry")
    @ApiOperation(value = "qryFamilyMainRoleGroup", notes = "qryFamilyMainRoleGroup", tags = "qryFamilyMainRoleGroup")
    public OutDTO<Object> qryFamilyMainRoleGroup(@Valid @RequestBody InDTO<RequestMessage<Map>> inDTO) {

        //获取节点参数
        Map busiInfo = inDTO.getBody().getBusiInfo();
        String phoneNo = (String) busiInfo.get("PHONE_NO");

        if (StringUtil.isEmptyOrNull(phoneNo)) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "处理失败", "入参不能为空");
        }
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("phoneNo",phoneNo);
        try {
            List<FamilyGroupInfo> groupInfoList = mainRoleGroupQryCoImpl.query(param);
            OutDTO outDTO = new OutDTO<>();
            outDTO.setHeader(inDTO.getBodyHeader().getHeader());
            Map<String, List<FamilyGroupInfo>> queryData = new HashMap<String, List<FamilyGroupInfo>>();
            queryData.put("UR_USERGROUP_INFO_LIST", groupInfoList);
            outDTO.setBodyOutData(queryData);
            return outDTO;

        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "查询失败", e.getMessage());
        }
    }
}
