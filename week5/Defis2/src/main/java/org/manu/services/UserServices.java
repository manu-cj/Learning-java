package org.manu.services;

import org.manu.Dto.UserRequest;
import org.manu.Dto.UserResponse;
import org.manu.models.User;
import org.manu.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServices {
    private final UserRepository userRepository;

    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse createUser(UserRequest userRequest){
        UUID id = UUID.randomUUID();
        User user = new User(id,userRequest.getName());

        User savedUser = userRepository.save(user);

        return new UserResponse(savedUser.getId(), savedUser.getUsername());

    }

}
