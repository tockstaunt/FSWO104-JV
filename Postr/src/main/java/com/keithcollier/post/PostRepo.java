package com.keithcollier.post;

import java.util.List;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Long> {
	List<Post> findByPosterName(String posterName);

	
}