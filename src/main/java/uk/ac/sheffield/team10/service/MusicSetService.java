package uk.ac.sheffield.team10.service;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import uk.ac.sheffield.team10.model.MusicSet;
import uk.ac.sheffield.team10.repository.MusicSetRepository;

@Service
public class MusicSetService {
    private final MusicSetRepository musicSetRepository;

    public MusicSetService(MusicSetRepository musicSetRepository) {
        this.musicSetRepository = musicSetRepository;
    }

    public List<MusicSet> getAll() {
        return musicSetRepository.findAll();
    }

    public Optional<MusicSet> findById(Long id) {
        return musicSetRepository.findById(id);
    }

    public MusicSet save(MusicSet musicSet) {
        return musicSetRepository.save(musicSet);
    }

    public MusicSet update(Long id, MusicSet updatedMusicSet) {
        Optional<MusicSet> musicSetOptional = musicSetRepository.findById(id);
        if (musicSetOptional.isPresent()) {
            MusicSet musicSet = musicSetOptional.get();
            musicSet.setTitle(updatedMusicSet.getTitle());
            musicSet.setComposer(updatedMusicSet.getComposer());
            musicSet.setArranger(updatedMusicSet.getArranger());
            musicSet.setForTrainingBand(updatedMusicSet.isForTrainingBand());
            return musicSetRepository.save(musicSet);
        } else {
            throw new RuntimeException("Music Set Not Found -> id=" + id);
        }
    }

    public void delete(Long id) {
        musicSetRepository.deleteById(id);
    }
}
