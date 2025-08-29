package lt.techin.demo.dto.rating;

import lt.techin.demo.model.Rating;

public class RatingMapper {

    public static RatingResponseDTO toRatingResponseDTO(Rating rating) {
        return new RatingResponseDTO(rating.getId(), rating.getRate());
    }

    public static Rating toRatingRequestDTO(RatingRequestDTO ratingRequestDTO) {
        Rating rating = new Rating();
        rating.setRate(ratingRequestDTO.rate());

        return rating;
    }

    public static UpdateRatingResponseDTO toUpdateRatingResponseDTO(Rating rating) {
        return new UpdateRatingResponseDTO(
                rating.getRate()
        );

    }

}
