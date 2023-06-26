package com.application.ScienceTeacher.Controller;

import com.application.ScienceTeacher.Entity.Rating;
import com.application.ScienceTeacher.Repository.RatingRepository;
import com.application.ScienceTeacher.Repository.TeacherRepository;
import com.application.ScienceTeacher.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/Rating")
public class RatingController {

    @Autowired
    public RatingService ratingService;

    @Autowired
    public TeacherRepository teacherRepository;

    @Autowired
    public RatingRepository ratingRepository;

    @PostMapping("/add")
    public Rating addRating(@RequestBody Rating rating) {
        return this.ratingService.addRating(rating);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Rating>> getAllRating() {
        List<Rating> ratings = this.ratingService.getAllRating();
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }

    @GetMapping("/getById/{rating_id}")
    public ResponseEntity<Rating> getRatingById(@PathVariable("rating_id") Integer rating_id) {
        Rating rating = this.ratingService.getById(rating_id);
        return new ResponseEntity<>(rating, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/deleteRating/{rating_id}")
    public void deleteRatingById(@PathVariable Integer rating_id) {
        this.ratingService.deleteRatingById(rating_id);
    }

    @PutMapping("/updateRating/{rating_id}")
    public Rating updateRating(@RequestBody Rating rating) {
        return this.ratingService.updateRating(rating);
    }
}
