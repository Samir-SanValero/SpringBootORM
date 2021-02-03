package com.sanvalero.orms.Services;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import com.sanvalero.orms.Repositories.Entities.PostEntity;
import com.sanvalero.orms.Repositories.Interface.PostsAsyncRepository;
import com.sanvalero.orms.Services.Models.PostDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;


public class PostsAsyncServices {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PostsAsyncRepository postsAsyncRepository;

    public CompletableFuture<List<PostDTO>> getAll() {
        return postsAsyncRepository.findAllAsync().whenCompleteAsync((input, exception) -> { }).thenApply(input -> EntitiesToDTO(input));
    }

    public CompletableFuture<List<PostDTO>> findByUserId(Long userId) {
        return postsAsyncRepository.findByUserId(userId).whenCompleteAsync((input, exception) -> { }).thenApply(input -> EntitiesToDTO(input));
    }

    /* public List<PostDTO> filterSalary(Long salary) {
        return postsRepository.filterSalary(salary).stream().map(x -> modelMapper.map(x, PostDTO.class))
        .collect(Collectors.toList());
    } */

    private List<PostDTO> EntitiesToDTO(List<PostEntity> input) {
        return input.stream().map(x -> modelMapper.map(x, PostDTO.class))
        .collect(Collectors.toList());
    }
}
