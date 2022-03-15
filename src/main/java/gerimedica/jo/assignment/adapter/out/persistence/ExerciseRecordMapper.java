package gerimedica.jo.assignment.adapter.out.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import gerimedica.jo.assignment.domain.entity.ExerciseRecord;

@Component
public class ExerciseRecordMapper {

    public ExerciseRecord toDomainObject(ExerciseEntity entity) {
        return new ExerciseRecord(
                entity.getSource(),
                entity.getCodeListCode(),
                entity.getCode(),
                entity.getDisplayValue(),
                entity.getLongDescription(),
                entity.getFromDate(),
                entity.getToDate(),
                entity.getSortingPriority());
    }

    public List<ExerciseRecord> toDomainObjects(List<ExerciseEntity> entities) {
        List<ExerciseRecord> domainObjects = new ArrayList<ExerciseRecord>();

        for (ExerciseEntity entity : entities) {
            domainObjects.add(toDomainObject(entity));
        }
        return domainObjects;
    }

    public ExerciseEntity toEntity(ExerciseRecord domainObject) {
        return new ExerciseEntity(
                domainObject.getSource(),
                domainObject.getCodeListCode(),
                domainObject.getCode(),
                domainObject.getDisplayValue(),
                domainObject.getLongDescription(),
                domainObject.getFromDate(),
                domainObject.getToDate(),
                domainObject.getSortingPriority());
    }

    public List<ExerciseEntity> toEntities(List<ExerciseRecord> domainObjects) {
        List<ExerciseEntity> entities = new ArrayList<ExerciseEntity>();
        for (ExerciseRecord domainObject : domainObjects) {
            entities.add(toEntity(domainObject));
        }
        return entities;
    }
}
