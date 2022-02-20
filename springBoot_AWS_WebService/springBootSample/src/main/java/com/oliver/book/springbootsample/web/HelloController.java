package com.oliver.book.springbootsample.web;

import com.oliver.book.springbootsample.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//Application을 json을 반환하는 컨트롤러로 변환해준다
public class HelloController {

    @GetMapping("/hello")
    //GET 메소드 허용
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
