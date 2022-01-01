package com.example.InternshipPlatform_1.InternshipPlatform_1.result;

import lombok.Data;

@Data
public class Result {
    private int code;
    private Object accessToken;

    public Result(int code, Object accessToken) {
        this.code = code;
        this.accessToken = accessToken;
    }

    public Result(int code) {
        this.code = code;
    }
}
