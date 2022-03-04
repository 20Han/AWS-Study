package com.oliver.book.springbootsample.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index() {
        //머스테치 스타터에의해 컨트롤러에서 문자열을 반환할 대 앞의 경로와 뒤의 파일 확장자는 자동으로 결정
        //여기서 리턴값이 머스테치파일의 이름, 확장자는 .mustache
        //따라서 index.mustache라는 View Resolver가 뷰를 처리하게 된다.
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }
}
