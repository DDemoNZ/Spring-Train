package spring;

public class UserResponseDto {

    private String username;

    public UserResponseDto() {
    }

    public UserResponseDto(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
