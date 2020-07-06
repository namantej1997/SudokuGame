package com.firstapp.angular.version1.dao;

import com.firstapp.angular.version1.entity.Sudoku;

import java.util.List;

public interface ISudokuDAO {
    List<Sudoku> fetchSudoku();
    void insertSudoku(Sudoku sudoku, String level) throws Exception;
    void deleteSudoku(int id) throws Exception;
}
