package com.revature.assigments.p0;

import com.revature.assigments.p0.util.AppState;

public class Driver {

    private static AppState app = new AppState();

    public static void main(String[] args){
        while(app.isAppRunning()){
            app.getRouter().navigate("/landing");
        }


    }

}
