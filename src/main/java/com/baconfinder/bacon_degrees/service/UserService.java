package com.baconfinder.bacon_degrees.service;

import com.baconfinder.bacon_degrees.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    private final Map<Long, User> userMap = new HashMap<>();
    private Long idCounter = 1L;

    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }

    public User addUser(User user) {
        user.setId(idCounter++);
        userMap.put(user.getId(), user);
        return user;
    }
    public User getUserById(Long id) {
        return userMap.get(id);
    }

    public void deleteUser(Long id) {
        userMap.remove(id);
    }

}
