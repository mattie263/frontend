package uk.ac.sheffield.team10.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.sheffield.team10.model.TrainingBand;
import uk.ac.sheffield.team10.service.TrainingBandService;

@RestController
@RequestMapping("/api/training-band")
public class TrainingBandController {
    private final TrainingBandService trainingBandService;

    public TrainingBandController(TrainingBandService trainingBandService) {
        this.trainingBandService = trainingBandService;
    }

    @GetMapping
    public List<TrainingBand> getAll() {
        return trainingBandService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainingBand> getById(Long id) {
        Optional<TrainingBand> trainingBand = trainingBandService.findById(id);
        return trainingBand.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TrainingBand> create(@RequestBody TrainingBand trainingBand) {
        TrainingBand savedTrainingBand = trainingBandService.save(trainingBand);
        return new ResponseEntity<>(savedTrainingBand, HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<TrainingBand> update(@PathVariable Long id, @RequestBody TrainingBand updatedTrainingBand) {
        try {
            TrainingBand savedTrainingBand = trainingBandService.update(id, updatedTrainingBand);
            return ResponseEntity.ok(savedTrainingBand);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TrainingBand> delete(@PathVariable Long id) {
        trainingBandService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
