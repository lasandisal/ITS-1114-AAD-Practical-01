package lk.ijse.aad.service;

import lk.ijse.aad.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO saveUser(UserDTO userDTO);
    List<UserDTO> getUsers();
    UserDTO getUserById(Long id);
    UserDTO updateUser(UserDTO userDTO);
    void updateUserStatus(UserDTO userDTO);
    void deleteUser(Long id);
}
