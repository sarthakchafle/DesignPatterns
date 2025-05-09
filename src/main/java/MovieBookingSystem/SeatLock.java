package MovieBookingSystem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class SeatLock {
    private Seat seat; // The specific seat that is locked.
    private Show show; // The show for which the seat is locked.
    private Integer timeoutInSeconds; // The duration for which the lock is valid, in seconds.
    private Date lockTime; // The timestamp when the lock was acquired.
    private User lockedBy; // Identifier of the user or process that holds the lock.

    public boolean isLockExpired(){
        final Instant lockInstant = lockTime.toInstant().plusSeconds(timeoutInSeconds);
        final Instant currentInstant = new Date().toInstant();
        return lockInstant.isBefore(currentInstant);
    }
}
