package com.training.msau.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.msau.model.Users;

public interface UsersInterface extends JpaRepository<Users, Long>{

}
