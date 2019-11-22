package com.sitech.family.compservice.service;

import com.sitech.family.common.dto.OprInfo;
import com.sitech.family.common.util.CommonCheckUtil;
import com.sitech.family.compservice.compbiz.IPhoneQryCo;
import com.sitech.family.common.dto.RequestMessage;
import com.sitech.family.compservice.compbiz.IStandardAddressQryCo;
import com.sitech.family.compservice.dto.indto.BusiInfoAddress;
import com.sitech.family.compservice.dto.indto.PhoneNoPreemptInDto;
import com.sitech.family.compservice.dto.indto.PhoneQryInDto;
import com.sitech.family.compservice.dto.outdto.StandarAddressOutDto;
import com.sitech.family.compservice.inter.IResourceInfoCoSvc;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import com.sitech.ijcf.message6.dt.Header;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import com.sitech.ijcf.message6.dt.support.MBean;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.validation.Valid;

import java.util.HashMap;
import java.util.Map;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * Created by xuwei on 2018/12/13.john
 */
@Service("ResourceInfoCoSvc")
public class ResourceInfoCoSvc implements IResourceInfoCoSvc {

    private static Logger logger = LoggerFactory.getLogger(ResourceInfoCoSvc.class);

    @Resource
    private IPhoneQryCo iPhoneQryCo;

    @Resource
    private IStandardAddressQryCo iStandardAddressQryCo;

    /**
     * 号码查询
     *
     * @param inDTO
     * @return
     */
    @Override
    @ResponseBody
    @RequestMapping("/sPhoneNoQry")
    @ApiOperation(value = "号码查询", notes = "号码查询", tags = "qryPhoneNo")
    public OutDTO<Object> qryPhoneNo(@Valid @RequestBody InDTO<RequestMessage<PhoneQryInDto>> inDTO,BindingResult bindingResult) {
        if (StringUtil.isEmptyOrNull(inDTO.getBody().getBusiInfo())) {
            throw new BusiException(getErrorCode("1000", "160001"), "入参节点BUSI_INFO不能为空!");
        }
        //获取注解校验错误信息
        CommonCheckUtil.inDTOCheck(bindingResult);

        //header校验
        CommonCheckUtil.getHeaderDataCheck(inDTO);
        try {
            Header header = inDTO.getBodyHeader().getHeader();
            RequestMessage<PhoneQryInDto> body = inDTO.getBodyHeader().getBody();

            Map<String, Object> paramInDto = new HashMap<>(3);
            paramInDto.put("header", header);
            paramInDto.put("oprInfo", body.getOprInfo());
            paramInDto.put("BUSI_INFO", body.getBusiInfo());

            Map<String,Object> outMap = iPhoneQryCo.query(paramInDto);
            OutDTO<Object> outDTO = new OutDTO<>();
            outDTO.setBodyOutData(outMap);
            return outDTO;
        }catch (Exception e){
            throw new BusiException("99999999999999999", "号码查询异常", e.getMessage());
        }
    }

    /**
     * SIM卡号查询
     * @param inDTO
     * @return
     */
    @Override
    @ResponseBody
    @RequestMapping("/sSimNoQry")
    @ApiOperation(value = "SIM卡号查询",notes = "SIM卡号查询",tags = "sSimNoQry")
    public OutDTO<Object> qrySimNo(@RequestBody InDTO<RequestMessage<Map>> inDTO) {
        OprInfo oprInfo = inDTO.getBody().getOprInfo();
        try {
            Header header = inDTO.getBodyHeader().getHeader();
            Map<String, Object> paramInDto = new HashMap<>(3);
            paramInDto.put("header", header);
            paramInDto.put("oprInfo", oprInfo);

            Map<String,Object> outMap = iPhoneQryCo.querySim(paramInDto);
            OutDTO<Object> outDTO = new OutDTO<>();
            outDTO.setBodyOutData(outMap);
            return outDTO;
        }catch (Exception e){
            throw new BusiException("99999999999999999", "SIM卡号查询异常", e.getMessage());
        }
    }

