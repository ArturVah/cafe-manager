package am.artyshok.repository;

import am.artyshok.entity.OrderProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductsInOrderRepository extends CrudRepository<OrderProductEntity, Long> {
    OrderProductEntity getById(Long id);
}
