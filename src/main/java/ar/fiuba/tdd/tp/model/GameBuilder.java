package ar.fiuba.tdd.tp.model;

import ar.fiuba.tdd.tp.model.cell.*;
import ar.fiuba.tdd.tp.utils.Parser;
import ar.fiuba.tdd.tp.view.ButtonHashing;
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

    GameBuilder(String gameName) {
        this.gameName = gameName;
    }

    GameBuilder loadConf() throws Exception {
        String path = System.getProperty("user.dir") + "/src/main/java/ar/fiuba/tdd/tp/games/" + gameName + ".json" ;
        this.gameParser = new Parser(path);
        return this;
    }

    Grid createGrid() {
        Grid grid = new Grid(this.gameParser.getJsonInt("cols"),this.gameParser.getJsonInt("rows"), this.gameParser.getJsonInt("nsets"));
        String combine = this.gameParser.getString("combine");
        if (combine != null) {
            grid.setCombine(combine);
        }
        for (Object cell : this.gameParser.getJSONarray("cells")) {
            JSONObject cellJson = (JSONObject) cell;
            int row = ((Long)cellJson.get("row")).intValue();
            int col = ((Long)cellJson.get("col")).intValue();
            ArrayList val = (JSONArray) cellJson.get("value");
            ArrayList sets = (JSONArray) cellJson.get("sets");
            ArrayList borders = (JSONArray) cellJson.get("borders");
            int type = ((Long)cellJson.get("type")).intValue();
            this.internalProcessOfValue(grid, type, val, sets, col, row, borders);
        }
        grid = loadRulesGame(grid);
        //grid.printSets();
        grid.printRules();
        return grid;
    }

    private void internalProcessOfValue(Grid grid, int type, ArrayList val, ArrayList sets, int col, int row, ArrayList borders) {

        switch (type) {
            case 1:
                addCellFlagsAndNumbers(grid, val, row  , col, sets, borders);
                break;
            case 2:
                addCellDualSum(grid, val, row, col, sets, borders);
                break;
            case 3:
                grid.addCell(new CellBlack(),row - 1 ,col - 1,sets, borders);
                break;
            case 4:
                addCellFlagsAndNumbers(grid, val, row, col, sets, borders);
                break;
            default:
                break;
        }
    }

    private void addCellDualSum(Grid grid, ArrayList val, int row, int col, ArrayList sets, ArrayList borders) {
        Vector<Value> vecAux = new Vector<>(val.size());
        for (Object values : val) {
            vecAux.add(new Value(((Long) values).intValue()));
        }

        grid.addCell(new CellDualSum(vecAux),row - 1, col - 1, sets, borders);
    }

    private void addCellFlagsAndNumbers(Grid grid, ArrayList val, int row, int col, ArrayList sets, ArrayList borders) {
        int intValue = ((Long) val.get(0)).intValue();
        grid.addCell(new CellFlagsAndNumbers(new Value(intValue)), row - 1, col - 1, sets, borders);
    }

    private void parseRules(Grid grid, ArrayList rulesArray) {
        Vector<Long> values = null ;
        for (Object arulesArray : rulesArray) {
            int idRule = ((Long) arulesArray).intValue();
            if (idRule < 5) {
                values = parserRulesFirst(idRule);
            } else if (idRule < 8) {
                values = parserRulesSecond(idRule);
            } else {
                values = parserRulesThird(idRule);
            }
            grid.loadRulesSet(idRule, values);
        }
    }

    private Vector<Long> parserRulesFirst(int idRule) {
        Vector<Long> values = null ;
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
        return values;
    }

    private Vector<Long> getValues(String name) {
        Vector<Long> values = null ;
        JSONArray valArray = this.gameParser.getJSONarray(name);
        return this.gameParser.toVector(valArray);
    }

    private Vector<Long> parserRulesSecond(int idRule) {
        Vector<Long> values = null ;
        switch (idRule) {
            case 5:
                values = this.getValues("continuity");
                //JSONArray continuity = this.gameParser.getJSONarray("continuity");
                //values = this.gameParser.toVector(continuity);
                break;
            case 6:
                values = this.getValues("corner");
                //JSONArray corner = this.gameParser.getJSONarray("corner");
                //values = this.gameParser.toVector(corner);
                break;
            case 7:
                values = this.getValues("border");

                //JSONArray border = this.gameParser.getJSONarray("border");
                //values = this.gameParser.toVector(border);
                break;
            default:
                break;
        }
        return values;
    }

    private Vector<Long> parserRulesThird(int idRule) {
        Vector<Long> values = null ;
        switch (idRule) {
            case 8:
                JSONArray noRepeatEnding = this.gameParser.getJSONarray("noRepeatEnding");
                values = this.gameParser.toVector(noRepeatEnding);
                break;
            case 9:
                JSONArray adjacents = this.gameParser.getJSONarray("adjacents");
                values = this.gameParser.toVector(adjacents);
                break;
            default:
                break;
        }
        return values;
    }

    private Grid loadRulesGame(Grid grid) {
        JSONArray rules = this.gameParser.getJSONarray("rulesets");
        ArrayList rulesArray = this.gameParser.toArrayList(rules);
        this.parseRules(grid, rulesArray);
        return grid;
    }

    public Vector<Value> getAllowedValues() {
        Vector<Value> valueAux = new Vector<>();
        ButtonHashing hashing = new ButtonHashing();

        JSONArray buttonsJson = this.gameParser.getJSONarray("buttons");
        ArrayList buttons = this.gameParser.toArrayList(buttonsJson);
        for (Object id: buttons) {
            int idButton = ((Long) id).intValue();
            valueAux.add(hashing.getMapAt(idButton));
        }
        return valueAux;
    }
}
