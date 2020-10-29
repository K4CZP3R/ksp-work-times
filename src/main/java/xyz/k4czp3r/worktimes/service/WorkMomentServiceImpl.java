package xyz.k4czp3r.worktimes.service;

import org.springframework.stereotype.Service;
import xyz.k4czp3r.worktimes.domain.User;
import xyz.k4czp3r.worktimes.domain.WorkMoment;
import xyz.k4czp3r.worktimes.domain.WorkSummary;
import xyz.k4czp3r.worktimes.exception.IllegalInputException;
import xyz.k4czp3r.worktimes.model.WorkMomentModel;
import xyz.k4czp3r.worktimes.repository.UserRepository;
import xyz.k4czp3r.worktimes.repository.WorkMomentRepository;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class WorkMomentServiceImpl implements WorkMomentService {
    private final WorkMomentRepository workMomentRepository;
    private final UserRepository userRepository;

    public WorkMomentServiceImpl(WorkMomentRepository workMomentRepository, UserRepository userRepository) {
        this.workMomentRepository = workMomentRepository;
        this.userRepository = userRepository;
    }

    private User getUserBySecretKey(UUID secretKey) {
        User user = userRepository.findBySecretKey(secretKey).orElse(null);
        if (user == null) {
            throw new IllegalInputException("Invalid secret key!");
        }
        return user;
    }


    @Override
    public WorkMoment createWorkMoment(UUID secretKey, WorkMomentModel workMomentModel)  {
        if(workMomentModel == null)
        {
            throw new IllegalInputException("Invalid input!");
        }

        User user = getUserBySecretKey(secretKey);
        WorkMoment.Builder workMomentBuilder;
        try {
            workMomentBuilder = new WorkMoment.Builder(
                    workMomentModel.getStartTime(),
                    workMomentModel.getEndTime(),
                    workMomentModel.getBreakTime(),
                    workMomentModel.getWorkType(),
                    user.getId()
            );
        } catch (ParseException exception) {

            throw new IllegalInputException(exception.getMessage());
        }
        if (workMomentModel.getWorkDescription() != null) {
            workMomentBuilder.setWorkDescription(workMomentModel.getWorkDescription());
        }
        return workMomentRepository.save(workMomentBuilder.build());


    }

    @Override
    public List<WorkMoment> getAllWorkMoments(UUID secretKey) {
        User user = getUserBySecretKey(secretKey);
        return workMomentRepository.findByUserId(user.getId());
    }

    @Override
    public WorkSummary getWorkSummaryForWorkType(UUID secretKey, String workType) {
        return null;
    }
}
