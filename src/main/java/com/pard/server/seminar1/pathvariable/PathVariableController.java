package com.pard.server.seminar1.pathvariable;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathVariableController {
    @RequestMapping ("/path/{name}")
    public String path(@PathVariable("name") String userName) {
        return "1번 pathVariable name : " + userName;
    }

    @RequestMapping("/pathV2/{name}")
    public String path2(@PathVariable String name){
        return "2번 pathVariable name : " + name;
    }

    @RequestMapping("/pathV3/{name}/{age}")
    public String path3(@PathVariable String name, @PathVariable int age){
        return "3번 user 이름: " + name + "나이 : " + age;
    }
}
