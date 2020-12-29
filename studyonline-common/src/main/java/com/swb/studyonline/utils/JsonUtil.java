package com.swb.studyonline.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.PropertyNamingStrategyBase;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.apache.commons.lang3.StringUtils;

/**
 * <p>文件  JsonUtil</p>
 * <p>时间  2020-12-26 17:11:41</p>
 *
 * @author swb
 */
public class JsonUtil {
    public static final ObjectMapper INSTANCE = new ObjectMapper();
    public static final ObjectMapper PASCAL_CASE_INSTANCE;

    public JsonUtil() {
    }

    public static String serialize(Object object) {
        try {
            String value = INSTANCE.writeValueAsString(object);
            return value;
        } catch (JsonProcessingException var3) {
            throw new RuntimeException(var3);
        }
    }

    public static <T> T deserialize(String json, Class<T> clazz) {
        Object object = null;

        try {
            object = INSTANCE.readValue(json, TypeFactory.rawClass(clazz));
            return (T) object;
        } catch (JsonProcessingException var4) {
            throw new RuntimeException(var4);
        }
    }

    public static <T> T deserialize(String json, TypeReference typeReference) {
        Object object = null;

        try {
            object = INSTANCE.readValue(json, typeReference);
            return (T) object;
        } catch (JsonProcessingException var4) {
            throw new RuntimeException(var4);
        }
    }

    static {
        INSTANCE.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        PASCAL_CASE_INSTANCE = new ObjectMapper();
        PASCAL_CASE_INSTANCE.setPropertyNamingStrategy(new PropertyNamingStrategyBase() {
            @Override
            public String translate(String propertyName) {
                return StringUtils.capitalize(propertyName);
            }
        });
    }
}
