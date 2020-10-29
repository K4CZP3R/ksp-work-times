package xyz.k4czp3r.worktimes.controller;

import org.springframework.web.bind.annotation.*;
import xyz.k4czp3r.worktimes.domain.User;
import xyz.k4czp3r.worktimes.domain.WorkMoment;
import xyz.k4czp3r.worktimes.model.CreateUserModel;
import xyz.k4czp3r.worktimes.model.WorkMomentModel;
import xyz.k4czp3r.worktimes.service.WorkMomentService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/work_moment")
public class WorkMomentController {
    private final WorkMomentService workMomentService;

    public WorkMomentController(WorkMomentService workMomentService)
    {
        this.workMomentService = workMomentService;
    }

    @PostMapping("")
    public @ResponseBody
    WorkMoment create(@RequestHeader(value = "secret_key") UUID secretKey , @RequestBody WorkMomentModel workMomentModel)
    {
        workMomentModel.checkItself();
        return workMomentService.createWorkMoment(secretKey,workMomentModel);
    }

    @GetMapping("")
    public @ResponseBody
    List<WorkMoment> getAll(@RequestHeader(value = "secret_key") UUID secretKey)
    {
        return workMomentService.getAllWorkMoments(secretKey);
    }
}
