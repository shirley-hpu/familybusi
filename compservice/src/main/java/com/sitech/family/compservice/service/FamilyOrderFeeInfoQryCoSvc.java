package com.sitech.family.compservice.service;

import com.sitech.family.common.dto.OprInfo;
import com.sitech.family.common.dto.RequestMessage;
import com.sitech.family.compservice.compbiz.IFamilyOrderFeeInfoQryCo;
import com.sitech.family.compservice.dto.indto.FamilyOrderFeeInfo;
import com.sitech.family.compservice.inter.IFamilyOrderFeeInfoQryCoSvc;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.message6.dt.Header;
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
 * @Date: 2019-08-12 15:23
 * @Version: 1.0
 */
@Service
public class FamilyOrderFeeInfoQryCoSvc implements IFamilyOrderFeeInfoQryCoSvc {

    @Autowired
    private IFamilyOrderFeeInfoQryCo iFamilyOrderFeeInfoQryCo;

    /**
     * 附加资费已订购信息
     *
     * @param inDTO
     * @return outDTO
     */
    @Override
    @ResponseBody
    @RequestMapping("/sFamilyOrderFeeInfoQry")
    public OutDTO qryFamilyOrderFeeInfo(@RequestBody @Valid InDTO<RequestMessage<FamilyOrderFeeInfo>> inDTO) {
        OutDTO outDTO = new OutDTO();

        try {
            Header header = inDTO.getHeader();
            RequestMessage requestMessage = inDTO.getBodyHeader().getBody();
            OprInfo oprInfo = requestMessage.getOprInfo();
            FamilyOrderFeeInfo familyOrderFeeInfo  = (FamilyOrderFeeInfo) requestMessage.getBusiInfo();

            Map<String, Object> map = new HashMap<>();
            map.put("header", header);
            map.put("oprInfo", oprInfo);
            map.put("busiInfo", familyOrderFeeInfo);

            Map outMap = iFamilyOrderFeeInfoQryCo.qryFamilyOrderFeeInfo(map);

            outDTO.setBodyOutData(outMap);
        } catch (Exception e) {
            throw new BusiException("-9999", e.getMessage());
        }

        return outDTO;
    }
}
