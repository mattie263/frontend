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
import uk.ac.sheffield.team10.model.SeniorBand;
import uk.ac.sheffield.team10.service.SeniorBandService;

@RestController
@RequestMapping("/api/senior-band")
public class SeniorBandController {
    private final SeniorBandService seniorBandService;

    public SeniorBandController(SeniorBandService seniorBandService) {
        this.seniorBandService = seniorBandService;
    }

    @GetMapping
    public List<SeniorBand> getAllSeniorBands() {
        return seniorBandService.getAllSeniorBands();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeniorBand> getSeniorBandById(Long id) {
        Optional<SeniorBand> seniorBand = seniorBandService.findSeniorBandById(id);
        return seniorBand.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SeniorBand> createSeniorBand(@RequestBody SeniorBand seniorBand) {
        SeniorBand savedSeniorBand = seniorBandService.saveSeniorBand(seniorBand);
        return new ResponseEntity<>(savedSeniorBand, HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<SeniorBand> updateSeniorBand(@PathVariable Long id, @RequestBody SeniorBand updatedSeniorBand) {
        try {
            SeniorBand savedSeniorBand = seniorBandService.updateSeniorBand(id, updatedSeniorBand);
            return ResponseEntity.ok(savedSeniorBand);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SeniorBand> deleteSeniorBand(@PathVariable Long id) {
        seniorBandService.deleteSeniorBand(id);
        return ResponseEntity.noContent().build();
    }
}
