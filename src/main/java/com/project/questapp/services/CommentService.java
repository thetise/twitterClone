package com.project.questapp.services;

import com.project.questapp.entities.Comment;
import com.project.questapp.entities.Post;
import com.project.questapp.entities.User;
import com.project.questapp.repos.ICommentRepository;
import com.project.questapp.requests.CommentCreateRequest;
import com.project.questapp.requests.CommentUpdateRequest;
import com.project.questapp.responses.CommentResponse;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentService {


    private ICommentRepository iCommentRepository;
    private UserService userService;
    private PostService postService;

    public CommentService(ICommentRepository iCommentRepository, UserService userService, PostService postService) {
        this.iCommentRepository = iCommentRepository;
        this.userService = userService;
        this.postService = postService;
    }


    public List<CommentResponse> getAllCommentsWithParam(Optional<Long> userId, Optional<Long> postId) {
        List<Comment> comments;

        if(userId.isPresent() && postId.isPresent()){
            comments = iCommentRepository.findByUserIdAndPostId(userId.get(), postId.get());
        }else if(userId.isPresent()){
            comments = iCommentRepository.findByUserId(userId.get());
        }else if(postId.isPresent()){
            comments = iCommentRepository.findByPostId(postId.get());
        }else
            comments = iCommentRepository.findAll();
        return comments.stream().map(comment -> new CommentResponse(comment)).collect(Collectors.toList());
    }

    public Comment createOneComment(CommentCreateRequest request) {
        User user = userService.getOneUserById(request.getUserId());
        Post post = postService.getOnePostById(request.getPostId());
        if(user != null && post != null){
            Comment commentToSave = new Comment();
            commentToSave.setId(request.getId());
            commentToSave.setPost(post);
            commentToSave.setUser(user);
            commentToSave.setTexts(request.getTexts());
            commentToSave.setCreateDate(new Date());
            return iCommentRepository.save(commentToSave);
        }else
            return null;
    }


    public Comment getOneCommentById(Long commentId) {
        return iCommentRepository.findById(commentId).orElse(null);
    }


    public Comment updateOneCommentById(Long commentId, CommentUpdateRequest request) {
        Optional<Comment> comment = iCommentRepository.findById(commentId);
        if(comment.isPresent()){
            Comment commentToUpdate = comment.get();
            commentToUpdate.setTexts(request.getTexts());
            return  iCommentRepository.save(commentToUpdate);
        }else
            return null;
    }

    public void deleteOneCommentById(Long commentId) {
        iCommentRepository.deleteById(commentId);
    }
}
