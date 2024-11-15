package uk.ac.sheffield.team10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.ac.sheffield.team10.model.TrainingBand;

public interface TrainingBandRepository extends JpaRepository<TrainingBand, Long> {
}
