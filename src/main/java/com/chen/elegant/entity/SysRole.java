package com.chen.elegant.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

//角色实体
@Data
@Entity
@Table
public class SysRole implements Serializable {

    private static final long serialVersionUID = -937059690693046799L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(unique=true, length=32)
    private String roleCode;//程序中判断使用,如"admin",这个是唯一的

    @Column(unique=true, length=30)
    private String roleName; // 角色名字

    @Column(length=200)
    private String description; //角色描述,UI界面显示使用

    private Boolean state = Boolean.TRUE; //是否可用,如果不可用将不会添加给用户

    @CreatedDate
    private Date createTime;

    @LastModifiedDate
    private Date updateTime;
}