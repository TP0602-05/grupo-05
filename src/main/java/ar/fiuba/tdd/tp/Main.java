package ar.fiuba.tdd.tp;


import ar.fiuba.tdd.tp.model.Grid;

/**
 * Created by nicolas on 21/09/16.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("This is just a tp project");
        Grid grid = new Grid();
        grid.insertValue(1,1,null);
        grid.deleteValue(1,1);
        //TestGrid01 tg = new TestGrid01();
    }
}
