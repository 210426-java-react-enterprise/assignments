package code;

import org.junit.Assert;
import org.junit.Test;

public class test_Driver {
    @Test
    public void testSolution1() {
        // Arrange
        int[] array1 = {3, 1, 4, 1};
        int solution1 = 4311;
        int attempt1;
        // Act
        attempt1 = Driver.solution(array1);

        // Assert
        Assert.assertEquals(solution1, attempt1);
    }

    @Test
    public void testSolution2() {
        // Arrange
        int[] array2 = {3, 1, 4, 1, 5, 9};
        int solution2 = 94311;
        int attempt2;

        // Act
        attempt2 = Driver.solution(array2);

        // Assert
        Assert.assertEquals(solution2, attempt2);
    }

    @Test
    public void testSolution3() {
        // Arrange
        int[] array3 = {4, 4, 1, 1, 1, 3};;
        int solution3 = 4431;
        int attempt3;

        // Act
        attempt3 = Driver.solution(array3);

        // Assert
        Assert.assertEquals(solution3, attempt3);
    }
}
