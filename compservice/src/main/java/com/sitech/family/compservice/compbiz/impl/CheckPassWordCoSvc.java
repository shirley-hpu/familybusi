package com.sitech.family.compservice.compbiz.impl;

import com.sitech.family.compservice.atombiz.ICheckPassWordAo;
import com.sitech.family.compservice.compbiz.ICheckPassWordCo;
import com.sitech.family.common.dto.OprInfo;
import com.sitech.family.compservice.dto.indto.CheckPassWordInDto;
import com.sitech.ijcf.message6.dt.out.OutDTO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author guanqp
 * @Description
 * @date 2019/1/22 15:06
 */
@Component
public class CheckPassWordCoSvc implements ICheckPassWordCo {

    @Resource
    private ICheckPassWordAo iCheckPassWordAo;

    @Override
    public OutDTO<Object> checkPassWord(CheckPassWordInDto checkPassWordInDto,OprInfo oprInfo) {
        OutDTO<Object> OutDTO = iCheckPassWordAo.checkPassWord(checkPassWordInDto,oprInfo);
        return OutDTO;
    }
}
