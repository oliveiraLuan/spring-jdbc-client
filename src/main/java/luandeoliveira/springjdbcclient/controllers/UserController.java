package luandeoliveira.springjdbcclient.controllers;

import luandeoliveira.springjdbcclient.dto.UserDTO;
import luandeoliveira.springjdbcclient.entities.User;
import luandeoliveira.springjdbcclient.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<UserDTO> users = userService.findAll();
        return ResponseEntity.ok(users);
    }
}
