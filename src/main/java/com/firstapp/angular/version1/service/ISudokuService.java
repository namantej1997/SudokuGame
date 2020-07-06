package com.firstapp.angular.version1.service;

import com.firstapp.angular.version1.entity.Sudoku;

import java.util.List;

public interface ISudokuService {
    List<Sudoku> filterSudoku(String filter);
    void getResult(Sudoku sudoku);
}
