package app.controller.dto;

import lombok.Data;

@Data
public class UpdateUserRequest {
    private String email;
    private String password;
}
