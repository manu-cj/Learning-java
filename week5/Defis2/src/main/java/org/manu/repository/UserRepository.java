package org.manu.repository;

import org.manu.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    List<User> userRepository = new ArrayList<>();

    public User save(User user) {
        for (User alreadyExist : userRepository) {
            if (alreadyExist.getId().equals(user.getId())) {
                return null;
            }
        }

        userRepository.add(user);
        return user;
    }

    public User findByUsername(String username) {
        return userRepository.stream()
                .filter(n -> n.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    public List<User> findAll() {
        return userRepository;
    }
}
