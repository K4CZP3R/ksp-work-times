package xyz.k4czp3r.worktimes.service;

import xyz.k4czp3r.worktimes.domain.WorkMoment;
import xyz.k4czp3r.worktimes.domain.WorkSummary;
import xyz.k4czp3r.worktimes.model.WorkMomentModel;


import java.util.List;
import java.util.UUID;

public interface WorkMomentService {
    WorkMoment createWorkMoment(UUID secretKey, WorkMomentModel workMomentModel);
    List<WorkMoment> getAllWorkMoments(UUID secretKey);
    WorkSummary getWorkSummaryForWorkType(UUID secretKey, String workType);
}
