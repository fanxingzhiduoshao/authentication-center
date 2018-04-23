package com.fanxingzhiduoshao.user.authentication.center.controller.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
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

}
