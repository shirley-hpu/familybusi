package com.sitech.family.custqryservice.service;

import com.sitech.family.custqryservice.atombusi.IFamilyUserInfo;
import com.sitech.family.custqryservice.dto.commondto.RequestMessage;
import com.sitech.family.custqryservice.inter.IFamilyOrderFeeQryAoSvc;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: wusm
 * @Date: 2019-08-12 15:54
 * @Version: 1.0
 */
@Service
public class FamilyOrderFeeQryAoSvc implements IFamilyOrderFeeQryAoSvc {

    @Resource(name="familyUserInfo")
    private IFamilyUserInfo iFamilyUserInfo;

    /**
     * 根据手机号码查询已订购附加资费信息
     *
     * @param inDTO
     * @return outDTO
     */
    @Override
    @ResponseBody
    @RequestMapping("/sFamilyOrderFeeInfo")
    public OutDTO qryFamilyOrderFee(@RequestBody @Valid InDTO<RequestMessage<Map>> inDTO) {
        OutDTO outDTO = new OutDTO();

        try {
            RequestMessage requestMessage = inDTO.getBody();
            Map map = (Map) requestMessage.getBusiInfo();

            List list = iFamilyUserInfo.qryOrderFeeByPhoneNo(map);

            outDTO.setBodyOutData(list);
        } catch (Exception e) {
            throw new BusiException("-9999", e.getMessage());
        }

        return outDTO;
    }
}
