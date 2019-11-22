package com.sitech.family.common.util;

import com.sitech.family.compservice.dto.outdto.UserInfo;
import com.sitech.ijcf.message6.dt.in.InDTO;

/**
 * @author wusm
 * @description
 * @date 2019/5/8 15:08
 */
public class SessionUtil {

    public static UserInfo getOprInfoSession(InDTO inDTO) {
        UserInfo session = new UserInfo();

        session.setBillDay(String.valueOf(inDTO.getHttpRequestHead("x-session-billday", String.class)));
        session.setBillEndTime(String.valueOf(inDTO.getHttpRequestHead("x-session-billendtime", String.class)));
        session.setBillingMode(String.valueOf(inDTO.getHttpRequestHead("x-session-billingmode", String.class)));
        session.setBrandId(String.valueOf(inDTO.getHttpRequestHead("x-session-brandid", String.class)));
        session.setBrandName(String.valueOf(inDTO.getHttpRequestHead("x-session-brandname", String.class)));
        session.setCadeType(String.valueOf(inDTO.getHttpRequestHead("x-session-cadetype", String.class)));
        session.setContraceNo(String.valueOf(inDTO.getHttpRequestHead("x-session-contraceno", String.class)));
        session.setCustId(String.valueOf(inDTO.getHttpRequestHead("x-session-custid", String.class)));
        session.setGroupId(String.valueOf(inDTO.getHttpRequestHead("x-session-groupid", String.class)));
        session.setIdNo(String.valueOf(inDTO.getHttpRequestHead("x-session-idno", String.class)));
        session.setMasterServId(String.valueOf(inDTO.getHttpRequestHead("x-session-masterservid", String.class)));
        session.setOpenTime(String.valueOf(inDTO.getHttpRequestHead("x-session-opentime", String.class)));
        session.setOwnerType(String.valueOf(inDTO.getHttpRequestHead("x-session-ownertype", String.class)));
        session.setPhoneNo(String.valueOf(inDTO.getHttpRequestHead("x-session-phoneno", String.class)));
        session.setRunCode(String.valueOf(inDTO.getHttpRequestHead("x-session-runcode", String.class)));
        session.setRunName(String.valueOf(inDTO.getHttpRequestHead("x-session-runname", String.class)));
        session.setRunTime(String.valueOf(inDTO.getHttpRequestHead("x-session-runtime", String.class)));

        return session;
    }
}
