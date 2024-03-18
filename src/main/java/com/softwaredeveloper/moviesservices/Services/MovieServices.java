package com.softwaredeveloper.moviesservices.Services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softwaredeveloper.moviesservices.Exception.InvalidDataException;
import com.softwaredeveloper.moviesservices.Exception.NotFoundException;
import com.softwaredeveloper.moviesservices.Repository.MovieRepository;
import com.softwaredeveloper.moviesservices.model.Movie;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MovieServices {
	
	
	@Autowired
	private MovieRepository mRepository;

	//CRUD operation - create , read , update ,delete
	
	public Movie create(Movie movie)
	{
		if(movie == null)
		{
			throw new InvalidDataException("Invalid Movie : null");
		}
		
		return mRepository.save(movie);
	}
	
	
	public Movie read(Long id) 
	{
		return mRepository.findById(id)
				.orElseThrow(()->new NotFoundException("Movie not found with id : " + id));
	}
	
	public void update(Long id, Movie update)
	{
		if(id == null || update == null)
		{
			throw new InvalidDataException("Invalid Movie : null");
		}
		if(mRepository.existsById(id))
		{
			Movie  movie  = mRepository.getReferenceById(id); 
			
			movie.setName(update.getName());
			movie.setDirector(update.getDirector());
			movie.setActors(update.getActors());
			mRepository.save(movie);
			
		}
		else
		{
		 throw	new NotFoundException("Movie not found with id : " + id);
		}
		
		
	}
	
	
	public void delete(long id)
	{
		if(mRepository.existsById(id))
		{
			mRepository.deleteById(id);
		}
		else
		{
			new NotFoundException("Movie not found with id : " + id);
			
		}
		

	}
}
