/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.core.domain.AjaxResult
 *  com.kylin.kton.common.core.text.Convert
 *  com.kylin.kton.common.exception.DemoModeException
 *  com.kylin.kton.common.exception.ServiceException
 *  com.kylin.kton.common.utils.StringUtils
 *  com.kylin.kton.common.utils.html.EscapeUtil
 *  javax.servlet.http.HttpServletRequest
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.dao.DataAccessException
 *  org.springframework.http.converter.HttpMessageConversionException
 *  org.springframework.http.converter.HttpMessageNotReadableException
 *  org.springframework.security.access.AccessDeniedException
 *  org.springframework.validation.BindException
 *  org.springframework.validation.ObjectError
 *  org.springframework.web.HttpRequestMethodNotSupportedException
 *  org.springframework.web.bind.MethodArgumentNotValidException
 *  org.springframework.web.bind.MissingPathVariableException
 *  org.springframework.web.bind.MissingServletRequestParameterException
 *  org.springframework.web.bind.ServletRequestBindingException
 *  org.springframework.web.bind.annotation.ExceptionHandler
 *  org.springframework.web.bind.annotation.RestControllerAdvice
 *  org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
 *  org.springframework.web.servlet.NoHandlerFoundException
 */
package com.kylin.kton.framework.web.exception;

