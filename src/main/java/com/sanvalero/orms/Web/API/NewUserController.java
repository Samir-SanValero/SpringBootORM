package com.sanvalero.orms.Web.API;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

import com.sanvalero.orms.Repositories.Entities.NewUser;
import com.sanvalero.orms.Repositories.Entities.NewUserV2;

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
    private ArrayList<NewUserV2> usersV2 = new ArrayList<NewUserV2>(Arrays.asList(
        new NewUserV2(1, "name a", "en-US"),
        new NewUserV2(2, "name d", "en-ES"),
        new NewUserV2(3, "name c", null),
        new NewUserV2(4, "name d", "a")
    ));

    @GetMapping(value = "/v1")
    private ArrayList<NewUser> getAllUser() {
        // insertUsers();
        ArrayList<NewUser> users = new ArrayList<>();

        for (NewUserV2 user : usersV2) {
            users.add(new NewUser(user.getId(), user.getName()));
        }

        return users;
    }

    @GetMapping(value = "/v2")
    private ArrayList<NewUserV2> getAllUserV2() {
        return usersV2;
    }

    @GetMapping(value = "/{id}")
    private NewUser getUserById(@PathVariable("id") int id) {
        insertUsers();

        return findUserById(id);
    }

    @GetMapping(value = "/lang") 
    private String changeLang(Locale locale) {
        var messages = ResourceBundle.getBundle("i18n\\messages", locale);

        return messages.getString("Main.Hello");
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
