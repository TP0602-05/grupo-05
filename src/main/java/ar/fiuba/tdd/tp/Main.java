package ar.fiuba.tdd.tp;

import ar.fiuba.tdd.tp.model.Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Welcome. Please enter a game name:");
        String gameName = null;
        try {
            gameName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("You will play : " + gameName);
        Game.init(gameName.trim());

    }
}