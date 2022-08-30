package com.sunglowsys.service;

import com.sunglowsys.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {

    User save(User user);

    User  update(User user, Long id);

    Page<User> getAll(Pageable pageable);

    Optional<User> getOne(Long id);

    void delete(Long id);
}
