package oks.ro.marketapi.service;

import oks.ro.marketapi.model.User;
import oks.ro.marketapi.service.serviceInterfaces.UserServiceInterface;

import java.util.List;
import java.util.Optional;

public class UserService implements UserServiceInterface {

    @Override
    public List<User> findUsers() {
        return null;
    }

    @Override
    public Optional<User> findUserById(Long userId) {
        return Optional.empty();
    }

    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public User updateUser(Long userId, User user) {
        return null;
    }

    @Override
    public void deleteUserById(Long userId) {

    }
}
