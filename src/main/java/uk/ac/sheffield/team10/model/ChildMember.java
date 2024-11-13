package uk.ac.sheffield.team10.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "ChildMember")
public class ChildMember extends Member {

    @JoinColumn(name = "parentID", nullable = false)
    private Long parentId;

    public ChildMember() {}

    public ChildMember(Long memberId, String firstName, String lastName, Long parentId) {
        super(memberId, firstName, lastName);
        this.parentId = parentId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
