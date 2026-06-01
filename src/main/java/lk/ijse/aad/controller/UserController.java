package lk.ijse.aad.controller;

import lk.ijse.aad.dto.UserDTO;
import lk.ijse.aad.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)// In industry level there has to be only one PostMapping (save)
    public UserDTO saveUser(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> getUsers(){
        return userService.getUsers();
    }

    // homework on get department by id
    @GetMapping(value = "/userId", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO getUserById(@RequestParam("id") Long id){
        return userService.getUserById(id);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO updateUser(@RequestBody UserDTO userDTO){
        return userService.updateUser(userDTO);
    }

    @PatchMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String updateUserStatus(@RequestBody UserDTO userDTO){
        userService.updateUserStatus(userDTO);
        return "User status updated successfully";
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "User deleted successfully";
    }
}
