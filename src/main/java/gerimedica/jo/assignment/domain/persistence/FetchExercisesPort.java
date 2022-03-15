package gerimedica.jo.assignment.domain.persistence;

import java.util.List;

import gerimedica.jo.assignment.domain.entity.ExerciseRecord;

public interface FetchExercisesPort {
    
    List<ExerciseRecord> getAllExercises();

    ExerciseRecord getExerciseByCode(String code);

}
