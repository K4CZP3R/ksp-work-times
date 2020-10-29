package xyz.k4czp3r.worktimes.domain;

import java.util.List;

public class WorkSummary {

    private final List<WorkMoment> workMomentsList;
    public WorkSummary(List<WorkMoment> workMoments)
    {
         this.workMomentsList = workMoments;
    }


}
