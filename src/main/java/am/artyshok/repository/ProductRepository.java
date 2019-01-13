package am.artyshok.repository;

import am.artyshok.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
    ProductEntity getById(Long id);
}
