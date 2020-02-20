package com.htu.shareinfo.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mhx
 * @date 2020-02-05 16:29
 **/
public class ResponseMapUtil {

    public static Map<String,Object> success(){
        Map<String,Object> map = new HashMap<>();
        map.put("respCode","200");
        map.put("respDesc","成功");
        return map;
    }

    public static Map<String,Object> success(String msg){
        Map<String,Object> map = new HashMap<>();
        map.put("respCode","200");
        map.put("respDesc",msg);
        return map;
    }

    public static Map<String,Object> success(String respCode,String msg){
        Map<String,Object> map = new HashMap<>();
        map.put("respCode",respCode);
        map.put("respDesc",msg);
        return map;
    }

    public static Map<String,Object>  fail(){
        Map<String,Object> map = new HashMap<>();
        map.put("respCode","500");
        map.put("respDesc","失败");
        return map;
    }

    public static Map<String,Object>  fail(String msg){
        Map<String,Object> map = new HashMap<>();
        map.put("respCode","500");
        map.put("respDesc",msg);
        return map;
    }

    public static Map<String,Object> fail(String respCode,String msg){
        Map<String,Object> map = new HashMap<>();
        map.put("respCode",respCode);
        map.put("respDesc",msg);
        return map;
    }
}
