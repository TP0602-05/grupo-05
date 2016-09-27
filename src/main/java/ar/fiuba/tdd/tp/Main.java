package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.model.GameBuilder;
import ar.fiuba.tdd.tp.model.Grid;

public class Main {
    public static void main(String[] args) {
        System.out.println("This is just a tp project");
        GameBuilder game = new GameBuilder("sudoku");
        try {
            game.loadConf();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Grid grilla = game.createGrid();
        String name =  game.getGameName();
        System.out.println(name);
        grilla.printGrid();

        //JSONParser parser = new JSONParser();

        /*try {

            String path = System.getProperty("user.dir") + "/src/main/java/ar/fiuba/tdd/tp/model/" ;
            System.out.println(path);
            Object obj = parser.parse(new InputStreamReader(new FileInputStream(path), "UTF-8"));

            JSONObject jsonObject = (JSONObject) obj;
            JSONArray cells =  (JSONArray)jsonObject.get("cells");
            System.out.println("cells");
            for (Object cell : cells) {
                System.out.println(cell);
            }

            JSONArray rulesets = (JSONArray) jsonObject.get("rulesets");
            System.out.println(rulesets);

            // loop array
            //int msg = (int) jsonObject.get("nsets");


        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }*/

    }
}