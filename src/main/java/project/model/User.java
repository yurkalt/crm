package project.model;

import javax.persistence.*;

/**
 * Created by slava23 on 10/11/2016.
 */
@Entity
public class User {

    private static final String DEFAULT_PASSWORD = "123456";

    @Id
    private int id;

    private String username;

    private String password;

    private boolean enabled;

    public User() {
    }

    public User(int id, String username, String password, boolean enabled) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public User(int id, String username) {
        this(id, username, DEFAULT_PASSWORD, false);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
