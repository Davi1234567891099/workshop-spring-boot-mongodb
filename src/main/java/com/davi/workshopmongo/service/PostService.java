package com.davi.workshopmongo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davi.workshopmongo.domain.Post;
import com.davi.workshopmongo.repository.PostRepository;
import com.davi.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository pr;
	
	public List<Post> findAll(){
		return pr.findAll();
	}
	
	public Post findById(String id) { 
		try {
			return pr.findById(id).get();
		}
		catch(RuntimeException e) {
			throw new ObjectNotFoundException("Object not exists.");
		}
	}
	
	public List<Post> findByTitleContaining(String text) {
		return pr.searchByTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return pr.fullSearch(text, minDate, maxDate);
	}
}
