package com.progetto.betalent.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
public class UserDto {
    private String username;
    private String password;
    private String fullname;
    private String role;
    
    public UserDto() {
    }

    public UserDto(String username, String password, String fullname) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
    }


}
