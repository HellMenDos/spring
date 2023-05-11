package com.bbtutorials.users.controller;

import com.bbtutorials.users.entity.Post;
import com.bbtutorials.users.service.PostService;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {

  private final PostService postService;

  @Transactional
  @PostMapping()
  @ResponseStatus(value = HttpStatus.CREATED)
  public ResponseEntity<Post> createPost(
      @RequestBody
      @Valid
      @NotNull
      Post post) {
    log.info("PostController:  create post");
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(postService.createPost(post));
  }

  @Transactional
  @ResponseStatus(value = HttpStatus.OK)
  @PatchMapping("/{id}")
  public ResponseEntity<Post> updatePost(
      @RequestBody
      @Valid
      @NotNull
      Post post,
      @PathVariable("id")
      @NotNull
      Long postId) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(postService.updatePost(post, postId));
  }

  @ResponseStatus(value = HttpStatus.OK)
  @GetMapping("/{id}")
  public ResponseEntity<Post> getPostById(
      @PathVariable("id")
      @NotNull
      Long postId) {
    return ResponseEntity.status(HttpStatus.OK).body(postService.findPostById(postId));
  }

  @GetMapping()
  @ResponseStatus(value = HttpStatus.OK)
  public ResponseEntity<List<Post>> getAllPosts() {
    return ResponseEntity.ok(postService.findAllPosts());
  }

  @Transactional
  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletePostById(
      @PathVariable("id")
      @NotNull
      Long postId) {
    postService.deletePostById(postId);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}
