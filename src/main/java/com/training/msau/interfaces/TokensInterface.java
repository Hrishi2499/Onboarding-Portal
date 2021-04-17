package com.training.msau.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.msau.model.Tokens;

public interface TokensInterface extends JpaRepository<Tokens, Long>{

}
