package ar.fiuba.tdd.tp.model;

import ar.fiuba.tdd.tp.model.cell.*;
import ar.fiuba.tdd.tp.utils.Parser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Vector;

/*
This class loads the configuration of the game from a json file
and loads everything necessary to play.
 */
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

    Grid createGrid() {
        Grid grid = new Grid(this.gameParser.getJsonInt("cols"),this.gameParser.getJsonInt("rows"), this.gameParser.getJsonInt("nsets"));
        for (Object cell : this.gameParser.getJSONarray("cells")) {
            JSONObject cellJson = (JSONObject) cell;
            int row = ((Long)cellJson.get("row")).intValue();
            int col = ((Long)cellJson.get("col")).intValue();
            ArrayList val = (JSONArray) cellJson.get("value");
            ArrayList sets = (JSONArray) cellJson.get("sets");
            int type = ((Long)cellJson.get("type")).intValue();
            String blocked = (String)cellJson.get("isBlocked");
            //System.out.println("TYPE:" + type + " VAL: " + val + " ROW: " + row + " COL: " + col +  " SETS:" + sets);
            this.internalProcessOfValue(grid, type, blocked, val, sets, col, row);
        }
        grid = loadRulesGame(grid);
        grid.printSets();
        return grid;
    }

    private void internalProcessOfValue(Grid grid, int type, String blocked, ArrayList val, ArrayList sets, int col, int row) {

        switch (type) {
            case 1:
                int intValue = ((Long) val.get(0)).intValue();
                grid.addCell(new CellFlagsAndNumbers(new Value(intValue)), row - 1, col - 1, sets);
                break;
            case 2:
                Vector<Value> vecAux = new Vector<>(val.size());
                for (Object values : val) {
                    vecAux.add(new Value(((Long) values).intValue()));
                }
                grid.addCell(new CellDualSum(vecAux),row - 1, col - 1, sets);
                break;
            case 3:
                grid.addCell(new CellBlack(),row - 1 ,col - 1,sets);
                break;
            case 4:
                intValue = ((Long) val.get(0)).intValue();
                grid.addCell(new CellFlagsAndNumbers(new Value(intValue)),row - 1,col - 1,sets);
                break;
            default:
                break;
        }
    }

    private void parseRules(Grid grid, ArrayList rulesArray) {
        Vector<Long> values = null ;
        for (Object arulesArray : rulesArray) {
            int idRule = ((Long) arulesArray).intValue();
            switch (idRule) {
                case 2:
                    JSONArray sums = this.gameParser.getJSONarray("sum");
                    values = this.gameParser.toVector(sums);
                    break;
                case 3:
                    JSONArray muls = this.gameParser.getJSONarray("mul");
                    values = this.gameParser.toVector(muls);
                    break;
                case 4:
                    JSONArray count = this.gameParser.getJSONarray("count");
                    values = this.gameParser.toVector(count);
                    break;
                default:
                    break;
            }
            grid.loadRulesSet(idRule, values);
        }
    }

    private Grid loadRulesGame(Grid grid) {
        JSONArray rules = this.gameParser.getJSONarray("rulesets");
        ArrayList rulesArray = this.gameParser.toArrayList(rules);
        this.parseRules(grid, rulesArray);
        return grid;
    }

    public String getGameName() {
        return this.gameName;
    }
}
