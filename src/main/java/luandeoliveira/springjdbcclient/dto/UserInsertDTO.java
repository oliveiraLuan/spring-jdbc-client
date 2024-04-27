package luandeoliveira.springjdbcclient.dto;

import luandeoliveira.springjdbcclient.entities.User;

public class UserInsertDTO extends UserDTO{
    private String password;

    public UserInsertDTO(){

    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
