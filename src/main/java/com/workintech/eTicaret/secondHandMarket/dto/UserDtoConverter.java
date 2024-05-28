package com.workintech.eTicaret.secondHandMarket.dto;

import com.workintech.eTicaret.secondHandMarket.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter {
    public UserDto convert(User from){
        return new UserDto(from.getMail(),from.getFirstName(), from.getLastName());
    }

}
