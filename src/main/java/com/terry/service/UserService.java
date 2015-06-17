package com.terry.service;

import java.util.List;

import com.terry.domain.User;

public interface UserService {
    User save(User user);
    List<User> getList();
}
