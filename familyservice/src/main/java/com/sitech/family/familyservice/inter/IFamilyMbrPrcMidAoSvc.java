package com.sitech.family.familyservice.inter;

import com.sitech.family.familyservice.dto.commondto.RequestMessage;
import com.sitech.family.familyservice.dto.indto.FamilyAddMbrInDto;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;

/**
 * 在途成员资费订购
 *
 * @author shirley
 * @version 1.0
 * @date 2019/7/22 下午2:38
 */
public interface IFamilyMbrPrcMidAoSvc {

    /**
     * 在途成员资费订购
     *
     * @param inDTO :
     * @return com.sitech.ijcf.message6.dt.out.OutDTO
     * @throws
     * @date 2019/7/22 下午2:41
     */
    public OutDTO sFamilyMbrPrcMidCfm(InDTO<RequestMessage<FamilyAddMbrInDto>> inDTO);
}
