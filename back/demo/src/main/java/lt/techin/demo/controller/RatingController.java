package lt.techin.demo.controller;

import lt.techin.demo.dto.rating.RatingMapper;
import lt.techin.demo.dto.rating.RatingResponseDTO;
import lt.techin.demo.service.RatingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping("/ratings")
    public ResponseEntity<List<RatingResponseDTO>> getAllRating() {
        return ResponseEntity.ok(
                ratingService.findAllRatings().stream()
                        .map(RatingMapper::toRatingResponseDTO)
                        .toList()
        );
    }
}
