package com.backFalahApp.BackFalahApp.repository;

import com.backFalahApp.BackFalahApp.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Integer> {

    @Query(value="select * from falah.comments c where c.id_posts =?1",nativeQuery=true)
    List<Comments> findByPosts (final int postId);
}
