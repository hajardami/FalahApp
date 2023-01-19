package com.backFalahApp.BackFalahApp.repository;

import com.backFalahApp.BackFalahApp.model.PostsLikes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsLikesRepository extends JpaRepository<PostsLikes, Integer> {

	@Query(value ="select * from falah.postslikes l where l.id_user =?1",nativeQuery=true)
	List<PostsLikes> findByIdUser (final int id_user);

	
	@Query(value = "select * from falah.postslikes l where l.id_posts = ?1", nativeQuery=true)
	List<PostsLikes> findByIdPosts (final int id_posts);
	
	@Query(value = "select * from falah.postslikes l where l.id_user = ?1 and l.id_posts = ?2", nativeQuery = true)
	PostsLikes findByIdUserAndIdPosts(final int id_user, final int id_posts);
	
}