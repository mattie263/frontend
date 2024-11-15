package uk.ac.sheffield.team10.controller;

import java.util.List;
import java.util.Optional;

import javax.swing.plaf.basic.BasicTreeUI.TreeHomeAction;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import uk.ac.sheffield.team10.model.ChildMember;
import uk.ac.sheffield.team10.model.SeniorBand;
import uk.ac.sheffield.team10.model.TrainingBand;
import uk.ac.sheffield.team10.repository.TrainingBandRepository;
import uk.ac.sheffield.team10.service.AdultMemberService;
import uk.ac.sheffield.team10.service.ChildMemberService;
import uk.ac.sheffield.team10.service.SeniorBandService;
import uk.ac.sheffield.team10.service.TrainingBandService;

@RestController
@RequestMapping("/api/training-band")
public class TrainingBandController {
    private final TrainingBandService trainingBandService;

    public TrainingBandController(TrainingBandService trainingBandService) {
        this.trainingBandService = trainingBandService;
    }

    @GetMapping
    public List<TrainingBand> getAllTrainingBands() {
        return trainingBandService.getAllTrainingBands();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainingBand> getTrainingBandById(Long id) {
        Optional<TrainingBand> trainingBand = trainingBandService.findTrainingBandById(id);
        return trainingBand.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TrainingBand> createTrainingBand(@RequestBody TrainingBand trainingBand) {
        TrainingBand savedTrainingBand = trainingBandService.saveTrainingBand(trainingBand);
        return new ResponseEntity<>(savedTrainingBand, HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<TrainingBand> updateTrainingBand(@PathVariable Long id, @RequestBody TrainingBand updatedTrainingBand) {
        try {
            TrainingBand savedTrainingBand = trainingBandService.updateTrainingBand(id, updatedTrainingBand);
            return ResponseEntity.ok(savedTrainingBand);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TrainingBand> deleteTrainingBand(@PathVariable Long id) {
        trainingBandService.deleteTrainingBand(id);
        return ResponseEntity.noContent().build();
    }
}
