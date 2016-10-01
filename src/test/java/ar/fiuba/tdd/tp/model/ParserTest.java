package ar.fiuba.tdd.tp.model;

import ar.fiuba.tdd.tp.utils.Parser;
import org.junit.Test;

import static org.junit.Assert.*;


public class ParserTest {
    @Test
    public void getString() throws Exception {
        Parser parser = new Parser(System.getProperty("user.dir") + "/src/test/java/ar/fiuba/tdd/tp/model/" + "input" + ".json");
        assertEquals("String match ok",parser.getString("name"),"mkyong.com");
    }

    @Test
    public void getLong() throws Exception {
        Parser parser = new Parser(System.getProperty("user.dir") + "/src/test/java/ar/fiuba/tdd/tp/model/" + "input" + ".json");
        assertEquals("Long match ok",parser.getLong("age"),Long.valueOf(100));
    }

    @Test
    public void getJSONarray() throws Exception {
        Parser parser = new Parser(System.getProperty("user.dir") + "/src/test/java/ar/fiuba/tdd/tp/model/" + "input" + ".json");
        assertEquals("getJSONArray match ok",parser.getJSONarray("messages").size(),3);
    }

}