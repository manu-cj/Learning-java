package com.manu.surface;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    void shouldConvertCentimeterToMeters() {
        // Tester la conversion de centimètres à mètres
        double result = App.parseToMeter("250cm");
        assertEquals(2.5, result, "La conversion de 250cm en mètres doit donner 2.5");
    }

    @Test 
    void shouldConvertMilimeterToMeters() {
        double result = App.parseToMeter("2500mm");
        assertEquals(2.5, result, "La conversion de 2500mm en mètres doit donner 2.5");
    }
}
