package com.sunglowsys.resource;

import com.sunglowsys.domain.User;
import com.sunglowsys.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User result = userService.save (user);
        return ResponseEntity
                .status (HttpStatus.CREATED)
                .body (result);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUsers(@PathVariable User user , Long id) {
        User result = userService.update (user, id);
        return ResponseEntity
                .status (HttpStatus.OK)
                .body (result);
    }

    @GetMapping("/users")
    public ResponseEntity<Page<User>> getAll(Pageable pageable) {
        Page<User> result = userService.getAll (pageable);
        return ResponseEntity.status (HttpStatus.OK).body (result);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Optional<User>> getOneUser(@PathVariable Long id) {
        Optional<User> result = userService.getOne (id);
        return ResponseEntity
                .status (HttpStatus.OK)
                .body (result);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteOneUsers(@PathVariable Long id) {
        userService.delete (id);
        return ResponseEntity
                .status (HttpStatus.OK)
                .build ();
    }
}
