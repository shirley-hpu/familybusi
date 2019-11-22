package com.sitech.family.custqryservice.service;

import com.sitech.family.custqryservice.dto.commondto.RequestMessage;
import com.sitech.family.custqryservice.dto.mapperdto.PdGoodsPrcDict;
import com.sitech.family.custqryservice.inter.IFamilyPkgGoodsAoSvc;
import com.sitech.family.custqryservice.mapper.IPdGoodsPrcDictMapper;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: wusm
 * @Date: 2019-09-24 10:34
 * @Version: 1.0
 */
@Service
public class FamilyPkgGoodsAoSvc implements IFamilyPkgGoodsAoSvc {

    @Autowired
    private IPdGoodsPrcDictMapper mapper;

    /**
     * 查询家庭套餐基本信息
     *
     * @param inDTO
     * @return outDto
     */
    @Override
    @ResponseBody
    @RequestMapping("/sFamilyPkgGoodsInfoQry")
    public OutDTO qryFamilyPkgGoods(@RequestBody InDTO<RequestMessage<Map>> inDTO) {
        OutDTO outDTO = new OutDTO();

        try {
            Map inMap = inDTO.getBodyHeader().getBody().getBusiInfo();

            Map<String,Object> map = new HashMap<>();
            map.put("prcId",inMap.get("PRC_ID"));
            map.put("goodsId",inMap.get("GOODS_ID"));

            PdGoodsPrcDict pdGoodsPrcDict = mapper.qryGoodsPrcInfo(map);

            outDTO.setBodyOutData(pdGoodsPrcDict);
        }catch (Exception e){
            throw new BusiException("-9999",e.getMessage());
        }

        return outDTO;
    }
}
