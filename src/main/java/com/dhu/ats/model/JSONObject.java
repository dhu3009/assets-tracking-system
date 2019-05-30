package com.dhu.ats.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JSONObject {
    Map<String,Object> result = new HashMap<>();

    public void put(String msg, Object value){
        result.put(msg,value);
    }

    public Map<String, Object> getResult() {
        return result;
    }

    public void setResult(Map<String, Object> result) {
        this.result = result;
    }
}
