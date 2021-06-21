package com.example.springbootasm2.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String fullName;
    private String passwordHash;
    private int role;
    private int status;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Credential> token;

    public Account() {
    }

    public Account(int id, String username, String fullName, String passwordHash, int role, int status) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.passwordHash = passwordHash;
        this.role = role;
        this.status = status;
    }
}
