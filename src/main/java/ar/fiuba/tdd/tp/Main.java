package ar.fiuba.tdd.tp;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        System.out.println("This is just a tp project");

        JSONParser parser = new JSONParser();

        try {

            String path = System.getProperty("user.dir") + "/src/main/java/ar/fiuba/tdd/tp/model/" + "input" + ".json";
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
        }
    }
}