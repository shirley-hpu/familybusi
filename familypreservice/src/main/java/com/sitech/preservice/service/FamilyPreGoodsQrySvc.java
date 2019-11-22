package com.sitech.preservice.service;

import com.sitech.family.constants.ReturnCode;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.preservice.dto.CssCodeDef;
import com.sitech.preservice.dto.PreGoods;
import com.sitech.preservice.dto.commondto.OprInfo;
import com.sitech.preservice.dto.commondto.RequestMessage;
import com.sitech.preservice.inter.IFamilyPreGoodsQrySvc;
import com.sitech.preservice.mapper.CssCodeDefMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 推荐套餐查询
 *
 * @author shirley
 * @version 1.0
 * @date 2019/10/9 下午4:45
 */
@Service
@Api("推荐套餐")
public class FamilyPreGoodsQrySvc implements IFamilyPreGoodsQrySvc {

    private static final Logger logger = LoggerFactory.getLogger(FamilyPreGoodsQrySvc.class);

    @Autowired
    private CssCodeDefMapper cssCodeDefMapper;

    /**
     * 推荐套餐查询
     *
     * @param inDTO         :
     * @param bindingResult :
     * @return OutDTO<Object>
     */
    @Override
    @ResponseBody
    @RequestMapping("/sFamilyPreGoodsQry")
    @ApiOperation(value = "qryFamilyPreGoods", notes = "qryFamilyPreGoods", tags = "qryFamilyPreGoods")
    public OutDTO<Object> qryFamilyPreGoods(@Valid @RequestBody InDTO<RequestMessage<Map>> inDTO, BindingResult bindingResult) {

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
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "查询失败", errorInfo.toString());
        }

        //获取节点参数
        OprInfo oprInfo = inDTO.getBody().getOprInfo();
        Map busiInfo = inDTO.getBody().getBusiInfo();

        logger.debug("***** inDto：*****" + inDTO.toString());

        try {
            //拼接map 调用原子服务
            List<CssCodeDef> list = cssCodeDefMapper.qryByCondAll(busiInfo);

            List<PreGoods> data = new ArrayList<>();
            for (CssCodeDef temp : list) {
                PreGoods preGoods = new PreGoods();
                preGoods.setGoodsId(temp.getValueId());
                preGoods.setGoodsName(temp.getBeginValueDesc());
                preGoods.setPrcId(temp.getValueId());
                preGoods.setPrcName(temp.getBeginValueDesc());
                preGoods.setPrcDesc(temp.getClassDesc());
                preGoods.setFreeSum(temp.getBeginValue());
                preGoods.setEffDate(temp.getEffDate());
                preGoods.setExpDate(temp.getExpDate());
                data.add(preGoods);
            }

            OutDTO<Object> outDTO = new OutDTO<>();
            outDTO.setHeader(inDTO.getBodyHeader().getHeader());
            Map<String, Object> map = new HashMap<>();
            map.put("GOODSLIST", data);
            outDTO.setBodyOutData(map);
            return outDTO;
        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "查询失败", e.getMessage());
        }
    }
}
