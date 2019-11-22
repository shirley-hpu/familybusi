package com.sitech.preservice.service;

import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.DateUtil;
import com.sitech.ijcf.message6.dt.Header;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.preservice.atombusi.IFamilyPreOrderRdComAo;
import com.sitech.preservice.dto.commondto.OprInfo;
import com.sitech.preservice.dto.commondto.RequestMessage;
import com.sitech.preservice.inter.IFamilyPreOrderRdComSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/**
 * TODO
 * @author liangjy
 */
@Service
public class FamilyPreOrderRdComSvc implements IFamilyPreOrderRdComSvc {
    @Resource
    private IFamilyPreOrderRdComAo iFamilyPreOrderRdComAo;

    //预受理提交服务
    @Override
    @RequestMapping("/sFamilyPreOrderRdCom")
    @ResponseBody
    public OutDTO commit(@Valid @RequestBody InDTO<RequestMessage<Map>> inDTO) {
        try {
            Header header = inDTO.getHeader();
            OprInfo oprInfo = inDTO.getBody().getOprInfo();
            Map busiInfo = inDTO.getBody().getBusiInfo();
            String phoneNo = (String) busiInfo.get("PHONE_NO");
            if ("".equals(phoneNo) || phoneNo == null){
                throw new BusiException("462701","电话号码不能为空");
            }
            Map<String,Object> inMap = new HashMap<>();
            inMap.put("header",header);
            inMap.put("oprInfo",oprInfo);
            inMap.put("busiInfo",busiInfo);
            OutDTO outDTO = iFamilyPreOrderRdComAo.commit(inMap);
            return outDTO;
        }catch (Exception e){
            throw new BusiException("462701",e.getMessage());
        }
    }

    //预受理查询服务
    @Override
    @RequestMapping("/sFamilyPreOrderRdQry")
    @ResponseBody
    public OutDTO query(@Valid @RequestBody InDTO<RequestMessage<Map>> inDTO) {
        try {
            Header header = inDTO.getHeader();
            OprInfo oprInfo = inDTO.getBody().getOprInfo();
            Map busiInfo = inDTO.getBody().getBusiInfo();

            String phoneNo = (String) busiInfo.get("PHONE_NO");
            if("".equals(phoneNo) || phoneNo == null){
                throw  new BusiException("462702","电话号码不能为空");
            }
            Map inMap = new HashMap();
            inMap.put("header",header);
            inMap.put("opeInfo",oprInfo);
            inMap.put("busiInfo",busiInfo);
            OutDTO outDTO = iFamilyPreOrderRdComAo.query(inMap);
            return outDTO;
        }catch (BusiException e){
            throw new BusiException("462702"+e.getErrCode(),e.getMessage());
        }

    }
}
