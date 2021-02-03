package com.sanvalero.orms.Web.Config;

import com.sanvalero.orms.Services.PostsAsyncServices;
import com.sanvalero.orms.Services.PostsServices;
import com.sanvalero.orms.Services.UsersServices;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DI {

    @Bean
    UsersServices createUserService() {
        return new UsersServices();
    }

    @Bean
    PostsServices createPostsService() {
        return new PostsServices();
    }

    @Bean
    PostsAsyncServices createPostsAsyncService() {
        return new PostsAsyncServices();
    }

    @Bean
    ModelMapper createModelMapper() {
        return new ModelMapper();
    }
}
