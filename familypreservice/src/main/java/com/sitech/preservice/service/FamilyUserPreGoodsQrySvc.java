package com.sitech.preservice.service;

import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.message6.dt.Header;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.preservice.atombusi.IFamilyUserPreGoodsQryAo;
import com.sitech.preservice.dto.commondto.OprInfo;
import com.sitech.preservice.dto.commondto.RequestMessage;
import com.sitech.preservice.inter.IFamilyUserPreGoodsQrySvc;
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
import java.util.Map;
/**
 * TODO
 * @author liangjy
 */

@Service
public class FamilyUserPreGoodsQrySvc implements IFamilyUserPreGoodsQrySvc {
    @Resource
    private IFamilyUserPreGoodsQryAo iFamilyUserPreGoodsQryAo;

    private static Logger logger = LoggerFactory.getLogger(FamilyUserPreGoodsQrySvc.class);

    //查询用户已办权益及赠送权益（宽带、iptv、ims固话）
    @Override
    @ResponseBody
    @RequestMapping("/sFamilyUserPreGoodsQry")
    @ApiOperation(value = "qryFamilyUserPreGoods", notes = "qryFamilyUserPreGoods", tags = "qryFamilyUserPreGoods")
    public OutDTO<Map> qryFamilyUserPreGoods(@Valid @RequestBody InDTO<RequestMessage<Map>> inDTO) {
        OutDTO<Map> outDTO;
        try {
            Header header = inDTO.getHeader();
            OprInfo oprInfo = inDTO.getBody().getOprInfo();
            Map busiInfo = inDTO.getBody().getBusiInfo();
            logger.debug("++++++++++++++++");
            Map<String,Object> inMap = new HashMap<>();
            inMap.put("header",header);
            inMap.put("oprInfo",oprInfo);
            inMap.put("busiInfo",busiInfo);
            logger.debug("------------------");
            outDTO = iFamilyUserPreGoodsQryAo.qryFamilyUserPreGoods(inMap);
            return outDTO;
        }catch (BusiException e){
            throw new BusiException("462701"+e.getErrCode(),e.getMessage());
        }
    }
}
