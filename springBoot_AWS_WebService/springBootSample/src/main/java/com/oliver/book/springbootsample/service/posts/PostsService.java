package com.oliver.book.springbootsample.service.posts;

import com.oliver.book.springbootsample.domain.posts.Posts;
import com.oliver.book.springbootsample.domain.posts.PostsRepository;
import com.oliver.book.springbootsample.web.dto.PostsResponseDto;
import com.oliver.book.springbootsample.web.dto.PostsSaveRequestDto;
import com.oliver.book.springbootsample.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public long update(Long id, PostsUpdateRequestDto requestDto) {
        //update시에 db쿼리를 날리는 과정이 없다 -> JPA의 영속성 컨텍스트 덕분에 데이터를 가져온 후 수정하면 트랜잭션이 끝나는 시점에 해당 테이블에 변경된 부분을 반영한다.
        //즉 Update 쿼리가 따로 필요없으며 이를 더티 체킹(dirty checking)이라고 한다.

        Posts posts = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다 id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다 id=" + id));

        return new PostsResponseDto(entity);
    }
}
