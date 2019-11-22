package com.sitech.family.compservice.service;

import com.sitech.family.compservice.compbiz.IFamilyGoodsLabelQryCo;
import com.sitech.family.common.dto.OprInfo;
import com.sitech.family.common.dto.RequestMessage;
import com.sitech.family.compservice.dto.indto.FamilyGoodsLabel;
import com.sitech.family.compservice.inter.IFamilyGoodsLabelQry;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.message6.dt.Header;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import io.swagger.annotations.ApiModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wusm
 * @description 商品标签查询
 * @date 2019/4/1 17:50
 */
@Service("FamilyGoodsLabelQrySvc")
@ApiModel("商品标签查询")
public class FamilyGoodsLabelQrySvc implements IFamilyGoodsLabelQry {
    private static Logger logger = LoggerFactory.getLogger(FamilyGoodsLabelQrySvc.class);

    @Autowired
    private IFamilyGoodsLabelQryCo iFamilyGoodsLabelQryCo;

    /**
     * 商品标签查询
     *
     * @param inDTO
     * @return outDTO
     */
    @Override
    @ResponseBody
    @RequestMapping("/sFamilyGoodsLabelQry")
    public OutDTO qryFamilyGoodsLabel(@Valid @RequestBody InDTO<RequestMessage<FamilyGoodsLabel>> inDTO) {
        OutDTO outDTO = new OutDTO<>();

        try {
            Header header = inDTO.getHeader();
            OprInfo oprInfo = inDTO.getBodyHeader().getBody().getOprInfo();
            FamilyGoodsLabel familyGoodsLabel = (FamilyGoodsLabel) inDTO.getBodyHeader().getBody().getBusiInfo();

            Map<String, Object> map = new HashMap<>();
            map.put("header", header);
            map.put("oprInfo", oprInfo);
            map.put("busiInfo", familyGoodsLabel);

            Map outMap = iFamilyGoodsLabelQryCo.query(map);

            outDTO.setBodyOutData(outMap);
            return outDTO;
        } catch (Exception e) {
            throw new BusiException("-9999", e.getMessage());
        }
    }
}
