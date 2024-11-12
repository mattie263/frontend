package uk.ac.sheffield.team10.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import uk.ac.sheffield.team10.model.AdultMember;

public interface AdultMemberRepository extends JpaRepository<AdultMember, Long> {
    Page<AdultMember> findAll(Pageable pageable);
}
