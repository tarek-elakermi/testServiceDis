package com.example.movieratingDataservice.controller;


import com.example.movieratingDataservice.model.Rating;
import com.example.movieratingDataservice.model.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings-data")
public class RatingResource {



    @RequestMapping("/movies/{movieId}")
    public Rating getMovieRating(@PathVariable("movieId") long movieId)
    {
        return new Rating(movieId, 4);
    }

    @RequestMapping("/user/{userId}")
    public UserRating getUserRatings(@PathVariable("userId") String userId) {
        UserRating userRating = new UserRating();
        userRating.initData(userId);
        return userRating;
    }


}

// so for the bulkhead pattern we configure the thread pool
//like this:
/*
HystrixCommand(
            fallbackMethod="getFallBackCatalogItem",
            threadPoolKey="movieInfoPool",
            threadPoolProperties={
                    @HystrixProperty(name ="coreSize", valur="20"),
                    @HystrixProperty(name ="maxQueueSize", valur="10")
                    }
)
*/
