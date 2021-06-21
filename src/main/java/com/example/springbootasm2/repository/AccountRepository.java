package com.example.springbootasm2.repository;

import com.example.springbootasm2.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Integer> {
    Optional<Account> findAccountByUsername(String username);
}
