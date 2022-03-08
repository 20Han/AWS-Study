package com.oliver.book.springbootsample.web;

import com.oliver.book.springbootsample.config.auth.dto.SessionUser;
import com.oliver.book.springbootsample.service.posts.PostsService;
import com.oliver.book.springbootsample.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model) {
        //서버 템플릿 엔진에서 사용할 수 있는 객체를 저장
        //여기서는 postsService.findAllDesc()로 가져온 결과를 posts로 index.mustache에 전달한다
        model.addAttribute("posts", postsService.findAllDesc());

        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if(user != null) {
            model.addAttribute("userName", user.getName());
        }
        //머스테치 스타터에의해 컨트롤러에서 문자열을 반환할 대 앞의 경로와 뒤의 파일 확장자는 자동으로 결정
        //여기서 리턴값이 머스테치파일의 이름, 확장자는 .mustache
        //따라서 index.mustache라는 View Resolver가 뷰를 처리하게 된다.
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsSave(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
