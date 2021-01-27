package com.sanvalero.orms.Web.API;

import java.util.List;

import com.sanvalero.orms.Services.PostsServices;
import com.sanvalero.orms.Services.Models.PostDTO;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("posts/v1")
public class PostsController {
    private final PostsServices postsServices;

    PostsController(PostsServices postsServices) {
        this.postsServices = postsServices;
    }

    @GetMapping()
    public List<PostDTO> GetUsers() {
        return postsServices.getAll();
    }

    @PostMapping()
    public PostDTO addUser(@RequestBody PostDTO post) {
        return postsServices.add(post);
    }

    @PutMapping("/{id}")
    public PostDTO updateUser(@RequestBody PostDTO post, @PathVariable("id") Long id) {
        return postsServices.update(id, post);
    }

    @DeleteMapping("/{id}")
    public void DeleteUser(@PathVariable("id") Long id) {
        postsServices.delete(id);
    }
}
