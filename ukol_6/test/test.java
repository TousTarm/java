import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrojuhelnikOptionTest {

    // Option 1: Right-angled (a,b)
    @Test
    void testOption1_PravouhlyAB() {
        // Valid case
        Trojuhelnik valid = Trojuhelnik.getPravouhlyAB(3, 4);
        assertNotNull(valid, "Valid 3-4-5 triangle should be created");
        assertEquals(5, valid.getStranaC(), 0.001, "Hypotenuse should be 5");

        // Invalid case
        assertNull(Trojuhelnik.getPravouhlyAB(0, 4), "Zero side should be invalid");
    }

    // Option 2: Right-angled (a,c)
    @Test
    void testOption2_PravouhlyAC() {
        // Valid case
        Trojuhelnik valid = Trojuhelnik.getPravouhlyAC(3, 5);
        assertNotNull(valid, "Valid 3-4-5 triangle should be created");
        assertEquals(4, valid.getStranaB(), 0.001, "Missing side should be 4");

        // Invalid case
        assertNull(Trojuhelnik.getPravouhlyAC(5, 3), "Side longer than hypotenuse should be invalid");
    }


    // Option 3: Equilateral
    @Test
    void testOption3_Rovnostranny() {
        // Valid case
        Trojuhelnik valid = Trojuhelnik.getRovnostranny(5);
        assertNotNull(valid, "Valid equilateral triangle should be created");
        assertEquals(5, valid.getStranaA(), 0.001, "All sides should be equal");
        assertEquals(5, valid.getStranaB(), 0.001, "All sides should be equal");
        assertEquals(5, valid.getStranaC(), 0.001, "All sides should be equal");

        // Invalid case
        assertNull(Trojuhelnik.getRovnostranny(0), "Zero side should be invalid");
    }

    // Option 4: General (a,b,c)
    @Test
    void testOption4_ObecnyABC() {
        // Valid case
        Trojuhelnik valid = Trojuhelnik.getObecnyABC(5, 6, 7);
        assertNotNull(valid, "Valid general triangle should be created");
        assertEquals(5, valid.getStranaA(), 0.001);
        assertEquals(6, valid.getStranaB(), 0.001);
        assertEquals(7, valid.getStranaC(), 0.001);

        // Invalid case (triangle inequality violation)
        assertNull(Trojuhelnik.getObecnyABC(1, 2, 5), "Invalid sides should be rejected");
    }

    // Option 5: General (a,b,α)
    @Test
    void testOption5_ObecnyABAlfa() {
        // Valid case
        Trojuhelnik valid = Trojuhelnik.getObecnyABAlfa(5, 6, 60);
        assertNotNull(valid, "Valid triangle should be created with sides and angle");
        assertEquals(5.567, valid.getStranaC(), 0.001, "Third side should match law of cosines");

        // Invalid case (angle too large)
        assertNull(Trojuhelnik.getObecnyABAlfa(5, 6, 180), "180° angle should be invalid");
    }

    // Option 6: General (α,β,a)
    @Test
    void testOption6_ObecnyAlfaBetaA() {
        // Valid case
        Trojuhelnik valid = Trojuhelnik.getObecnyAlfaBetaA(60, 60, 10);
        assertNotNull(valid, "Valid triangle should be created with angles and side");
        assertEquals(60, valid.getAlfa(), 0.001, "Angle α should be preserved");
        assertEquals(60, valid.getBeta(), 0.001, "Angle β should be preserved");

        // Invalid case (angles sum to 180°)
        assertNull(Trojuhelnik.getObecnyAlfaBetaA(90, 90, 10), "Angles summing to 180° should be invalid");
    }
}