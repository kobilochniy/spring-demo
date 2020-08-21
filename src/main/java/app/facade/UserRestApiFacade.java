package app.facade;

import app.facade.dto.UserDto;

import java.util.List;

public interface UserRestApiFacade {

    List<UserDto> findAll();

    void updateUser(Long id, String email, String password);
}
