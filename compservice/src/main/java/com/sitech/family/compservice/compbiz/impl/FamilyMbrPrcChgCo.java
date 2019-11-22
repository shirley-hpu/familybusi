package com.sitech.family.compservice.compbiz.impl;

import com.sitech.family.common.dto.OprInfo;
import com.sitech.family.common.util.BaseLoginAccept;
import com.sitech.family.compservice.compbiz.IFamilyMbrPrcChgCo;
import com.sitech.family.compservice.dto.indto.FamilyMemPrcChg;
import com.sitech.ijcf.boot.core.error.exception.BusiException;
import com.sitech.ijcf.boot.core.util.StringUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class FamilyMbrPrcChgCo implements IFamilyMbrPrcChgCo {

    @Resource
    private BaseLoginAccept baseLoginAccept;

    /**
     * 成员资费变更
     *
     * @param map
     * @return map
     */
    @Override
    public Map updateMemberPrc(Map map) {
        Map retMap = new HashMap();

        try {
            FamilyMemPrcChg familyMemPrcChg = (FamilyMemPrcChg) map.get("busiInfo");
            OprInfo oprInfo = (OprInfo) map.get("oprInfo");

            if (StringUtil.isEmptyOrNull(familyMemPrcChg.getMbrPrcInsChgInfoList())) {
                retMap.put("retCode", "-9999");
                return retMap;
            }

            Map<String, Object> inMap = new HashMap<>();
            Map<String, String> oprMap = new HashMap<>();
            oprMap.put("REGION_ID", oprInfo.getRegionId());
            oprMap.put("LOGIN_NO", oprInfo.getLoginNo());
            oprMap.put("GROUP_ID", oprInfo.getGroupId());
            oprMap.put("CONTACT_ID", oprInfo.getContactId());
            oprMap.put("OP_NOTE", oprInfo.getOpNote());
            oprMap.put("CHANNEL_TYPE", oprInfo.getChannelType());
            oprMap.put("LOGIN_ACCEPT", oprInfo.getLoginAccpet());
            oprMap.put("CREATE_TIME", oprInfo.getCreateTime());
            oprMap.put("OP_CODE", oprInfo.getOpCode());
            oprMap.put("SYSTEM_NOTE", oprInfo.getSystemNote());
            oprMap.put("OUT_ACCEPT", oprInfo.getOutAccept());

            inMap.put("OPR_INFO", oprMap);

            List<FamilyMemPrcChg.MbrPrcInsChgInfo> mbrPrcInsChgInfoList = familyMemPrcChg.getMbrPrcInsChgInfoList();

            for (FamilyMemPrcChg.MbrPrcInsChgInfo mbrPrcInsChgInfo : mbrPrcInsChgInfoList) {
                Map<String, Object> mbrPrcInsMap = new HashMap<>();
                mbrPrcInsMap.put("ID_NO", mbrPrcInsChgInfo.getIdNo());
                mbrPrcInsMap.put("GROUP_ID", familyMemPrcChg.getGroupId());
                mbrPrcInsMap.put("MEMBER_ID", mbrPrcInsChgInfo.getMemberId());

                if (StringUtil.isNotEmptyOrNull(mbrPrcInsChgInfo.getMbrPrcInsInfoList())) {
                    List<FamilyMemPrcChg.MbrPrcInsInfo> mbrPrcInsInfoList = mbrPrcInsChgInfo.getMbrPrcInsInfoList();

                    List<Map> list = new ArrayList<>();
                    for (FamilyMemPrcChg.MbrPrcInsInfo mbrPrcInsInfo : mbrPrcInsInfoList) {
                        Map<String, Object> mbrPrcMap = new HashMap<>();

                        if ("A".equals(mbrPrcInsInfo.getOperateType())) {
                            Map<String, String> sequenceMap = new HashMap<>(2);
                            sequenceMap.put("ACCEPT_LABEL", "SEQ_FM_MEMBERID");
                            //String prodprcinsId = baseLoginAccept.getPubLoginAccept(sequenceMap);
                            //mbrPrcMap.put("PRODPRCINS_ID", prodprcinsId);
                            mbrPrcMap.put("EXP_DATE",mbrPrcInsInfo.getExpDate());
                        } else {
                            mbrPrcMap.put("PRODPRCINS_ID", mbrPrcInsInfo.getProdprcinsId());
                            mbrPrcMap.put("EXP_DATE",mbrPrcInsInfo.getExpDate());
                        }

                        list.add(mbrPrcMap);
                    }

                    mbrPrcInsMap.put("MBRPRCINSLIST",list);
                }
            }
        } catch (Exception e) {
            throw new BusiException("-9999", e.getMessage());
        }

        return retMap;
    }
}
