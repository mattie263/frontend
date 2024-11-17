package uk.ac.sheffield.team10.service;


import org.springframework.stereotype.Service;
import uk.ac.sheffield.team10.model.MiscellaneousItems;
import uk.ac.sheffield.team10.repository.MiscellaneousItemsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MiscellaneousItemsService {
    private final MiscellaneousItemsRepository miscellaneousItemsRepository;

    public MiscellaneousItemsService(MiscellaneousItemsRepository miscellaneousItemsRepository) {
        this.miscellaneousItemsRepository = miscellaneousItemsRepository;
    }

    public List<MiscellaneousItems> getAll() {
        return miscellaneousItemsRepository.findAll();
    }

    public Optional<MiscellaneousItems> getById(Long id) {
        return miscellaneousItemsRepository.findById(id);
    }

    public MiscellaneousItems save(MiscellaneousItems miscellaneousItems) {
        return miscellaneousItemsRepository.save(miscellaneousItems);
    }

    public MiscellaneousItems update(Long id, MiscellaneousItems updatedMiscellaneousItems) {
        Optional<MiscellaneousItems> miscellaneousItemsOptional = miscellaneousItemsRepository.findById(id);
        if (miscellaneousItemsOptional.isPresent()) {
            MiscellaneousItems miscellaneousItems = miscellaneousItemsOptional.get();
            miscellaneousItems.setItemType(updatedMiscellaneousItems.getItemType());
            miscellaneousItems.setMiscellaneousID(updatedMiscellaneousItems.getMiscellaneousID());
            miscellaneousItems.setMake(updatedMiscellaneousItems.getMake());
            miscellaneousItems.setQuantity(updatedMiscellaneousItems.getQuantity());
            miscellaneousItems.setName(updatedMiscellaneousItems.getName());
            miscellaneousItems.setInstrumentType(updatedMiscellaneousItems.getInstrumentType());
            return miscellaneousItemsRepository.save(miscellaneousItems);
        } else {
            throw new RuntimeException("Miscellaneous Item not found  -> id=" + id);
        }
    }

    public void delete(Long id) {
        miscellaneousItemsRepository.deleteById(id);
    }
}



