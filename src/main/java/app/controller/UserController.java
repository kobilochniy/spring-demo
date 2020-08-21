package app.controller;

import app.controller.dto.UpdateUserRequest;
import app.facade.UserRestApiFacade;
import app.facade.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserRestApiFacade userRestApiFacade;

    public UserController(UserRestApiFacade userRestApiFacade) {
        this.userRestApiFacade = userRestApiFacade;
    }

    @GetMapping
    public List<UserDto> findAll() {
        return userRestApiFacade.findAll();
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id,
                       @RequestBody UpdateUserRequest updateUserRequest) {
        userRestApiFacade.updateUser(id, updateUserRequest.getEmail(), updateUserRequest.getPassword());
    }
}
