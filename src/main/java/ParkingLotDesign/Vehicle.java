package ParkingLotDesign;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public abstract class Vehicle {
    private String licensePlateNumber;
    protected String vehicleType;
    private ParkingFeeStrategy parkingFeeStrategy;

}
