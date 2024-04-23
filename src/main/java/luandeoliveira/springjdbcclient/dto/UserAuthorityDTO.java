package luandeoliveira.springjdbcclient.dto;

import luandeoliveira.springjdbcclient.entities.UserAuthority;

import java.util.ArrayList;
import java.util.List;

public class UserAuthorityDTO {
    private String username;
    private Boolean enabled;
    private List<String> authorities = new ArrayList<>();

    public UserAuthorityDTO(){

    }

    public UserAuthorityDTO(UserAuthority user) {
        this.username = user.username();
        this.enabled = user.enabled();
        for(String authority : user.authorities()){
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

    public List<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }
}
