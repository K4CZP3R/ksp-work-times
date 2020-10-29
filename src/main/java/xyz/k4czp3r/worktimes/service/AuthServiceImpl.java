package xyz.k4czp3r.worktimes.service;

import org.springframework.stereotype.Service;
import xyz.k4czp3r.worktimes.domain.User;
import xyz.k4czp3r.worktimes.exception.IllegalInputException;
import xyz.k4czp3r.worktimes.model.CreateUserModel;
import xyz.k4czp3r.worktimes.repository.UserRepository;

import java.util.UUID;

@Service
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(CreateUserModel createUserModel) {
        User user = new User.Builder(createUserModel.getUsername()).build();
        return userRepository.save(user);
    }

    @Override
    public User getUser(UUID secretKey) {
        User foundUser = userRepository.findBySecretKey(secretKey).orElse(null);
        if(foundUser == null)
        {
            throw new IllegalInputException("Can't find user using this id!");
        }
        return foundUser;
    }
}
