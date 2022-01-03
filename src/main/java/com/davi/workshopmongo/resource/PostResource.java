package com.davi.workshopmongo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.davi.workshopmongo.domain.Post;
import com.davi.workshopmongo.resource.util.URL;
import com.davi.workshopmongo.service.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService ps;
	
	@GetMapping
	public ResponseEntity<List<Post>> findAll(){
		return ResponseEntity.ok().body(ps.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
		return ResponseEntity.ok().body(ps.findById(id));
	}
	
	@GetMapping(value = "/title")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){
		text = URL.decodeParam(text);
		List<Post> posts = ps.findByTitleContaining(text);
		return ResponseEntity.ok().body(posts);
	}
}
