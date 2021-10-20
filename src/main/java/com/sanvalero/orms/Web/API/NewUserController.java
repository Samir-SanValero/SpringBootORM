package com.sanvalero.orms.Web.API;

import java.util.ArrayList;

import com.sanvalero.orms.Repositories.Entities.NewUser;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class NewUserController {

    private ArrayList<NewUser> users = new ArrayList<NewUser>();

    @GetMapping()
    private ArrayList<NewUser> getAllUser() {
        insertUsers();

        return users;
    }

    @GetMapping(value = "/{id}")
    private NewUser getUserById(@PathVariable("id") int id) {
        insertUsers();

        return findUserById(id);
    }

    @PostMapping()
    private NewUser addUser(@RequestBody NewUser user) {
        users.add(user);

        return user;
    }

    @PutMapping(value = "/{id}")
    private ArrayList<NewUser> updateUser(@RequestBody NewUser updateUser, @PathVariable("id") int id) {
        insertUsers();

        NewUser userFound = findUserById(id);
        userFound.setName(updateUser.getName());

        return users;
    }

    @DeleteMapping(value = "/{id}")
    private NewUser deleteUser(@PathVariable("id") int id) {
        insertUsers();

        NewUser user = findUserById(id);
        users.remove(user);

        return user;
    }

    private void insertUsers() {
        for (int i = 0; i < 5; i++) {
            NewUser user = new NewUser();
            user.setId(i);
            user.setName("Name");

            users.add(user);
        }
    }

    private NewUser findUserById(int id) {
        for (NewUser user : users) {
            if (id == user.getId()) {
                return user;
            }
        }
        return null;
    }
    
}
