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
    private boolean gridHasBlocks;

    GameBuilder(String gameName) {
        this.gameName = gameName;
        gridHasBlocks = false;
    }

    GameBuilder loadConf() throws Exception {
        String path = System.getProperty("user.dir") + "/src/main/java/ar/fiuba/tdd/tp/games/" + gameName + ".json" ;
        gridHasBlocks = gameName.equals("sudoku");
        this.gameParser = new Parser(path);
        return this;
    }

    public boolean gridHasBlocks() {
        return gridHasBlocks;
    }

    //TODO: NCSS max is 20
    Grid createGrid() {
        Grid grid = new Grid(this.gameParser.getJsonInt("cols"),this.gameParser.getJsonInt("rows"), this.gameParser.getJsonInt("nsets"));
        for (Object cell : this.gameParser.getJSONarray("cells")) {
            JSONObject cellJson = (JSONObject) cell;
            int row = ((Long)cellJson.get("row")).intValue();
            int col = ((Long)cellJson.get("col")).intValue();
            ArrayList val = (JSONArray) cellJson.get("value");
            ArrayList sets = (JSONArray) cellJson.get("sets");
            if (val.size() == 1) {
                int intValue = ((Long) val.get(0)).intValue();
                if (intValue == 0) {
                    grid.addCell(new Cell(), row - 1, col - 1, sets);
                } else {
                    grid.addCell(new Cell(new Value(intValue)), row - 1, col - 1, sets);
                }
            } else {
                Vector<Value> vecAux = new Vector<>(val.size());
                for (Object values : val) {
                    vecAux.add(new Value(((Long) values).intValue()));
                }
                grid.addCell(new Cell(vecAux),row - 1, col - 1, sets);
            }
        }
        grid = loadRulesGame(grid);
        return grid;
    }

    private Grid loadRulesGame(Grid grid) {
        JSONArray rules = this.gameParser.getJSONarray("rulesets");
        ArrayList rulesArray = this.gameParser.toArrayList(rules);
        JSONArray sums = this.gameParser.getJSONarray("sum");
        Vector<Long> sumArray = this.gameParser.toVector(sums);


        for (Iterator iterator = rulesArray.iterator(); iterator.hasNext();) {
            int idRule = ((Long) iterator.next()).intValue();
            grid.loadRulesSet(idRule, sumArray);
        }
        return grid;
    }

    public String getGameName() {
        return this.gameName;
    }
}
