package com.sitech.family.compservice.service;

import com.sitech.family.common.dto.OprInfo;
import com.sitech.family.common.dto.RequestMessage;
import com.sitech.family.compservice.compbiz.IFamilyMbrPrcChgCo;
import com.sitech.family.compservice.dto.indto.FamilyMemPrcChg;
import com.sitech.family.compservice.inter.IFamilyMbrPrcChgCoSvc;
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

@Service
public class FamilyMbrPrcChgCoSvc implements IFamilyMbrPrcChgCoSvc {

    @Autowired
    private IFamilyMbrPrcChgCo iFamilyMbrPrcChgCo;

    /**
     * 成员资费变更
     *
     * @param inDTO
     * @return outDTO
     */
    @Override
    @ResponseBody
    @RequestMapping("/sFamilyMbrPrcChg")
    public OutDTO updateMemberPrc(@Valid @RequestBody InDTO<RequestMessage<FamilyMemPrcChg>> inDTO) {
        OutDTO outDTO = new OutDTO();

        try {
            RequestMessage requestMessage = (RequestMessage) inDTO.getBody();
            FamilyMemPrcChg familyMemPrcChg = (FamilyMemPrcChg) requestMessage.getBusiInfo();
            OprInfo oprInfo = requestMessage.getOprInfo();

            Map<String, Object> map = new HashMap<>();
            map.put("busiInfo", familyMemPrcChg);
            map.put("oprInfo", oprInfo);

            Map outMap = iFamilyMbrPrcChgCo.updateMemberPrc(map);

            outDTO.setBodyOutData(outMap);
        } catch (Exception e) {
            throw new BusiException("-9999", e.getMessage());
        }

        return outDTO;
    }
}
