package com.project.questapp.repos;

import com.project.questapp.entities.Post;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Transactional
public interface IPostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUserId(Long userId);

    @Query(value = "SELECT id FROM post WHERE user_id = :userId ORDER BY create_date DESC LIMIT 5", nativeQuery = true)
    List<Long> findTopByUserId(@Param("userId") Long userId);
}
