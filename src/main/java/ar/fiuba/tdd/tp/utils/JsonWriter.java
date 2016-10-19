package ar.fiuba.tdd.tp.utils;

import ar.fiuba.tdd.tp.model.observables.Game;
import org.json.simple.JSONValue;

import java.io.*;
import java.util.*;

class JsonWriter {
    private Map<String, Object> obj;
    private String path;
    private ArrayList<Map> list;

    void writePlays(Vector<Integer> number, Vector<String> boardStatus) {
        for (int i = 0; i < number.size(); i++) {
            Map<String, Object> object =  new HashMap<>();
            object.put("number",number.get(i));
            object.put("boardStatus",boardStatus.elementAt(i));
            list.add(object);
        }
        obj.put("plays", list);
    }

    void writeGrid() {
        Map<String, Object> oboard =  new HashMap<>();
        String boardState = Game.getInstance().checkFinish() ? "valid" : "invalid";
        ArrayList<Map> valuesList = new ArrayList<>();
        for (int rows = 1; rows <= Game.getInstance().getRows(); rows++) {
            for (int cols = 1; cols <= Game.getInstance().getCols(); cols++) {
                Map<String, Object> opositionandvalue =  new HashMap<>();
                ArrayList<Integer> aposition = new ArrayList<>();
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
            JSONValue.writeJSONString(obj, pw);
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    JsonWriter(String path) {
        this.path = path;
        obj = new HashMap<>();
        list = new ArrayList<>();
    }
}