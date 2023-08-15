package service;

import domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(Long userId);
    Optional<User> getUserByUsername(String username);
    User addUser(User user);
    void deleteUser(Long userId);
}
