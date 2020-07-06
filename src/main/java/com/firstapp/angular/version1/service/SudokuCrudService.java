package com.firstapp.angular.version1.service;

import com.firstapp.angular.version1.businessLogic.LogicImpl;
import com.firstapp.angular.version1.entity.Sudoku;
import com.firstapp.angular.version1.mongoRepository.sudokuPuzzle.PuzzleMongoRepository;
import com.firstapp.angular.version1.mongoRepository.sudokuSolution.SolMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SudokuCrudService {

    @Autowired
    PuzzleMongoRepository puzzleMongoRepository;

    @Autowired
    SolMongoRepository solMongoRepository;

    @Autowired
    LogicImpl logicImpl;

    //Create operations
    public Sudoku create(ArrayList<ArrayList<Integer>> sudokuStructure, String level){
        return puzzleMongoRepository.save(new Sudoku(sudokuStructure,level));
    }

    //retrieve
    public List<Sudoku> getAll(){
        return puzzleMongoRepository.findAll();
    }

    public Sudoku getById(int id){
        return puzzleMongoRepository.findById(id);
    }

    //delete
    public void deleteById(int id){
        Sudoku sudoku = puzzleMongoRepository.findById(id);
        puzzleMongoRepository.delete(sudoku);
        solMongoRepository.delete(sudoku);
    }

    public void getResult(Sudoku sudoku) {
        if(logicImpl.logicApplied(sudoku.getSudokuStructure())){
            print(sudoku.getSudokuStructure());
            solMongoRepository.save(sudoku);
        }
        else{
            System.out.println("No solution");
        }
    }

    private void print(ArrayList<ArrayList<Integer>> givenSudoku)
    {
        int N = givenSudoku.size();
        // we got the answer, just print it
        for (int r = 0; r < N; r++) {
            for (int d = 0; d < N; d++) {
                System.out.print(givenSudoku.get(r).get(d));
                System.out.print(" ");
            }
            System.out.print("\n");

            if ((r + 1) % (int)Math.sqrt(N) == 0) {
                System.out.print("");
            }
        }
    }
}
