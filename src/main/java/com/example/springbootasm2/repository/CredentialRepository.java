package com.example.springbootasm2.repository;

import com.example.springbootasm2.entity.Credential;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialRepository extends JpaRepository<Credential,String> {
}
