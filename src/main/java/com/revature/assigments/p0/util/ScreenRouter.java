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
            System.out.println("i =" +i);
            if(screens[i] != null){
                Screen screen = screens.get(i);
                if (screen.getRoute().equals(route)){ // Obj1 > String from getRoute --- Obj2 > String from route and getting a boolean this methods belongs to Object Class
                    screen.render();
                }
            }

        }
    }

}
