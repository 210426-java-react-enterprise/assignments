package com.revature.assigments.p0.util;

import com.revature.assigments.p0.screens.Screen;

public class ScreenRouter {
    private ArrayList<Screen> screens = new ArrayList<>();

    public ScreenRouter addScreen(Screen screen){
        screens.add(screen);
        return this;
    }

    public void navigate(String route){
        //int arraySize = screens.size() - 1;
        int arraySize = screens.size();
        //System.out.println("The route value is >>>" + route);
        //System.out.println("Var arraySize >>> "+ arraySize);
        for (int i = 0; i < arraySize ; i++) {
            //System.out.println("i >>> " +i);
            //System.out.println("Array size >>> "+ screens.size());
            Screen screen = screens.get(i);
            System.out.println("the route value is >>> "+ route);
            System.out.println("the value returned by my ArrayList >>> "+screen.getRoute());
            if (screen.getRoute().equals(route)){ // Obj1 > String from getRoute --- Obj2 > String from route and getting a boolean this methods belongs to Object Class
                screen.render();
            }

        }
    }

}
