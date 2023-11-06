package com.progetto.betalent.board.service;


import com.progetto.betalent.board.dto.UserDto;
import com.progetto.betalent.board.entities.User;

public interface UserService {
    User findByUsrname(String username);
    User save(UserDto userDto);
}
