package com.sitech.family.compservice.service;

import com.sitech.family.compservice.compbiz.IFamilyGoodsChkCo;
import com.sitech.family.common.dto.OprInfo;
import com.sitech.family.common.dto.RequestMessage;
import com.sitech.family.compservice.dto.indto.FamilyGoodsChk;
import com.sitech.family.compservice.inter.IFamilyGoodsChkCoSvc;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.message6.dt.Header;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
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

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author wusm
 * @description 关系校验
 * @date 2018/9/28 16:00
 */
@Service("FamilyGoodsChkCoSvc")
public class FamilyGoodsChkCoSvc implements IFamilyGoodsChkCoSvc {
    private static Logger logger = LoggerFactory.getLogger(FamilyGoodsChkCoSvc.class);

    @Resource(name = "FamilyGoodsChkCo")
    private IFamilyGoodsChkCo iFamilyGoodsChkCo;

    /**
     * 关系校验
     * @param inDTO
     * @return outDTO
     */
    @Override
    @ResponseBody
    @RequestMapping("/sFamilyGoodsChk")
    public OutDTO chkFamilyGoods(@Valid @RequestBody InDTO<RequestMessage<FamilyGoodsChk>> inDTO) {
        OutDTO outDTO = new OutDTO<>();

        try {
            Header header = inDTO.getHeader();
            OprInfo oprInfo = inDTO.getBodyHeader().getBody().getOprInfo();
            FamilyGoodsChk familyGoodsChk = (FamilyGoodsChk) inDTO.getBodyHeader().getBody().getBusiInfo();

            Map<String, Object> map = new HashMap<>();
            map.put("header", header);
            map.put("oprInfo", oprInfo);
            map.put("busiInfo", familyGoodsChk);

            Map outMap = iFamilyGoodsChkCo.check(map);

            outDTO.setBodyOutData(outMap);
        } catch (Exception e) {
            logger.error("关系校验失败" + e.getMessage());
            throw new BusiException(getErrorCode("1000", "15000"), e.getMessage());
        }

        return outDTO;
    }

}
