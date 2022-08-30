package com.sunglowsys.service.serviceImpl;

import com.sunglowsys.domain.User;
import com.sunglowsys.repository.UserRepository;
import com.sunglowsys.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Override
    public User save(User user) {
        user.setPassword(encoder.encode (user.getPassword ()));
        return userRepository.save (user);
    }

    @Override
    public User update(User user, Long id) {
        return userRepository.save (user);
    }

    @Override
    public Page<User> getAll(Pageable pageable) {
        return userRepository.findAll (pageable);
    }

    @Override
    public Optional<User> getOne(Long id) {
        return userRepository.findById (id);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById (id);
    }
}
