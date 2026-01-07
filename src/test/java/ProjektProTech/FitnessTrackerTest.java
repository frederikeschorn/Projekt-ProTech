package ProjektProTech;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FitnessTrackerTest {

    @Test
    void kalorienSumme() {
        FitnessTracker ft = new FitnessTracker();
        double v1 = ft.kalorienSumme();
        assertEquals(1910.0, v1);
    }
}