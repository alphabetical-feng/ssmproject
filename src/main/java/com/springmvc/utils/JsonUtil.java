//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.springmvc.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class JsonUtil {
    private static final Logger log = LogManager.getLogger(JsonUtil.class);
    public static Gson g = new Gson();
    private static Gson t = null;

    public JsonUtil() {
    }

    public static String objectToJson(Object ts) {
        String jsonStr = null;
        if (t != null) {
            jsonStr = t.toJson(ts);
        }

        return jsonStr;
    }

//    public static String objectToJson(Object ts, final String dateformat) {
//        String jsonStr = null;
//        t = (new GsonBuilder()).registerTypeHierarchyAdapter(Date.class, new JsonSerializer<Date>() {
//            public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
//                SimpleDateFormat format = new SimpleDateFormat(dateformat);
//                return new JsonPrimitive(format.format(src));
//            }
//        }).registerTypeAdapter(byte[].class, new ByteAdapter()).setDateFormat(dateformat).create();
//        if (t != null) {
//            jsonStr = t.toJson(ts);
//        }
//
//        return jsonStr;
//    }

    public static List<?> jsonToList(String jsonStr) {
        List<?> objList = null;
        if (t != null) {
            Type type = (new TypeToken<List<?>>() {
            }).getType();
            objList = (List)t.fromJson(jsonStr, type);
        }

        return objList;
    }

    public static List<?> jsonToList(String jsonStr, Type type) {
        List<?> objList = null;
        if (t != null) {
            objList = (List)t.fromJson(jsonStr, type);
        }

        return objList;
    }

//    public static List<?> jsonToList(String jsonStr, Type type, final String pattern) {
//        List<?> objList = null;
//        t = (new GsonBuilder()).registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
//            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
//                SimpleDateFormat format = new SimpleDateFormat(pattern);
//                String dateStr = json.getAsString();
//
//                try {
//                    if (StringUtils.isNotEmpty(dateStr)) {
//                        return format.parse(dateStr);
//                    }
//                } catch (ParseException var7) {
//                    JsonUtil.log.info("jsonToList(String jsonStr,java.lang.reflect.Type type, final String pattern)  日期解析发生异常:" + dateStr);
//                }
//
//                return null;
//            }
//        }).registerTypeAdapter(byte[].class, new ByteAdapter()).setDateFormat(pattern).create();
//        if (t != null) {
//            objList = (List)t.fromJson(jsonStr, type);
//        }
//
//        return objList;
//    }

    public static Map<?, ?> jsonToMap(String jsonStr) {
        Map<?, ?> objMap = null;
        if (t != null) {
            Type type = (new TypeToken<Map<?, ?>>() {
            }).getType();
            objMap = (Map)t.fromJson(jsonStr, type);
        }

        return objMap;
    }

    public static Object jsonToBean(String jsonStr, Class<?> cl) {
        Object obj = null;
        if (t != null) {
            obj = t.fromJson(jsonStr, cl);
        }

        return obj;
    }

//    public static <T> T jsonToBean(String jsonStr, Class<T> cl, final String pattern) {
//        Object obj = null;
//        t = (new GsonBuilder()).registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
//            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
//                SimpleDateFormat format = new SimpleDateFormat(pattern);
//                String dateStr = json.getAsString();
//
//                try {
//                    if (StringUtils.isNotEmpty(dateStr)) {
//                        return format.parse(dateStr);
//                    }
//                } catch (ParseException var7) {
//                    JsonUtil.log.info("jsonToList(String jsonStr,java.lang.reflect.Type type, final String pattern)  日期解析发生异常:" + dateStr);
//                }
//
//                return null;
//            }
//        }).registerTypeAdapter(byte[].class, new ByteAdapter()).setDateFormat(pattern).create();
//        if (t != null) {
//            obj = t.fromJson(jsonStr, cl);
//        }
//
//        return obj;
//    }

//    public static <T> T jsonToBean(String jsonStr, Type type, final String pattern) {
//        Object obj = null;
//        t = (new GsonBuilder()).registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
//            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
//                SimpleDateFormat format = new SimpleDateFormat(pattern);
//                String dateStr = json.getAsString();
//
//                try {
//                    if (StringUtils.isNotEmpty(dateStr)) {
//                        return format.parse(dateStr);
//                    }
//                } catch (ParseException var7) {
//                    JsonUtil.log.info("jsonToList(String jsonStr,java.lang.reflect.Type type, final String pattern)  日期解析发生异常:" + dateStr);
//                }
//
//                return null;
//            }
//        }).registerTypeAdapter(byte[].class, new ByteAdapter()).setDateFormat(pattern).create();
//        if (t != null) {
//            obj = t.fromJson(jsonStr, type);
//        }
//
//        return obj;
//    }
//
//    public static <T> T jsonToBean(Reader jsonReader, Class<T> cl, final String pattern) {
//        Object obj = null;
//        t = (new GsonBuilder()).registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
//            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
//                SimpleDateFormat format = new SimpleDateFormat(pattern);
//                String dateStr = json.getAsString();
//
//                try {
//                    if (StringUtils.isNotEmpty(dateStr)) {
//                        return format.parse(dateStr);
//                    }
//                } catch (ParseException var7) {
//                    JsonUtil.log.info("jsonToList(String jsonStr,java.lang.reflect.Type type, final String pattern)  日期解析发生异常:" + dateStr);
//                }
//
//                return null;
//            }
//        }).registerTypeAdapter(byte[].class, new ByteAdapter()).setDateFormat(pattern).create();
//        if (t != null) {
//            obj = t.fromJson(jsonReader, cl);
//        }
//
//        return obj;
//    }

    public static Object getJsonValue(String jsonStr, String key) {
        Object rulsObj = null;
        Map<?, ?> rulsMap = jsonToMap(jsonStr);
        if (rulsMap != null && rulsMap.size() > 0) {
            rulsObj = rulsMap.get(key);
        }

        return rulsObj;
    }

    static {
        if (t == null) {
            t = new Gson();
        }

    }
}
