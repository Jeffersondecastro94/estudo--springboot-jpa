package com.estudo.estudo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.estudo.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
