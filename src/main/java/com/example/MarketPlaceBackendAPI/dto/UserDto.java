package com.example.MarketPlaceBackendAPI.dto;

import com.example.MarketPlaceBackendAPI.models.User;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    private String otherInfo;
    public User toUser(){
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setOtherInfo(otherInfo);

        return user;
    }
    public static UserDto fromUser(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setFirstname(user.getFirstname());
        userDto.setLastname(user.getLastname());
        userDto.setEmail(user.getEmail());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setOtherInfo(user.getOtherInfo());

        return userDto;
    }
}
