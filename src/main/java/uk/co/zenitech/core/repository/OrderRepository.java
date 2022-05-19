package uk.co.zenitech.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.co.zenitech.core.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
