package MovieBookingSystem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Seat {
    private final int seatId;
    private final int row;
    private final SeatCategory seatCategory;
}
