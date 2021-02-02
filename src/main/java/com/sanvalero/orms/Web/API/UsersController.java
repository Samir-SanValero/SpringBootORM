package com.sanvalero.orms.Web.API;

import java.util.List;

import com.sanvalero.orms.Services.UsersServices;
import com.sanvalero.orms.Services.Models.PostDTO;
import com.sanvalero.orms.Services.Models.UserDTO;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users/v1")
public class UsersController {
    private final UsersServices usersService;


    UsersController(UsersServices usersService) {
        this.usersService = usersService;
    }

    @GetMapping()
    public List<UserDTO> GetUsers() {
        return usersService.getAll();
    }

    @PostMapping()
    public UserDTO addUser(@RequestBody UserDTO user) {
        return usersService.add(user);
    }

    @PutMapping("/{id}")
    public UserDTO updateUser(@RequestBody UserDTO user, @PathVariable("id") Long id) {
        return usersService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public void DeleteUser(@PathVariable("id") Long id) {
        usersService.delete(id);
    }
}
