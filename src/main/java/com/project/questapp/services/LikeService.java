package com.project.questapp.services;

import com.project.questapp.entities.Like;
import com.project.questapp.entities.Post;
import com.project.questapp.entities.User;
import com.project.questapp.repos.ILikeRepository;
import com.project.questapp.requests.LikeCreateRequest;
import com.project.questapp.responses.LikeResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LikeService {

    private ILikeRepository iLikeRepository;
    private UserService userService;
    private PostService postService;

    public LikeService(ILikeRepository iLikeRepository, UserService userService, PostService postService) {
        this.iLikeRepository = iLikeRepository;
        this.userService = userService;
        this.postService = postService;
    }




    public List<LikeResponse> getAllLikesWithParam(Optional<Long> userId, Optional<Long> postId) {

        List<Like> list;

        if(userId.isPresent() && postId.isPresent()){
            list = iLikeRepository.findByUserIdAndPostId(userId.get(), postId.get());
        }else if(userId.isPresent()){
            list = iLikeRepository.findByUserId(userId.get());
        }else if(postId.isPresent()){
            list = iLikeRepository.findByPostId(postId.get());
        }else
            list = iLikeRepository.findAll();
        return list.stream().map(LikeResponse::new).collect(Collectors.toList());
    }

    public Like createOneLike(LikeCreateRequest request) {
        User user = userService.getOneUserById(request.getUserId());
        Post post = postService.getOnePostById(request.getPostId());
        if(user != null && post != null){
            Like likeToSave = new Like();
            likeToSave.setId(request.getId());
            likeToSave.setPost(post);
            likeToSave.setUser(user);
            return iLikeRepository.save(likeToSave);
        }else
            return null;
    }

    public Like getOneLike(Long likeId) {
        return iLikeRepository.findById(likeId).orElse(null);
    }


    public void deleteOneLikeById(Long likeId) {
        iLikeRepository.deleteById(likeId);
    }
}
