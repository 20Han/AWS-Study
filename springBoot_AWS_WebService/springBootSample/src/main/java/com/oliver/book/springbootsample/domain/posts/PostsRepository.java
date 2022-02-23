package com.oliver.book.springbootsample.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//Entity클래스와 Repository가 함꼐 위치해야한다.
//JpaRepository를 상속받으면 CRUD 메소드가 자동을 생성된다
public interface PostsRepository extends JpaRepository<Posts, Long> {
    
}
