package com.workintech.eTicaret.secondHandMarket.controller;

import com.workintech.eTicaret.secondHandMarket.entity.User;
import com.workintech.eTicaret.secondHandMarket.service.UserService;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>>  getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        return ResponseEntity.ok(userService.getUserbyId(id));
    }

    @PostMapping//201
    public ResponseEntity<User> createUser(@RequestBody User user){
        return ResponseEntity.ok(userService.createUser(userRequest));
    };

   @PutMapping("/{id}")//202
    public ResponseEntity<User> updateUser(@RequestBody UpdateUserRequest updateUserRequest){
        return ResponseEntity.ok(userService.updateUser(updateUserRequest));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Void> deactiveUser(@PathVariable("id") Long id){
        userService.deactiveUser(id);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id){
       userService.deleteUser(id);
       return ResponseEntity.ok().build();
    }

}
