package com.workintech.eTicaret.secondHandMarket.repository;

import com.workintech.eTicaret.secondHandMarket.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {

}
