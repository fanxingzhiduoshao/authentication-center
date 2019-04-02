package com.fanxingzhiduoshao.user.authentication.center.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author star
 */
@Entity
@Getter @Setter @ToString
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String uid;
    private String name;
    private String description;
    private Long owner;
    private Long createTime;


    public Account(String uid, String name, String description, Long owner, Long createTime) {
        this.uid = uid;
        this.name = name;
        this.description = description;
        this.owner = owner;
        this.createTime = createTime;
    }
}
