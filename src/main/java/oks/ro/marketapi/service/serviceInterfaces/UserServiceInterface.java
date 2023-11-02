package oks.ro.marketapi.service.serviceInterfaces;

import oks.ro.marketapi.model.Customer;
import oks.ro.marketapi.model.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface {
    List<User> findUsers();
    Optional<User> findUserById(Long userId);

    User addUser(User user);
    User updateUser(Long userId, User user);
    void deleteUserById(Long userId);
}
