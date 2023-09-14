package com.td.HMA.DAOs;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
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
