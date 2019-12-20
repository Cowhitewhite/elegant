package com.chen.elegant.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
//用户角色关联实体
@Data
@Entity
@Table
public class SysUserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String uid;

    @Column(length=32)

    private String roleCode;

    @CreatedDate
    private Date createTime;

    @LastModifiedDate
    private Date updateTime;
}