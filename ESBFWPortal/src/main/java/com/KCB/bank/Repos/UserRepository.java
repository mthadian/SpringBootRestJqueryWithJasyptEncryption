package com.KCB.bank.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KCB.bank.models.auth.Users;


@Repository
public interface UserRepository extends JpaRepository<Users, String>{

}
