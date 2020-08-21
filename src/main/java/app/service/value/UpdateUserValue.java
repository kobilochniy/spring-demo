package app.service.value;

public class UpdateUserValue {

    private final String email;
    private final String password;

    public UpdateUserValue(final String email, final String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }
}
