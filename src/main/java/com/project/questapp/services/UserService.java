package com.project.questapp.services;

import com.project.questapp.entities.Comment;
import com.project.questapp.entities.Like;
import com.project.questapp.entities.User;
import com.project.questapp.repos.ICommentRepository;
import com.project.questapp.repos.ILikeRepository;
import com.project.questapp.repos.IPostRepository;
import com.project.questapp.repos.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    IUserRepository iUserRepository;
    ILikeRepository iLikeRepository;
    ICommentRepository iCommentRepository;
    IPostRepository iPostRepository;

    public UserService(IUserRepository iUserRepository, ILikeRepository iLikeRepository, ICommentRepository iCommentRepository, IPostRepository iPostRepository) {
        this.iUserRepository = iUserRepository;
        this.iLikeRepository = iLikeRepository;
        this.iCommentRepository = iCommentRepository;
        this.iPostRepository = iPostRepository;
    }

    public List<User> getAllUsers() {
        return iUserRepository.findAll();
    }

    public User saveOneUser(User newUser) {
        return iUserRepository.save(newUser);
    }

    public User getOneUserById(Long userId) {
        return iUserRepository.findById(userId).orElse(null);
    }

    public User updateOneUser(Long userId, User newUser) {
        Optional<User> user = iUserRepository.findById(userId);
        if(user.isPresent()){
            User foundUser = user.get();
            foundUser.setUserName(newUser.getUserName());
            foundUser.setPassword(newUser.getPassword());
            foundUser.setAvatar(newUser.getAvatar());
            iUserRepository.save(foundUser);
            return foundUser;
        }else
            return null;
    }

    public void deleteById(Long userId) {
        iUserRepository.deleteById(userId);
    }

    public User getOneUserByUserName(String userName) {
        return iUserRepository.findByUserName(userName);
    }

    public List<Object> getUserActivity(Long userId) {
        List<Long> postIds = iPostRepository.findTopByUserId(userId);
        if(postIds.isEmpty())
            return null;
        List<Object> comments = iCommentRepository.findUserCommentsByPostId(postIds);
        List<Object> likes = iLikeRepository.findUserLikesByPostId(postIds);
        List<Object> result = new ArrayList<>();
        result.addAll(comments);
        result.addAll(likes);
        return result;
    }
}