import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.text.Convert;
import com.kylin.kton.common.exception.DemoModeException;
import com.kylin.kton.common.exception.ServiceException;
import com.kylin.kton.common.utils.StringUtils;
import com.kylin.kton.common.utils.html.EscapeUtil;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value={MissingServletRequestParameterException.class, ServletRequestBindingException.class, HttpMessageConversionException.class})
    public AjaxResult handleBadRequestException(Exception e) {
        log.error("\u8bf7\u6c42\u53c2\u6570\u5f02\u5e38", (Throwable)e);
        return AjaxResult.error((String)"\u8bf7\u6c42\u53c2\u6570\u9519\u8bef\uff0c\u8bf7\u68c0\u67e5\u8f93\u5165");
    }

    @ExceptionHandler(value={NoHandlerFoundException.class})
    public AjaxResult handle404(NoHandlerFoundException e) {
        return AjaxResult.error((int)404, (String)"\u63a5\u53e3\u4e0d\u5b58\u5728");
    }

    @ExceptionHandler(value={NullPointerException.class})
    public AjaxResult handleNullPointerException(NullPointerException e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("\u8bf7\u6c42\u5730\u5740'{}',\u53d1\u751f\u7a7a\u6307\u9488\u5f02\u5e38: {}", new Object[]{requestURI, e.getMessage(), e});
        return AjaxResult.error((String)"\u7cfb\u7edf\u5185\u90e8\u9519\u8bef\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
    }

    @ExceptionHandler(value={AccessDeniedException.class})
    public AjaxResult handleAccessDeniedException(AccessDeniedException e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("\u8bf7\u6c42\u5730\u5740'{}',\u6743\u9650\u6821\u9a8c\u5931\u8d25'{}'", (Object)requestURI, (Object)e.getMessage());
        return AjaxResult.error((int)403, (String)"\u6ca1\u6709\u6743\u9650\uff0c\u8bf7\u8054\u7cfb\u7ba1\u7406\u5458\u6388\u6743");
    }

    @ExceptionHandler(value={HttpRequestMethodNotSupportedException.class})
    public AjaxResult handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("\u8bf7\u6c42\u5730\u5740'{}',\u4e0d\u652f\u6301'{}'\u8bf7\u6c42", (Object)requestURI, (Object)e.getMethod());
        return AjaxResult.error((String)e.getMessage());
    }

    @ExceptionHandler(value={ServiceException.class})
    public AjaxResult handleServiceException(ServiceException e, HttpServletRequest request) {
        log.error(e.getMessage(), (Throwable)e);
        Integer code = e.getCode();
        return StringUtils.isNotNull((Object)code) ? AjaxResult.error((int)code, (String)e.getMessage()) : AjaxResult.error((String)e.getMessage());
    }

    @ExceptionHandler(value={MissingPathVariableException.class})
    public AjaxResult handleMissingPathVariableException(MissingPathVariableException e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("\u8bf7\u6c42\u8def\u5f84\u4e2d\u7f3a\u5c11\u5fc5\u9700\u7684\u8def\u5f84\u53d8\u91cf'{}',\u53d1\u751f\u7cfb\u7edf\u5f02\u5e38.", (Object)requestURI, (Object)e);
        return AjaxResult.error((String)String.format("\u8bf7\u6c42\u8def\u5f84\u4e2d\u7f3a\u5c11\u5fc5\u9700\u7684\u8def\u5f84\u53d8\u91cf[%s]", e.getVariableName()));
    }

    @ExceptionHandler(value={MethodArgumentTypeMismatchException.class})
    public AjaxResult handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        String value = Convert.toStr((Object)e.getValue());
        if (StringUtils.isNotEmpty((String)value)) {
            value = EscapeUtil.clean((String)value);
        }
        log.error("\u8bf7\u6c42\u53c2\u6570\u7c7b\u578b\u4e0d\u5339\u914d'{}',\u53d1\u751f\u7cfb\u7edf\u5f02\u5e38.", (Object)requestURI, (Object)e);
        return AjaxResult.error((String)String.format("\u8bf7\u6c42\u53c2\u6570\u7c7b\u578b\u4e0d\u5339\u914d\uff0c\u53c2\u6570[%s]\u8981\u6c42\u7c7b\u578b\u4e3a\uff1a'%s'\uff0c\u4f46\u8f93\u5165\u503c\u4e3a\uff1a'%s'", e.getName(), e.getRequiredType().getName(), value));
    }

    @ExceptionHandler(value={RuntimeException.class})
    public AjaxResult handleRuntimeException(RuntimeException e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("\u8bf7\u6c42\u5730\u5740'{}',\u53d1\u751f\u672a\u77e5\u5f02\u5e38.", (Object)requestURI, (Object)e);
        return AjaxResult.error((String)e.getMessage());
    }

    @ExceptionHandler(value={Exception.class})
    public AjaxResult handleException(Exception e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("\u8bf7\u6c42\u5730\u5740'{}',\u53d1\u751f\u7cfb\u7edf\u5f02\u5e38.", (Object)requestURI, (Object)e);
        return AjaxResult.error((String)e.getMessage());
    }

    @ExceptionHandler(value={BindException.class})
    public AjaxResult handleBindException(BindException e) {
        log.error(e.getMessage(), (Throwable)e);
        String message = ((ObjectError)e.getAllErrors().get(0)).getDefaultMessage();
        return AjaxResult.error((String)message);
    }

    @ExceptionHandler(value={HttpMessageNotReadableException.class})
    public AjaxResult handleHttpMessageNotReadableException(HttpMessageNotReadableException e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("\u8bf7\u6c42\u5730\u5740'{}',\u8bf7\u6c42\u4f53\u7f3a\u5931\u6216\u4e0d\u53ef\u8bfb: {}", (Object)requestURI, (Object)e.getMessage());
        return AjaxResult.error((String)"\u8bf7\u6c42\u53c2\u6570\u9519\u8bef\uff0c\u8bf7\u68c0\u67e5\u8bf7\u6c42\u4f53");
    }

    @ExceptionHandler(value={MethodArgumentNotValidException.class})
    public Object handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), (Throwable)e);
        String message = e.getBindingResult().getFieldError().getDefaultMessage();
        return AjaxResult.error((String)message);
    }

    @ExceptionHandler(value={DemoModeException.class})
    public AjaxResult handleDemoModeException(DemoModeException e) {
        return AjaxResult.error((String)"\u6f14\u793a\u6a21\u5f0f\uff0c\u4e0d\u5141\u8bb8\u64cd\u4f5c");
    }

    @ExceptionHandler(value={SQLException.class, DataAccessException.class})
    public AjaxResult handleDatabaseException(Exception e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("\u8bf7\u6c42\u5730\u5740'{}',\u53d1\u751f\u6570\u636e\u5e93\u5f02\u5e38: {}", new Object[]{requestURI, e.getMessage(), e});
        return AjaxResult.error((String)"\u7cfb\u7edf\u5185\u90e8\u9519\u8bef\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
    }

    @ExceptionHandler(value={Throwable.class})
    public AjaxResult handleAllExceptions(Throwable t, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("\u8bf7\u6c42\u5730\u5740'{}',\u53d1\u751f\u672a\u77e5\u4e25\u91cd\u5f02\u5e38: {}", new Object[]{requestURI, t.getMessage(), t});
        return AjaxResult.error((String)"\u7cfb\u7edf\u5185\u90e8\u9519\u8bef\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
    }
}

