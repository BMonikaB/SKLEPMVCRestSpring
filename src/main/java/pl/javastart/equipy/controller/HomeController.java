package pl.javastart.equipy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.javastart.equipy.DTO.UserDTO;
import pl.javastart.equipy.service.UserService;

import java.util.List;

//@RestController
@RestController
@RequestMapping("/api/users")
public class HomeController {

    @Autowired
    UserService userService;


    @GetMapping("")
    public List<UserDTO> searchByName(@RequestParam(required = false) String lastName) {
        if (lastName == null) {
            return userService.findAll();
        } else return userService.findByName(lastName);
    }


    @PostMapping("")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO)  {

        if(userDTO.getPesel()==null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Zapisywany obiekt nie może mieć ustawionego id");
        }

        userService.save(userDTO);
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable Long id){
        return userService.findById(id);
    }

    @PutMapping("/{id}")
    public UserDTO saveChangeUser(@RequestBody UserDTO userDTO){
        return userService.saveChaneUser(userDTO);
    }




}
