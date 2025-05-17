package com.practice.Demo.JPA.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.Demo.JPA.Entity.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {

}
