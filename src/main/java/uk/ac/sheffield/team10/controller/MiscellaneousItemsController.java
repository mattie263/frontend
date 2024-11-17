package uk.ac.sheffield.team10.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.ac.sheffield.team10.model.MiscellaneousItems;
import uk.ac.sheffield.team10.service.MiscellaneousItemsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/miscellaneous_items")
public class MiscellaneousItemsController {
    private final MiscellaneousItemsService miscellaneousItemsService;

    public MiscellaneousItemsController(MiscellaneousItemsService miscellaneousItemsService) {
        this.miscellaneousItemsService = miscellaneousItemsService;
    }

    @GetMapping
    public List<MiscellaneousItems> getAllMiscellaneousItems(){
        return miscellaneousItemsService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MiscellaneousItems> getMiscellaneousItems(@PathVariable Long id){
        Optional<MiscellaneousItems> miscellaneousItems = miscellaneousItemsService.getById(id);
        return  miscellaneousItems.map(ResponseEntity::ok).
                orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MiscellaneousItems> create(@RequestBody MiscellaneousItems miscellaneousItems) {
        MiscellaneousItems savedMiscellaneousItem = miscellaneousItemsService.save(miscellaneousItems);
        return new ResponseEntity<>(savedMiscellaneousItem, HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<MiscellaneousItems> updateMiscellaneousItems(
        @PathVariable Long id,
        @RequestBody MiscellaneousItems updatedMiscellaneousItem) {
        try{
            MiscellaneousItems savedMiscellaneousItem = miscellaneousItemsService.update(id, updatedMiscellaneousItem);
            return ResponseEntity.ok(savedMiscellaneousItem);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
        }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMiscellaneousItems(@PathVariable Long id) {
        miscellaneousItemsService.delete(id);
        return ResponseEntity.noContent().build();
    }


    }

