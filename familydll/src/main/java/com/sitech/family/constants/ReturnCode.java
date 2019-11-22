package com.sitech.family.constants;

/**
 *
 */
public enum ReturnCode {

    /**
     * 成功代码
     */
    RETURN_CODE_SUCCESS(0),

    /**
     * 失败代码
     */
    RETURN_CODE_FAIL(1);

    private int code;

    ReturnCode(int code) {
        this.code = code;
    }

    public String getCode() {
        return String.valueOf(code);
    }

}
