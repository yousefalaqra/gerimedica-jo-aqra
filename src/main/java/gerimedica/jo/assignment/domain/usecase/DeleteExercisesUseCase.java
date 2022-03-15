package gerimedica.jo.assignment.domain.usecase;

import org.springframework.stereotype.Service;

import gerimedica.jo.assignment.domain.persistence.DeleteExercisesPort;

@Service
public class DeleteExercisesUseCase {

    private DeleteExercisesPort deleteExercisesPort;

    public DeleteExercisesUseCase(DeleteExercisesPort deleteExercisesPort) {
        this.deleteExercisesPort = deleteExercisesPort;
    }

    public void deleteAllExercises() {
        this.deleteExercisesPort.deleteAllExercises();
    }
}
