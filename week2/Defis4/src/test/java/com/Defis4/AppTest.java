package com.Defis4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void changeMonney() {
        assertEquals(4.60, App.changeInEuros("5"));
    }
}