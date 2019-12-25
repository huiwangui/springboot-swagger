package com.hxyc.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName User
 * @Description TODO
 * @Author admin
 * @Date 2019/12/24 11:22
 **/
@ApiModel("用户")
public class User {
    @ApiModelProperty("用户名称")
    private String username;
    @ApiModelProperty("用户年龄")
    private Integer age;

    public User() {
    }

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
