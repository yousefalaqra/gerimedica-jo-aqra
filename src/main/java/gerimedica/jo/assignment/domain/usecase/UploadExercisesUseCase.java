package gerimedica.jo.assignment.domain.usecase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import gerimedica.jo.assignment.domain.entity.ExerciseRecord;
import gerimedica.jo.assignment.domain.persistence.SaveExercisesPort;

@Service
public class UploadExercisesUseCase {

    private SaveExercisesPort saveExercisesPort;

    public UploadExercisesUseCase(SaveExercisesPort saveExercisesPort) {
        this.saveExercisesPort = saveExercisesPort;
    }

    public void SaveExercises(InputStream inputSteam) throws IOException {
        try (
                Reader reader = new BufferedReader(new InputStreamReader(inputSteam, "UTF-8"));
                CSVParser csvParser = new CSVParser(reader,
                        CSVFormat.DEFAULT.withHeader().withSkipHeaderRecord(false))) {

            List<ExerciseRecord> exercises = new ArrayList<ExerciseRecord>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord csvRecord : csvRecords) {
                ExerciseRecord exercise = new ExerciseRecord(
                        csvRecord.get("source"),
                        csvRecord.get("codeListCode"),
                        csvRecord.get("code"),
                        csvRecord.get("displayValue"),
                        csvRecord.get("longDescription"),
                        csvRecord.get("fromDate"),
                        csvRecord.get("toDate"),
                        csvRecord.get("sortingPriority").isEmpty() ? null
                                : Integer.parseInt(csvRecord.get("sortingPriority")));
                exercises.add(exercise);
            }

            this.saveExercisesPort.saveTimeRecords(exercises);

        } catch (Exception ex) {
            throw new RuntimeException("fail to parse CSV file: " + ex.toString());
        }

    }

}
