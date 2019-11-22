package com.sitech.preservice.service;

import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.message6.dt.Header;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.preservice.atombusi.IStandardRegionQryAo;
import com.sitech.preservice.dto.commondto.OprInfo;
import com.sitech.preservice.dto.commondto.RequestMessage;
import com.sitech.preservice.inter.IStandardRegionQrySvc;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Map;
/**
 * TODO
 * @author liangjy
 */
@Service
public class StandardRegionQrySvc implements IStandardRegionQrySvc {

    @Resource
    private IStandardRegionQryAo iStandardRegionQryAo;

    //根据GROUP_ID查询地市信息
    @Override
    @RequestMapping("/sStandardCityQry")
    @ResponseBody
    public OutDTO queryStandardRegion(@Valid @RequestBody InDTO<RequestMessage<Map>> inDTO) {
        try {
            Header header = inDTO.getHeader();
            Map map = inDTO.getBody().getBusiInfo();
            OprInfo oprInfo = inDTO.getBody().getOprInfo();

            String groupId = (String) map.get("GROUP_ID");
            if("".equals(groupId) || groupId == null){
                throw new BusiException("1","GROUP_ID不能为空");
            }
            OutDTO<Map> outDTO = iStandardRegionQryAo.queryStandardRegion(map);
            return outDTO;
        }catch (BusiException e){
            throw new BusiException("0000"+e.getErrCode(),e.getMessage());
        }
    }
}
