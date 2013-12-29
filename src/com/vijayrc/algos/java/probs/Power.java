package com.vijayrc.algos.java.probs;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class Power {
    private Double value;
    public Power(Double value) {this.value = value;}
    public Double to(Integer power) {return realPower(value, power);}

    private Double realPower(Double value, Integer power) {
        if(power == 1) return value;
        if(power <= 0) return 1d;
        Double x = realPower(value, power / 2);
        if (power % 2 == 0) return x * x;
        else return value * x * x;
    }

    public static class Zest {
        @Test
        public void shouldWork() {
            assertEquals(8d, new Power(2d).to(3));
            assertEquals(256d, new Power(16d).to(2));
            assertEquals(1d, new Power(2d).to(0));
            assertEquals(2d, new Power(2d).to(1));
            assertEquals(81d, new Power(3d).to(4));
            assertEquals(169d, new Power(13d).to(2));
            assertEquals(625d, new Power(5d).to(4));
        }
    }

}
