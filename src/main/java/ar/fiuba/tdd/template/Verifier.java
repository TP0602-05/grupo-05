package ar.fiuba.tdd.template;

import java.util.ArrayList;

public class Verifier {
    private ArrayList<SetOfValues> setOfValues;

    ArrayList<Integer>[][] indexSet;

    public boolean insertValue(int row, int col, Object obj) {
        ArrayList<Integer> sets = indexSet[row][col];
        boolean canInsert = true;
        for (int a=0; a<sets.size(); a++) {
            int indexInSet = sets.get(a);
            if (!setOfValues.get(indexInSet).canInsertValue(obj))
                canInsert = false;
        }
        if (canInsert) {
            for (int a=0; a<sets.size(); a++) {
                int indexInSet = sets.get(a);
                setOfValues.get(indexInSet).insertValue(obj);
            }
            return true;
        }
        else {
            return false;
        }
    }

    public void deleteValue(int row, int col, Object obj){
        ArrayList<Integer> sets = indexSet[row][col];
        for (int a=0; a<sets.size(); a++) {
            int indexInSet = sets.get(a);
            setOfValues.get(indexInSet).deleteValue(obj);
        }
    }
}
