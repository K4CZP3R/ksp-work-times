package xyz.k4czp3r.worktimes.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "work_moments")
public class WorkMoment {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, unique = true, length = 36)
    @Type(type = "uuid-char")
    private UUID id;
    private long startTime;
    private long endTime;
    private int breakTime;
    private String workType;
    private String workDescription;

    @Type(type = "uuid-char")
    private UUID userId;
}
