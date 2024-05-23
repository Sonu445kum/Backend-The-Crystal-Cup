package com.cup.Utils;

import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class CupUtils {
    private CupUtils() { }

    public static ResponseEntity<String> getResponseEntity(String message, HttpStatus httpStatus) {
        return new ResponseEntity<>("{\"message\":\""+message+"\"}", httpStatus);
        // this message structure is used to return a JSON object. '\"' is for double quote
    }

    public static String getUUID() {
        Date date = new Date();
        long time = date.getTime();
        return "BILL_" + time;
    }

    public static JSONArray getJsonArrayFromString(String data) throws JSONException {
        JSONArray jsonArray = new JSONArray(data);
        return jsonArray;
    }

    public static Map<String, Object> getMapFromJson(String data) {
        if (!Strings.isNullOrEmpty(data)) {
            return new Gson().fromJson(data, new TypeToken<Map<String, Object>>() {
            }.getType());
        }
        return new HashMap<>();
    }

    public static boolean isFileExist(String path) {
        log.info("Inside isFileExist {}", path);
        try {
            File file = new File(path);
            return (file != null && file.exists()) ? true : false;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}