package com.sanvalero.orms.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.sanvalero.orms.Repositories.Entities.PostEntity;
import com.sanvalero.orms.Repositories.Interface.PostsRepository;
import com.sanvalero.orms.Services.Models.PostDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class PostsServices {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PostsRepository postsRepository;

    public List<PostDTO> getAll() {
        return postsRepository.findAll().stream().map(x -> modelMapper.map(x, PostDTO.class))
        .collect(Collectors.toList());
    }

    public PostDTO add(PostDTO post) {
        return modelMapper.map(resultUser(post), PostDTO.class);
    }

    public PostDTO update(Long id, PostDTO post) {
        return modelMapper.map(resultUser(post), PostDTO.class);
    }

    public void delete(Long id) {
        Optional<PostEntity> entityToDelete = postsRepository.findById(id);

        if (entityToDelete.isPresent()) {
            postsRepository.delete(entityToDelete.get());
        }
    }

    public Optional<PostDTO> findById(Long id) {
        Optional<PostEntity> entity = postsRepository.findById(id);

        if (entity.isPresent()) {
            return Optional.of(modelMapper.map(entity.get(), PostDTO.class));
        } else {
            return Optional.empty();
        }
    }

    private PostEntity resultUser(PostDTO post) {
        PostEntity entity = modelMapper.map(post, PostEntity.class);
        PostEntity result = postsRepository.save(entity);
        return result;
    }
}
