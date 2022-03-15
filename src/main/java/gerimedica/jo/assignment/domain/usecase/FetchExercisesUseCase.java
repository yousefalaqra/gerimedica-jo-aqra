package gerimedica.jo.assignment.domain.usecase;

import gerimedica.jo.assignment.domain.entity.ExerciseRecord;
import java.util.List;

import org.springframework.stereotype.Service;

import gerimedica.jo.assignment.domain.persistence.FetchExercisesPort;

@Service
public class FetchExercisesUseCase {

    private FetchExercisesPort fetchExercisesPort;

    public FetchExercisesUseCase(FetchExercisesPort fetchExercisesPort) {
        this.fetchExercisesPort = fetchExercisesPort;
    }

    public List<ExerciseRecord> getAllExercise() {
        return this.fetchExercisesPort.getAllExercises();
    }

    public ExerciseRecord getExerciseByCode(String code) {
        return this.fetchExercisesPort.getExerciseByCode(code);
    }
}
