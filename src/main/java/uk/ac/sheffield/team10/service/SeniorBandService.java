package uk.ac.sheffield.team10.service;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import uk.ac.sheffield.team10.model.SeniorBand;
import uk.ac.sheffield.team10.repository.SeniorBandRepository;

@Service
public class SeniorBandService {
    private final SeniorBandRepository seniorBandRepository;

    public SeniorBandService(SeniorBandRepository seniorBandRepository) {
        this.seniorBandRepository = seniorBandRepository;
    }

    public List<SeniorBand> getAllSeniorBands() {
        return seniorBandRepository.findAll();
    }

    public Optional<SeniorBand> findSeniorBandById(Long id) {
        return seniorBandRepository.findById(id);
    }

    public SeniorBand saveSeniorBand(SeniorBand seniorBand) {
        return seniorBandRepository.save(seniorBand);
    }

    public SeniorBand updateSeniorBand(Long id, SeniorBand updatedSeniorBand) {
        Optional<SeniorBand> seniorBandOptional = seniorBandRepository.findById(id);
        if (seniorBandOptional.isPresent()) {
            SeniorBand seniorBand = seniorBandOptional.get();
            seniorBand.setName(updatedSeniorBand.getName());
            return seniorBandRepository.save(seniorBand);
        } else {
            throw new RuntimeException("Senior Band Not Found -> id=" + id);
        }
    }

    public void deleteSeniorBand(Long id) {
        seniorBandRepository.deleteById(id);
    }
}
