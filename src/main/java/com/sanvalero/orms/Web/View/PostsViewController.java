package com.sanvalero.orms.Web.View;

import com.sanvalero.orms.Services.PostsServices;
import com.sanvalero.orms.Services.Models.PostDTO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/posts/view")
@Controller
public class PostsViewController {
    private final PostsServices postsServices;

    PostsViewController(PostsServices postsServices) {
        this.postsServices = postsServices;
    }

    @GetMapping
    public ModelAndView PostV2() {
        ModelAndView mv = new ModelAndView("listPosts");
        mv.addObject("posts", postsServices.getAll());
        return mv;
    }

    @GetMapping("/new")
    public ModelAndView createPost() {
        ModelAndView mv = new ModelAndView("detailPosts");
        mv.addObject("post", new PostDTO());
        return mv;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editPost(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("detailPosts");
        var postOrEmpty = postsServices.findById(id);
        PostDTO post = new PostDTO();

        if (postOrEmpty.isPresent()) {
            post = postOrEmpty.get();
        }

        mv.addObject("post", post);
        return mv;
    }
}
