package com.firstapp.angular.version1.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;

@Component
@Document
public class Sudoku {

    private ArrayList<ArrayList<Integer>> sudokuStructure = new ArrayList(new ArrayList<Integer>());
    private String level = null;
    @Id
    public int id;
    Random random = new Random();

    public Sudoku() {
    }

    public Sudoku(ArrayList<ArrayList<Integer>> sudokuStructure, String level) {
        this.sudokuStructure = sudokuStructure;
        this.level = level;
        this.id = random.nextInt(1000);
    }

    public ArrayList<ArrayList<Integer>> getSudokuStructure() {
        return sudokuStructure;
    }

    public void setSudokuStructure(ArrayList<ArrayList<Integer>> sudokuStructure, String level) {
        this.sudokuStructure = sudokuStructure;
        this.level = level;
        this.id = random.nextInt(1000);
    }

    public String getLevel() {
        return level;
    }
}
