package com.firstapp.angular.version1.mongoRepository.sudokuPuzzle;

import com.firstapp.angular.version1.entity.Sudoku;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PuzzleMongoRepository extends MongoRepository<Sudoku, Integer> {
    List<Sudoku> findByLevel(String level);
    Sudoku findById(int id);
}
