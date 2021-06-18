import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class SolarDoomsdayTest {

    public static boolean test1() {

        int testNum = 12;
        List<Integer> expected = Arrays.asList(9,1,1,1);

        List<Integer> actual = SolarDoomsday.solution(testNum);

        return actual.equals(expected);
    }

    public static boolean test2() {

        int testNum = 15324;
        List<Integer> expected = Arrays.asList(15129,169,25,1);

        List<Integer> actual = SolarDoomsday.solution(testNum);

        return actual.equals(expected);
    }

    public static boolean test3() {

        int testNum = 123456;
        List<Integer> expected = Arrays.asList(123201,225,25,4,1);

        List<Integer> actual = SolarDoomsday.solution(testNum);

        return actual.equals(expected);
    }

    public static boolean test4() {

        int testNum = 1000000;
        List<Integer> expected = Arrays.asList(1000000);

        List<Integer> actual = SolarDoomsday.solution(testNum);

        return actual.equals(expected);
    }

    public static boolean test5() {

        int testNum = 1;
        List<Integer> expected = Arrays.asList(1);

        List<Integer> actual = SolarDoomsday.solution(testNum);

        return actual.equals(expected);
    }

    public static boolean test6() {

        int testNum = 999999;
        List<Integer> expected = Arrays.asList(998001,1936,49,9,4);

        List<Integer> actual = SolarDoomsday.solution(testNum);

        return actual.equals(expected);
    }

    public static void main(String[] args) {
        System.out.println(test1());
        System.out.println(test2());
        System.out.println(test3());
        System.out.println(test4());
        System.out.println(test5());
        System.out.println(test6());
    }

}
