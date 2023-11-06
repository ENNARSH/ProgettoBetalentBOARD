package com.progetto.betalent.board.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
@Entity  //Questa classe corrisponde a una tabella
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")  //corrisponde al nome della colonna (attributo)
    private Long id;
    @Column(name = "username")  //corrisponde al nome della colonna (attributo)
    private String username;
    @Column(name = "password")  //corrisponde al nome della colonna (attributo)
    private String password;
    @Column(name = "fullname")  //corrisponde al nome della colonna (attributo)
    private String fullname;

<<<<<<< HEAD
    public User(String username, String password, String fullname) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
    }

    public User() {
    }
=======
public User(Long id,String username,String fullname){
this.id = id;
this.username = username;
this.fullname = fullname;
}
>>>>>>> 08aee9c6ae7c1fd5e24c8ced04608c33ed9668d5

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
