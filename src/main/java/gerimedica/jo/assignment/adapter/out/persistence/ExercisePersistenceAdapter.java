package gerimedica.jo.assignment.adapter.out.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import gerimedica.jo.assignment.domain.entity.ExerciseRecord;
import gerimedica.jo.assignment.domain.persistence.DeleteExercisesPort;
import gerimedica.jo.assignment.domain.persistence.FetchExercisesPort;
import gerimedica.jo.assignment.domain.persistence.SaveExercisesPort;

@Component
public class ExercisePersistenceAdapter implements SaveExercisesPort, DeleteExercisesPort, FetchExercisesPort {

    private ExerciseRepository exerciseRepository;
    private ExerciseRecordMapper exerciseRecordMapper;

    public ExercisePersistenceAdapter(ExerciseRepository exerciseRepository,
            ExerciseRecordMapper exerciseRecordMapper) {
        this.exerciseRepository = exerciseRepository;
        this.exerciseRecordMapper = exerciseRecordMapper;
    }

    @Override
    public void saveTimeRecords(List<ExerciseRecord> exercises) {
        List<ExerciseEntity> entities = this.exerciseRecordMapper.toEntities(exercises);

        this.exerciseRepository.saveAll(entities);

    }

    @Override
    public List<ExerciseRecord> getAllExercises() {
        List<ExerciseEntity> entities = this.exerciseRepository.findAll();

        return this.exerciseRecordMapper.toDomainObjects(entities);
    }

    @Override
    public ExerciseRecord getExerciseByCode(String code) {

        ExerciseEntity entity =  this.exerciseRepository.findById(code).get();

        return this.exerciseRecordMapper.toDomainObject(entity);
    }

    @Override
    public void deleteAllExercises() {
        this.exerciseRepository.deleteAll();
    }

}
