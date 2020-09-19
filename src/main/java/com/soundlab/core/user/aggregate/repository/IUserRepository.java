package com.soundlab.core.user.aggregate.repository;

import com.soundlab.core.user.aggregate.entity.User;

import java.util.List;

public interface IUserRepository {

    List<User> getAll();
    User getById(Long id);
    void save(User user);
    void delete(Long id);
    void update(Long id, User user);
}
