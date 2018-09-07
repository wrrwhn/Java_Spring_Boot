package com.yao.seed.core.exception.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Creator: Yao
 * Date:    2018/9/6
 * For:
 * Other:
 */
public class ErrorInfo {

    @JsonProperty
    private int status;

    @JsonProperty
    private String reason;

    @JsonProperty
    private String method;

    @JsonProperty
    private String path;

    @JsonProperty
    private Map<String, String[]> parameters;

    @JsonProperty
    private List<String> messages = new ArrayList<String>();

    @JsonProperty
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String errorCode;

    public ErrorInfo() {
    }

    public ErrorInfo(final HttpStatus status, final HttpServletRequest request) {
        this.getDataFromHttpStatus(status);
        this.getDataFromRequest(request);
    }

    public ErrorInfo(final HttpStatus status, final HttpServletRequest request, final Exception resultingException) {
        this(status, request);
        this.messages.add(ExceptionUtils.getRootCauseMessage(resultingException));
    }

    public ErrorInfo(final HttpStatus status, final HttpServletRequest request, final String errorMessage) {
        this(status, request);
        if (StringUtils.isNotBlank(errorMessage)) {
            this.messages.add(errorMessage);
        }
    }

    public ErrorInfo(final HttpStatus status, final HttpServletRequest request, final String errorCode, final String errorMessage) {
        this(status, request);
        if (StringUtils.isNotBlank(errorCode)) {
            this.errorCode = errorCode;
        }
        if (StringUtils.isNotBlank(errorMessage)) {
            this.messages.add(errorMessage);
        }
    }

    public ErrorInfo(final HttpStatus status, final HttpServletRequest request, final List<String> errorMessages) {
        this(status, request);
        if (CollectionUtils.isNotEmpty(errorMessages)) {
            this.messages.addAll(errorMessages);
        }
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    private void getDataFromHttpStatus(final HttpStatus status) {
        this.status = status.value();
        this.reason = status.getReasonPhrase();
    }

    private void getDataFromRequest(final HttpServletRequest request) {
        this.path = request.getRequestURI();
        this.method = request.getMethod();
        this.parameters = request.getParameterMap();
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
