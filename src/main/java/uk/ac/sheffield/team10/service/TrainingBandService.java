package uk.ac.sheffield.team10.service;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import uk.ac.sheffield.team10.model.TrainingBand;
import uk.ac.sheffield.team10.repository.TrainingBandRepository;

@Service
public class TrainingBandService {
    private final TrainingBandRepository trainingBandRepository;

    public TrainingBandService(TrainingBandRepository trainingBandRepository) {
        this.trainingBandRepository = trainingBandRepository;
    }

    public List<TrainingBand> getAllTrainingBands() {
        return trainingBandRepository.findAll();
    }

    public Optional<TrainingBand> findTrainingBandById(Long id) {
        return trainingBandRepository.findById(id);
    }

    public TrainingBand saveTrainingBand(TrainingBand trainingBand) {
        return trainingBandRepository.save(trainingBand);
    }

    public TrainingBand updateTrainingBand(Long id, TrainingBand updatedTrainingBand) {
        Optional<TrainingBand> trainingBandOptional = trainingBandRepository.findById(id);
        if (trainingBandOptional.isPresent()) {
            TrainingBand trainingBand = trainingBandOptional.get();
            trainingBand.setName(updatedTrainingBand.getName());
            return trainingBandRepository.save(trainingBand);
        } else {
            throw new RuntimeException("Training Band Not Found -> id=" + id);
        }
    }

    public void deleteTrainingBand(Long id) {
        trainingBandRepository.deleteById(id);
    }
}
