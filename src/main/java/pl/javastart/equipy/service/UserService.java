package pl.javastart.equipy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.javastart.equipy.DTO.UserDTO;
import pl.javastart.equipy.Mapper.UserMapper;
import pl.javastart.equipy.domain.User;
import pl.javastart.equipy.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    private UserMapper userMapper;


    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(UserMapper::toUser).collect(Collectors.toList());
    }

    public List<UserDTO> findByName(String lastName) {
        return userRepository.findAllByLastNameContainingIgnoreCase(lastName).stream().map(UserMapper::toUser).collect(Collectors.toList());

    }

    public UserDTO save(UserDTO userDTO) {
        User userByPesel = userRepository.findByPesel(userDTO.getPesel());
        User user = userRepository.save(UserMapper.toUserDto(userDTO));
        return UserMapper.toUser(user);
    }

    public UserDTO findById(Long id) {
        return userRepository.findById(id).stream().map(UserMapper::toUser).findFirst().get();
    }


    public UserDTO saveChaneUser(UserDTO userDTO) {
        User user = userRepository.findById(userDTO.getId()).get();
        User user1 = userRepository.save(UserMapper.toUserDto(userDTO));
        return UserMapper.toUser(user1);
    }
}
