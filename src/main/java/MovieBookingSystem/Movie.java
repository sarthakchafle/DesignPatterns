package MovieBookingSystem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Movie {
    private final int movieId;
    private final String movieName;
    private final Integer movieDurationInMinutes;
}
