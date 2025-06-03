package org.manu.repository;

import org.manu.models.User;

import java.util.ArrayList;
import java.util.List;

public class UsersRepository {
    List<User> usersRepository = new ArrayList<>();

    public boolean save(User user) {
        for (User alreadyExist : usersRepository) {
            if (alreadyExist.getId().equals(user.getId())) {
                return false;
            }
        }

        usersRepository.add(user);
        return true;
    }
}
