package xyz.k4czp3r.worktimes.service;

import xyz.k4czp3r.worktimes.domain.User;
import xyz.k4czp3r.worktimes.model.CreateUserModel;

import java.util.UUID;

public interface AuthService {
    User createUser(CreateUserModel createUserModel);
    User getUser(UUID secretKey);
}
