package pl.javastart.equipy.Mapper;

import pl.javastart.equipy.DTO.UserDTO;
import pl.javastart.equipy.domain.User;

public class UserMapper {


    public static User toUserDto(UserDTO userDTO){
        User user = new User();
        user.setId(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPesel(userDTO.getPesel());
        return user;
    }

    public static  UserDTO toUser(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setPesel(user.getPesel());
        return userDTO;
    }


}
