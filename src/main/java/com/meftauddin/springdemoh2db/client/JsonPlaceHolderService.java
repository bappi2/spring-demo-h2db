package com.meftauddin.springdemoh2db.client;

import com.meftauddin.springdemoh2db.entity.Post;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

import java.util.List;

public interface JsonPlaceHolderService {
    @GetExchange("/posts")
    List<Post> findAll();

    @GetExchange("/posts/{id}")
    Post findById(@PathVariable("id") Integer id);

    @PostExchange("/posts")
    Post create(Post post);

    @PutExchange("/posts/{id}")
    Post update(@PathVariable("id") Integer id, Post post);

    @DeleteMapping("/posts/{id}")
    void delete(@PathVariable("id") Integer id);
}
