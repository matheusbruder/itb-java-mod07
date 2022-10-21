package br.com.mpbruder.storage01.controller;

import br.com.mpbruder.storage01.model.UserBD;
import br.com.mpbruder.storage01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;


    @PostMapping
    public ResponseEntity<UserBD> newUser(@RequestBody UserBD userBD) {
        UserBD newUser = service.insertUser(userBD);

        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/{cod}")
    public ResponseEntity<UserBD> findUser(@PathVariable long cod) {
        Optional<UserBD> optionalUserBD = service.findUser(cod);

        return optionalUserBD.map(userBD -> new ResponseEntity<>(userBD, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping
    public ResponseEntity<UserBD> updateUser(@RequestBody UserBD userBD) {
        UserBD userUpdated = service.updateUser(userBD);

        return new ResponseEntity<>(userUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/{cod}")
    public ResponseEntity<Void> deleteUser(@PathVariable long cod) {
        service.deleteUser(cod);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
