package com.yao.user.vo;

/**
 * Creator: Yao
 * Date:    2018/11/6
 * For:
 * Other:
 */
public class UserVo {

    private Long id;
    private String name;

    public UserVo() {
    }

    public UserVo(Long id, String name) {
        this.id = id;
        this.name = name;
    }

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
}
