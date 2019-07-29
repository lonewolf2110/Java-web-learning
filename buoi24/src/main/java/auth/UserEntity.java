package auth;

public class UserEntity {
    private int id;
    private String username, password, email, fullName, address;

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public UserEntity(int id, String username, String password, String email, String fullName, String address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.address = address;
    }
}
