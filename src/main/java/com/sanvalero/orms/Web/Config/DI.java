package com.sanvalero.orms.Web.Config;

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
    ModelMapper createModelMapper() {
        return new ModelMapper();
    }
}
