package com.ashwin.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Wind {
    private int speed;
    private int degree;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }
}
