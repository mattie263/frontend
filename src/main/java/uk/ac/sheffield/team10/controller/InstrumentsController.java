package uk.ac.sheffield.team10.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import uk.ac.sheffield.team10.model.Instruments;
import uk.ac.sheffield.team10.service.InstrumentsService;

@RestController
@RequestMapping("/api/instruments")
public class InstrumentsController {

    private final InstrumentsService instrumentService;

    public InstrumentsController(InstrumentsService instrumentService) {
        this.instrumentService = instrumentService;
    }

    @GetMapping
    public List<Instruments> getAll() {
        return instrumentService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instruments> getById(@PathVariable Long id) {
        Optional<Instruments> instrument = instrumentService.getById(id);
        return instrument.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Instruments> create(@RequestBody Instruments instrument) {
        Instruments savedInstrument = instrumentService.save(instrument);
        return new ResponseEntity<>(savedInstrument, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instruments> update(@PathVariable Long id, @RequestBody Instruments updatedInstrument) {
        try {
            Instruments savedInstrument = instrumentService.update(id, updatedInstrument);
            return ResponseEntity.ok(savedInstrument);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Instrument not found -> id=" + id, e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        instrumentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

