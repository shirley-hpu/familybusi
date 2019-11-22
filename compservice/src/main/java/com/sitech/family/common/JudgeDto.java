package com.sitech.family.common;

import java.io.Serializable;

/**
 * Package: com.sitech.family.common
 * Description： TODO
 * Author: Richard Meng
 * Date: Created in 2018/9/13 11:12
 * Company: SI-TECH
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 */
public class JudgeDto implements Serializable {

    private String key;
    private String value;
    private String chinese;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }
}
