package lk.ijse.aad.service.impl;

import lk.ijse.aad.dto.UserDTO;
import lk.ijse.aad.entity.User;
import lk.ijse.aad.enums.UserStatus;
import lk.ijse.aad.repository.UserRepository;
import lk.ijse.aad.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
//        log.info("Execute saveUser");
//        User user = new User();
//        user.setFirstName("IJSE");
//        user.setLastName("Institute");
//        user.setDob(new Date());
//        user.setStatus(UserStatus.ACTIVE);
//
//        User saveUser = userRepository.save(user);
//
//        UserDTO userDTO = new UserDTO();
//        userDTO.setId(saveUser.getId());
//        userDTO.setFirstName(saveUser.getFirstName());
//        userDTO.setLastName(saveUser.getLastName());
//        userDTO.setDob(saveUser.getDob());
//        userDTO.setStatus(saveUser.getStatus());
//
//        log.info("User saved!!!");
//        return userDTO;

        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setDob(userDTO.getDob());
        user.setStatus(userDTO.getStatus());

        User savedUser = userRepository.save(user);

        UserDTO savedUserDTO = new UserDTO();
        savedUserDTO.setId(savedUser.getId());
        savedUserDTO.setFirstName(savedUser.getFirstName());
        savedUserDTO.setLastName(savedUser.getLastName());
        savedUserDTO.setDob(savedUser.getDob());
        savedUserDTO.setStatus(savedUser.getStatus());
        return savedUserDTO;
    }

    @Override
    public List<UserDTO> getUsers() {
        log.info("Execute getUsers");

        try{
            List<UserDTO> responseList = new ArrayList<>();
            List<User> users = userRepository.findAll();
            for (User user : users) {
                UserDTO userDTO = new UserDTO();
                userDTO.setId(user.getId());
                userDTO.setFirstName(user.getFirstName());
                userDTO.setLastName(user.getLastName());
                userDTO.setDob(user.getDob());
                userDTO.setStatus(user.getStatus());

                responseList.add(userDTO);
            }
            return responseList;
        } catch (Exception e) {
            log.error("Error in getUsers!!!" + e.getMessage());
            throw e; // if not success, break the method and throw the error
        }
    }

    @Override
    public UserDTO getUserById(Long id) {
        log.info("Execute getUserById for ID: " + id);

        try{
            User user = userRepository.findById(id).
                    orElseThrow(() -> new RuntimeException("User not found with id: " + id));

            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setFirstName(user.getFirstName());
            userDTO.setLastName(user.getLastName());
            userDTO.setDob(user.getDob());
            userDTO.setStatus(user.getStatus());

            return userDTO;
        } catch (Exception e) {
            log.error("Error in getUserById!!!" + e.getMessage());
            throw e;
        }
    }
}
