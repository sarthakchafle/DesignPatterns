package MovieBookingSystem;

public class TheatreController {
    private final TheatreService theatreService;
    // Constructor to inject TheatreService
    public TheatreController(final TheatreService theatreService) {
        this.theatreService = theatreService;
    }
    public int createTheatre(final String theatreName) {
        return theatreService.createTheatre(theatreName).getId();
    }
    public int createScreenInTheatre(final String screenName, final int theatreId) throws Exception {
        final Theatre theatre = theatreService.getTheatre(theatreId);
        return theatreService.createScreenInTheatre(screenName, theatre).getId();
    }

    public int createSeatInScreen(final Integer rowNo, final SeatCategory seatCategory, final int screenId) throws Exception {
        final Screen screen = theatreService.getScreen(screenId);
        return theatreService.createSeatInScreen(rowNo, seatCategory, screen).getSeatId();
    }
}
