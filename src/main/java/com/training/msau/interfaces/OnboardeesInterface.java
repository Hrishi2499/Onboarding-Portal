package com.training.msau.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.msau.model.Onboardees;

public interface OnboardeesInterface extends JpaRepository<Onboardees, Long>{

}
