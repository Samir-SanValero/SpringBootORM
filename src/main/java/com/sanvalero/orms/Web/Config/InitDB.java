package com.sanvalero.orms.Web.Config;

import com.sanvalero.orms.Repositories.Entities.PostEntity;
import com.sanvalero.orms.Repositories.Entities.UserEntity;
import com.sanvalero.orms.Repositories.Interface.PostsRepository;
import com.sanvalero.orms.Repositories.Interface.UsersRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitDB {

    @Bean
    CommandLineRunner initDatabase(UsersRepository repository, PostsRepository postsRepository) {

        return args -> {
            repository.save(new UserEntity("User 1", 2000L));
            repository.save(new UserEntity("User 2", 1000L));

            for (Long i = 0L; i < 500.000; i++) {
                postsRepository.save(new PostEntity("title", "description", i));
            }
        };
    }

}
