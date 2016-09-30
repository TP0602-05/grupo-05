package ar.fiuba.tdd.tp.utils;

import ar.fiuba.tdd.tp.model.Game;
import ar.fiuba.tdd.tp.model.cell.Value;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Vector;

/**
 * This class is responsible for automatic game plays.
 */
public class AutomaticPlayer {
    private Parser gamePlays;
    private JSONArray plays;

    public AutomaticPlayer(String path) throws Exception {
        this.gamePlays = new Parser(path);
        this.plays = this.gamePlays.getJSONarray("plays");
    }

    public void playGame() {
        for (Object aPlay: this.plays) {
            JSONObject aPlayJSON = (JSONObject) aPlay;
            int number = ((Long)aPlayJSON.get("number")).intValue();
            int value = ((Long)aPlayJSON.get("value")).intValue();
            JSONArray position = this.gamePlays.getArrayAttribute(aPlayJSON,"position");
            Vector<Long> array = this.gamePlays.toVector(position);
            int row = ((Long) array.elementAt(0)).intValue();
            int col = ((Long) array.elementAt(1)).intValue();
            Game.getInstance().setValue(row,col,new Value(value));
        }
    }
}
