package uk.ac.sheffield.team10.service;

import org.springframework.stereotype.Service;
import uk.ac.sheffield.team10.model.Instruments;
import uk.ac.sheffield.team10.repository.InstrumentsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InstrumentsService {

    private final InstrumentsRepository instrumentsRepository;

    public InstrumentsService(InstrumentsRepository instrumentsRepository) {
        this.instrumentsRepository = instrumentsRepository;
    }

    public List<Instruments> getAll() {
        return instrumentsRepository.findAll();
    }

    public Optional<Instruments> getById(Long serialNumber) {
        return instrumentsRepository.findById(serialNumber);
    }

    public Instruments save(Instruments instrument) {
        return instrumentsRepository.save(instrument);
    }

    public Instruments update(Long serialNumber, Instruments updatedInstruments) {
        Optional<Instruments> instrumentsOptional = instrumentsRepository.findById(serialNumber);
        if (instrumentsOptional.isPresent()) {
            Instruments instrument = instrumentsOptional.get();
            instrument.setInstrumentID(updatedInstruments.getInstrumentID());
            instrument.setMake(updatedInstruments.getMake());
            instrument.setOnLoan(updatedInstruments.getOnLoan());
            return instrumentsRepository.save(instrument);
        } else {
            throw new RuntimeException("Instrument not found -> serial number=" + serialNumber);
        }
    }

    public void delete(Long serialNumber) {
        if (!instrumentsRepository.existsById(serialNumber)) {
            throw new RuntimeException("Instrument not found -> id=" + serialNumber);
        }
        instrumentsRepository.deleteById(serialNumber);
    }
}
