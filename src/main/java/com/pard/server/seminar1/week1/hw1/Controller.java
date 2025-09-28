package com.pard.server.seminar1.week1.hw1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hw1")
public class Controller {
    @GetMapping
    public String measureFiveSeconds(){
        try{
            for (int i = 0; i < 5; i++) {
                System.out.println(i + "초");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        return "hello";
    }
}
