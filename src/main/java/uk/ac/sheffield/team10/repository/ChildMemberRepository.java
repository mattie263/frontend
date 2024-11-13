package uk.ac.sheffield.team10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.ac.sheffield.team10.model.ChildMember;

public interface ChildMemberRepository extends JpaRepository<ChildMember, Long> {

}
