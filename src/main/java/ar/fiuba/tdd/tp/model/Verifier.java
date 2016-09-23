package ar.fiuba.tdd.tp.model;

import ar.fiuba.tdd.tp.model.SetOfValues;

import java.util.ArrayList;

public class Verifier {
    private ArrayList<SetOfValues> setOfValues;
    private ArrayList<Integer>[][] indexSet;

    public Verifier() {
        setOfValues = new ArrayList<>();
        indexSet = null;
    }

    public boolean insertValue(int row, int col, Object obj) {
        ArrayList<Integer> sets = indexSet[row][col];
        if (canInsert(row,col,obj)) {
            for (int a = 0 ; a < sets.size(); a++) {
                int indexInSet = sets.get(a);
                setOfValues.get(indexInSet).insertValue(obj);
            }
            return true;
        }
        else {
            return false;
        }
    }

    private boolean canInsert(int row, int col, Object obj) {
        ArrayList<Integer> sets = indexSet[row][col];
        boolean canInsert = true;
        for (int a = 0 ; a<sets.size(); a++) {
            int indexInSet = sets.get(a);
            if (!setOfValues.get(indexInSet).canInsertValue(obj))
                canInsert = false;
        }
        return canInsert;
    }

    public void deleteValue(int row, int col, Object obj){
        ArrayList<Integer> sets = indexSet[row][col];
        for (int a=0; a<sets.size(); a++) {
            int indexInSet = sets.get(a);
            setOfValues.get(indexInSet).deleteValue(obj);
        }
    }
}
