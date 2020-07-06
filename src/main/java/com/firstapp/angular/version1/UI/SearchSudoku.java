package com.firstapp.angular.version1.UI;

import com.firstapp.angular.version1.entity.Sudoku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class SearchSudoku {

    @Autowired
    private Sudoku sudoku;

    public ArrayList<Sudoku> getSudokuList(){
        ArrayList<Sudoku> sudokuList = new ArrayList<>();



        return sudokuList;
    }
}
