package com.fanxingzhiduoshao.user.authentication.center.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter @Setter @ToString
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String accountName;
    private String password;
    private String phoneNumber;
    private String mail;
    private Date createTime;
    private Date updateTime;
    private Boolean mailState;
    private Boolean phoneState;
    private Boolean state;
    private String encryptKey;


}
