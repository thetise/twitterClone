package com.project.questapp.repos;

import com.project.questapp.entities.Comment;
import com.project.questapp.entities.Like;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

// LİKE SİLME İŞLEMİNDE "http://localhost:3000/likes" dan "http://localhost:3000/likes/likeId" ye ulaşmaya çalışıyorum
// burada transactional'ı ondan ekledim, ulaşıp silmem lazım o yüzden ekledim çalışmazsa trans'ı comment'e alcam
//@Transactional ne yazık ki bu da işe yaramadı.


public interface ILikeRepository extends JpaRepository<Like, Long> {
    List<Like> findByUserIdAndPostId(Long userId, Long postId);

    List<Like> findByUserId(Long userId);

    List<Like> findByPostId(Long postId);

    @Query(value = "select 'liked', l.post_id, u.avatar, u.user_name from "
            + "p_like l left join users u on u.id = l.user_id "
            + "where l.post_id in :postIds LIMIT 5", nativeQuery = true)
    List<Object> findUserLikesByPostId(@Param("postIds") List<Long> postIds);



}
