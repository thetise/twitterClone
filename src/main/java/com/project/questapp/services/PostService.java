package com.project.questapp.services;

import com.project.questapp.entities.Post;
import com.project.questapp.entities.User;
import com.project.questapp.repos.IPostRepository;
import com.project.questapp.requests.PostCreateRequest;
import com.project.questapp.requests.PostUpdateRequest;
import com.project.questapp.responses.LikeResponse;
import com.project.questapp.responses.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

    private IPostRepository iPostRepository;
    private UserService userService;
    private LikeService likeService;

    public PostService(IPostRepository iPostRepository, UserService userService) {
        this.iPostRepository = iPostRepository;
        this.userService = userService;
    }

    @Autowired
    public void setLikeService(LikeService likeService){
        this.likeService = likeService;
    }

    public List<PostResponse> getAllPosts(Optional<Long> userId) {
        List<Post> list;
        if(userId.isPresent()){
            list =  iPostRepository.findByUserId(userId.get());
        }
        else
            list = iPostRepository.findAll();
        return list.stream().map(p -> {
            List<LikeResponse> likes = likeService.getAllLikesWithParam(Optional.ofNullable(null), Optional.of(p.getId()));
            return new PostResponse(p, likes);}).collect(Collectors.toList());
    }


    public Post createOnePost(PostCreateRequest newPostRequest) {
        User user = userService.getOneUserById(newPostRequest.getUserId());
        if(user == null)
            return null;
        Post toSave = new Post();
        toSave.setId(newPostRequest.getId());
        toSave.setTexts(newPostRequest.getTexts());
        toSave.setTitle(newPostRequest.getTitle());
        toSave.setUser(user);
        toSave.setCreateDate(new Date());
        return iPostRepository.save(toSave);
    }


    public Post getOnePostById(Long postId) {
        return iPostRepository.findById(postId).orElse(null);
    }



    public PostResponse getOnePostByIdWithLikes(Long postId){
        Post post = iPostRepository.findById(postId).orElse(null);
        List<LikeResponse> likes = likeService.getAllLikesWithParam(Optional.ofNullable(null), Optional.of(postId));
        return new PostResponse(post, likes);
    }





    public Post updateOnePostById(Long postId, PostUpdateRequest updatePostRequest) {
        Optional<Post> post = iPostRepository.findById(postId);
        if(post.isPresent()){
            Post toUpdate = post.get();
            toUpdate.setTitle(updatePostRequest.getTitle());
            toUpdate.setTexts(updatePostRequest.getTexts());
            iPostRepository.save(toUpdate);
            return toUpdate;
        }
        return null;
    }


    public void deleteOnePostById(Long postId) {
        iPostRepository.deleteById(postId);
    }

}
