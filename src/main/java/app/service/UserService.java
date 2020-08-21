package app.service;

import app.model.User;
import app.service.value.UpdateUserValue;

import java.util.List;

public interface UserService {

    List<User> findAllUser();

    User findUserById(long id);

    boolean changeUserPasswordAndEmail(Long id, UpdateUserValue updateUserValue);
}
