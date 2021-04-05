package com.jyhan.book.springboot.service.posts;

import com.jyhan.book.springboot.domain.posts.Posts;
import com.jyhan.book.springboot.domain.posts.PostsRepository;
import com.jyhan.book.springboot.web.dto.PostsResponseDto;
import com.jyhan.book.springboot.web.dto.PostsSaveRequestDto;
import com.jyhan.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto postsSaveRequestDto) {
        return postsRepository.save(postsSaveRequestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("exception occure"));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("exection occur"));
        return new PostsResponseDto(entity);
    }
}
