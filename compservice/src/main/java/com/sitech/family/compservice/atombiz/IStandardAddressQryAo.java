package com.sitech.family.compservice.atombiz;

        import com.sitech.family.compservice.dto.outdto.StandarAddressOutDto;
        import com.sitech.ijcf.message6.dt.in.InDTO;
        import com.sitech.ijcf.message6.dt.out.OutDTO;

        import java.util.Map;

/**
 * @Description 宽带地址查询
 * @Author guanqp
 * @Date 2018/12/18
 **/
public interface IStandardAddressQryAo {

    OutDTO query(InDTO<Map> requestMessage);
}
