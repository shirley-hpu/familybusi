package com.sitech.family.custqryservice.service;

import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custqryservice.atombusi.ICssCodeDefDictInfo;
import com.sitech.family.custqryservice.dto.commondto.OprInfo;
import com.sitech.family.custqryservice.dto.commondto.RequestMessage;
import com.sitech.family.custqryservice.dto.outdto.CssCodeDefDict;
import com.sitech.family.custqryservice.inter.ICssCodeDefDictAoSvc;
import com.sitech.family.dto.dict.CssCodeDefInfo;
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
 * 统一代码配置表
 *
 * @author shirley
 * @date created in 2019/4/19
 */
@Service
@Api("统一代码配置")
public class CssCodeDefDictAoSvc implements ICssCodeDefDictAoSvc {

    private static final Logger logger = LoggerFactory.getLogger(CssCodeDefDictAoSvc.class);

    @Resource
    private ICssCodeDefDictInfo cssCodeDefDictInfo;


    /**
     * query records by major columns
     *
     * @param inDTO
     * @param bindingResult
     * @return
     * @args codeClass valueId groupId classLevel codeId idType beginValue endValue otherValue
     */
    @Override
    @ResponseBody
    @RequestMapping("/sCssCodeDefQryByCond")
    @ApiOperation(value = "qryByCond", notes = "qryByCond", tags = "qryByCond")
    public OutDTO<Object> qryByCond(@Valid @RequestBody InDTO<RequestMessage<Map>> inDTO, BindingResult bindingResult) {

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
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "failed query", errorInfo.toString());
        }

        //获取节点参数
        OprInfo oprInfo = inDTO.getBody().getOprInfo();
        Map busiInfo = inDTO.getBody().getBusiInfo();

        logger.debug("***** inDto：*****" + inDTO.toString());

        try {
            //拼接map 调用原子服务
            List<CssCodeDefInfo> list = cssCodeDefDictInfo.qryByCond(busiInfo);
            List<CssCodeDefDict> outDto = new ArrayList<>();

            for (CssCodeDefInfo obj : list) {
                CssCodeDefDict temp = new CssCodeDefDict();
                temp.setCodeClass(obj.getCodeClass());
                temp.setClassDesc(obj.getClassDesc());
                temp.setClassLevel(obj.getClassLevel());
                temp.setCodeId(obj.getCodeId());
                temp.setBeginValue(obj.getBeginValue());
                temp.setBeginValueDesc(obj.getBeginValueDesc());
                temp.setEffDate(obj.getEffDate());
                temp.setExpDate(obj.getExpDate());
                temp.setEndValue(obj.getEndValue());
                temp.setEndValueDesc(obj.getEndValueDesc());
                temp.setGroupId(obj.getGroupId());
                temp.setIdDesc(obj.getIdDesc());
                temp.setIdType(obj.getIdType());
                temp.setOtherValue(obj.getOtherValue());
                temp.setRemark(obj.getRemark());
                temp.setBak(obj.getBak());
                temp.setValueId(obj.getValueId());
                outDto.add(temp);
            }

            OutDTO<Object> outDTO = new OutDTO<>();
            outDTO.setHeader(inDTO.getBodyHeader().getHeader());
            Map queryData = new HashMap();
            queryData.put("CSSCODEDEFLIST", outDto);
            outDTO.setBodyOutData(outDto);
            return outDTO;
        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "failed query", e.getMessage());
        }
    }

    /**
     * query records by GROUP_ID='0' and codeClass
     *
     * @param inDTO
     * @param bindingResult
     * @return
     * @args GROUP_ID ='0' CODE_CLASS
     */
    @Override
    @ResponseBody
    @RequestMapping("/sCssCodeDefQryByClass")
    @ApiOperation(value = "qryByClass", notes = "qryByClass", tags = "qryByClass")
    public OutDTO<Object> qryByClass(@Valid @RequestBody InDTO<RequestMessage<Map>> inDTO, BindingResult bindingResult) {

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
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "failed query", errorInfo.toString());
        }

        //获取节点参数
        OprInfo oprInfo = inDTO.getBody().getOprInfo();
        Map busiInfo = inDTO.getBody().getBusiInfo();

        logger.debug("***** inDto：*****" + inDTO.toString());

        try {
            //拼接map 调用原子服务
            List<CssCodeDefInfo> list = cssCodeDefDictInfo.qryByClass(busiInfo);
            List<CssCodeDefDict> outDto = new ArrayList<>();

            for (CssCodeDefInfo obj : list) {
                CssCodeDefDict temp = new CssCodeDefDict();
                temp.setCodeClass(obj.getCodeClass());
                temp.setClassDesc(obj.getClassDesc());
                temp.setClassLevel(obj.getClassLevel());
                temp.setCodeId(obj.getCodeId());
                temp.setBeginValue(obj.getBeginValue());
                temp.setBeginValueDesc(obj.getBeginValueDesc());
                temp.setEffDate(obj.getEffDate());
                temp.setExpDate(obj.getExpDate());
                temp.setEndValue(obj.getEndValue());
                temp.setEndValueDesc(obj.getEndValueDesc());
                temp.setGroupId(obj.getGroupId());
                temp.setIdDesc(obj.getIdDesc());
                temp.setIdType(obj.getIdType());
                temp.setOtherValue(obj.getOtherValue());
                temp.setRemark(obj.getRemark());
                temp.setBak(obj.getBak());
                temp.setValueId(obj.getValueId());
                outDto.add(temp);
            }

            OutDTO<Object> outDTO = new OutDTO<>();
            outDTO.setHeader(inDTO.getBodyHeader().getHeader());
            outDTO.setBodyOutData(outDto);
            return outDTO;
        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "failed query", e.getMessage());
        }
    }

    /**
     * query records by codeClass and (groupId or groupId='0')
     *
     * @param inDTO
     * @param bindingResult
     * @return
     * @args codeClass and (groupId or groupId='0')
     */
    @Override
    @ResponseBody
    @RequestMapping("/sCssCodeDefQryByClassGrpId")
    @ApiOperation(value = "qryByClassGrpId", notes = "qryByClassGrpId", tags = "qryByClassGrpId")
    public OutDTO<Object> qryByClassGrpId(@Valid @RequestBody InDTO<RequestMessage<Map>> inDTO, BindingResult bindingResult) {

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
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "failed query", errorInfo.toString());
        }

        //获取节点参数
        OprInfo oprInfo = inDTO.getBody().getOprInfo();
        Map busiInfo = inDTO.getBody().getBusiInfo();

        logger.debug("***** inDto：*****" + inDTO.toString());

        try {
            //拼接map 调用原子服务
            List<CssCodeDefInfo> list = cssCodeDefDictInfo.qryByClassGrpId(busiInfo);
            List<CssCodeDefDict> outDto = new ArrayList<>();

            for (CssCodeDefInfo obj : list) {
                CssCodeDefDict temp = new CssCodeDefDict();
                temp.setCodeClass(obj.getCodeClass());
                temp.setClassDesc(obj.getClassDesc());
                temp.setClassLevel(obj.getClassLevel());
                temp.setCodeId(obj.getCodeId());
                temp.setBeginValue(obj.getBeginValue());
                temp.setBeginValueDesc(obj.getBeginValueDesc());
                temp.setEffDate(obj.getEffDate());
                temp.setExpDate(obj.getExpDate());
                temp.setEndValue(obj.getEndValue());
                temp.setEndValueDesc(obj.getEndValueDesc());
                temp.setGroupId(obj.getGroupId());
                temp.setIdDesc(obj.getIdDesc());
                temp.setIdType(obj.getIdType());
                temp.setOtherValue(obj.getOtherValue());
                temp.setRemark(obj.getRemark());
                temp.setBak(obj.getBak());
                temp.setValueId(obj.getValueId());
                outDto.add(temp);
            }

            OutDTO<Object> outDTO = new OutDTO<>();
            outDTO.setHeader(inDTO.getBodyHeader().getHeader());
            outDTO.setBodyOutData(outDto);
            return outDTO;
        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "failed query", e.getMessage());
        }
    }

    /**
     * query records by codeClass or other columns
     *
     * @param inDTO
     * @param bindingResult
     * @return
     * @args codeClass or other columns
     */
    @Override
    @ResponseBody
    @RequestMapping("/sCssCodeDefQryByCondAll")
    @ApiOperation(value = "qryByCondAll", notes = "qryByCondAll", tags = "qryByCondAll")
    public OutDTO<Object> qryByCondAll(@Valid @RequestBody InDTO<RequestMessage<Map>> inDTO, BindingResult bindingResult) {

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
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "failed query", errorInfo.toString());
        }

        //获取节点参数
        OprInfo oprInfo = inDTO.getBody().getOprInfo();
        Map busiInfo = inDTO.getBody().getBusiInfo();

        logger.debug("***** inDto：*****" + inDTO.toString());

        try {
            //拼接map 调用原子服务
            List<CssCodeDefInfo> list = cssCodeDefDictInfo.qryByCondAll(busiInfo);
            List<CssCodeDefDict> outDto = new ArrayList<>();

            for (CssCodeDefInfo obj : list) {
                CssCodeDefDict temp = new CssCodeDefDict();
                temp.setCodeClass(obj.getCodeClass());
                temp.setClassDesc(obj.getClassDesc());
                temp.setClassLevel(obj.getClassLevel());
                temp.setCodeId(obj.getCodeId());
                temp.setBeginValue(obj.getBeginValue());
                temp.setBeginValueDesc(obj.getBeginValueDesc());
                temp.setEffDate(obj.getEffDate());
                temp.setExpDate(obj.getExpDate());
                temp.setEndValue(obj.getEndValue());
                temp.setEndValueDesc(obj.getEndValueDesc());
                temp.setGroupId(obj.getGroupId());
                temp.setIdDesc(obj.getIdDesc());
                temp.setIdType(obj.getIdType());
                temp.setOtherValue(obj.getOtherValue());
                temp.setRemark(obj.getRemark());
                temp.setBak(obj.getBak());
                temp.setValueId(obj.getValueId());
                outDto.add(temp);
            }

            OutDTO<Object> outDTO = new OutDTO<>();
            outDTO.setHeader(inDTO.getBodyHeader().getHeader());
            outDTO.setBodyOutData(outDto);
            return outDTO;
        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "failed query", e.getMessage());
        }
    }

    /**
     * query records by major columns and fuzzy query by endValueDesc
     *
     * @param inDTO
     * @param bindingResult
     * @return
     * @args major columns query and fuzzy query by endValueDesc
     */
    @Override
    @ResponseBody
    @RequestMapping("/sCssCodeDefQryBySpecial")
    @ApiOperation(value = "qryBySpecial", notes = "qryBySpecial", tags = "qryBySpecial")
    public OutDTO<Object> qryBySpecial(@Valid @RequestBody InDTO<RequestMessage<Map>> inDTO, BindingResult bindingResult) {

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
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "failed query", errorInfo.toString());
        }

        //获取节点参数
        OprInfo oprInfo = inDTO.getBody().getOprInfo();
        Map busiInfo = inDTO.getBody().getBusiInfo();

        logger.debug("***** inDto：*****" + inDTO.toString());

        try {
            //拼接map 调用原子服务
            List<CssCodeDefInfo> list = cssCodeDefDictInfo.qryBySpecial(busiInfo);
            List<CssCodeDefDict> outDto = new ArrayList<>();

            for (CssCodeDefInfo obj : list) {
                CssCodeDefDict temp = new CssCodeDefDict();
                temp.setCodeClass(obj.getCodeClass());
                temp.setClassDesc(obj.getClassDesc());
                temp.setClassLevel(obj.getClassLevel());
                temp.setCodeId(obj.getCodeId());
                temp.setBeginValue(obj.getBeginValue());
                temp.setBeginValueDesc(obj.getBeginValueDesc());
                temp.setEffDate(obj.getEffDate());
                temp.setExpDate(obj.getExpDate());
                temp.setEndValue(obj.getEndValue());
                temp.setEndValueDesc(obj.getEndValueDesc());
                temp.setGroupId(obj.getGroupId());
                temp.setIdDesc(obj.getIdDesc());
                temp.setIdType(obj.getIdType());
                temp.setOtherValue(obj.getOtherValue());
                temp.setRemark(obj.getRemark());
                temp.setBak(obj.getBak());
                temp.setValueId(obj.getValueId());
                outDto.add(temp);
            }

            OutDTO<Object> outDTO = new OutDTO<>();
            outDTO.setHeader(inDTO.getBodyHeader().getHeader());
            outDTO.setBodyOutData(outDto);
            return outDTO;
        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "failed query", e.getMessage());
        }
    }


    /**
     * query umber of records by major columns
     *
     * @param inDTO
     * @param bindingResult
     * @return
     * @args codeClass groupId classLevel beginValue endValue
     */
    @Override
    @ResponseBody
    @RequestMapping("/sCssCodeDefQryByCondForNum")
    @ApiOperation(value = "qryByCondForNum", notes = "qryByCondForNum", tags = "qryByCondForNum")
    public OutDTO<Object> qryByCondForNum(@Valid @RequestBody InDTO<RequestMessage<Map>> inDTO, BindingResult bindingResult) {

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
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "failed query", errorInfo.toString());
        }

        //获取节点参数
        OprInfo oprInfo = inDTO.getBody().getOprInfo();
        Map busiInfo = inDTO.getBody().getBusiInfo();

        logger.debug("***** inDto：*****" + inDTO.toString());

        try {
            //拼接map 调用原子服务
            Map map = cssCodeDefDictInfo.qryByCondForNum(busiInfo);

            OutDTO<Object> outDTO = new OutDTO<>();
            outDTO.setHeader(inDTO.getBodyHeader().getHeader());
            outDTO.setBodyOutData(map);
            return outDTO;
        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "failed query", e.getMessage());
        }
    }
}
