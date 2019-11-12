package com.linux0.provider.feign;

/*
import com.linux0.provider.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
*/

/**
 * @author chenhang
 * @Title: UserFeign
 * @ProjectName SpringCloudStudyDemo
 * @Description: TODO
 * @date 2019/11/8 000816:33
 */
//客户端名称 用于创建ribbon 负载均衡器   ribbon会把consumer解析成eurekaserver服务注册表中的服务
//@FeignClient(name = "consumer")
public interface UserFeign {

    //feign接口
   // @RequestMapping(value = "user/{id}",method = RequestMethod.GET)
   // public User findById(@PathVariable Long id);
}
