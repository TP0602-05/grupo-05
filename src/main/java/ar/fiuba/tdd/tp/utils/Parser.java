package ar.fiuba.tdd.tp.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.Vector;

/**
 * This class is used to parse external JSON files and extract its values
 */

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
        return (JSONObject) object.get(attr);
    }

    public JSONArray getArrayAttribute(JSONObject object, String attr) {
        return (JSONArray) object.get(attr);
    }

    public ArrayList toArrayList(JSONArray array) {
        ArrayList<? super Object> list = new ArrayList<>();

        int len = array.size();
        for (int i = 0;i < len; i++) {
            list.add(array.get(i));
        }

        return list;

    }

    public Vector<Long> toVector(JSONArray array) {
        Vector<Long> vector = new Vector<>(array.size());

        for (Object anArray : array) {
            vector.add((Long)anArray);
        }

        return vector;
    }

}
