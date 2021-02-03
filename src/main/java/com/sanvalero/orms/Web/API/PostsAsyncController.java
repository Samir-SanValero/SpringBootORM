package com.sanvalero.orms.Web.API;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.sanvalero.orms.Services.PostsAsyncServices;
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
@RequestMapping("posts/async/v1")
public class PostsAsyncController {
    private final PostsAsyncServices postsServices;

    PostsAsyncController(PostsAsyncServices postsServices) {
        this.postsServices = postsServices;
    }

    @GetMapping()
    public List<PostDTO> GetPosts(@RequestParam(name = "userId", required = false, defaultValue = "0") Long userId)
            throws InterruptedException, ExecutionException {

        List<PostDTO> result = null;

        if (userId != 0) {
            result = postsServices.findByUserId(userId).get();
        } else {
            result = postsServices.getAll().get();
        }

        return result;
    }

}
