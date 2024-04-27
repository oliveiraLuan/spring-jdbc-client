package luandeoliveira.springjdbcclient.controllers;

import luandeoliveira.springjdbcclient.dto.UserAuthorityDTO;
import luandeoliveira.springjdbcclient.dto.UserDTO;
import luandeoliveira.springjdbcclient.dto.UserInsertDTO;
import luandeoliveira.springjdbcclient.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<UserDTO> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users_authorities")
    public List<UserAuthorityDTO> findAllUsersAuthorities(){
        return userService.findAllUsersAuthorities();
    }

    @GetMapping(value = "/{username}")
    public UserDTO findByUsername(@PathVariable String username){
        UserDTO dto = userService.findByUsername(username);
        return dto;
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserInsertDTO insertDTO){
        userService.insert(insertDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/username")
                .buildAndExpand()
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{username}")
    public ResponseEntity<Void> delete(@PathVariable String username){
        userService.deleteByUsername(username);
        return ResponseEntity.noContent().build();
    }
}
