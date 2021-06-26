package com.vm.moviecatalog.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vm.moviecatalog.model.CatalogItem;
import com.vm.moviecatalog.model.Rating;


@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {


	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		List<Rating> ratings = Arrays.asList(
				
				new Rating("movieOne",1),
				new Rating("movieTwo",2),
				new Rating("movieThree",3)
				);

		
		return ratings.stream()                                                  //putting the list of items [emptying the bag on a] conveyor belt
				.map(rating -> new CatalogItem(rating.getMovieId(), "description of "+ rating.getMovieId(), rating.getRating()))   //converting each rating item moving on the conveyor belt TO  catalogitem
				.collect(Collectors.toList());
	}

}