package com.example.springbootasm2.service;

import com.example.springbootasm2.entity.Account;
import com.example.springbootasm2.entity.Credential;
import com.example.springbootasm2.repository.AccountRepository;
import com.example.springbootasm2.repository.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CredentialRepository credentialRepository;

    private PasswordEncoder passwordEncoder;

    public boolean register(String username, String password,int role){
      //  student.getInfomation().setStudent(student);
        Account account = new Account();
        account.setUsername(username);
        account.setPasswordHash(passwordEncoder.encode(password));
        account.setRole(2);
        account.setStatus(1);
        accountRepository.save(account);
        return true;
    }

    public Account login(String username, String password){
        Account account = null;
      Optional<Account> optionalAccount = accountRepository.findAccountByUsername(username);
      if (optionalAccount.get().getPasswordHash()==password){
       account = optionalAccount.get();
      }
        return account;
    }
}
