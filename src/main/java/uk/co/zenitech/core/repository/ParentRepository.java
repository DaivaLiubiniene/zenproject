package uk.co.zenitech.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.co.zenitech.core.model.Parent;

public interface ParentRepository extends JpaRepository<Parent, Long> {
}
