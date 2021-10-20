package com.sanvalero.orms.Web.API;
import java.util.ArrayList;

import com.sanvalero.orms.Repositories.Entities.NewPost;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("posts")
public class NewPostController {

    private ArrayList<NewPost> posts = new ArrayList<NewPost>();

    @GetMapping()
    private ArrayList<NewPost> getAllPost() {
        insertPosts();

        return posts;
    }

    @GetMapping(value = "/{id}")
    private NewPost getPostById(@PathVariable("id") int id) {
        insertPosts();

        return findPostById(id);
    }

    @PostMapping()
    private NewPost addPost(@RequestBody NewPost post) {
        posts.add(post);

        return post;
    }

    @PutMapping(value = "/{id}")
    private ArrayList<NewPost> updatePost(@RequestBody NewPost updatePost, @PathVariable("id") int id) {
        insertPosts();

        NewPost postFound = findPostById(id);
        postFound.setTitle(updatePost.getTitle());
        postFound.setDescription(updatePost.getDescription());

        return posts;
    }

    @DeleteMapping(value = "/{id}")
    private NewPost deletePost(@PathVariable("id") int id) {
        insertPosts();

        NewPost post = findPostById(id);
        posts.remove(post);

        return post;
    }

    private void insertPosts() {
        for (int i = 0; i < 5; i++) {
            NewPost post = new NewPost();

            post.setId(i);
            post.setTitle("Title");
            post.setDescription("Description");

            posts.add(post);
        }
    }

    private NewPost findPostById(int id) {
        for (NewPost post : posts) {
            if (id == post.getId()) {
                return post;
            }
        }
        return null;
    }
    
}
