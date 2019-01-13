package am.artyshok.repository;

import am.artyshok.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderEntity, Long> {
    OrderEntity getById(Long id);
}
