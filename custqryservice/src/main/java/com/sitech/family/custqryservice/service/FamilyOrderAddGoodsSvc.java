package com.sitech.family.custqryservice.service;

import com.sitech.family.custqryservice.compbusi.IFamilyOrderAddGoodsCo;
import com.sitech.family.custqryservice.dto.commondto.RequestMessage;
import com.sitech.family.custqryservice.dto.indto.FamilyOrderAdditionGoods;
import com.sitech.family.custqryservice.inter.IFamilyOrderAddGoodsSvc;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: wusm
 * @Date: 2019-09-19 15:08
 * @Version: 1.0
 */
@Service
public class FamilyOrderAddGoodsSvc implements IFamilyOrderAddGoodsSvc {

    @Autowired
    private IFamilyOrderAddGoodsCo iFamilyOrderAddGoodsCo;

    /**
     * 家庭已订购附加商品信息查询
     *
     * @param inDto
     * @return OutDTO
     */
    @Override
    @ResponseBody
    @RequestMapping("/sFamilyOrderAdditionGoodsQry")
    public OutDTO qryFamilyOrderAdditionGoods(@Valid @RequestBody InDTO<RequestMessage<FamilyOrderAdditionGoods>> inDto) {
        OutDTO outDTO = new OutDTO();

        try {
            RequestMessage requestMessage = inDto.getBodyHeader().getBody();
            FamilyOrderAdditionGoods familyOrderAdditionGoods = (FamilyOrderAdditionGoods) requestMessage.getBusiInfo();

            Map<String, String> map = new HashMap<>();
            map.put("idNo", familyOrderAdditionGoods.getIdNo());

            Map outMap = iFamilyOrderAddGoodsCo.qryFamilyOrderAdditionGoods(map);

            outDTO.setBodyOutData(outMap);

            return outDTO;
        } catch (Exception e) {
            throw new BusiException("-9999", e.getMessage());
        }
    }
}
