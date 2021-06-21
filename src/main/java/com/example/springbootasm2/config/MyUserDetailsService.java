package com.example.springbootasm2.config;

import com.example.springbootasm2.entity.Account;
import com.example.springbootasm2.repository.AccountRepository;
import com.example.springbootasm2.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<Account> optionalAccount = accountRepository.findAccountByUsername(username);
        if (optionalAccount.isPresent()){
            Account account= optionalAccount.get();
            UserDetails userDetails =
                    User.builder()
                        .username(account.getUsername())
                        .password(account.getPasswordHash())
                        .roles("ADMIN","USER")
                        .build();
            return userDetails;
        }
        return null;
    }

}
