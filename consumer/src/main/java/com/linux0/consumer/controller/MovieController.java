package com.linux0.consumer.controller;

import com.linux0.consumer.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

/**
 * @author chenhang
 * @Title: MovieController
 * @ProjectName SpringCloudStudyDemo
 * @Description: TODO
 * @date 2019/10/30 003010:43
 */
@RestController
@RefreshScope
public class MovieController {
/*
    @Value("${from}")
    private String from;*/

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return this.restTemplate.getForObject("http://localhost:8001/" + id, User.class);
    }

    @GetMapping("/add/{a}/{b}")
    public int add(@PathVariable int a,@PathVariable int b){
        return a+b;
    }



    @HystrixCommand(fallbackMethod = "findByUserByIdFallBack")
    @GetMapping("/provider/user/{id}")
    public User providerUserFindById(@PathVariable Long id){
        return this.restTemplate.getForObject("http://localhost:8001/"+ id,User.class);
    }

    public User findByUserByIdFallBack(Long id){
        User user = new User();
        user.setName("noname");
        user.setAge(1);
        user.setBalance(BigDecimal.valueOf(0.00));
        user.setId(0L);
        System.out.println("this is fallback message and the id is "+id);
        return user;
    }

   /* @GetMapping("/getFrom")
    public String getFrom(){
        return this.from;
    }*/
}
