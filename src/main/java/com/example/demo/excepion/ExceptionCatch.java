package com.example.demo.excepion;

import com.example.demo.base.utils.MsgResult;
import org.springframework.web.bind.annotation.ControllerAdvice;//捕获所有web层的异常
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice//声明这是个全局异常捕获注解
public class ExceptionCatch {
    @ExceptionHandler(DGExcepion.class)
    @ResponseBody
    public MsgResult catchException(DGExcepion dgExcepion){
        return MsgResult.fail(dgExcepion.getCode(),dgExcepion.getMessage());
    }
}
