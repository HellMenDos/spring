package com.bbtutorials.users.service;

import com.bbtutorials.users.entity.Post;
import com.bbtutorials.users.repository.PostRepository;
import com.bbtutorials.users.utils.DateUtils;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class PostService {

  private final PostRepository postRepository;

  public Post createPost(Post post) {
    post.setCreatedAt(DateUtils.getNowLocalDateTime());

    Post createdPost = postRepository.save(post);
    log.info("Post was created. Id of post: " + createdPost.getId());
    return createdPost;
  }

  public Post updatePost(Post post, Long postId) {
    Post postToUpdate = postRepository.findPostById(postId)
        .orElseThrow(() -> {
          log.error("Post not found. Id of post: " + postId);
          throw new EntityNotFoundException("Post not found!");
        });

    postToUpdate.setTitle(
        post.getTitle() == null
            ? postToUpdate.getTitle()
            : post.getTitle());
    postToUpdate.setContent(
        post.getContent() == null
            ? postToUpdate.getContent()
            : post.getContent());

    postToUpdate.setUpdatedAt(DateUtils.getNowLocalDateTime());

    log.info("Post was updated. Id of post: " + postId);
    return postRepository.save(postToUpdate);
  }

  public Post findPostById(Long postId) {
    return postRepository.findPostById(postId)
        .orElseThrow(() -> {
          log.error("Post not found. Id of post: " + postId);
          throw new EntityNotFoundException("Post not found!");
        });
  }

  public List<Post> findAllPosts() {
    return postRepository.findAll();
  }

  public void deletePostById(Long postId) {
    Optional<Post> postToDeleteOptional = postRepository.findPostById(postId);

    if (postToDeleteOptional.isPresent()) {
      Post postToDelete = postToDeleteOptional.get();

      log.info("Post deleted. If of post: " + postId);
      postRepository.deleteById(postToDelete.getId());
    } else {
      log.error("Post not found. Id of post: " + postId);
      throw new EntityNotFoundException("Post not found!");
    }
  }
}
