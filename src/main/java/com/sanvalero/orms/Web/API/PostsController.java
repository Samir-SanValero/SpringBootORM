package com.sanvalero.orms.Web.API;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.sanvalero.orms.Services.PostsServices;
import com.sanvalero.orms.Services.Models.PostDTO;
import com.sanvalero.orms.Services.Models.UserDTO;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("post/v2")
public class PostsController {
    private final PostsServices postsServices;

    PostsController(PostsServices postsServices) {
        this.postsServices = postsServices;
    }

    @GetMapping(value = "/hi")
    public String hello() {
        return "post";
    }

    // @GetMapping()
    // public List<PostDTO> GetPosts(@RequestParam(name="userId", required = false, defaultValue = "0") Long userId) {

    //     List<PostDTO> result = null;

    //     if (userId != 0) {
    //         result = postsServices.findByUserId(userId);
    //     } else {
    //         result = postsServices.getAll();
    //     }

    //     return result;
    // }

    @GetMapping("/salary")
    public List<PostDTO> filterSalary(@RequestParam(name = "id", required = false, defaultValue = "0") Long salary) {
        return postsServices.filterSalary(salary);
    }

    @PostMapping()
    public PostDTO addPost(@RequestBody PostDTO post) {
        return postsServices.add(post);
    }

    @PutMapping("/{id}")
    public PostDTO updatePost(@RequestBody PostDTO post, @PathVariable("id") Long id) {
        return postsServices.update(id, post);
    }

    @DeleteMapping("/{id}")
    public void DeletePost(@PathVariable("id") Long id) {
        postsServices.delete(id);
    }
}
