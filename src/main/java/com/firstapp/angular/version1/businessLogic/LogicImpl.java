package com.firstapp.angular.version1.businessLogic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LogicImpl {

    public boolean logicApplied(ArrayList<ArrayList<Integer>> givenSudoku){
        int n = givenSudoku.size();
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (givenSudoku.get(i).get(j) == 0) {
                    row = i;
                    col = j;

                    // we still have some remaining
                    // missing values in Sudoku
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }

        // no empty space left
        if (isEmpty) {
            return true;
        }

        // else for each-row backtrack
        for (int num = 1; num <= n; num++) {
            if (isSafe(givenSudoku, row, col, num)) {
                givenSudoku.get(row).set(col, num);
                if (logicApplied(givenSudoku)) {
                    // print(board, n);
                    return true;
                }
                else {
                    // replace it
                    givenSudoku.get(row).set(col,0);
                }
            }
        }
        return false;
    }

    private boolean isSafe(ArrayList<ArrayList<Integer>> givenSudoku,
                           int row, int col,
                           int num)
    {
        // row has the unique (row-clash)
        for (int d = 0; d < givenSudoku.size(); d++) {
            // if the number we are trying to
            // place is already present in
            // that row, return false;
            if (givenSudoku.get(row).get(d) == num) {
                return false;
            }
        }

        // column has the unique numbers (column-clash)
        for (int r = 0; r < givenSudoku.size(); r++) {
            // if the number we are trying to
            // place is already present in
            // that column, return false;

            if (givenSudoku.get(r).get(col)== num) {
                return false;
            }
        }

        // corresponding square has
        // unique number (box-clash)
        int sqrt = (int)Math.sqrt(givenSudoku.size());
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for (int r = boxRowStart;
             r < boxRowStart + sqrt; r++) {
            for (int d = boxColStart;
                 d < boxColStart + sqrt; d++) {
                if (givenSudoku.get(r).get(d)== num) {
                    return false;
                }
            }
        }

        // if there is no clash, it's safe
        return true;
    }
}
