package com.hxyc.controller;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author admin
 * @Date 2019/12/23 21:11
 **/
@Api(tags="hello相关的请求")
@RestController
@RequestMapping("/hello")
public class HelloController {
    /**
     *
     * @param token @RequestHeader("token")String token 表示接受请求头参数token
     * @param str
     * @return
     */
    @PutMapping
    public String updateHello(@RequestHeader("token")String token, String str){
        return str;
    }

    @DeleteMapping
    public String deleteHello(Integer id, Long idL, HttpSession session, HttpServletRequest request){
        return "hello";
    }

    /**
     *
     * @param str   @GetMapping 与@RequestMapping 都可以设置方法的访问方式
     * @return
     */
    //@GetMapping
    @RequestMapping( method = RequestMethod.GET,value = "/getHello")
    //value方法的简要描述，notes方法的详细描述
    @ApiOperation(value = "获取hello信息",notes ="根据参数获取hello信息" )
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name="str",value="查询信息",defaultValue="张三",example="张三")
    })
    public String getHello(@RequestParam(required=false) String str){
        return str;
    }
}
