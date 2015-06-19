package com.terry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.terry.domain.User;
import com.terry.exception.UserAlreadyExistsException;
import com.terry.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private CounterService counterService;
    
    @Override
    @Transactional
    public User save(final User user) {
        User existing = repository.findOne(user.getId());
        if (existing != null) {
            counterService.increment("counter.errors.addUser");  // will appear in /metrics
            throw new UserAlreadyExistsException(
                    String.format("There already exists a user with id=%s", user.getId()));
        }
        counterService.increment("counter.calls.addUser"); // will appear in /metrics
        return repository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getList() {
        return repository.findAll();
    }

}
