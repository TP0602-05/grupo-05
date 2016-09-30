package ar.fiuba.tdd.tp.utils;

import ar.fiuba.tdd.tp.model.Game;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;
import org.json.simple.JSONValue;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Vector;

class JsonWriter {
    private JSONObject obj;
    private String path;
    private JSONArray list;

    void writePlays(Vector<Integer> number, Vector<String> boardStatus) {
        for (int i = 0; i < number.size(); i++) {
            JSONObject object = new JSONObject();
            object.put("number",number.get(i));
            object.put("boardStatus",boardStatus.elementAt(i));
            list.add(object);
        }
        obj.put("plays", list);
    }

    void writeGrid() {
        JSONObject oboard = new JSONObject();
        String boardState = Game.getInstance().checkFinish() ? "valid" : "invalid";
        JSONArray valuesList = new JSONArray();
        for (int rows = 1; rows <= Game.getInstance().getRows(); rows++) {
            for (int cols = 1; cols <= Game.getInstance().getCols(); cols++) {
                JSONObject opositionandvalue = new JSONObject();

                JSONArray aposition = new JSONArray();
                aposition.add(rows);
                aposition.add(cols);
                opositionandvalue.put("position", aposition);

                opositionandvalue.put("value", Game.getInstance().getValue(rows - 1, cols - 1).getValue());

                valuesList.add(opositionandvalue);
            }
        }
        oboard.put("status",boardState);
        oboard.put("values",valuesList);
        obj.put("board",oboard);
    }

    void printToFile() {
        try {
            File file = new File(path);
            Writer writer = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            PrintWriter pw = new PrintWriter(writer);
            pw.println(obj.toJSONString());
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    JsonWriter(String path) {
        this.path = path;
        obj = new JSONObject();
        list = new JSONArray();
    }
}