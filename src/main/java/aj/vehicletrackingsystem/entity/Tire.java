package aj.vehicletrackingsystem.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Tire {
    private int frontLeft;
    private int frontRight;
    private int rearLeft;
    private int rearRight;
}
