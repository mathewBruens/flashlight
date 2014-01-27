/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spotlightppm;

import java.sql.Timestamp;

/**
 *
 * @author Mathew
 */
public interface ContractStubs {

    //    public ScreenshotSettings getScreenshotSettings(){
    //        return new ScreenshotSettings("HIGH");
    //    }
    UserSettings getUserSettings(String username, String password);

    void pushScreenshotImage(String username, String password, byte[] image);

    void pushUseageStats(String username, String password,
            int numOfMousePress,
            int numOfKeyPress,
            Timestamp start,
            Timestamp end,
            long longestKeyPressInterval,
            long longestMousePressInterval,
            Timestamp lastKeyPress,
            Timestamp lastMousePress);

    void pushWebcamImage(String username, String password, byte[] image);
    
    boolean logout(String username, String password);
    
    boolean login(String username, String password);
}
