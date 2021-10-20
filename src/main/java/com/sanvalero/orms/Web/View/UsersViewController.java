package com.sanvalero.orms.Web.View;

import com.sanvalero.orms.Services.UsersServices;
import com.sanvalero.orms.Services.Models.UserDTO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/users/view")
@Controller
public class UsersViewController {
    private final UsersServices usersService;


    UsersViewController(UsersServices usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public ModelAndView UserV2() {
        ModelAndView mv = new ModelAndView("listUsers");
        mv.addObject("users", usersService.getAll());
        return mv;
    }

    @GetMapping("/new")
    public ModelAndView createUser() {
        ModelAndView mv = new ModelAndView("detailUsers");
        mv.addObject("user", new UserDTO());
        return mv;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editUser(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("detailUsers");
        var userOrEmpty = usersService.findById(id);
        UserDTO user = new UserDTO();

        if (userOrEmpty.isPresent()) {
            user = userOrEmpty.get();
        }

        mv.addObject("user", user);
        return mv;
    }
}
