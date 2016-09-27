package ar.fiuba.tdd.tp.model;

import ar.fiuba.tdd.tp.model.cell.Cell;
import ar.fiuba.tdd.tp.model.cell.Value;
import ar.fiuba.tdd.tp.utils.Parser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class GameBuilder {

    private String gameName;
    private Parser gameParser;

    public GameBuilder(String gameName) {
        this.gameName = gameName;
    }

    public  GameBuilder loadConf() throws Exception {
        String path = System.getProperty("user.dir") + "/src/main/java/ar/fiuba/tdd/tp/model/" + gameName + ".json" ;
        this.gameParser = new Parser(path);
        return this;
    }

    public Grid createGrid() {
        int height = this.gameParser.getJsonInt("rows");
        int width = this.gameParser.getJsonInt("cols");
        JSONArray cells = this.gameParser.getJSONarray("cells");
        Grid grid = new Grid(width,height);
        for (Object cell : cells) {
            JSONObject cellJson = (JSONObject) cell;
            int row = ((Long)cellJson.get("row")).intValue();
            int col = ((Long)cellJson.get("col")).intValue();
            JSONArray values = (JSONArray) cellJson.get("value");
            for (Object val : values) {
                //System.out.println(val);
                int intValue = (int)((Long) val).intValue();
                grid.addCell(new Cell(new Value(intValue)),row - 1,col - 1);
            }

        }

        /*for (int row = 0; row < height; ++row) {
            int i = 1;
            for (int col = 0; col < width; ++col) {
                grid.addCell(new Cell(new Value(i)),row,col);
                i+=1;
            }
        }
        */
        return grid;
    }

    public void createSetsOfValues(Grid grid) {

    }

    public String getGameName() {
        return this.gameName;
    }
}
