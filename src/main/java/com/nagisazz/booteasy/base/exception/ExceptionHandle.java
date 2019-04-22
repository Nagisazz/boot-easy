package com.nagisazz.booteasy.base.exception;

import com.nagisazz.booteasy.base.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author NagisaZZ
 * @description: ExceptionHandle
 * @date 2019/4/22  11:58
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandle {

    /**
     * 未捕获的系统异常处理
     *
     * @param exception
     * @return
     * @throws
     * @see
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody
    Result handleException(Exception exception) {
        log.error("system exception handler:", exception);
        return Result.fail(exception);
    }

    /**
     * 未捕获的业务异常处理
     *
     * @param exception
     * @return
     * @throws
     * @see
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody
    Result handleServiceException(ServiceException exception) {
        log.error("system exception handler:", exception);
        return Result.fail(exception);
    }

}
