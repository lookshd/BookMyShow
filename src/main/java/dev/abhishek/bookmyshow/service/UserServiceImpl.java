package dev.abhishek.bookmyshow.service;

import dev.abhishek.bookmyshow.entity.User;
import dev.abhishek.bookmyshow.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepo.findAll();
        System.out.println("=== All Users in Database ===");
        for (User user : users) {
            System.out.println("User ID: " + user.getId() +
                             ", Username: " + user.getUsername() +
                             ", Email: " + user.getEmail());
        }
        System.out.println("Total Users: " + users.size());
        System.out.println("============================");
        return users;
    }
}
