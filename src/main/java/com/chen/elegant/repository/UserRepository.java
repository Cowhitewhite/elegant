package com.chen.elegant.repository;

import com.chen.elegant.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUserName(String name);

    User findById(Integer id);
}
