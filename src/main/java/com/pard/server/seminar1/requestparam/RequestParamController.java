package com.pard.server.seminar1.requestparam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RequestParamController {

    //http://localhost:9090/v1?name=redtruth&age=19
    @RequestMapping("/v1")
    public String param1(@RequestParam("name") String myName, @RequestParam("age") int myAge){
        return "RequestParam 1번 : name" + myName + " 나이 " + myAge;
    }

    @RequestMapping("/v2")
    public String param2(@RequestParam String name, @RequestParam int age){
        return "RequestParam 2번 : name " + name + " 나이 " + age;
    }

    @RequestMapping("/v3")
    public String param3(String name, int age){
        return "RequestParam 2번 : name " + name + " 나이 " + age;
    }

    @RequestMapping("/v4")
    public String requestParam4(
            @RequestParam(required = true) String name,
            @RequestParam(required = false) int age
    ){
        return "RequestParam 4번 : name " + name + " 나이 " + age;
    }

    @RequestMapping("/default")
    public String requestParamDefault(
            @RequestParam(required = true, defaultValue = "guest") String name,
            @RequestParam(required = false, defaultValue = "-1") int age
    ){
        return "RequestParam 5번 : name " + name + " 나이 " + age;
    }

    @RequestMapping("/map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap){
        return "RequestParam 6번 : name " + paramMap.get("name") + " age : " + paramMap.get("age");
    }
}
