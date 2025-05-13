package MovieBookingSystem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Setter
@Getter
public class Screen {
    private final int id;
    private final String name;
    private final Theatre theater;
    private List<Seat> seats;

    public Screen(int id, String name, Theatre theater) {
        this.id = id;
        this.name = name;
        this.theater = theater;
        this.seats = new ArrayList<>();
    }

    public void addSeat(final Seat seat) {
        this.seats.add(seat);
    }
}
