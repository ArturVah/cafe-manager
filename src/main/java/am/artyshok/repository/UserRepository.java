package am.artyshok.repository;

import am.artyshok.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity getByEmail(String email);
}
