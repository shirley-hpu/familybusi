package com.sitech.family.custservice.inter;

import com.sitech.family.custservice.dto.commondto.RequestMessage;
import com.sitech.family.custservice.dto.indto.FamilyAddMbrInDto;
import com.sitech.family.custservice.dto.indto.FamilyMbrPrcInsInDto;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;

import java.util.Map;

/**
 * @author wusm
 * @description
 * @date 2019/2/26 10:24
 */
public interface IFamilyMbrAoSvc {

    /**
     *  成员资料创建(正常状态)
     * @param inDTO
     * @return OutDTO
     */
    public OutDTO sFamilyAddMbrCfm(InDTO<RequestMessage<FamilyAddMbrInDto>> inDTO);

    /**
     *  成员资料创建(在途状态)
     * @param inDTO
     * @return OutDTO
     */
    public OutDTO sFamilyPreAddMbrCfm(InDTO<RequestMessage<FamilyAddMbrInDto>> inDTO);

    /**
     *  成员关系删除
     * @param inDTO
     * @return OutDTO
     */
    public OutDTO cfmFamilyDelMbr(InDTO<RequestMessage<Map>> inDTO);

    /**
     * 成员资料变更
     * @param inDTO
     * @return OutDTO
     */
    public OutDTO cfmFamilyMbrPrcChg(InDTO<RequestMessage<FamilyMbrPrcInsInDto>> inDTO);
}
