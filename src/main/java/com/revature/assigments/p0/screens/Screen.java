package com.revature.assigments.p0.screens;

/**
 * Abstract class to describe the behaviour of screen
 */
public abstract class Screen {

    protected String name;
    protected String route;

    public Screen(String name, String route) {
        this.name = name;
        this.route = route;
    }

    public String getName() {
        return name;
    }

    public String getRoute() {
        return route;
    }

    public abstract void render();
    
}