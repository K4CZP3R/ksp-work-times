package xyz.k4czp3r.worktimes.repository;

import org.springframework.data.repository.CrudRepository;
import xyz.k4czp3r.worktimes.domain.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {
    Optional<User> findById(UUID id);
    Optional<User> findBySecretKey(UUID secretKey);
}
