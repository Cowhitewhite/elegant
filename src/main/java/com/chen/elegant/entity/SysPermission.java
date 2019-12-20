package com.chen.elegant.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Data
@Entity
@Table
public class SysPermission implements Serializable{

    private static final long serialVersionUID = 960801694129036736L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String PermName;//名称.

    @Column(columnDefinition="enum('menu','button')",length=10)
    private String resourceType;//资源类型，[menu|button]

    @Column(length=200)
    private String url;//资源路径.

    @Column(length=100)
    private String icon;

    private int sort;

    @Column(unique=true,length=20)
    private String permission; //权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view

    private int parentId; //父编号

    private Boolean state = Boolean.TRUE;

    @CreatedDate
    private Date createTime;

    @LastModifiedDate
    private Date updateTime;
}
