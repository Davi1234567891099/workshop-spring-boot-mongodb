package com.davi.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.davi.workshopmongo.domain.Post;
import com.davi.workshopmongo.domain.User;
import com.davi.workshopmongo.repository.PostRepository;
import com.davi.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository ur;
	
	@Autowired
	private PostRepository pr;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		ur.deleteAll();
		pr.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Viagem", "Vou viajar para Sao Paulo, abracos.", maria);
		Post post2 = new Post(null, sdf.parse("23/06/2015"), "Bom dia", "Bom dia.", maria);

		ur.saveAll(Arrays.asList(maria,alex,bob));
		pr.saveAll(Arrays.asList(post1, post2));
	}

}
