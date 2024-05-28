package com.workintech.eTicaret.secondHandMarket.service;

import com.workintech.eTicaret.secondHandMarket.dto.CreateUserRequest;
import com.workintech.eTicaret.secondHandMarket.dto.UserDto;
import com.workintech.eTicaret.secondHandMarket.entity.User;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers();

   UserDto getUserById(Long id);


    UserDto createUser(CreateUserRequest userRequest);
}
