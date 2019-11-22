package com.sitech.family.compservice.inter;

import com.sitech.family.common.dto.RequestMessage;
import com.sitech.family.compservice.dto.indto.FamilyGroupMbrInDto;
import com.sitech.family.compservice.dto.indto.FamilyMbrDelInDto;
import com.sitech.family.compservice.dto.indto.FamilyMbrMngInDto;
import com.sitech.ijcf.message6.dt.in.InDTO;
import com.sitech.ijcf.message6.dt.out.OutDTO;

import java.util.List;
import java.util.Map;

public interface IFamilyMbrCfmCoSvc {

    /**
     * 成员管理新增
     * @param inDTO
     * @return
     */
    public OutDTO cfmFamilyAddMbr(InDTO<RequestMessage<FamilyMbrMngInDto>> inDTO);


    /**
     *  成员关系删除
     * @param inDTO
     * @return OutDTO
     */
    public OutDTO cfmFamilyDelMbr(InDTO<RequestMessage<FamilyMbrDelInDto>> inDTO);

    /**
     * 家庭成员信息管理
     * @param inDTO
     * @return
     */
    public OutDTO cfmFamilyGroupMbr(InDTO<RequestMessage<FamilyGroupMbrInDto>> inDTO);
}
