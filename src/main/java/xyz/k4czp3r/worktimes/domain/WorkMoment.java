package xyz.k4czp3r.worktimes.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import xyz.k4czp3r.worktimes.utils.TimeHelper;

import javax.persistence.*;
import java.text.ParseException;
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

    public String getWorkType() {
        return workType;
    }

    public String getWorkDescription() {
        return workDescription;
    }

    public int getBreakTime() {
        return breakTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public long getStartTime() {
        return startTime;
    }


    public static class Builder {
        private final long startTime;
        private final long endTime;
        private final int breakTime;
        private final String workType;
        private String workDescription;
        private final UUID userId;

        public Builder(
                String startTime,
                String endTime,
                int breakTime,
                String workType,
                UUID userId
        ) throws ParseException {
            this.startTime = TimeHelper.convertToUnix(startTime);
            this.endTime = TimeHelper.convertToUnix(endTime);
            this.breakTime = breakTime;
            this.workType = workType;
            this.userId = userId;
        }

        public Builder setWorkDescription(String description)
        {
            this.workDescription = description;
            return this;
        }

        public WorkMoment build()
        {
            WorkMoment workMoment = new WorkMoment();
            workMoment.breakTime = breakTime;
            workMoment.endTime= endTime;
            workMoment.startTime = startTime;
            workMoment.userId = userId;
            workMoment.workType = workType;
            workMoment.workDescription = workDescription;
            return workMoment;
        }


    }
}
