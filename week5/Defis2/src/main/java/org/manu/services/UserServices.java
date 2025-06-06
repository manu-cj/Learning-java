package org.manu.services;

import org.manu.Dto.UserRequest;
import org.manu.Dto.UserResponse;
import org.manu.models.User;
import org.manu.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServices {
    private final UserRepository userRepository;

    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Create a new user
     * @param userRequest
     * @return
     */
    @Transactional
    public UserResponse createUser(UserRequest userRequest){
        UUID id = UUID.randomUUID();
        User user = new User(id,userRequest.getUsername());

        User savedUser = userRepository.save(user);

        return new UserResponse(savedUser.getId(), savedUser.getUsername());
    }

    /**
     * Return user by username
     * @param username
     * @return
     */
    public UserResponse getByUsername(String username) {
        User savedUser = userRepository.findByUsername(username);

        if (savedUser == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Utilisateur non trouvé avec l'username :" + username);
        }

        return UserResponse.builder()
                .id(savedUser.getId())
                .username(savedUser.getUsername())
                .build();
    }

    /**
     * Return all users
     * @return
     */
    public List<UserResponse> getAllUser() {
        return  userRepository.findAll().stream()
                .map(user -> UserResponse.builder()
                        .id(user.getId())
                        .username(user.getUsername())
                        .build())
                .collect(Collectors.toList());
    }


}
