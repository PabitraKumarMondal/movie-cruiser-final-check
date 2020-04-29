package com.cognizant.moviecruiser;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.MovieService;

/**
 * Hello world!
 *
 */
public class App 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
    	LOGGER.info("Start of Main Method");
    	ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    	MovieService service = (MovieService) context.getBean("movieService");
    	List<Movie> movieList = service.getMovieListAdmin();
    	System.out.println(movieList);
    	LOGGER.info("End of Main Method");
    }
}
