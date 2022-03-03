package uk.co.zenitech.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.co.zenitech.core.model.Nanny;

public interface NannyRepository extends JpaRepository<Nanny, Long> {
}
