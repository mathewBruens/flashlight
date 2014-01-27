package com.spotlightppm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mathew
 */


@WebService
public class Server implements ContractStubs {
    
//    public ScreenshotSettings getScreenshotSettings(){
//        return new ScreenshotSettings("HIGH");
//    }
    
    public boolean logout(String username, String password){
        return false;
        
    }
    
    @Override
    public UserSettings getUserSettings(String username, String password){
         return new UserSettings(true, 5000, 10000, "HIGH", true, 5000, 10000, "LOW",true, 5000, 10000);
    }
    
    @Override
    public void pushWebcamImage(String username, String password, byte[] image){
//        System.out.println(image);
        System.out.println("Webcam Image Recieved");
    }
    
    @Override
    public void pushScreenshotImage(String username, String password, byte[] image){
        System.out.println("Screenshot Image Recieved");
    }
    
    @Override
    public void pushUseageStats(String username, String password, 
	int numOfMousePress,
	int numOfKeyPress,
	Timestamp start,
	Timestamp end,
	long longestKeyPressInterval,
	long longestMousePressInterval,
	Timestamp lastKeyPress,
	Timestamp lastMousePress){ //interesting to create a graphic of mouse and keyPresses

        System.out.println("UseageStats Recieved");
    }

    @Override
    public boolean login(String username, String password) {
       return true; 
       }
        

}
