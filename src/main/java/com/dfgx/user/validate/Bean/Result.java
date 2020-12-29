package com.dfgx.user.validate.Bean;

public enum  Result {
    SUCCESS(200,"符合要求"),
    FAIL(400,"不符合要求");
    private Integer code;
    private String message;

    Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
