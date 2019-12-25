package com.hxyc.controller;

import com.hxyc.model.Cat;
import com.hxyc.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author admin
 * @Date 2019/12/23 21:01
 **/
@Api(tags="用户相关的请求")
@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * @param  //方法参数如Cat cat这个形式，在swagger页面models中是没有Cat 这种一般是表单提交
     * @return
     */
   /* @GetMapping
    public String getUser(Cat cat){
        return "张三";
    }*/

    @PostMapping
    public String addUser(String username){
        return username;
    }

    /**
     *
     * @return 返回的实体，在swagger页面models中会显示
     */
    @DeleteMapping
    public User delUser(){
        User user = new User("zhangsan", 18);
        return user;
    }

    /**
     *
     * @param cat 接受json形式的Cat,方法参数如@RequestBody Cat cat这样的参数，Cat会在swagger页面models中显示
     *            json形式的参数都会扫描到swagger的实体中
     * @return
     */
    @PutMapping
    public String putUser(@RequestBody Cat cat){
        return "user";
    }

    /**
     *
     * @param username
     * @param password
     * @return
     */
    @ApiOperation("获取用户信息")
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name="username",value="用户名",defaultValue="张三",example="lisi"),
            @ApiImplicitParam(name="password",value="用户密码")
    })
    public String getUser(String username,String password){
        return "张三";
    }
}
