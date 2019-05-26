package com.jnmybxg.twohour.service;

import com.jnmybxg.twohour.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl,Integer> {
    public List<Girl> findGirlsByAge(Integer age);
}
