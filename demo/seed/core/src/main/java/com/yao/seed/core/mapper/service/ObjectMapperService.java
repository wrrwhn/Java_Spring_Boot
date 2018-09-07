package com.yao.seed.core.mapper.service;

/**
 * Creator: Yao
 * Date:    2018/9/6
 * For:
 * Other:
 */
public interface ObjectMapperService {

    void log(String format, Object object, String... args);

    void log(Object obj);

    String writeValueAsString(Object obj);

    byte[] writeValueAsBytes(Object value);

    <T> T readValue(String content, Class<T> valueType);

    <T> T readValueIgnore(String content, Class<T> valueType);
}
