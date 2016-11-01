package ar.fiuba.tdd.tp.model.rule;

import ar.fiuba.tdd.tp.model.cell.PositionValueDuo;
import ar.fiuba.tdd.tp.model.cell.Value;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Checks if the specified number of lines corresponds with the amount of lines drawn.
 */
public class AmountOfLinesRule implements Rule {

    private int amountOfLines;
    private static final int CENTER = 4;
    private static final int UP = 1;
    private static final int LEFT = 3;
    private static final int RIGTH = 5;
    private static final int DOWN = 7;

    public AmountOfLinesRule(Integer amount) {
        this.amountOfLines = amount;
    }


    public boolean checkFinal(ArrayList<PositionValueDuo> values) {
        if (this.amountOfLines < 0) {
            return true;
        }
        int cantLines = 0;
        for (PositionValueDuo valueToCount: values) {
            cantLines += this.countLinesOfOne(valueToCount.getValue().getDots());
        }
        return (cantLines == amountOfLines);
    }


    public boolean check(ArrayList<PositionValueDuo> values, PositionValueDuo value) {

        if (this.amountOfLines < 0) {
            return true;
        }
        int cantLines = this.countLinesOfOne(value.getValue().getDots());
        /*System.out.println("let's see. Lines to add:"+cantLines);
        System.out.println("Size of values :  "+values.size());
        */
        for ( PositionValueDuo valueToCount: values ) {
            //value.getValue().printBorders();
            cantLines += this.countLinesOfOne(valueToCount.getValue().getDots());
        }
        //System.out.println("Lines tootal:"+cantLines);

        /*if (cantLines <= amountOfLines) {
            System.out.println("good");
        } else {
            System.out.println("fuuu");
        }*/

        return (cantLines <= amountOfLines);
    }

    private int countLinesOfOne(Vector<Boolean> booleans) {
        int counter = 0;
        //int finalCont;
        if ( booleans.elementAt(CENTER) ) {
            return 1;
        } else {
            return (boolToInt(booleans.elementAt(UP)) + boolToInt(booleans.elementAt(LEFT))
                    + boolToInt(booleans.elementAt(RIGTH)) + boolToInt(booleans.elementAt(DOWN)));
            /*if (booleans.elementAt(UP)) {
                counter++;
            }
            if (booleans.elementAt(LEFT)) {
                counter++;
            }
            if (booleans.elementAt(RIGTH)) {
                counter++;
            }
            if (booleans.elementAt(DOWN)) {
                counter++;
            }*/
        }
        /* System.out.println(" booleans: "+booleans.toString());
        System.out.println("Counter lines: "+counter);

        */
        //return counter;

        /*
        for (Boolean mybool : booleans) {
            if (mybool) {
                counter++;
            }
        }
        if (counter == 8) {
            finalCont = 4;
        } else {
            finalCont = ((counter - 1) / 2);
        }

                return finalCont;
        }
        */
    }

    private int boolToInt(Boolean boo) {
        if (boo) {
            return 1;
        }
        return 0;
    }

    public void printRule() {

    }
}
