package com.sitech.preservice.atombusi.impl;

import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.service.ArchitectureType;
import com.sitech.ijcf.boot.core.service.client.IServiceClient;
import com.sitech.ijcf.message6.dt.Header;
import com.sitech.ijcf.message6.dt.Routing;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.ijcf.message6.dt.support.MBean;
import com.sitech.preservice.atombusi.IStandardRegionQryAo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
@Component("StandardRegionQryAo")
public class StandardRegionQryAo implements IStandardRegionQryAo {

    @Resource
    private IServiceClient serviceClient;

    @Override
    public OutDTO<Map> queryStandardRegion(Map map) {
        try {
            MBean mBean = new MBean();
            OutDTO outDTO = new OutDTO();
            Header header = new Header();
            Routing routing = new Routing();
            routing.setRouteKey("15");
            routing.setRouteValue("16");
            header.setRouting(routing);
            mBean.setHeader(header);

            map.put("ROOT_DISTANCE","0");

            mBean.setBody(map);
            outDTO = serviceClient.callService("http://10.208.225.85:30411/esbWS/rest/com_sitech_basemng_atom_inter_IQryGroupRegionSvc_qryGetGroupRegion",
                    mBean.toString(),OutDTO.class,ArchitectureType.ESB_REST);
            return outDTO;
        }catch (Exception e){
            throw new BusiException("01",e.getMessage());
        }
    }
}
