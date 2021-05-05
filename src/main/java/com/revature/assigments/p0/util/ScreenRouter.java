package com.revature.assigments.p0.util;

import com.revature.assigments.p0.screens.Screen;

public class ScreenRouter {
    private ArrayList<Screen> screens = new ArrayList<>();

    public ScreenRouter addScreen(Screen screen){
        screens.add(screen);
        return this;
    }

    public void navigate(String route){
        for (int i = 0; i < screens.size() ; i++) {
            Screen screen = screens.get(i);

        }
    }

}
