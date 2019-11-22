package com.sitech.family.custqryservice.service;

import com.sitech.family.constants.ReturnCode;
import com.sitech.family.custqryservice.dto.commondto.OprInfo;
import com.sitech.family.custqryservice.dto.commondto.RequestMessage;
import com.sitech.family.custqryservice.dto.outdto.GoodsPrcInfo;
import com.sitech.family.custqryservice.inter.IFamilyGoodsQryAoSvc;
import com.sitech.family.custqryservice.mapper.IPdGoodsDictMapper;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 查询商品信息
 *
 * @author shirley
 * @date created in 2019/6/12
 */
@Service
@Api("商品信息查询")
public class FamilyGoodsQryAoSvc implements IFamilyGoodsQryAoSvc {

    private static final Logger logger = LoggerFactory.getLogger(FamilyGoodsQryAoSvc.class);

    @Resource
    private IPdGoodsDictMapper mapper;

    /**
     * 查询商品信息
     *
     * @param inDTO
     * @return
     */
    @Override
    @ResponseBody
    @RequestMapping("/sFamilyGoodsDictQry")
    @ApiOperation(value = "qryFamilyGoodsDict", notes = "qryFamilyGoodsDict", tags = "qryFamilyGoodsDict")
    public OutDTO<Object> qryFamilyGoodsDict(@RequestBody InDTO<RequestMessage<Map>> inDTO) {

        //获取节点参数
        OprInfo oprInfo = inDTO.getBody().getOprInfo();
        Map busiInfo = inDTO.getBody().getBusiInfo();

        try {

            List<GoodsPrcInfo> goodsPrcInfoList = mapper.qryGoodsDict(busiInfo);

            if (!goodsPrcInfoList.isEmpty()) {
                OutDTO<Object> outDTO = new OutDTO<>();
                outDTO.setHeader(inDTO.getBodyHeader().getHeader());
                Map<String,Object> queryData = new HashMap<>();
                queryData.put("GOODS_PRC_INFO", goodsPrcInfoList.get(0));
                outDTO.setBodyOutData(queryData);
                return outDTO;
            } else {
                OutDTO<Object> outDTO = new OutDTO<>();
                outDTO.setHeader(inDTO.getBodyHeader().getHeader());
                outDTO.setBodyOutData("查询数据为空");
                return outDTO;
            }

        } catch (Exception e) {
            throw new BusiException(ReturnCode.RETURN_CODE_FAIL.getCode(), "查询失败", e.getMessage());
        }
    }
}
