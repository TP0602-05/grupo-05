package ar.fiuba.tdd.tp.model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

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

    public int getJSONInt(String str) {
        return ((Long)jsonObject.get(str)).intValue();
    }


}
