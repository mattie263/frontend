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
    public List<SeniorBand> getAll() {
        return seniorBandService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeniorBand> getById(Long id) {
        Optional<SeniorBand> seniorBand = seniorBandService.findById(id);
        return seniorBand.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SeniorBand> create(@RequestBody SeniorBand seniorBand) {
        SeniorBand savedSeniorBand = seniorBandService.save(seniorBand);
        return new ResponseEntity<>(savedSeniorBand, HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<SeniorBand> update(@PathVariable Long id, @RequestBody SeniorBand updatedSeniorBand) {
        try {
            SeniorBand savedSeniorBand = seniorBandService.update(id, updatedSeniorBand);
            return ResponseEntity.ok(savedSeniorBand);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SeniorBand> delete(@PathVariable Long id) {
        seniorBandService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
