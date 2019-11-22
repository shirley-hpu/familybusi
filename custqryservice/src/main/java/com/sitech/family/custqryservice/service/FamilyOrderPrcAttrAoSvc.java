package com.sitech.family.custqryservice.service;

import com.sitech.family.custqryservice.dto.commondto.RequestMessage;
import com.sitech.family.custqryservice.dto.mapperdto.UserGoodsAttr;
import com.sitech.family.custqryservice.inter.IFamilyOrderPrcAttrAoSvc;
import com.sitech.family.custqryservice.mapper.IUserGoodsAttrMapper;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: wusm
 * @Date: 2019-09-25 15:33
 * @Version: 1.0
 */
@Service
public class FamilyOrderPrcAttrAoSvc implements IFamilyOrderPrcAttrAoSvc {

    @Autowired
    private IUserGoodsAttrMapper iUserGoodsAttrMapper;

    /**
     * 查询资费属性信息
     *
     * @param inDTO
     * @return outDTO
     */
    @Override
    @ResponseBody
    @RequestMapping("/sFamilyOrderPrcAttrQry")
    public OutDTO qryFamilyOrderPrcAttr(@RequestBody InDTO<RequestMessage<Map>> inDTO) {
        OutDTO outDTO = new OutDTO();

        try {
            Map inMap = inDTO.getBodyHeader().getBody().getBusiInfo();

            Map<String, Object> map = new HashMap<>();
            map.put("idNo", inMap.get("ID_NO"));
            map.put("prcId", inMap.get("PRC_ID"));

            List<UserGoodsAttr> list = iUserGoodsAttrMapper.qryUserGoodsAttrList(map);

            List<Map> attrList = new ArrayList<>();
            for (UserGoodsAttr userGoodsAttr : list) {
                Map<String, Object> attrMap = new HashMap<>();
                attrMap.put("ATTR_ID", userGoodsAttr.getAttrId());
                attrMap.put("ATTR_NO", userGoodsAttr.getAttrNo());
                attrMap.put("ATTR_VALUE", userGoodsAttr.getAttrValue());
                attrMap.put("EXP_DATE", userGoodsAttr.getExpDate());
                attrMap.put("EFF_DATE", userGoodsAttr.getEffDate());
                attrMap.put("PRC_ID", userGoodsAttr.getPrcId());
                attrMap.put("ID_NO", userGoodsAttr.getIdNo());
                attrList.add(attrMap);
            }

            Map<String, Object> outMap = new HashMap<>();
            outMap.put("ATTR_LIST", attrList);

            outDTO.setBodyOutData(outMap);

            return outDTO;
        } catch (Exception e) {
            throw new BusiException("-9999", e.getMessage());
        }
    }
}
