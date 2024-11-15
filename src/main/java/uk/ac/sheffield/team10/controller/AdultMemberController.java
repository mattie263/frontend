package uk.ac.sheffield.team10.controller;

import java.util.ArrayList;
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
import uk.ac.sheffield.team10.model.AdultMember;
import uk.ac.sheffield.team10.service.AdultMemberService;

@RestController
@RequestMapping("/api/adult-member")
public class AdultMemberController {
    private final AdultMemberService adultMemberService;

    public AdultMemberController(AdultMemberService adultMemberService) {
        this.adultMemberService = adultMemberService;
    }

    @GetMapping
    public List<AdultMember> getAllAdultMembers() {
        return adultMemberService.getAllAdultMembers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdultMember> findAdultMemberById(Long id) {
        Optional<AdultMember> adultMember = adultMemberService.findAdultMemberById(id);
        return adultMember.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AdultMember> createAdultMember(@RequestBody AdultMember adultMember) {
        AdultMember savedAdultMember = adultMemberService.saveAdultMember(adultMember);
        return new ResponseEntity<>(savedAdultMember, HttpStatus.CREATED);
    }


    //TODO remove later for bulk adding accounts.
    @PostMapping("/bulk")
    public ResponseEntity<List<AdultMember>> createMultipleAdultMembers(@RequestBody List<AdultMember> adultMembers) {
        List<AdultMember> savedAdultMembers = new ArrayList<>();

        for (AdultMember adultMember : adultMembers) {
            AdultMember savedAdultMember = adultMemberService.saveAdultMember(adultMember);
            savedAdultMembers.add(savedAdultMember);
        }

        return new ResponseEntity<>(savedAdultMembers, HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<AdultMember> updateAdultMember(@PathVariable Long id, @RequestBody AdultMember updatedAdultMember) {
        try {
            AdultMember savedAdultMember = adultMemberService.updateAdultMember(id, updatedAdultMember);
            return ResponseEntity.ok(savedAdultMember);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AdultMember> deleteAdultMember(@PathVariable Long id) {
        adultMemberService.deleteAdultMember(id);
        return ResponseEntity.noContent().build();
    }
}
