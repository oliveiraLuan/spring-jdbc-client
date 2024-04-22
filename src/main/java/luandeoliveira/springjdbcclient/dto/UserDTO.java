package luandeoliveira.springjdbcclient.dto;

import luandeoliveira.springjdbcclient.entities.Authority;
import luandeoliveira.springjdbcclient.entities.User;

import java.util.List;

public class UserDTO {

    private String username;
    private List<Authority> authorities;
    private Boolean enabled;

    public UserDTO(User user, List<Authority> authorities) {
        this.username = user.username();
        this.enabled = user.enabled();

        for(Authority authority : authorities){
            this.authorities.add(authority);
        }
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
