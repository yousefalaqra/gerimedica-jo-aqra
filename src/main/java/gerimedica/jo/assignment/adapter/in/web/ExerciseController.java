package gerimedica.jo.assignment.adapter.in.web;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import gerimedica.jo.assignment.domain.entity.ExerciseRecord;
import gerimedica.jo.assignment.domain.usecase.DeleteExercisesUseCase;
import gerimedica.jo.assignment.domain.usecase.FetchExercisesUseCase;
import gerimedica.jo.assignment.domain.usecase.UploadExercisesUseCase;

@RestController
public class ExerciseController {
    private UploadExercisesUseCase uploadExercisesUseCase;
    private FetchExercisesUseCase fetchExercisesUseCase;
    private DeleteExercisesUseCase deleteExercisesUseCase;

    public ExerciseController(
        UploadExercisesUseCase uploadExercisesUseCase,
        FetchExercisesUseCase fetchExercisesUseCase,
        DeleteExercisesUseCase deleteExercisesUseCase
    ){
        this.uploadExercisesUseCase = uploadExercisesUseCase;
        this.fetchExercisesUseCase = fetchExercisesUseCase;
        this.deleteExercisesUseCase = deleteExercisesUseCase;
    }

    @GetMapping("/api/exercises/all")
    public List<ExerciseRecord> getAll(){
        return this.fetchExercisesUseCase.getAllExercise();
    }

    @GetMapping("/api/exercise")
    public ExerciseRecord getAllByCode(@RequestParam("code") String code){
        return this.fetchExercisesUseCase.getExerciseByCode(code);
    }

    @PostMapping("/api/exercises/upload")
    public String uploadExercises(@RequestParam("file") MultipartFile file) throws IOException {
        this.uploadExercisesUseCase.SaveExercises(file.getInputStream());
        return "Success";
    }

    @DeleteMapping("/api/exercises")
    public String deleteAll(){
        this.deleteExercisesUseCase.deleteAllExercises();

        return "Success";
    }

}
