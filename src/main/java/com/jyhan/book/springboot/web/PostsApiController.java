package com.jyhan.book.springboot.web;

import com.jyhan.book.springboot.service.posts.PostsService;
import com.jyhan.book.springboot.web.dto.PostsResponseDto;
import com.jyhan.book.springboot.web.dto.PostsSaveRequestDto;
import com.jyhan.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto postsSaveRequestDto){
        return postsService.save(postsSaveRequestDto);
    }

    @PutMapping("api/v1/posts/{id}")
    //@RequestMapping(value = "api/v1/posts/{id}", method = RequestMethod.PUT)
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("api/v1/posts/{id}")
   // @RequestMapping(value = "api/v1/posts/{id}", method = RequestMethod.GET)
    public PostsResponseDto findByid(@PathVariable Long id){
        return postsService.findById(id);
    }
}
