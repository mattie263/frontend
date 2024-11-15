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
import org.springframework.web.server.ResponseStatusException;
import uk.ac.sheffield.team10.model.BandMembership;
import uk.ac.sheffield.team10.service.AdultMemberService;
import uk.ac.sheffield.team10.service.BandMembershipService;
import uk.ac.sheffield.team10.service.SeniorBandService;
import uk.ac.sheffield.team10.service.TrainingBandService;

@RestController
@RequestMapping("/api/band-membership")
public class BandMembershipController {
    private final BandMembershipService bandMembershipService;
    private final AdultMemberService adultMemberService;
    private final SeniorBandService seniorBandService;
    private final TrainingBandService trainingBandService;

    public BandMembershipController(
        BandMembershipService bandMembershipService,
        AdultMemberService adultMemberService,
        SeniorBandService seniorBandService,
        TrainingBandService trainingBandService) {

        this.bandMembershipService = bandMembershipService;
        this.adultMemberService = adultMemberService;
        this.seniorBandService = seniorBandService;
        this.trainingBandService = trainingBandService;
    }

    @GetMapping
    public List<BandMembership> getAll() {
        return bandMembershipService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BandMembership> getById(Long id) {
        Optional<BandMembership> bandMembership = bandMembershipService.getById(id);
        return bandMembership.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BandMembership> create(@RequestBody BandMembership bandMembership) {
        adultMemberService.findById(bandMembership.getMemberId())
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Adult account not found -> id=" + bandMembership.getMemberId()));

        Long seniorId = bandMembership.getSeniorBandId();
        Long trainingId = bandMembership.getTrainingBandId();

        if (seniorId != null) {
            seniorBandService.findById(seniorId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Senior Band not found -> id=" + seniorId));
        }

        if (trainingId != null) {
            trainingBandService.findById(trainingId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Training Band not found -> id=" + trainingId));
        }
        BandMembership savedBandMembership = bandMembershipService.save(bandMembership);
        return new ResponseEntity<>(savedBandMembership, HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<BandMembership> update(@PathVariable Long id, @RequestBody BandMembership updatedBandMembership) {
        try {
            Long seniorId = updatedBandMembership.getSeniorBandId();
            Long trainingId = updatedBandMembership.getTrainingBandId();

            if (seniorId != null) {
                seniorBandService.findById(seniorId)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Senior Band not found -> id=" + seniorId));
            }

            if (trainingId != null) {
                trainingBandService.findById(trainingId)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Training Band not found -> id=" + trainingId));
            }
            BandMembership savedBandMembership = bandMembershipService.update(id, updatedBandMembership);
            return ResponseEntity.ok(savedBandMembership);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BandMembership> delete(@PathVariable Long id) {
        bandMembershipService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
