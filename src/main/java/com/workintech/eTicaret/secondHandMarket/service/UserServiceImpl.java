package com.workintech.eTicaret.secondHandMarket.service;

import com.workintech.eTicaret.secondHandMarket.dto.CreateUserRequest;
import com.workintech.eTicaret.secondHandMarket.dto.UserDto;
import com.workintech.eTicaret.secondHandMarket.dto.UserDtoConverter;
import com.workintech.eTicaret.secondHandMarket.entity.User;
import com.workintech.eTicaret.secondHandMarket.exception.UserNotFoundException;
import com.workintech.eTicaret.secondHandMarket.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements  UserService{
    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;

    public UserServiceImpl(UserRepository userRepository, UserDtoConverter userDtoConverter) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
    }
     public List<UserDto> getAllUsers(){
         return userRepository.findAll().stream().map(userDtoConverter::convert).collect(Collectors.toList());
     }
     public UserDto getUserById(Long id){
        User user=userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User couldn't be found by following id:", HttpStatus.NOT_FOUND));
         return UserDtoConverter.convert(user);

     }
     public UserDto createUser(CreateUserRequest userRequest){
        User user=new User(null,userRequest.mail(),userRequest.firstName(),userRequest.lastName(),userRequest.password());
        return userDtoConverter.convert(userRepository.save(user));
     }

}
