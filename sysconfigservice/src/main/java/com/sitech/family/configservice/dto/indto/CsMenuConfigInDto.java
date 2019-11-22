package com.sitech.family.configservice.dto.indto;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;


/**
 * @author Zhangc
 * @version 1.0
 * @date 2018/12/12 13:43
 */
public class CsMenuConfigInDto {
    @JSONField(name="OWNER_BOTTOM")
    @NotBlank(message = "15000$底座不能为空")
    private String ownerBottom;

    @JSONField(name="test")
    @NotBlank(message = "15000$测试")
    private String test;

    @JSONField(name="test1")
    @NotBlank(message = "15000$测试1")
    private String test1;

    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getOwnerBottom() {
        return ownerBottom;
    }

    public void setOwnerBottom(String ownerBottom) {
        this.ownerBottom = ownerBottom;
    }
}
