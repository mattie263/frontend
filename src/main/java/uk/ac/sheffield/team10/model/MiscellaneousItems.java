package uk.ac.sheffield.team10.model;

import jakarta.persistence.*;


@Entity
@Table(name = "MiscellaneousItems")
public class MiscellaneousItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long miscellaneousID;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "itemType", nullable = false)
    private String itemType;

    @Column(name = "instrumentType", nullable = false)
    private String instrumentType;

    @Column(name = "make")
    private String make;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    public MiscellaneousItems() {
    }

    public MiscellaneousItems(Long miscellaneousID, String name, String itemType, String instrumentType, String make, int quantity ) {
        this.miscellaneousID = miscellaneousID;
        this.itemType = itemType;
        this.instrumentType = instrumentType;
        this.make = make;
        this.quantity = quantity;
        this.name = name;
    }

    public Long getMiscellaneousID() {
        return miscellaneousID;
    }

    public void setMiscellaneousID(Long miscellaneousID) {
        this.miscellaneousID = miscellaneousID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getInstrumentType() {
        return instrumentType;
    }

    public void setInstrumentType(String instrumentType) {
        this.instrumentType = instrumentType;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
