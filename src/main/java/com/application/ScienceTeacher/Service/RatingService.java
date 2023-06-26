package com.application.ScienceTeacher.Service;
import com.application.ScienceTeacher.Entity.Rating;
import com.application.ScienceTeacher.Exception.ResourceNotFoundException;
import com.application.ScienceTeacher.Repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RatingService {

    @Autowired
    public RatingRepository ratingRepository;
    public Rating addRating(Rating rating){
        return this.ratingRepository.save(rating);
    }
    public List<Rating> getAllRating(){
        return this.ratingRepository.findAll();
    }

    public Rating getById(Integer rating_id) {
        return this.ratingRepository.findById(rating_id).orElseThrow(() ->
                new ResourceNotFoundException("That" + rating_id + "NotFound"));
    }

    public void deleteRatingById(Integer rating_id){
        this.ratingRepository.deleteById(rating_id);
    }
    public Rating updateRating(Rating rating){
        Rating rating1 = this.ratingRepository.findById(rating.getRating_id()).orElseThrow(null);
        rating1.setRating_no(rating.getRating_no());
        rating1.setStatus(rating.getStatus());
        return this.ratingRepository.save(rating1);
    }

}
