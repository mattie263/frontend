package uk.ac.sheffield.team10.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MusicSet")
public class MusicSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long musicSetId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "composer", nullable = false)
    private String composer;

    @Column(name = "arranger", nullable = false)
    private String arranger;

    @Column(name = "forTrainingBand", nullable = false)
    private boolean forTrainingBand;

    public MusicSet() {}

    public MusicSet(
        Long musicSetId,
        String title,
        String composer,
        String arranger,
        boolean forTrainingBand) {

        this.musicSetId = musicSetId;
        this.title = title;
        this.composer = composer;
        this.arranger = arranger;
        this.forTrainingBand = forTrainingBand;
    }

    public Long getMusicSetId() {
        return musicSetId;
    }

    public void setMusicSetId(Long musicSetId) {
        this.musicSetId = musicSetId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public String getArranger() {
        return arranger;
    }

    public void setArranger(String arranger) {
        this.arranger = arranger;
    }

    public boolean isForTrainingBand() {
        return forTrainingBand;
    }

    public void setForTrainingBand(boolean forTrainingBand) {
        this.forTrainingBand = forTrainingBand;
    }
}
