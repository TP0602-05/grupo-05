package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.model.observables.Game;
import ar.fiuba.tdd.tp.utils.AutomaticPlayer;

public class Main {
    public static void main(String[] args) {

        Game.init("country");
        String path = System.getProperty("user.dir") + "/src/main/java/ar/fiuba/tdd/tp/games/country.json" ;

        try {
            AutomaticPlayer automaticPlayer = new AutomaticPlayer(path);
            automaticPlayer.playGame();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}