package app.facade;

import app.facade.dto.UserDto;
import app.model.User;
import app.service.UserService;
import app.service.value.UpdateUserValue;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRestApiFacadeImpl implements UserRestApiFacade {
    private final UserService userService;

    public UserRestApiFacadeImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<UserDto> findAll() {
        List<UserDto> $userDtoList = new ArrayList<>();
        List<User> allUser = userService.findAllUser();
        for (User user : allUser) {
            UserDto $userDto = new UserDto();
            $userDto.setId(user.getId());
            $userDto.setEmail(user.getEmail());
            $userDtoList.add($userDto);
        }
        return $userDtoList;
    }

    @Override
    public void updateUser(Long id, String email, String password) {
        UpdateUserValue updateValue = new UpdateUserValue(email, password);
        userService.changeUserPasswordAndEmail(id, updateValue);
    }
}
