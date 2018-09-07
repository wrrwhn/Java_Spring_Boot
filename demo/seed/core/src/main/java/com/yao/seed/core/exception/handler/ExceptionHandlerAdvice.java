package com.yao.seed.core.exception.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yao.seed.core.exception.vo.ErrorInfo;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Creator: Yao
 * Date:    2018/9/6
 * For:
 * Other:
 */
@ControllerAdvice(annotations = RestController.class)
public class ExceptionHandlerAdvice {

    private Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);


    public ExceptionHandlerAdvice() {
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorInfo handleNotImplementedException(final HttpServletRequest request, final NotFoundException e) {
        final ErrorInfo result = new ErrorInfo(HttpStatus.NOT_FOUND, request, e.getLocalizedMessage());
        this.logException(e);
        this.logError(result);
        return result;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorInfo handleIllegalArgumentException(final HttpServletRequest request, final IllegalArgumentException e) {
        final ErrorInfo result = new ErrorInfo(HttpStatus.BAD_REQUEST, request, e.getLocalizedMessage());
        this.logException(e);
        this.logError(result);
        return result;
    }

    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorInfo handleIllegalArgumentException(final HttpServletRequest request, final IllegalStateException e) {
        final ErrorInfo result = new ErrorInfo(HttpStatus.BAD_REQUEST, request, e.getLocalizedMessage());
        this.logException(e);
        this.logError(result);
        return result;
    }

    private void logException(final Exception e) {
        logger.error("Exception message: {}", e.getMessage());
    }

    private void logError(final ErrorInfo error) {
        logger.error("Returning error: {}", error);
    }
}
