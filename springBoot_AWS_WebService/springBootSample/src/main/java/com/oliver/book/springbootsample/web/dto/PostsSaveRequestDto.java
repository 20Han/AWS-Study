package com.oliver.book.springbootsample.web.dto;

import com.oliver.book.springbootsample.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String conetent;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.conetent = content;
        this.author = author;
    }

    /*
    현재 Dto클래스가 Entity클래스와 거의 유사하다.
    하지만 비즈니스 로직인 Entity를 바로 response, request용 클래스로 사용해서는 안된다.
    왜냐하면 DB Layer가 View Layer에 의해 간섭을 받게 되기 때문이다.
    */
    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(conetent)
                .author(author)
                .build();
    }
}
