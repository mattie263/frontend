package uk.ac.sheffield.team10.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Instruments")
public class Instruments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long instrumentID;

    @Column(name = "serialNumber", nullable = false)
    private Long serialNumber;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "make", nullable = false)
    private String make;

    @Column(name = "onLoan", nullable = false)
    private boolean onLoan;

    @Column (name = "note")
    private String note;

    public Instruments() {}

    public Instruments(Long serialNumber, String type, String make, boolean onLoan, String note) {
        this.serialNumber = serialNumber;
        this.type = type;
        this.make = make;
        this.onLoan = onLoan;
        this.note = note;
    }

    // Getters and Setters
    public Long getInstrumentID() {
        return instrumentID;
    }

    public void setInstrumentID(Long instrumentID) {
        this.instrumentID = instrumentID;
    }

    public Long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public boolean getOnLoan() {
        return onLoan;
    }

    public void setOnLoan(boolean onLoan) {
        this.onLoan = onLoan;
    }
}
