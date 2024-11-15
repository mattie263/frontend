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
import uk.ac.sheffield.team10.model.MusicSet;
import uk.ac.sheffield.team10.service.AdultMemberService;
import uk.ac.sheffield.team10.service.MusicSetService;

@RestController
@RequestMapping("/api/music-set")
public class MusicSetController {
    private final MusicSetService musicSetService;

    public MusicSetController(MusicSetService musicSetService) {
        this.musicSetService = musicSetService;
    }

    @GetMapping
    public List<MusicSet> getAll() {
        return musicSetService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MusicSet> findById(Long id) {
        Optional<MusicSet> musicSet = musicSetService.findById(id);
        return musicSet.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MusicSet > create(@RequestBody MusicSet musicSet) {
        MusicSet savedMusicSet = musicSetService.save(musicSet);
        return new ResponseEntity<>(savedMusicSet, HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<MusicSet> update(@PathVariable Long id, @RequestBody MusicSet updatedMusicSet) {
        try {
            MusicSet savedMusicSet = musicSetService.update(id, updatedMusicSet);
            return ResponseEntity.ok(savedMusicSet);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MusicSet> delete(@PathVariable Long id) {
        musicSetService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
