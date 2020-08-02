package com.example.demo.excepion;

import java.io.Serializable;

public class DGExcepion extends RuntimeException implements Serializable {


    private static final long serialVersionUID = 3433464516067817563L;
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public DGExcepion(String message, Integer code) {
        super(message);
        this.code = code;
    }
}
