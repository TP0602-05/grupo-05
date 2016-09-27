package ar.fiuba.tdd.tp.model;

import org.junit.Test;

import static org.junit.Assert.*;


public class ParserTest {
    @Test
    public void getString() throws Exception {
        Parser parser = new Parser(System.getProperty("user.dir") + "/src/test/java/ar/fiuba/tdd/tp/model/" + "input" + ".json");
        assertEquals(parser.getString("name"),"mkyong.com");
    }

    @Test
    public void getLong() throws Exception {
        Parser parser = new Parser(System.getProperty("user.dir") + "/src/test/java/ar/fiuba/tdd/tp/model/" + "input" + ".json");
        assertEquals(parser.getLong("age"),new Long(100));
    }

    @Test
    public void getJSONarray() throws Exception {
        Parser parser = new Parser(System.getProperty("user.dir") + "/src/test/java/ar/fiuba/tdd/tp/model/" + "input" + ".json");
        assertEquals(parser.getJSONarray("messages").size(),3);
    }

}