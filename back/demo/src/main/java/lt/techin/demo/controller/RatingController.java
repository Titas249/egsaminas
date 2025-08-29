package lt.techin.demo.controller;

import lt.techin.demo.dto.rating.RatingMapper;
import lt.techin.demo.dto.rating.RatingResponseDTO;
import lt.techin.demo.model.Rating;
import lt.techin.demo.service.RatingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/ratings/{id}")
    public ResponseEntity<RatingResponseDTO> getRatingById(@PathVariable long id) {
        Optional<Rating> maybeRating = ratingService.findRatingById(id);

        if (maybeRating.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        RatingResponseDTO response = RatingMapper.toRatingResponseDTO(maybeRating.get());
        return ResponseEntity.ok(response);
    }
}
