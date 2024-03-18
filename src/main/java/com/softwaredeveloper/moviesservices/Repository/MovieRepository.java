package com.softwaredeveloper.moviesservices.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softwaredeveloper.moviesservices.model.Movie;

@Repository
public interface MovieRepository  extends JpaRepository<Movie, Long>{

}
