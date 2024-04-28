package luandeoliveira.springjdbcclient.services;

import luandeoliveira.springjdbcclient.dto.UserAuthorityDTO;
import luandeoliveira.springjdbcclient.dto.UserDTO;
import luandeoliveira.springjdbcclient.dto.UserInsertDTO;
import luandeoliveira.springjdbcclient.entities.Authority;
import luandeoliveira.springjdbcclient.entities.User;
import luandeoliveira.springjdbcclient.entities.UserAuthority;
import luandeoliveira.springjdbcclient.repositories.UserRepository;
import luandeoliveira.springjdbcclient.services.exceptions.UserNotFoundException;
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
        return users.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
    }


    public List<UserAuthorityDTO> findAllUsersAuthorities() {
        List<UserAuthority> users = userRepository.findAllUsersAuthority();
        return users.stream().map(user -> new UserAuthorityDTO(user)).collect(Collectors.toList());
    }

    public UserDTO findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return new UserDTO(user);
    }

    public void insert(UserInsertDTO insertDTO){
        userRepository.insert(insertDTO);
    }

    public void deleteByUsername(String username) {
        Integer response = userRepository.deleteByUsername(username);
        if(response == 0){
            throw new UserNotFoundException("Usuário não encontrado.");
        }
    }

    public void update(UserInsertDTO updateDTO) {
        User user = new User(updateDTO.getUsername(), updateDTO.getPassword(), updateDTO.getEnabled());
        userRepository.update(user);
    }
}
