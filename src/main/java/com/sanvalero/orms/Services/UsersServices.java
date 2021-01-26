package com.sanvalero.orms.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.sanvalero.orms.Repositories.Entities.UserEntity;
import com.sanvalero.orms.Repositories.Interface.UsersRepository;
import com.sanvalero.orms.Services.Models.UserDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class UsersServices {

    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserDTO> getAll() {
        return userRepository.findAll().stream().map(x -> modelMapper.map(x, UserDTO.class))
        .collect(Collectors.toList());
    }

    public UserDTO add(UserDTO user) {
        return modelMapper.map(resultUser(user), UserDTO.class);
    }

    public UserDTO update(Long id, UserDTO user) {
        return modelMapper.map(resultUser(user), UserDTO.class);
    }

    public void delete(Long id) {
        Optional<UserEntity> entityToDelete = userRepository.findById(id);

        if (entityToDelete.isPresent()) {
            userRepository.delete(entityToDelete.get());
        }
    }

    public Optional<UserDTO> findById(Long id) {
        Optional<UserEntity> entity = userRepository.findById(id);

        if (entity.isPresent()) {
            return Optional.of(modelMapper.map(entity.get(), UserDTO.class));
        } else {
            return Optional.empty();
        }
    }

    private UserEntity resultUser(UserDTO user) {
        UserEntity entity = modelMapper.map(user, UserEntity.class);
        UserEntity result = userRepository.save(entity);
        return result;
    }
}
