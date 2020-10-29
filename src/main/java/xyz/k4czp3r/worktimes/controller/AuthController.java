package xyz.k4czp3r.worktimes.controller;

import org.springframework.web.bind.annotation.*;
import xyz.k4czp3r.worktimes.domain.User;
import xyz.k4czp3r.worktimes.model.CreateUserModel;
import xyz.k4czp3r.worktimes.service.AuthService;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService)
    {
        this.authService = authService;
    }

    @PostMapping("")
    public @ResponseBody
    User create(@RequestBody CreateUserModel createUserModel)
    {
        return authService.createUser(createUserModel);
    }

    @GetMapping("")
    public @ResponseBody
    User get(@RequestHeader(value = "secret_key") UUID secretKey){
        return authService.getUser(secretKey);
    }
}
