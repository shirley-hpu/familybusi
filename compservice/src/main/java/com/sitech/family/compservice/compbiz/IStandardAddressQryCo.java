package com.sitech.family.compservice.compbiz;

import com.sitech.family.compservice.dto.outdto.StandarAddressOutDto;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;

import java.util.Map;

/**
 * @author guanqp
 * @Description 宽带安装地址查询
 * @date 2018/12/18
 */
public interface IStandardAddressQryCo {

    /**
     * 宽带安装地址查询
     *
     * @param inDTO
     * @return OutDTO
     */
    OutDTO query(InDTO<Map> inDTO);
}
