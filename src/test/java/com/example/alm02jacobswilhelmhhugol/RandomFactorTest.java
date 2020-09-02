package com.example.alm02jacobswilhelmhhugol;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomFactorTest {
    RandomFactor randomFactor = new RandomFactor();

    @Test
    void getIntFromName() {
        assertTrue(randomFactor.getIntFromName("Wilhelm Hattenbach")==21);
    }

    @Test
    void getIntFromNationality() {
        assertTrue(randomFactor.getIntFromNationality("Sweden")==3);

    }

    @Test
    void getIntFromAge() {
        assertTrue(randomFactor.getIntFromAge(32)==41);
    }
}