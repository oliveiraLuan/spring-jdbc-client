package luandeoliveira.springjdbcclient.services;

import luandeoliveira.springjdbcclient.dto.UserDTO;
import luandeoliveira.springjdbcclient.entities.Authority;
import luandeoliveira.springjdbcclient.entities.User;
import luandeoliveira.springjdbcclient.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> findAll(){
        List<User> users = userRepository.findAll();
        List<Authority> authorities = new ArrayList<>();
        return users.stream().map(user -> new UserDTO(user, authorities)).collect(Collectors.toList());
    }

}
