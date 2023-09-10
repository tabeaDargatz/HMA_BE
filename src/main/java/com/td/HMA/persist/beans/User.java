package com.td.HMA.persist.beans;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "USERNAME", nullable = false)
    private String username;
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    @Column(name = "EMAIL", nullable = false)
    private String email;
}
