package xyz.k4czp3r.worktimes.repository;

import org.springframework.data.repository.CrudRepository;
import xyz.k4czp3r.worktimes.domain.WorkMoment;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WorkMomentRepository  extends CrudRepository<WorkMoment, UUID> {
    Optional<WorkMoment> findById(UUID id);
    List<WorkMoment> findByUserId(UUID userId);

}
