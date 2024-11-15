package uk.ac.sheffield.team10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.ac.sheffield.team10.model.SeniorBand;

public interface SeniorBandRepository extends JpaRepository<SeniorBand, Long> {
}
