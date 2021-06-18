package com.solardoomsday;

import java.util.ArrayList;
import java.util.List;

public class SolarDoomsday {

    public List<Integer> solution(int area) {

        List<Integer> squares = new ArrayList<>();

        while (area > 0) {
            int highestRoot = (int) Math.floor(Math.sqrt(area));
            squares.add(highestRoot * highestRoot);
            area = area - (highestRoot * highestRoot);
        }

        return squares;
    }
}
