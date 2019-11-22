package com.sitech.family.common.util;

import com.alibaba.fastjson.JSONObject;
import com.sitech.family.common.dto.OprInfo;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import com.sitech.ijcf.message6.dt.Routing;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.*;

import static com.sitech.family.common.errorcode.AppErrorCode.getErrorCode;

/**
 * @author : shirley
 * @version : 1.0
 * @description ： 参数校验工具类
 * @date : 2018/9/13 10:54
 */
public class CommonCheckUtil {

    /**
     * 获取注解校验错误信息
     *
     * @param bindingResult
     */
    public static void inDTOCheck(BindingResult bindingResult) {

        StringBuffer errorInfo;

        if (bindingResult.hasErrors()) {

            errorInfo = new StringBuffer();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();

            for (FieldError fieldError : fieldErrors) {
                //日志打印不符合校验的字段名和错误提示
                //logger.debug("error field is : {} ,message is : {} ", fieldError.getField(), fieldError.getDefaultMessage());
                errorInfo.append(fieldError.getDefaultMessage()).append(",");
            }

            String substring = errorInfo.substring(0, errorInfo.length() - 1);
            throw new BusiException("99999999999999999", "处理失败", substring);
        }
    }


    /**
     * 入参校验 [key:key; value1:value; value2:chinese]
     *
     * @param paramMap
     * @return map
     * @throws BusiException 业务异常
     */
    public static Map paramCheck(MultiValueMap<String, String> paramMap) {

        if (paramMap.size() == 0) {
            throw new BusiException(getErrorCode("1000", "15000"), "处理失败，入参节点不存在或为空！");
        }

        Map<String, String> parameterMap = new HashMap<>(16);
        //遍历map 做参数校验
        Set<String> keySet = paramMap.keySet();
        for (String key : keySet) {
            List<String> values = paramMap.get(key);
            if (StringUtil.isEmptyOrNull(values.get(0))) {
                throw new BusiException("99999999999999999", "处理失败，" + key + "[" + values.get(1) + "]节点不存在或为空！");
            }
            parameterMap.put(key, values.get(0));
        }
        return parameterMap;
    }


    /**
     * 入参OprInfoDto数据提取并校验
     *
     * @param oprInfoDto
     * @return paramMap
     * @throws BusiException 业务异常
     */
    public static Map oprInfoCheck(OprInfo oprInfoDto) {
        MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>(16);

        if (StringUtil.isEmptyOrNull(oprInfoDto)) {
            throw new BusiException(getErrorCode("1000", "15000"), "入参节点[OPR_INFO]不存在或为空!");
        }

        paramMap.add("REGION_ID", oprInfoDto.getRegionId());
        paramMap.add("REGION_ID", "地市");
        paramMap.add("LOGIN_NO", oprInfoDto.getLoginNo());
        paramMap.add("LOGIN_NO", "工号");
        //    paramMap.add("OP_CODE", oprInfoDto.getOpCode());
        //    paramMap.add("OP_CODE", "操作代码");
        paramMap.add("CONTACT_ID", oprInfoDto.getContactId());
        paramMap.add("CONTACT_ID", "接触ID");
        paramMap.add("OP_NOTE", oprInfoDto.getOpNote());
        paramMap.add("OP_NOTE", "操作备注");
        paramMap.add("CHANNEL_TYPE", oprInfoDto.getChannelType());
        paramMap.add("CHANNEL_TYPE", "渠道类型");
        //    paramMap.add("APPLY_ID", oprInfoDto.getApplyId());
        //    paramMap.add("APPLY_ID", "授权申请编码");
        paramMap.add("GROUP_ID", oprInfoDto.getGroupId());
        paramMap.add("GROUP_ID", "营业厅代码");

        return paramCheck(paramMap);
    }


    /**
     * 入参header数据提取并校验
     *
     * @param requestMessage
     * @return paramMap
     * @throws BusiException 业务异常
     */
    public static Map getHeaderDataCheck(InDTO requestMessage) {

        MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>(6);
        //获取路由信息并校验

        if (StringUtil.isEmptyOrNull(requestMessage) || StringUtil.isEmptyOrNull(requestMessage.getHeader())) {
            throw new BusiException("99999999999999999", "处理失败,入参不存在或为空!");
        }

        Routing header = requestMessage.getHeader().getRouting();
        if (StringUtil.isEmptyOrNull(header)) {
            throw new BusiException("99999999999999999", "入参节点[ROUTING]不存在或为空!");
        }

        String routeKey = header.getRouteKey();
        String routeValue = header.getRouteValue();
//        String channelId = (String) requestMessage.getHeader().get("CHANNEL_ID");

        if (StringUtil.isEmptyOrNull(routeKey)) {
            throw new BusiException("99999999999999999", "入参节点[ROUTE_KEY]不存在或为空!");
        }

        if (StringUtil.isEmptyOrNull(routeValue)) {
            throw new BusiException("99999999999999999", "入参节点[ROUTE_VALUE]不存在或为空!");
        }

        paramMap.add("ROUTE_KEY", routeKey);
        paramMap.add("ROUTE_KEY", "路由类型");
        paramMap.add("ROUTE_VALUE", routeValue);
        paramMap.add("ROUTE_VALUE", "路由值");

        //校验header节点下routing节点参数  并返回map
        paramCheck(paramMap);

        return requestMessage.getBodyHeader().getHeader();
    }


    private static final String RETURN_CODE = "0";

    /**
     * 出参结果判断:0-成功 其他值-失败
     *
     * @param : outParam
     */
    public static void getOutParamCheck(OutDTO<Map> mapOutDTO) {

        JSONObject jsonObject = JSONObject.parseObject(mapOutDTO.toJsonString());

        JSONObject outData = jsonObject.getJSONObject("ROOT").getJSONObject("BODY");

        //判断出参节点
        if (!RETURN_CODE.equals(outData.getString("RETURN_CODE"))) {
            throw new BusiException(outData.getString("RETURN_CODE"),
                    outData.getString("DETAIL_MSG"));
        }
    }


}
