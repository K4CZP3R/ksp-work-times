package xyz.k4czp3r.worktimes.model;

import xyz.k4czp3r.worktimes.exception.IllegalInputException;

public class WorkMomentModel {
    private String startTime;
    private String endTime;
    private int breakTime;
    private String workType;
    private String workDescription;

    public int getBreakTime() {
        return breakTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getWorkDescription() {
        return workDescription;
    }

    public String getWorkType() {
        return workType;
    }

    public void checkItself() {
        if (startTime == null ||
                endTime == null ||
                workType == null
        )
        {
            throw new IllegalInputException("Model is not filled properly!");
        }
    }
}
