package app.service.impl;

import app.model.User;
import app.repository.UserRepository;
import app.service.UserService;
import app.service.value.UpdateUserValue;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("USER_NOT_FOUND"));
    }

    @Override
    public boolean changeUserPasswordAndEmail(Long id, UpdateUserValue updateUserValue) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("USER_NOT_FOUND"));
        user.setPassword(updateUserValue.getPassword());
        user.setEmail(updateUserValue.getEmail());
        return true;
    }
}
