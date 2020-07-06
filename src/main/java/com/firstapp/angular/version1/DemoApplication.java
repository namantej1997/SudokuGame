package com.firstapp.angular.version1;

import com.firstapp.angular.version1.entity.Sudoku;
import com.firstapp.angular.version1.service.SudokuCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(exclude={MongoAutoConfiguration.class,MongoDataAutoConfiguration.class})
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private SudokuCrudService sudokuCrudService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		ArrayList<Integer> row1 = new ArrayList<>(
				List.of(0,0,0,0,0,5,0,1,9));
		ArrayList<Integer> row2 = new ArrayList<>(
				List.of(9,1,5,0,4,0,0,0,6));
		ArrayList<Integer> row3 = new ArrayList<>(
				List.of(0,0,0,0,9,0,5,0,0));
		ArrayList<Integer> row4 = new ArrayList<>(
				List.of(0,2,0,0,1,4,0,8,0));
		ArrayList<Integer> row5 = new ArrayList<>(
				List.of(0,0,0,8,0,2,0,0,0));
		ArrayList<Integer> row6 = new ArrayList<>(
				List.of(0,7,0,3,6,0,0,4,0));
		ArrayList<Integer> row7 = new ArrayList<>(
				List.of(0,0,1,0,8,0,0,0,0));
		ArrayList<Integer> row8 = new ArrayList<>(
				List.of(8,0,0,0,7,0,4,2,1));
		ArrayList<Integer> row9 = new ArrayList<>(
				List.of(4,6,0,5,0,0,0,0,0));

		ArrayList<ArrayList<Integer>> sudoku2Array = new ArrayList<>();
		sudoku2Array.add(row1);
		sudoku2Array.add(row2);
		sudoku2Array.add(row3);
		sudoku2Array.add(row4);
		sudoku2Array.add(row5);
		sudoku2Array.add(row6);
		sudoku2Array.add(row7);
		sudoku2Array.add(row8);
		sudoku2Array.add(row9);

		Sudoku sudoku2 = sudokuCrudService.create(sudoku2Array,"Medium");
		sudokuCrudService.getResult(sudoku2);
	}
}
