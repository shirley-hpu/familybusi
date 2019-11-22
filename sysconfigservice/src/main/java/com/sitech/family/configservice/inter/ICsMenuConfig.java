package com.sitech.family.configservice.inter;

import com.sitech.family.common.dto.RequestMessage;
import com.sitech.family.configservice.dto.indto.CsMenuConfigInDto;
import com.sitech.family.configservice.dto.outdto.CsMenuConfigOutDto;
import com.sitech.ijcf.message6.dt.in.InDTO;
import org.springframework.validation.BindingResult;

import java.util.List;

/**
 * 家客app底座元数据查询
 * @author Zhangc
 * @version 1.0
 * @date 2018/12/12 13:19
 */
public interface ICsMenuConfig {

    /**
     * 家客app底座元数据查询
     * @param inDto 入参
     * @param result 校验结果
     * @return CsMenuConfigOutDto
     */
    List<CsMenuConfigOutDto> qryMenuList(InDTO<RequestMessage<CsMenuConfigInDto>> inDto, BindingResult result);

    /**
     * 分布式序列获取测试
     */
    void getSequence();
}