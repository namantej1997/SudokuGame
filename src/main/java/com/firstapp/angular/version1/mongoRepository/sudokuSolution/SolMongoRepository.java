package com.firstapp.angular.version1.mongoRepository.sudokuSolution;

import com.firstapp.angular.version1.entity.Sudoku;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface SolMongoRepository extends MongoRepository<Sudoku,Integer> {
    ArrayList<ArrayList<Integer>> findSolByIdAndLevel(int id, String level);
}
