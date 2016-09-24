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

            String name = (String) jsonObject.get("name");
            System.out.println(name);

            long age = (Long) jsonObject.get("age");
            System.out.println(age);

            // loop array
            JSONArray msg = (JSONArray) jsonObject.get("messages");
            for (Object message : msg) {
                System.out.println(message);
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}