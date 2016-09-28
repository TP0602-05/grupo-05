package ar.fiuba.tdd.tp.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.Vector;

public class Parser {
    private JSONObject jsonObject;

    public Parser(String path) throws Exception {
        try {
            JSONParser parser = new JSONParser();
            Object objectParser = parser.parse(new InputStreamReader(new FileInputStream(path), "UTF-8") );
            this.jsonObject = (JSONObject) objectParser;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public String getString(String str) {
        return (String)this.jsonObject.get(str);
    }

    public Long getLong(String str) {
        return (Long) this.jsonObject.get(str);
    }

    public JSONArray getJSONarray(String str) {
        return  (JSONArray) this.jsonObject.get(str);
    }

    public JSONValue getJsonValue(String str) {
        return (JSONValue) this.jsonObject.get(str);
    }

   // public JSObject getJsonObject(String str) { return (JSObject) this.jsonObject.get(str); }

    public int getJsonInt(String str) {
        return ((Long)jsonObject.get(str)).intValue();
    }

    public JSONObject getObjectAttribute(JSONObject object, String attr) {
        JSONObject atomicObject = (JSONObject) object.get(attr);
        return atomicObject;
    }

    public JSONArray getArrayAttribute(JSONObject object, String attr) {
        JSONArray atomicObject = (JSONArray) object.get(attr);
        return atomicObject;
    }

    public ArrayList toArrayList(JSONArray array) {
        ArrayList list = new ArrayList<>();

        int len = array.size();
        for (int i = 0;i < len; i++) {
            list.add(array.get(i));
        }

        return list;

    }

    public Vector toVector(JSONArray array) {
        Vector vector = new Vector<>(array.size());

        int len = array.size();
        for (int i = 0; i < len; i++) {
            vector.add(array.get(i));
        }

        return vector;
    }

}
