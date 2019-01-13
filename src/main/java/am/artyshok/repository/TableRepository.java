package am.artyshok.repository;

import am.artyshok.entity.TableEntity;
import am.artyshok.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TableRepository extends CrudRepository<TableEntity, Long> {
    TableEntity getById(Long id);

    List<TableEntity> getByWaiter(UserEntity waiter);
}
