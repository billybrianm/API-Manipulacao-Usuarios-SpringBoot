package com.coodesh.billybrianm.usuariosapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coodesh.billybrianm.usuariosapi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}