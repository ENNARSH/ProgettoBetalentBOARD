package com.progetto.betalent.board.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
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





}
