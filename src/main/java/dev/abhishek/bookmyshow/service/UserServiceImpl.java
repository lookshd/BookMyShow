package dev.abhishek.bookmyshow.service;

import dev.abhishek.bookmyshow.entity.User;
import dev.abhishek.bookmyshow.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements  UserService {

    @Autowired
    private UserRepo userRepo;

    public User createUser(User user) {
        return userRepo.save(user);
    }
    public User getUserById(Integer id) {
        return userRepo.findById(id).get();
    }
}
