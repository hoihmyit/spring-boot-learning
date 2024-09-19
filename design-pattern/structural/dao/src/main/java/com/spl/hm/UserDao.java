package com.spl.hm;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao implements Dao<User> {

    private List<User> users = new ArrayList<>();

    public UserDao() {
        users.add(new User(1, "Dao user 1", "dao1@gmail.com"));
        users.add(new User(2, "Dao user 2", "dao2@gmail.com"));
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public Optional<User> getById(final int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst();
    }

    @Override
    public void save(final User user) {
        users.add(user);
    }

    @Override
    public void update(final User user) {
        getById(user.getId())
                .ifPresent(existUser -> {
                    existUser.setName(user.getName());
                    existUser.setEmail(user.getEmail());
                });
    }

    @Override
    public void delete(final User user) {
        getById(user.getId()).ifPresent(existUser -> users.remove(existUser));
    }
}
