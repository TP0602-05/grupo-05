package ar.fiuba.tdd.tp.utils;

import ar.fiuba.tdd.tp.model.Game;
import ar.fiuba.tdd.tp.model.cell.Value;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

/**
 * This class is responsible for automatic game plays.
 */
public class AutomaticPlayer {
    private Parser gamePlays;
    private JSONArray plays;
    private JsonWriter writer;
    private Vector<Integer> vnumber;
    Vector<String> vboardStatus;

    public AutomaticPlayer(String path) throws Exception {
        this.gamePlays = new Parser(path);
        this.plays = this.gamePlays.getJSONarray("plays");

        vnumber = new Vector<>(this.plays.size());
        vboardStatus = new Vector<>(this.plays.size());

        String pathout = System.getProperty("user.dir") + "/src/main/java/ar/fiuba/tdd/tp/output.json" ;
        this.writer = new JsonWriter(pathout);
    }

    public void playGame() {
        for (Object arrplayer: this.plays) {
            JSONObject aplayJson = (JSONObject) arrplayer;
            int number = ((Long)aplayJson.get("number")).intValue();
            int value = Integer.parseInt((String)aplayJson.get("value"));
            JSONArray position = this.gamePlays.getArrayAttribute(aplayJson,"position");
            Vector<Long> array = this.gamePlays.toVector(position);
            int row = array.elementAt(0).intValue();
            int col = array.elementAt(1).intValue();
            vnumber.add(number);
            if (Game.getInstance().setValueInCompilationTime(row - 1,col - 1,new Value(value))) {
                vboardStatus.add("valid");
            } else {
                vboardStatus.add("invalid");
            }
        }
        this.writer.writePlays(vnumber,vboardStatus);
        this.writer.writeGrid();
        this.writer.printToFile();
    }
}
