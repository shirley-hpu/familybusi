package com.sitech.family.custservice.dto.mapperdto;


import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author Zhangc
 * @version 1.0
 * @date 2019/3/12 15:12
 */
public class RunCodeCompRulePhysical implements Serializable {
    @NotBlank(message = "CRM侧状态不能为空")
    private String crmRunCode;
    @NotBlank(message = "Boss侧状态不能为空")
    private String bossRunCode;
    private String timePriority;
    private String runCode;

    public String getCrmRunCode() {
        return crmRunCode;
    }

    public void setCrmRunCode(String crmRunCode) {
        this.crmRunCode = crmRunCode;
    }

    public String getBossRunCode() {
        return bossRunCode;
    }

    public void setBossRunCode(String bossRunCode) {
        this.bossRunCode = bossRunCode;
    }

    public String getTimePriority() {
        return timePriority;
    }

    public void setTimePriority(String timePriority) {
        this.timePriority = timePriority;
    }

    public String getRunCode() {
        return runCode;
    }

    public void setRunCode(String runCode) {
        this.runCode = runCode;
    }
}
