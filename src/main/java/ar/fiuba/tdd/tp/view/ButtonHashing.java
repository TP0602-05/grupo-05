package ar.fiuba.tdd.tp.view;


import ar.fiuba.tdd.tp.model.cell.Value;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;

public class ButtonHashing {
    public Value getMapAt(int position) {
        return map.get(position);
    }

    HashMap<Integer,Value> map;

    void putValues(Vector<Boolean> boolvec1) {
        map.put(1,new Value(1,boolvec1));
        map.put(2,new Value(2,boolvec1));
        map.put(3,new Value(3,boolvec1));
        map.put(4,new Value(4,boolvec1));
        map.put(5,new Value(5,boolvec1));
        map.put(6,new Value(6,boolvec1));
        map.put(7,new Value(7,boolvec1));
        map.put(8,new Value(8,boolvec1));
        map.put(9,new Value(9,boolvec1));
    }

    void putVectorOne() {
        // 1
        Boolean[] boollist2 = {true,false,false,true,false,false,true,false,false};
        Vector<Boolean> boolvec2 = new Vector<>(Arrays.asList(boollist2));
        map.put(10,new Value(0,boolvec2));
    }

    void putVectorTwo() {
        // 2
        Boolean[] boollist3 = {true,true,true,false,false,false,false,false,false};
        Vector<Boolean> boolvec3 = new Vector<>(Arrays.asList(boollist3));
        map.put(11,new Value(0,boolvec3));
    }

    void putVectorThree() {
        // 3
        Boolean[] boollist4 = {false,false,true,false,false,true,false,false,true};
        Vector<Boolean> boolvec4 = new Vector<>(Arrays.asList(boollist4));
        map.put(12,new Value(0,boolvec4));
    }

    void putVectorFour() {
        // 4
        Boolean[] boollist5 = {false,false,false,false,false,false,true,true,true};
        Vector<Boolean> boolvec5 = new Vector<>(Arrays.asList(boollist5));
        map.put(13,new Value(0,boolvec5));
    }

    void putVectorFive() {
        // 5
        Boolean[] boollist6 = {true,false,false,false,true,false,false,false,true};
        Vector<Boolean> boolvec6 = new Vector<>(Arrays.asList(boollist6));
        map.put(14,new Value(0,boolvec6));
    }

    void putVectorSix() {
        // 6
        Boolean[] boollist7 = {false,false,true,false,true,false,true,false,false};
        Vector<Boolean> boolvec7 = new Vector<>(Arrays.asList(boollist7));
        map.put(15,new Value(0,boolvec7));
    }

    void putVectorSeven() {
        // 7
        Boolean[] boollist8 = {false,false,false,false,true,true,false,true,false};
        Vector<Boolean> boolvec8 = new Vector<>(Arrays.asList(boollist8));
        map.put(16,new Value(0,boolvec8));
    }

    void putVectorEight() {
        // 8
        Boolean[] boollist9 = {false,false,false,true,true,false,false,true,false};
        Vector<Boolean> boolvec9 = new Vector<>(Arrays.asList(boollist9));
        map.put(17,new Value(0,boolvec9));
    }

    void putVectorNine() {
        // 9
        Boolean[] boollist10 = {false,true,false,false,true,true,false,false,false};
        Vector<Boolean> boolvec10 = new Vector<>(Arrays.asList(boollist10));
        map.put(18,new Value(0,boolvec10));
    }

    void putVectorTen() {
        // 10
        Boolean[] boollist11 = {false,true,false,true,true,false,false,false,false};
        Vector<Boolean> boolvec11 = new Vector<>(Arrays.asList(boollist11));
        map.put(19,new Value(0,boolvec11));
    }

    void putVectorEleven() {
        // 11
        Boolean[] boollist12 = {false,true,false,false,true,false,false,true,false};
        Vector<Boolean> boolvec12 = new Vector<>(Arrays.asList(boollist12));
        map.put(20,new Value(0,boolvec12));
    }

    void putVectorTwelve() {
        // 12
        Boolean[] boollist13 = {false,false,false,true,true,true,false,false,false};
        Vector<Boolean> boolvec13 = new Vector<>(Arrays.asList(boollist13));
        map.put(21,new Value(0,boolvec13));
    }

    public ButtonHashing() {
        map = new HashMap<>();
        Boolean[] boollist1 = {false,false,false,false,false,false,false,false,false};
        Vector<Boolean> boolvec1 = new Vector<>(Arrays.asList(boollist1));

        putValues(boolvec1);

        putVectorOne();
        putVectorTwo();
        putVectorThree();
        putVectorFour();
        putVectorFive();
        putVectorSix();
        putVectorSeven();
        putVectorEight();
        putVectorNine();
        putVectorTen();
        putVectorEleven();
        putVectorTwelve();

    }
}
