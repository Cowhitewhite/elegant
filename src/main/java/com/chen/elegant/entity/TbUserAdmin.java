package com.chen.elegant.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "tb_admin_user")
public class TbUserAdmin implements Serializable {
    private static final long serialVersionUID = 75825390851163595L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int adminUserId;

    private  String loginUserName;

    private  String loginPassword;

    private  String nickName;

    private  Integer locked;
}
