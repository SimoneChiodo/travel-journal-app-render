package org.travel.java.travel_emotions.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.travel.java.travel_emotions.model.Travel;

public interface TravelRepository extends JpaRepository<Travel, Long> {
  // Additional query methods can be defined here if needed
  
  // Filtered Index
  List<Travel> findDistinctByPlaceContainingIgnoreCaseAndDateGreaterThanEqualAndCostLessThanEqualAndStrengthRatingLessThanEqualAndMonetaryRatingLessThanEqualAndTags_IdIn(
    String place,
    LocalDate date,
    BigDecimal cost,
    Integer strengthRating,
    Integer monetaryRating,
    List<Long> tagIds
  );

  // Filtered Index (without tags selected)
  List<Travel> findByPlaceContainingIgnoreCaseAndDateGreaterThanEqualAndCostLessThanEqualAndStrengthRatingLessThanEqualAndMonetaryRatingLessThanEqual(
    String place,
    LocalDate date,
    BigDecimal cost,
    Integer strengthRating,
    Integer monetaryRating
  );

}
