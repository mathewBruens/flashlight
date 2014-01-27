/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spotlightppm;

/**
 *
 * @author Mathew
 */
public class ServerPull {

    public ServerPull() {
       System.out.print(getUserSettings("Mathew", "Password").getScreenshotMaxInterval());
    }
    
    public static void main(String[] args) {
        new ServerPull();
    }
    
    public UserSettings getUserSettings(){
        return getUserSettings("Mathew", "Password");
    }

    

    private static UserSettings getUserSettings(java.lang.String arg0, java.lang.String arg1) {
        com.spotlightppm.ServerService service = new com.spotlightppm.ServerService();
        com.spotlightppm.Server port = service.getServerPort();
        return port.getUserSettings(arg0, arg1);
    }
    
}
