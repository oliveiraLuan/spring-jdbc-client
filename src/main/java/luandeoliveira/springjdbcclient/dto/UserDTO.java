package luandeoliveira.springjdbcclient.dto;

import luandeoliveira.springjdbcclient.entities.Authority;
import luandeoliveira.springjdbcclient.entities.User;

import java.io.Serializable;
import java.util.List;

public class UserDTO implements Serializable {

    private String username;
    private List<Authority> authorities;
    private Boolean enabled;

    public UserDTO(){

    }

    public UserDTO(User user) {
        this.username = user.username();
        this.enabled = user.enabled();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
