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
import uk.ac.sheffield.team10.model.ChildMember;
import uk.ac.sheffield.team10.service.AdultMemberService;
import uk.ac.sheffield.team10.service.ChildMemberService;

@RestController
@RequestMapping("/api/child-member")
public class ChildMemberController {
    private final ChildMemberService childMemberService;
    private final AdultMemberService adultMemberService;

    public ChildMemberController(ChildMemberService childMemberService, AdultMemberService adultMemberService) {
        this.childMemberService = childMemberService;
        this.adultMemberService = adultMemberService;
    }

    @GetMapping
    public List<ChildMember> getAllChildMembers() {
        return childMemberService.getAllChildMembers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChildMember> getChildMemberById(Long id) {
        Optional<ChildMember> childMember = childMemberService.getChildMemberById(id);
        return childMember.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ChildMember> createChildMember(@RequestBody ChildMember childMember) {
        Long parentId = childMember.getParentId();

        adultMemberService.findAdultMemberById(parentId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Parent not found -> id=" + parentId));
        ChildMember savedChildMember = childMemberService.saveChildMember(childMember);
        return new ResponseEntity<>(savedChildMember, HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<ChildMember> updateChildMember(@PathVariable Long id, @RequestBody ChildMember updatedChildMember) {
        try {
            Long parentId = updatedChildMember.getParentId();
            adultMemberService.findAdultMemberById(parentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Parent not found -> id=" + parentId));

            ChildMember savedChildMember = childMemberService.updateChildMember(id, updatedChildMember);
            return ResponseEntity.ok(savedChildMember);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ChildMember> deleteChildMember(@PathVariable Long id) {
        childMemberService.deleteChildMember(id);
        return ResponseEntity.noContent().build();
    }
}
