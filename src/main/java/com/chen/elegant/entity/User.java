package com.chen.elegant.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 75825390851163595L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private  String name;

    private  String sex;

    private  Integer age;

    private  String email;

    private  String headUrl;

    private  String userName;

    private  String password;

    private  String perms;

    private Integer status;

    private Date createDate;
}
