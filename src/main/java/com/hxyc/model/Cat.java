package com.hxyc.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName Cat
 * @Description TODO 实体信息配置
 * @Author admin
 * @Date 2019/12/24 11:26
 **/
@ApiModel("猫")
public class Cat {
    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty(value = "年龄",example = "1")
    private Integer age;

    public Cat() {
    }

    public Cat(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
