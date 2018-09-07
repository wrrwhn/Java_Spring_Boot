package com.yao.seed.commons.user.entity;

import javax.persistence.*;

/**
 * Creator: Yao
 * Date:    2018/9/6
 * For:
 * Other:
 */
@Entity
@Table(name = "`user`")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "`name`")
    private String name;
    @Column(name = "`pwd`")
    private String pwd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
