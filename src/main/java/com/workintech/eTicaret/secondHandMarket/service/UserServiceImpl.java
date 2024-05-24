package com.workintech.eTicaret.secondHandMarket.service;

import com.workintech.eTicaret.secondHandMarket.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements  UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
