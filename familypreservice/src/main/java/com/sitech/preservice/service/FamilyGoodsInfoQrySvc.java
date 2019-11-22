package com.sitech.preservice.service;

import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.message6.dt.Header;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.preservice.atombusi.IFamilyGoodsInfoQryAo;
import com.sitech.preservice.dto.commondto.OprInfo;
import com.sitech.preservice.dto.commondto.RequestMessage;
import com.sitech.preservice.inter.IFamilyGoodsInfoQrySvc;
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
public class FamilyGoodsInfoQrySvc implements IFamilyGoodsInfoQrySvc {
    @Resource
    private IFamilyGoodsInfoQryAo iFamilyGoodsInfoQryAo;

    //根据价格区间查询家庭套餐信息
    @Override
    @ResponseBody
    @RequestMapping("/sFamilyGoodsInfoQry")
    public OutDTO<Map> qryFamilyGoodsInfoByPrc(@Valid @RequestBody InDTO<RequestMessage<Map>> inDTO) {
        try {
            Header header = inDTO.getHeader();
            OprInfo oprInfo = inDTO.getBody().getOprInfo();
            Map busiInfo =  inDTO.getBody().getBusiInfo();

            Map<String,Object> inMap = new HashMap<>();
            inMap.put("header",header);
            inMap.put("oprInfo",oprInfo);
            inMap.put("busiInfo",busiInfo);
            OutDTO<Map> outDTO = iFamilyGoodsInfoQryAo.qryFamilyGoodsInfoByPrc(inMap);
            return outDTO;
        }catch (BusiException e){
            throw new BusiException("462701"+e.getErrCode(),e.getMessage());
        }
    }
}
