package com.oliver.book.springbootsample.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//Application을 json을 반환하는 컨트롤러로 변환해준다
public class HelloController {

    @GetMapping("/hello")
    //GET 메소드 허용
    public String hello() {
        return "hello";
    }
}
