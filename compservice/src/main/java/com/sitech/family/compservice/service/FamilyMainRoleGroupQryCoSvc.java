package com.sitech.family.compservice.service;

import com.sitech.family.common.dto.OprInfo;
import com.sitech.family.common.dto.RequestMessage;
import com.sitech.family.common.util.CommonCheckUtil;
import com.sitech.family.compservice.atombiz.IFamilyMainRoleGroupQryAo;
import com.sitech.family.compservice.inter.IFamilyMainRoleGroupQryCoSvc;
import com.sitech.family.constants.ReturnCode;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import com.sitech.ijcf.message6.dt.Header;
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
import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.HashMap;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * 主号家庭信息查询
 *
 * @author shirley
 * @version 1.0
 * @date 2019/7/30 下午3:55
 */
@Service
@Api("主号家庭信息查询")
public class FamilyMainRoleGroupQryCoSvc implements IFamilyMainRoleGroupQryCoSvc {

    private static final Logger logger = LoggerFactory.getLogger(FamilyMainRoleGroupQryCoSvc.class);

    @Resource
    private IFamilyMainRoleGroupQryAo familyMainRoleGroupQryAo;

    @Override
    @ResponseBody
    @RequestMapping("/sFamilyMainRoleGroupQry")
    @ApiOperation(value = "qryFamilyMainRoleGroup", notes = "qryFamilyMainRoleGroup", tags = "qryFamilyMainRoleGroup")
    public OutDTO<Object> qryFamilyMainRoleGroup(@RequestBody InDTO<RequestMessage<Map>> inDTO) {

        //header校验
        CommonCheckUtil.getHeaderDataCheck(inDTO);

        try {
            //调用 compbiz业务逻辑层 封装map 返回Map
            Header header = inDTO.getBodyHeader().getHeader();
            RequestMessage<Map> body = inDTO.getBodyHeader().getBody();

            Map<String, Object> paramInDto = new HashMap<>(3);
            paramInDto.put("header", header);
            paramInDto.put("oprInfo", body.getOprInfo());
            paramInDto.put("BUSI_INFO", body.getBusiInfo());

            Map map = familyMainRoleGroupQryAo.qryFamilyMainRoleGroup(paramInDto);

            if (map.size() == 0 || StringUtil.isEmptyOrNull(map)) {
                OutDTO<Object> outDTO = new OutDTO<>();
                outDTO.setHeader(inDTO.getBodyHeader().getHeader());
                outDTO.setBodyOutData("查询数据为空");
                return outDTO;
            }

            OutDTO<Object> outDTO = new OutDTO<>();
            outDTO.setHeader(inDTO.getBodyHeader().getHeader());
            outDTO.setBodyOutData(map);
            return outDTO;

        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "查询失败", e.getMessage());
        }
    }

    /**
     * 对外暴露的组合服务，家庭用户基本信息查询
     * @param inDTO
     * @return
     */
    @Override
    @ResponseBody
    @RequestMapping("/sFamilyUserBasicInfoQry")
    @ApiOperation(value = "qryFamilyUserBasicInfo", notes = "qryFamilyUserBasicInfo", tags = "qryFamilyUserBasicInfo")
    public OutDTO<Object> qryFamilyUserBasicInfo(@RequestBody InDTO<RequestMessage<Map>> inDTO) {
        Header header = inDTO.getHeader();
        OprInfo oprInfo = inDTO.getBodyHeader().getBody().getOprInfo();
        Map<String, Object> busiInfo = inDTO.getBody().getBusiInfo();
        if(StringUtil.isEmptyOrNull(busiInfo.get("ID_NO"))){
            throw new BusiException(getErrorCode("1000","15000"),"入参不能为空");
        }
        Map map = new HashMap();
        map.put("header",header);
        map.put("oprInfo",oprInfo);
        map.put("busiInfo",busiInfo);
        return familyMainRoleGroupQryAo.qryFamilyUserBasicInfo(map);
    }
}
