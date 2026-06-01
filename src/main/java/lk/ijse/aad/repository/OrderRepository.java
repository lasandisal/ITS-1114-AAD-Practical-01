package lk.ijse.aad.repository;

import lk.ijse.aad.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
