package com.chen.elegant.repository;

import com.chen.elegant.entity.SysPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysPermissionDao extends JpaRepository<SysPermission,Long> {



}
