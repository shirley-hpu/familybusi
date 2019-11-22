package com.sitech.preservice.service;

import com.sitech.ijcf.boot.core.util.DateUtil;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.preservice.dto.FamilyPreOrderCfm;
import com.sitech.preservice.dto.ReturnOutDto;
import com.sitech.preservice.dto.commondto.RequestMessage;
import com.sitech.preservice.inter.IFamilyPreOrderCfmSvc;
import com.sitech.preservice.mapper.FmPreOrderMidMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wusm
 * @description
 * @date 2019/5/30 16:23
 */
@Service
public class FamilyPreOrderCfmSvc implements IFamilyPreOrderCfmSvc {

    @Autowired
    private FmPreOrderMidMapper mapper;

    /**
     * 预受理提交服务
     *
     * @param inDTO
     * @return
     */
    @ResponseBody
    @RequestMapping("/sFamilyPreOrderCfm")
    @Override
    public OutDTO commit(@Valid @RequestBody(required = false) InDTO<RequestMessage<FamilyPreOrderCfm>> inDTO) {
        OutDTO<ReturnOutDto> outDTO = new OutDTO<ReturnOutDto>();
        ReturnOutDto returnOutDto = new ReturnOutDto();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            RequestMessage requestMessage = inDTO.getBodyHeader().getBody();
            FamilyPreOrderCfm familyPreOrderCfm = (FamilyPreOrderCfm) requestMessage.getBusiInfo();
            FamilyPreOrderCfm.PreoderInfo preoderInfo = familyPreOrderCfm.getPreoderInfo();
            preoderInfo.setOpTime(new Date());
            preoderInfo.setInstallTime(DateUtil.toDate(sdf.format(preoderInfo.getInstallTime()),"yyyy-MM-dd"));

            int count = mapper.commit(preoderInfo);

            if (count > 0){
                returnOutDto.setRtnCode("0");
                returnOutDto.setRtnMsg("预受理提交服务成功");
            }
        } catch (Exception e) {
            returnOutDto.setRtnCode("-9999");
            returnOutDto.setRtnMsg("预受理提交服务失败:" +e.getMessage());
            outDTO.setBodyOutData(returnOutDto);
            return outDTO;
        }

        outDTO.setBodyOutData(returnOutDto);
        return outDTO;
    }
}
