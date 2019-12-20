package com.chen.elegant.repository;

import com.chen.elegant.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserRepository extends JpaRepository<SysUser,Long> {

    SysUser findByUsername(String name);

}
