package MovieBookingSystem;

import java.util.List;

public interface ISeatLockProvider {
    void lockSeats(Show show, List<Seat> seats, User user) throws Exception;
    void unlockSeats(Show show, List<Seat> seats, User user);
    boolean validateLock(Show show,Seat seat,User user);
    List<Seat> getLockedSeats(Show show);
}
