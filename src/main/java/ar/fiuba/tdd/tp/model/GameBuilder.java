package ar.fiuba.tdd.tp.model;

import ar.fiuba.tdd.tp.model.cell.Cell;
import ar.fiuba.tdd.tp.model.cell.Value;
import ar.fiuba.tdd.tp.utils.Parser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

class GameBuilder {

    private String gameName;
    private Parser gameParser;

    GameBuilder(String gameName) {
        this.gameName = gameName;
    }

    GameBuilder loadConf() throws Exception {
        String path = System.getProperty("user.dir") + "/src/main/java/ar/fiuba/tdd/tp/games/" + gameName + ".json" ;
        this.gameParser = new Parser(path);
        return this;
    }

    Grid createGrid() {
        int height = this.gameParser.getJsonInt("rows");
        int width = this.gameParser.getJsonInt("cols");
        int nsets = this.gameParser.getJsonInt("nsets");
        JSONArray cells = this.gameParser.getJSONarray("cells");
        Grid grid = new Grid(width,height, nsets);
        for (Object cell : cells) {
            JSONObject cellJson = (JSONObject) cell;
            int row = ((Long)cellJson.get("row")).intValue();
            int col = ((Long)cellJson.get("col")).intValue();
            JSONArray values = (JSONArray) cellJson.get("value");
            ArrayList sets = (JSONArray) cellJson.get("sets");
            for (Object val : values) {
                int intValue = ((Long) val).intValue();
                if (intValue == 0) {
                    grid.addCell(new Cell(), row - 1, col - 1, sets);
                } else {
                    grid.addCell(new Cell(new Value(intValue)), row - 1, col - 1, sets);
                }
            }
        }
        //grid.printSets();
        grid = loadRulesGame(grid);
        return grid;
    }

    private Grid loadRulesGame(Grid grid) {
        JSONArray rules = this.gameParser.getJSONarray("rulesets");
        ArrayList rulesArray = this.gameParser.toArrayList(rules);
        JSONArray sums = this.gameParser.getJSONarray("sum");
        Vector<Integer> sumArray = this.gameParser.toVector(sums);


        for (Iterator iterator = rulesArray.iterator(); iterator.hasNext();) {
            int idRule = ((Long) iterator.next()).intValue();
            grid.loadRulesSet(idRule, sumArray);

        }
        return grid;
    }
    /*public void createSetsOfValues(Grid grid) {
        JSONArray cells = this.gameParser.getJSONarray("cells");
        for (Object cell : cells) {
            JSONObject cellJson = (JSONObject) cell;
            JSONArray values = (JSONArray) cellJson.get("value");
            for (Object val : values) {
                int intValue = (int)((Long) val).intValue();
                Value valSet = new Value(intValue);

            }
        }
    }*/

    public String getGameName() {
        return this.gameName;
    }
}
