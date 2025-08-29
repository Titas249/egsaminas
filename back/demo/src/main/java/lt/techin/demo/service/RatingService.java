package lt.techin.demo.service;

import lt.techin.demo.model.Rating;
import lt.techin.demo.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public Collection<Rating> findAllRatings() {
        return ratingRepository.findAll();
    }

    public Optional<Rating> findRatingById(long id) {
        return ratingRepository.findById(id);
    }
}
