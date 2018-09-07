package com.yao.seed.core.mapper.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yao.seed.core.mapper.service.ObjectMapperService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * Creator: Yao
 * Date:    2018/9/6
 * For:
 * Other:
 */
public class ObjectMapperServiceImpl implements ObjectMapperService {


    private static Logger logger = LoggerFactory.getLogger(ObjectMapperServiceImpl.class);

    @Autowired
    ObjectMapper objectMapper;

    /****
     * log("update %s fail", "institute")
     * log("update %s fail;: %s", error, "institute")
     *
     * @param format
     * @param obj
     * @param args
     */
    @Override
    public void log(String format, Object obj, String... args) {

        int i = 0;
        String exception = "";
        String[] vars = new String[args.length + (null != obj ? 1 : 0)];
        for (String info : args)
            vars[i++] = info;

        if (null != obj) {
            try {
                exception = objectMapper.writeValueAsString(obj);
            } catch (JsonProcessingException e1) {
                e1.printStackTrace();
            } finally {
                vars[i] = exception;
            }
        }

        if (null != obj && obj instanceof Exception)
            logger.error(format, vars);
        else
            logger.info(format, vars);
    }

    @Override
    public void log(Object obj) {

        String sObj = null;
        try {
            sObj = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        logger.info(sObj);
    }

    @Override
    public String writeValueAsString(Object obj) {

        if (null == obj)
            return null;

        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public byte[] writeValueAsBytes(Object obj) {

        try {
            return objectMapper.writeValueAsBytes(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public <T> T readValue(String content, Class<T> valueType) {

        try {
            return objectMapper.readValue(content, valueType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public <T> T readValueIgnore(String content, Class<T> valueType) {

        if (StringUtils.isBlank(content))
            return null;

        try {
            return objectMapper.readValue(content, valueType);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return null;
    }
}
