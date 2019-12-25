package com.hxyc.config;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * @ClassName SwaggerConfig
 * @Description TODO
 * @Author admin
 * @Date 2019/12/23 17:40
 **/

@ComponentScan("com.hxyc.controller")
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Autowired
    Environment environment;

    @Bean
    public Docket docketUser() {
        // 设置要显示swagger的环境 控制swagger在哪种环境下显示；开发、测试
        //Profiles of = Profiles.of("dev", "test"); //在org.springframework.core.env包下找不到Profiles类，这个就无法测试咯
        // 判断当前是处于该环境，通过 enable() 接收此参数判断是否要显示
        //boolean b = environment.acceptsProfiles(of);

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("user") // 为API配置分组
                .apiInfo(apiInfo())
                // 配置接口要忽略的参数
                //.ignoredParameterTypes(Integer.class, HttpSession.class)
                .enable(true) // 配置是否启用Swagger，如果是false，在浏览器将无法访问,默认是true
                // 通过.select()方法，去配置接口扫描策略
                .select()
                // RequestHandlerSelectors配置如何扫描接口
                .apis(RequestHandlerSelectors.basePackage("com.hxyc.controller"))

                // 配置如何通过 path过滤 即这里只扫描 请求以 /user开头的接口
                .paths(PathSelectors.ant("/user/**"))
                .build();

    }

    //配置多个分组只需要配置多个docket即可
    @Bean
    public Docket docketHello() {
        //配置全局参数；全局参数的理解：比如一个网站，用户登录过后，网站后台发给前台一个token，
        // 以后每次请求时这个token就以请求头的形式带到服务器，那么这个请求头参数token就是一个全局参数
        Parameter token = new ParameterBuilder().name("token")
                .description("用户登录令牌")
                .parameterType("header") //"header":表示请求头参数，controller中@RequestHeader("token")String token这样来接受请求头参数；还可以是"query",这个参数放在请求体中的，controller中String token这样来接受请求体参数
                .modelRef(new ModelRef("String")) //表示这个参数是string,还可以是integer等
                .required(true) //设置每个请求都带上token
                .build();
        ArrayList<Parameter> parameters = new ArrayList<>();
        parameters.add(token);
        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters(parameters) //配置全局参数
                .groupName("hello") // 配置分组
                .apiInfo(apiInfo())
                // 配置接口要忽略的参数
                //.ignoredParameterTypes(Integer.class, HttpSession.class, HttpServletRequest.class)
               // .enable(true) // 配置是否启用Swagger，如果是false，在浏览器将无法访问,默认是true
                // 通过.select()方法，去配置接口扫描策略
                .select()
                // RequestHandlerSelectors配置如何扫描接口
                .apis(RequestHandlerSelectors.basePackage("com.hxyc.controller"))
                // 配置如何通过 path过滤 即这里只扫描 请求以 /user开头的接口
                .paths(PathSelectors.ant("/hello/**")) //特别注意：这里的路径必须这样写：/hello/**；表示/hello下的所有请求
                //.paths(PathSelectors.any())
                .build();

    }

    // Swagger描述信息的配置
    private ApiInfo apiInfo() {
        Contact contact = new Contact("wgh", "http://xxx.xxx.com/联系人访问链接", "联系人邮箱");
        // public ApiInfo(String title, String description, String version, String termsOfServiceUrl, Contact contact, String ", String licenseUrl, Collection<VendorExtension> vendorExtensions) {
        return new ApiInfo("Swagger学习", // 标题
                "学习演示如何配置Swagger", // 描述
                "v1.0", // 版本
                "http://terms.service.url/组织链接", // 组织链接
                contact, // 联系人信息
                "Apach 2.0 许可", // 许可
                "许可链接", // 许可连接
                new ArrayList<>()); // 扩展
    }


}
