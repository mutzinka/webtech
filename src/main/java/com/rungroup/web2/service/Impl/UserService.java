package com.rungroup.web2.service.Impl;

import com.rungroup.web2.model.User;

public interface UserService {

    String logConfirmation(String email,String password);

    void saveUser(User user);
}
