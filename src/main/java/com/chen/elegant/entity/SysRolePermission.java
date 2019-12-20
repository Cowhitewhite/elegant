package com.chen.elegant.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

//角色权限关联实体
@Data
@Entity
@Table
public class SysRolePermission implements Serializable {
    private static final long serialVersionUID = 8949842330879809712L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(length=32)
    private String roleCode;

    private int permissionId;

    @CreatedDate
    private Date createTime;

    @LastModifiedDate
    private Date updateTime;
}
