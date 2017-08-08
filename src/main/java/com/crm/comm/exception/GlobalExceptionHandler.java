package com.crm.comm.exception;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.crm.comm.Result;
import com.crm.comm.ResultCode;
import com.crm.comm.exception.ServiceException;

/**
 * 统一日志处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    protected Logger logger = Logger.getLogger(this.getClass());

    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(Exception e, HttpServletRequest request,HttpServletResponse response) throws Exception {  
        
    		Result result = new Result();
        if (e instanceof ServiceException) {//业务失败的异常，如“账号或密码错误”
            result.setCode(ResultCode.FAIL).setMessage(e.getMessage());
            logger.info(e.getMessage());
        } else if (e instanceof NoHandlerFoundException) {
            result.setCode(ResultCode.NOT_FOUND).setMessage("接口 [" + request.getRequestURI() + "] 不存在");
        } else if (e instanceof ServletException) {
            result.setCode(ResultCode.FAIL).setMessage(e.getMessage());
        } else {
            result.setCode(ResultCode.INTERNAL_SERVER_ERROR).setMessage("接口 [" + request.getRequestURI() + "] 内部错误，请联系管理员");
            String message;
            /*if (handler instanceof HandlerMethod) {
                HandlerMethod handlerMethod = (HandlerMethod) handler;
                message = String.format("接口 [%s] 出现异常，方法：%s.%s，异常摘要：%s",
                        request.getRequestURI(),
                        handlerMethod.getBean().getClass().getName(),
                        handlerMethod.getMethod().getName(),
                        e.getMessage());
            me
            } else {*/
                message = e.getMessage();
            //}
            logger.error(message, e);
        }
        responseResult(response, result);
        
        logger.info("请求地址：" + request.getRequestURL());
        ModelAndView mav = new ModelAndView();
        logger.error("异常信息：",e);
        mav.setViewName(DEFAULT_ERROR_VIEW);
        
        return mav;

    }
    
    private void responseResult(HttpServletResponse response, Result result) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.setStatus(200);
        try {
            response.getWriter().write(result.toString());
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

}
