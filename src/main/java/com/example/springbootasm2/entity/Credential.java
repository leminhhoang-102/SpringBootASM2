package com.example.springbootasm2.entity;

import javax.persistence.*;

@Entity
public class Credential {
    @Id
    private String accessToken;
    @Column(insertable = false,updatable = false)
    private int accountId;
    private long createdAt;
    private long expiredAt;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "accountId")
    private Account account;
}