    /**
     * 宽带安装地址查询
     *
     * @param inDTO
     * @return
     */
    @Override
    @ResponseBody
    @RequestMapping("/sStandardAddressQry")
    public OutDTO qryStandardAddress(@Valid @RequestBody InDTO<RequestMessage<Map>> inDTO) {
        /**
         //         * 假如远程调用入参如下
         //         * {
         //         *     "ROOT": {
         //         *         "BODY": {
         //         *             "BUSI_INFO": {
         //         *                 "City": "01",
         //         *                 "village": "测试",
         //         *                 "StandardAddress_Id": "12"
         //         *             }
         //         *         }
         //         *     }
         //         * }
         //         */
        //        // 业务数据
        Header header = inDTO.getHeader();
        OprInfo oprInfo = inDTO.getBody().getOprInfo();
        Map address = inDTO.getBody().getBusiInfo();

        /**
         * 此处需要针对远程调用callService重新封装入参
         */
        OutDTO outDTO = new OutDTO();

        if("0".equals(address.get("QUERY_TYPE"))){
            BusiInfoAddress preciseQuery =  (BusiInfoAddress)address.get("preciseQuery");
            Map mapBusi = new HashMap<String, String>();

            mapBusi.put("City", preciseQuery.getRegionId());
            mapBusi.put("village", preciseQuery.getCommunityName());
            mapBusi.put("StandardAddress_Id", preciseQuery.getStandardAddressId());
            mapBusi.put("queryType", address.get("queryType"));

            Map mapBody = new HashMap<String, Object>();
            mapBody.put("BUSI_INFO", mapBusi);

            InDTO remoteInDTO = new InDTO<Map>();
            remoteInDTO.setBody(mapBody);
            outDTO = (OutDTO<StandarAddressOutDto>) iStandardAddressQryCo.query(remoteInDTO);
        }else {
            Map fuzzyQuery = (Map)address.get("FUZZY_QUERY");

            fuzzyQuery.put("QUERY_TYPE",address.get("QUERY_TYPE"));

            Map mapBody = new HashMap<String, Object>();

            mapBody.put("BUSI_INFO",fuzzyQuery);

            InDTO remoteInDTO = new InDTO<Map>();
            remoteInDTO.setBody(mapBody);
            outDTO = iStandardAddressQryCo.query(remoteInDTO);
        }

        return outDTO;
    }

    /**
     * 号码预占
     *
     * @param inDTO
     * @return
     */
    @Override
    @ResponseBody
    @RequestMapping("/sPhoneNoPreemptSub")
    public OutDTO<Object> subPhoneNoPreempt(@RequestBody InDTO<RequestMessage<PhoneNoPreemptInDto>> inDTO) {
        OutDTO<Object> outDTO = new OutDTO<>();
        MBean mBean = new MBean();
        String outParam = "";
        try {
            /**
             * 拼接查询参数节点下的信息
             */
            Map<String, Object> busiInfo = new HashMap<>();

            busiInfo.put("RES_OPR", "3");
            busiInfo.put("LOGIN_NO", "wwwwww");
            busiInfo.put("PHON", inDTO.getBody().getBusiInfo().getPhoneNo());
            busiInfo.put("QUERY_FLAG", "4");
            busiInfo.put("OP_CODE", "1000");
            busiInfo.put("OPR_TYPE", inDTO.getBody().getBusiInfo().getOprType());
            busiInfo.put("MIN_COST_FEE", "0");
            busiInfo.put("NEED_ATTR", "Y");

            mBean.addBody("BUSI_INFO", busiInfo);

           /* OutDTO<Map> mapOutDTO = serviceClient.callService("com_sitech_res_inter_outinter_IUpdNoByNoGrpSvc_updPhoneStatus",
                    mBean.toString(), OutDTO.class);

            logger.info("mapOutDTO=", mapOutDTO);E_NO

            outDTO.setBodyOutData(mapOutDTO);*/
            System.out.println("电话号码" + inDTO.getBody().getBusiInfo().getPhoneNo());
            Map<String, Object> map = new HashMap<>(16);

            outDTO.setBodyOutData(map);

        } catch (Exception e) {
            e.printStackTrace();
            throw new BusiException(getErrorCode("1000", "160030", "调用资源接口错误"), e);
        }
        return outDTO;
    }

    /**
     * 号码释放
     *
     * @param inDTO
     * @return
     */
    @Override
    @ResponseBody
    @RequestMapping("/sPhoneNoReleaseSub")
    public OutDTO<Object> subPhoneNoRelease(InDTO<RequestMessage<PhoneNoPreemptInDto>> inDTO) {
        return null;
    }
}
