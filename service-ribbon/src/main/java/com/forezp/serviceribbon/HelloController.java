package com.forezp.serviceribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @RequestMapping("/hi")
    public String hi(@RequestParam String name){
       return helloService.hiService(name);
    }

    @RequestMapping(value = "/rmt")
    public String rmt(){
        return "rmt success!";
    }

    @GetMapping(value = "/gmt")
    public String gmt(){
        return "gmt success!";
    }
}
