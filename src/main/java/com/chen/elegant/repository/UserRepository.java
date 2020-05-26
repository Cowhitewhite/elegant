package com.chen.elegant.repository;

import com.chen.elegant.entity.TbUserAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<TbUserAdmin,Long> {

    TbUserAdmin findByLoginUserName(String name);

    TbUserAdmin findByAdminUserId(Integer id);
}
