package com.linux0.provider.controller;

import com.linux0.provider.dao.UserRepository;
import com.linux0.provider.entity.User;
import com.linux0.provider.feign.UserFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenhang
 * @Title: UserController
 * @ProjectName SpringCloudStudyDemo
 * @Description: TODO
 * @date 2019/10/22 002216:08
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserFeign userFeign;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return userRepository.findById(id).get();
    }


    /**
     *测试zuul
     * @return
     */
    @GetMapping("/add/{a}/{b}")
    public int add(@PathVariable int a,@PathVariable int b){
        return a+b;
    }

    /**
     * 使用feign方式调用
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    public User UserfindByid(@PathVariable Long id){
       return userFeign.findById(id);
    }


}
