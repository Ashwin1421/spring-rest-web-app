package aj.vehicletrackingsystem.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Wind {
    private float speed;
    private int degree;

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }
}
