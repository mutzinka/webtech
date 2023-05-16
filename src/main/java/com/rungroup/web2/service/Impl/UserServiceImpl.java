package com.rungroup.web2.service.Impl;

import com.rungroup.web2.model.User;
import com.rungroup.web2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String logConfirmation(String email, String password) {
        try {
            User user = userRepository.findByEmailAndPassword(email, password);
            if (user != null && user.getRole().equals("ADMIN")) {
                return "redirect:/schools";
            } else {
                return "redirect:/signup";
            }
        } catch (Exception ex) {
            return "redirect:/schools";
        }
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
