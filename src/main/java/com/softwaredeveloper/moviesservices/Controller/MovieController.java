package com.softwaredeveloper.moviesservices.Controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.softwaredeveloper.moviesservices.Services.MovieServices;
import com.softwaredeveloper.moviesservices.model.Movie;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/movies")
@Slf4j
public class MovieController {

	
	
	@Autowired
	private MovieServices mServices;
	
	
	@PostMapping
	public ResponseEntity<Movie> createMovie(@RequestBody Movie m)
	{
		Movie createMovie =mServices.create(m);
		log.info("Created Movie With Id : {} ",createMovie.getId());
		return ResponseEntity.ok(createMovie);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Movie> getMovie(@PathVariable Long id)
	{
			Movie getMovie = mServices.read(id);
			
			log.info("Returned with id: {} ",id);
			
			return ResponseEntity.ok(getMovie);
	}
	
	@PutMapping("/{id}")
	public void updateMovie(@PathVariable Long id , @RequestBody Movie m)
	{
		 
		mServices.update(id, m);
		log.info("Update Movie With id : {}",id);
		
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteMovie(@PathVariable Long id)
	{
		mServices.delete(id);
		log.info("Delete Movie With id : {} ",id);
	}
}
