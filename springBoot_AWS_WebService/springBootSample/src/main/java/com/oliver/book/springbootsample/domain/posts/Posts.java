package com.oliver.book.springbootsample.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity //db 테이블과 링크될 클래스임을 나타냄. 클래스의 카멜케이스 이름을 스네이크 케이스로 바꾸어 테이블 이름을 매칭함, Entity 클래스에서는 Setter 메소드를 만들지 않음(언제 변하는지 확인 어렵). Setter대신 특정 값을 넣을 수 있는 별도의 메소드를 만듦
public class Posts {
    @Id //Primary Key 필드를 나타낸다, AutoIncrement를 추천한다고 한다. 또한 비즈니스적 유니크 키(ex: 주민번호)를 pk로 두지 않는것을 추천
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 스프링 부트 2.0에서는 GenerationType.IDENTITY 옵션을 추가해야 auto_increment가 된다.
    private Long id;

    @Column(length = 500, nullable = false)
    private String content;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String title;
    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
