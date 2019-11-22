package com.sitech.family.compservice.service;

import com.sitech.family.common.dto.OprInfo;
import com.sitech.family.common.dto.RequestMessage;
import com.sitech.family.compservice.compbiz.IFamilyAddFeeInfoQryCo;
import com.sitech.family.compservice.dto.indto.FamilyAddFeeInfo;
import com.sitech.family.compservice.inter.IFamilyAddFeeInfoQryCoSvc;
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
 * @Date: 2019-07-31 15:37
 * @Version: 1.0
 */
@Service
public class FamilyAddFeeInfoQryCoSvc implements IFamilyAddFeeInfoQryCoSvc {

    @Autowired
    private IFamilyAddFeeInfoQryCo iFamilyAddFeeInfoQryCo;

    /**
     * 附加资费全量信息
     *
     * @param inDTO
     * @return outDTO
     */
    @Override
    @ResponseBody
    @RequestMapping("/sFamilyAddFeeInfoQry")
    public OutDTO qryFamilyAddFeeInfo(@RequestBody InDTO<RequestMessage<FamilyAddFeeInfo>> inDTO) {
        OutDTO outDTO = new OutDTO();

        try {
            Header header = inDTO.getHeader();
            RequestMessage requestMessage = inDTO.getBodyHeader().getBody();
            OprInfo oprInfo = requestMessage.getOprInfo();
            FamilyAddFeeInfo familyAddFeeInfo = (FamilyAddFeeInfo) requestMessage.getBusiInfo();

            Map<String, Object> map = new HashMap<>();
            map.put("header", header);
            map.put("oprInfo", oprInfo);
            map.put("busiInfo", familyAddFeeInfo);

            Map outMap = iFamilyAddFeeInfoQryCo.qryFamilyAddFeeInfo(map);

            outDTO.setBodyOutData(outMap);
        } catch (Exception e) {
            throw new BusiException("-9999", e.getMessage());
        }

        return outDTO;
    }
}
