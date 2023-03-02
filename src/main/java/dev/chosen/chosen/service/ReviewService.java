package dev.chosen.chosen.service;

import dev.chosen.chosen.model.Movie;
import dev.chosen.chosen.model.Review;
import dev.chosen.chosen.repo.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    public Review createReview(String reviewBody , String imdbId){

        //This code is using Spring Data to insert a new Review object into a database through a repository interface called reviewRepository.
        //
        //The code first creates a new Review object with the reviewBody as the constructor parameter. Then, it calls the insert method on the reviewRepository instance, passing in the new Review object as a parameter.
        //
        //The insert method is likely implemented by Spring Data to persist the Review object into the database and return the newly created object.
        //
        //The returned Review object is then assigned to a variable named review of type Review declared in the code, allowing further processing or manipulation of the object if needed. //
        Review review = reviewRepository.insert(new Review(reviewBody));

        //// This mongo template is used to update the movie class where the imdbId is equals and update the reviewId with review
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewsIds").value(review))
                .first();

        return review;
    }
}
