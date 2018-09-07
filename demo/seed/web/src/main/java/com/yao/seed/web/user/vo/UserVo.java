package com.yao.seed.web.user.vo;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Creator: Yao
 * Date:    2018/9/7
 * For:
 * Other:
 */
public class UserVo {

    private Long id;
    @NotBlank(message = "请输入用户名")
    private String name;
    @NotBlank(message = "请输入密码")
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
