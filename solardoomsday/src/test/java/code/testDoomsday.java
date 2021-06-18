package code;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testDoomsday {
    /*
    BASE TEST CASES:
    Input: 12
    Output: [9,1,1,1]

    Input: 15324
    Output: [15129,169,25,1]
     */
    Doomsday sut;

    @Before
    public void setUp() {
        sut = new Doomsday();
    }

    @After
    public void tearDown() {
        sut = null;
    }

    @Test
    public void testCalculateTotalAreaWithValidInputs() {

    }
}
