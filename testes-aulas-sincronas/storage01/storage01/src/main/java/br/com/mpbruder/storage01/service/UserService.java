package br.com.mpbruder.storage01.service;

import br.com.mpbruder.storage01.model.UserBD;
import br.com.mpbruder.storage01.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public UserBD insertUser(UserBD userBD) {
        return repo.save(userBD);
    }

    public Optional<UserBD> findUser(Long cod) {
        return repo.findById(cod);
    }

    public UserBD updateUser(UserBD userBD) {
        return repo.save(userBD);
    }

    public void deleteUser(long cod) {
        repo.deleteById(cod);
    }

}
