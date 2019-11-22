package com.sitech.family.custservice.compbusi.impl;

import com.sitech.family.custservice.atombusi.ICrmToBossStateInfo;
import com.sitech.family.custservice.atombusi.IFamilyUserInfo;
import com.sitech.family.custservice.atombusi.IFamilyUserStateInfo;
import com.sitech.family.custservice.atombusi.IRunCodeCompRuleDict;
import com.sitech.family.custservice.base.util.DateConst;
import com.sitech.family.custservice.base.util.StringUtils;
import com.sitech.family.custservice.compbusi.IFamilyUserStateInfoCo;
import com.sitech.family.dto.dict.RunCodeCompRuleInfo;
import com.sitech.family.dto.user.CrmToBossStateInfo;
import com.sitech.family.dto.user.UserInfo;
import com.sitech.family.dto.user.UserStateInfo;
import com.sitech.ijcf.boot.core.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * @author Zhangc
 * @version 1.0
 * @date 2019/3/8 16:48
 */
@Component
public class FamilyUserStateInfoCoImpl implements IFamilyUserStateInfoCo {

    @Autowired
    private ICrmToBossStateInfo crmToBossStateInfo;
    @Autowired
    private IRunCodeCompRuleDict runCodeCompRuleDict;
    @Autowired
    private IFamilyUserStateInfo familyUserStateInfo;
    @Autowired
    private IFamilyUserInfo familyUserInfo;
    /**
     * 用户状态合成处理
     * @param param
     */
    @Override
    public void modify(Map<String, Object> param) {
        /*
         * 用户状态变化信息--逻辑模型信息解析
         * 用下面几个逻辑dto承载入参信息
         * */
        CrmToBossStateInfo familycrmToBossStateInfo = new CrmToBossStateInfo();
        UserStateInfo userStateInfo = new UserStateInfo();
        UserInfo userInfoInfo = new UserInfo();
        // idNo
        String idNoStr = StringUtils.castToString(param.get("ID_ NO"));
        Long idNo = StringUtils.castToLong(idNoStr);
        familycrmToBossStateInfo.setIdNo(idNo);
        userStateInfo.setIdNo(idNo);
        userInfoInfo.setIdNo(idNo);
        //newRunTime
        String newRunTime = StringUtils.castToString(param.get("NEW_RUN_TIME"));
        Date newRunTimeDate = DateUtil.toDate(newRunTime,DateConst.DATE_MODEL_8);
        userInfoInfo.setRunTime(newRunTimeDate);
        userStateInfo.setExpDate(newRunTimeDate);
        // opTime
        String opTime = StringUtils.castToString(param.get("OP_TIME"));
        Date opTimeDate = DateUtil.toDate(opTime,DateConst.DATE_MODEL_8);
        familycrmToBossStateInfo.setOpTime(opTimeDate);
        userStateInfo.setOpTime(opTimeDate);
        userInfoInfo.setOpTime(opTimeDate);
        // opCode
        String opCode = StringUtils.castToString(param.get("OP_CODE"));
        familycrmToBossStateInfo.setOpCode(opCode);
        userStateInfo.setOpCode(opCode);
        userInfoInfo.setOpCode(opCode);
        //loginNo
        String loginNo = StringUtils.castToString(param.get("LOGIN_NO"));
        familycrmToBossStateInfo.setLoginNo(loginNo);
        userStateInfo.setLoginNo(loginNo);
        userInfoInfo.setLoginNo(loginNo);
        // loginAccept
        String loginAcceptStr = StringUtils.castToString(param.get("LOGIN_ACCEPT"));
        Long loginAccept = StringUtils.castToLong(loginAcceptStr);
        familycrmToBossStateInfo.setLoginAccept(loginAccept);
        userStateInfo.setLoginAccept(loginAccept);
        userInfoInfo.setLoginAccept(loginAccept);
        //oupAccept ?
        String oupAccept = StringUtils.castToString(param.get("OUP_ACCEPT"));
        userInfoInfo.setOupAccept(oupAccept);
        if(oupAccept != null && oupAccept.length()>0){}
        //opNote
        String opNote = StringUtils.castToString(param.get("OP_NOTE"));
        userStateInfo.setOpNote(opNote);
        userInfoInfo.setOpNote(opNote);
        //systemNote
        String systemNote = StringUtils.castToString(param.get("SYSTEM_NOTE"));
        userStateInfo.setSystemNote(systemNote);
        userInfoInfo.setSystemNote(systemNote);
        // 1.查询crmToBossState，获取crm或boss侧状态信息
        CrmToBossStateInfo CTOBS = crmToBossStateInfo.query(familycrmToBossStateInfo);
        //newRun
        String changeType = StringUtils.castToString(param.get("CHANGE_TYPE"));//合成类型（B-C or C-B）
        String newRun = StringUtils.castToString(param.get("NEW_RUN"));// 合成目标状态
        if(StringUtils.isEqual(changeType, "CTOB")){
            familycrmToBossStateInfo.setCrmRunTime(newRunTimeDate);
            familycrmToBossStateInfo.setCrmRunCode(newRun);
            CTOBS.setCrmRunCode(newRun);
        }
        if(StringUtils.isEqual(changeType, "BTOC")){
            familycrmToBossStateInfo.setBossRunTime(newRunTimeDate);
            familycrmToBossStateInfo.setBossRunCode(newRun);
            CTOBS.setBossRunCode(newRun);
        }
        // 2. 合成最终状态RunCode
        RunCodeCompRuleInfo runCodeCompRuleInfo = new RunCodeCompRuleInfo();
        runCodeCompRuleInfo.setBossRunCode(CTOBS.getBossRunCode());
        runCodeCompRuleInfo.setCrmRunCode(CTOBS.getCrmRunCode());
        RunCodeCompRuleInfo runCodeTemp = runCodeCompRuleDict.query(runCodeCompRuleInfo);
        String runCode = runCodeTemp.getRunCode();
        // 给涉及到的逻辑模型设置runCode值
        familycrmToBossStateInfo.setRunCode(runCode);
        userStateInfo.setRunCode(runCode);
        userInfoInfo.setRunCode(runCode);
        // 3. 处理用户状态变化轨迹模型
        familyUserStateInfo.modify(userStateInfo);
        // 4. 处理用户状态同步模型
        crmToBossStateInfo.modify(familycrmToBossStateInfo);
        // 5. 处理用户详细信息和用户信息模型
        familyUserInfo.modify(userInfoInfo);
        // 6. 发送报文

    }
}
